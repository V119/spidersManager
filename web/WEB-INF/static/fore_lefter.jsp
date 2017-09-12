<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-th"></i>分析</a>
    <ul style="display: block;background: #2E363F;height: 800px;">
        <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i>
            <span>事件列表</span></a></li>
        <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i>
            <span>事件趋势</span></a></li>
        <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-signal"></i> <span>热点词</span></a></li>
        <li><a href="sourceWebsiteStatistics?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-inbox"></i> <span>媒体来源分析</span></a></li>
        <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i
                class="icon icon-th"></i> <span>文章传播</span></a></li>
        <li><a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-inbox"></i> <span>事件走势</span></a></li>
        <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
        <li><a href="authorIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-fullscreen"></i> <span>发布者指标</span></a></li>
        <li><a href="sentiment?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-signal"></i><span>舆情影响力</span></a></li>
        <li><a href="participant?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-tint"></i><span>网民参与度</span></a></li>
        <li><a href="negativeIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-home"></i><span>舆情负面指数</span></a></li>
        <li><a href="db_scan" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-home"></i><span>db scan算法</span></a></li>
        <li><a href="dp" style="font-family: 新宋体;font-size: 18px;"><i
                class="icon icon-home"></i><span>dp</span></a></li>

        <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>
            <%--<ul>--%>
        <%--<li><a href="publish.html" style="font-family: 新宋体;font-size: 18px;">博主分析</a></li>--%>
        <%--<li><a href="sex.html" style="font-family: 新宋体;font-size: 18px;">男女比例</a></li>--%>
        <%--<li><a href="count.html" style="font-family: 新宋体;font-size: 18px;">统计</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="hotCorePeople.jsp" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>核心传播人</span></a></li>--%>
        <%--<li><a href="hotInformation.jsp" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-pencil"></i><span>热门信息</span></a></li>--%>
        <%--<li><a href="data.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-file"></i><span>数据类型</span></a></li>--%>
        <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-info-sign"></i> <span>发布</span> <span class="label label-important">3</span></a>--%>
        <%--<ul>--%>
        <%--<li><a href="weibo.html" style="font-family: 新宋体;font-size: 18px;">微博分布</a></li>--%>
        <%--<li><a href="area.html" style="font-family: 新宋体;font-size: 18px;">地域分布</a></li>--%>
        <%--<li><a href="device.html" style="font-family: 新宋体;font-size: 18px;">设备分布</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
    </ul>
</div>
<!--sidebar-menu-->
