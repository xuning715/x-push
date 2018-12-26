package com.x.push.jpush.util;

import java.util.Map;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.x.framework.controller.ResultCode;
import com.x.framework.controller.ResultModel;

public class JPushClientUtil {

	private String appKey;

	private String appSecret;

	private boolean apnsProduction;

	private JPushClient jpushClient;

	public JPushClientUtil(String appKey, String appSecret, boolean apnsProduction) {
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.apnsProduction = apnsProduction;
		jpushClient = new JPushClient(this.appSecret, this.appKey, null, ClientConfig.getInstance());
	}

	public ResultModel pushTag(String[] tag, String alert) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildTagTitle(tag, null, alert)));
	}

	public ResultModel pushTagTitle(String[] tag, String title, String alert) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildTagTitle(tag, title, alert)));
	}

	public ResultModel pushTagTitleMap(String[] tag, String title, String alert, Map<String, String> pushMap) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildTagTitleMap(tag, title, alert, pushMap)));
	}

	public ResultModel pushAlias(String alias, String alert) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildAliasTitle(alias, null, alert)));
	}

	public ResultModel pushAliasTitle(String alias, String title, String alert) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildAliasTitle(alias, title, alert)));
	}

	public ResultModel pushAll(String alert) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildAll(alert)));
	}

	public ResultModel pushAliasTitleMap(String alias, String title, String alert, Map<String, String> pushMap) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildAliasTitleMap(alias, title, alert, pushMap)));
	}

	public ResultModel pushAllTitleMap(String title, String alert, Map<String, String> pushMap) throws APIConnectionException, APIRequestException {
		return getResultModel(jpushClient.sendPush(buildAllTitleMap(title, alert, pushMap)));
	}

	private PushPayload buildTagTitle(String[] tag, String title, String alert) {
		return buildTagTitleMap(tag, title, alert, null);
	}

	private PushPayload buildTagTitleMap(String[] tag, String title, String alert, Map<String, String> pushMap) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag(tag))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert(alert)
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.addExtras(pushMap)
												.setTitle(title).build())
								.addPlatformNotification(
										IosNotification.newBuilder()
												.addExtras(pushMap)
												.addExtra("title", title)
												.build())// IOS推送不支持标题，做为Key值传过去
								.build())
				.setOptions(
						Options.newBuilder()
								.setApnsProduction(this.apnsProduction).build())
				.build();
	}

	private PushPayload buildAll(String alert) {
		return PushPayload.alertAll(alert);
	}

	private PushPayload buildAliasTitle(String alias, String title, String alert) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.alias(alias))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert(alert)
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle(title).build())
								.addPlatformNotification(
										IosNotification.newBuilder()
												.addExtra("title", title)
												.build())// IOS推送不支持标题，做为Key值传过去
								.build())
				.setOptions(
						Options.newBuilder()
								.setApnsProduction(this.apnsProduction).build())
				.build();
	}

	private PushPayload buildAliasTitleMap(String alias, String title, String alert, Map<String, String> pushMap) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.alias(alias))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert(alert)
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle(title)
												.addExtras(pushMap).build())
								.addPlatformNotification(
										IosNotification.newBuilder()
												.addExtras(pushMap)
												.addExtra("title", title)
												.build())// IOS推送不支持标题，做为Key值传过去
								.build())
				.setOptions(
						Options.newBuilder()
								.setApnsProduction(this.apnsProduction).build())
				.build();
	}

	private PushPayload buildAllTitleMap(String title, String alert, Map<String, String> pushMap) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.all())
				.setNotification(
						Notification
								.newBuilder()
								.setAlert(alert)
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle(title)
												.addExtras(pushMap).build())
								.addPlatformNotification(
										IosNotification.newBuilder()
												.addExtras(pushMap)
												.addExtra("title", title)
												.build())// IOS推送不支持标题，做为Key值传过去
								.build())
				.setOptions(
						Options.newBuilder()
								.setApnsProduction(this.apnsProduction).build())
				.build();
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public boolean isApnsProduction() {
		return apnsProduction;
	}

	public void setApnsProduction(boolean apnsProduction) {
		this.apnsProduction = apnsProduction;
	}

	private ResultModel getResultModel(PushResult result) {
		if (result.isResultOK()) {
			return new ResultModel(ResultCode.RESULT_SUCCESS, "发送成功", result);
		}
		return new ResultModel(ResultCode.RESULT_FAIL, "发送失败", result);
	}
}
