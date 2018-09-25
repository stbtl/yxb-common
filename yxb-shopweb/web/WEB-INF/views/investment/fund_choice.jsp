<div class="pure-g itop">
    <div class="pure-u-1-24 idiv_left">&nbsp;＜</div>
    <div class="pure-u-23-24"><input id="fundCode" type="text" placeholder="基金名称/代码/缩写" /></div>
</div>
<form class="pure-form">
    <div class="pure-control-group">
        <div class="pure-g">
            <div class="pure-u-1-1">
                <span class="ifont2">历史记录</span>
            </div>
        </div>
        <div class="pure-g" style="padding: 10px 0;">
            <div class="pure-u-1-1">
                <span class="ifont6" style="background-color: #F4F4F4; color:#DDDDDD; padding: 5px 0;" onclick="gotoProduct_detail()">天弘中证500指数（000657）</span>
            </div>
        </div>
    </div>
    <div class="pure-control-group">
        <div class="pure-g">
            <div class="pure-u-1-1">
                <span class="ifont2">热销基金</span>
            </div>
        </div>
        <div class="pure-g">
            <div class="pure-u-1-3" onclick="gotoProduct_detail_add()">
                <div>上证300ETF</div>
                <div>000475</div>
            </div>
            <div class="pure-u-1-3">
                <div>10.01%</div>
                <div>近1年收益</div>
            </div>
            <div class="pure-u-1-3">加入自选</div>
        </div>
    </div>
</form>
<script>
    function gotoProduct_detail_add() {
        window.location.href = "investment/product_detail_add";
    }
</script>
