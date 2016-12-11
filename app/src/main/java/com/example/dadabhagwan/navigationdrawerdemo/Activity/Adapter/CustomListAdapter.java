package com.example.dadabhagwan.navigationdrawerdemo.Activity.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.user.Example1;
import com.example.dadabhagwan.navigationdrawerdemo.R;

import java.util.List;

/**
 * Created by dadabhagwan on 11/22/2016.
 */

public class CustomListAdapter extends BaseAdapter {

    Context context;

    List<Example1> userList;
    public CustomListAdapter(List<Example1> usersArray, Context context)
    {
        this.context = context;
        this.userList = usersArray;

    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Example1 getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewItem2 viewItem = null;
        if(convertView == null)
        {
            viewItem = new ViewItem2();
            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInfiater.inflate(R.layout.single_raw_2 , null);

            viewItem.Id = (TextView)convertView.findViewById(R.id.tvId1);
            viewItem.Name = (TextView)convertView.findViewById(R.id.tvName);
            viewItem.UserName = (TextView)convertView.findViewById(R.id.tvUserName);
            viewItem.Email = (TextView)convertView.findViewById(R.id.tvEmail);
            viewItem.Phone = (TextView)convertView.findViewById(R.id.tvPhone);
            viewItem.Website = (TextView)convertView.findViewById(R.id.tvWebsite);
            viewItem.Street = (TextView)convertView.findViewById(R.id.tvAddressStreet);
            viewItem.Suite = (TextView)convertView.findViewById(R.id.tvAddressSuite);
            viewItem.City = (TextView)convertView.findViewById(R.id.tvAddressCity);
            viewItem.Zipcode = (TextView)convertView.findViewById(R.id.tvAddressZipcode);
            viewItem.Lat = (TextView)convertView.findViewById(R.id.tvGeoLat);
            viewItem.Long = (TextView)convertView.findViewById(R.id.tvGeoLongitude);
            viewItem.CompanyName = (TextView)convertView.findViewById(R.id.tvCompanyName);
            viewItem.CatchPhrase = (TextView)convertView.findViewById(R.id.tvCompanyCatchPhrase);
            viewItem.CompanyBS = (TextView)convertView.findViewById(R.id.tvCompanyBs);

            convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem2) convertView.getTag();
        }





        viewItem.Id.setText(userList.get(position).getId()+"");

        viewItem.Name.setText(userList.get(position).getName());
        viewItem.UserName.setText(userList.get(position).getUsername());
        viewItem.Email.setText(userList.get(position).getEmail());
        viewItem.Phone.setText(userList.get(position).getPhone());
        viewItem.Website.setText(userList.get(position).getWebsite());
            viewItem.Street.setText(userList.get(position).getAddress().getStreet());
            viewItem.Suite.setText(userList.get(position).getAddress().getSuite());
            viewItem.City.setText(userList.get(position).getAddress().getCity());
            viewItem.Zipcode.setText(userList.get(position).getAddress().getZipcode());
                viewItem.Lat.setText(userList.get(position).getAddress().getGeo().getLat());
                viewItem.Long.setText(userList.get(position).getAddress().getGeo().getLng());
            viewItem.CompanyName.setText(userList.get(position).getCompany().getName());


            viewItem.CatchPhrase.setText(userList.get(position).getCompany().getCatchPhrase());
            viewItem.CompanyBS.setText(userList.get(position).getCompany().getBs());




//        viewItem.Lat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String  lat = (String) view.getTag();
//                Log.e("lat = ",lat);
//            }
//        });
        return convertView;

    }
}

class ViewItem2
{
    TextView Id;
    TextView Name;
    TextView UserName;
    TextView Email;
    TextView Phone;
    TextView Website;
    TextView Street;
    TextView Suite;
    TextView City;
    TextView Zipcode;
    TextView Lat;
    TextView Long;
    TextView CompanyName;
    TextView CatchPhrase;
    TextView CompanyBS;

}