<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1>取得結果</h1>

    <ul>
        <%
            List<String> users =
                (List<String>) request.getAttribute("users");
            for (String name : users) {
        %>
            <li><%= name %></li>
        <%
            }
        %>
    </ul>

    <a href="index.jsp">戻る</a>
</body>
</html>