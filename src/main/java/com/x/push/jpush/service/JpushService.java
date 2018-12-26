package com.x.push.jpush.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

//import com.x.erp.payload.CyAuctionNoticeMsg;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
//import com.x.crm.payload.IntentionMsg;
//import com.x.erp.payload.CarStateMsg;
//import com.x.erp.payload.DetectionMsg;
import com.x.framework.exception.BusinessException;
import com.x.push.jpush.util.JPushClientUtil;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;

@Component
public class JpushService {

//	private static final Logger logger = LogManager.getLogger(JpushService.class);

	@Autowired
	private JPushClientUtil jpushClientUtil;// 极光推送服务

	/**
	 * 记录询价信息
	 * 
	 * @param intentionMsg
	 */
//	public void jpushIntention(IntentionMsg intentionMsg) {
//		logger.info("rmq-message:记录询价信息，推送消息给商户（start）：" + JSON.toJSONString(intentionMsg));
//		try {
//			String msg = "有用户在 " + intentionMsg.getDate() + "看了：“" + intentionMsg.getCarTitle() + "”，手机号为："
//					+ intentionMsg.getCustomerMobile();
//			jpushClientUtil.pushTag(new String[] { intentionMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录询价信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录询价信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录询价信息error", e);
//		}
//		logger.info("rmq-message:记录询价信息，推送消息给商户（end）：" + JSON.toJSONString(intentionMsg));
//	}

	/**
	 * 推送车辆已入库信息
	 * 
	 * @param carStateMsg
	 */
//	public void updateCarStockState20(CarStateMsg carStateMsg) {
//		logger.info("erp-message:记录车辆入库信息，推送消息给商户（start）：" + JSON.toJSONString(carStateMsg));
//		try {
//			String msg = "您的车辆“" + carStateMsg.getCarTitle() + "”已通过入库审核！";
//			jpushClientUtil.pushTag(new String[] { carStateMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录车辆入库信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录车辆入库信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录车辆入库信息error", e);
//		}
//		logger.info("erp-message:记录车辆入库信息，推送消息给商户（end）：" + JSON.toJSONString(carStateMsg));
//	}

	/**
	 * 推送车辆入库审核未通过信息
	 * 
	 * @param carStateMsg
	 */
//	public void updateCarStockState0(CarStateMsg carStateMsg) {
//		logger.info("erp-message:记录车辆入库审核未通过信息，推送消息给商户（start）：" + JSON.toJSONString(carStateMsg));
//		try {
//			String checkTime = getDateStr(carStateMsg.getCheckTime());
//			// 尊敬的用户您好，您的上架/入库申请于年月日时分秒审核不通过，不通过原因：xxxx。请在已入库/未入库中进行编辑并提交。
//			String msg = "尊敬的用户您好，您的入库申请车辆“" + carStateMsg.getCarTitle() + "”于" + checkTime + "审核不通过，不通过原因："
//					+ carStateMsg.getContent() + "。请在未入库中进行编辑并提交。";
//			jpushClientUtil.pushTag(new String[] { carStateMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录车辆入库审核未通过信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录车辆入库审核未通过信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录车辆入库审核未通过信息error", e);
//		}
//		logger.info("erp-message:记录车辆入库审核未通过信息，推送消息给商户（end）：" + JSON.toJSONString(carStateMsg));
//	}

	// 从date类型获得年月日时分秒的时间字符串
	private String getDateStr(Date checkTime) {
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		return df.format(checkTime);
	}

	/**
	 * 推送车辆上架审核未通过信息
	 * 
	 * @param carStateMsg
	 */
//	public void updateCarSaleState0(CarStateMsg carStateMsg) {
//		logger.info("erp-message:记录车辆上架审核未通过信息，推送消息给商户（start）：" + JSON.toJSONString(carStateMsg));
//		try {
//			String checkTime = getDateStr(carStateMsg.getCheckTime());
//			// 尊敬的用户您好，您的上架/入库申请于年月日时分秒审核不通过，不通过原因：xxxx。请在已入库/未入库中进行编辑并提交。
//			String msg = "尊敬的用户您好，您的上架申请车辆“" + carStateMsg.getCarTitle() + "”于" + checkTime + "审核不通过，不通过原因："
//					+ carStateMsg.getContent() + "。请在已入库中进行编辑并提交。";
//			jpushClientUtil.pushTag(new String[] { carStateMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录车辆上架审核未通过信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录车辆上架审核未通过信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录车辆上架审核未通过信息error", e);
//		}
//		logger.info("erp-message:记录车辆上架审核未通过信息，推送消息给商户（end）：" + JSON.toJSONString(carStateMsg));
//	}

	/**
	 * 推送车辆检测已派单信息
	 * 
	 * @param detectionMsg
	 */
//	public void updateDetectIONState10(DetectionMsg detectionMsg) {
//		logger.info("erp-message:记录车辆检测派单信息，推送消息给商户（start）：" + JSON.toJSONString(detectionMsg));
//		try {
//			String msg = "您提检的车辆“" + detectionMsg.getCarTitle() + "”已派发检测任务，稍后检测师将上门检测车辆！检测师“"
//					+ detectionMsg.getDetectorName() + "”检测师电话" + detectionMsg.getDetectorMobile();
//			jpushClientUtil.pushTag(new String[] { detectionMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录车辆检测派单信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录车辆检测派单信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录车辆检测派单信息error", e);
//		}
//		logger.info("erp-message:记录车辆检测派单信息，推送消息给商户（end）：" + JSON.toJSONString(detectionMsg));
//	}

	/**
	 * 推送车辆检测完毕信息
	 * 
	 * @param detectionMsg
	 */
//	public void updateDetectIONState20(DetectionMsg detectionMsg) {
//		logger.info("erp-message:记录车辆检测完毕信息，推送消息给商户（start）：" + JSON.toJSONString(detectionMsg));
//		try {
//			String msg = "您的检测车辆“" + detectionMsg.getCarTitle() + "”已检测完毕!";
//			jpushClientUtil.pushTag(new String[] { detectionMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录车辆检测完毕信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录车辆检测完毕信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录车辆检测完毕信息error", e);
//		}
//		logger.info("erp-message:记录车辆检测完毕信息，推送消息给商户（end）：" + JSON.toJSONString(detectionMsg));
//	}

	/**
	 * 车辆临时出库审核未通过信息
	 * 
	 * @param carStateMsg
	 */
//	public void updateCarSiteState410(CarStateMsg carStateMsg) {
//		logger.info("erp-message:记录临时出库审核未通过信息，推送消息给商户（start）：" + JSON.toJSONString(carStateMsg));
//		try {
//			String msg = "您申请的" + carStateMsg.getCarVin() + "（车架号）车辆的临时出场，审核拒绝，拒绝原因：" + carStateMsg.getContent() + "。";
//			jpushClientUtil.pushTag(new String[] { carStateMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录临时出库审核未通过信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录临时出库审核未通过信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录临时出库审核未通过信息error", e);
//		}
//		logger.info("erp-message:记录临时出库审核未通过信息，推送消息给商户（end）：" + JSON.toJSONString(carStateMsg));
//	}

	/**
	 * 车辆临时出库审核通过信息
	 * 
	 * @param carStateMsg
	 */
//	public void updateCarSiteState430(CarStateMsg carStateMsg) {
//		logger.info("erp-message:记录临时出库审核通过信息，推送消息给商户（start）：" + JSON.toJSONString(carStateMsg));
//		try {
//			String msg = "您申请的" + carStateMsg.getCarVin() + "（车架号）车辆的临时出场，已通过审核。";
//			jpushClientUtil.pushTag(new String[] { carStateMsg.getShopId() }, msg);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录临时出库审核通过信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录临时出库审核通过信息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录临时出库审核通过信息error", e);
//		}
//		logger.info("erp-message:记录临时出库审核通过信息，推送消息给商户（end）：" + JSON.toJSONString(carStateMsg));
//	}

	/**
	 * 推送车赢SDK给商户
	 *
	 * @param openApiMsg
	 */
//	public void sendSDKToShopUser(CyAuctionNoticeMsg openApiMsg) {
//		logger.info("erp-message:记录推送车赢sdk消息给商户（start）：" + JSON.toJSONString(openApiMsg));
//		try {
//			String title = openApiMsg.getTitle();
//			String msg = openApiMsg.getContent();
//			HashMap<String, String> map = new HashMap<>();
//			map.put("type",openApiMsg.getType());
//			map.put("pid",openApiMsg.getPid());
//			map.put("pushMessageTypeId",openApiMsg.getPushMessageTypeId());
//			jpushClientUtil.pushTagTitleMap(new String[] {"shopUser"}, title, msg, map);
//		} catch (APIConnectionException e) {
//			logger.error("rmq-message:记录推送车赢sdk信息error", e);
//		} catch (APIRequestException e) {
//			logger.error("rmq-message:记录推送车赢sdk消息error", e);
//		} catch (Exception e) {
//			throw new BusinessException("rmq-message:记录推送车赢sdk信息error", e);
//		}
//		logger.info("erp-message:记录推送车赢sdk消息给商户（end）：" + JSON.toJSONString(openApiMsg));
//	}
}
