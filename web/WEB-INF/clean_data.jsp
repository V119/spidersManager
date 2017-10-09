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
<head>
  <script src="js/etljs/html5.js"></script>
  <![endif]-->

  <!-- core js files -->
  <script src="js/etljs/jquery-1.11.0.min.js"></script>
  <script src="js/etljs/bootstrap.min.js"></script>
  <script src="js/etljs/modernizr.custom.js"></script>
  <script src="js/etljs/core.js"></script>
  <script>src="js/etljs/mock.js"</script>
  <script>src="js/etljs/jquery.js"</script>
  <script>src="js/etljs/jquery.dropdown.js"</script>
  <!-- core js files -->

  <link rel="stylesheet" href="css/etlcss/bootstrap.min.css">
  <link rel="stylesheet" href="css/etlcss/font-awesome.min.css">
  <link rel="stylesheet" href="css/etlcss/style.css">


  <link rel="stylesheet" href="css/etlcss/plugins/chosen/chosen.css">
  <script src="js/etljs/plugins/chosen.jquery.min.js"></script>

  <link rel="stylesheet" href="css/etlcss/demo_table.css">
  <link rel="stylesheet" href="css/etlcss/dtable.css">
  <script src="js/etljs/jquery.dataTables.min.js"></script>
  <script src="js/etljsjs/sorting.js"></script>

  <script src="js/etljs/plugins/jquery.tipsy.js"></script>
  <link rel="stylesheet" href="css/etlcss/plugins/files/tipsy.css">

  <link rel="stylesheet" href="css/etlcss/plugins/datepicker/datepicker.css">
  <script src="js/etljs/plugins/bootstrap-datepicker.js"></script>
  <script src="js/etljs/plugins/jquery.maskedinput.min.js"></script>

  <script src="js/etljs/plugins/bootstrap3-typeahead.min.js"></script>

  <script src="js/etljs/plugins/bootbox.min.js"></script>
  <script src="js/etljs/plugins/jquery.dlmenu.js"></script>

  <link rel="stylesheet" href="css/etlcss/plugins/files/bootstrap-checkbox.css">
  <script src="js/etljs/plugins/bootstrap-checkbox.js"></script>

  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

  <script type="text/javascript">
      var ac_siteURL='';  //PHP Application üzerinde autocomplete verisi işlenmesi için temel adres tanımlaması için
  </script>
  <style type="text/css">
    <%--表格中的form一开始不可见--%>
    .tdForm{display:none}


    #btn_bbs_mop{display: none}
    #btn_bbs_news{display: none}
    #btn_bbs_people{display: none}
    #btn_bbs_sohu{display: none}
    #btn_bbs_tianya{display: none}
    #btn_bbs_xici{display: none}
    #btn_blog_163{display: none}
    #btn_blog_sina{display: none}
    #btn_blogchina{display: none}
    #btn_douban{display: none}
    #btn_kdnet{display: none}
    #btn_moe{display: none}
    /*#btn_sanqin{display: none}*/
    /*#btn_news_sina{display: none}*/
    /*#btn_people_news{display: none}*/
    /*#btn_weibo{display: none}*/
    #btn_xinhua_news{display: none}
    /*#btn_xinwen110{display: none}*/
  </style>
  <script>
    //将浏览器会自动转义的html标签转化为不被转义的
      function html2Escape(sHtml)
      {
          return sHtml.replace(/[<>&"]/g,function(c){return{'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;'}[c];});
      }
      //实现表内数据可编辑
      function editData(content){
          //获取p标签
          var pTag =document.getElementById(content);
          //获取input标签
          var inputTag =document.getElementById(content+"Input");
          inputTag.value=pTag.innerText;
          pTag.style.display ="none";
          inputTag.style.display="inline";
          //文本框获得焦点，使不编辑使也可执行失去焦点的函数
          inputTag.focus();
      }
      //input失去焦点的事件
      function loseBlur(inputId) {
          var pId = inputId.replace("Input","");
          var pTag =document.getElementById(pId);
          var inputTag =document.getElementById(inputId);
          pTag.innerText=inputTag.value;
          inputTag.style.display="none";
          pTag.style.display ="inline";
      }

      //1、获取到xmlhttprequest
      function xmlhttprequest() {
          var xmlhttp;
          if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
              xmlhttp = new XMLHttpRequest();
          } else { // code for IE6, IE5
              xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
          }
          return xmlhttp;
      }
      //用户点击某表btn时，将该表名存入input引发其改变，从而触发ajax的onchange函数，清空

      function display(value) {
          $.post("TableServerlet",
              {
                  tablename: value
              },
              function (data, status) {
                  var headData = data.split("+")[0];
                  //bodyData得到的是中括号包含大括号的json
                  var bodyData = data.split("+")[1];

                  var headObj = eval('(' + headData + ')');
                  var bodyObj = eval('(' + bodyData + ')');
                  var html = "";
                  html ="<thead><tr role=\'role\'>";
                  for(var i=0;i<headObj.length;i++){    //遍历data数组
                      var headLs = headObj[i];
                      html +="<th role=\"columnheader\" rowspan=\"1\" colspan=\'1\' tabindex=\"0\"  bgcolor=\'#ffe4c4\'>"+headLs+"</th>";
                  }
                  html =html+"</tr></thead>";
                  html =html+"<tbody role=\"alert\" aria-live=\"polite\" aria-relevant=\"all\">";
                  for(var k = 0; k < bodyObj.length; ){    //遍历data数组,取100个值#############这里需要调整可控制
                      if (k%2==0){
                          html +="<tr class=\"gradeA odd\">";
                      }else{
                          html +="<tr class=\"gradeA even\">";
                      }
                      for(var j =0;j<headObj.length;j++){
                          var bodyLs = bodyObj[j+k];
                          //处理掉原文中包含的标签
                          bodyLs.replace("<","&lt;");
                          bodyLs.replace(">","&gt;");
                          //一个变化的独一无二的数
                          var pId=k+"&"+j;
                          var inputId=pId+"Input";
                          bodyLs =html2Escape(bodyLs);
                          html +="<td><p id=\'"+pId+"\' onclick=\"editData(\'"+pId+"\')\">"+bodyLs+"</p><input id=\'"+inputId+"\' class=\"tdForm\" onblur=\"loseBlur(\'"+inputId+"\')\" /></td>";
                      }
                      html +="</tr>";
                      k=k+headObj.length;
                  }
                  html=html+"</tbody>";
                  $("#displayTable").html(html); //在html页面id=的标签里显示html内容
              });

      }
      //        //保存表的名字(修改了input的值
      ////        document.getElementById("tablename").value=value;
      //        //清空展示区的内容来展示新内容
      ////        $("#tb_form").html("");
      //
      ////处理点击表名字法ajax请求从而获得后台数据库中的内容
      //
      ////        window.onload = function() {
      //
      ////            document.getElementById('tablename').onchange = function() {
      //
      //                //1、获取到xmlhttprequest 对象
      //        var xmlhttp = xmlhttprequest();
      //                //2、xmlhttprequest的响应事件
      //        xmlhttp.onreadystatechange = function() {
      //            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      //                        //5、操作获取到的信息
      //                        //5.1ajax返回的数据,转换为javascript对象
      //                        // 5.1.1 利用eval实现转换
      //                var ajaxResult = eval("(" + xmlhttp.responseText + ")");
      //                        //5.1.2 利用jquery的方法,对于jQuery.parseJSON(),键值必须为双引号
      //                        /* var ajaxResult = jQuery.parseJSON(xmlhttp.responseText); */
      //                alert(ajaxResult);
      //                        //5.2获取JavaScript对象的属性
      ////                var age = ajaxResult.age;
      ////                var name = ajaxResult.name;
      //
      //                        //5.3获取到页面的DIV,并设置内容
      //                var mydiv = document.getElementById("myAjax");
      ////                mydiv.innerHTML = "name:" + name + "," + "age:" + age;
      //            }
      //        }
      //                //3、准备获取ajax请求
      //                //3.1 对于get请求,带参数的方式,直接在open函数的请求地址带上参数
      //        xmlhttp.open("POST", "TableServerlet", true);
      //                //4、发送ajax请求
      //        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      //        xmlhttp.send("tablename=\'"+value+ "\'");
      //
      ////            };
      //    }

  </script>
</head>
<body style="overflow: hidden">
<div>
  <!--BEGIN BACK TO TOP-->
  <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
  <!--END BACK TO TOP-->
  <jsp:include page="static/headerInfo.jsp"/>
  <div id="wrapper">

  <jsp:include page="static/leftNav_one.jsp"/>
    <!--BEGIN PAGE WRAPPER-->
    <div id="page-wrapper">
      <!--BEGIN TITLE & BREADCRUMB PAGE-->
      <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
        <div class="page-header pull-left">
          <div class="page-title">
            <font color="#808080">数据清洗</font></div>
        </div>
        <ol class="breadcrumb page-breadcrumb pull-right">
          <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
          <li class="hidden"><a href="#">数据清洗</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
          <li class="active">数据清洗</li>
        </ol>
        <div class="clearfix">
        </div>
      </div>
      <!--END TITLE & BREADCRUMB PAGE-->

      <!--BEGIN CONTENT-->
      <div class="page-content">
        <div class="content">
          <div class="row">

            <div class="col-md-4">
              <div class="widget">
                <div class="whead">
                  <h6><i class="fa fa-cloud"></i> 请选择要操作的网站</h6>
                  <a href="#" class="btn btn-sm btn-default">Kaydet</a>
                  <a href="#" class="btn btn-sm btn-success">İptal</a>
                </div>
                <div class="wbody">
                  <td>选择网站</td>
                  <td>
                    <select name="websites" id="websites" onchange="onchange_websites()">
                      <option value="bbs_china" selected>中华网</option><%--bbs_china--%>
                      <option value="bbs_mop">猫扑网</option><%--bbs_mop--%>
                      <option value="bbs_news">新华网</option><%--bbs_news--%>
                      <option value="bbs_people">强国论坛</option><%--bbs_people--%>
                      <option value="bbs_sohu">搜狐BBS</option><%--bbs_sohu--%>
                      <option value="bbs_tianya">天涯BBS</option><%--bbs_tianya--%>
                      <option value="bbs_xici">西祠胡同</option><%--bbs_xici--%>
                      <option value="blog_163">博客163</option><%--blog_163-->
                                            <option value="blog_sina">新浪微博</option><%--blog_sina--%>
                      <option value="blogchina">博客中国</option><%--blogchina--%>
                      <option value="douban">豆瓣</option><%--douban--%>
                      <option value="kdnet">凯迪网络</option><%--kdnet--%>
                      <option value="moe">教育部</option><%--moe--%>
                      <%--<option value="sanqin">三秦网</option>&lt;%&ndash;sanqin&ndash;%&gt;--%>
                      <%--<option value="news_sina">新浪新闻</option>&lt;%&ndash;news_sina&ndash;%&gt;--%>
                      <%--<option value="people_news">人民新闻</option>&lt;%&ndash;people_news&ndash;%&gt;--%>
                      <%--<option value="weibo">微博</option>&lt;%&ndash;people_news&ndash;%&gt;--%>
                      <option value="xinhua_news">新华新闻</option><%--xinhua_news--%>
                      <%--<option value="xinwen110">社会新闻</option>&lt;%&ndash;xiwenn110&ndash;%&gt;--%>
                    </select>
                  </td>
                  <!-- Button trigger modal -->
                  <%--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">--%>
                  <%--Launch demo modal--%>
                  <%--</button>--%>

                  <!-- Modal -->
                  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                        </div>
                        <div class="modal-body">
                          ...
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                      </div>
                    </div>
                  </div>
                  <br/>
                  <br/>
                  <br/>



                  <fieldset>
                    <h6><i class="fa fa-cloud"> </i>请选择要操作的数据表</h6>

                    <div id="btn_bbs_china">
                      <a href="javascript:display('bbs_china_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_china_author</a>
                      <a href="javascript:display('bbs_china_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_china_comment</a>
                      <a href="javascript:display('bbs_china_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_china_post</a>
                    </div>
                    <div id="btn_bbs_mop">
                      <a href="javascript:display('bbs_mop_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_mop_author</a>
                      <a href="javascript:display('bbs_mop_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_mop_comment</a>
                      <a href="javascript:display('bbs_mop_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_mop_post</a>
                      <a href="javascript:display('bbs_mop_fans')" class="btn btn-success tipSag" original-title="Lorem ipsum dolar sit amed">bbs_mop_fans</a>
                    </div>
                    <div id="btn_bbs_news">
                      <a href="javascript:display('bbs_news_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_news_author</a>
                      <a href="javascript:display('bbs_news_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_news_comment</a>
                      <a href="javascript:display('bbs_news_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_news_post</a>
                      <a href="javascript:display('bbs_news_fans')" class="btn btn-success tipSag" original-title="Lorem ipsum dolar sit amed">bbs_news_fans</a>
                    </div>
                    <div id="btn_bbs_people">
                      <a href="javascript:display('bbs_people_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_people_author</a>
                      <a href="javascript:display('bbs_people_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_people_post</a>
                    </div>
                    <div id="btn_bbs_sohu">
                      <a href="javascript:display('bbs_sohu_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_sohu_author</a>
                      <a href="javascript:display('bbs_sohu_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_sohu_comment</a>
                      <a href="javascript:display('bbs_sohu_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_sohu_post</a>
                      <a href="javascript:display('bbs_sohu_fans')" class="btn btn-success tipSag" original-title="Lorem ipsum dolar sit amed">bbs_sohu_fans</a>
                    </div>
                    <div id="btn_bbs_tianya">
                      <a href="javascript:display('bbs_tianya_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_tianya_author</a>
                      <a href="javascript:display('bbs_tianya_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_tianya_comment</a>
                      <a href="javascript:display('bbs_tianya_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_tianya_post</a>
                    </div>
                    <div id="btn_bbs_xici">
                      <a href="javascript:display('bbs_xici_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_xici_comment</a>
                      <a href="javascript:display('bbs_xici_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_xici_post</a>
                    </div>
                    <div id="btn_blog_163">
                      <a href="javascript:display('blog_163_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">blog_163_author</a>
                      <a href="javascript:display('blog_163_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">blog_163_comment</a>
                      <a href="javascript:display('blog_163_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">blog_163_post</a>
                    </div>
                    <div id="btn_blog_sina">
                      <a href="javascript:display('blog_sina_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">blog_sina_author</a>
                      <a href="javascript:display('blog_sina_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">blog_sina_comment</a>
                      <a href="javascript:display('blog_sina_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">blog_sina_post</a>
                    </div>
                    <div id="btn_blogchina">
                      <a href="javascript:display('blogchina_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">blogchina_author</a>
                      <%--<a href="javascript:display('blogchina_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">blogchina_comment</a>--%>
                      <%--<a href="javascript:display('blogchina_blog')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">blogchina_blog</a>--%>
                    </div>
                    <div id="btn_douban">
                      <a href="javascript:display('douban_group_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">douban_group_author</a>
                      <a href="javascript:display('douban_group_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">douban_group_comment</a>
                      <a href="javascript:display('douban_group_group')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">douban_group_group</a>
                      <a href="javascript:display('douban_group_post')" class="btn btn-success tipSag" original-title="Lorem ipsum dolar sit amed">douban_group_post</a>
                    </div>
                    <div id="btn_kdnet">
                      <a href="javascript:display('kdnet_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">kdnet_author</a>
                      <a href="javascript:display('kdnet_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">kdnet_comment</a>
                      <a href="javascript:display('kdnet_comment')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">kdnet_post</a>
                      <a href="javascript:display('kdnet_fans')" class="btn btn-success tipSag" original-title="Lorem ipsum dolar sit amed">kdnet_fans</a>
                    </div>
                    <div id="btn_moe">
                      <a href="javascript:display('moe_data')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">moe_data</a>
                      <a href="javascript:display('moe_declaration')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">moe_declaration</a>
                      <a href="javascript:display('moe_news')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">moe_news</a>
                    </div>
                    <%--<div id="btn_sanqin">--%>
                    <%--<a href="javascript:display('news_sanqin')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">news_sanqin</a>--%>
                    <%--</div>--%>
                    <%--<div id="btn_news_sina">--%>
                    <%--<a href="javascript:display('news_sina')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">news_sina</a>--%>
                    <%--</div>--%>
                    <%--<div id="btn_weibo">--%>
                    <%--<a href="javascript:display('weibo_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">weibo_author</a>--%>
                    <%--<a href="javascript:display('weibo_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">weibo_comment</a>--%>
                    <%--<a href="javascript:display('weibo_comment')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">weibo_content</a>--%>
                    <%--</div>--%>
                    <%--<div id="btn_people_news">--%>
                    <%--<a href="javascript:display('people_news')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">people_news</a>--%>
                    <%--</div>--%>
                    <div id="btn_xinhua_news">
                      <a href="javascript:display('xinhua_news')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">xinhua_news</a>
                    </div>
                    <%--<div id="btn_xinwen110">--%>
                    <%--<a href="javascript:display('xinwen110_news')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">xinwen110_news</a>--%>
                    <%--</div>--%>

                  </fieldset>


                </div>
              </div>
            </div>
            <div class="col-md-5">
              <div class="widget">
                <div class="whead">
                  <h6><i class="fa fa-cloud"></i> 数据清洗策略的选择</h6>
                  <div class="btn-group">
                    <a href="" class="btn btn-primary" data-message=""><i class="fa fa-share"></i> Buton</a>
                    <a href="" class="btn btn-info" data-message=""><i class="fa fa-plus"></i> Grup</a>
                    <a href="" class="btn btn-default" data-message=""><i class="fa fa-home"></i> Denemesi</a>
                  </div>
                </div>
                <div class="wbody">
                  <table class="table">
                    <tr>
                      <td>Form Text</td>
                      <td><input type="text" class="form-control"/></td>
                    </tr>                                        <tr>
                    <td>Select Form</td>
                    <td>
                      <select class="select form-control">
                        <option>Value 1</option>
                        <option>Value 2</option>
                        <option>Value 3</option>
                        <option>Value 4</option>
                        <option>Value Value</option>
                        <option>Value 5</option>
                        <option>Value 6</option>
                      </select>
                    </td>
                  </tr>
                    <tr>
                      <td>Date Picker</td>
                      <td><input type="text" class="form-control dpform"/></td>
                    </tr>
                    <tr>
                      <td>Auto Complete</td>
                      <td><input type="text"  class="form-control autocomplete" data-source="etldemodata/autocomplete.json"/></td>
                    </tr>
                    <tr>
                      <td>Chechbox</td>
                      <td>
                        <input type="checkbox"  class="checkboxcustom" value="yes" name="a" />
                        <input type="checkbox"  class="checkboxcustom1" value="yes" name="b" />
                        <input type="checkbox"  class="checkboxcustom2" value="yes" name="c" />
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
            <div class="col-md-3">
              <div class="widget">
                <div class="whead">
                  <h6><i class="fa fa-cloud"></i>统计</h6>
                  <a href="#" class="btn btn-sm btn-default">Kaydet</a>
                  <a href="#" class="btn btn-sm btn-success">İptal</a>
                </div>
                <div class="wbody">
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                      <span class="sr-only">40% Complete (success)</span>
                    </div>
                  </div>
                  <div class="progress">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                      <span class="sr-only">20% Complete</span>
                    </div>
                  </div>
                  <div class="progress">
                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                      <span class="sr-only">60% Complete (warning)</span>
                    </div>
                  </div>
                  <div class="progress">
                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                      <span class="sr-only">80% Complete</span>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <%--这里展示返回的数据表--%>
            <form method="post" action="tbform" name="tbform1" id="tbform1">
              <%--接收用户选择的表名--%>
              <input type="hidden" name="tablename" id ="tablename" value="" />

              <div class="col-md-12" style="width:99.5%; height:420px; overflow:scroll;">
                <div class="widget">
                  <div class="whead">
                    <h6>数据展示与清洗</h6>
                  </div>

                  <table cellpadding="0" cellspacing="0" border="0" height="550px" class="displayTable" id="displayTable" width="100%" data-table-ajax="">
                  </table>
                  <%--<table cellpadding="0" cellspacing="0" border="0" class="displayTable" id="displayTable" width="100%" data-table-ajax="">--%>
                  <%--<thead>--%>
                  <%--<tr>--%>
                  <%--<th>Rendering engine</th>--%>
                  <%--<th>Browser</th>--%>
                  <%--<th>Platform(s)</th>--%>
                  <%--<th>Engine version</th>--%>
                  <%--<th>CSS grade</th>--%>

                  <%--</tr>--%>
                  <%--<tr>--%>
                  <%--<c:forEach var="fm" items="${data}">--%>
                  <%--<th>${fm}</th>--%>
                  <%--</c:forEach>--%>
                  <%--</tr>--%>
                  <%--</thead>--%>
                  <%--<tbody>--%>


                  <%--</tbody>--%>
                  <%--<tr class="gradeX">--%>
                  <%--<td>Trident</td>--%>
                  <%--<td>Internet--%>
                  <%--Explorer 4.0</td>--%>
                  <%--<td>Win 95+</td>--%>
                  <%--<td class="center">4</td>--%>
                  <%--<td class="center">X</td>--%>
                  <%--</tr>--%>

                  <%--</tr>--%>
                  <%--</tbody>--%>
                  <%--<tfoot>--%>
                  <%--<tr>--%>
                  <%--<th></th>--%>
                  <%--<th></th>--%>
                  <%--<th></th>--%>
                  <%--<th></th>--%>
                  <%--<th></th>--%>
                  <%--</tr>--%>
                  <%--</tfoot>--%>
                  <%--</table>--%>

                  <div class="clearfix"></div>
                </div>

                <div class="clearfix"></div>
              </div>
            </form>
            <div class="clearfix"></div>
            <div class="ara" id="ara"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
      //选择不同网站时显示不同的对应数据表
      function onchange_websites() {
          var obj = document.getElementById("websites").value;
          switch (obj)
          {
              case "bbs_china":
                  document.getElementById("btn_bbs_china").style.display="inline";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "bbs_mop":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="inline";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "bbs_news":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="inline";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "bbs_people":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="inline";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "bbs_sohu":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="inline";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "bbs_tianya":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="inline";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "bbs_xici":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="inline";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "blog_163":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="inline";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "blog_sina":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="inline";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "blogchina":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="inline";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "douban":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="inline";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "kdnet":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="inline";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
              case "moe":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="inline";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
//            case "sanqin":
//                document.getElementById("btn_bbs_china").style.display="none";
//                document.getElementById("btn_bbs_mop").style.display="none";
//                document.getElementById("btn_bbs_news").style.display="none";
//                document.getElementById("btn_bbs_people").style.display="none";
//                document.getElementById("btn_bbs_sohu").style.display="none";
//                document.getElementById("btn_bbs_tianya").style.display="none";
//                document.getElementById("btn_bbs_xici").style.display="none";
//                document.getElementById("btn_blog_sina").style.display="none";
//                document.getElementById("btn_blogchina").style.display="none";
//                document.getElementById("btn_douban").style.display="none";
//                document.getElementById("btn_kdnet").style.display="none";
//                document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="inline";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
//                document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
//                break;
//            case "news_sina":
//                document.getElementById("btn_bbs_china").style.display="none";
//                document.getElementById("btn_bbs_mop").style.display="none";
//                document.getElementById("btn_bbs_news").style.display="none";
//                document.getElementById("btn_bbs_people").style.display="none";
//                document.getElementById("btn_bbs_sohu").style.display="none";
//                document.getElementById("btn_bbs_tianya").style.display="none";
//                document.getElementById("btn_bbs_xici").style.display="none";
//                document.getElementById("btn_blog_sina").style.display="none";
//                document.getElementById("btn_blogchina").style.display="none";
//                document.getElementById("btn_douban").style.display="none";
//                document.getElementById("btn_kdnet").style.display="none";
//                document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="inline";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
//                document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
//                break;
//            case "people_news":
//                document.getElementById("btn_bbs_china").style.display="none";
//                document.getElementById("btn_bbs_mop").style.display="none";
//                document.getElementById("btn_bbs_news").style.display="none";
//                document.getElementById("btn_bbs_people").style.display="none";
//                document.getElementById("btn_bbs_sohu").style.display="none";
//                document.getElementById("btn_bbs_tianya").style.display="none";
//                document.getElementById("btn_bbs_xici").style.display="none";
//                document.getElementById("btn_blog_sina").style.display="none";
//                document.getElementById("btn_blogchina").style.display="none";
//                document.getElementById("btn_douban").style.display="none";
//                document.getElementById("btn_kdnet").style.display="none";
//                document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="inline";
//                document.getElementById("btn_weibo").style.display="none";
//                document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
//                break;
//            case "weibo":
//                document.getElementById("btn_bbs_china").style.display="none";
//                document.getElementById("btn_bbs_mop").style.display="none";
//                document.getElementById("btn_bbs_news").style.display="none";
//                document.getElementById("btn_bbs_people").style.display="none";
//                document.getElementById("btn_bbs_sohu").style.display="none";
//                document.getElementById("btn_bbs_tianya").style.display="none";
//                document.getElementById("btn_bbs_xici").style.display="none";
//                document.getElementById("btn_blog_sina").style.display="none";
//                document.getElementById("btn_blogchina").style.display="none";
//                document.getElementById("btn_douban").style.display="none";
//                document.getElementById("btn_kdnet").style.display="none";
//                document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="inline";
//                document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="none";
//                break;
              case "xinhua_news":
                  document.getElementById("btn_bbs_china").style.display="none";
                  document.getElementById("btn_bbs_mop").style.display="none";
                  document.getElementById("btn_bbs_news").style.display="none";
                  document.getElementById("btn_bbs_people").style.display="none";
                  document.getElementById("btn_bbs_sohu").style.display="none";
                  document.getElementById("btn_bbs_tianya").style.display="none";
                  document.getElementById("btn_bbs_xici").style.display="none";
                  document.getElementById("btn_blog_163").style.display="none";
                  document.getElementById("btn_blog_sina").style.display="none";
                  document.getElementById("btn_blogchina").style.display="none";
                  document.getElementById("btn_douban").style.display="none";
                  document.getElementById("btn_kdnet").style.display="none";
                  document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
                  document.getElementById("btn_xinhua_news").style.display="inline";
//                document.getElementById("btn_xinwen110").style.display="none";
                  break;
//            case "xinwen110":
//                document.getElementById("btn_bbs_china").style.display="none";
//                document.getElementById("btn_bbs_mop").style.display="none";
//                document.getElementById("btn_bbs_news").style.display="none";
//                document.getElementById("btn_bbs_people").style.display="none";
//                document.getElementById("btn_bbs_sohu").style.display="none";
//                document.getElementById("btn_bbs_tianya").style.display="none";
//                document.getElementById("btn_bbs_xici").style.display="none";
//                document.getElementById("btn_blog_sina").style.display="none";
//                document.getElementById("btn_blogchina").style.display="none";
//                document.getElementById("btn_douban").style.display="none";
//                document.getElementById("btn_kdnet").style.display="none";
//                document.getElementById("btn_moe").style.display="none";
//                document.getElementById("btn_sanqin").style.display="none";
//                document.getElementById("btn_news_sina").style.display="none";
//                document.getElementById("btn_people_news").style.display="none";
//                document.getElementById("btn_weibo").style.display="none";
//                document.getElementById("btn_xinhua_news").style.display="none";
//                document.getElementById("btn_xinwen110").style.display="inline";
//                break;
              default:
                  alert("error");
          }
      }
  </script>

        <!--END CONTENT-->


        <!--BEGIN FOOTER-->
        <jsp:include page="static/footer.jsp"/>
        <!--END FOOTER-->
      </div>
      <!--END PAGE WRAPPER-->
    </div>
  </div>

  <jsp:include page="static/footer_script.jsp"/>
  <script src="js/js1/echarts.min.js"></script>
  <script>
      jQuery(function(){
          amazonmenu.init({
              menuid: 'mysidebarmenu'
          })
      })
  </script>
  <style>
    .select-res span {
      display: inline-block;
      width:180px;
      height:14px;
      line-height:14px;
      padding:7px 15px 7px 5px;
      border:solid 1px #c0c0c0;
      background:url(images/backgrounds/select_box_bg.gif) no-repeat 190px center;
      cursor: pointer;
      color:#c2c2c2;
      text-overflow:ellipsis;
      white-space:nowrap;
      overflow:hidden;
    }
    .select-res p {
      position:relative;
      width: 200px;
      height:28px;
      line-height:28px;
      border-bottom:dashed 1px #c0c0c0;
      padding:0 5px;
      text-overflow:ellipsis;
      white-space:nowrap;
      overflow:hidden;
      padding-right:20px;
    }
    .select-res a {
      position:absolute;
      top:0;
      right:0;
      display: block;
      width:28px;
      height:28px;
      background:url(images/backgrounds/close_btn.jpg) no-repeat center;
      cursor:pointer;
    }
    .select-res input {
      width:172px;
      height:14px;
      line-height:14px;
      margin-left:4px;
      padding:7px 5px;
      border:solid 1px #c0c0c0;
      color:#2c2c2c;
    }
    .select-res span.selected {
      color:#626262;
    }
    .select-box {
      height:220px;
      margin:10px;
      margin-left: 28%;
      padding:20px 20px 10px;
      position:absolute;
      display:none;
      z-index:5;
      background: #f1f1f1;
    }
    .select-box .close-btn {
      position:absolute;
      right:5px;
      top:5px;
      cursor: pointer;
    }
    .select-box .wrap {
      height:200px;
      border:solid 1px #ddd;
      margin-top:5px;
    }
    .select-box ul {
      float:left;
      width:178px;
      height:200px;
      overflow-y: scroll;
    }
    .select-box ul li {
      height:25px;
      line-height:25px;
      padding:0 10px;
      background: url(images/backgrounds/arr.gif) no-repeat 152px center;
      color:#626262;
      cursor: pointer;
    }
    .select-box ul li.selected {
      background:url(images/backgrounds/arr_selected.gif) no-repeat 152px center #fd8340;
      color:#fff;
    }
  </style>
  <script>
      var dataJson = {
          "option": [{
              "id": "1",
              "name": "户外玩具\/设施",
              "child": [{
                  "id": "4",
                  "name": "平衡木",
                  "child": [{
                      "id": "12",
                      "name": "塑制平衡木"
                  }, {
                      "id": "13",
                      "name": "木质平衡木"
                  }, {
                      "id": "14",
                      "name": "独木桥"
                  }, {
                      "id": "15",
                      "name": "平衡步道"
                  }]
              }, {
                  "id": "5",
                  "name": "滑梯",
                  "child": [{
                      "id": "35",
                      "name": "组合滑梯"
                  }, {
                      "id": "36",
                      "name": "直筒滑梯"
                  }, {
                      "id": "37",
                      "name": "旋转滑梯"
                  }, {
                      "id": "38",
                      "name": "双排滑梯"
                  }, {
                      "id": "39",
                      "name": "单排滑梯"
                  }, {
                      "id": "41",
                      "name": "多功能滑梯"
                  }, {
                      "id": "42",
                      "name": "木质滑梯"
                  }]
              }, {
                  "id": "6",
                  "name": "蹦床",
                  "child": [{
                      "id": "58",
                      "name": "护网蹦床"
                  }, {
                      "id": "59",
                      "name": "折叠蹦床"
                  }, {
                      "id": "60",
                      "name": "弹跳床"
                  }, {
                      "id": "61",
                      "name": "城堡蹦床"
                  }]
              }, {
                  "id": "7",
                  "name": "跷跷板",
                  "child": [{
                      "id": "74",
                      "name": "双人跷跷板"
                  }, {
                      "id": "75",
                      "name": "单人跷跷板"
                  }, {
                      "id": "76",
                      "name": "摇马"
                  }, {
                      "id": "77",
                      "name": "室外跷跷板"
                  }, {
                      "id": "78",
                      "name": "弹簧跷跷板"
                  }, {
                      "id": "79",
                      "name": "摇摇乐"
                  }]
              }, {
                  "id": "8",
                  "name": "荡船",
                  "child": [{
                      "id": "90",
                      "name": "彩棚荡船"
                  }, {
                      "id": "91",
                      "name": "公鸡荡船"
                  }, {
                      "id": "92",
                      "name": "秋千"
                  }, {
                      "id": "93",
                      "name": "吊椅"
                  }, {
                      "id": "94",
                      "name": "摇椅"
                  }, {
                      "id": "95",
                      "name": "荡桥"
                  }]
              }, {
                  "id": "9",
                  "name": "攀岩",
                  "child": [{
                      "id": "107",
                      "name": "塑料攀岩"
                  }, {
                      "id": "108",
                      "name": "爬山坡"
                  }, {
                      "id": "109",
                      "name": "木质攀岩"
                  }, {
                      "id": "110",
                      "name": "保险带"
                  }, {
                      "id": "111",
                      "name": "攀岩石"
                  }, {
                      "id": "112",
                      "name": "安全绳"
                  }, {
                      "id": "113",
                      "name": "拖鞋儿童帐篷"
                  }, {
                      "id": "114",
                      "name": "爬网攀岩架"
                  }, {
                      "id": "115",
                      "name": "攀岩鞋"
                  }, {
                      "id": "116",
                      "name": "充气攀岩"
                  }]
              }, {
                  "id": "10",
                  "name": "淘气堡",
                  "child": [{
                      "id": "119",
                      "name": "淘气堡玩具"
                  }, {
                      "id": "120",
                      "name": "淘气堡配件"
                  }, {
                      "id": "121",
                      "name": "充气城堡"
                  }, {
                      "id": "122",
                      "name": "小型淘气堡"
                  }]
              }, {
                  "id": "11",
                  "name": "其他玩具",
                  "child": [{
                      "id": "137",
                      "name": "隧道"
                  }, {
                      "id": "138",
                      "name": "钻洞"
                  }, {
                      "id": "139",
                      "name": "轨道火车"
                  }, {
                      "id": "140",
                      "name": "围栏"
                  }, {
                      "id": "141",
                      "name": "垃圾桶"
                  }, {
                      "id": "142",
                      "name": "滚筒"
                  }, {
                      "id": "143",
                      "name": "木制设施"
                  }]
              }]
          }, {
              "id": "2",
              "name": "室内玩具",
              "child": [{
                  "id": "151",
                  "name": "亲子玩具",
                  "child": [{
                      "id": "156",
                      "name": "儿童健身器材"
                  }, {
                      "id": "157",
                      "name": "高跷"
                  }, {
                      "id": "158",
                      "name": "玩具球"
                  }, {
                      "id": "159",
                      "name": "跨栏"
                  }, {
                      "id": "160",
                      "name": "跳跳袋"
                  }, {
                      "id": "161",
                      "name": "体能器材"
                  }]
              }, {
                  "id": "152",
                  "name": "海洋球类",
                  "child": [{
                      "id": "162",
                      "name": "海洋球帐篷"
                  }, {
                      "id": "163",
                      "name": "澳乐海洋球"
                  }, {
                      "id": "164",
                      "name": "儿童帐篷"
                  }, {
                      "id": "165",
                      "name": "海洋球池"
                  }, {
                      "id": "1059",
                      "name": "决明子沙池"
                  }]
              }, {
                  "id": "153",
                  "name": "积木",
                  "child": [{
                      "id": "166",
                      "name": "拼装积木"
                  }, {
                      "id": "167",
                      "name": "星钻积木"
                  }, {
                      "id": "168",
                      "name": "木质积木"
                  }, {
                      "id": "169",
                      "name": "乐高积木"
                  }, {
                      "id": "170",
                      "name": "电子积木"
                  }, {
                      "id": "171",
                      "name": "拼图"
                  }, {
                      "id": "172",
                      "name": "塑料积木"
                  }, {
                      "id": "173",
                      "name": "启蒙积木"
                  }, {
                      "id": "1060",
                      "name": "邦宝积木"
                  }, {
                      "id": "1061",
                      "name": "LOZ积木"
                  }, {
                      "id": "1062",
                      "name": "数字积木"
                  }]
              }, {
                  "id": "154",
                  "name": "转椅",
                  "child": [{
                      "id": "174",
                      "name": "三座转椅"
                  }, {
                      "id": "175",
                      "name": "四座转椅"
                  }, {
                      "id": "176",
                      "name": "六座转椅"
                  }, {
                      "id": "177",
                      "name": "八座转椅"
                  }, {
                      "id": "178",
                      "name": "十二座转椅"
                  }, {
                      "id": "179",
                      "name": "蘑菇转椅"
                  }, {
                      "id": "180",
                      "name": "旋转木马"
                  }]
              }, {
                  "id": "155",
                  "name": "软体玩具",
                  "child": [{
                      "id": "184",
                      "name": "软体积木"
                  }, {
                      "id": "185",
                      "name": "软体长椅"
                  }, {
                      "id": "186",
                      "name": "毛绒玩具"
                  }]
              }, {
                  "id": "1057",
                  "name": "教学玩具",
                  "child": [{
                      "id": "1063",
                      "name": "益智玩具"
                  }, {
                      "id": "1064",
                      "name": "感官玩具"
                  }, {
                      "id": "1065",
                      "name": "数学玩具"
                  }, {
                      "id": "1066",
                      "name": "手眼协调"
                  }, {
                      "id": "1067",
                      "name": "拼图玩具"
                  }, {
                      "id": "1068",
                      "name": "其他玩具"
                  }]
              }, {
                  "id": "1058",
                  "name": "区角器材",
                  "child": [{
                      "id": "1069",
                      "name": "娃娃家"
                  }, {
                      "id": "1070",
                      "name": "超市"
                  }, {
                      "id": "1071",
                      "name": "医院"
                  }, {
                      "id": "1072",
                      "name": "交通"
                  }, {
                      "id": "1073",
                      "name": "邮局"
                  }, {
                      "id": "1074",
                      "name": "厨房"
                  }, {
                      "id": "1075",
                      "name": "创意区角"
                  }]
              }]
          }, {
              "id": "3",
              "name": "教材\/教具",
              "child": [{
                  "id": "200",
                  "name": "五大领域",
                  "child": [{
                      "id": "206",
                      "name": "小班教材书"
                  }, {
                      "id": "207",
                      "name": "中班教材书"
                  }, {
                      "id": "208",
                      "name": "大班教材书"
                  }, {
                      "id": "209",
                      "name": "成套教材书"
                  }]
              }, {
                  "id": "201",
                  "name": "蒙氏系列",
                  "child": [{
                      "id": "218",
                      "name": "蒙氏教具"
                  }, {
                      "id": "219",
                      "name": "蒙氏数学"
                  }, {
                      "id": "220",
                      "name": "蒙氏教具套装"
                  }, {
                      "id": "221",
                      "name": "图形认知"
                  }, {
                      "id": "222",
                      "name": "逻辑狗"
                  }, {
                      "id": "223",
                      "name": "色彩认知"
                  }, {
                      "id": "224",
                      "name": "感官教具"
                  }, {
                      "id": "225",
                      "name": "益智拼图"
                  }, {
                      "id": "226",
                      "name": "数学棒"
                  }, {
                      "id": "227",
                      "name": "对数板"
                  }, {
                      "id": "1078",
                      "name": "早教教具"
                  }]
              }, {
                  "id": "202",
                  "name": "音乐特色",
                  "child": [{
                      "id": "228",
                      "name": "音乐教材"
                  }, {
                      "id": "229",
                      "name": "打击乐器"
                  }, {
                      "id": "230",
                      "name": "手串铃"
                  }, {
                      "id": "231",
                      "name": "儿童木鱼"
                  }, {
                      "id": "232",
                      "name": "节奏棒"
                  }, {
                      "id": "233",
                      "name": "蛙鸣筒"
                  }, {
                      "id": "1079",
                      "name": "摇铃鼓"
                  }, {
                      "id": "1080",
                      "name": "三角铃"
                  }, {
                      "id": "1081",
                      "name": "方巾纱巾"
                  }, {
                      "id": "1082",
                      "name": "铜碰钟"
                  }, {
                      "id": "1083",
                      "name": "手拍鼓"
                  }, {
                      "id": "1084",
                      "name": "舞板响板"
                  }, {
                      "id": "1085",
                      "name": "三角铁"
                  }, {
                      "id": "1086",
                      "name": "撞钟"
                  }, {
                      "id": "1087",
                      "name": "棒铃"
                  }, {
                      "id": "1088",
                      "name": "铃鼓"
                  }, {
                      "id": "1089",
                      "name": "奥尔夫乐器"
                  }, {
                      "id": "1090",
                      "name": "手摇铃"
                  }, {
                      "id": "1091",
                      "name": "沙球沙锤"
                  }]
              }, {
                  "id": "203",
                  "name": "美术特色",
                  "child": [{
                      "id": "234",
                      "name": "美术教材"
                  }, {
                      "id": "235",
                      "name": "美术教具"
                  }, {
                      "id": "236",
                      "name": "美术材料"
                  }]
              }, {
                  "id": "204",
                  "name": "舞蹈特色",
                  "child": [{
                      "id": "243",
                      "name": "舞蹈教材"
                  }, {
                      "id": "244",
                      "name": "道具扇子"
                  }, {
                      "id": "245",
                      "name": "道具花"
                  }, {
                      "id": "246",
                      "name": "道具手绢"
                  }, {
                      "id": "247",
                      "name": "道具花伞"
                  }, {
                      "id": "248",
                      "name": "道具服"
                  }, {
                      "id": "1092",
                      "name": "道具鞋"
                  }, {
                      "id": "1093",
                      "name": "道具裙"
                  }]
              }, {
                  "id": "205",
                  "name": "识字特色",
                  "child": [{
                      "id": "249",
                      "name": "识字教材"
                  }, {
                      "id": "250",
                      "name": "识字闪卡"
                  }, {
                      "id": "251",
                      "name": "识字玩具"
                  }, {
                      "id": "252",
                      "name": "识字绘本"
                  }]
              }, {
                  "id": "1076",
                  "name": "生活特色",
                  "child": [{
                      "id": "1096",
                      "name": "陶艺教材教具"
                  }, {
                      "id": "1097",
                      "name": "烘焙教材教具"
                  }]
              }, {
                  "id": "1077",
                  "name": "辅助器材",
                  "child": [{
                      "id": "1094",
                      "name": "黑板"
                  }, {
                      "id": "1095",
                      "name": "工作毯"
                  }, {
                      "id": "1098",
                      "name": "电子白板"
                  }, {
                      "id": "1099",
                      "name": "教学投影仪"
                  }, {
                      "id": "1100",
                      "name": "电子白板笔"
                  }, {
                      "id": "1101",
                      "name": "电子白板配件"
                  }, {
                      "id": "1102",
                      "name": "智能机器人"
                  }]
              }]
          }]
      }
      var l1 = 0,
          l2 = 0;
      var cname1, cname2, cname3;
      var cid1, cid2, cid3;
      var canClick = !0;
      var canClose = !1;
      $('.select-box').css({
          left: $('.select-res').offset().left,
//                      top: $('.select-res').offset().top -150
      });
      $('span', $('.select-res')).on('click', function() {
          $('.select-box').show();
          if (canClick) {
              $('ul', $('.select-box')).html('');
              fillData();
              canClick = !1;
          }
      });
      $('span', $('.select-box')).on("click", function() {
          canClose ? $('.select-box').hide() : alert('请选择下级品类！');
          canClick = !0;
      });

      $('.select-res').on('click', 'a', function() {
          $(this).parent().remove();
          $('.select-box').css({
//                        top: $('.select-res').offset().top + $('.select-res').outerHeight(true)
          });
      })

      $('ul.first', $('.select-box')).on('click', 'li', function() {
          $(this).addClass('selected').siblings().removeClass('selected');
          $('ul.third').html('');
          fillData($(this).index());
          l1 = $(this).index();
          cname1 = $(this).text();
          cid1 = $(this).attr('val');
          canClose = !1;
          $('input.cid', $('.select-res')).val(cid1);
          $('input.cname', $('.select-res')).val(cname1);
      });
      $('ul.second', $('.select-box')).on('click', 'li', function() {
          $(this).addClass('selected').siblings().removeClass('selected');
          fillData(l1, $(this).index());
          l2 = $(this).index();
          cname2 = $(this).text();
          cid2 = $(this).attr('val');
          canClose = !1;
          $('input.cid', $('.select-res')).val(cid1 + ',' + cid2);
          $('input.cname', $('.select-res')).val(cname1 + ',' + cname2);
      });
      $('ul.third', $('.select-box')).on('click', 'li', function() {
          $(this).addClass('selected').siblings().removeClass('selected');
          cname3 = $(this).text();
          cid3 = $(this).attr('val');
          canClose = !0;
          var hasExist = !1;
          $('.select-res').find("p").each(function() {
              if ($(this).text().split(' > ')[2] == cname3) hasExist = !0;
          })
          hasExist ? alert('所选品类已被添加！') : $('.select-res').append('<p>' + cname1 + ' > ' + cname2 + ' > ' + cname3 + '<a></a><input type="hidden" value="' + cid1 + ',' + cid2 + ',' + cid3 + '" name="cid[]" /><input type="hidden" value="' + cname1 + ',' + cname2 + ',' + cname3 + '" name="cname[]" /></p>');
          $('.select-box').css({
//                        top: $('.select-res').offset().top + $('.select-res').outerHeight(true)
          });
          $('input.cid', $('.select-res')).val(cid1 + ',' + cid2 + ',' + cid3);
          $('input.cname', $('.select-res')).val(cname1 + ',' + cname2 + ',' + cname3);
      });

      //填充级联数据

      function fillData(l1, l2) {
          var temp_html = "";
          if (typeof(dataJson.option) != 'undefined' && arguments.length == 0) {
              $.each(dataJson.option, function(i, pro) {
                  temp_html += '<li val="' + pro.id + '">' + pro.name + '</li>';
              });
          } else if (typeof(dataJson.option[l1].child) != 'undefined' && arguments.length == 1) {
              $.each(dataJson.option[l1].child, function(i, pro) {
                  temp_html += '<li val="' + pro.id + '">' + pro.name + '</li>';
              });
          } else if (typeof(dataJson.option[l1].child[l2].child) != 'undefined' && arguments.length == 2) {
              $.each(dataJson.option[l1].child[l2].child, function(i, pro) {
                  temp_html += '<li val="' + pro.id + '">' + pro.name + '</li>';
              });
          }
          $('.select-box ul:eq(' + arguments.length + ')').html(temp_html);
      }
  </script>
</body>
</html>
