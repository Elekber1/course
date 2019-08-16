<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 29.06.2019
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>Course</title>
  <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
  <script type="text/javascript" src="js/main.js"></script>
  <script type="text/javascript" src="js/combo.js"></script>
  <link rel="stylesheet" type="text/css" href="css/layout.css">
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
</head>
<body>

<%-- Header --%>
<div class="ui-layout-north">
  <h1 style="text-align: center">Course</h1>
</div>

<%-- Content --%>
<div class="ui-layout-center">

</div>

<%-- Menu --%>
<div class="ui-layout-west">
  <input type="button" value="Student Data" id="studentDataBtnId" class="btnDesign" /><br>
  <input type="button" value="Teacher Data" id="teacherDataBtnId" class="btnDesign"/><br>
  <input type="button" value="Lesson Data" id="lessonDataBtnId" class="btnDesign"/><br>
  <input type="button" value="Payment Data" id="paymentDataBtnId" class="btnDesign"/><br>
</div>

<%-- Information --%>
<div class="ui-layout-east">
  <input type="button" value="New" id="newBtnId" class="btnDesign1">
</div>

<%-- Footer --%>
<div class="ui-layout-south">
  <div style="text-align: center">Copyright &copy; Alakbar Hajizada</div>
</div>

<div id="newStudentDialogId"></div>
<div id="newTeacherDialogId"></div>
<div id="newPaymentDialogId"></div>


</body>
</html>
