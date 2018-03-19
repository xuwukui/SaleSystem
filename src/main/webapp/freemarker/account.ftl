<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>财务</title>
<#include "include/common.ftl">
</head>
<body>
<#include "include/header.ftl">
<#assign total = 0>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>账单</h2>
    </div>
<#if !accountList?has_content>
    <div class="n-result">
        <h3>您的目前没有消费记录！</h3>
    </div>
<#else>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
        <thead>
        <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
        </thead>
        <tbody>
            <#list accountList as x>
                <#assign total = total + x.buyPrice * x.buyNum>
            <tr>
                <td><a href="/SaleSystem/detail?goodsId=${x.goodsId}"><img src="${x.goodsInfo.pictureUrl}" alt=""></a></td>
                <td><h4><a href="/SaleSystem/detail?goodsId=${x.goodsId}">${x.goodsInfo.title}</a></h4></td>
                <td><span class="v-time">${x.buyTime}</span></td>
                <td><span class="v-time goodsBuyNum">${x.buyNum}</span></td>
                <td><span class="v-unit">¥</span><span class="value">${x.buyPrice}</span></td>
            </tr>
            </#list>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4"><div class="total">总计：</div></td>
            <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
        </tr>
        </tfoot>
    </table>
</#if>
</div>
<#include "include/footer.ftl">
</body>
</html>