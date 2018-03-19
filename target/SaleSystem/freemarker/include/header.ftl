<header class="header">
    <div class="header-inner body-width">
        <a href="#" class="logo"></a>
        <#if !logining>
            <nav class="header-nav">
                <ul>
                    <#if login>
                        <li>
                            <a href="#" >您好，${userName}</a>
                            <span class="line"></span>
                        </li>
                        <#if isInCartPage>
                            <li>
                                <a  class="icon-text__pink register" onclick="history.go(-1);">退出</a>
                            </li>
                        <#else>
                            <#if isSeller>
                                <li>
                                    <a href="/SaleSystem/homePage" class="icon-text__pink register">首页</a>
                                    <span class="line"></span>
                                </li>
                                <li>
                                    <a href="/SaleSystem/public" class="icon-text__pink register">发布</a>
                                    <span class="line"></span>
                                </li>
                                <li>
                                    <a href="/SaleSystem/signout" class="icon-text__pink register">退出</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/SaleSystem/homePage" class="icon-text__pink register">首页</a>
                                    <span class="line"></span>
                                </li>
                                <li>
                                    <a href="/SaleSystem/account" class="icon-text__pink register">财务</a>
                                    <span class="line"></span>
                                </li>
                                <li>
                                    <a href="/SaleSystem/cart/show" class="icon-text__pink register">购物车</a>
                                    <span class="line"></span>
                                </li>
                                <li>
                                    <a href="/SaleSystem/signout" class="icon-text__pink register">退出</a>
                                </li>
                            </#if>
                        </#if>
                    <#else>
                        <li>
                            <span class="line"></span>
                            <a href="/SaleSystem/login" class="icon-text__pink register">登录</a>
                            <span class="line"></span>
                        </li>
                    </#if>
                </ul>
            </nav>
        </#if>
    </div>
    <div class="header-shadow"></div>
</header>