package com.example.dadabhagwan.navigationdrawerdemo.Activity.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dadabhagwan.navigationdrawerdemo.R;

/**
 * Created by dadabhagwan on 11/25/2016.
 */

public class SecondJsonFragment extends Fragment {
    ListView list1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_json2,container, false);
        list1= (ListView) view.findViewById(R.id.listView2);
        return view;

    }
}
