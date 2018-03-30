package com.android.andi.mytrip.server;

import android.content.Context;
import android.provider.Settings;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BuildConfig;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by Andi Xu on 3/29/18.
 */

public class ServerAPI {
    public static final String STATUS_MSG_OK = "OK";

    public static final int STATUS_OK = 200;
    public static final int STATUS_UNKNOWNERROR = -1;

    public static final String SERVER_BASE_URL = "";

    private static AsyncHttpClient client = null;
    private static PersistentCookieStore mCookieStore = null;

    public static void init(Context context) {
        client = null;
        client = new AsyncHttpClient();
        client.setUserAgent("Version " + BuildConfig.VERSION_NAME + " deviceID " + getDeviceId(context));
        if (mCookieStore == null) {
            mCookieStore = new PersistentCookieStore(context);
            client.setCookieStore(mCookieStore);
        }
    }

    private static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static void shutdown(Context context) {
        if (mCookieStore != null) {
            mCookieStore.clear();
            mCookieStore = null;
            mCookieStore = new PersistentCookieStore(context);
            client.setCookieStore(mCookieStore);
        }
    }

    public static PersistentCookieStore getCookieStore() {
        return mCookieStore;
    }

    public static void get(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        if (client == null)
            ServerAPI.init(context);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void getAbsoulte(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        if (client == null)
            ServerAPI.init(context);
        client.get(url, params, responseHandler);
    }

    public static void post(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        if (client == null)
            ServerAPI.init(context);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void postJSON(Context context, String url, JSONObject data,
                                AsyncHttpResponseHandler responseHandler) {
        StringEntity entity;
        try {
            if (client == null) {
                ServerAPI.init(context);
            }
            entity = new StringEntity(data.toString());
            entity.setContentType("application/json");
            client.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Context context, String url, AsyncHttpResponseHandler responseHandler) {
        if (client == null)
            ServerAPI.init(context);
        client.delete(getAbsoluteUrl(url), responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return ServerAPI.SERVER_BASE_URL + relativeUrl;
    }



}
