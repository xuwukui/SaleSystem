package com.netease.homework.salesystem.service;

import com.netease.homework.salesystem.dao.GoodsDAO;
import com.netease.homework.salesystem.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDAO goodsDAO;

    @Transactional
    public List<Goods> getAllGoods(){
        return goodsDAO.getAllGoodsList();
    }

    @Transactional
    public List<Goods> getGoodsListIsNotBought(){
        return goodsDAO.getGoodsListIsNotBought();
    }

    @Transactional
    public Goods getGoodsDetailById(int id){
        return goodsDAO.getGoodsDetailById(id);
    }

    @Transactional
    public void updateGoodsStatus2IsBought(int id){
        goodsDAO.updateGoodsStatus2IsBought(id);
    }

    @Transactional
    public void updateGoodsInfo4Purchase(int goodsId,int buyNum){
        goodsDAO.updateGoodsInfo4Purchase(goodsId,buyNum);
    }

    @Transactional
    public void insertGoods(Goods goods){
        goodsDAO.insertGoods(goods);
    }

    @Transactional
    public  int getGoodsIdByPictureUrl(String pictureUrl){
        return goodsDAO.getGoodsIdByPictureUrl(pictureUrl);
    }

    @Transactional
    public void updateGoods(Goods goods){
        goodsDAO.updateGoodsById(goods);
    }

    @Transactional
    public Goods getGoodsById(int goodsId){
        return goodsDAO.getGoodsById(goodsId);
    }

    public void deleteGoodsById(int goodsId){
        goodsDAO.deleteGoodsById(goodsId);
    }
}
