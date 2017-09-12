<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
        <html lang="en">
        <head>
            <title>舆情分析大平台</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/css3/css1/bootstrap.min.css" />
        <link rel="stylesheet" href="css/css3/css1/matrix-style.css" />
        <link rel="stylesheet" href="css/css3/css1/matrix-media.css" />
        <link rel="stylesheet" href="css/css3/css1/common.css" />
        <link rel="stylesheet" href="css/css3/css1/eventAnalysis.css" />
        <link rel="stylesheet" href="css/css3/css1/other.css" />
        <link rel="stylesheet" href="css/css3/css1/style.css" />
        <link href="css/css3/font-awesome.min.css" rel="stylesheet">
        <link href="css/css3/templatemo-style.css" rel="stylesheet">
        <link href="css/css3/bootstrap.css" rel="stylesheet"/>
        <link href="css/css3/home.css" rel="stylesheet"/>
        <link href="css/css3/common.css" rel="stylesheet" />
        <link href="css/css3/bootstrap.css" rel="stylesheet">
        </head>
<body>

    <!--Header-part-->
    <jsp:include page="static/fore_header.jsp"/>
    <!--sidebar-menu-->
    <jsp:include page="static/fore_lefter.jsp">
        <jsp:param name="eventID" value='<%=request.getSession().getAttribute("eventID")%>'/>
    </jsp:include>
    <!--sidebar-menu-->
<div class="search-wrapper search-wrapper2">
    <div class="search" style="margin-left:300px;width:600px;margin-top:60px;">
    <span style="margin-left:100px;">
	<input type="text" class="keyWord searchkey" name="keywords" onkeydown="enterClick(event)" onmousedown="history()" oninput="thinkKeywords(this,0)" maxlength="20"  id="search-keyword" value="事件关键词">
	</span>
        <span><a href="javascript:void(0);" onclick="getEventSearch();" class="searchBtn">搜索</a>
	</span>
    </div>
</div>
<!--main-container-part-->
<div id="content">
    <div id="content-header" style="margin-top:65px;">
        <h1>热点的网民参与度</h1>
    </div>
    <div class="container-fluid">
        <hr>
        <div class="row-fluid">
            <div class="widget-box">
                <div class="widget-title">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab1">全部</a></li>
                        <li><a data-toggle="tab" href="#tab2">豆瓣社区</a></li>
                        <li><a data-toggle="tab" href="#tab3">人民网社区</a></li>
                        <li><a data-toggle="tab" href="#tab4">搜狐社区</a></li>
                    </ul>
                </div>
                <!--全部热点网民  start-->
                <div style="width:1380px;" class="widget-content tab-content" >
                    <div id="tab1" class="tab-pane active">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                <c:forEach items="${tbNetizenParticiTop10}" var="h">
                                  <c:if test="${h.doubanGroupPost != null}">
                                    <li>
                                        <div class="tx"><img src="images/images3/1.jpg"></div>
                                        <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1">${h.doubanGroupPost.authorName}</a><a href="javascript:void(0)"><i class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.doubanGroupPost.recommendNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>

                                    </li>
                                  </c:if>
                                  <c:if test="${h.bbsPeoplePost !=null}">
                                    <li>
                                        <div class="tx"><img src="images/images3/01.jpg"></div>
                                        <p class="mscrame"><a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1">${h.bbsPeoplePost.authorName}</a><a href="javascript:void(0)"><i class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsPeoplePost.priseNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    </li>
                                  </c:if>
                                   <c:if test="${h.bbsSohuPost !=null}">
                                     <li>
                                        <div class="tx"><img src="images/images3/001.jpg"></div>
                                         <p class="mscrame"><a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1">${h.bbsSohuPost.authorName}</a><a href="javascript:void(0)"><i class="W_icon"></i></a>
                                             <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                         </p>
                                         <p style="margin-top: 5px;"><span class="time">${h.bbsSohuPost.dateTime}</span><a href="${h.bbsSohuPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                         <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsSohuPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsSohuPost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>

                                     </li>
                                   </c:if>
                                </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--全部热点网民  end-->
                    <!--豆瓣热点网民  start-->
                    <div id="tab2" class="tab-pane">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                    <c:forEach items="${tbNetizenParticiTop10_douban}" var="h">
                                    <li>
                                        <div class="tx"><img src="images/images3/1.jpg"></div>
                                        <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1">${h.doubanGroupPost.authorName}</a><a href="javascript:void(0)"><i title="" class="W_icon "></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.doubanGroupPost.recommendNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    </li>
                                    </c:forEach>
                                </ul>

                            </div>
                        </div>
                    </div>
                    <!--豆瓣热点网民  end-->
                    <!--人民网社区热点网民  start-->
                    <div id="tab3" class="tab-pane">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                    <c:forEach items="${tbNetizenParticiTop10_bbspeople}" var="h">
                                    <li>
                                        <div class="tx"><img src="images/images3/01.jpg"></div>
                                        <p class="mscrame"><a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1">${h.bbsPeoplePost.authorName}</a><a href="javascript:void(0)"><i title=" " class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsPeoplePost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--人民网社区热点网民  end-->
                    <!--搜狐社区热点网民 start-->
                    <div id="tab4" class="tab-pane">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                    <c:forEach items="${tbNetizenParticiTop10_bbssohu}" var="h">
                                    <li>
                                        <div class="tx"><img src="images/images3/001.jpg"></div>
                                        <p class="mscrame"><a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1">${h.bbsSohuPost.authorName}</a><a href="javascript:void(0)"><i title=" " class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.bbsSohuPost.dateTime}</span><a href="${h.bbsSohuPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsSohuPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsSohuPost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>

                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--搜狐社区热点网民 end-->
                </div>
            </div>
            <hr>
        </div>
    </div>
</div>
<!--JS-->
<script src="js/js3/js1/jquery.min.js"></script>
<script src="js/js3/js1/bootstrap.min.js"></script>
<script src="js/js3/js1/jquery.ui.custom.js"></script>
<script src="js/js3/js1/matrix.js"></script>
</body>
</html>
