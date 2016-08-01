package com.tai.joker.thenews.utils;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tai.joker.thenews.Constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/1.
 */
public class VolleyUtils {

    private Context mContext;
    private RequestQueue mRequestQueue;

    private static VolleyUtils mVolleyUtils = null;


    private VolleyUtils(Context context) {
        this.mContext = context;
        mRequestQueue = Volley.newRequestQueue(mContext);
    }

    public static VolleyUtils getInstance(Context context) {
        if (mVolleyUtils == null) {
            mVolleyUtils = new VolleyUtils(context);
        }
        return mVolleyUtils;

    }

    /**
     * Post请求
     *
     * @param url
     * @param value
     * @param listener
     * @param errorListener
     */
    public <T> void post(String url, final T value, Response.Listener<String> listener, Response.ErrorListener errorListener) {

        StringRequest request = new StringRequest(Request.Method.POST, Constants.ADRRESS + url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("params", JSON.toJSONString(value));
                return map;
            }
        };
        mRequestQueue.add(request);
    }

    /**
     * Get请求
     *
     * @param url
     * @param value
     * @param listener
     * @param errorListener
     */
    public <T> void get(String url, final T value, Response.Listener<String> listener, Response.ErrorListener errorListener) {

        StringRequest request = new StringRequest(Request.Method.GET, Constants.ADRRESS + url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("params", JSON.toJSONString(value));
                return map;
            }

        };
        mRequestQueue.add(request);
    }

    public RequestQueue getmQueue() {
        return mRequestQueue;
    }


}
