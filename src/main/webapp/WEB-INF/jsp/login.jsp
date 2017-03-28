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
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <script src="${ctx}/js/jquery-3.1.1.js" type="text/javascript"></script>
    <script src="${ctx}/js/BigInt.js" type="text/javascript" ></script>
    <script src="${ctx}/js/Barrett.js" type="text/javascript" ></script>
    <script src="${ctx}/js/RSA.js" type="text/javascript" ></script>

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
</head>
<body>
<form id="myForm" method="post"  onsubmit="cmdEncrypt();">
    账号：<input type="text" name="username" id="username" /><br/>
    密码：<input type="password" name="password" id="password"/><br/>
     <!-- <input type="submit" value="登录">-->
    <input type="submit"  value="登录">

</form>


</body>
</html>
