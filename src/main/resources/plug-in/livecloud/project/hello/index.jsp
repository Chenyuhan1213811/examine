<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>你好</h1>
<button onclick="testInterface()">123</button>
<button id="btn">345</button>
<script>
    function testInterface() {
        $.get("${pageContext.request.contextPath}/livecloud/project/user.pagex", (res) => {
            alert(res);
            console.log(res);
        });
    }
    $("#btn").click(testInterface);
</script>

</body>
</html>