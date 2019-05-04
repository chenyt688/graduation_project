package com.cyt.graduation_project.sys.util;



import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;



/**
 * @author 创建人 HZJ
 * @date 日期 2019/4/23
 * @function
 **/
public class NewsCrawlerUtil extends BreadthCrawler {



    private int typeId;
    private String df_url;

    public NewsCrawlerUtil(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.typeId = typeId;
        this.addSeed("http://www.cta613.org/forum-66-1.html");
        this.addRegex("http://www.cta613.org/thread-9873-1-1.html");
        //this.df_url = "http://www.360changshi.com/jk/jiankang/\\d+.html";


        /**设置线程数*/
        setThreads(10);
        getConf().setTopN(100);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        if (page.matchUrl("http://www.cta613.org/thread-9873-1-1.html")) {

            try {
                News newsByUrl = ContentExtractor.getNewsByUrl(url);
                System.out.println(newsByUrl.getContent());
                System.out.println(newsByUrl.getTitle());
                System.out.println(newsByUrl.getUrl());
                System.out.println(newsByUrl.getTime());
                System.out.println(newsByUrl.getContentElement());
            }catch (Exception e){
            }
        }


    }



}