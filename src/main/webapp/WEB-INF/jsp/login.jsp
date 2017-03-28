<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ctx}/css/signin.css" rel="stylesheet">
    <script src="${ctx}/js/jquery-3.1.1.js" type="text/javascript"></script>
    <script src="${ctx}/js/BigInt.js" type="text/javascript" ></script>
    <script src="${ctx}/js/Barrett.js" type="text/javascript" ></script>
    <script src="${ctx}/js/RSA.js" type="text/javascript" ></script>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>


    <script type="text/javascript">
        function cmdEncrypt() {
            var pubexponent;
            var pubmodules;
            $.ajax({
                url:"${ctx}/userLogin",
                dataType:"text",
                type:"get",
                async:false,
                success:function (data) {
                    var jn = $.parseJSON(data);
                    pubexponent = jn.pubexponent;
                    pubmodules = jn.pubmodules;
                },
                error:function () {

                }
            });
            setMaxDigits(200);
            if(pubexponent!=""&&pubmodules!=""){
                $form=$("#myForm");
                var key = new RSAKeyPair(pubexponent, "", pubmodules);
                var encrypedPwd = encryptedString(key, encodeURIComponent($form.find('input[type="password"]').val()));
                $form.find('input[type="password"]').val(encrypedPwd);
            }
            $form.attr("action","${ctx}/loginCheck");
            return true;
        }

    </script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form class="form-signin" id="myForm" method="post"  onsubmit="cmdEncrypt();">
        <h2 class="form-signin-heading">请登陆</h2>
        <label for="username" class="sr-only">Email address</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="password" required>
        </br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登 陆</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

