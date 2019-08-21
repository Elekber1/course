<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
    $('#accordion').accordion({
       collapsible: true
    });

    $('#paymentTableId').DataTable({
        'searching': false
    });
</script>

<div id="accordion">
    <h3>Advanced Search</h3>
    <div>
       <select id="advLessonComboId" class="cmbDesign">
            <option value="0" selected>Select Lesson</option>
           <c:forEach items="${lessonList}" var="ll">
               <option value="${ll.id}">${ll.lessonName}</option>
           </c:forEach>
       </select> &nbsp;
        <select id="advTeacherComboId" class="cmbDesign">
            <option value="0" selected>Select Teacher  </option>
            <c:forEach items="${teacherList}" var="tl">
                <option value= "${tl.id}">${tl.name} ${tl.surname}</option>
            </c:forEach>
        </select> <br>
        <input type="text" placeholder="Min Amount..." id="minAmountId" />&nbsp;
        <input type="text" placeholder="Max Amount..." id="maxAmountId" /><br>
        <input type="text" placeholder="Begin Date..." id="beginDateId" />&nbsp;
        <input type="text" placeholder="End Date..." id="endDateId" /><br>&nbsp;
        <input type="button" id="advSearchBtnId" value="Search" />
    </div>


<table id="paymentTableId" class="display" style="width:100%" >

    <thead>
    <tr>
        <th>№</th>
        <th>Student Fullname</th>
        <th>Lesson Name</th>
        <th>Teacher Fullname</th>
        <th>Amount(AZN)</th>
        <th>Payment Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

<tbody>


<c:forEach items="${paymentList}" var="pl">

    <tr>
    <td>${pl.id}</td>
    <td>${pl.student.name} ${pl.student.surname}</td>
    <td>${pl.lesson.lessonName}</td>
    <td>${pl.teacher.name} ${pl.teacher.surname}</td>
    <td>${pl.amount}</td>
    <td>${pl.payDate}</td>
    <td><a href="javascript: editPayment('${pl.id}');">Edit</a></td>
    <td><a href="javascript: deletePayment('${pl.id}');">Delete</a></td>
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
<%--<td><%=pl.getPayDate()%></td>--%>
<%--<td><a href="javascript: editPayment('${pl.id}');">Edit</a></td>--%>
<%--<td><a href="javascript: deletePayment('${pl.id}');">Delete</a></td>--%>
<%--</tr>--%>
<%--<%}%>--%>







