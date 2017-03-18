<%--
  Created by IntelliJ IDEA.
  Date: 2017/3/14
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/Barrett.js" type="text/javascript" ></script>
    <script src="${pageContext.request.contextPath}/js/BigInt.js" type="text/javascript" ></script>
    <script src="${pageContext.request.contextPath}/js/RSA.js" type="text/javascript" ></script>

    <script type="text/javascript">
        $.ready(function () {
                function test() {
                    var username=$("username").val();
                    var password=$("password").val();

                }

        })

        function cmdEncrypt($form) {
            $.ajax({
                url:"${pageContext.request.contextPath}/userLogin",
                dataType:"text",
                type:"get",
                async:"false",
                success:function (data) {
                    var jn = $.parseJSON(data);
                    pubexponent = jn.pubexponent;
                    pubmodules = jn.pubmodules;
                },
                error:function () {
                }
            })
            setMaxDigits(200);
            alert(pubexponent);
            alert(pubmodules);
            if(pubexponent!=""&&pubmodules!=""){
                var key = new RSAKeyPair(pubexponent, "", pubmodules);
                var encrypedPwd = encryptedString(key, encodeURIComponent($form.find('input[type="password"]').val()));
                $form.find('input[type="password"]').val(encrypedPwd);
            }


            $form.submit();
            return true;
        }



    </script>
</head>
<body>
<form id="form1" method="post" action="${pageContext.request.contextPath}/login">
    账号：<input type="text" name="username" id="account" /><br/>
    密码：<input type="password" name="password" id="password"/><br/>
     <!-- <input type="submit" value="登录">-->
    <input type="submit"  value="登录" >

</form>


</body>
</html>
