<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/9/2
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理员</title>

    <meta charset="UTF-8">

    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/Styles/bridging.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">

</head>
<body>

<form method="post" id="userForm" action="${ctx}/admin/insert-admin.do">

    <br>

    <div class="specificPageEdit" style="*position: static;">
        <div class="form">

            <div class="hide_tab fix" data-tab="tab_1" id="tab_1">
                <div id="MainContent_UpdatePanel1">
                    <table border="0" cellpadding="0" cellspacing="6" align="center">


                        <tr>
                            <td class="input_text tar">用户名：</td>
                            <td>
                                <p>
                                    <input name="admin_username" type="text" value="" id="admin_username"
                                           style="width: 150px;"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="input_text tar">密码：</td>
                            <td>
                                <p>
                                    <input name="admin_password" type="password" value="" id="admin_password"
                                           style="width: 150px;"/>
                                </p>
                            </td>
                        </tr>

                        <tr>
                            <td class="input_text tar">电话：</td>
                            <td>
                                <p>
                                    <input name="admin_telephone" type="text" value="" id="admin_telephone"
                                           style="width: 150px;"/>
                                </p>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

            <br>

            <div class="demoTable" align="center">
                <button class="layui-btn layui-btn-sm" type="submit" onclick="sub()">提交</button>

            </div>

        </div>
    </div>
</form>

</body>
<script>

    /**
     * 关闭父页面的layer弹层
     */
    function sub() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index)
    }


</script>
</html>
