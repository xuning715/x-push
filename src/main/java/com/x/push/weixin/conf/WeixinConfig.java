package com.x.push.weixin.conf;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.wxaapp.WxaConfig;
import com.jfinal.wxaapp.WxaConfigKit;

/**
 * 微信常量配置
 */
public class WeixinConfig {

	public static String token;

	public static String appId;

	public static String appSecret;

	public static String encodingAesKey;

	public static boolean encryptMessage;

	public WeixinConfig(String token, String appId, String appSecret, String encodingAesKey, boolean encryptMessage) {
		WeixinConfig.token = token;
		WeixinConfig.appId = appId;
		WeixinConfig.appSecret = appSecret;
		WeixinConfig.encodingAesKey = encodingAesKey;
		WeixinConfig.encryptMessage = encryptMessage;
		this.init();
	}

	private void init(){
		ApiConfig ac = new ApiConfig();
		// 配置微信 API 相关参数
		ac.setToken(WeixinConfig.token);
		ac.setAppId(WeixinConfig.appId);
		ac.setAppSecret(WeixinConfig.appSecret);
		/**
		 * 是否对消息进行加密，对应于微信平台的消息加解密方式： 1：true进行加密且必须配置 encodingAesKey
		 * 2：false采用明文模式，同时也支持混合模式
		 */
		ac.setEncryptMessage(WeixinConfig.encryptMessage);
		ac.setEncodingAesKey(WeixinConfig.encodingAesKey);

		ApiConfigKit.putApiConfig(ac);
		WxaConfig wc = new WxaConfig();
		wc.setAppId(WeixinConfig.appId);
		wc.setAppSecret(WeixinConfig.appSecret);
		WxaConfigKit.setWxaConfig(wc);
	}

	public void setToken(String token) {
		WeixinConfig.token = token;
	}

	public void setAppId(String appId) {
		WeixinConfig.appId = appId;
	}

	public void setAppSecret(String appSecret) {
		WeixinConfig.appSecret = appSecret;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		WeixinConfig.encodingAesKey = encodingAesKey;
	}

	public void setEncryptMessage(boolean encryptMessage) {
		WeixinConfig.encryptMessage = encryptMessage;
	}

}
