<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/8/28
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="WEB-INF/views/common/top.jsp"/>

<div class="layui-body" style="margin-top: 5px;margin-left: 5px">

    <div id="monitor-charts" style="width:100%;height:400px;padding-top: 30px;"></div>

</div>

<script src="static/echarts/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('monitor-charts'));
    var tem = [];
    var hum = [];
    var tim = [];


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option = {
        title: {
            text: '传感器实时数据'
        },
        tooltip: {},
        legend: {
            data: ['温度', '湿度']
        },
        xAxis: [{
            type: 'category',
            boundaryGap: false,
            data: []
        }],
        yAxis: {
            // type: 'value'
        },
        series: [{
            name: '温度',
            type: 'line',
            smooth: true,
            data: []
        },
            {
                name: '湿度',
                type: 'line',
                smooth: true,
                data: []
            }]
    });


    $.ajax({
        type: "POST",
        async: true, //异步请求:同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行
        url: "http://localhost:8080/monitor/findAll.do",
        data: {},
        dataType: "json",
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                tem.push(result[i].monitor_temperature);
                hum.push(result[i].monitor_humidity);
                tim.push(result[i].monitor_time);
            }
            myChart.setOption({
                xAxis: [{
                    data: tim
                }
                ],

                series: [{
                    name: '温度',
                    type: 'line',
                    data: tem
                }, {
                    name: '湿度',
                    type: 'line',
                    data: hum
                }]
            })
        }
    })

    // var $=layui.jquery;
    // $.getJSON("http://localhost:8080/monitor/findAll.do", function (res) {
    //     console.log("nihao");
    //     console.log(res)
    //     // myChart.setOption({
    //     //     xAxis: {
    //     //         data: res.tim
    //     //     },
    //     //     series: [{
    //     //         data: res.tem
    //     //     }
    //     //     ]
    //     // });
    // });

    // this.$.get("http://localhost:8080/monitor/findAll.do", function (res) {
    //     console.log("nihao");
    //     console.log(res)
    // })


</script>

<jsp:include page="WEB-INF/views/common/bottom.jsp"/>