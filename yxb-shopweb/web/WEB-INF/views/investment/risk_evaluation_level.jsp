<div class="pure-g itop">
    <div class="pure-u-1-1">风险评测等级</div>
</div>
<form class="pure-form">
    <div class="pure-g idiv_c1">
        <div class="pure-u-1-1">
            您的风险等级类型为：<span class="ifont1">${customer.risk_level_type}</span>
        </div>
    </div>
    <div class="pure-g idiv_center">
        <div class="pure-u-1-1">
            <img src="${pageContext.request.contextPath}/resources/vendor/img/phx.png" />
        </div>
    </div>
    <div class="pure-g">
        <div class="pure-u-1-1">
            <table class="pure-table itable1">
                <tbody>
                    <tr>
                        <td>风险承受能力：<span class="icolor_red">${customer.risk_tolerance}</span></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="pure-g idiv_center">
        <div class="pure-u-1-2"><a class="pure-button ibutton" href="investment/intelligent_optional">我要自选</a></div>
        <div class="pure-u-1-2"><a class="pure-button ibutton" href="investment/intelligent_investment_choice">一键智投</a></div>
    </div>
</form>
<script>
    $(function(){
        alert(${customer.customerId});

    });
</script>
