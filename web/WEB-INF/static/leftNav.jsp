<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/7
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--BEGIN SIDEBAR MENU-->
<nav id="sidebar" role="navigation" data-step="2" data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
     data-position="right" class="navbar-default navbar-static-side" style="min-height: 100%;">
    <div class="sidebar-collapse menu-scroll">
        <ul id="side-menu" class="nav">
            <div class="clearfix"></div>
            <li class="active"><a href="eventsList"><i class="fa fa-th-list fa-fw"><%--<i class="fa fa-tachometer fa-fw">--%>
                <div class="icon-bg bg-orange"></div>
            </i><span class="menu-title">事件列表</span></a></li>

            <li><a href="event?eventID=${eventID}"><i class="fa fa-desktop fa-fw">
                <div class="icon-bg bg-pink"></div>
            </i><span class="menu-title">事件趋势</span></a>
            </li>
            <li><a href="hotWords?eventID=${eventID}"><i class="fa fa-send-o fa-fw">
                <div class="icon-bg bg-green"></div>
            </i><span class="menu-title">热点词</span></a>

            </li>
            <li><a href="#"><i class="fa fa-edit fa-fw">
                <div class="icon-bg bg-violet"></div>
            </i><span class="menu-title">媒体来源分析</span></a>

            </li>
            <li><a href="articleSpread?eventID=${eventID}"><i class="fa fa-th-list fa-fw">
                <div class="icon-bg bg-blue"></div>
            </i><span class="menu-title">文章传播</span></a>

            </li>
            <li><a href="eventTrend?eventID=${eventID}"><i class="fa fa-bar-chart-o fa-fw">
                <div class="icon-bg bg-red"></div>
            </i><span class="menu-title">事件走势</span></a>

            </li>
            <li><a href="hotInformation?eventID=${eventID}"><i class="fa fa-envelope-o">
                <div class="icon-bg bg-yellow"></div>
            </i><span class="menu-title">热门信息</span></a>

            </li>
            <li><a href="sentiment?eventID=${eventID}"><i class="fa fa-gift fa-fw">
                <div class="icon-bg bg-grey"></div>
            </i><span class="menu-title">舆情影响力</span></a>

            </li>
            <li><a href="participant?eventID=${eventID}"><i class="fa fa-sitemap fa-fw">
                <div class="icon-bg bg-dark"></div>
            </i><span class="menu-title">网民参与度</span></a>

            </li>
            <li><a href="negativeIndex?eventID=${eventID}"><i class="fa fa-envelope-o">
                <div class="icon-bg bg-primary"></div>
            </i><span class="menu-title">舆情负面指数</span></a>
            </li>
            <li><a href="authorIndex"><i class="fa fa-bar-chart-o fa-fw">
                <div class="icon-bg bg-primary"></div>
            </i><span class="menu-title">发布者影响力和活跃度</span></a>
            </li>
            <li><a href="explore?eventID=${eventID}"><i class="fa fa-bar-chart-o fa-fw">
                <div class="icon-bg bg-primary"></div>
            </i><span class="menu-title">引爆点</span></a>
            </li>
            <li><a href="dp"><i class="fa fa-sitemap fa-fw">
                <div class="icon-bg bg-primary"></div>
            </i><span class="menu-title">dp聚类</span></a>
            </li>

        </ul>
    </div>
</nav>
<!--END SIDEBAR MENU-->
