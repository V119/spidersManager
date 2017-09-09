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
            热门信息
          </div>
        </div>
        <ol class="breadcrumb page-breadcrumb pull-right">
          <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
          <li class="hidden"><a href="#">热门信息</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
          <li class="active">热门信息</li>
        </ol>
        <div class="clearfix">
        </div>
      </div>
      <!--END TITLE & BREADCRUMB PAGE-->

      <!--BEGIN CONTENT-->
      <div class="page-content" align="center">

        <div id="tab-general">

          <div class="row mbl">
            <c:forEach items="${tableHotValuestop10}" var="h">
            <c:if test="${h.doubanGroupPost != null}">
            <div class="col-lg-4">
              <div class="panel" >
                <div class="panel-body">
                  <div class="profile">
                    <div style="margin-bottom: 15px" class="row">
                      <div class="col-xs-12 col-sm-8">
                        <h3>${h.doubanGroupPost.authorName}</h3>
                        <p>
                          <strong>时间:</strong> ${h.doubanGroupPost.dateTime}</p>
                        <div style="width: 250px;height: 150px">
                          <strong>内容:</strong> ${h.doubanGroupPost.content}</div>
                        <p>
                          <strong class="mrs"><font color="red">热度:${h.hotValue}</font></strong><span class="label label-sm label-warning" ><a href="${h.doubanGroupPost.url}" style="color: white">原文链接</a></span></p>
                      </div>
                      <div class="col-xs-12 col-sm-4 text-center">
                        <figure><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg" alt="" style="display: inline-block" class="img-responsive img-circle" width="60px"/>
                            <%--<img src="images/${index+1}.jpg" alt="" style="display: inline-block" class="img-responsive img-circle"/>--%>
                          <figcaption class="ratings"><p>${h.websiteName}</p></figcaption>
                        </figure>
                      </div>
                    </div>
                    <div class="row text-center divider">
                      <div class="col-xs-12 col-sm-4 emphasis">
                        <h2>
                          <strong>${h.doubanGroupPost.likeNum}</strong></h2>
                        <p>
                          <small>喜欢</small>
                        </p>

                      </div>
                      <div class="col-xs-12 col-sm-4 emphasis">
                        <h2>
                          <strong>${h.doubanGroupPost.recommendNum}</strong></h2>
                        <p>
                          <small>推荐</small>
                        </p>

                      </div>
                      <div class="col-xs-12 col-sm-4 emphasis">
                        <h2>
                          <strong>${h.doubanGroupPost.commentNum}</strong></h2>
                        <p>
                          <small>评论</small>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </c:if>
            </c:forEach>
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
