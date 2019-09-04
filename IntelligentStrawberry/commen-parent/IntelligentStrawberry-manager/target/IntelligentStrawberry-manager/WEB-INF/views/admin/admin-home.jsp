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
    String insertAdminJSP = "\'http://localhost:8080/admin/insert-admin-jsp.do\'";
    String deleteAdmin = "\'http://localhost:8080/admin/delete-admin.do\'";
    String updateAdmin = "\'http://localhost:8080/admin/update-admin.do\'";
%>
<script type="text/html" id="table-bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
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

    <table class="layui-hide" id="admin-table" lay-filter="test3"></table>

</div>

<script src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
<script>
    layui.use(['layer', 'table', 'element'], function () {
        var layer = layui.layer
            , table = layui.table //表格
            , element = layui.element;//元素操作

        layer.msg("已停止采集感器数据！");

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
                , {id: 'test3', field: 'admin_id', title: 'ID', sort: true, fixed: 'left'}
                , {id: 'test3', edit: 'text', field: 'admin_username', title: '姓名'}
                , {id: 'test3', edit: 'text', field: 'admin_password', title: '密码'}
                , {id: 'test3', edit: 'text', field: 'admin_telephone', title: '联系电话'}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#table-bar'}
            ]]
        });

        //监听单元格编辑
        table.on('edit(test3)', function (obj) {
            var value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
                , field = obj.field; //得到字段
            // var my_data = "{\"admin_id\":" + data.admin_id + "+,\"filed\":\"" + field + "\",\"value\":\"" + value + "\"}";

            var my_data = {
                "admin_id": data.admin_id,
                "filed": field,
                "value": value
            };

            $.ajax({
                url:<%=updateAdmin%>,
                type: 'post',
                data: my_data,
                dataType: "json",
                success: function (data) {
                    if (data === "success") {
                        layer.msg("编辑成功")
                    } else {
                        layer.msg("编辑失败")
                    }
                }
            });


            // layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });

        //监听头工具栏事件
        table.on('toolbar(test3)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title: '添加管理员',
                        type: 2,
                        area: '400px',
                        content: <%=insertAdminJSP%>,
                        /**
                         * 添加完毕，刷新列表显示
                         * 重新加载 windows
                         */
                        end: function () {
                            window.location.reload();
                        }

                    });
                    layer.msg("添加成功");
                    break;

                case 'update':
                    layer.msg("请直接点击单元格进行编辑");
                    break;
                case 'delete':
                    layer.msg("请直接点击单元格右侧进行删除");
                    break;
            }
        });

        //监听行工具事件
        table.on('tool(test3)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值

            if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    layer.close(index);
                    $.ajax({
                        url:<%=deleteAdmin%>,
                        type: 'post',
                        data: data,
                        success: function (data) {
                            if (data === "success") {
                                layer.msg("删除成功")
                            } else {
                                layer.msg("删除失败")
                            }
                        }
                    });
                    obj.del(); //删除对应行（tr）的DOM结构

                });
            } else if (layEvent === 'edit') {
                layer.msg("请直接点击单元格进行编辑")

            }
        });
    });

</script>


<jsp:include page="../common/bottom.jsp"/>

