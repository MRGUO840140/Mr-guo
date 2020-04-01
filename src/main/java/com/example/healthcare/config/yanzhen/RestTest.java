/**
 * @author Tony
 * @date 2018-01-10
 * @project rest_demo
 */
package com.example.healthcare.config.yanzhen;

import com.example.healthcare.config.yanzhen.client.AbsRestClient;
import com.example.healthcare.config.yanzhen.client.JsonReqClient;

import java.io.IOException;

public class RestTest {

	static AbsRestClient InstantiationRestAPI() {
		return new JsonReqClient();
	}
	
	public static void testSendSms(String sid, String token, String appid, String templateid, String param, String mobile, String uid){
		try {
			String result=InstantiationRestAPI().sendSms(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testSendSmsBatch(String sid, String token, String appid, String templateid, String param, String mobile, String uid){
		try {
			String result=InstantiationRestAPI().sendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testAddSmsTemplate(String sid, String token, String appid, String type, String template_name, String autograph, String content){
		try {
			String result=InstantiationRestAPI().addSmsTemplate(sid, token, appid, type, template_name, autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	
	public static void testGetSmsTemplate(String sid, String token, String appid, String templateid, String page_num, String page_size){
		try {
			String result=InstantiationRestAPI().getSmsTemplate(sid, token, appid, templateid, page_num, page_size);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testEditSmsTemplate(String sid, String token, String appid, String templateid, String type, String template_name, String autograph, String content){
		try {
			String result=InstantiationRestAPI().editSmsTemplate(sid, token, appid, templateid, type, template_name, autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testDeleterSmsTemplate(String sid, String token, String appid, String templateid){
		try {
			String result=InstantiationRestAPI().deleterSmsTemplate(sid, token, appid, templateid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 测试说明  启动main方法后，请在控制台输入数字(数字对应 相应的调用方法)，回车键结束
	 * 参数名称含义，请参考rest api 文档
	 * @throws IOException 
	 * @method main
	 */
	public static void main(String[] args) throws IOException{
		

		String methodNumber ="1";

		
		if (methodNumber.equals("1")) {  //指定模板单发
			String sid = "2ed76a12c6516c7f998d567e12bd1417";
			String token = "8565f3c2aa73f257cf5ea07858cedb43";
			String appid = "50d08efd1c5241b5bdf9be56009bb913";
			String templateid = "504741";
			String param = "123456";
			String mobile = "18151130050";
			String uid = "";
			testSendSms(sid, token, appid, templateid, param, mobile, uid);
		} /*else if (methodNumber.equals("2")) { //指定模板群发
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String param = "";
			String mobile = "";
			String uid = "";
			testSendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
		} else if (methodNumber.equals("3")) {  //增加模板
			String sid = "";
			String token = "";
			String appid = "";
			String type = "";
			String template_name = "";
			String autograph = "";
			String content = "";
			testAddSmsTemplate(sid, token, appid, type, template_name, autograph, content);
		} else if (methodNumber.equals("4")) {  //查询模板
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String page_num = "";
			String page_size = "";
			testGetSmsTemplate(sid, token, appid, templateid, page_num, page_size);
		} else if (methodNumber.equals("5")) {  //编辑模板
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String type = "";
			String template_name = "";
			String autograph = "";
			String content = "";
			testEditSmsTemplate(sid, token, appid, templateid, type, template_name, autograph, content);
		} else if (methodNumber.equals("6")) {  //删除模板
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			testDeleterSmsTemplate(sid, token, appid, templateid);
		} 	*/
	}
}
