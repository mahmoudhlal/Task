package com.hlal.m7moud.task.Shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopItems {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("shop_list")
    @Expose
    private List<ShopList> shopList = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ShopList> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopList> shopList) {
        this.shopList = shopList;
    }

}
