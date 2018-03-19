package com.netease.homework.salesystem.pojo;

public class Goods {
    private int id;
    private String title;
    private String summary;
    private String pictureUrl;
    private String detail;
    private Float price;
    private int saleNum;
    private Boolean isBought;

    private BuyerGoods buyRecord;

    public Goods(){}

    public Goods(int id, String title, String summary, String pictureUrl, String detail, Float price, Integer saleNum, Boolean isBought) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.pictureUrl = pictureUrl;
        this.detail = detail;
        this.price = price;
        this.saleNum = saleNum;
        this.isBought = isBought;
    }

    public Goods(String title, String summary, String pictureUrl, String detail, Float price, Integer saleNum, Boolean isBought) {
        this.title = title;
        this.summary = summary;
        this.pictureUrl = pictureUrl;
        this.detail = detail;
        this.price = price;
        this.saleNum = saleNum;
        this.isBought = isBought;
    }

    public Goods(String title, String summary, String pictureUrl, String detail, Float price) {
        this.title = title;
        this.summary = summary;
        this.pictureUrl = pictureUrl;
        this.detail = detail;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureurl) {
        this.pictureUrl = pictureurl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public Boolean getIsBought() {
        return isBought;
    }

    public void setIsBought(Boolean isbought) {
        this.isBought = isbought;
    }

    public BuyerGoods getBuyRecord() {
        return buyRecord;
    }

    public void setBuyRecord(BuyerGoods buyRecord) {
        this.buyRecord = buyRecord;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", saleNum=" + saleNum +
                ", isBought=" + isBought +
                ", buyRecord=" + buyRecord +
                '}';
    }
}
