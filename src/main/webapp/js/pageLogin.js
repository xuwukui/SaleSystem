$(document).ready(function(){
    $('#login_submit').click(function () {
        var username = $("input[name='userName']").val();
        var password = $("input[name='password']").val();
        if(username.trim() === "" || password.trim() === ""){
            alert("用户和密码不能为空!");
            return false;
        }
        $("input[name='password']").val(hex_md5(password).toUpperCase());
        $("#loginForm").submit();
        //$.post("/SaleSystem/logining",{userName:username,password:password});
    });
});
