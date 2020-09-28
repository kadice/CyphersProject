using System;
using System.Collections.Generic;
using System.Data.Common;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using MySql.Data.MySqlClient;
using NetCoreWebApp.Models;

namespace NetCoreMvcApp
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }
        IServiceCollection _services;

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddControllersWithViews();

            // Add framework services.  
            //services.AddMvc();
            //services.Add(new ServiceDescriptor(typeof(StoryDAO), new StoryDAO(Configuration.GetConnectionString("DefaultConnection"))));

            // Add these after CloudSQL testing
            //string projectId = Google.Api.Gax.Platform.Instance().ProjectId;
            //if (!string.IsNullOrEmpty(projectId))
            //{
            //    services.AddGoogleExceptionLogging(options =>
            //    {
            //        options.ProjectId = projectId;
            //        options.ServiceName = "CloudSqlSample";
            //        options.Version = "Test";
            //    });
            //}
            services.AddSingleton(typeof(DbConnection), (IServiceProvider) =>
                InitializeDatabase());
            services.AddMvc();
            _services = services;
        }

        DbConnection InitializeDatabase()
        {
            DbConnection connection;
            var connBuilder = new MySqlConnectionStringBuilder(Configuration["CloudSql:ConnectionString"])
            {
                SslMode = MySqlSslMode.None, // Connecting to a local proxy that does not support ssl.
            };
            connection = new MySqlConnection(connBuilder.ConnectionString);
            //connection.Open();
            //using (var createTableCommand = connection.CreateCommand())
            //{
            //    createTableCommand.CommandText = @"
            //        CREATE TABLE IF NOT EXISTS
            //        visits (
            //            time_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            //            user_ip CHAR(64)
            //        )";
            //    createTableCommand.ExecuteNonQuery();
            //}
            return connection;
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Home}/{action=Index}/{id?}");
            });
        }
    }
}
