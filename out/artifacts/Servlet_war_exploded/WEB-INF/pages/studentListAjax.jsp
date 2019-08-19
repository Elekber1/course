<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="az.com.alakbar.model.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 08.08.2019
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>--%>

    <script type="text/javascript">
        $('#studentTableId').DataTable();
    </script>

<table  id="studentTableId" class="display" style="width:100%">

    <thead>
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Date of birth</th>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${studentList}" var="sl">
        <tr>
            <td>${sl.id}</td>
            <td>${sl.name}</td>
            <td>${sl.surname}</td>
            <%--<c:choose>--%>
                <%--<c:when test="${not empty sl.address}">--%>
                    <td>${sl.address}</td>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<td>Yoxdur</td>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
            <td>${sl.dob}</td>
            <td><a href="javascript: editStudent('${sl.id}');">Edit</a></td>
            <td><a href="javascript: deleteStudent('${sl.id}','${sl.name} ${sl.surname}');">Delete</a></td>
        </tr>
    </c:forEach>

    </tbody>

</table>



    <%--<tr>--%>

        <%--<% for (Student student: studentList) {%>--%>
        <%--<td><%=student.getR()%></td>--%>
        <%--<td><%=student.getName()%></td>--%>
        <%--<td><%=student.getSurname()%></td>--%>
        <%--<td><%=student.getAddress()%></td>--%>
        <%--<td><%=student.getDob()%></td>--%>

    <%--</tr>--%>
    <%--<%}%>--%>

