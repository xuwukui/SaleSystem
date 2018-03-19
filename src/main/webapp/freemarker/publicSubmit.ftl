<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>发布提交结果</title>
<#include "include/common.ftl">
</head>
<body>
<#include "include/header.ftl">
<div class="g-doc">
    <#if success>
    <div class="n-result">
        <h3>发布成功！</h3>
        <div>
            <a href="/SaleSystem/detail?goodsId=${goodsId}" style="margin-top:10px ">[查看内容]</a>
            <a href="/SaleSystem/homePage">[返回首页]</a>
        </div>
    </div>
    <#else>
    <div class="n-result">
        <h3>发布失败！</h3>
        <div>
            <a href="/SaleSystem/public" style="margin-top:10px ">[重新发布]</a>
            <a href="/SaleSystem/homePage">[返回首页]</a>
        </div>
    </div>
    </#if>
</div>
<#include "include/footer.ftl">
</body>
</html>