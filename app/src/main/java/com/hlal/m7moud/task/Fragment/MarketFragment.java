package com.hlal.m7moud.task.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hlal.m7moud.task.AdapterMarket;
import com.hlal.m7moud.task.MainActivity;
import com.hlal.m7moud.task.R;
import com.hlal.m7moud.task.Remote.ApiUtlis;
import com.hlal.m7moud.task.Remote.UserService;
import com.hlal.m7moud.task.Shop.ShopItems;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketFragment extends Fragment {

     View view;
    BottomNavigationView bnavigate ;
    RecyclerView recyclerView ;
    private AdapterMarket adapterMarket ;


    private UserService userService ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater  , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState){
        view= inflater.inflate(R.layout.fragment_market , container , false) ;
        initComponents();

        RecyclerMain();
        getMarkets("31.2219914","29.9345114");
        return view;
    }

    private void initComponents() {
        userService = ApiUtlis.getUserService() ;
    }

    private void RecyclerMain(){
        recyclerView = (RecyclerView)view.findViewById(R.id.recmarket);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity()) ;
        recyclerView.setLayoutManager(layoutManager);


    }

    private void getMarkets(String lat , String lon){
        Call<ShopItems> call = userService.getMarkets(lat , lon)  ;
        call.enqueue(new Callback<ShopItems>() {
            @Override
            public void onResponse(Call<ShopItems> call, Response<ShopItems> response) {
                if(response.isSuccessful()) {
                    if (response.body().getShopList().size() > 0) {
                        Toast.makeText(getActivity(), "poools", Toast.LENGTH_SHORT).show();
                        adapterMarket = new AdapterMarket(response.body().getShopList(), getActivity().getApplicationContext());
                        recyclerView.setAdapter(adapterMarket);
                        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                        adapterMarket.notifyDataSetChanged();
                    } else{
                        Toast.makeText(getActivity(), "No Places", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItems> call, Throwable t) {

            }
        });
    }



}
