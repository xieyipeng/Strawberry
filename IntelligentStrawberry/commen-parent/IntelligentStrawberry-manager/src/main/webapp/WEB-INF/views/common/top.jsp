<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/8/29
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>智能草莓园 - 后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">

    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script>


    </script>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">智能草莓园</div>
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="../../../index.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <%--        <ul class="layui-nav layui-layout-right">--%>
        <%--            <li class="layui-nav-item">--%>
        <%--                <a href="javascript:;">--%>
        <%--                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">--%>
        <%--                    贤心--%>
        <%--                </a>--%>
        <%--                <dl class="layui-nav-child">--%>
        <%--                    <dd><a href="">基本资料</a></dd>--%>
        <%--                    <dd><a href="">安全设置</a></dd>--%>
        <%--                </dl>--%>
        <%--            </li>--%>
        <%--            <li class="layui-nav-item"><a href="">退出</a></li>--%>
        <%--        </ul>--%>
    </div>
    <%-- 左侧导航区域 --%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="../../../index.jsp">系统概览</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-admin-home.do">管理员表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-farm-home.do">草莓园表</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">照片展示</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-gallery1.do">一号草莓园</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-gallery2.do">二号草莓园</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-gallery3.do">三号草莓园</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-gallery4.do">四号草莓园</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-gallery5.do">五号草莓园</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/page-jump/to-gallery6.do">六号草莓园</a></dd>
                    </dl>
                </li>

                <li id="topological-graph" class="layui-nav-item"><a href="http://192.168.0.1/strawberry.html">拓扑图</a>
                <li id="control" class="layui-nav-item"><a href="${pageContext.request.contextPath}/page-jump/to-control.do">控制</a>

                </li>
            </ul>
        </div>
    </div>

