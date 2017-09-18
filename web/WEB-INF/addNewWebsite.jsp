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
        <jsp:include page="static/leftNav.jsp"/>
        <!--END SIDEBAR MENU-->

        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
              <div class="page-header pull-left">
                <div class="page-title">
                  新增网址</div>
              </div>
              <ol class="breadcrumb page-breadcrumb pull-right">
                <li><i class="fa fa-home"></i>&nbsp;<a>爬虫管理</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                <li class="hidden"><a href="#">新增网址</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                <li class="active">新增网址</li>
              </ol>
              <div class="clearfix">
              </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content">
                <div style="width: 40%;margin-left: 30%;margin-top: 10%">
                <div class="panel panel-orange">
                    <%--<div class="panel-heading">
                        Registration form</div>--%>
                    <div class="panel-body pan">
                        <form action="#">
                            <div class="form-body pal">
                                <div class="form-group">
                                    <a style="font-family: 黑体;color: black;font-size: 16px">网站名称:</a>
                                    <div class="input-icon right">
                                       <input id="inputName" type="text" placeholder="新浪" class="form-control" /></div>
                                </div>
                                <div class="form-group">
                                    <a style="font-family: 黑体;color: black;font-size: 16px">URL:</a>
                                    <div class="input-icon right">
                                        <input id="inputEmail" type="text" placeholder="https://weibo/..." class="form-control" /></div>
                                </div>

                                <div class="form-group">
                                    <a style="font-family: 黑体;color: black;font-size: 16px">网站类型:</a>
                                    <select class="form-control">
                                        <c:forEach var="site" items="${siteVlaue}" varStatus="status">
                                            <option value="${site}">${site}</option>
                                        </c:forEach>
                                    </select></div>

                            </div>
                            <div class="form-actions text-right pal">
                                <button type="submit" class="btn btn-primary" onclick="saveWS();">
                                    提交</button>
                            </div>
                        </form>
                    </div>
                </div>
                </div>
                    
                <!--END CONTENT-->


                <!--BEGIN FOOTER-->
                <jsp:include page="static/footer.jsp"/>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>

    <jsp:include page="static/footer_script.jsp"/>
    <script>
        var validate_url = false;
        var validate_name = false;
        function saveWS(){
            var website = {};

//        var websiteName = $("#websiteName").val();
//        var websiteUrl = $("#websiteUrl").val();
//        var siteType = $("#siteType").val();
            website['websiteType'] = $("#siteType").val();
            website['websiteName'] = $("#websiteName").val();
            website['websiteUrl'] = $("#websiteUrl").val();

            if(!validate_url || !validate_name) {
                alert("输入不正确");
                return false;
            } else {
                $.ajax({
                    async : false,//将async设置为false,才能使得return 返回true/false有效
                    type : 'post',
                    url : 'saveWebsite',
                    data: website,
                    success : function (msg){
                        if(msg == 'success'){
                            alert("添加成功");
                        }else{
                            alert("添加失败");
                        }
                    }
                });
            }
        }

        function checkSiteName() {
            var siteName = $("#websiteName").val();
            var flag = 0;

            if(siteName == "") {
                $("#prompt_site_name").html("网站名称不能为空！！");
                $("#prompt_site_name").css("display", "inline");
                $("#prompt_site_name").css("color", "red");
                $("#prompt_site_name").css("font-size", "14px");

                validate_name = false;

                return false;
            }

            $.ajax({
                type : 'post',
                url : 'checkSiteName?siteName=' + siteName,
                success : function (msg) {
                    if(msg == "exist") {
                        $("#prompt_site_name").html("网站名称已存在！！");
                        $("#prompt_site_name").css("display", "inline");
                        $("#prompt_site_name").css("color", "red");
                        $("#prompt_site_name").css("font-size", "14px");
                        validate_name = false;
                    } else {
                        $("#prompt_site_name").html("");
                        $("#prompt_site_name").css("display", "inline");
                        validate_name = true;
                        flag = 0;
                    }
                }
            });

            if(flag == 1) {
                return false;
            } else {
                return true;
            }
        }

        function checkSiteUrl() {
            var siteUrl = $("#websiteUrl").val();

            if(siteUrl == "") {
                $("#prompt_site_url").html("Url不能为空！！");
                $("#prompt_site_url").css("display", "inline");
                $("#prompt_site_url").css("color", "red");
                $("#prompt_site_url").css("font-size", "14px");
                validate_url = false;

                return false;
            }

            var is_url = isUrl(siteUrl);

            if(!is_url) {
                $("#prompt_site_url").html("不是正确的URL！！");
                $("#prompt_site_url").css("display", "inline");
                $("#prompt_site_url").css("color", "red");
                $("#prompt_site_url").css("font-size", "14px");
                validate_url = false;

                return false;
            }

            $.ajax({
                type : 'post',
                url : 'checkSiteUrl?siteUrl=' + siteUrl,
                success : function (msg) {
                    if(msg == "exist") {
                        $("#prompt_site_url").html("网站URL已存在！！");
                        $("#prompt_site_url").css("display", "inline");
                        $("#prompt_site_url").css("color", "red");
                        $("#prompt_site_url").css("font-size", "14px");
                        validate_url = false;
                        return false;
                    } else {
                        $("#prompt_site_url").html("");
                        $("#prompt_site_url").css("display", "inline");
                        validate_url = true;
                        return true;
                    }
                }
            });
        }

        function isUrl(str_url) {
            var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
                + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
                + "[a-z]{2,6})" // first level domain- .com or .museum
                + "(:[0-9]{1,4})?" // 端口- :80
                + "((/?)|" // a slash isn't required if there is no file name
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
            var re=new RegExp(strRegex);
            //re.test()
            if (re.test(str_url)){
                return true;
            }else{
                return false;
            }
        }
    </script>
</body>
</html>
