package com.netease.homework.salesystem.dao;

import com.netease.homework.salesystem.pojo.BuyerGoods;
import com.netease.homework.salesystem.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buyerGoodsDAO")
public interface BuyerGoodsDAO {

    @Select("select * from buyer_goods where goodsId = #{id}")
    BuyerGoods getBuyerGoodsByGoodsId(int id);

    @Insert("insert into buyer_goods(goodsId,buyNum,buyPrice) values(#{goodsId},#{buyNum},#{buyPrice})")
    void addGoodsToCart(@Param("goodsId") int goodsId, @Param("buyNum") int buyNum,@Param("buyPrice") int buyPrice);

    @Update("update buyer_goods set buyNum = buyNum + #{buyNum} where goodsId = #{goodsId}")
    void updateCartBuyNum(@Param("goodsId") int goodsId,@Param("buyNum") int buyNum);

    @Update("update buyer_goods set isInCart = 0 where goodsId = #{goodsId}")
    void removeGoodsFromCart(@Param("goodsId") int goodsId);

    @Results({
            @Result(property = "goodsInfo",column = "goodsId",javaType = Goods.class,
                    one = @One(select = "com.netease.homework.salesystem.dao.GoodsDAO.getGoodsById"))
    })
    @Select("select * from buyer_goods where isInCart = 1")
    List<BuyerGoods> getCartGoodsList();

    @Results({
            @Result(property = "goodsInfo",column = "goodsId",javaType = Goods.class,
                    one = @One(select = "com.netease.homework.salesystem.dao.GoodsDAO.getGoodsById"))
    })
    @Select("select * from buyer_goods where isInCart = 0")
    List<BuyerGoods> getAccountList();

}
