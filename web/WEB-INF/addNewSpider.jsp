   <%--
  Created by IntelliJ IDEA.
  User: haoyang
  Date: 2017/4/22
  Time: 17:04
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
                           第一步：新增爬虫</div>
                   </div>
                   <ol class="breadcrumb page-breadcrumb pull-right">
                       <li><i class="fa fa-home"></i>&nbsp;<a>爬虫管理</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                       <li class="hidden"><a href="#">新增爬虫</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                       <li class="active">新增爬虫</li>
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
                                           <a style="font-family: 黑体;color: black;font-size: 16px">爬虫名:</a>
                                           <div class="input-icon right">
                                               <input id="spiderName" type="text"  class="form-control" onblur="checkSiteName()"/></div>
                                       </div>
                                       <div class="form-group">
                                           <a style="font-family: 黑体;color: black;font-size: 16px">网站:</a>
                                           <div class="input-icon right">
                                               <select class="form-control" id="websiteID">
                                                   <c:forEach var="ws" items="${wsList}" varStatus="status">
                                                       <option value="${ws.id}">${ws.websiteName}</option>
                                                   </c:forEach>
                                               </select></div>
                                       </div>

                                       <div class="form-group">
                                           <a style="font-family: 黑体;color: black;font-size: 16px">爬虫源码:</a><input id="fileName" type="file" placeholder="Inlcude some file" />
                                           </div>

                                   </div>
                                   <div class="form-actions text-right pal">
                                       <button type="submit" class="btn btn-primary" onclick=""><a href="spiderConfig">下一步</a>
                                           </button>
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
           var uid = WebUploader.guid();
           var fileName = undefined;
           var checkSpiderName = false;

           var uploader = WebUploader.create({

               // swf文件路径
               swf : '<%=path%>/others/webuploader/Uploader.swf',

               // 文件接收服务端。
               server : 'saveSpiderFile',

               auto : true,

               fileNumLimit : 1,

               chunked : true,

               chunkRetry : 4,  //分片上传失败之后的重试次数

               threads : 3,  //上传并发数。允许同时最大3个上传进程
               //去重
               duplicate : true,

               // 选择文件的按钮。可选。
               // 内部根据当前运行是创建，可能是input元素，也可能是flash.
               pick : '#picker',

               formData : {
                   'uid' : uid
               }
           });

           // 当有文件被添加进队列的时候
           uploader.on('fileQueued', function(file) {
               //alert(123);
               $("#fileName")[0].value = file.name;
               $("#theList").text('等待上传...');
           });

           uploader.on('uploadSuccess', function(file) {
               fileName = file.name;
               //$("#theList").append('<p class="state">上传完成</p>');
               $("#theList").text('上传完成');
               //document.getElementById("theList").text('上传完成')
               $('#saveBtn').removeAttr('disabled');
           });

           uploader.on('uploadError', function(file) {
               uploader.removeFile( file );
               fileName = undefined;

               $("#theList").text('上传出错');
               $('#saveBtn').attr("disabled", "disabled");
           });

           uploader.on('uploadComplete', function(file) {
               $('#theList').find('.progress').fadeOut();
           });


           $("#saveBtn").on('click', function() {
               if ($(this).hasClass('disabled')) {
                   return false;
               }

               if(!checkSpiderName) {
                   alert("爬虫名不能为空！！")
                   return false;
               }

               if(fileName != undefined && fileName != "") {
                   var spiderName = $("#spiderName").val();
                   var websiteID = $("#websiteID").val();

                   //对其他信息进行上传
                   $.ajax({
                       type : 'post',
                       url : "saveSpiderInfo?spiderName=" + spiderName + "&websiteID=" + websiteID
                       + "&fileID=" + uid + "&fileName=" + fileName,
                       success : function (msg){
                           var msgJson = JSON.parse(msg);

                           var result = msgJson.result;
                           if(result == 'success'){
                               alert("添加成功");
                               window.location.href="spiderConfig?spiderID=" + msgJson.spiderID;
                           }else{
                               alert("添加失败");
                           }
                       },
                       error : function(msg) {
                           alert(msg)
                       }
                   })
               } else {
                   alert("文件不存在，请重新上传！！")
               }
           });

           function checkSiteName() {
               var siteName = $("#spiderName").val();

               if(siteName == "" || siteName.trim() == "") {
                   /*$("#prompt_spider_name").html("爬虫名不能为空！！");
                   $("#prompt_spider_name").css("display", "inline");
                   $("#prompt_spider_name").css("color", "red");
                   $("#prompt_spider_name").css("font-size", "14px");*/
                    alert("爬虫名不能为空");
                   checkSpiderName = false;

                   return false;
               }

               checkSpiderName = true;
               return true;
           }
       </script>
   </body>
   </html>

