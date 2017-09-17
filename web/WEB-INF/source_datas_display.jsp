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
                <ul id="generalTab" class="nav nav-tabs responsive">
                  <li class="active"><a href="#label-badge-tab" data-toggle="tab">全部</a></li>
                  <li><a href="#list-group-tab" data-toggle="tab">中华网</a></li>
                  <li><a href="#list-group-tab" data-toggle="tab">猫扑网</a></li>
                  <li><a href="#list-group-tab" data-toggle="tab">新华网</a></li>
                  <li><a href="#list-group-tab" data-toggle="tab">人民网</a></li>
                  <li><a href="#list-group-tab" data-toggle="tab">搜狐网</a></li>
                  <li><a href="#list-group-tab" data-toggle="tab">天涯网</a></li>
                </ul>
                <div id="generalTabContent" class="tab-content responsive">
                  <div id="label-badge-tab" class="tab-pane fade in active">
                    <div class="row">
                      <div class="col-lg-6"><h3>Labels</h3><span class="label label-default">Default</span>&nbsp;<span class="label label-primary">Primary</span>&nbsp;<span class="label label-success">Success</span>&nbsp;<span class="label label-info">Info</span>&nbsp;<span class="label label-warning">Warning</span>&nbsp;<span class="label label-danger">Danger</span>

                        <div class="mbxl"></div>
                        <h3>Label Colors</h3><span class="label label-red">Red</span>&nbsp;<span class="label label-orange">Orange</span>&nbsp;<span class="label label-green">Green</span>&nbsp;<span class="label label-yellow">Yellow</span>&nbsp;<span class="label label-blue">Blue</span>&nbsp;<span class="label label-violet">Violet</span>&nbsp;<span
                                class="label label-pink">Pink</span>&nbsp;<span class="label label-grey">Grey</span>&nbsp;<span class="label label-dark">Dark</span>

                        <div class="mbxl"></div>
                        <h3>Label In Headings</h3>

                        <h1>Example heading
                          &nbsp;<span class="label label-default">Default</span></h1>

                        <h2>Example heading
                          &nbsp;<span class="label label-primary">Primary</span></h2>

                        <h3>Example heading
                          &nbsp;<span class="label label-success">Success</span></h3><h4>Example heading
                          &nbsp;<span class="label label-warning">Warning</span></h4><h5>Example heading
                          &nbsp;<span class="label label-info">Info</span></h5><h6>Example heading
                          &nbsp;<span class="label label-danger">Danger</span></h6></div>
                      <div class="col-lg-6"><h3>Badges</h3><span class="badge badge-default">Default</span>&nbsp;<span class="badge badge-primary">Primary</span>&nbsp;<span class="badge badge-success">Success</span>&nbsp;<span class="badge badge-warning">Warning</span>&nbsp;<span class="badge badge-info">Info</span>&nbsp;<span class="badge badge-danger">Danger</span>

                        <div class="mbxl"></div>
                        <h3>Badge Colors</h3><span class="badge badge-red">Red</span>&nbsp;<span class="badge badge-orange">Orange</span>&nbsp;<span class="badge badge-green">Green</span>&nbsp;<span class="badge badge-yellow">Yellow</span>&nbsp;<span class="badge badge-blue">Blue</span>&nbsp;<span class="badge badge-pink">Pink</span>&nbsp;<span
                                class="badge badge-violet">Violet</span>&nbsp;<span class="badge badge-grey">Grey</span>&nbsp;<span class="badge badge-dark">Dark</span>

                        <div class="mtxl"></div>
                        <h3>Badges List Navigations</h3>
                        <ul style="max-width: 260px;" class="nav nav-pills nav-stacked">
                          <li class="active"><a href="#"><span class="badge pull-right">2</span>Home</a></li>
                          <li><a href="#">Profile</a></li>
                          <li><a href="#"><span class="badge badge-warning pull-right">3</span>Messages</a></li>
                        </ul>
                        <div class="mtxl"></div>
                        <h3>Badge In Pill</h3>
                        <ul class="nav nav-pills">
                          <li class="active"><a href="#">Home
                            &nbsp;<span class="badge badge-green">3</span></a></li>
                          <li><a href="#">Profile</a></li>
                          <li><a href="#">Messages
                            &nbsp;<span class="badge badge-info">3</span></a></li>
                        </ul>
                        <div class="mbxl"></div>
                        <h3>Badge With Button Dropdown</h3>

                        <div class="btn-group">
                          <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">Account
                            &nbsp;<i class="fa fa-angle-down"></i></button>
                          <ul role="menu" class="dropdown-menu">
                            <li><a href="#">Action<span class="badge badge-yellow pull-right">5</span></a></li>
                            <li><a href="#">Another action<span class="badge badge-info pull-right">3</span></a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                          </ul>
                        </div>
                        &nbsp;
                        <div class="btn-group">
                          <button type="button" class="btn btn-primary">Chats</button>
                          <button type="button" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true" class="btn btn-primary dropdown-toggle"><i class="fa fa-angle-down"></i></button>
                          <ul class="dropdown-menu">
                            <li><a href="#"><span class="label label-warning">7:00 AM</span>&nbsp;
                              Hi :)</a></li>
                            <li><a href="#"><span class="label label-warning">8:00 AM</span>&nbsp;
                              How are you?</a></li>
                            <li><a href="#"><span class="label label-warning">9:00 AM</span>&nbsp;
                              What are you doing?</a></li>
                            <li class="divider"></li>
                            <li><a href="#" class="text-center">View All</a></li>
                          </ul>
                        </div>
                        &nbsp;
                        <div class="btn-group">
                          <button type="button" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true" class="btn btn-primary dropdown-toggle">Inbox
                            &nbsp;<span class="badge badge-yellow">25</span></button>
                          <ul class="dropdown-menu pull-right">
                            <li><a href="#"><span class="label label-info"><i class="fa fa-bell"></i></span>&nbsp;
                              Favourites Snippet</a></li>
                            <li><a href="#"><span class="label label-red"><i class="fa fa-magic"></i></span>&nbsp;
                              Email marketing</a></li>
                            <li><a href="#"><span class="label label-yellow"><i class="fa fa-bullhorn"></i></span>&nbsp;
                              Subscriber focused email design</a></li>
                            <li class="divider"></li>
                            <li><a href="#" class="text-center">View All</a></li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div id="list-group-tab" class="tab-pane fade">
                    <div class="row">
                      <div class="col-lg-4"><h4 class="box-heading">Basic</h4>
                        <ul class="list-group">
                          <li class="list-group-item">Cras justo odio</li>
                          <li class="list-group-item">Dapibus ac facilisis in</li>
                          <li class="list-group-item">Morbi leo risus</li>
                          <li class="list-group-item">Porta ac consectetur ac</li>
                          <li class="list-group-item">Vestibulum at eros</li>
                          <li class="list-group-item">Morbi leo risus</li>
                        </ul>
                        <div class="mbxl"></div>
                        <h4 class="box-heading">Contextual classes</h4>
                        <ul class="list-group">
                          <li class="list-group-item list-group-item-success">Dapibus ac facilisis in</li>
                          <li class="list-group-item list-group-item-info">Cras sit amet nibh libero</li>
                          <li class="list-group-item list-group-item-warning">Porta ac consectetur ac</li>
                          <li class="list-group-item list-group-item-danger">Vestibulum at eros</li>
                        </ul>
                      </div>
                      <div class="col-lg-4"><h4 class="box-heading">Badges</h4>

                        <div class="list-group"><a href="#" class="list-group-item active">Cras justo odio<span class="badge badge-info pull-right">4</span></a><a href="#" class="list-group-item">Dapibus ac facilisis in<span class="badge badge-warning pull-right">2</span></a><a href="#" class="list-group-item">Morbi leo risus<span
                                class="badge badge-danger pull-right">3</span></a><a href="#" class="list-group-item">Porta ac consectetur ac<span class="badge badge-info pull-right">8</span></a><a href="#" class="list-group-item">Vestibulum at eros<span class="badge badge-success pull-right">1</span></a><a href="#" class="list-group-item">Morbi leo risus<span
                                class="badge badge-danger pull-right">5</span></a></div>
                        <div class="mbxl"></div>
                        <h4 class="box-heading">Contextual classes with '.active'</h4>

                        <div class="list-group"><a href="#" class="list-group-item list-group-item-success">Dapibus ac facilisis in</a><a href="#" class="list-group-item list-group-item-info">Cras sit amet nibh libero</a><a href="#" class="list-group-item list-group-item-warning">Porta ac consectetur ac</a><a href="#" class="list-group-item list-group-item-danger">Vestibulum at
                          eros</a></div>
                      </div>
                      <div class="col-lg-4"><h4 class="box-heading">Linked Items</h4>

                        <div class="list-group"><a href="#" class="list-group-item active">Cras justo odio</a><a href="#" class="list-group-item">Dapibus ac facilisis in</a><a href="#" class="list-group-item">Morbi leo risus</a><a href="#" class="list-group-item">Porta ac consectetur ac</a><a href="#" class="list-group-item">Vestibulum at eros</a><a href="#"
                                                                                                                                                                                                                                                                                                                                                                class="list-group-item">Morbi
                          leo risus</a></div>
                        <div class="mbxl"></div>
                        <h4 class="box-heading">Custom Content</h4>

                        <div class="list-group"><a href="#" class="list-group-item active"><h4 class="list-group-item-heading">List group item heading</h4>

                          <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p></a><a href="#" class="list-group-item"><h4 class="list-group-item-heading">List group item heading</h4>

                          <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p></a><a href="#" class="list-group-item"><h4 class="list-group-item-heading">List group item heading</h4>

                          <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p></a></div>
                      </div>
                    </div>
                  </div>

                </div>
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
