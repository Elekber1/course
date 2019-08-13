<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 12.08.2019
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<option value="0" selected disabled>Select Student</option>
<c:forEach items="${studentList}" var="sl">
    <option value="${sl.id}">${sl.name} ${sl.surname}</option>

</c:forEach>


