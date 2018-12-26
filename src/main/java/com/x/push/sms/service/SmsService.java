package com.x.push.sms.service;

//import com.x.client.payload.ClientSmsCodeMsg;
//import com.x.erp.payload.SmsCodeMsg;
import com.x.push.sms.conf.SmsConstant;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
//import com.x.erp.payload.CarOutMsg;
import com.x.framework.controller.ResultCode;
import com.x.framework.controller.ResultModel;
import com.x.push.sms.util.SmsUtil;

@Component
public class SmsService {
	
//	private static final Logger logger = LogManager.getLogger(SmsService.class);
	
	@Autowired
	private SmsUtil smsUtil;
	
//	public void xxx() {
//		ResultModel resultModel =  smsUtil.sendSms("15011363786", "【启辕汽车】市场-商铺，抵押车辆vin（车架号）已出场5小时，请跟进。 车商电话：mobile。");
//		if(resultModel.getCode() == ResultCode.RESULT_SUCCESS){
//
//		}
//	}

	/**
	 * 车辆临时出库超时短信提醒
	 * 
	 * @param carOutMsg
	 */
//	public void sendMsgCarOutOvertimeTask(CarOutMsg carOutMsg) {
//		logger.info("erp-message:记录车辆临时出库超时信息，发送短息给指定电话号码（start）：" + JSON.toJSONString(carOutMsg));
//		//String msg = "【启辕汽车】市场-商铺，抵押车辆vin（车架号）已出场5小时，请跟进。 车商电话：mobile。";
//		String msg = "【启辕汽车】" + carOutMsg.getMarketName() + "-" + carOutMsg.getShopName() + "，抵押车辆" + carOutMsg.getCarVin()
//					+ "（车架号）已出场5小时，请跟进。 车商电话：" + carOutMsg.getShopMobile() + "。";
//		ResultModel resultModel =  smsUtil.sendSms(SmsConstant.CAR_OUT_OVERTIME_MOBILE, msg);
//		// 记录日志
//		if(resultModel.getCode() == ResultCode.RESULT_SUCCESS){
//			logger.info("erp-message:记录车辆临时出库超时信息，发送短息给指定电话号码（end）：" + JSON.toJSONString(carOutMsg));
//		}else{
//			logger.error("erp-message:记录车辆临时出库超时信息，发送短息给指定电话号码失败：" + JSON.toJSONString(carOutMsg));
//		}
//	}

	/**
	 * 用户密码重置获取短信验证码
	 * @param smsCodeMsg
	 */
//	public void sendMsgGetValidateCodeTask(SmsCodeMsg smsCodeMsg) {
//		logger.info("erp-message:重置密码验证码（start）：" + JSON.toJSONString(smsCodeMsg));
//		String msg = "【启辕汽车】您正在重置密码，验证码为"+ smsCodeMsg.getValidateCode() +"，为了您的账号安全，切勿将验证码泄露。";
//		ResultModel resultModel = smsUtil.sendSms(smsCodeMsg.getUserMiobile(), msg);
//		// 记录日志
//		if(resultModel.getCode() == ResultCode.RESULT_SUCCESS){
//			logger.info("erp-message:记录用户重置密码，发送短息给指定电话号码（end）：" + JSON.toJSONString(smsCodeMsg));
//		}else{
//			logger.error("erp-message:记录用户重置密码，发送短息给指定电话号码失败：" + JSON.toJSONString(smsCodeMsg));
//		}
//	}


	/**
	 * C端用户登录获取短信验证码
	 * @param smsCodeMsg
	 */
//	public void clientLoginGetValidateCodeTask(ClientSmsCodeMsg clientSmsCodeMsg) {
//		logger.info("client-message:登录验证码（start）：" + JSON.toJSONString(clientSmsCodeMsg));
//		String msg = "【启辕车商城】您正在登录启辕车商城，验证码为"+ clientSmsCodeMsg.getValidateCode() +"，为了您的账号安全，切勿将验证码泄露。";
//		ResultModel resultModel = smsUtil.sendSms(clientSmsCodeMsg.getUserMiobile(), msg);
//		// 记录日志
//		if(resultModel.getCode() == ResultCode.RESULT_SUCCESS){
//			logger.info("client-message:记录用户登录验证码，发送短息给指定电话号码（end）：" + JSON.toJSONString(clientSmsCodeMsg));
//		}else{
//			logger.error("client-message:记录用户登录验证码，发送短息给指定电话号码失败：" + JSON.toJSONString(clientSmsCodeMsg));
//		}
//	}
}

