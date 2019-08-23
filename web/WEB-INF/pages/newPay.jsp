<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 12.08.2019
  Time: 10:00
  To change this template use File | Settings | File Templates.


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lblDesign">Student:</div>
<select id="studentComboId" class="cmbDesign" >
    <option value="0" selected disabled>Select Student</option>
    <c:forEach items="${studentList}" var="sl">
        <option value="${sl.id}">${sl.name} ${sl.surname}</option>
    </c:forEach>
</select>
<br>

<div class="lblDesign" >Teacher:</div>
<select id="teacherComboId"  class="cmbDesign">
    <option value="0" selected disabled>Select Teacher</option>
    <c:forEach items="${teacherList}" var="tl">
        <option value= "${tl.id}">${tl.name} ${tl.surname}</option>
    </c:forEach>
</select>
<br>

<div class="lblDesign">Lesson:</div>
<select id="lessonComboId"  class="cmbDesign">
    <option value="0" selected disabled>Select Lesson</option>
    <c:forEach items="${lessonList}" var="ll">
    <option value="${ll.id}">${ll.lessonName}</option>
</c:forEach>
</select>
<br>

<div class="lblDesign" class="cmbDesign">Amount:</div>
<input type="text" id="amountId" />