<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/9/5
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String get_i = "\'http://localhost:8080/farm/select_i.do\'";

%>

<jsp:include page="../common/top.jsp"/>

<!-- 内容主体区域 -->
<div class="layui-body" id="banner" style="margin-top: 5px;margin-left: 50px">

</div>

<script src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
<script>

    var data = {
        "StrawberryFram_farm_id": 2
    };

    $.ajax({
        type: "POST",
        async: true, //异步请求
        url: <%=get_i%>,
        data: data,
        dataType: "json",
        success: function (result) {
            size = result.length;
            for (var i = 0; i < result.length; i++) {
                var myParent = document.getElementById("banner");
                var myImage = document.createElement("img");

                var temp = result[i].strawberryFram_picture;
                for (var j = 0; j < temp.length; j++) {
                    if (temp.charAt(j) === '\\') {
                        temp = temp.substr(0, j) + "/" + temp.substr(j + 1);
                    }
                }

                myImage.src = "http://127.0.0.1:81" + temp;
                myImage.style.margin = "10px";
                myImage.style.cssText += 'text-align:center';
                myImage.width=300;



                myParent.appendChild(myImage);
            }
        }
    });

</script>




<jsp:include page="../common/bottom.jsp"/>
