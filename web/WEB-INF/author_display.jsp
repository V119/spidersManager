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
<script>

    function json(list) {
        for (var key in list){
            alert(key.valueOf());
        }
    }
</script>
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
            <div class="page-content" style="position:absolute; height:90%; overflow-y:auto;width: 100%">
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
                                        <li><a href="bbs_sohu_author?pageIndex=1">搜狐社区</a></li>
                                        <li><a href="kdnet_author?pageIndex=1">凯迪社区</a></li>
                                        <li><a href="bbs_mop_author?pageIndex=1">猫扑社区</a></li>
                                        <li><a href="#">西祠社区</a></li>
                                        <li><a href="bbs_tianya_author?pageIndex=1">天涯BBS</a></li>
                                        <li><a href="bbs_people_author?pageIndex=1">人民网BBS</a></li>
                                        <li><a href="#">新华网BBS</a></li>
                                        <li><a href="bbs_china_author?pageIndex=1">中华网BBS</a></li>
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
                                <form role="search" class="navbar-form navbar-right" method="post" action="">
                                    <div class="form-group"><input type="text"  class="form-control"/></div>
                                    &nbsp;
                                    <button type="submit" class="btn btn-green">搜</button>
                                </form>
                            </div>
                            <hr>
                            <div class="page-content" >
                                <div class="row">

                                    <div id="change-transitions" class="row">
                                        <div class="col-md-2">
                                            <div class="box-placeholder">
                                                <div align="center"><a href="bbs_china_posttitle?authorID=3225263">kv3429</a></div>
                                                <%--<button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block"></button>--%>
                                            </div>
                                        </div>
                                    <c:if test="${bbs_china_author!=null}">
                                        <c:forEach items="${bbs_china_author}" var="a" varStatus="status">
                                        <div class="col-md-2">
                                            <div class="box-placeholder">
                                                <div align="center"><a href="bbs_china_posttitle?authorID=${a.authorID}">${a.authorName}</a></div>
                                                <%--<button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block"></button>--%>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </c:if>
                                        <c:if test="${bbs_china_author=null}">

                                                <div class="col-md-2">
                                                    <div class="box-placeholder">
                                                        没有内容啦
                                                    </div>
                                                </div>

                                        </c:if>
                                        <c:if test="${bbs_mop_author!=null}">
                                            <c:forEach items="${bbs_mop_author}" var="b">
                                                <div class="col-md-2">
                                                    <div class="box-placeholder">
                                                        <div align="center"><a href="bbs_mop_posttitle?authorID=${b.authorID}">${b.authorName}</a></div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                         </c:if>
                                        <c:if test="${bbs_people_author!=null}">
                                            <c:forEach items="${bbs_people_author}" var="c">
                                                <div class="col-md-2">
                                                    <div class="box-placeholder">
                                                        <div align="center"><a href="bbs_people_posttitle?authorID=${c.authorID}">${c.authorName}</a></div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                            <c:if test="${bbs_sohu_author!=null}">
                                                <c:forEach items="${bbs_sohu_author}" var="d">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <div align="center"><a href="bbs_sohu_posttitle?authorID=${d.authorID}">${d.nickName}</a></div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${bbs_tianya_author!=null}">
                                                <c:forEach items="${bbs_tianya_author}" var="e">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <div align="center"><a href="bbs_tianya_posttitle?authorID=${e.authorID}">${e.authorName}</a></div>
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
                                            <c:if test="${kdnet_author!=null}">
                                                <c:forEach items="${kdnet_author}" var="f">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <div align="center"><a href="bbs_kdnet_posttitle?authorID=${f.author_id}">${f.nick}</a></div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
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
                                            <%--<c:if test="${blog_sina_author!=null}">
                                                <c:forEach items="${blog_sina_author}" var="a">
                                                    <div class="col-md-2">
                                                        <div class="box-placeholder">
                                                            <button data-toggle="dropdown" data-value="bounce" class="btn btn-success btn-block">${a.authorName}</button>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>--%>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-md-2">
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">每页显示条数
                                            &nbsp;<span class="caret"></span></button>
                                        <ul role="menu" class="dropdown-menu">
                                            <li><a href="bbs_china_author?pageSize=50&&pageIndex=1">50</a></li>
                                            <li><a href="bbs_china_author?pageSize=100&&pageIndex=1">100</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-4" style="margin-left: 20%">
                                    <c:if test="${page!=null}">
                                        <input hidden="${page.pageIndex}">
                                    <ul class="pagination pagination-lg mtm mbm">
                                        <li><a href="bbs_china_author?prePage=0&&pageSize=${page.pageSize}&&pageIndex=${page.pageIndex-1}&&flag=0&&rowKeyEndNum=${rowKeyEndNum}&&rowKeyBeginNum=${rowKeyBeginNum}">上一页</a></li>
                                        <li><a href="bbs_china_author?nextPage=0&&pageSize=${page.pageSize}&&pageIndex=${page.pageIndex+1}&&flag=0&&rowKeyEndNum=${rowKeyEndNum}&&rowKeyBeginNum=${rowKeyBeginNum}">下一页</a></li>
                                    </ul>
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
    <script src="js/js1/echarts.min.js"></script>

</body>
</html>