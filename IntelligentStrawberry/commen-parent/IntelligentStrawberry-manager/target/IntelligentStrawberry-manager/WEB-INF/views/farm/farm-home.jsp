<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/9/5
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/html" id="table-bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<%
    String findAllFarm = "\'http://localhost:8080/farm/findAll.do\'";

%>


<jsp:include page="../common/top.jsp"/>


<!-- 内容主体区域 -->
<div class="layui-body" style="margin-top: 5px;margin-left: 5px">

    <div class="demoTable">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>

    <table class="layui-table" id="farm-table" lay-filter="test3"></table>

</div>


<script src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
<script>

    layui.use(['layer', 'table', 'element'], function () {
        var layer = layui.layer
            , table = layui.table //表格
            , element = layui.element;//元素操作

        layer.msg("已停止采集感器数据！");

        //执行一个 table 实例
        table.render({
            elem: '#farm-table'
            , height: 500
            , url:<%=findAllFarm%>
            , title: '用户表'
            , id: 'testReload'
            , page: true //开启分页
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度
            , toolbar: 'default'  //开启工具栏，此处显示默认图标
            , defaultToolbar: ''
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {id: 'test3', field: 'strawberryFram_id', title: 'ID', sort: true, fixed: 'left'}
                , {id: 'test3', edit: 'text', field: 'strawberryFram_farm_id', title: '农场ID'}
                , {id: 'test3', edit: 'text', field: 'strawberryFram_price', title: '价格'}
                , {id: 'test3', edit: 'text', field: 'strawberryFram_address', title: '地址'}
                , {id: 'test3', edit: 'text', field: 'strawberryFram_variety_of_strawberry', title: '草莓种类'}
                , {id: 'test3', edit: 'text', field: 'strawberryFram_picture', title: '图片'}
                , {id: 'test3', edit: 'text', field: 'strawberryFram_time', title: '创建时间'}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#table-bar'}
            ]]
        });
    });

</script>


<jsp:include page="../common/bottom.jsp"/>
