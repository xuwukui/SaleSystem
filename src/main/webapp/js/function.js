function addToCart(goodsId){
    if(confirm("是否将此商品加入购物车？")){
        data={};
        data["goodsId"] = Number(goodsId);
        data["buyNum"] = Number($("#purchase-num").val());
        data["buyPrice"] = Number($("#goodsPriceNow").html());
        // var url = "/SaleSystem/cart/add?" + "goodsId=" +  goodsId + "&buyNum=" +  $("#purchase-num").val() + "&buyPrice=" +  $("#goodsPriceNow").val();
        $.post("/SaleSystem/cart/add",data);
    }
}

function subtractNum(){
    var num = Number($("#purchase-num").val());
    if(num >= 1) {
        $("#purchase-num").val(num - 1);
    }
}

function addNum() {
    $("#purchase-num").val(Number($("#purchase-num").val()) + 1);
}

function balance(){
    goodsIdList=[];
    buyNumList=[];
    $('.goodsId-hidden').each(function() {
        var $this = $(this);
        goodsIdList.push(Number($this[0].innerText));
    });
    $('.goodsBuyNum').each(function() {
        var $this = $(this);
        buyNumList.push(Number($this[0].innerText));
    });
    console.log(goodsIdList);
    console.log(buyNumList);
    $.post("/SaleSystem/cart/balance",{
        goodsIdList:JSON.stringify(goodsIdList),
        buyNumList:JSON.stringify(buyNumList)
    },function (data,status) {
        location.reload();
    });
}

function checkPublic(){
    return true;
}

function checkEdit(){
    return true;
}

function  deleteGoods(goodsId) {
    $.post("/SaleSystem/delete?goodsId=" + goodsId,function (data,status) {
        location.reload();
    })
}
