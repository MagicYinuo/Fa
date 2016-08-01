package com.tai.joker.thenews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.tai.joker.thenews.Constants.Constants;
import com.tai.joker.thenews.R;
import com.tai.joker.thenews.utils.VolleyUtils;

/**
 * Created by Administrator on 2016/8/1.
 */
public class SimpleFragment extends Fragment {
    private TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        View v = inflater.inflate(R.layout.fragment_item, container, false);
        tv = (TextView) v.findViewById(R.id.tv);
//        tv.setText(title);
        VolleyUtils.getInstance(getContext()).get(Constants.ADRRESS, "type=null&key=4203ac1bc6b06574a129ab1d47aa0f97", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        return v;

    }
}
