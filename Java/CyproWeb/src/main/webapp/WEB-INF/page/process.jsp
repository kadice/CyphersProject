<%@ page contentType="text/html;charset=UTF-8"%>
<pre style="background-color: #CCCCCC;">
<b>開發筆記：</b>

2018年08月31日	CyphersProject_V2 計畫始動；預計捨棄Wix框架重新規劃網站架構

2017年03月24日	完成裝備爬蟲程式自動翻譯裝備效果的功能

2017年03月23日	開始開發裝備資料的爬蟲程式，完成資料解析

2017年03月22日	新增爬蟲-自動搜尋技能基礎資料並儲存的功能

2017年03月18日	技能呈現頁面完成，但演示影片因WIX平台限制無法展示

2017年03月17日	能力者檔案的技能列表增加特殊效果小圖示；各編輯頁面增加防止ENTER鍵導致送出表單的script；

2017年03月16日	編輯技能頁面：修正傷害係數的欄位，取消基本公式改為6欄自定義公式列；修正頁面上的其他小錯誤；開始開發技能呈現頁面

2017年03月15日	完成編輯技能頁面；調整使用到角色選擇BOX並有編輯/儲存功能的頁面，將會在儲存後跳回最後編輯的角色，並正確標示紅框

2017年03月14日	調整所有使用到角色選擇BOX的頁面，會自動載入勞拉斯的頁面；初步完成編輯技能頁面的畫面，開始撰寫儲存技能的功能

2017年03月13日	調整大型文本資料庫欄位的資料型態；開始開發編輯技能頁面

2017年03月12日	於HTML編輯器增加字數計算的外掛(可設定字數限制)

2017年03月11日	裝備搜尋頁面：增加品質欄顏色標示、增加階數欄

2017年03月10日	整理CSS；完成裝備搜尋頁面設計；將舊版批次編輯裝備頁面上方更換成新版的搜尋功能區塊

2017年03月09日	修正裝備搜尋時無法搜尋到共用裝備的問題；完成裝備搜尋頁面的搜尋功能

2017年03月08日	修正當舊資料是空值時可能導致組裝LOG時當掉的錯誤；

2017年03月07日	變更能力者檔案/能力者調查報告的LOG設計；能力者檔案頁面增加[升級能力加成]區塊；HTML編輯器增加可插入圖片功能；配合內文和新加入的圖片調整背景故事的配置

2017年03月06日	完成初版裝備搜尋頁面；

2017年03月05日	變更角色選擇BOX設計；

2017年03月04日	能力者檔案頁面：增加內嵌BGM、增加配合評價區塊的欄數自動調整區塊寬度的功能

2017年03月03日	完成編輯能力者檔案頁面的版面與儲存功能；變更全站使用的TAB標籤設計

2017年03月02日	開始開發編輯能力者檔案頁面

2017年03月01日	能力者檔案頁面：完成除了BGM區塊與WIKI區塊以外的設計

2017年02月28日	能力者檔案頁面：變更配色、背景與部分區塊配置

2017年02月24日	能力者檔案頁面：完成調查檔案區塊、裝備故事情報區塊；變更資料庫中裝備資料表與角色資料表的設計；批次查詢裝備頁與角色資料頁增加"隱藏捲動軸"的設計

2017年02月23日	能力者檔案頁面：完成技能區塊、粉裝區塊

2017年02月22日	建立能力者檔案頁面的top/content樣板；完成能力者基本資料區塊

2017年02月21日	完善背景故事的呈現頁面和編輯頁面

2017年02月20日	WIX增加背景故事頁面；增加背景故事的顯示和編輯功能(可使用html編輯器)	

2017年02月16日	建立WIX網站http://cyphersproject.wixsite.com/zh-tw

2017年02月14日	裝備資料庫：增加最後編輯日期欄位；批次查詢裝備頁：增加顯示最後編輯日期；改進儲存裝備時的log

2017年02月13日	批次查詢裝備頁：儲存裝備時log記錄時間、IP、變更的裝備編號；增加查看log的功能頁

2017年02月12日	批次查詢裝備頁：修正在wix上alert()和confirm()無法正常運作的問題，改以其他方式顯是提示

2017年02月11日	批次查詢裝備頁：增加裝備品質會隨著選項改變背景色

2017年02月10日	批次查詢裝備頁：增加以"部位"作為搜尋條件的功能；調整搜尋條件區塊的排版

2017年02月09日	批次查詢裝備頁：增加打勾時改變底色的醒目效果；大幅更改查詢裝備的SQL語法，加快搜尋效率；搜尋結果排序變更為[角色>部位>品質]；調整搜尋條件區塊的排版

2017年02月08日	批次查詢裝備頁：增加批次儲存裝備資料的功能；處理裝備的[功能效果]在編輯與儲存時的換行問題

2017年02月07日	批次查詢裝備頁：調整裝備列表的排版；增加列數會隨著裝備品質動態增減的功能

2017年01月底~2月初(沒詳細記錄)	將之前做在本地端玩玩用的角色資料頁面、裝備查詢頁面搬過來；將本地資料庫的DATA轉移至Google Cloud SQL資料庫

2017年01月18日	成功使用myBatis連接上Google Cloud SQL(歡呼暴動)

2017年01月16日	基礎架構完成至能夠使用DAO存取本地資料庫資料，除了連接至雲端資料庫以外的主架構大致完成

2016年12月02日	將資料傳輸架構更改為SpringServlet

2016年12月02日	成功建立以Maven為基礎架構的gae程式，並能夠在google伺服器上運行

2016年11月29日	成功建立google app engine的hello world程式，並能夠在google伺服器上運行(NO MAVEN)

2016年09月初		計畫始動；開始研究MVN架構
</pre>