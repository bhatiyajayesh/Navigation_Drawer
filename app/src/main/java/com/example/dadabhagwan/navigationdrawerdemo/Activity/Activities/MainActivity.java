package com.example.dadabhagwan.navigationdrawerdemo.Activity.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dadabhagwan.navigationdrawerdemo.Activity.Adapter.CustomAdapter;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.Adapter.CustomJsonObjectAdapter;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.Adapter.CustomListAdapter;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.Fragment.FirstJSON;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.Fragment.SecondJsonFragment;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.Fragment.ThirdJsonFrgment;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Example;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Preview.Contact;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Preview.Examples;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.StudentObject;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.user.Example1;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.REST.RetrofitArrayAPI;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.REST.RetrofitObjectApi;
import com.example.dadabhagwan.navigationdrawerdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {



            FirstJSON fJson=new FirstJSON();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_main,fJson);
            String url = "https://jsonplaceholder.typicode.com";
            setCallBack1(url);

            //fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();




        } else if (id == R.id.nav_gallery) {
            SecondJsonFragment SecondFrag=new SecondJsonFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_main,SecondFrag);
            String url = "https://jsonplaceholder.typicode.com";
            setCallBack2(url);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_slideshow) {

            ThirdJsonFrgment jsonObject=new ThirdJsonFrgment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_main,jsonObject);
            String url = "http://pratikbutani.x10.mx";
            setCallBack3(url);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setCallBack1(String url)
    {


        final ProgressDialog PD=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        PD.setTitle("Please Wait..");
        PD.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);
        Call<ArrayList<Example>> call = service.getUserDetails();
        call.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {

                if(response!=null) {


                    ArrayList<Example> example=new ArrayList<Example>();
                    example = response.body();
                    CustomAdapter adapter;
                    ListView lv;
                    lv= (ListView) findViewById(R.id.listView1);

                    adapter = new CustomAdapter(MainActivity.this, example);
                    lv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "There is no response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {

            }
        });
  }

    public void setCallBack2(String url)
    {


        final ProgressDialog PD=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        PD.setTitle("Please Wait..");
        PD.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);
        Call<ArrayList<Example1>> call = service.getUserDetails2();
        call.enqueue(new Callback<ArrayList<Example1>>() {
            @Override
            public void onResponse(Call<ArrayList<Example1>> call, Response<ArrayList<Example1>> response) {
                PD.dismiss();
                List<Example1> example=new ArrayList<Example1>();
                example = response.body();
                Log.e("onResponse: size ",example.size()+"" );
                CustomListAdapter adapter;
                ListView lv;
                lv= (ListView) findViewById(R.id.listView2);
                adapter = new CustomListAdapter(example,MainActivity.this);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Example1>> call, Throwable t) {

            }
        });
    }
    public void setCallBack3(String url)
    {


        final ProgressDialog PD=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        PD.setTitle("Please Wait..");
        PD.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectApi service = retrofit.create(RetrofitObjectApi.class);
        Call<Examples> call = service.getStudentDetails();
        call.enqueue(new Callback<Examples>() {
            @Override
            public void onResponse(Call<Examples> call, Response<Examples> response) {

                PD.dismiss();

              List<Contact>  ContactList=new ArrayList<Contact>();
               if(response.isSuccessful())
               {
               ContactList=response.body().getContacts();
                   for (int i = 0; i < response.body().getContacts().size(); i++) {
                       Log.e("Url: ", response.body().getContacts().get(i).getName()+"");
                   }

                   ListView lv3;
                   lv3= (ListView) findViewById(R.id.listView3);
                   CustomJsonObjectAdapter adapter1=new CustomJsonObjectAdapter(MainActivity.this,ContactList);
                   lv3.setAdapter(adapter1);
                   adapter1.notifyDataSetChanged();

               }
               else
               {
                   Toast.makeText(MainActivity.this, "Did Not Get Response..! ", Toast.LENGTH_SHORT).show();
               }

            }

            @Override
            public void onFailure(Call<Examples> call, Throwable t) {

            }
        });
    }
}

