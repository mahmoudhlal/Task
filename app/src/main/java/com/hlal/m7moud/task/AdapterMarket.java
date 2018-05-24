package com.hlal.m7moud.task;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hlal.m7moud.task.Shop.ShopItems;
import com.hlal.m7moud.task.Shop.ShopList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterMarket extends RecyclerView.Adapter<AdapterMarket.ViewHolder> implements View.OnClickListener {
    List<ShopList> arrayList ;
    Context context ;
    ShopList dataEncap = new ShopList();


    public AdapterMarket(List<ShopList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public AdapterMarket.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show , parent , false) ;
        ViewHolder viewHolder  = new ViewHolder(view);

        return viewHolder ;
    }

    @Override
    public void onBindViewHolder( AdapterMarket.ViewHolder holder, int position) {

        dataEncap = arrayList.get(position) ;

        holder.cardView.setTag(position);
        holder.name.setText(dataEncap.getShopName());


        Picasso.with(context).load(dataEncap.getShopIcon()).into(holder.imageMarket);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View view) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView ;
        ImageView imageMarket ;
        TextView name ;


        public ViewHolder(View view) {
            super(view);
            cardView = (CardView)view.findViewById(R.id.cardview);
            imageMarket = (ImageView) view.findViewById(R.id.imagemarket);
            name = (TextView) view.findViewById(R.id.txtmarket);

            cardView.setOnClickListener((View.OnClickListener) this);
        }


        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();
        }
    }

}
