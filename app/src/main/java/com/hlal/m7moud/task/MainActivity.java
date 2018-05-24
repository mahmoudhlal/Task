package com.hlal.m7moud.task;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.hlal.m7moud.task.Fragment.MarketFragment;
import com.hlal.m7moud.task.Remote.ApiUtlis;
import com.hlal.m7moud.task.Remote.UserService;
import com.hlal.m7moud.task.Shop.ShopItems;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private View v;

    BottomNavigationView bnavigate ;
    RecyclerView recyclerView ;
    private AdapterMarket adapterMarket ;

    private SearchView editText;

    private UserService userService ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userService = ApiUtlis.getUserService() ;

        bnavigate = (BottomNavigationView)findViewById(R.id.bottom_Nav);
        bnavigate.setSelectedItemId(R.id.Nav_market);

        getSupportFragmentManager().beginTransaction().replace(R.id.container , new MarketFragment()).commit() ;

        bnavigate.setOnNavigationItemSelectedListener(navListener);



        LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflator.inflate(R.layout.search, null);
        editText=v.findViewById(R.id.edit_query);
        /*PersonalPhoto=v.findViewById(R.id.imageView4);
        SearchImage=v.findViewById(R.id.imageView3);*/


        //region DoctorProfileMenu
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(v);

        

        
        /*PersonalPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START, true);
            }
        });

        SearchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorDashboardActivity.this, "Search", Toast.LENGTH_SHORT).show();
            }
        });*/

        //endregion

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfrag = null ;
            switch (item.getItemId()){
                case R.id.Nav_market:
                    selectedfrag=  new MarketFragment() ;
                    break ;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container , selectedfrag).commit() ;
            return  true ;
        }
    };




    public void buMap(View view) {
        startActivity(new Intent(this , Main_Map.class));
    }



    private void RecyclerMain(){
        recyclerView = (RecyclerView)findViewById(R.id.recmarket);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()) ;
        recyclerView.setLayoutManager(layoutManager);


    }

    private void getMarkets(String lat , String lon){
        Call<ShopItems> call = userService.getMarkets(lat , lon)  ;
        call.enqueue(new Callback<ShopItems>() {
            @Override
            public void onResponse(Call<ShopItems> call, Response<ShopItems> response) {
                if(response.isSuccessful()) {
                    if (response.body().getShopList().size() > 0) {
                        Toast.makeText(MainActivity.this, "poools", Toast.LENGTH_SHORT).show();
                        adapterMarket = new AdapterMarket(response.body().getShopList(), getApplicationContext());
                        recyclerView.setAdapter(adapterMarket);
                        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                        adapterMarket.notifyDataSetChanged();
                    } else{
                        Toast.makeText(MainActivity.this, "No Places", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItems> call, Throwable t) {

            }
        });
    }

}
