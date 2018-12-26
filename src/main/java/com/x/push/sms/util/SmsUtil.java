package com.x.push.sms.util;

import com.alibaba.fastjson.JSON;
import com.x.framework.controller.ResultCode;
import com.x.framework.controller.ResultModel;
import com.x.framework.remote.HttpClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class SmsUtil {

	@Autowired
	private HttpClient httpClient;// 极光推送服务

	private String apikey;

	public SmsUtil(String apikey){
		this.apikey = apikey;
	}

	public ResultModel sendSms(String mobile, String content){
		Map<String, String> param = new HashMap<>();
		param.put("apikey", apikey);
		param.put("mobile", mobile);
		param.put("text", content);
		try {
			String res = httpClient.doPostMap("https://sms.yunpian.com/v2/sms/single_send.json", param);
			if(StringUtils.isEmpty(res) || JSON.parseObject(res).getInteger("code") != 0){
				return new ResultModel(ResultCode.RESULT_FAIL, "发送失败");
			}
			return new ResultModel(ResultCode.RESULT_SUCCESS, "发送成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultModel(ResultCode.RESULT_FAIL, "发送失败");
	}

	public static void main(String[] args) {
		HttpClient hc = new HttpClient();
		Map<String, String> a = new HashMap<>();
		a.put("apikey", "eb593149962876a76f84edf967406a4b");
		a.put("mobile", "18811132880");
		a.put("text", "【启辕汽车】市场--商铺，抵押车辆vin（车架号）已出场5小时，请跟进。 车商电话：18811132880。");
		try {
			System.out.println(hc.doPostMap("https://sms.yunpian.com/v2/sms/single_send.json", a));
			System.out.println("info");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
