<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

    body{ margin: 0px; padding: 0px; font-family: Verdana, Geneva, sans-serif; font-size: 12px; color: #FFF; background-color: #434343 }
    body a{ color: grey; }
    .box{margin:0px auto; padding:0px; width:500px;}
    .box ul{margin:0px; padding:0px; list-style:none;border: 0;}
    .box ul li{ margin: 0px 2px 0px 0px; padding: 0px; width: 120px; height: 35px; display: block; border-radius: 0px; box-shadow: #000 0px 0px 1px; border: 0; background-color: #F3F3F3; }
    .box ul li:hover ul{display:block;}
    .box ul li a{text-align:center; width:121px; height:37px; line-height:35px; display:block; text-decoration:none;}
    .box ul li ul{display:none;position:relative; top:-37px; left:121px;}
    .box ul li ul li{margin:0px 0px 2px 0px; padding:0px 	; background-color:#FFFFFF;}
    .sech{background-color:pink;}
    .box ul li ul li:hover{background:pink;}
    .box ul li ul li:hover ul{visibility:visible;}
    .box ul li ul li ul{visibility:hidden; position:relative; top:-37px; left:121px;}
    .box ul li ul li ul li{background:#FFFFFF;}
    .box ul li ul li ul li:hover{background:#AFEEEE;}
    .thirdh{background-color: orange;}
</style>
</head>
<body>
<div class="box">
    <ul>
        <li><a href="#">错误数据清洗</a>
            <ul>

                <li><a href="#">一致性检验</a>
                    <ul>
                        <li><a href="#" class="thirdh">字符串检验</a></li>
                        <li><a href="#">数值检验</a></li>
                        <li><a href="#">日期检验</a></li>
                        <li><a href="#">枚举检验</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="#">缺失数据清洗</a>
            <ul>

                <li><a href="#">缺失数据填充</a>
                    <ul>
                        <li><a href="#" class="thirdh">字符串填充</a></li>
                        <li><a href="#">数值填充</a></li>
                        <li><a href="#">日期填充</a></li>
                        <li><a href="#">枚举填充</a></li>
                    </ul>
                </li>
                <li><a href="#">缺失数据删除</a>
                    <ul>
                        <li><a href="#" class="thirdh">整例删除</a></li>
                        <li><a href="#">变量删除</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="#">相似度数据清洗</a>
            <ul>
                <li><a href="#">相似度数据处理</a></li>
            </ul>
        </li>
    </ul>
</div>
