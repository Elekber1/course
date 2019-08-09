<%--
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
</head>

  <body>

  <div id="container">

<jsp:include page="static/header.jsp"></jsp:include>

   <jsp:include page="static/menu.jsp"></jsp:include>

      <div id="content">

          <table border="1"  id="studentTableId" class="myClas" style="display: none">
              <caption>Student</caption>

              <thead>
              <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Surname</th>
                  <th>Address</th>
              </tr>
              </thead>

              <tbody>
              <tr>
                  <td>1</td>
                  <td>Alakbar</td>
                  <td>Hacizade</td>
                  <td>Goygol</td>

              </tr>

              <tr>
                  <td>2</td>
                  <td>Samir</td>
                  <td>Camalov</td>
                  <td>Gence</td>

              </tr>

              <tr>
                  <td>1</td>
                  <td>Ilkin</td>
                  <td>Rzayev</td>
                  <td>Selyan</td>

              </tr>
              </tbody>

          </table>
    <br>
          <table border="1"  id="teacherTableId" class="myClas" style="display: none">
              <caption>Teacher</caption>

              <thead>
              <tr>
                  <th>#</th>
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

      <%--
      <form action="cs?action=registerStudent" method="post">
    <div class="lblDesign"><label for="nameId">Name:</label></div> <input type="text" id="nameId" name="studentName" required/><br>
    <div class="lblDesign"><label for="surnameId">Surname:</label> </div>  <input type="text" id="surnameId" name="studentSurname" required/><br>
    <div class="lblDesign">Adress:</div> <input type="text" name="adress" required/><br>
    <div class="lblDesign">Password:</div> <input type="password" name="pwd" required/><br>
    <div class="lblDesign">Gender:</div> <input type="radio" name="gender" value="kishi"/>Male &nbsp;
    <input type="radio" name="gender" value="qadin" />Female<br>
    <div class="lblDesign">Foreign Languages: </div><input type="checkbox" name="foreignLang" value="eng" />English<br>
    <div class="lblDesign"></div><input type="checkbox" name="foreignLang" value="rus" />Russian<br>
    <div class="lblDesign"></div><input type="checkbox" name="foreignLang" value="fr" />French<br>
    <div class="lblDesign"></div><input type="checkbox" name="foreignLang" value="deu" />Deutsch<br>
    <div class="lblDesign"></div><input type="checkbox" name="foreignLang" value="tr" />Turkish<br>
    <div class="lblDesign">Email:</div><input type="email" name="email" /><br>

    <div class="lblDesign">Country:</div><select name="Country" multiple>
    <option value="0" disabled selected>Select Country</option>
    <option value="1">Azerbaijan</option>
    <option value="2">Turkey</option>
    <option value="3">Russian</option>
    <option value="4">England</option>
    <option value="5">Spain</option>
    <option value="6">Italy</option>
    <option value="7">Saudi Arabia</option>
  </select><br>

    <div class="lblDesign">TravelCountry: </div><select name="travelCountry" multiple>
      <option value="0" >Select Country</option>
      <option value="1">Azerbaijan</option>
      <option value="2">Turkey</option>
      <option value="3">Russian</option>
      <option value="4">England</option>
      <option value="5">Spain</option>
      <option value="6">Italy</option>
      <option value="7">Saudi Arabia</option>
    </select><br>
    <div class="lblDesign">Note:: </div>    <textarea name="note" cols="20" rows="3">

    </textarea>
  <br>
    <input type="submit" value="Send" /> &nbsp;
    <input type="reset" value="Clear">

  </form>

      --%>

    <jsp:include page="static/footer.jsp"></jsp:include>

  </div>


  </body>
</html>
