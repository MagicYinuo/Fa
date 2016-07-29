package com.tai.joker.tabdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyFragment extends Fragment {
    private static String ARG_POSITION = "position";
    private int position;
    private String[] str = {"中国", "美国", "日本"};

    public static MyFragment getInstance(int position) {
        MyFragment mf = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION, position);
        mf.setArguments(bundle);
        return mf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment, null);
        ListView lv = (ListView) v.findViewById(R.id.list);
        lv.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, str));
        return v;
    }
}
