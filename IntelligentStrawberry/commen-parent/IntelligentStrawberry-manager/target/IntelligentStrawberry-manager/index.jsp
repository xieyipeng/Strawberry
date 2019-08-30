<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/8/28
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String insertMonitor = "\'http://localhost:8080/monitor/insertMonitor.do\'";
    String findAllMonitor = "\'http://localhost:8080/monitor/findAll.do\'";
    String findRecently = "\'http://localhost:8080/monitor/findRecently.do\'";
    String findRecentlyOne = "\'http://localhost:8080/monitor/findRecentlyOne.do\'";
%>


<jsp:include page="WEB-INF/views/common/top.jsp"/>

<div class="layui-body" style="margin-top: 5px;margin-left: 5px">

    <div id="monitor-charts-time" style="width:100%;height:400px;padding: 30px;"></div>

    <br>
    <br>

    <div id="monitor-charts-all" style="width:100%;height:400px;padding: 30px"></div>

</div>

<script src="static/echarts/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart_all = echarts.init(document.getElementById('monitor-charts-all'));
    var myChart_time = echarts.init(document.getElementById('monitor-charts-time'));

    var time_tim = [];
    var time_tem = [];
    var time_hum = [];

    /**
     * 实时数据 - 表格的构建
     */
    myChart_time.setOption(option = {
        title: {
            left: 'center',
            text: '\n传感器实时数据展示：'
        },
        tooltip: {},
        legend: {

            orient: 'vertical',//垂直布局
            x: 'left', //水平方向居左显示
            y: 'center', //垂直方向居中显示
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

    /**
     * 实时数据 - 最近20条数据的添加
     */
    $.ajax({
        type: "GET",
        async: true, //异步请求
        url: <%=findRecently%>,
        data: {},
        dataType: "json",
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                time_tem.push(result[i].monitor_temperature);
                time_hum.push(result[i].monitor_humidity);
                // time_tim.push(new Date(result[i].monitor_time));
                time_tim.push(result[i].monitor_time);
            }
            myChart_time.setOption({
                xAxis: [{
                    data: time_tim
                }
                ],
                series: [{
                    name: '温度',
                    type: 'line',
                    data: time_tem
                }, {
                    name: '湿度',
                    type: 'line',
                    data: time_hum
                }]
            })
        }
    });

    /**
     * 实时数据 - 间隔函数，添加数据
     */
    setInterval(function () {
        $.ajax({
            type: "GET",
            async: true, //异步请求
            url: <%=findRecentlyOne%>,
            data: {},
            dataType: "json",
            success: function (result) {
                for (var i = 0; i < result.length; i++) {
                    time_tem.push(result[i].monitor_temperature);
                    time_hum.push(result[i].monitor_humidity);
                    // time_tim.push(new Date(result[i].monitor_time));
                    time_tim.push(result[i].monitor_time);
                }
                // Date.parse(new Date())
                // result[i].monitor_time
                myChart_time.setOption({
                    xAxis: [{
                        data: time_tim
                    }],
                    series: [{
                        name: '温度',
                        type: 'line',
                        data: time_tem
                    }, {
                        name: '湿度',
                        type: 'line',
                        data: time_hum
                    }]
                });

            }
        });
    }, 1000);


    /**
     * 数据库中所有数据的显示
     */
    myChart_all.setOption(option = {
        title: {
            left: 'center',
            text: '所有数据数据展示：'
        },
        tooltip: {
            trigger: 'axis'//滚动条缩放数据
        },
        legend: {
            orient: 'vertical',//垂直布局
            x: 'left', //水平方向居左显示
            y: 'center', //垂直方向居中显示
            data: ['温度', '湿度']
        },
        // toolbox: {
        //     feature: {
        //         dataZoom: {
        //             yAxisIndex: 'none'
        //         },
        //         restore: {},
        //         saveAsImage: {}
        //     }
        // },
        dataZoom: [{
            type: 'slider',//图表下方的伸缩条
            show: true, //是否显示
            realtime: true, //拖动时，是否实时更新系列的视图
            start: 0, //伸缩条开始位置（1-100），可以随时更改
            end: 100 //伸缩条结束位置（1-100），可以随时更改
        }],
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

    /**
     * 所有传感器信息
     */
    $.ajax({
        type: "GET",
        async: true, //异步请求
        url: <%=findAllMonitor%>,
        data: {},
        dataType: "json",
        success: function (result) {
            var tem = [];
            var hum = [];
            var tim = [];
            for (var i = 0; i < result.length; i++) {
                tem.push(result[i].monitor_temperature);
                hum.push(result[i].monitor_humidity);
                tim.push(result[i].monitor_time);
            }
            myChart_all.setOption({
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
    });

    /**
     * 实时采集传感器
     */
    layui.use('layer', function () {
        var my_layer = layui.layer;
        /**
         * 间隔函数
         */
        setInterval(function () {
            $.ajax({
                type: "GET",
                async: true, //异步请求
                url: <%=insertMonitor%>,
                data: {},
                // dataType: "string",
                success: function (result) {
                    if (result === "success") {
                        console.log("monitor collect success")
                    } else {
                        console.log("monitor collect failed")
                    }
                }
            });
        }, 3000);
        my_layer.msg("实时采集传感器数据中。。。")

    });


</script>

<jsp:include page="WEB-INF/views/common/bottom.jsp"/>