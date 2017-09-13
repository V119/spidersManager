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
<head>
  <title>Dashboard | Dashboard</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="merge/images/icons/favicon.ico">
  <link rel="apple-touch-icon" href="merge/images/icons/favicon.png">
  <link rel="apple-touch-icon" sizes="72x72" href="merge/images/icons/favicon-72x72.png">
  <link rel="apple-touch-icon" sizes="114x114" href="merge/images/icons/favicon-114x114.png">
  <!--Loading bootstrap css-->
  <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
  <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
  <link type="text/css" rel="stylesheet" href="merge/styles/jquery-ui-1.10.4.custom.min.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/font-awesome.min.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/bootstrap.min.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/animate.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/all.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/main.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/style-responsive.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/zabuto_calendar.min.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/pace.css">
  <link type="text/css" rel="stylesheet" href="merge/styles/jquery.news-ticker.css">

</head>
<body>
<div>
  <!--BEGIN BACK TO TOP-->
  <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
  <!--END BACK TO TOP-->
  <jsp:include page="static/headerInfo.jsp"/>
  <div id="wrapper">

  <jsp:include page="static/leftNav.jsp"/>
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


        <!--END CONTENT-->
        <div>
        <a style="color:grey;">请选择数据清洗方式：</a><hr>
        <jsp:include page="static/clean_data_nav.jsp"/>
        </div>

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
