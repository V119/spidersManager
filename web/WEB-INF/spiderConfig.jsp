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
                        第二步：配置爬虫</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>爬虫管理</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">配置爬虫</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">配置爬虫</li>
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
                            <input id="spider-id" data="${spiderID}" type="hidden">
                            <form action="#">
                                <div class="form-body pal">
<%--<c:forEach var="configItem" items="${configItemList}" varStatus="status">--%>
                                    <%--<div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">${configItem.displayName} </a>
                                        <div class="input-icon right">
    <c:if test="${configItem.type == 'int'}">
        <input id="sel_${status.index}" conf-id="${configItem.id}" type="text" class="span6" placeholder="默认值" onblur="checkType('int', '${configItem.id}');"/>
    </c:if>
    <c:if test="${configItem.type == 'boolean'}">
        <select id="sel_${status.index}" conf-id="${configItem.id}" class="span6">
            <option value="" selected="selected">默认值</option>
            <option value="True">True</option>
            <option value="False">False</option>
        </select>
    </c:if>
    <c:if test="${configItem.type == 'text'}">
        <textarea id="sel_${status.index}" conf-id="${configItem.id}" placeholder="默认值" class="span6"></textarea>
    </c:if>
                                            <input id="spiderName" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>--%>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">ROBOTSTXT_OBEY:</a>
                                        <div class="input-icon right">
                                            <select class="form-control" id="websiteID">
                                                <c:forEach var="ws" items="${wsList}" varStatus="status">
                                                    <option value="${ws.id}">${ws.websiteName}</option>
                                                </c:forEach>
                                            </select></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">DOWNLOAD_MAXSIZE:</a>
                                        <div class="input-icon right">
                                            <input id="DOWNLOAD_MAXSIZE" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">DOWNLOAD_TIMEOUT:</a>
                                        <div class="input-icon right">
                                            <input id="DOWNLOAD_TIMEOUT" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">DNS_TIMEOUT:</a>
                                        <div class="input-icon right">
                                            <input id="DNS_TIMEOUT" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">DEPTH_LIMIT:</a>
                                        <div class="input-icon right">
                                            <input id="DEPTH_LIMIT:" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">CON_REQ_PER_IP:</a>
                                        <div class="input-icon right">
                                            <input id="CON_REQ_PER_IP" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">CON_REQ_PER_DOM:</a>
                                        <div class="input-icon right">
                                            <input id="CON_REQ_PER_DOM" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">CON_ITEMS:</a>
                                        <div class="input-icon right">
                                            <input id="CON_ITEMS" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                    </div>
                                    <div class="form-group">
                                        <a style="font-family: 黑体;color: black;font-size: 16px">DEPTH_STATS:</a>
                                        <div class="input-icon right">
                                            <select class="form-control" id="DEPTH_STATS">
                                                <c:forEach var="ws" items="${wsList}" varStatus="status">
                                                    <option value="${ws.id}">${ws.websiteName}</option>
                                                </c:forEach>
                                            </select></div>
                                    </div>

                                </div>
                                <div class="form-actions text-right pal">
                                    <button type="submit" class="btn btn-primary" onclick=""><a href="spiderConfig"></a>
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
        var validate = true;
        function checkType(type, id) {
            var input_id = 'sel_' + id;
            var label_id = 'prompt_' + id;

            var val = $("#"+input_id).val();
//        if(val == "" || val.trim() == "") {
//            $("#" + label_id).html("不能为空！！");
//            $("#" + label_id).css("display", "inline");
//            $("#" + label_id).css("color", "red");
//            $("#" + label_id).css("font-size", "14px");
//
//            return false;
//        }

            if(type == "int") {
                var num_reg = new RegExp("^[0-9]*$");
                if(!num_reg.test(val)) {
                    $("#" + label_id).html("请输入数字！！");
                    $("#" + label_id).css("display", "inline");
                    $("#" + label_id).css("color", "red");
                    $("#" + label_id).css("font-size", "14px");

                    validate = false;

                    return false;
                } else {
                    $("#" + label_id).html("");
                    $("#" + label_id).css("display", "inline");

                    validate = true;

                    return true;
                }
            }

        }

        function saveConfig() {
            if(!validate) {
                alert("输入不正确！！")
                return false;
            }
            var spider_id = $("#spider-id").attr("data");
            var shit = $("#conf-info").attr("fuck");
            var configJSON = "{";
            for(var i = 0; i < shit; i++) {
                configJSON = configJSON + "'" + $("#sel_" + i).attr("conf-id") + "': '" + $("#sel_" + i).val() + "'";
                if(i < shit - 1) {
                    configJSON += ","
                }
            }
            configJSON += "}";

            $.ajax({
                type : 'post',
                url : 'saveSpiderConfig',
                data : {
                    "spider_id": spider_id,
                    "config": configJSON
                },
                success : function (msg) {
                    if(msg == "success") {
                        alert("保存成功！！");
                        window.location.href = "viewSpiderConfig";
                    } else {
                        alert("保存失败！！");
                    }
                }
            })
        }
    </script>

</body>
</html>

