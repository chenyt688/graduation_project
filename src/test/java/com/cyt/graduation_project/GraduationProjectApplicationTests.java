/*
package com.cyt.graduation_project;

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
    */
/*@Test
    //判断本地是否存在图片
    public static boolean getRource(String source){
        try {
            URL url = new URL(source);
            URLConnection uc = url.openConnection();
            InputStream in = uc.getInputStream();
            if (source.equalsIgnoreCase(uc.getURL().toString()))
                in.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }*//*

    //读取照片
    public  byte[] getImg(String filepath){
        */
/*BASE64Encoder encoder = new BASE64Encoder();         //通过base64 转化图片
        String img = "";
        //获得输入流,将文件读到内存
        FileInputStream in = null;
        try {
            in = new  FileInputStream(filepath);

            int n=0;
            //1024字节 ,相当于每次读取1kb
            byte[] arr = new byte[in.available()];
            //循环读取,读到末尾会返回-1
            while((n=in.read(arr)) !=-1) {
                //将读取的内容写入到输出流当中

            }
            String s = Base64.encodeBase64String(arr);
            //img = encoder.encode(arr);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*//*

        return null;

    }

    @Test
    public  void main1(){
        //getImg("E://BD/UserInfo/用户cyt/个人申请书.jpg");
        */
/*File file=new File("E://BD/UserInfo/用户cyt/个人申请书.jpg");

        if(!file.exists()){
            System.out.println("文件不存在");
        }else{
            System.out.println("文件存在");
        }*//*




       */
/* String date = "2019-01-31T14:53:48.8889Z";

        System.out.println(DateFormatUtil.dateFormat2(date));

        String str = "1-1-1-1-1-";
        String s[] = str.split("-");
        int j = s.length;
        for(int i = 0 ;i<s.length;i++){
            System.out.println(s[i] + i);
        }
*//*

        */
/*NewsCrawlerUtil newsCrawlerUtil =new  NewsCrawlerUtil("sss",true);
        try {
            newsCrawlerUtil.start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }*//*



        */
/*Date t = new Date();
        java.sql.Date sqld = new java.sql.Date(t.getTime());
        System.out.println(sqld);
        java.sql.Time sqlt = new java.sql.Time(t.getTime());
        System.out.println(sqlt);*//*

    }



}
*/
