<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/8/25
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user</title>

    <meta charset="UTF-8">

    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/Styles/bridging.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script>

        function clooos() {
            alert("成功")
        }

    </script>

</head>
<body class="layui-layout-body">
<form method="post" id="userForm" action="${pageContext.request.contextPath}/user/insertUser.do">

    <br>

    <div class="specificPageEdit" style="*position: static;">
        <div class="form">

            <div class="hide_tab fix" data-tab="tab_1" id="tab_1">
                <div id="MainContent_UpdatePanel1">
                    <table border="0" cellpadding="0" cellspacing="6" align="center">

                        <tr>
                            <td class="input_text tar">id：</td>
                            <td>
                                <p>
                                    <input name="id" type="text" value="" id="id" style="width: 150px;"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="input_text tar">用户名：</td>
                            <td>
                                <p>
                                    <input name="username" type="text" value="" id="username" style="width: 150px;"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="input_text tar">密码：</td>
                            <td>
                                <p>
                                    <input name="password" type="text" value="" id="password" style="width: 150px;"/>
                                </p>
                            </td>

                        </tr>
                    </table>
                </div>
            </div>

            <br>

            <div class="demoTable" align="center">
                <button class="layui-btn layui-btn-sm" type="submit">提交</button>

            </div>

        </div>
    </div>
</form>
</body>
</html>
