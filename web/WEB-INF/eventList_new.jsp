<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/6
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
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
        <nav id="sidebar" role="navigation" data-step="2" data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
             data-position="right" class="navbar-default navbar-static-side">
            <div class="sidebar-collapse menu-scroll">
                <ul id="side-menu" class="nav">
                    <div class="clearfix"></div>
                    <li class="active"><a><i class="fa fa-th-list fa-fw"><%--<i class="fa fa-tachometer fa-fw">--%>
                        <div class="icon-bg bg-orange"></div>
                    </i><span class="menu-title">事件列表</span></a></li>
                </ul>
            </div>
        </nav>


        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper">

            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        事件列表</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">事件列表</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">事件列表</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN-->
            <div class="page-content" style="position:absolute; height:90%; overflow-y:auto">
                <div class="col-md-12">
                    <div class="row mtl">
                        <c:forEach items="${events}" var="e">
                            <div class="col-md-3" style="height:70%">

                                <%--<div class="form-group">
                                    <div class="text-center mbl"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg" width="60" height="60" class="img-responsive"/></div>
                                </div>--%>
                                <table class="table table-striped table-hover" style="font-size: 14px;" width="50px" align="left">
                                    <tbody>

                                    <tr>
                                        <td width="25%"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg" width="60" height="60" class="img-responsive"/></td>
                                        <td style="color: grey"><strong>${e.eventName}</strong></td>
                                    </tr>
                                    <tr style="height: 240px">
                                        <td colspan="2">摘要：${e.eventIntroduction}</td>
                                    </tr>
                                    <tr>
                                        <td style="color: #00b7ee">开始时间:<br>结束时间:<br>峰值时间:<br>峰值数量:<br>事件趋势:</td>
                                        <td>${e.eventStartTime}<br>${e.eventEndTime}<br>${e.eventRushTime}<br>${e.eventRushNum}<br>${e.eventTrend}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="text-center mbl"><a href="javascript:window.location.href='event?eventID=' + '${e.id}'" class="btn btn-green"><i class="fa fa-upload"></i>&nbsp;
                                    进入事件</a>
                                </div>

                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!--END-->



            <!--BEGIN CONTENT-->

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
