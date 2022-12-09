<%@ page import="com.example.demo4.models.Point" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  ServletContext servletContext = request.getServletContext();
  ArrayList<Point> results = (ArrayList<Point>) servletContext.getAttribute("Collection");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Лабораторная работа №2 по веб-программированию</title>
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/style.css"/>
  <script defer src="<%= request.getContextPath() %>/js/grapher.js"></script>
  <script defer src="<%= request.getContextPath() %>/js/validation.js"></script>
</head>
<body>
<script>
  const POINTS = [
    <%
      if (results == null) {
        results = new ArrayList<>();
      } else {
      for (int i = 0; i < results.size(); i++) {
    %>
    {
      x: <%= results.get(i).getX() %>,
      y: <%= results.get(i).getY() %>,
      r: <%= results.get(i).getR() %>,
    },
    <%
      }}
    %>
  ];
  drawGraph();
</script>
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
  </tr>
  <tr>
    <td>
      <div id="parameters" class="bordered">
        <form id="input-form" action="<%= request.getContextPath() %>" method="GET">
        <div id="xBlock">
          <!-- элемент, содержащий текст, при нажатии на который меняется фокус на другой элемент -->
          <label for="x">X:</label>
          <div>
            <input title="enter a value x" name="x_coord" class="inputX" id="x" type="text" placeholder="range from -3 to 5" maxlength="5" />
          </div>
        </div>
        <div id="yTable">
          <label for="y_value">Y:</label>
          <table title="enter a value y" id="y">
            <tr>
              <td>
                <button type="button" value="-2" onclick="setY('-2', this)">-2</button>
              </td>
              <td>
                <button type="button" value="-1.5" onclick="setY('-1.5', this)">-1.5</button>
              </td>
              <td>
                <button type="button" value="-1" onclick="setY('-1', this)">-1</button>
              </td>
            </tr>
            <tr>
              <td>
                <button type="button" value="-0.5" onclick="setY('-0.5', this)">-0.5</button>
              </td>
              <td>
                <button type="button" value="0" onclick="setY('0', this)">0</button>
              </td>
              <td>
                <button type="button" value="0.5" onclick="setY('0.5', this)">0.5</button>
              </td>
            </tr>
            <tr>
              <td>
                <button type="button" value="1" onclick="setY('1', this)">1</button>
              </td>
              <td>
                <button type="button" value="1.5" onclick="setY('1.5', this)">1.5</button>
              </td>
              <td>
                <button type="button" value="2" onclick="setY('2', this)">2</button>
              </td>
            </tr>
            <input type="hidden" name="y_coord" id="y_value">
          </table>
        </div>
        <div style="height: 115px" ;id="rBlock">
          <label id="labelR" for="r">R:</label>
          <table title="enter a value r" id="r">
            <tr>
              <td>
                <input type="checkbox" value="1" id="r1" onclick="rCheckboxClicked(this)">1</input>
              </td>
              <td>
                <input type="checkbox" value="2" id="r2" onclick="rCheckboxClicked(this)">2</input>
              </td>
              <td>
                <input type="checkbox" value="3" id="r3" onclick="rCheckboxClicked(this)">3</input>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" value="4" id="r4" onclick="rCheckboxClicked(this)">4</input>
              </td>
              <td>
                <input type="checkbox" value="5" id="r5" onclick="rCheckboxClicked(this)">5</input>
              </td>
            </tr>
          </table>
          <input type="hidden" name="r_coord" id="r_value">
          <input type="hidden" name="is_click" id="isClick_value">
        </div>
        <div>
          <button type="button" id="sumbitButton" class="actionButton" onclick="funcClick()">check point</button>
        </div>
        </form>
        <div>
          <form id="clear_form" action="<%= request.getContextPath()%>" method="GET">
            <button style="width: 160px" type="submit" name="clear" id="clear" value="clear" onclick="clean()">clear</button>
          </form>
        </div>

      </div>
    </td>
    <td style="width: 400px;">
      <div class="bordered canvasContainer">
        <canvas style="margin-left: 4.4%;" id="graph" width="350" height="350">
            <span>
              <img src="img/task_graph.png" alt="Task grpah" width="350" height="350" />
            </span>
        </canvas>
      </div>
    </td>
    <td>
      <table id="results" style="width: 128%;">
        <tbody>
        <tr>
          <th id="attemptRow">
            Attempt #
          </th>
          <th id="xRow">
            X
          </th>
          <th id="yRow">
            Y
          </th>
          <th id="rRow">
            R
          </th>
          <th id="formatSendRow">
            Sending format
          </th>
          <th id="resultRow">
            Result
          </th>
          <th id="attempttimeRow" style="width: 185px">
            Attempt time
          </th>
          <th id="processingtimeRow">
            Processing time
          </th>
        </tr>
        <% StringBuilder info = new StringBuilder();
          Integer i=1;
          for (Point point: results) {
            info.append("<tr>"+"<td>"+i+"</td>"+point.block()+"</tr>");
            i++;
          }%>
        <%=info.toString()%>
        </tbody>
      </table>
    </td>
  </tr>
</table>
<img class="cat" src="<%= request.getContextPath()%>/img/VeC.gif">
</body>
</html>