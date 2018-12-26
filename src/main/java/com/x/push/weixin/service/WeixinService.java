package com.x.push.weixin.service;

import com.alibaba.fastjson.JSON;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.TemplateMsgApi;
//import com.x.crm.payload.IntentionMsg;
//import com.x.erp.util.Constant;
import com.x.framework.exception.BusinessException;
import com.x.push.jpush.util.JPushClientUtil;
import com.x.push.weixin.conf.WxTemplateConstants;
import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeixinService {
//    private static final Logger logger = LogManager.getLogger(WeixinService.class);

    /**
     * 记录询价信息
     *
     * @param intentionMsg
     */
//    public void pushCarIntentionMsg(IntentionMsg intentionMsg) {
//        logger.info("mq--pushCarintentionMsg");
//        try {
//            logger.info("rmq-message:记录询价信息，推送消息给商户（start）：" + JSON.toJSONString(intentionMsg));
//            String carId = intentionMsg.getCarId();
//            String mobile = intentionMsg.getCustomerMobile();
//            String customerName = intentionMsg.getCustomerName();
//            String carTitle = intentionMsg.getCarTitle();
//            String date = intentionMsg.getDate();
//            for (String wxOpenId : intentionMsg.getWxOpenIds()) {
//                if (StringUtils.isNotEmpty(wxOpenId)) {
//                    ApiResult result = TemplateMsgApi.send("{\"touser\":\"" + wxOpenId
//                            + "\",\"url\":\"" + Constant.ERP_CONTEXT_PATH + "/mshop/src/cars_detial.html?carId=" + carId + "&imgUrl=" + Constant.FDFS_CONTENT_PATH
//                            + "\",\"template_id\":\"" + WxTemplateConstants.pushCarIntentionModel
//                            + "\",\"data\":{\"first\":{\"value\":\"老板，有人询价了！\",\"color\":\"#173177\"},"
//                            + "\"keyword1\":{\"value\":\"" + customerName + "\",\"color\":\"#173177\"},"
//                            + "\"keyword2\":{\"value\":\"" + mobile + "\",\"color\":\"#173177\"},"
//                            + "\"keyword3\":{\"value\":\"" + date + "\",\"color\":\"#173177\"},"
//                            + "\"keyword4\":{\"value\":\"" + carTitle + "\",\"color\":\"#173177\"},"
//                            + "\"remark\":{\"value\":\"请尽快处理！点击可查看车辆详情\",\"color\":\"#173177\"}}}");
//                    logger.info("微信推送询价消息给对应的用户 result=" + JSON.toJSONString(result));
//                }
//            }
//            logger.info("rmq-message:记录询价信息，推送消息给商户（end）：" + JSON.toJSONString(intentionMsg));
//        } catch (Exception e) {
//            throw new BusinessException("rmq-message:记录询价信息error", e);
//        }
//    }
}
