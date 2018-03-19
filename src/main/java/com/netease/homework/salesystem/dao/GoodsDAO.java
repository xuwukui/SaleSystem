package com.netease.homework.salesystem.dao;

import com.netease.homework.salesystem.pojo.BuyerGoods;
import com.netease.homework.salesystem.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("goodsDAO")
public interface GoodsDAO {

    @Select("select * from goods")
    List<Goods> getAllGoodsList();

    @Select("select * from goods where isBought=false")
    List<Goods> getGoodsListIsNotBought();

    @Select("select * from goods where id=#{id}")
    Goods getGoodsById(int id);

    @Insert("insert into goods(title,summary,pictureUrl,detail,price) values(#{title},#{summary},#{pictureUrl},#{detail},#{price})")
    @Options(useGeneratedKeys = true)
    void insertGoods(Goods goods);

    @Update("update goods set title=#{title},summary=#{summary},pictureUrl=#{pictureUrl},detail=#{detail},price=#{price} where id=#{id}")
    void updateGoodsById(Goods goods);

    @Update("update goods set isBought = 1 where id = #{id}")
    void updateGoodsStatus2IsBought(int id);

    @Delete("delete from goods where id=#{id}")
    void deleteGoodsById(int id);

    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "buyRecord",column = "id",javaType = BuyerGoods.class,
            one = @One(select = "com.netease.homework.salesystem.dao.BuyerGoodsDAO.getBuyerGoodsByGoodsId"))
    })
    @Select("select * from goods where id = #{id}")
    Goods getGoodsDetailById(int id);

    @Update("update goods set isBought = 1,saleNum = saleNum + #{buyNum} where id = #{id}")
    void updateGoodsInfo4Purchase(@Param("id") int id,@Param("buyNum") int buyNum);

    @Select("select id from goods where pictureUrl = #{pictureUrl}")
    int getGoodsIdByPictureUrl(String pictureUrl);
}
