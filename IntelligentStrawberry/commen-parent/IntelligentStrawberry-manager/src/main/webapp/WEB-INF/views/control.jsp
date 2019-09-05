<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/9/5
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xieyipeng.IntelligentStrawberry.web.controller.tools.Constant" %>

<script src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>

<jsp:include page="common/top.jsp"/>

<!-- 内容主体区域 -->
<div id="banner" class="layui-body" style="margin: 10px">
    <br>
    <br>
    <br>
    <br>
    <form class="layui-form">
        <div class="layui-form-item layui-form">
            <div class="layui-input-block">
                <input id="light" type="checkbox" name="light" title="光照">
                <input id="fan" type="checkbox" name="fan" title="风扇">
                <input id="humidifier" type="checkbox" name="humidifier" title="加湿器">
            </div>
        </div>
        <br>
        <div class="layui-form-item layui-form" style="padding-left: 60px">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="control(this)">控制</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script>

    var light = 0x01; //光照
    var fan = 0x02; //风扇
    var humidifier = 0x04; //加湿器

    layui.use('form', function () {
        var form = layui.form;
        form.render();

        form.on('checkbox(filter)', function (data) {
            console.log(data.elem); //得到checkbox原始DOM对象
            console.log(data.elem.checked); //是否被选中，true或者false
            console.log(data.value); //复选框value值，也可以通过data.elem.value得到
            console.log(data.othis); //得到美化后的DOM对象
        });
    });

    function control(btn) {

        var check_light=document.getElementById("light");
        var check_fan=document.getElementById("fan");
        var check_humidifier=document.getElementById("humidifier");
        var res=0x00;
        if (check_light.checked){
            res=res+light;
        }
        if (check_fan.checked){
            res=res+fan;
        }
        if (check_humidifier.checked){
            res=res+humidifier;
        }

        $.ajax({
            async: true,
            url: "http://192.168.0.1/cgi-bin/send_node.cgi",
            dataType: "json",
            data: {'type': 11, 'id': 3, 'data': res},
            timeout: 4000,
            context: btn,
            success: function (json) {

            },
            error: function (xhr) {

            }
        });
    }


</script>


<jsp:include page="common/bottom.jsp"/>
