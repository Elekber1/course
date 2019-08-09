<%@ page import="java.util.List" %>
<%@ page import="az.com.alakbar.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 30.06.2019
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
    <script type="text/javascript" src="js/jquery/jquery-3.4.1.js"></script>
    <link rel="stylesheet" type="text/css" href="css/layout.css">
    <script type="text/javascript" src="js/main.js"></script>

    <% List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>

</head>

<body>

<div id="container">

    <jsp:include page="/static/header.jsp"></jsp:include>

    <jsp:include page="/static/menu.jsp"></jsp:include>

    <div id="content">

        <table border="1"  id="studentTableId" class="myClas">
            <caption>Student</caption>

            <thead>
            <tr>
                <th>№</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Address</th>
                <th>Date of birth</th>
            </tr>
            </thead>

            <tbody>


            <tr>

                <% for (Student student: studentList) {%>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getSurname()%></td>
                <td><%=student.getAddress()%></td>
                <td><%=student.getDob()%></td>

            </tr>
            <%}%>
            </tbody>

        </table>
        <br>
        <table border="1"  id="teacherTableId" class="myClas" style="display: none">
            <caption>Teacher</caption>

            <thead>
            <tr>
                <th>№</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Address</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>1</td>
                <td>Orhan</td>
                <td>Vuqarov</td>
                <td>Baki</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Samire</td>
                <td>Gunelzade</td>
                <td>Baki</td>

            </tr>

            <tr>
                <td>3</td>
                <td>Gunel</td>
                <td>Bayramli</td>
                <td>Baki</td>

            </tr>

            </tbody>

        </table>

    </div>

    <jsp:include page="/static/footer.jsp"></jsp:include>

</div>


</body>
</html>
