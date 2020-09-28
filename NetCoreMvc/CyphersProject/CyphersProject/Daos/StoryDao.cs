using MySql.Data;
using MySql.Data.MySqlClient;
using NetCoreMvcApp.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Common;

namespace NetCoreWebApp.Models
{
    public class StoryDAO
    {
        private DbConnection _connection;

        public StoryDAO(DbConnection connection)
        {
            this._connection = connection;
        }

        private DbConnection GetConnection()
        {
            return _connection;
        }

        public List<StoryModel> GetAllStory()
        {
            List<StoryModel> list = new List<StoryModel>();
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "select * from story order by seq";

                    cmd.CommandText = sSQL;
                    using (var reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            list.Add(new StoryModel()
                            {
                                chapter = reader["chapter"].ToString(),
                                section = Convert.ToInt32(reader["section"]),
                                seq = reader["seq"].ToString(),
                                title = reader["title"].ToString(),
                                storyContent_ch = reader["storyContent_ch"].ToString(),
                                storyContent_kr = reader["storyContent_kr"].ToString()
                            });
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return list;
        }

        public StoryModel GetStoryByKey(string chapter, int section)
        {
            StoryModel model = new StoryModel();
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "select * from story where chapter=@CHAPTER and section=@SECTION";
                    cmd.Parameters.AddWithValue("CHAPTER", chapter);
                    cmd.Parameters.AddWithValue("SECTION", section);

                    cmd.CommandText = sSQL;
                    using (var reader = cmd.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            model.chapter = reader["chapter"].ToString();
                            model.section = Convert.ToInt32(reader["section"]);
                            model.seq = reader["seq"].ToString();
                            model.title = reader["title"].ToString();
                            model.storyContent_ch = reader["storyContent_ch"].ToString();
                            model.storyContent_kr = reader["storyContent_kr"].ToString();
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return model;
        }

        public List<StoryModel> GetStoryList()
        {
            List<StoryModel> list = new List<StoryModel>();
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "select chapter, section, title from story order by seq";

                    cmd.CommandText = sSQL;
                    using (var reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            list.Add(new StoryModel()
                            {
                                chapter = reader["chapter"].ToString(),
                                section = Convert.ToInt32(reader["section"]),
                                title = reader["title"].ToString()
                            });
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return list;
        }

        public List<StoryModel> GetStoryByChapter(string chapter)
        {
            List<StoryModel> list = new List<StoryModel>();
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "select * from story where chapter=@CHAPTER order by seq";
                    cmd.Parameters.AddWithValue("CHAPTER", chapter);

                    cmd.CommandText = sSQL;
                    using (var reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            list.Add(new StoryModel()
                            {
                                chapter = reader["chapter"].ToString(),
                                section = Convert.ToInt32(reader["section"]),
                                title = reader["title"].ToString(),
                                storyContent_ch = reader["storyContent_ch"].ToString(),
                                storyContent_kr = reader["storyContent_kr"].ToString()
                            });
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return list;
        }

        internal int InsertStory(StoryModel model)
        {
            int i = 0;
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "insert into story";

                    sSQL += " (chapter, section, seq, title, storyContent_ch, storyContent_kr, lastModified)";
                    sSQL += " VALUES";
                    sSQL += " (@CHAPTER, @SECTION, @SEQ, @TITLE, @STORYCONTENT_CH, @STORYCONTENT_KR, @LASTMODIFIED)";
                    cmd.Parameters.AddWithValue("CHAPTER", model.chapter);
                    cmd.Parameters.AddWithValue("SECTION", model.section);
                    cmd.Parameters.AddWithValue("SEQ", model.seq);
                    cmd.Parameters.AddWithValue("TITLE", model.title);
                    cmd.Parameters.AddWithValue("STORYCONTENT_CH", model.storyContent_ch);
                    cmd.Parameters.AddWithValue("STORYCONTENT_KR", model.storyContent_kr);
                    cmd.Parameters.AddWithValue("LASTMODIFIED", DateTime.Now);

                    cmd.CommandText = sSQL;
                    i = cmd.ExecuteNonQuery();
                }
            }
            catch (Exception ex) {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return i;
        }

        public int UpdateStoryByKey(StoryModel model)
        {
            int i = 0;
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "update story set";

                    sSQL += " seq=@SEQ,";
                    cmd.Parameters.AddWithValue("SEQ", model.seq);

                    sSQL += " title=@TITLE,";
                    cmd.Parameters.AddWithValue("TITLE", model.title);

                    sSQL += " storyContent_ch=@STORYCONTENT_CH,";
                    cmd.Parameters.AddWithValue("STORYCONTENT_CH", model.storyContent_ch);

                    sSQL += " storyContent_kr=@STORYCONTENT_KR,";
                    cmd.Parameters.AddWithValue("STORYCONTENT_KR", model.storyContent_kr);

                    sSQL += " lastModified=@LASTMODIFIED,";
                    cmd.Parameters.AddWithValue("LASTMODIFIED", DateTime.Now);

                    if (sSQL[sSQL.Length - 1] == ',')
                        sSQL = sSQL.Substring(0, sSQL.Length - 1);

                    sSQL += " where chapter=@CHAPTER and section=@SECTION";
                    cmd.Parameters.AddWithValue("CHAPTER", model.chapter);
                    cmd.Parameters.AddWithValue("SECTION", model.section);

                    cmd.CommandText = sSQL;
                    i = cmd.ExecuteNonQuery();
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return i;
        }

        internal int DeleteStory(StoryModel model)
        {
            int i = 0;
            _connection.Open();
            try
            {
                using (MySqlCommand cmd = _connection.CreateCommand() as MySqlCommand)
                {
                    string sSQL = "delete from story where chapter=@CHAPTER and section=@SECTION";

                    cmd.Parameters.AddWithValue("CHAPTER", model.chapter);
                    cmd.Parameters.AddWithValue("SECTION", model.section);

                    cmd.CommandText = sSQL;
                    i = cmd.ExecuteNonQuery();

                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                _connection.Close();
            }
            return i;
        }
    }
}