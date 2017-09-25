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
                    <li><i class="fa fa-home"></i>&nbsp;<a href="bbs_china_author">作者列表</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
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

                            <div class="panel-body">
                                <c:if test="${bbs_china_authorInfo!=null}">
                            <h4>
                                <strong>作者：${bbs_china_authorInfo.authorName}</strong>

                            </h4>
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>昵称：</td>
                                            <td>${bbs_china_authorInfo.name}</td>
                                        </tr>
                                        <tr>
                                            <td>性别：</td>
                                            <td>${bbs_china_authorInfo.sex}</td>
                                        </tr>
                                        <tr>
                                            <td>生日：</td>
                                            <td>${bbs_china_authorInfo.birthday}</td>
                                        </tr>
                                        <tr>
                                            <td>地址：</td>
                                            <td>${bbs_china_authorInfo.address}</td>
                                        </tr>
                                        <tr>
                                            <td>粉丝数：</td>
                                            <td>${bbs_china_authorInfo.fansNum}</td>
                                        </tr>

                                        </tbody>
                                    </table>
                                   <%-- <p>

                                        <c:if test="${bbs_china_authorInfo.name!=null}">昵称：${bbs_china_authorInfo.name}</c:if>&nbsp;&nbsp;
                                        <c:if test="${bbs_china_authorInfo.sex!=null}">性别：${bbs_china_authorInfo.sex}</c:if>&nbsp;&nbsp;
                                        <c:if test="${bbs_china_authorInfo.birthday!=null}">生日：${bbs_china_authorInfo.birthday}</c:if>&nbsp;&nbsp;
                                        <c:if test="${bbs_china_authorInfo.address!=null}">地址：${bbs_china_authorInfo.address}</c:if>&nbsp;&nbsp;
                                        &lt;%&ndash;<c:if test="${bbs_china_authorInfo.fansNum!=null}">粉丝数：${bbs_china_authorInfo.fansNum}</c:if>&ndash;%&gt;
                                    &lt;%&ndash;性别：${bbs_china_authorInfo.sex}
                                    生日：${bbs_china_authorInfo.birthday}
                                    地址： ${bbs_china_authorInfo.address}
                                    粉丝数：${bbs_china_authorInfo.fansNum}&ndash;%&gt;
                                </p>--%>
                                </c:if>
                                    </div>

                         </div>
                            <div class="col-sm-9 col-md-10" style="width: 100%">
                                <div class="tab-content">
                                    <div id="home" class="tab-pane fade in active">
                                        <div class="list-group mail-box">
                                            <h4>作者相关的文章：</h4>
                                            <c:if test="${postList!=null}">
                                                <c:forEach items="${postList}" var="p">
                                                                      <a href="bbs_china_postInfo?postID=${p.postID}" class="list-group-item">
                                                                          <span class="fa fa-star-o mrm mlm"></span>
                                                                          <span style="min-width: 120px; display: inline-block;" class="name">${p.title}</span>
                                                                          <span>${p.title}</span>&nbsp; - &nbsp;
                                                                          <%--<span style="font-size: 11px;" class="text-muted">${p.keyWords}</span>--%>
                                                                          <span class="time-badge">${p.dateTime}<%--12:10 AM--%></span>
                                                                          <span class="pull-right mrl">
                                                                              <span class="fa fa-paperclip"></span>
                                                                          </span>
                                                                      </a>
                                                </c:forEach>
                                            </c:if>

                                    </div>
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
