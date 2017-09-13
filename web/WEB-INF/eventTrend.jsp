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
<head>
    <title>Dashboard | Dashboard</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="merge/images/icons/favicon.ico">
    <link rel="apple-touch-icon" href="merge/images/icons/favicon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="merge/images/icons/favicon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="merge/images/icons/favicon-114x114.png">
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
    <link type="text/css" rel="stylesheet" href="merge/styles/jquery-ui-1.10.4.custom.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/animate.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/all.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/main.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/style-responsive.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/zabuto_calendar.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/pace.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/jquery.news-ticker.css">

    <link rel="stylesheet" type="text/css" href="timebar/css/history.css">
    <script type="text/javascript" src="timebar/js/jquery.js"></script>
    <script type="text/javascript" src="timebar/js/jquery.mousewheel.js"></script>
    <script type="text/javascript" src="timebar/js/jquery.easing.js"></script>
    <script type="text/javascript" src="timebar/js/history.js"></script>
</head>
<body>
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
        <div id="page-wrapper">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        事件走势
                    </div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">事件走势</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">事件走势</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" style="position:absolute; height:1000px; overflow-y:auto" align="center">
                <div id="content">
                    <ul class="list">
                    <c:forEach items="${tableHotValues}" var="h" varStatus="st">
                        <c:if test="${h.doubanGroupPost != null}">
                        <li>
                            <div class="liwrap">
                                <div class="lileft">
                                    <div class="date">
                                        <span class="year"></span>
                                        <span class="md">豆瓣小组：</span>
                                    </div>
                                </div>

                                <div class="point"><b></b></div>

                                <div class="liright">
                                    <div class="histt"><a href="${h.doubanGroupPost.url}"></a></div>
                                    <div class="hisct">标题：${h.doubanGroupPost.title}
                                        内容：${h.doubanGroupPost.content}
                                        <p class="f_c1"><a style="color: orangered">热度</a>：${h.hotValue}&nbsp;&nbsp;&nbsp;<a style="color: blue">时间</a>：${h.doubanGroupPost.dateTime}(可能是事件源头，仅供参考)</p></div>
                                </div>
                            </div>
                        </li>
                        </c:if>
                        <c:if test="${h.bbsPeoplePost != null}">
                            <li>
                                <div class="liwrap">
                                    <div class="lileft">
                                        <div class="date">
                                            <span class="year"></span>
                                            <span class="md">人民网BBS：</span>
                                        </div>
                                    </div>

                                    <div class="point"><b></b></div>

                                    <div class="liright">
                                        <div class="histt"><a href="${h.bbsPeoplePost.url}"></a></div>
                                        <div class="hisct">标题：${h.bbsPeoplePost.title}
                                            内容：${h.bbsPeoplePost.content}
                                            <p class="f_c1"><a style="color: orangered">热度</a>：${h.hotValue}&nbsp;&nbsp;&nbsp;<a style="color: blue">时间</a>：${h.bbsPeoplePost.dateTime}(可能是事件源头，仅供参考)</p></div>
                                    </div>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                    </ul>
                </div>

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
