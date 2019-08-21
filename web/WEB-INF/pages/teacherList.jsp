<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="az.com.alakbar.model.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 08.08.2019
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Teacher> teacherList = (List<Teacher>) request.getAttribute("teacherList");  %>

<table border="1"  id="teacherTableId" class="myClas">
    <caption><h3>Teacher</h3></caption>

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
<c:forEach items="teacherList" var="th">


</c:forEach>


    </tbody>

</table>


<%--<tr>--%>

<%--<% for (Teacher teacher: teacherList) {%>--%>
<%--<td><%=teacher.getId()%></td>--%>
<%--<td><%=teacher.getName()%></td>--%>
<%--<td><%=teacher.getSurname()%></td>--%>
<%--<td><%=teacher.getAddress()%></td>--%>
<%--<td><%=teacher.getDob()%></td>--%>

<%--</tr>--%>
<%--<%}%>--%>