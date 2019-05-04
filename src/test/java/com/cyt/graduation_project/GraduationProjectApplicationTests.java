package com.cyt.graduation_project;

import com.cyt.graduation_project.sys.util.NewsCrawlerUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class GraduationProjectApplicationTests {
    private final Logger log = LoggerFactory.getLogger(GraduationProjectApplicationTests.class);



    @Test
    public void contextLoads() {

        log.info("info....");
        log.debug("debug....");
        log.error("error....");
    }
    @Test
    public static void main(String[] agrs){
       /* String date = "2019-01-31T14:53:48.8889Z";

        System.out.println(DateFormatUtil.dateFormat2(date));

        String str = "1-1-1-1-1-";
        String s[] = str.split("-");
        int j = s.length;
        for(int i = 0 ;i<s.length;i++){
            System.out.println(s[i] + i);
        }
*/
        NewsCrawlerUtil newsCrawlerUtil =new  NewsCrawlerUtil("sss",true);
        try {
            newsCrawlerUtil.start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Date t = new Date();
        java.sql.Date sqld = new java.sql.Date(t.getTime());
        System.out.println(sqld);
        java.sql.Time sqlt = new java.sql.Time(t.getTime());
        System.out.println(sqlt);*/
    }



}
