package com.netease.homework.salesystem.service;

import com.netease.homework.salesystem.dao.BuyerGoodsDAO;
import com.netease.homework.salesystem.pojo.BuyerGoods;
import com.netease.homework.salesystem.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyerGoodsService {

    @Autowired
    BuyerGoodsDAO buyerGoodsDAO;

    @Autowired
    GoodsService goodsService;

    @Transactional
    public BuyerGoods getBuyerGoodsByGoodsId(int id){
        return buyerGoodsDAO.getBuyerGoodsByGoodsId(id);
    }

    @Transactional
    public void addGoodsToCart(int goodsId,int buyNum,int buyPrice){
        if(buyerGoodsDAO.getBuyerGoodsByGoodsId(goodsId) != null){
            buyerGoodsDAO.updateCartBuyNum(goodsId,buyNum);
        }
        else{
            buyerGoodsDAO.addGoodsToCart(goodsId,buyNum,buyPrice);
        }
    }

    @Transactional
    public List<BuyerGoods> getCartGoodsList(){
        return buyerGoodsDAO.getCartGoodsList();
    }

    @Transactional
    public List<BuyerGoods> getAccountList(){
        return buyerGoodsDAO.getAccountList();
    }

    @Transactional
    public void goodsBalance(List<Integer> goodsIdList,List<Integer> buyNumList){
        for(int i = 0 ; i < goodsIdList.size() ; ++i){
            int goodsId = goodsIdList.get(i);
            int buyNum = buyNumList.get(i);
            buyerGoodsDAO.removeGoodsFromCart(goodsId);
            goodsService.updateGoodsInfo4Purchase(goodsId,buyNum);
        }
    }
}
