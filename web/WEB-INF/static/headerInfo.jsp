<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/6
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--BEGIN THEME SETTING-->
<!--Header-part-->
<!--BEGIN TOPBAR-->
<div id="header-topbar-option-demo" class="page-header-topbar">
    <nav id="topbar" role="navigation" style="margin-bottom: 0;" data-step="3" class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <button type="button" data-toggle="collapse" data-target=".sidebar-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            <marquee behavior="alternate" direction="right">
                <style>
                    #test{animation:change 10s linear 0s infinite;font-size:18px;font-weight:700;}
                    @keyframes change{0%   {color:#333;}25%{color:#ff0;}50%{color:#f60;}75%{color:#cf0;}100% {color:#f00;}}
                </style>
                <h1 id="test" style="font-size: 24px;font-family: 黑体">舆情分析大平台</h1>
            </marquee></div>
        <div class="topbar-main"><a id="menu-toggle" href="#" class="hidden-xs"><i class="fa fa-bars"></i></a>

            <form id="topbar-search" action="" method="" class="hidden-sm hidden-xs">
                <div class="input-icon right text-white"><a href="#"><i class="fa fa-search"></i></a><input type="text" placeholder="搜索" class="form-control text-white"/></div>
            </form>

            <ul class="nav navbar navbar-top-links navbar-right mbn">
                <li class="dropdown topbar-user"><a data-hover="dropdown" href="clean_data" class="dropdown-toggle">&nbsp;<span class="hidden-xs"><i class="fa fa-slack fa-fw"></i>爬虫管理</span>&nbsp;<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-user pull-right">
                        <li><a href="form-wizard.jsp"><i class="fa fa-tachometer fa-fw"></i>现有爬虫展示</a></li>
                        <li><a href="addEvent"><i class="fa fa-edit fa-fw"></i>增加事件</a></li>
                        <li><a href="addNewSite"><i class="fa fa-edit fa-fw"></i>新增网站</a></li>
                        <li><a href="addNewSpider"><i class="fa fa-edit fa-fw"></i>新增爬虫</a></li>
                        <li><a href="form-validation.jsp"><i class="fa fa-edit fa-fw"></i>修改爬虫</a></li>
                        <li><a href="form-wizard.jsp"><i class="fa fa-user"></i>删除爬虫</a></li>
                        <li><a href="spiderConfig"><i class="fa fa-user"></i>配置爬虫</a></li>
                    </ul>
                </li>

                <li class="dropdown topbar-user"><a data-hover="dropdown" href="clean_data" class="dropdown-toggle">&nbsp;<span class="hidden-xs"><i class="fa fa-bar-chart-o fa-fw"></i>数据可视化</span>&nbsp;<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-user pull-right">
                        <li><a href="source_datas"><i class="fa fa-desktop fa-fw"></i>源数据库展示</a></li>
                        <li><a href="source_data"><i class="fa fa-desktop fa-fw"></i>数据清理展示</a></li>
                        <li><a href="source_datas_display"><i class="fa fa-desktop fa-fw"></i>源数据展示</a></li>
                        <li><a href="bbs_author?pageIndex=1&&type=bbs_china_author"><i class="fa fa-desktop fa-fw"></i>源数据展示-作者</a></li>
                        <li><a href="cleaned_datas"><i class="fa fa-desktop fa-fw"></i>数据清洗后数据展示</a></li>
                    </ul>
                </li>
                <li class="dropdown topbar-user"><a data-hover="dropdown" href="clean_data" class="dropdown-toggle">&nbsp;<span class="hidden-xs"><i class="fa fa-sitemap fa-fw"></i>数据清洗</span>&nbsp;<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-user pull-right">
                        <li><a href="#"><i class="fa fa-edit fa-fw"></i>新增清洗过程</a></li><%--calendar.jsp--%>
                        <li><a href="#"><i class="fa fa-user"></i>清洗过程配置</a></li><%--chat.jsp--%>
                        <li><a href="test"><i class="fa fa-user"></i>test</a></li>
                    </ul>
                </li>
                <li class="dropdown topbar-user"><a data-hover="dropdown" href="clean_data" class="dropdown-toggle">&nbsp;<span class="hidden-xs"><i class="fa fa-tachometer fa-fw"></i>舆情指标展示</span>&nbsp;<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-user pull-right">
                        <li><a href=""><i class="fa fa-gift fa-fw"></i>网络舆情事件主页</a></li>
                        <li><a href="event?eventID=${eventID}"><i class="fa fa-gift fa-fw"></i>舆情分析指标展示主页</a></li>
                        <li><a href="test"><i class="fa fa-user"></i>test</a></li>
                    </ul>
                </li>

                <li class="dropdown topbar-user"><a data-hover="dropdown" href="#" class="dropdown-toggle">&nbsp;<span class="hidden-xs"><i class="fa fa-envelope-o"></i>信息站</span>&nbsp;<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-user pull-right">
                        <li><a href="#"><i class="fa fa-user"></i>新信息</a></li>
                        <li><a href="#"><i class="fa fa-tasks"></i>收信信箱<span class="badge badge-success">7</span></a></li>
                        <li><a href="#"><i class="fa fa-key"></i>待发箱</a></li>
                        <li><a href="#"><i class="fa fa-user"></i>回收站</a></li>
                    </ul>
                </li>
                <li class="dropdown topbar-user"><a data-hover="dropdown" href="#" class="dropdown-toggle">&nbsp;<span class="hidden-xs">我的个人中心</span>&nbsp;<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-user pull-right">
                        <li><a href="#"><i class="fa fa-user"></i>个人资料</a></li>
                        <li><a href="#"><i class="fa fa-tasks"></i>我的任务<span class="badge badge-success">7</span></a></li>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-key"></i>注销</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
    <!--BEGIN MODAL CONFIG PORTLET-->
    <div id="modal-config" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" data-dismiss="modal" aria-hidden="true" class="close">
                        &times;</button>
                    <h4 class="modal-title">
                        Modal title</h4>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" data-dismiss="modal" class="btn btn-default">
                        Close</button>
                    <button type="button" class="btn btn-primary">
                        Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <!--END MODAL CONFIG PORTLET-->
</div>
<!--END TOPBAR-->

