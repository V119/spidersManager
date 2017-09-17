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
        <div id="page-wrapper" style="position:absolute; height:100%; overflow-y:auto">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        引爆点</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">引爆点</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">引爆点</li>
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

                            <div class="page-content">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <div id="grid-layout-table-1" class="box jplist">
                                                    <div class="box text-shadow">
                                                        <table class="demo-tbl"><!--<item>1</item>-->
                                                            <tr class="tbl-item"><!--<img/>-->
                                                                <td class="img"><img src="images/thumbs/arch-1.jpg" alt="" title=""/></td>
                                                                <!--<data></data>-->
                                                                <td class="td-block"><p class="date">03/15/2012</p>

                                                                    <p class="title">Arch</p>

                                                                    <p class="desc">An arch is a structure that spans a space and supports a load. Arches appeared as early as the 2nd millennium BC in Mesopotamian brick architecture and their systematic use started with the Ancient Romans who were the first to apply the technique to a wide range of structures.</p>

                                                                    <p class="like">5 Likes</p></td>
                                                            </tr>
                                                            <!--<item>2</item>-->
                                                            <tr class="tbl-item"><!--<img/>-->
                                                                <td class="img"><img src="images/thumbs/arch-2.jpg" alt="" title=""/></td>
                                                                <!--<data></data>-->
                                                                <td class="td-block"><p class="date">03/18/2012</p>

                                                                    <p class="title">Architecture</p>

                                                                    <p class="desc">Architecture is both the process and product of planning, designing and construction. Architectural works, in the material form of buildings, are often perceived as cultural symbols and as works of art. Historical civilizations are often identified with their surviving architectural achievements.</p>

                                                                    <p class="like">25 Likes</p></td>
                                                            </tr>
                                                            <!--<item>3</item>-->
                                                            <tr class="tbl-item"><!--<img/>-->
                                                                <td class="img"><img src="images/thumbs/autumn-1.jpg" alt="" title=""/></td>
                                                                <!--<data></data>-->
                                                                <td class="td-block"><p class="date">01/16/2011</p>

                                                                    <p class="title">Autumn</p>

                                                                    <p class="desc">Autumn or Fall is one of the four temperate seasons. Autumn marks the transition from summer into winter, in September (Northern Hemisphere) or March (Southern Hemisphere) when the arrival of night becomes noticeably earlier. The equinoxes might be expected to be in the middle of their respective seasons, but temperature lag
                                                                        (caused by the thermal latency of the ground and sea) means that seasons appear later than dates calculated from a purely astronomical perspective.</p>

                                                                    <p class="like">12 Likes</p></td>
                                                            </tr>

                                                        </table>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
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
