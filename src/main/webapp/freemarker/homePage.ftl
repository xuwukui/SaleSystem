<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <#include "include/common.ftl">
</head>
<body>

<#include "include/header.ftl">

<div class="main">
    <div class="main-inner body-width">
        <#list sellerGoodsList as goods>
            <#if goods_index%5==0>
                <br/><br/>
                <div class="main-cont main-recommend">
                    <ul class="main-cont__list clearfix">
            </#if>
                    <li class="item">
                        <a href="/SaleSystem/detail?goodsId=${goods.id}" class="pic"><img src="${goods.pictureUrl}" alt="${goods.title}" height="100%" width="100%"></a>
                        <div class="info">
                            <div class="name-price">
                                <a href="/SaleSystem/detail?goodsId=${goods.id}" class="title"><p style="max-width: 150px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;">${goods.title}</p></a>
                                <h5 class="price" style="max-width: 50px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;">￥${goods.price}</h5>
                            </div>
                        <#if login && isSeller>
                            <#if goods.isBought>
                                <div>
                                    <h5 class="buynum">已售出:${goods.saleNum}</h5>
                                </div>
                            <#else>
                                <button type="button" id="delete" class="btn btn-primary btn-sm purchase-button" onclick="deleteGoods(${goods.id})">下架商品</button>
                            </#if>
                        <#elseif login && goods.isBought>
                            <span class="has-buy"><b>已购买</b></span>
                        </#if>
                        </div>
                    </li>
            <#if (goods_index%5==4 || goods_index == sellerGoodsList?size)>
                    </ul>
                </div>
            </#if>
        </#list>
    </div>
</div>
<#include "include/footer.ftl">
</body>
</html>