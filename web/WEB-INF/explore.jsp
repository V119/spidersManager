<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>舆情大数据平台</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/css1/common.css" />
    <link rel="stylesheet" href="css/css1/style.css" />
    <link rel="stylesheet" href="css/css1/layout.css" />
    <link rel="stylesheet" href="css/css1/openWeiboImg.css" />
    <link rel="stylesheet" href="css/css1/message.css" />
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
<!--Header start-->
<div id="header">
    <h1 style="font-family: 华文行楷;font-size: 27px;padding-top:10px;color: red;">舆情分析大平台</h1>
</div>
<!--Header end-->
<!--Header-menu start-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">欢迎用户</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#"><i class="icon-user"></i>个人资料</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-check"></i>我的任务</a></li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="icon-key"></i>注销</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">信息</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i>新信息</a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i>收信信箱</a></li>
                <li class="divider"></li>
                <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i>待发箱</a></li>
                <li class="divider"></li>
                <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i>回收站</a></li>
            </ul>
        </li>
        <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
    </ul>
</div>
<!--Header-menu end-->
<!--serch start-->
<div id="search">
    <input type="text" placeholder="在此搜索...."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--serch end-->
<!-- sidebar-menu start-->
<div id="sidebar">
    <ul style="display: block;background: #2E363F;height: 800px;margin-top:-106px;">
        <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
        <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
        <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
        <li> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
        <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
        <li> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
        <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
        <li><a href="sentiment?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i><span>舆情影响力</span></a></li>
        <li><a href="participant?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>网民参与度</span></a></li>
        <li><a href="negativeIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-home"></i><span>舆情负面指数</span></a></li>
        <li class="active"><a href="explore?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-home"></i><span>舆情引爆点</span></a></li>
    </ul>
</div>
<!-- sidebar-menu end-->
<!--search start-->
<div class="search-wrapper search-wrapper2">
    <form action="keywords" method="post">
        <div class="search" style="margin-left:300px;width:600px;margin-top:60px;">
            <span style="margin-left:100px;"><input type="text" class="keyWord searchkey" name="keywords"   maxlength="20"  id="search-keyword" value="事件关键词"></span>
            <span><button type="submit" class="searchBtn">搜索</button></span>
        </div>
    </form>
</div>
<!--search end-->
<!--main start-->
<div class="mwbBorder">
    <h2>引爆点</h2>
    <div class="mwbcon2 chart_shuiyin">
        <div class="ybdChart">
            <ul id="keyUserTop">
                <li class="ybd_r ybd_r_1">
                    <div class="tx v_yellow">
                        <img src="images/demo/${h.index+1}.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1197161814');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1197161814');">李开复</a></p><p>粉丝：<em>50008471</em></p><p>二次转发：<em>1141</em></p><p><font>转发时间：</font>2016-03-22 21:58</p>
                    </div>
                </li>
                <li class="ybd_r ybd_r_2">
                    <div class="tx v_blue">
                        <img src="http://tva2.sinaimg.cn/crop.0.0.180.180.50/65dfab2djw1e8qgp5bmzyj2050050aa8.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1709157165');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1709157165');">联合国</a></p><p>粉丝：<em>7827838</em></p><p>二次转发：<em>733</em></p><p><font>转发时间：</font>2016-03-23 00:21</p>
                    </div>
                </li>
                <li class="ybd_r ybd_r_3">
                    <div class="tx">
                        <img src="http://tva1.sinaimg.cn/crop.0.0.180.180.50/8380d51ejw1e8qgp5bmzyj2050050aa8.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/2206258462');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/2206258462');">NASA中文</a></p><p>粉丝：<em>3105757</em></p><p>二次转发：<em>721</em></p><p><font>转发时间：</font>2016-03-22 20:37</p>
                </div>
                </li>
                <li class="ybd_r ybd_r_4">
                    <div class="tx">
                        <img src="http://tva1.sinaimg.cn/crop.0.0.750.750.50/62209e25jw8f1wprhp09sj20ku0kudhy.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1646304805');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1646304805');">最爱</a>	</p><p>粉丝：<em>34727</em></p><p>二次转发：<em>597</em></p><p><font>转发时间：</font>2016-03-22 19:18</p>
            </div>	</li>
                <li class="ybd_r ybd_r_5">
                    <div class="tx v_yellow">
                    <img src="http://tva3.sinaimg.cn/crop.0.32.500.500.50/3ed43aafjw8f3rn5ut6kej20go0p00v6.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1054096047');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1054096047');">龚晓明医生</a></p><p>粉丝：<em>838938</em></p><p>二次转发：<em>539</em></p><p><font>转发时间：</font>2016-03-22 19:26</p>
                </div>
                </li>
                <li class="ybd_l ybd_l_5">
                    <div class="tx v_blue">
                        <img src="http://tva3.sinaimg.cn/crop.0.0.200.200.50/75b1a75fjw8evame98iaij205k05kt8p.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1974576991');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1974576991');">环球时报</a></p><p>粉丝：<em>4404656</em></p><p>二次转发：<em>533</em></p>	<p><font>转发时间：</font>2016-03-22 19:12</p>
                </div>
                </li>
                <li class="ybd_l ybd_l_4">
                    <div class="tx">
                        <img src="http://tva2.sinaimg.cn/crop.0.0.180.180.50/6220686bjw1e8qgp5bmzyj2050050aa8.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1646291051');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1646291051');">遐丝</a>	</p><p>粉丝：<em>25345</em></p><p>二次转发：<em>504</em></p><p><font>转发时间：</font>2016-03-22 19:23</p>
                    </div>
                </li>
                <li class="ybd_l ybd_l_3">
                    <div class="tx">
                        <img src="http://tva1.sinaimg.cn/crop.12.6.171.171.50/74395746jw8f28ul4n9nxj205k05k0sy.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1949914950');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1949914950');">愤怒的葡萄2016</a></p><p>粉丝：<em>430</em></p><p>二次转发：<em>422</em></p><p><font>转发时间：</font>2016-03-23 10:37</p>
                    </div>
                </li>
                <li class="ybd_l ybd_l_2">
                    <div class="tx">
                        <img src="http://tva2.sinaimg.cn/crop.0.0.180.180.50/62212e6cjw1e8qgp5bmzyj2050050aa8.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1646341740');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1646341740');">旁观27</a></p><p>粉丝：<em>176</em></p><p>二次转发：<em>392</em></p><p><font>转发时间：</font>2016-03-22 19:28</p>
                    </div>
                </li>
                <li class="ybd_l ybd_l_1">
                    <div class="tx">
                        <img src="http://tva1.sinaimg.cn/crop.0.0.180.180.50/51e81862jw1e8qgp5bmzyj2050050aa8.jpg" style="cursor: pointer;" onclick="javascript:window.open('http://weibo.com/1374165090');">
                    </div>
                    <div class="con"><p><a href="javascript:;" onclick="javascript:window.open('http://weibo.com/1374165090');">别样不二</a></p><p>粉丝：<em>67213</em></p><p>二次转发：<em>390</em></p><p><font>转发时间：</font>2016-03-22 19:29</p>
            </div>
            </li>
            </ul>
        </div>
    </div>
</div>
<!--main end-->
</div>
</body>
</html>