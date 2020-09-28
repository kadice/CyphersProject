using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.Common;
using System.Diagnostics;
using System.Linq;
using System.Text.Encodings.Web;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using NetCoreMvcApp.Models;
using NetCoreWebApp.Models;
using Org.BouncyCastle.Utilities;

namespace NetCoreMvcApp.Controllers
{
    public class StoryController : Controller
    {
        private readonly DbConnection _connection;

        public StoryController(DbConnection connection)
        {
            this._connection = connection;
        }

        /// <summary>
        /// 故事首頁
        /// </summary>
        [Route("Story")]
        public IActionResult Index()
        {
            return View();
        }

        /// <summary>
        /// 依指定的章節顯示該章節所有故事
        /// </summary>
        [Route("/Story/s/{chapter}")]
        public IActionResult StoryPage([FromRoute] string chapter)
        {
            StoryDAO dao = new StoryDAO(_connection);

            //指定章節的故事列表
            List<StoryModel> storyList = dao.GetStoryByChapter(chapter);

            return View("~/Views/Story/StoryPage.cshtml", storyList);
        }

        /// <summary>
        /// 以"新增模式"開啟編輯故事畫面
        /// </summary>
        [HttpPost]
        [Route("/Story/NewStory")]
        public IActionResult NewStory()
        {
            StoryDAO dao = new StoryDAO(_connection);

            //待編輯的storyModel
            StoryModel storyModel = new StoryModel();

            //EditStory頁面所需資料
            List<StoryModel> storyList = dao.GetStoryList();
            ViewData.Add("StoryList", storyList);
            ViewData["EditMode"] = "insert";

            return View("~/Views/Story/EditStory.cshtml", storyModel);
        }

        /// <summary>
        /// 以"更新模式"開啟編輯故事畫面
        /// </summary>
        [HttpPost]
        [Route("/Story/Edit/{chapter}/{section}")]
        public IActionResult EditStory([FromRoute] string chapter, [FromRoute] int section)
        {
            StoryDAO dao = new StoryDAO(_connection);

            //待編輯的storyModel
            StoryModel storyModel = dao.GetStoryByKey(chapter, section);

            //EditStory頁面所需資料
            List<StoryModel> storyList = dao.GetStoryList();
            ViewData.Add("StoryList", storyList);
            ViewData["EditMode"] = "update";

            return View(storyModel);
        }

        /// <summary>
        /// 刪除故事後，導頁至編輯故事畫面
        /// </summary>
        [HttpPost]
        public IActionResult DeleteStory(StoryModel storyModel)
        {
            StoryDAO dao = new StoryDAO(_connection);
            int i = dao.DeleteStory(storyModel);
            if (i > 0)
            {
                ViewData["alertType"] = "alert alert-success";
                ViewData["MSG"] = "刪除成功";
                //刪除成功時顯示新增模式
                ViewData["EditMode"] = "insert";
            }
            else
            {
                ViewData["alertType"] = "alert alert-danger";
                ViewData["MSG"] = "刪除失敗";
                //刪除失敗時維持更新模式
                ViewData["EditMode"] = "update";
            }

            //EditStory頁面所需資料
            List<StoryModel> storyList = dao.GetStoryList();
            ViewData.Add("StoryList", storyList);

            return View("~/Views/Story/EditStory.cshtml", storyModel);
        }

        /// <summary>
        /// 儲存故事後，導頁至編輯故事畫面
        /// </summary>
        [HttpPost]
        public IActionResult SaveStory(StoryModel storyModel)
        {
            StoryDAO dao = new StoryDAO(_connection);
            string editMode = Request.Form["editMode"];
            int i = 0;
            if (ModelState.IsValid)
            {
                if (editMode == "insert")
                    i = dao.InsertStory(storyModel);
                else
                    i = dao.UpdateStoryByKey(storyModel);
            }
            if (i > 0)
            {
                ViewData["alertType"] = "alert alert-success";
                ViewData["MSG"] = "更新成功";
            }
            else
            {
                ViewData["alertType"] = "alert alert-danger";
                ViewData["MSG"] = "更新失敗";
            }

            //EditStory頁面所需資料
            List<StoryModel> storyList = dao.GetStoryList();
            ViewData.Add("StoryList", storyList);
            if (editMode == "insert" && i <= 0)
                ViewData["EditMode"] = "insert";//新增失敗時保持新增模式
            else
                ViewData["EditMode"] = "update";//新增成功時轉為更新模式

            return View("~/Views/Story/EditStory.cshtml", storyModel);
        }
    }
}