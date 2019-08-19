<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 18.08.2019
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">

    $(function () {
        $('#dobId1').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });
</script>


<div class="lblDesign"><label for="nameId1">Name:</label></div> <input type="text" id="nameId1" value="${student.name}"/><br>
<div class="lblDesign"><label for="surnameId1">Surname:</label> </div>  <input type="text" id="surnameId1" value="${student.surname}"/><br>
<div class="lblDesign">Address:</div> <input type="text" id="addressId1" value="${student.address}"/><br>
<div class="lblDesign">Date of Birth:</div> <input type="text" id="dobId1" value="${student.dob}"/><br>
<div class="lblDesign">Phone:</div> <input type="text" id="phoneId1" value="${student.phone}"/><br>
<div class="lblDesign">Email:</div> <input type="email" id="emailId1" value="${student.email}"/><br>
