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
            <div class="page-content" style="position:absolute; overflow-y:auto;height:90%;width: 100%" align="center">
                <div id="content" >
                    <div class="row">
                        <div class="col-lg-8" style="margin-left: 10%;">
                            <div class="timeline-centered timeline-sm">
                            <c:forEach items="${tableHotValues}" var="h" varStatus="st">
                                <c:if test="${h.doubanGroupPost != null}">
                                <article class="timeline-entry">
                                    <div class="timeline-entry-inner">
                                        <time datetime="" class="timeline-time"><span>豆瓣小组</span><span>${h.bbsPeoplePost.dateTime} 热度：${h.hotValue}</span></time>
                                        <div class="timeline-icon bg-violet"></div>
                                        <div class="timeline-label"><h4 class="timeline-title">${h.doubanGroupPost.title}</h4>

                                            <p>内容：${h.doubanGroupPost.content}</p></div>
                                    </div>
                                </article>
                                </c:if>
                                <c:if test="${h.bbsPeoplePost != null}">
                                    <article class="timeline-entry">
                                        <div class="timeline-entry-inner">
                                            <time datetime="" class="timeline-time"><span>人民网</span><span>热度：${h.hotValue}</span></time>
                                            <div class="timeline-icon bg-violet"></div>
                                            <div class="timeline-label"><h4 class="timeline-title">${h.bbsPeoplePost.title}</h4>

                                                <p>内容：${h.bbsPeoplePost.content}</p></div>
                                        </div>
                                    </article>
                                </c:if>

                            </c:forEach>
                            </div>
                        </div>

                    </div>
                    <%--<ul class="list">--%>
                    <%--<c:forEach items="${tableHotValues}" var="h" varStatus="st">--%>
                        <%--<c:if test="${h.doubanGroupPost != null}">--%>
                        <%--<li>--%>
                            <%--<div class="liwrap">--%>
                                <%--<div class="lileft">--%>
                                    <%--<div class="date">--%>
                                        <%--<span class="year"></span>--%>
                                        <%--<span class="md">豆瓣小组：</span>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="point"><b></b></div>--%>

                                <%--<div class="liright">--%>
                                    <%--<div class="histt"><a href="${h.doubanGroupPost.url}"></a></div>--%>
                                    <%--<div class="hisct">标题：${h.doubanGroupPost.title}--%>
                                        <%--内容：${h.doubanGroupPost.content}--%>
                                        <%--<p class="f_c1"><a style="color: orangered">热度</a>：${h.hotValue}&nbsp;&nbsp;&nbsp;<a style="color: blue">时间</a>：${h.doubanGroupPost.dateTime}(可能是事件源头，仅供参考)</p></div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${h.bbsPeoplePost != null}">--%>
                            <%--<li>--%>
                                <%--<div class="liwrap">--%>
                                    <%--<div class="lileft">--%>
                                        <%--<div class="date">--%>
                                            <%--<span class="year"></span>--%>
                                            <%--<span class="md">人民网BBS：</span>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<div class="point"><b></b></div>--%>

                                    <%--<div class="liright">--%>
                                        <%--<div class="histt"><a href="${h.bbsPeoplePost.url}"></a></div>--%>
                                        <%--<div class="hisct">标题：${h.bbsPeoplePost.title}--%>
                                            <%--内容：${h.bbsPeoplePost.content}--%>
                                            <%--<p class="f_c1"><a style="color: orangered">热度</a>：${h.hotValue}&nbsp;&nbsp;&nbsp;<a style="color: blue">时间</a>：${h.bbsPeoplePost.dateTime}(可能是事件源头，仅供参考)</p></div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</li>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--</ul>--%>
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
