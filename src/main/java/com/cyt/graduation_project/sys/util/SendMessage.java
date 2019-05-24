package com.cyt.graduation_project.sys.util;

/**
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2019-3-22
 * @version
 */
public class SendMessage {
	//用户名
	private static String Uid = "jim982836261";
	//private static String Uid = "cyt888";
	//接口安全秘钥
	//private static String Key = "d41d8cd98f00b204e980";
	private static String Key = "d41d8cd98f00b204e980";

	//手机号码，多个号码如13800000000,13800000001,13800000002
	private static String smsMob = null;
	
	//短信内容
	private static String smsText = "";
	public String sendNews(String smsMob) {
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		double yzm1=((Math.random()*9+1)*100000);
		int yzm2= (int) yzm1;
		String nums=String.valueOf(yzm2);
		smsText = "支教系统验证码:"+ nums + ",请勿泄漏验证码！";
		//UTF发送
		client.sendMsgUtf8(Uid, Key, smsText, smsMob);

		return nums+"";
	}

	public void sendNewAccounts(String smsMob,String userAccount,String password) {
		HttpClientUtil client = HttpClientUtil.getInstance();
		smsText = "尊敬的用户:"+ smsMob+ "，您成功注册支教网站，初始账号："+userAccount+",密码："+password+"。请勿泄漏！";
		client.sendMsgUtf8(Uid, Key, smsText, smsMob);

	}
}
