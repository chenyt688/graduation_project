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
		smsText = "支教系统登录验证码:"+ nums + ",请不要向他人透露该验证码";
		/*int number = (int) ((Math.random()*9+1)*100000);
		String num = number + "";*/
		//smsText = smsText + num;
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result>0){
			System.out.println("信息成功发送条数=="+result);
		}else{
			System.out.println(client.getErrorMsg(result));
		}
		return nums+"";
	}
}
