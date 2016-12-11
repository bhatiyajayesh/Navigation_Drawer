package com.example.dadabhagwan.navigationdrawerdemo.Activity.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Preview.Contact;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.StudentObject;
import com.example.dadabhagwan.navigationdrawerdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadabhagwan on 11/28/2016.
 */

public class CustomJsonObjectAdapter extends BaseAdapter{

    Context context;
    List<Contact> Object;
    LayoutInflater layoutInfiater;
    //StudentObject studentObject;
    public CustomJsonObjectAdapter(Context c, List<Contact> so)
    {
        this.Object=so;
        this.context=c;
        layoutInfiater= (LayoutInflater) this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return Object.size();
    }

    @Override
    public Object getItem(int i) {
        return Object.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewItem3 viewItem3 = null;

        if(view == null) {
            viewItem3 = new ViewItem3();
            view = layoutInfiater.inflate(R.layout.single_raw3,viewGroup,false);
            viewItem3.UId = (TextView) view.findViewById(R.id.tvId);
            viewItem3.UName = (TextView) view.findViewById(R.id.tvName);
            viewItem3.UEmail = (TextView) view.findViewById(R.id.tvEmail);
            viewItem3.Ugender = (TextView) view.findViewById(R.id.tvGender);
            viewItem3.UAddress = (TextView) view.findViewById(R.id.tvAddress);
            viewItem3.Umobile = (TextView) view.findViewById(R.id.tvMobile);
            viewItem3.Uhome = (TextView) view.findViewById(R.id.tvHome);
            viewItem3.Uoffice = (TextView) view.findViewById(R.id.tvOffice);
            viewItem3.img = (ImageView) view.findViewById(R.id.ivImage);



            view.setTag(viewItem3);
        }
        else
        {
            viewItem3 = (ViewItem3) view.getTag();
        }


        viewItem3.UId.setText(Object.get(i).getId());
        viewItem3.UName.setText(Object.get(i).getName());
        viewItem3.UEmail.setText(Object.get(i).getEmail());
        viewItem3.UAddress.setText(Object.get(i).getAddress());
        viewItem3.Ugender.setText(Object.get(i).getGender());
        viewItem3.Uoffice.setText(Object.get(i).getPhone().getOffice());
        viewItem3.Umobile.setText(Object.get(i).getPhone().getMobile());
        viewItem3.Uhome.setText(Object.get(i).getPhone().getHome());
        Picasso.with(context).load("http://cdn1.softproject.onlinebusiness.cc/files/en_sp/en_Adapters/Documenta%20and%20formats/JSON-Converter.jpg").into(viewItem3.img);


        return view;
    }
}
class ViewItem3
{
    TextView UId,UName,UEmail,UAddress,Ugender,Uoffice,Umobile,Uhome;
    ImageView img;
}