<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/14
  Time: 19:16
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
                        文章标题</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>作者列表</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a>文章标题</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">文章标题</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" style="position:absolute; height:90%; overflow-y:auto;width: 100%">
                <div id="tab-general">
                    <div class="row mbl">
                        <div class="panel">
                            <c:if test="${authorInfo!=null}">
                            <div class="panel-body">

                            <h4>
                                <strong>作者：${authorInfo.authorName}</strong>

                            </h4>
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>昵称：</td>
                                            <td>${authorInfo.name}</td>
                                        </tr>
                                        <tr>
                                            <td>性别：</td>
                                            <td>${authorInfo.sex}</td>
                                        </tr>
                                        <%--<tr>
                                            <td>生日：</td>
                                            <td>${authorInfo.birthday}</td>
                                        </tr>--%>
                                        <%--<tr>--%>
                                            <%--<td>地址：</td>--%>
                                            <%--<td>${authorInfo.address}</td>--%>
                                        <%--</tr>--%>
                                        <tr>
                                            <td>粉丝数：</td>
                                            <td>${authorInfo.fansNum}</td>
                                        </tr>

                                        </tbody>
                                    </table>

                                    </div>
                            </c:if>

                         </div>
                            <div class="col-sm-9 col-md-10" style="width: 100%">
                                <div class="tab-content">
                                    <div id="home" class="tab-pane fade in active">
                                        <c:if test="${bbs_china_post!=null}">
                                        <div class="list-group mail-box">
                                            <h4>作者相关的文章：</h4>
                                                <c:forEach items="${bbs_china_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                        </div>
                                        </c:if>
                                        <c:if test="${bbs_sohu_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${bbs_sohu_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${bbs_mop_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${bbs_mop_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${bbs_news_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${bbs_news_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${bbs_people_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${bbs_people_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <%--<c:if test="${blog_163_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${blog_163_post}" var="p">
                                                    <a href="postInfo?type=${type}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}&lt;%&ndash;12:10 AM&ndash;%&gt;</span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>--%>
                                        <c:if test="${blogchina_blog_1!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${blogchina_blog_1}" var="p">
                                                    <%--<a href="postInfo?type=${postType}&&condition=blog_id&&conditionValue=${p.blogID}" class="list-group-item">--%>
                                                        <a  class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge"><%--${p.dateTime}--%><%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${blog_sina_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${blog_sina_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=title&&conditionValue=${p.title}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge"><%--${p.dateTime}--%><%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${douban_group_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${douban_group_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${xinhua_news!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${xinhua_news}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=title&&conditionValue=${p.title}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${kdnet_post!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${kdnet_post}" var="p">
                                                    <a href="postInfo?type=${postType}&&condition=post_id&&conditionValue=${p.postID}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                        <span class="time-badge">${p.postTime}<%--12:10 AM--%></span>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                        </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                        <c:if test="${moe_news!=null}">
                                            <div class="list-group mail-box">
                                                <h4>作者相关的文章：</h4>
                                                <c:forEach items="${moe_news}" var="m">
                                                    <a href="postInfo?type=moe_news&&condition=news_title&&conditionValue=${m.newsTitle}" class="list-group-item">
                                                        <span class="fa fa-star-o mrm mlm"></span>
                                                        <span style="min-width: 120px; display: inline-block;" class="name">${m.newsTitle}</span>
                                                            <%--<span class="time-badge">${m.newsTime}&lt;%&ndash;12:10 AM&ndash;%&gt;</span>--%>
                                                        <span class="pull-right mrl">
                                                            <span class="fa fa-paperclip"></span>
                                                    </span>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!--END PAGE WRAPPER-->
            </div>
        </div>

        <jsp:include page="static/footer_script.jsp"/>


</body>
</html>
