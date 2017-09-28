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
                            <c:if test="${bbs_china_post!=null}">
                            <div class="col-lg-6" style="width: 100%">

                                <div align="center"><h3 class="box-heading">${bbs_china_post.title}</h3></div>
                                <div align="center"><span class="badge badge-default">作者</span>${bbs_china_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="badge badge-yellow">日期</span>${bbs_china_post.dateTime}</div>
                                <br>
                                <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bbs_china_post.content}</p>
                                        <div align="center">
                                            <span class="badge badge-pink">关键词</span>${bbs_china_post.keyWords}&nbsp;&nbsp;
                                            <span class="badge badge-red">热点词</span>${bbs_china_post.hotWords}&nbsp;&nbsp;
                                            <span class="badge badge-green">回复数</span>${bbs_china_post.replyNum}&nbsp;&nbsp;
                                            <span class="badge badge-dark">阅读数</span>${bbs_china_post.readNum}&nbsp;&nbsp;
                                        </div>
                            </div>
                            </c:if>
                            <c:if test="${bbs_sohu_post!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${bbs_sohu_post.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${bbs_sohu_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${bbs_sohu_post.date_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bbs_sohu_post.content}</p>
                                    <div align="center">
                                        <span class="badge badge-pink">回复数</span>${bbs_sohu_post.replyNum}&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${bbs_mop_post!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${bbs_mop_post.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${bbs_mop_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${bbs_mop_post.date_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bbs_mop_post.content}</p>
                                    <div align="center">
                                        <span class="badge badge-pink">推荐数</span>${bbs_mop_post.recommendNum}&nbsp;&nbsp;
                                        <span class="badge badge-red">收藏数</span>${bbs_mop_post.collectNum}&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${bbs_news_post!=null}">
                                <div class="col-lg-6" style="width: 100%">

                                    <div align="center"><h3 class="box-heading">${bbs_news_post.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${bbs_news_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${bbs_news_post.date_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bbs_news_post.content}</p>
                                    <div align="center">
                                        <span class="badge badge-pink">评论数</span>${bbs_news_post.commentNum}&nbsp;&nbsp;
                                        <span class="badge badge-red">赞</span>${bbs_news_post.likeNum}&nbsp;&nbsp;
                                        <span class="badge badge-dark">阅读数</span>${bbs_news_post.readNum}&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if><c:if test="${bbs_people_post!=null}">
                            <div class="col-lg-6" style="width: 100%">

                                <div align="center"><h3 class="box-heading">${bbs_people_post.title}</h3></div>
                                <div align="center"><span class="badge badge-default">作者</span>${bbs_people_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="badge badge-yellow">日期</span>${bbs_people_post.date_time}</div>
                                <br>
                                <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bbs_people_post.content}</p>
                                <div align="center">
                                    <span class="badge badge-pink">关键词</span>${bbs_people_post.keyWords}&nbsp;&nbsp;
                                    <span class="badge badge-green">回复数</span>${bbs_people_post.replyNum}&nbsp;&nbsp;
                                    <span class="badge badge-dark">阅读数</span>${bbs_people_post.readNum}&nbsp;&nbsp;
                                </div>
                            </div>
                        </c:if>
                            <c:if test="${blogchina_blog_1!=null}">
                            <div class="col-lg-6" style="width: 100%">
                                <div align="center"><h3 class="box-heading">${blogchina_blog_1.title}</h3></div>
                                <div align="center"><span class="badge badge-default">分类</span>${blogchina_blog_1.category}&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="badge badge-yellow">日期</span>${blogchina_blog_1.publish_time}</div>
                                <br>
                                <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${blogchina_blog_1.content}</p>
                                <div align="center">
                                    <span class="badge badge-green">评论数</span>${blogchina_blog_1.commentNum}&nbsp;&nbsp;
                                    <span class="badge badge-dark">阅读数</span>${blogchina_blog_1.readNum}&nbsp;&nbsp;
                                </div>
                            </div>
                        </c:if>
                            <c:if test="${blog_sina_post!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${blog_sina_post.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${blog_sina_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${blog_sina_post.date_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${blog_sina_post.content}</p>
                                    <div align="center">
                                        <span class="badge badge-pink">关键词</span>${blog_sina_post.keyWords}&nbsp;&nbsp;
                                        <span class="badge badge-red">评论数</span>${blog_sina_post.commentNum}&nbsp;&nbsp;
                                        <span class="badge badge-dark">阅读数</span>${blog_sina_post.readNum}&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${douban_group_post!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${douban_group_post.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${douban_group_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${douban_group_post.date_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${douban_group_post.content}</p>
                                    <div align="center">
                                        <span class="badge badge-pink">赞</span>${douban_group_post.likeNum}&nbsp;&nbsp;
                                        <span class="badge badge-dark">推荐数</span>${douban_group_post.recommentNum}&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${xinhua_news!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${xinhua_news.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${xinhua_news.editor}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${xinhua_news.date_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${xinhua_news.content}</p>
                                </div>
                            </c:if>
                            <c:if test="${kdnet_post!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${kdnet_post.title}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${kdnet_post.authorName}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${kdnet_post.post_time}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${kdnet_post.content}</p>
                                    <div align="center">

                                        <span class="badge badge-dark">评论数</span>${kdnet_post.commentNum}&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${postMoeInfo!=null}">
                                <div class="col-lg-6" style="width: 100%">
                                    <div align="center"><h3 class="box-heading">${postMoeInfo.newsTitle}</h3></div>
                                    <div align="center"><span class="badge badge-default">作者</span>${postMoeInfo.newsEditor}&nbsp;&nbsp;&nbsp;&nbsp;
                                        <span class="badge badge-yellow">日期</span>${postMoeInfo.newsTime}</div>
                                    <br>
                                    <p style="line-height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${postMoeInfo.newsContent}</p>
                                </div>
                            </c:if>
                        </div>

                        <!--评论-->
                        <div class="page-title-breadcrumb">
                            <div class="clearfix"></div>
                        </div>
                        <c:if test="${bbs_china_comment!=null}">
                        <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                            <ul class="media-list">

                                    <c:forEach items="${bbs_china_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                            </ul>
                        </div>
                        </c:if>
                        <c:if test="${bbs_mop_comment!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${bbs_mop_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${bbs_news_comment!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${bbs_news_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${bbs_sohu_comment!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${bbs_sohu_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${blog_163_comment!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${blog_163_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${blogchina_comment_1!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${blogchina_comment_1}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${douban_group_comment!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${douban_group_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${kdnet_comment!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${kdnet_comment}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${xinhua_news!=null}">
                            <div class="col-lg-6"><h4 class="box-heading">评论</h4>
                                <ul class="media-list">

                                    <c:forEach items="${xinhua_news}" var="c" varStatus="status">
                                        <li class="media">
                                            <img data-src="holder.js/64x64/text:${status.index}楼楼主" alt="64x64" class="media-object"/>
                                            <div><a style="color: black">${c.authorName} :${c.content}</a></div>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </c:if>
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

