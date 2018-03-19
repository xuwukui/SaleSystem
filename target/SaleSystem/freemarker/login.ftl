<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>登陆</title>
    <#include "include/common.ftl">
    <script src="../SaleSystem/js/pageLogin.js"></script>
    <script src="../SaleSystem/js/md5.js"></script>
</head>
<body>
<#include "include/header.ftl">
<form class="m-form m-form-ht n-login" id="loginForm" action="/SaleSystem/logining" method="post" autocomplete="off">
    <div class="fmitem">
        <label class="fmlab ">用户名：</label>
        <div class="fmipt xwk-input">
            <input class="u-ipt xwk-input"  name="userName" autofocus/>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密&nbsp;&nbsp;码：</label>
        <div class="fmipt xwk-input">
            <input class="u-ipt xwk-input" type="password" name="password"/>
        </div>
    </div>
    <#if !success>
        <div class="msg">${errorMsg}</div>
    </#if>
    <div>
        <button type="button" id="login_submit" class="u-btn u-btn-primary u-btn-lg u-btn-block xwk-btn">登 录</button>
    </div>
    <#--<div class="fmitem fmitem-nolab fmitem-btn">-->
        <#--<div class="fmipt">-->
            <#--<button type="button" id="login_submit" class="u-btn u-btn-primary u-btn-lg u-btn-block xwk-btn">登 录</button>-->
        <#--</div>-->
    <#--</div>-->
</form>
<#include "include/footer.ftl">
</body>
</html>