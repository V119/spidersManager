<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Social Mind底层配置管理平台</title><meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <link rel="stylesheet" href="css/maruti-style.css" />
    <link rel="stylesheet" href="css/maruti-media.css" class="skin-color" />
</head>
<body>

<!--Header-part-->
<div id="header">
    <h1><a href="http://www.mafiashare.net">Social Mind底层配置管理平台</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-messaages-->
<div class="btn-group rightzero"> <a class="top_message tip-left" title="Manage Files"><i class="icon-file"></i></a> <a class="top_message tip-bottom" title="Manage Users"><i class="icon-user"></i></a> <a class="top_message tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a> <a class="top_message tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a> </div>
<!--close-top-Header-messaages-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li class="" ><a title="" href="#"><i class="icon icon-user"></i> <span class="text">个人中心</span></a></li>

        <li class=""><a title="" href="login.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
    </ul>
</div>
<div id="search">
    <input type="text" placeholder="Search here..."/>
    <button type="submit" class="tip-left" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-Header-menu-->

<div id="sidebar"><a href="index" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
    <ul>
        <li class="active" style="width:6%"><a href="index"><i class="icon icon-home"></i> <span>首页</span></a></li>

        <li class="submenu" style="width:8%"> <i class="icon icon-th-list"></i> <span>爬虫管理</span> <span class="label">4</span>
            <ul style="width:20px">
                <li><a href="form-wizard.jsp">现有爬虫展示</a></li>
                <li><a href="form-common.jsp">新增爬虫</a></li>
                <li><a href="form-validation.jsp">修改爬虫</a></li>
                <li><a href="form-wizard.jsp">删除爬虫</a></li>
            </ul>
        </li>
        <li class="submenu" style="width:8%"><i class="icon icon-file"></i> <span>数据清洗</span> <span class="label">4</span>
            <ul>
                <li><a href="source_datas">源数据库展示</a></li>
                <li><a href="source_data">数据清理展示                                  </a></li>
                <li><a href="source_datas_display">源数据展示</a></li>
                <li><a href="calendar.jsp">新增清洗过程</a></li>
                <li><a href="chat.jsp">清洗过程配置</a></li>
                <li><a href="cleaned_datas">清洗后数据展示</a></li>
                <li><a href="test">test</a></li>
            </ul>
        </li>
        <li class="submenu" style="width:8%"><i class="icon icon-th-list"></i><span>舆情分析指标</span><span class="label">3</span>
            <ul>
                <li><a href="login">网络舆情事件主页</a></li>
                <li><a href="event?eventID=${eventID}">舆情分析指标的主界面</a></li>
                <li><a href="test">test</a></li>
            </ul>
        </li>
    </ul>
</div>

<script src="js/excanvas.min.js"></script>
<script src="js/jquery.min.js"></script>
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
</body>

</html>
