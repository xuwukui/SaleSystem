<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>编辑提交结果</title>
<#include "include/common.ftl">
</head>
<body>
<#include "include/header.ftl">
<div class="g-doc">
    <#if success>
    <div class="n-result">
        <h3>编辑成功！</h3>
        <div>
            <a href="/SaleSystem/detail?goodsId=${goodsId}" style="margin-top:10px ">[查看内容]</a>
            <a href="/">[返回首页]</a>
        </div>
    </div>
    <#else>
    <div class="n-result">
        <h3>编辑失败！</h3>
        <div>
            <a href="/SaleSystem/edit?goodsId=${goodsId}" style="margin-top:10px ">[重新编辑]</a>
            <a href="/">[返回首页]</a>
        </div>
    </div>
    </#if>
</div>
<#include "include/footer.ftl">
</body>
</html>