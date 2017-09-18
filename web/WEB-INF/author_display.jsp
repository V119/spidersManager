<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/13
  Time: 14:07
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
<body>

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
        <div id="page-wrapper">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        作者列表</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a>源数据展示</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">源数据展示</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content">
                <div id="tab-general">
                    <div class="row mbl">
                        <div class="col-lg-12">

                            <div class="col-md-12">
                                <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;">
                                </div>
                            </div>

                        </div>
                        <div class="col-lg-12">
                            <div class="col-lg-12">
                                <div class="btn-group">
                                    <h4>来源网站：</h4>
                                </div>&nbsp;
                                <div class="btn-group">
                                    <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">BBS
                                        &nbsp;<i class="fa fa-angle-down"></i></button>
                                    <ul role="menu" class="dropdown-menu">
                                        <li><a href="bbs_sohu_author">搜狐社区</a></li>
                                        <li><a href="bbs_kd_author">凯迪社区</a></li>
                                        <li><a href="bbs_mop_author">猫扑社区</a></li>
                                        <li><a href="#">西祠社区</a></li>
                                        <li><a href="bbs_tianya_author">天涯BBS</a></li>
                                        <li><a href="bbs_people_author">人民网BBS</a></li>
                                        <li><a href="#">新华网BBS</a></li>
                                        <li><a href="bbs_china_author">中华网BBS</a></li>
                                    </ul>
                                </div>
                                &nbsp;
                                <div class="btn-group">
                                    <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">博客
                                        &nbsp;<i class="fa fa-angle-down"></i></button>
                                    <ul role="menu" class="dropdown-menu">
                                        <li><a href="blog_china_author">博客中国</a></li>
                                        <li><a href="blog_sina_author">新浪博客</a></li>
                                        <li><a href="blog_163_author">网易博客</a></li>
                                    </ul>
                                </div> &nbsp;
                                <div class="btn-group">
                                    <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">政府网站
                                        &nbsp;<i class="fa fa-angle-down"></i></button>
                                    <ul role="menu" class="dropdown-menu">
                                        <li><a href="#">教育部</a></li>
                                    </ul>
                                </div> &nbsp;
                                <div class="btn-group">
                                    <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">社交网站
                                        &nbsp;<i class="fa fa-angle-down"></i></button>
                                    <ul role="menu" class="dropdown-menu">
                                        <li><a href="#">微博</a></li>
                                        <li><a href="douban_author">豆瓣小组</a></li>
                                    </ul>
                                </div> &nbsp;
                                <div class="btn-group">
                                    <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">新闻
                                        &nbsp;<i class="fa fa-angle-down"></i></button>
                                    <ul role="menu" class="dropdown-menu">
                                        <li><a href="#">人民网</a></li>
                                        <li><a href="#">网易网</a></li>
                                        <li><a href="#">新华网</a></li>
                                        <li><a href="#">三秦网</a></li>
                                        <li><a href="#">中国社会新闻网</a></li>
                                        <li><a href="#">新浪新闻</a></li>
                                    </ul>
                                </div>
                                <%--<div class="btn-group">--%>
                                    <%--<input type="text" class="form-control"/><button type="button">Go!</button>--%>
                                <%--</div>--%>
                                <form role="search" class="navbar-form navbar-right">
                                    <div class="form-group"><input type="text"  class="form-control"/></div>
                                    &nbsp;
                                    <button type="submit" class="btn btn-green">搜</button>
                                </form>
                            </div>
                            <hr>
                            <div class="page-content">
                                <div class="row">

                                    <div id="change-transitions" class="row">
                                        <a href="bbs_china_posttitle">来者不来</a>
                                   <%-- <c:if test="${bbs_china_author!=null}">
                                        <c:forEach items="${bbs_china_author}" var="a">
                                        <div class="col-md-2">
                                            <div class="box-placeholder">
                                                <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block" onclick="bbs_china_posttitle?authorID=${a.authorId}">${a.authorName}</button>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </c:if>--%>
                                        <%--<c:if test="${bbs_mop_author!=null}">
                                            <c:forEach items="${bbs_mop_author}" var="a">
                                                <div class="col-md-2">
                                                    <div class="box-placeholder">
                                                        <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                         </c:if>--%>
                                        <%--<c:if test="${bbs_people_author!=null}">
                                            <c:forEach items="${bbs_people_author}" var="a">
                                                <div class="col-md-2">
                                                    <div class="box-placeholder">
                                                        <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>--%>
                                            <%--<c:if test="${bbs_sohu_author!=null}">
                                                <c:forEach items="${bbs_sohu_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.nickName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                            <c:if test="${bbs_tianya_author!=null}">
                                                <c:forEach items="${bbs_tianya_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                            <%--<c:if test="${bbs_xici_author!=null}">
                                                <c:forEach items="${bbs_xici_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                            <%--<c:if test="${bbs_kd_author!=null}">
                                                <c:forEach items="${bbs_kd_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.nick}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                            <%--<c:if test="${blog_163_author!=null}">
                                                <c:forEach items="${blog_163_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.nick}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                            <%--<c:if test="${blog_china_author!=null}">
                                                <c:forEach items="${blog_china_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                            <%--<c:if test="${blog_sina_author!=null}">
                                                <c:forEach items="${blog_sina_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                            <c:if test="${blog_sina_author!=null}">
                                                <c:forEach items="${blog_sina_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-md-2">
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">每页显示条数
                                            &nbsp;<span class="caret"></span></button>
                                        <ul role="menu" class="dropdown-menu">
                                            <li><a href="#">100</a></li>
                                            <li><a href="#">200</a></li>
                                            <li><a href="#">300</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-4" style="margin-left: 30%">

                                    <ul class="pagination pagination-lg mtm mbm">
                                        <li><a href="#">&laquo;</a></li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">&raquo;</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>

    <jsp:include page="static/footer_script.jsp"/>
    <script src="js/js1/echarts.min.js"></script>

</body>
</html>