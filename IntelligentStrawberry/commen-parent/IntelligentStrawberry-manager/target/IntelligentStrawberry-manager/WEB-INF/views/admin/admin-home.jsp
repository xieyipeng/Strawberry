<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/8/28
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String findAllAdmin = "\'http://localhost:8080/admin/findAllAdmin.do\'";
    String insertUserJSP = "\'http://localhost:8080/user/insertUserJSP.do\'";
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

    <table class="layui-hide" id="admin-table" lay-filter="test"></table>


    <script type="text/html" id="table-bar">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

</div>

<script>
    layui.use(['layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var layer = layui.layer
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider; //滑块


        // 向世界问个好
        layer.msg('Hello World');

        //监听Tab切换
        element.on('tab(admin-table)', function (data) {
            layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                tips: 1
            });
        });

        //执行一个 table 实例
        table.render({
            elem: '#admin-table'
            , height: 420
            , url:<%=findAllAdmin%>
            , title: '用户表'
            , id: 'testReload'
            , page: true //开启分页
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度
            , toolbar: 'default'  //开启工具栏，此处显示默认图标
            , defaultToolbar: ''
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'admin_id', title: 'ID', sort: true, fixed: 'left'}
                , {field: 'admin_username', title: '姓名'}
                , {field: 'admin_password', title: '密码'}
                , {field: 'admin_telephone', title: '联系电话'}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#table-bar'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title: '添加管理员',
                        type: 2,
                        // area: ['500px', '500px'],
                        area: '400px',
                        content: <%=insertUserJSP%>,//这是 URL，直接发送的这个请求controller会接受到并返回userList页面。也就是弹出来的页面
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



        // $(document).on('click','#page-index',function () {
        //     alert("nihao")
        // })

    })
    ;

</script>


<jsp:include page="../common/bottom.jsp"/>

