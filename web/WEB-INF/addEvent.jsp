<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<jsp:include page="static/head_jsp.jsp"/>
<body style="overflow: hidden">
<div>
    <!--BEGIN BACK TO TOP-->
    <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
    <!--END BACK TO TOP-->
    <jsp:include page="static/headerInfo.jsp"/>
    <div id="wrapper">
        <!--BEGIN SIDEBAR MENU-->
        <jsp:include page="static/leftNav.jsp"/>
        <!--END SIDEBAR MENU-->

        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper" style="position:absolute; height:100%; overflow-y:auto">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        增加事件</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>爬虫管理</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">增加事件</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">增加事件</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content">
                <div>
                    <div class="row">
                    <div id="tab-general">

                        <div class="col-lg-6">
                            <div class="input-group">
                                <input type="text" class="form-control"/>

                                <div class="input-group-btn">
                                    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">添加事件

                                        &nbsp;</button>

                                </div>
                                <br>
                            </div>
                        </div>
                    </div>
                    </div>

                    <div class="panel panel-grey" style="width: 100%;margin-top: 3%">
                        <div class="panel-heading">事件列表</div>
                        <div class="panel-body">
                            <table class="table table-hover table-bordered" >
                                <thead>
                                <tr>
                                    <th width="15%">事件名称</th>
                                    <th width="25%">事件介绍</th>
                                    <th width="5%">事件总结</th>
                                    <th width="15%">事件开始时间</th>
                                    <th width="15%">事件结束时间</th>
                                    <th width="15%">事件峰值时间</th>
                                    <th>事件峰值数量</th>
                                    <th>事件趋势</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <c:forEach items="${events}" var="e">
                                <tr>
                                    <td>${e.eventName}</td>
                                    <td>${e.eventIntroduction}</td>
                                    <td>${e.eventSummary}</td>
                                    <td>${e.eventStartTime}</td>
                                    <td>${e.eventEndTime}</td>
                                    <td>${e.eventRushTime}</td>
                                    <td>${e.eventRushNum}</td>
                                    <td>${e.eventTrend}</td>
                                </tr>
                                </c:forEach>
                                </tr>


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!--END CONTENT-->


                <!--BEGIN FOOTER-->
                <jsp:include page="static/footer.jsp"/>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>

    <jsp:include page="static/footer_script.jsp"/>

</body>
</html>
