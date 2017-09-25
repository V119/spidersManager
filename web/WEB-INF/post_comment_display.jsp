<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/15
  Time: 21:26
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
        <!--BEGIN SIDEBAR MENU-->
        <jsp:include page="static/leftNav_one.jsp"/>
        <!--END SIDEBAR MENU-->

        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper" >
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        文章</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">文章</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">文章</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" style="position:absolute; height:90%; overflow-y:auto;width: 100%">
                <!--你可以在这里开始写内容-->
                <div id="tab-general">
                    <div class="row mbl">
                        <div class="col-lg-12">

                            <div class="col-md-12">
                                <div id="area-chart-spline" style="width: 100%;  display: none;">
                                </div>
                            </div>

                        </div>

                        <div class="col-lg-12">
                            <div class="col-lg-6" style="width: 100%">
                                <div align="center"><h3 class="box-heading">${bbs_china_postInfo.title}</h3></div>
                                <div align="center"><span class="badge badge-default">作者</span>${bbs_china_postInfo.authorName}&nbsp;&nbsp;&nbsp;&nbsp;<span class="badge badge-yellow">日期</span>${bbs_china_postInfo.date_time}</div>
                                <br>
                                <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bbs_china_postInfo.content}</p>

                                <c:if test="${bbs_china_postInfo!=null}">
                                        <div align="center">

                                            <span class="badge badge-pink">关键词</span>${bbs_china_postInfo.keyWords}&nbsp;&nbsp;
                                            <span class="badge badge-red">热点词</span>${bbs_china_postInfo.hotWords}&nbsp;&nbsp;
                                            <span class="badge badge-green">回复数</span>${bbs_china_postInfo.replyNum}&nbsp;&nbsp;
                                            <span class="badge badge-dark">阅读数</span>${bbs_china_postInfo.readNum}&nbsp;&nbsp;
                                        </div>
                                </c:if>

                            </div>
                        </div>

                        <!---->
                        <div class="page-title-breadcrumb">
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                            <ul class="media-list">
                                <%--<c:forEach>--%>
                        <c:if test="${commentList!=null}">
                            <c:forEach items="${commentList}" var="c" varStatus="status">
                                <li class="media">
                                    <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                    <%--<img data-src="holder.js/64x64/text:${c.author_name}" alt="64x64" class="media-object"/>--%>
                                    <div><a style="color: black">${c.authorName}</a></div>
                                    <%--<img data-src="holder.js/64x64/text:${c.content}" alt="64x64" class="media-object"/>--%>
                                </li>
                            </c:forEach>
                        </c:if>
                                <%--</c:forEach>--%>
                            </ul>
                        </div>
                    </div>
                    <!---->
                    </div>

                </div>

                <!--你可以在这里结束写内容-->
                <jsp:include page="static/footer.jsp"/>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>

    <jsp:include page="static/footer_script.jsp"/>
</body>
</html>

