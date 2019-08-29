<%--
  Created by IntelliJ IDEA.
  User: xieyipeng
  Date: 2019/8/29
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String insertMonitor = "\'http://localhost:8080/monitor/insertMonitor.do\'";
%>


<%-- 底部区域 --%>
<div id="footer_insert_monitor" class=" layui-footer">
    <blockquote id="insert-monitor" class="layui-elem-quote layui-quote-nm">点击，开始采集数据</blockquote>
</div>

<script>
    var flag = 1;
    layui.use('layer', function () {
        var layer = layui.layer;
        var $ = layui.jquery;
        $(document).on('click', '#insert-monitor', function () {
            if (flag === 1) {
                layer.open({
                    title: '数据采集中...',
                    type: 2,
                    area: ['800px', '500px'],
                    // area: '400px',
                    content: <%=insertMonitor%>
                });
                flag = 0;
            } else {
                layer.msg("已经开始！")
            }
        });
    });

</script>
</div>
</body>
</html>

