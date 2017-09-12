<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" href="css/css1/common.css" />
  <link rel="stylesheet" href="css/css1/eventAnalysis.css" />
  <link rel="stylesheet" href="css/css1/other.css" />
  <link rel="stylesheet" href="css/css1/report.css" />
  <link rel="stylesheet" href="css/css1/style.css" />
</head>
<body>
<jsp:include page="static/fore_header.jsp"/>
<!--sidebar-menu-->
<jsp:include page="static/fore_lefter.jsp">
  <jsp:param name="eventID" value='<%=request.getSession().getAttribute("eventID")%>'/>
</jsp:include>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a href="#" class="current">热门信息</a> </div>
    <h1>热门信息</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span6">
      </div>
        <div class="widget-box">
          <div class="widget-title">
            <ul class="nav nav-tabs">
              <li class="active"><a data-toggle="tab">全部热门信息</a></li>
              <li><a data-toggle="tab" href="#tab2">豆瓣小组 热门信息</a></li>
              <li><a data-toggle="tab" href="#tab3">人民网BBS 热门信息</a></li>
              <%--<li><a data-toggle="tab" href="#tab5">新华网 热门信息</a></li>--%>
            </ul>
          </div>
          <div class="widget-content tab-content">
            <div id="tab1" class="tab-pane active">
              <div class="wyqBorder wyqBorder2">
              <div class="mwblist mwblist2" id="hotList">
              <ul>
                <c:forEach items="${tableHotValuestop10}" var="h">
                  <c:if test="${h.doubanGroupPost != null}">
                    <li class="hotIn">
                      <div class="tx"><img src="images/${index+1}.jpg">${h.websiteName}</div>
                      <p class="mscrame">
                        <a target="_blank" href="${h.doubanGroupPost.authorHref}" class="a1">${h.doubanGroupPost.authorName}</a>
                        <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                      </p>
                      <p class="wbText">${h.doubanGroupPost.content}</p>
                      <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                      <p class="msfs"><span class="float_l"><span><font class="f_c1">喜欢</font>&nbsp;${h.doubanGroupPost.likeNum}</span><span><font class="f_c1">推荐</font>&nbsp;${h.doubanGroupPost.recommendNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span></span></p>
                    </li>
                  </c:if>

                  <c:if test="${h.bbsPeoplePost != null}">
                    <li class="hotIn">
                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                      <p class="mscrame">
                        <a target="_blank" href="${h.bbsPeoplePost.authorHref}" class="a1">${h.bbsPeoplePost.authorName}</a>
                        <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                      </p>
                      <p class="wbText">${h.bbsPeoplePost.content}</p>
                      <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                      <p class="msfs"><span class="float_l"><span><font class="f_c1">阅读</font>&nbsp;${h.bbsPeoplePost.readNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">回复</font>&nbsp;${h.bbsPeoplePost.replyNum}</span><span><font class="f_c1">打赏</font>&nbsp;${h.bbsPeoplePost.priseNum}</span></span></p>
                    </li>
                  </c:if>

                  <c:if test="${h.xinhuaNews != null}">
                    <li class="hotIn">
                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                      <p class="mscrame">
                        <a target="_blank" href="" class="a1">${h.xinhuaNews.authorName}</a>
                        <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                      </p>
                      <p class="wbText">${h.xinhuaNews.content}</p>
                      <p style="margin-top: 5px;"><span class="time">${h.xinhuaNews.dateTime}</span><a href="${h.xinhuaNews.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                    </li>
                  </c:if>

                </c:forEach>
              </ul>
            </div>
          </div>
        </div>

            <div id="tab2" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                <div class="mwblist mwblist2" id="hotList">
                  <ul>

                    <c:forEach items="${tableHotValuestop10_doubans}" var="h">
                        <li class="hotIn">
                          <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                          <p class="mscrame">
                            <a target="_blank" href="${h.doubanGroupPost.authorHref}" class="a1">${h.doubanGroupPost.authorName}</a>
                            <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                          </p>
                          <p class="wbText">${h.doubanGroupPost.content}</p>
                          <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                          <p class="msfs"><span class="float_l"><span><font class="f_c1">喜欢</font>&nbsp;${h.doubanGroupPost.likeNum}</span><span><font class="f_c1">推荐</font>&nbsp;${h.doubanGroupPost.recommendNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span></span></p>
                        </li>
                    </c:forEach>

                  </ul>
                </div>
                </div>
              </div>
            <div id="tab3" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                <div class="mwblist mwblist2" id="hotList">
                  <ul>
                    <c:forEach items="${tableHotValuestop10_bbsPeoples}" var="h">
                      <li class="hotIn">
                        <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                        <p class="mscrame">
                          <a target="_blank" href="${h.bbsPeoplePost.authorHref}" class="a1">${h.bbsPeoplePost.authorName}</a>
                          <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                        </p>
                        <p class="wbText">${h.bbsPeoplePost.content}</p>
                        <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                        <p class="msfs"><span class="float_l"><span><font class="f_c1">阅读</font>&nbsp;${h.bbsPeoplePost.readNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">回复</font>&nbsp;${h.bbsPeoplePost.replyNum}</span><span><font class="f_c1">打赏</font>&nbsp;${h.bbsPeoplePost.priseNum}</span></span></p>
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>
            <%--<div id="tab5" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                <div class="mwblist mwblist2" id="hotList">
                  <ul>
                    <c:forEach items="${tableHotValuestop10_xinhuanews}" var="h">
                      <li class="hotIn">
                        <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                        <p class="mscrame">
                          <a target="_blank" href="" class="a1">${h.xinhuaNews.authorName}</a>
                          <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                        </p>
                        <p class="wbText">${h.xinhuaNews.content}</p>
                        <p style="margin-top: 5px;"><span class="time">${h.xinhuaNews.dateTime}</span><a href="${h.xinhuaNews.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>--%>

          </div>
    </div>
    <hr>
  </div>
</div>
<!--main-container-part-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/matrix.js"></script>
</body>
</html>
