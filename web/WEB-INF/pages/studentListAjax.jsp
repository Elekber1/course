<%@ page import="az.com.alakbar.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 08.08.2019
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>

<table border="1"  id="studentTableId" class="myClas">
    <caption><h3>Student</h3></caption>

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
