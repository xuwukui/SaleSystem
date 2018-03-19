package com.netease.homework.salesystem.pojo;

import java.sql.Timestamp;

public class BuyerGoods {
    private Integer id;
    private Integer goodsId;
    private Integer buyNum;
    private java.sql.Timestamp buyTime;
    private Float buyPrice;
    private boolean isInCart;

    private Goods goodsInfo;

    public BuyerGoods(Integer id, Integer goodsId, Integer buyNum, Timestamp buyTime, Float buyPrice, boolean isInCart) {
        this.id = id;
        this.goodsId = goodsId;
        this.buyNum = buyNum;
        this.buyTime = buyTime;
        this.buyPrice = buyPrice;
        this.isInCart = isInCart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsid) {
        this.goodsId = goodsid;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public java.sql.Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(java.sql.Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public boolean isInCart() {
        return isInCart;
    }

    public void setInCart(boolean inCart) {
        isInCart = inCart;
    }

    public Goods getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(Goods goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public String toString() {
        return "BuyerGoods{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", buyNum=" + buyNum +
                ", buyTime=" + buyTime +
                ", buyPrice=" + buyPrice +
                ", isInCart=" + isInCart +
                ", goodsInfo=" + goodsInfo +
                '}';
    }
}
