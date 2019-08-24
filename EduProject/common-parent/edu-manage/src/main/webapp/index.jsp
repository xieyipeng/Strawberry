<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">


    <%
        String getAllUser = "\'http://localhost:8080/user/findAllUser.do\'";
    %>


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">

                <li class="layui-nav-item"><a href="">用户信息</a></li>


                <%--<li class="layui-nav-item layui-nav-itemed">--%>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="margin-top: 5px;margin-left: 5px">
        <!-- 内容主体区域 -->

        <div class="demoTable">
            搜索ID：
            <div class="layui-inline">
                <input class="layui-input" name="id" id="demoReload" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <table class="layui-hide" id="demo" lay-filter="test"></table>

        <script type="text/html" id="barDemo">
            <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>--%>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider; //滑块

        // 向世界问个好
        // layer.msg('Hello World');

        //监听Tab切换
        element.on('tab(demo)', function (data) {
            layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                tips: 1
            });
        });

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 420
            , url:<%=getAllUser%>//数据接口
            , title: '用户表'
            , id: 'testReload'
            , page: true //开启分页
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            // ,totalRow: true //开启合计行
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', sort: true, fixed: 'left'}
                , {field: 'username', title: '姓名'}
                // ,{field: 'gender', title: '性别',  sort: true, edit: 'text'}
                // ,{field: 'number', title: '号码',  sort: true, edit: 'text'}
                , {field: 'password', title: '密码'}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title: '添加用户',
                        type: 2,
                        area: ['500px', '500px'],
                        content: 'http://localhost:8080/user/addUser',//这是 URL，直接发送的这个请求controller会接受到并返回userList页面。也就是弹出来的页面
                        // btn : ['确定'] ,
                        yes: function (index, layero) {
                            layer.close(index);
                        }

                    });
                    // layer.msg('添加');
                    break;

                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            }
            ;
        });


        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值

            if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url: '${ctx}/user/delete/',
                        type: 'post',
                        data: data,
                        success: function (data) {
                            var msg = data.msg;
                            layer.msg(msg);
                        }
                    });
                });
            } else if (layEvent === 'edit') {
                $.ajax({
                    url: '${ctx}/user/update',
                    type: 'post',
                    data: data,
                    success: function (data1) {
                        if (data1 == '1') {
                            layer.msg('编辑成功');
                        } else {
                            layer.msg('编辑失败');
                        }
                    }
                })
            }
        });

        var $ = layui.$, active = {
            reload: function () {
                var textdemo = $('#demoReload').val();
                table.reload('textreload', {
                    url: 'http://localhost:8080/user/search',
                    method: 'get',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    },
                    where: {
                        key: textdemo
                    }
                })
            }
        }

        $('.chu.layui-btn').on('click', function () {
            var type = $(this).data('type');
            if ($('#textdemo').val() == "") {
                layer.msg('查询项目不能为空');
                return false;
            }
            active[type] ? active[type].call(this) : '';
        });

    });
</script>
</body>
</html>