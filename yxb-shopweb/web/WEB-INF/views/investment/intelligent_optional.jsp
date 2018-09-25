<div class="pure-g itop">
    <div class="pure-u-1-1">智能自选</div>
</div>
<form class="pure-form">
    <div class="pure-g idiv_center" style="padding: 50px 10px 0;">
        <div class="pure-u-1-1">
            <img src="${pageContext.request.contextPath}/resources/vendor/img/add.png" />
        </div>
    </div>
    <div class="pure-g idiv_center">
        <div class="pure-u-1-1">
            选择基金，创建组合
        </div>
    </div>
</form>
<script>
    $("img").click(function(){
       window.location.href = "investment/fund_choice";
    });
</script>
