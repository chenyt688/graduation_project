package com.cyt.graduation_project.sys.util;

/**
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2019-3-22
 * @version
 */
public class SendMessage {
	
	//用户名
	private static String Uid = "cyt888";
	
	//接口安全秘钥
	private static String Key = "d41d8cd98f00b204e980";
	
	//手机号码，多个号码如13800000000,13800000001,13800000002
	private static String smsMob = null;
	
	//短信内容
	private static String smsText = "【支教】登录验证码:";
	
	
	public String sendNews(String smsMob) {
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		int number = (int) (Math.random()*1000000);
		smsText = smsText + number;
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result>0){
			System.out.println("信息成功发送条数=="+result);
		}else{
			System.out.println(client.getErrorMsg(result));
		}
		return number+"";
	}
}
