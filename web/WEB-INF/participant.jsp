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
<script>
    function show(id){

        if(id==allInfo){
            document.getElementById("allInfo").style.display="";
            document.getElementById("souhu").style.display="none";
            document.getElementById("renmin").style.display="none";
            document.getElementById("douban").style.display="none";
        }
        if(id==souhu){
            document.getElementById("allInfo").style.display="none";
            document.getElementById("souhu").style.display="";
            document.getElementById("renmin").style.display="none";
            document.getElementById("douban").style.display="none";
        }
        if(id==renmin){
            document.getElementById("allInfo").style.display="none";
            document.getElementById("souhu").style.display="none";
            document.getElementById("renmin").style.display="";
            document.getElementById("douban").style.display="none";
        }
        if(id==douban){
            document.getElementById("allInfo").style.display="none";
            document.getElementById("souhu").style.display="none";
            document.getElementById("renmin").style.display="none";
            document.getElementById("douban").style.display="";
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
            <div class="page-content" style="position:absolute; height:90%; overflow-y:auto">
                <div>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a onclick="show(allInfo)">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a onclick="show(douban)">豆瓣社区</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a onclick="show(renmin)">人民网社区</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a onclick="show(souhu)">搜狐社区</a>
                </div>
                <hr>
                <div id="allInfo">
                    <c:forEach items="${tbNetizenParticiTop10}" var="h" varStatus="isindex">
                        <div class="col-md-12">
                            <div class="portlet-pink">
                                <!--kaishi-->
                                <c:if test="${h.doubanGroupPost != null}">
                                        <div class="tx"><img src="images/images3/1.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsPeoplePost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;$${h.doubanGroupPost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.doubanGroupPost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.doubanGroupPost.recommendNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.doubanGroupPost.url}" style="color: white">原文链接</a></span></label></div>
                                    <hr>
                                </c:if>
                                <c:if test="${h.bbsPeoplePost !=null}">
                                    <div class="tx"><img src="images/images3/01.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsPeoplePost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;${h.bbsPeoplePost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.bbsPeoplePost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.bbsPeoplePost.priseNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.bbsPeoplePost.url}" style="color: white">原文链接</a></span></label></div>
                                    <hr>
                                </c:if>
                                <c:if test="${h.bbsSohuPost !=null}">
                                        <div class="tx"><img src="images/images3/001.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsSohuPost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;${h.bbsSohuPost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.bbsSohuPost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.bbsSohuPost.readNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.bbsSohuPost.url}" style="color: white">原文链接</a></span></label></div>
                                    <hr>
                                </c:if>

                                <!--jieshu-->
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="douban" style="display: none">
                    <c:forEach items="${tbNetizenParticiTop10}" var="h" varStatus="isindex">
                        <div class="col-md-12">
                            <div class="portlet-pink">
                                <!--kaishi-->
                                <c:if test="${h.doubanGroupPost != null}">
                                    <div class="tx"><img src="images/images3/1.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsPeoplePost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;$${h.doubanGroupPost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.doubanGroupPost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.doubanGroupPost.recommendNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.doubanGroupPost.url}" style="color: white">原文链接</a></span></label></div>
                                    <hr>
                                </c:if>
                                <!--jieshu-->
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="renmin" style="display: none">
                    <c:forEach items="${tbNetizenParticiTop10}" var="h" varStatus="isindex">
                        <div class="col-md-12">
                            <div class="portlet-pink">
                                <!--kaishi-->

                                <c:if test="${h.bbsPeoplePost !=null}">
                                    <div class="tx"><img src="images/images3/01.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsPeoplePost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;${h.bbsPeoplePost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.bbsPeoplePost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.bbsPeoplePost.priseNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.bbsPeoplePost.url}" style="color: white">原文链接</a></span></label></div>
                                    <hr>
                                </c:if>

                                <!--jieshu-->
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="souhu" style="display: none">
                    <c:forEach items="${tbNetizenParticiTop10}" var="h" varStatus="isindex">
                        <div class="col-md-12">
                            <div class="portlet-pink">
                                <!--kaishi-->
                                <c:if test="${h.bbsSohuPost !=null}">
                                    <div class="tx"><img src="images/images3/001.jpg" height="60px" width="60px">&nbsp;&nbsp;&nbsp; <a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1" style="font-size: 14px;color: black;font-family: 微软雅黑">${h.bbsSohuPost.authorName}</a> &nbsp;&nbsp;&nbsp;&nbsp;${h.bbsSohuPost.dateTime}&nbsp;&nbsp;&nbsp;&nbsp;参与度：${h.engagement}  &nbsp;&nbsp;&nbsp;&nbsp;评论&nbsp;${h.bbsSohuPost.commentNum}&nbsp;&nbsp;&nbsp;&nbsp; 点击：&nbsp;${h.bbsSohuPost.readNum+1} <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp; 来源：</font>${h.websiteName}<label style="float:right;"><span class="label label-sm label-warning" ><a href="${h.bbsSohuPost.url}" style="color: white">原文链接</a></span></label></div>
                                    <hr>
                                </c:if>

                                <!--jieshu-->
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!--END-->

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
