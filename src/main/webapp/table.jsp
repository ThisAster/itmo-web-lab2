<%@ page import="com.example.demo4.models.Point" %>
<%@ page import="com.example.demo4.models.Results" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext servletContext = request.getServletContext();
    Results<Point> results = ((Results<Point>) servletContext.getAttribute("Collection"));
%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Лабораторная работа №2 по веб-программированию</title>
    <script>
        const POINTS = [
            {
                x: <%= results.get(results.size()-1).getX() %>,
                y: <%= results.get(results.size()-1).getY() %>,
                r: <%= results.get(results.size()-1).getR() %>,
            }
        ]
    </script>
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style.css"/>
    <script defer src="<%= request.getContextPath() %>/js/grapher.js"></script>
    <script defer src="<%= request.getContextPath() %>/js/validation.js"></script>
</head>
<body>
<table>
    <tr>
        <td colspan="3">
            <header>
                <h1>
                    <span>Abulfatov</span>
                    Ruslan
                </h1>
                <h2>P32312, var: 66631213</h2>
            </header>
        </td>
        <td style="width: 400px;">
            <div style="position: absolute; padding-right: 3px; bottom: 28%; left: 1%;" class="bordered canvasContainer">
                <canvas style="padding: 24px; " id="graph" width="350" height="350">
            <span>
              <img src="img/task_graph.png" alt="Task grpah" width="350" height="350" />
            </span>
                </canvas>
            </div>
            <div class="bordered" style="margin-left: 208px;margin-top: 170%;position: absolute;bottom: 19%;right: 83.5%; height: 63px;">
                <a href="<%= request.getContextPath() %>/" class="row-fill"><button style="width: 191px;height: 63px;">Return</button></a>
            </div>
        </td>
        <td>
            <table id="results" style="left: 21%;position: absolute; bottom: 70.5%;">
                <tbody>
                <tr>
                    <th style="width: 213px;" id="xRow">
                        X
                    </th>
                    <th style="width: 213px;" id="yRow">
                        Y
                    </th>
                    <th style="width: 213px;" id="rRow">
                        R
                    </th>
                    <th style="width: 213px;" id="resultRow">
                        Result
                    </th>
                    <th style="width: 213px;" id="attempttimeRow" style="width: 185px">
                        Attempt time
                    </th>
                    <th style="width: 213px;" id="processingtimeRow">
                        Processing time
                    </th>
                </tr>
                <%=
                "<tr>"+results.get(results.size()-1).block()+"</tr>"
                %>
                </tbody>
            </table>
        </td>
    </tr>
    <img class="cat" src="img/VeC.gif" alt="cat">
</table>
</body>
</html>
