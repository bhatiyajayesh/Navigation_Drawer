package com.example.dadabhagwan.navigationdrawerdemo.Activity.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Example;
import com.example.dadabhagwan.navigationdrawerdemo.R;
//import com.example.dadabhagwan.retrofit.POJO.Example;

import java.util.ArrayList;

/**
 * Created by dadabhagwan on 11/23/2016.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<Example> examples;
    Context c;
    LayoutInflater layoutInfiater;
    public CustomAdapter(Context c, ArrayList<Example> example)
    {
        this.c=c;
        this.examples=example;
        layoutInfiater= (LayoutInflater) this.c.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return examples.size();

    }

    @Override
    public Example getItem(int i) {
        return examples.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewItem viewItem = null;

        if(view == null) {
            viewItem = new ViewItem();
            view = layoutInfiater.inflate(R.layout.single_raw,viewGroup,false);
            viewItem.id = (TextView) view.findViewById(R.id.tvId);
            viewItem.UserId = (TextView) view.findViewById(R.id.tvUserId);
            viewItem.Body = (TextView) view.findViewById(R.id.tvTitle);
            viewItem.Title = (TextView) view.findViewById(R.id.tvBody);
            view.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem) view.getTag();


        }

        viewItem.id.setText("id = "+examples.get(i).getId());
        viewItem.UserId.setText("User Id = "+examples.get(i).getUserId());
        viewItem.Body.setText("Title = "+examples.get(i).getTitle());
        viewItem.Title.setText("Body = "+examples.get(i).getBody());




        return view;
    }
}

class ViewItem
{
    TextView id,UserId,Title,Body;
}