<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 08.08.2019
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">

        $(function () {
            $('#dobId').datepicker({
                changeMonth: true,
                changeYear: true
            });
        });
</script>


<div class="lblDesign"><label for="nameId">Name:</label></div> <input type="text" id="nameId"/><br>
<div class="lblDesign"><label for="surnameId">Surname:</label> </div>  <input type="text" id="surnameId"/><br>
<div class="lblDesign">Address:</div> <input type="text" id="addressId"/><br>
<div class="lblDesign">Date of Birth:</div> <input type="text" id="dobId"/><br>
<div class="lblDesign">Phone:</div> <input type="text" id="phoneId"/><br>
<div class="lblDesign">Email:</div> <input type="email" id="emailId"/><br>