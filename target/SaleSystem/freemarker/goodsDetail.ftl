<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${goods.title}</title>
    <#include "include/common.ftl">
</head>
<body>
<#include "include/header.ftl">
<br/><br/><br/><br/>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${goods.pictureUrl}" alt=""></div>
        <div class="cnt">
            <h2>${goods.title}</h2>
            <p style='color:red;border-bottom:2px solid #d9d9d9;'>${goods.summary}</p>
            <hr/>
            <br/><br/><br/><br/>
            <br/><br/><br/><br/>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value" id="goodsPriceNow">${goods.price}</span>
            </div>
            <#if login && !isSeller>
                <div>
                    <ul class="btn-numbox">
                        <li><span class="number">购买数量:</span></li>
                        <li>
                            <ul class="count">
                                <li><span id="num-jian" class="num-jian" onclick="subtractNum()">-</span></li>
                                <li><input type="text" class="input-num" id="purchase-num" value="0" /></li>
                                <li><span id="num-jia" class="num-jia" onclick="addNum()">+</span></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </#if>
            <#if login>
                <div class="oprt f-cb">
                    <#if isSeller>
                        <a href="/SaleSystem/edit?goodsId=${goods.id}" class="u-btn u-btn-primary">编 辑</a>
                    <#else>
                        <#if goods.isBought>
                            <span class="u-btn u-btn-primary z-dis">已购买</span>
                            <span class="buyprice">当时购买价格：¥${goods.buyRecord.buyPrice}</span>
                        <#else>
                            <button class="u-btn u-btn-primary" id="purchase_button" onclick="addToCart(${goods.id})">加入购物车</button>
                        </#if>
                    </#if>
                </div>
            </#if>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        <#list "${goods.detail}"?split(";") as url>
            <div class="img"><img src="${url}" alt="" align="middle"></div>
        </#list>
    </div>
</div>
<#include "include/footer.ftl">
</body>
</html>