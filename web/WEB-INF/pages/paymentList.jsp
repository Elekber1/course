<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="az.com.alakbar.model.Payment" %>
<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 17.08.2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%List<Payment> paymentList = (List<Payment>) request.getAttribute("paymentList");%>--%>
<script type="text/javascript">
    $('#paymentTableId').DataTable();
</script>

<table id="paymentTableId" class="display" style="width:100%" >

    <thead>
    <tr>
        <th>№</th>
        <th>Student Fullname</th>
        <th>Lesson Name</th>
        <th>Teacher Fullname</th>
        <th>Amount(AZN)</th>
    </tr>
    </thead>

<tbody>

   <c:forEach items="paymentList" var="pl">

    <tr>
        <td>${pl.id}</td>
            <%--<td>${pl.student.name} ${pl.student.surname}</td>--%>
            <%--<td>${pl.lesson.lessonName}</td>--%>
            <%--<td>${pl.amount}</td>--%>
        <%--<td>${pl.payDate}</td>--%>
    </tr>

   </c:forEach>
</tbody>

</table>





    <%--<tr>--%>
        <%--<% for (Payment pl: paymentList){%>--%>
        <%--<td><%=pl.getR()%></td>--%>
        <%--<td><%=pl.getStudent().getName()%>   <%=pl.getStudent().getSurname()%></td>--%>
        <%--<td><%=pl.getLesson().getLessonName()%></td>--%>
        <%--<td><%=pl.getTeacher().getName()%> <%=pl.getTeacher().getSurname()%></td>--%>
        <%--<td><%=pl.getAmount()%></td>--%>

    <%--</tr>--%>
    <%--<%}%>--%>












