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
        <jsp:include page="static/leftNav.jsp"></jsp:include>


        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper">

            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        热点网民的参与度</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">热点网民的参与度</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">热点网民的参与度</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN-->
            <div class="page-content">
                <%--<div id="tab-general">
                <div class="row mbl">
                    <c:forEach items="${tbNetizenParticiTop10}" var="h" varStatus="isindex">
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
                                                        <strong class="mrs"><font color="red">热度:${h.hotValue} 评论：${h.doubanGroupPost.commentNum}</font></strong><span class="label label-green mrs" href="${h.doubanGroupPost.url}">原文链接</span></p>
                                                </div>
                                                <div class="col-xs-12 col-sm-4 text-center">
                                                    <figure><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg" alt="" style="display: inline-block" class="img-responsive img-circle" width="60px"/>
                                                            &lt;%&ndash;<img src="images/${index+1}.jpg" alt="" style="display: inline-block" class="img-responsive img-circle"/>&ndash;%&gt;
                                                        <figcaption class="ratings"><p>${h.websiteName}</p></figcaption>
                                                    </figure>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${h.bbsPeoplePost !=null}">
                            <div class="col-lg-4">
                                <div class="panel" >
                                    <div class="panel-body">
                                        <div class="profile">
                                            <div style="margin-bottom: 15px" class="row">
                                                <div class="col-xs-12 col-sm-8">
                                                    <h3>${h.doubanGroupPost.authorName}</h3>
                                                    <p>
                                                        <strong>时间:</strong> ${h.bbsPeoplePost.dateTime}</p>
                                                    <div style="width: 250px;height: 150px">
                                                        <strong>内容:</strong> ${h.doubanGroupPost.content}</div>
                                                    <p>
                                                        <strong class="mrs"><font color="red">热度:${h.hotValue} 评论${h.bbsPeoplePost.commentNum}</font></strong><span class="label label-green mrs" href="${h.doubanGroupPost.url}">原文链接</span></p>
                                                </div>
                                                <div class="col-xs-12 col-sm-4 text-center">
                                                    <figure><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg" alt="" style="display: inline-block" class="img-responsive img-circle" width="60px"/>
                                                            &lt;%&ndash;<img src="images/${index+1}.jpg" alt="" style="display: inline-block" class="img-responsive img-circle"/>&ndash;%&gt;
                                                        <figcaption class="ratings"><p>${h.websiteName}</p></figcaption>
                                                    </figure>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
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
                                                        <strong class="mrs"><font color="red">参与度：${h.engagement}</font></strong><span class="label label-green mrs" href="${h.doubanGroupPost.url}">原文链接</span></p>
                                                </div>
                                                <div class="col-xs-12 col-sm-4 text-center">
                                                    <figure><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg" alt="" style="display: inline-block" class="img-responsive img-circle" width="60px"/>
                                                            &lt;%&ndash;<img src="images/${index+1}.jpg" alt="" style="display: inline-block" class="img-responsive img-circle"/>&ndash;%&gt;
                                                        <figcaption class="ratings"><p>${h.websiteName}</p></figcaption>
                                                    </figure>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                </div>--%>
                <c:forEach items="${tbNetizenParticiTop10}" var="h" varStatus="isindex">
                    <div class="col-md-12">
                        <div class="portlet-pink">
                            <!--kaishi-->
                            <c:if test="${h.doubanGroupPost != null}">
                                    <div class="tx"><img src="images/images3/1.jpg" height="60px" width="60px"></div>
                                    <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1">${h.doubanGroupPost.authorName}</a>参与度：${h.engagement}  ${h.doubanGroupPost.dateTime} <a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a> 评论<&nbsp;${h.doubanGroupPost.commentNum} 点击：${h.doubanGroupPost.recommendNum+1} 来源：${h.websiteName}<a href="javascript:void(0)"><i class="W_icon"></i></a>
                                        <%--<label style="float:right;color:orangered">参与度：${h.engagement}</label>--%>
                                    </p>
                                    <%--<p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                    <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.doubanGroupPost.recommendNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>--%>
                                    <div class="clearfix"></div>

                            </c:if>
                            <c:if test="${h.bbsPeoplePost !=null}">

                                <div class="tx"><img src="images/images3/01.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsPeoplePost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;${h.bbsPeoplePost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.bbsPeoplePost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.bbsPeoplePost.priseNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.bbsPeoplePost.url}" style="color: white">原文链接</a></span></label></div>
                                    <p class="mscrame"><%--<a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1">${h.bbsPeoplePost.authorName}</a>参与度：${h.engagement} ${h.bbsPeoplePost.dateTime} <a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a> 评论&nbsp;${h.bbsPeoplePost.commentNum} 点击：&nbsp;${h.bbsPeoplePost.priseNum+1}来源：${h.websiteName}<a href="javascript:void(0)"><i class="W_icon"></i></a>--%>
                                        <%--<label style="float:right;color:orangered">参与度：${h.engagement}</label>--%>
                                    </p>
                                    <%--<p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                    <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsPeoplePost.priseNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    <div class="clearfix"></div>--%>

                            </c:if>
                            <c:if test="${h.bbsSohuPost !=null}">

                                    <div class="tx"><img src="images/images3/001.jpg" height="60px" width="60px"></div>
                                    <p class="mscrame"><a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1">${h.bbsSohuPost.authorName}</a>参与度：${h.engagement} ${h.bbsSohuPost.dateTime} <a href="${h.bbsSohuPost.url}" target="_blank" class="wblink"><i></i>原文链接</a> 评论&nbsp;${h.bbsSohuPost.commentNum} 点击：${h.bbsSohuPost.readNum+1} 来源：${h.websiteName}<a href="javascript:void(0)"><i class="W_icon"></i></a>
                                        <%--<label style="float:right;color:orangered">参与度：${h.engagement}</label>--%>
                                    </p>
                                    <%--<p style="margin-top: 5px;"><span class="time">${h.bbsSohuPost.dateTime}</span><a href="${h.bbsSohuPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                    <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsSohuPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsSohuPost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    <div class="clearfix"></div>--%>

                            </c:if>

                            <!--jieshu-->
                        </div>

                    </div>

                </c:forEach>

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
