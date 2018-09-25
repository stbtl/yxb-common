<div class="pure-g itop">
    <div class="pure-u-1-1">组合详情</div>
</div>
<form class="pure-form">
    <div class="pure-g idiv_center">
        <div class="pure-u-1-1 ifont4">恭喜您！开启智能投资之路</div>
    </div>
    <div class="pure-g">
        <div class="pure-u-1-1 ifont2">组合信息</div>
    </div>
    <div class="pure-g">
        <div id="pie" class="pure-u-1-2" style="width: 10rem;height:10rem;"></div>
        <div class="pure-u-1-2" >
            <table class="pure-table pure-table-no-border">
                <tbody>
                    <tr>
                        <td>股票类</td>
                        <td>75%</td>
                    </tr>
                    <tr>
                        <td>另类及其他类</td>
                        <td>5%</td>
                    </tr>
                    <tr>
                        <td>固定收益</td>
                        <td>10%</td>
                    </tr>
                    <tr>
                        <td>现金及货币类</td>
                        <td>10%</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="pure-g">
        <div class="pure-u-1-1 ifont2">智能预估</div>
    </div>
    <div class="pure-g">
        <div id="line" class="pure-u-1-1" style="width: 20rem;height:20rem;"></div>
    </div>
    <div class="pure-g">
        <div class="pure-u-1-1 ifont2">组合策略</div>
    </div>
    <div class="pure-g" style="padding: 0.5rem 0;">
        <div class="pure-u-1-1 ifont6">采用约定交易实现大类资产动态平衡策略</div>
    </div>
    <div id="close" class="pure-control-group">
        <div class="pure-g">
            <div class="pure-u-1-1 ifont2">查看组合详情</div>
        </div>
        <div class="pure-g" style="padding: 0.5rem 0;">
            <div class="pure-u-1-1 ifont6">风险提示：过往业绩并不能预示其未来的表现，也不构成本组合业绩表现的保证。市场有风险，投资需谨慎。</div>
        </div>
    </div>
    <div id="open" class="pure-control-group" style="display: none;">
        <div class="pure-g">
            <div class="pure-u-1-1 ifont2">组合详情</div>
        </div>
        <div class="pure-g idiv_center" style="background-color: #F2F2F2;">
            <div class="pure-u-1-1">股票类 75%</div>
        </div>
        <div id="a" class="pure-g">
            <div class="pure-u-3-4 idiv_left">ABC基金1</div>
            <div class="pure-u-1-4 idiv_right">10%</div>
        </div>
    </div>
    <div class="pure-g idiv_center">
        <div class="pure-u-1-1">
            <a class="pure-button ibutton" href="#">生成投资报告</a>
        </div>
    </div>
</form>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var pieChart = echarts.init(document.getElementById('pie'));

    // 指定图表的配置项和数据
    var pieOption = {
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius: '85%',
                label: {
                    normal: {
                        position: 'inner'
                    }
                },
                data:[
                    {value:75, name:'75%'},
                    {value:10, name:'10%'},
                    {value:5, name:'5%'},
                    {value:10, name:'10%'},
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    pieChart.setOption(pieOption);

    var lineChart = echarts.init(document.getElementById('line'));

    lineOption = {

        legend: {
            data:['本产品','沪深300']
        },
        xAxis:  {
            type: 'category',
            boundaryGap: false,
            data: ['3个月','6个月','一年','3年']
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value} %'
            }
        },
        series: [
            {
                name:'本产品',
                type:'line',
                data:[0.58, 0.63, 1.62, 0.99]
            },
            {
                name:'沪深300',
                type:'line',
                data:[0.58, 0.43, 0.33, -1.26]
            }
        ]
    };

    lineChart.setOption(lineOption);

    $("#close").click(function() {
        $("#close").hide();
        $("#open").show();
    });
    $("#a").click(function() {
        window.location.href = 'investment/product_detail?productId=1';
    });
</script>
