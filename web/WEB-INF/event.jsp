<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>舆情分析大平台</title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/bootstrap.min.css" />
  <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
  <link rel="stylesheet" href="css/matrix-style.css" />
  <link rel="stylesheet" href="css/matrix-media.css" />
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/eventAnalysis.css" />
  <link rel="stylesheet" href="css/other.css" />
  <link rel="stylesheet" href="css/report.css" />
  <link rel="stylesheet" href="css/style.css" />
  <link rel="stylesheet" href="font-awesome/css/font-awesome.css" />
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1 style="font-family: 华文行楷;font-size: 27px;padding-top:10px;color: red;">舆情分析大平台</h1>
</div>
<!--close-Header-part-->
<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" >
      <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i><span class="text">欢迎用户</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i>个人资料</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i>我的任务</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-key"></i>注销</a></li>
      </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">信息</span> <b class="caret"></b></a>
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
    <li class=""><a title="" href="#"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
  </ul>
</div>
<div id="search">
  <input type="text" placeholder="在此搜索...."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--sidebar-menu-->
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-th"></i>分析</a>
  <ul style="display: block;background: #2E363F;height: 1150px;">
    <li class="active" style="font-family: 新宋体;font-size: 18px;"><a href="event.jsp"><i class="icon icon-home"></i> <span>事件</span></a> </li>
    <li><a href="#" style="font-family: 新宋体;font-size:18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
    <li><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>意见领袖</span></a> </li>
    <li><a href="#" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>传播途径</span></a></li>
    <li><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>表情分析</span></a></li>
    <li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="#" style="font-family: 新宋体;font-size: 18px;">博主分析</a></li>
        <li><a href="#" style="font-family: 新宋体;font-size: 18px;">男女比例</a></li>
        <li><a href="#" style="font-family: 新宋体;font-size: 18px;">统计</a></li>
      </ul>
    </li>
    <li><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>核心传播人</span></a></li>
    <li><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-pencil"></i><span>热门信息</span></a></li>
    <li><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-file"></i><span>数据类型</span></a></li>
    <li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-info-sign"></i> <span>分布</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="#" style="font-family: 新宋体;font-size: 18px;">微博分布</a></li>
        <li><a href="#" style="font-family:新宋体;font-size: 18px;">地域分布</a></li>
        <li><a href="#"style="font-family: 新宋体;font-size: 18px;">设备分布</a></li>
      </ul>
    </li>
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
  <!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="event.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a></div>
  </div>
  <!--End-breadcrumbs-->

  <!--Action boxes-->
  <div class="container-fluid">
   <%-- <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="event.jsp"> <i class="icon-dashboard"></i> <span class="label label-important"></span> 事件 </a> </li>
        <li class="bg_lg span3" style="width:160px"> <a href="comment.html"> <i class="icon-signal"></i>热点词</a> </li>
        <li class="bg_ly"> <a href="opinion.html"> <i class="icon-inbox"></i><span class="label label-success"></span>意见领袖</a> </li>
        <li class="bg_lo"> <a href="transmission.html"> <i class="icon-th"></i>传播途径</a> </li>
        <li class="bg_ls" > <a href="sentiment.html"> <i class="icon-fullscreen"></i>表情分析</a></li>
        <li class="bg_lo"> <a href="publish.html"> <i class="icon-th-list"></i>分析</a> </li>
        <li class="bg_ls"> <a href="communicate.html"> <i class="icon-tint"></i>核心传播人</a> </li>
        <li class="bg_lb"> <a href="hot.html"> <i class="icon-pencil"></i>热门信息</a> </li>
        <li class="bg_lg"> <a href="calendar.html"> <i class="icon-calendar"></i> 日历</a> </li>
        <li class="bg_lg"> <a href="data.html"> <i class="icon-tint"></i>数据类型</a> </li>
        <li class="bg_lr"> <a href="area.html"> <i class="icon-info-sign"></i>分布</a> </li>
      </ul>
    </div>--%>
    <!--End-Action boxes-->
      <!--事件简介 start-->
      <div class="row-fluid" id="ui-accordion-1" name="r1">
        <div class="widget-box">
          <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
              <h1 style="font-family: 华文行楷;font-size:20px;">事件简介</h1>
          </div>
        <div class="widget-content" style="font-size: 16px;width: 1500px;">
          ${introduction}
        </div>
        </div>
        <!--事件简介 end-->
        <!--事件趋势 start-->
        <div class="widget-box">
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
           <h1 style="font-family: 华文行楷;font-size:20px;">事件趋势</h1>
          </div>
          <!--为echarts准备一个具备大小(宽高)的DOM-->
          <div id="main"  style="width: 1000px;height: 600px;"></div>
        </div>
        </div>
      </div>
  </div>
  </div>
    <!--事件趋势 end-->
<!--end-main-container-part-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/js1/echarts.min.js"></script>
<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

    // if url is empty, skip the menu dividers and reset the menu selection to default
    if (newURL != "") {

      // if url is "-", it is this page -- reset the menu:
      if (newURL == "-" ) {
        resetMenu();
      }
      // else, send page to designated URL
      else {
        document.location.href = newURL;
      }
    }
  }

  // resets the menu selection upon entry to this page:
  function resetMenu() {
    document.gomenu.selector.selectedIndex = 2;
  }
</script>
<script type="text/javascript">
  //基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('main'));
  //指定图表的配置项和数据
  var option = {
    title: {
      text: '事件趋势',
      left: 'center'
    },
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      right: 50,
      orient: 'vertical',
      data: ['原创', '转发', '媒体']
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    toolbox: {
      feature: {
        saveAsImage: {}
      }
    },
    xAxis: {
      type: 'category',
      boundaryGap: false,
      data: ['2016-11-22 00', '2016-11-22 01','2016-11-22 02','2016-11-22 03','2016-11-22 04','2016-11-22 05','2016-11-22 06','2016-11-22 07','2016-11-22 08','2016-11-22 09','2016-11-22 10','2016-11-22 11', '2016-11-22 12','2016-11-22 13', '2016-11-22 14','2016-11-22 15','2016-11-22 16','2016-11-22 17','2016-11-22 18',
        '2016-11-22 19','2016-11-23 20', '2016-11-22 21','2016-11-22 22','2016-11-22 23','2016-11-23 00','2016-11-23 01','2016-11-23 02','2016-11-23 03','2016-11-23 04','2016-11-23 05','2016-11-23 06','2016-11-23 07','2016-11-23 08','2016-11-23 09','2016-11-23 10','2016-11-23 11', '2016-11-23 12','2016-11-23 13',
        '2016-11-23 14','2016-11-23 15','2016-11-23 16','2016-11-23 17']
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {   name:'原创',
        type:'line',
        stack: '总量',
        data: ['0', '0', '0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','3', '42', '99', '77', '64', '95', '60', '35', '20','1','3','0','1','2','7','21','27','38','27','9','6','13','12','14','0']
      },
      {
        name:'转发',
        type:'line',
        stack: '总量',
        data: ['0', '0', '0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','23', '1188', '713', '66', '62', '686', '539', '145', '43','11','3','6','7','14','27','20','112','122','143','137','77','24','27','18','0']
      },
      {
        name:'媒体',
        type:'line',
        stack: '总量',
        data:  ['0', '0', '0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','1', '2', '0', '2', '3', '0', '0', '0', '0','1','3','0','1','2','1','2','1','0','0','0','0','0','1','2','0']
      }

    ]
  };
//使用刚指定的配置项和数据显示图表
  myChart.setOption(option);
</script>
</body>
</html>
