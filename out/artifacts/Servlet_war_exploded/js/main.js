var globBtnId = '';
var globStudentId = 0;
var globPaymentId    = 0;

$(function () {

     $('body').layout({ applyDemoStyles: true });
     $('.ui-layout-center,.ui-layout-west,.ui-layout-east,.ui-layout-north,.ui-layout-south').css('background-color','khaki');


    $('#newPaymentDialogId').dialog({

        title: 'New Payment',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true,
        buttons:{
            "Save": function () {
                addPayment();

            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });


    $('#editPaymentDialogId').dialog({

        title: 'Update Payment',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true,
        buttons:{
            "Update": function () {
                updatePayment();
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#paymentDataBtnId').click(function () {
        getPaymentList();

    });

     $('#newStudentDialogId').dialog({

        title: 'New Student',
         height: 400,
         width: 400,
         autoOpen: false,
         modal: true,
         buttons:{
             "Save": function () {
                 addStudent();
             //    $(this).dialog('close');

             },
             "Close": function () {
                 alert('Close the window');
                 $(this).dialog('close');
             }   
         }

     });

    $('#editStudentDialogId').dialog({

        title: 'Update Student',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true,
        buttons:{
            "Update": function () {
               updateStudent();
              //  editStudent();
                //    $(this).dialog('close');

            },
            "Close": function () {
                alert('Close the window');
                $(this).dialog('close');
            }
        }

    });


    $('#newTeacherDialogId').dialog({

        title: 'New Teacher',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true,
        buttons:{
            "Save": function () {
                addTeacher();
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
     });

    $('#studentDataBtnId').click(function () {
        getStudentList();

        //  $('#studentTableId').show();
     //  $('#teacherTableId').hide();
    });

    $('#teacherDataBtnId').click(function () {
       getTeacherList();
        //$('#studentTableId').hide();
      // $('#teacherTableId').show();
    });



    $('.btnDesign').click(function () {
      var btnId =  $(this).attr('id');
        globBtnId = btnId;
        console.log(globBtnId);
        $('#keywordId').val('');
    });


      $('#newBtnId').click(function () {

          switch (globBtnId){
              case 'studentDataBtnId':
                  $('#newStudentDialogId').load('views/newStudent.jsp',function () {
                      $(this).dialog('open');

                  })
                  break;
              case 'teacherDataBtnId':
                  $('#newTeacherDialogId').dialog('open');
                  break;
              case 'lessonDataBtnId' :
                  alert('New Lesson');
                  break;
              case 'paymentDataBtnId':    //cs?action=newPay  views/newPayment.jsp
                  $('#newPaymentDialogId').load('views/newPayment.jsp',function () {
                      $(this).dialog('open');
                      getStudentCombo();
                      getTeacherCombo();
                      getLessonCombo();
                  });
                  break;
              default:
                  alert('Please, select menu!')
          }

    });

      $('#searchBtnId').click(function () {
          var keyword = $('#keywordId').val();
          console.log(keyword);

          switch (globBtnId){
              case 'studentDataBtnId':
                  searchStudentData(keyword);

                  break;
              case 'teacherDataBtnId':

                  break;
              case 'lessonDataBtnId':

                  break;
              case 'paymentDataBtnId':
                  searchPaymentData(keyword);

                  break;
              default:
                  alert('Please, select menu!')
          }
      });


});

$('#keywordId').keyup(function () {
    var keyword = $(this).val();
    console.log(keyword);

    switch (globBtnId){
        case 'studentDataBtnId':
            searchStudentData(keyword);

            break;
        case 'teacherDataBtnId':

            break;
        case 'lessonDataBtnId':

            break;
        case 'paymentDataBtnId':
            searchPaymentData(keyword);

            break;
        default:
            alert('Please, select menu!')
    }

    });

function getStudentList() {

    $.ajax({

    url: 'cs?action=getStudentListAjax',
    type: 'GET',
    dataType: 'html', //text html xml json
    success: function (response) {
        $('.ui-layout-center').html(response);
        
    },
    error: function (response) {
    alert('Error');
    }
    });
}
function getTeacherList() {

    $.ajax({
        url: 'cs?action=getTeacherList',
        type: 'GET',
        dataType: 'html',

        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert('Error');
        }

    });
}





 function  addStudent() {

      var name = $('#nameId').val();
     var surname = $('#surnameId').val();
     var address = $('#addressId').val();
     var dob = $('#dobId').val();
     var phone = $('#phoneId').val();
     var email = $('#emailId').val();

     if (name.trim() == "" || surname.trim() == ""){
         alert('Please, fill in!')
         return;
     }

     var data = {
         name: name,
         surname: surname,
         address: address,
         dob: dob,
         phone: phone,
         email: email
     };

     $.ajax({
         url: 'cs?action=addStudent',
         type: 'POST',
         data: data,
         dataType: 'text',

         success: function (response) {
             if (response == 'success'){
                 alert('Student has benn  successfully added!');
                 $('#newStudentDialogId').dialog('close');
                 getStudentList();
             }else {
                 alert('Problem! Student has not benn successfully added!');
             }
         }

     });

 }

 function addTeacher() {
     alert('This is button for adding new teacher!');
 }


function editStudent(studentId) {
    globStudentId = studentId;
    $.ajax({
       url: 'cs?action=editStudent',
       type: 'GET',
       data: 'studentId='+studentId,
       dataType: 'html',
       success:function (data) {
           $('#editStudentDialogId').html(data);
           $('#editStudentDialogId').dialog('open');
       } 
    });
}


function updateStudent() {

    var name = $('#nameId1').val();
    var surname = $('#surnameId1').val();
    var address = $('#addressId1').val();
    var dob = $('#dobId1').val();
    var phone = $('#phoneId1').val();
    var email = $('#emailId1').val();

    if (name.trim() == "" || surname.trim() == ""){
        alert('Please, fill in!')
        return;
    }

    var data = {
        name: name,
        surname: surname,
        address: address,
        dob: dob,
        phone: phone,
        email: email,
        studentId: globStudentId
    };

    $.ajax({
        url: 'cs?action=updateStudent',
        type: 'POST',
        data: data,
        dataType: 'text',

        success: function (response) {
            if (response == 'success'){
                alert('Student has benn  successfully updated!');
                $('#newStudentDialogId').dialog('close');
                getStudentList();
                $('#editStudentDialogId').dialog('close');
            }else {
                alert('Problem! Student has not benn successfully updated!');
            }
        }

    });

}

function deleteStudent(studentId, studentFullname) {

    var isDelete = confirm('Are you sure?'); ;
    if (!isDelete){
    alert(studentFullname+'has not been successfully deleted!');
    return ;
    }
    $.ajax({
       url: 'cs?action=deleteStudent',
        type: 'POST',
        data: 'studentId='+studentId,
        dataType: 'text',
        success: function (response) {
            if(response == 'success'){
            alert('Student has been successfully deleted');
            getStudentList();
            }else{
                alert('Student has not been successfully deleted!');
            }
        }
    });
}

// #################  PAYMENT  ###################################





function getPaymentList() {

    $.ajax({
        url: 'cs?action=getPaymentList',
        type: 'GET',
        dataType: 'html',

        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert('Error');
        }
    });
}

function editPayment(paymentId) {
    globPaymentId = paymentId;
    $.ajax({
        url: 'cs?action=editPayment',
        type: 'GET',
        data: 'paymentId='+paymentId,
        dataType: 'html',
        success: function (response) {
            $('#editPaymentDialogId').html(response);
            $('#editPaymentDialogId').dialog('open');
        }

    });
}


function addPayment() {
    var studentCombo = $('#studentComboId').val();
    var teacherCombo = $('#teacherComboId').val();
    var lessonCombo = $('#lessonComboId').val();
    var amount = $('#amountId').val();

    if (studentCombo == 0 || teacherCombo == 0|| lessonCombo == 0){
        alert('Please select combo!');
    }

    var data = {
        studentCombo:studentCombo,
        teacherCombo: teacherCombo,
        lessonCombo: lessonCombo,
        amount: amount
    };

    $.ajax({
        url: 'cs?action=addPayment',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {

            if (response == 'success'){
                alert('Payment has benn  successfully added!');
                getPaymentList();
                $('#newPaymentDialogId').dialog('close');
            }else {
                alert('Problem! Payment has not benn successfully added!');
            }

        }

    });

}

function updatePayment() {
    var studentCombo = $('#studentComboId1').val();
    var teacherCombo = $('#teacherComboId1').val();
    var lessonCombo = $('#lessonComboId1').val();
    var amount = $('#amountId1').val();

    if (studentCombo == 0 || teacherCombo == 0|| lessonCombo == 0){
        alert('Please select combo!');
    }

    var data = {
        studentCombo:studentCombo,
        teacherCombo: teacherCombo,
        lessonCombo: lessonCombo,
        amount: amount,
        paymentId: globPaymentId
    };

    $.ajax({
        url: 'cs?action=updatePayment',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {

            if (response == 'success'){
                alert('Payment has benn  successfully updated!');
                getPaymentList();
                $('#editPaymentDialogId').dialog('close');
            }else {
                alert('Problem! Payment has not benn successfully updated!');
            }

        }

    });
}

function deletePayment(paymentId) {
    globPaymentId = paymentId;
}

function searchStudentData(keyword) {
    $.ajax({
       url: 'cs?action=searchStudentData',
       type: 'GET',
       data: 'keyword='+keyword,
       dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        }
    });
}

function searchPaymentData(keyword) {
        $.ajax({
           url: 'cs?action=searchPaymentData',
           type: 'GET',
           data: 'keyword='+keyword,
           dataType: 'html',
           success: function (response) {
               $('.ui-layout-center').html(response);

           } 
        });
}

function advancedSearchPaymentData() {
    var advLessonCombo  = $('#advLessonComboId').val();
    var advTeacherCombo = $('#advTeacherComboId').val();
    var minAmount = $('#minAmountId').val();
    var maxAmount = $('#maxAmountId').val();
    var beginDate = $('#beginDateId').val();
    var endDate = $('#endDateId').val();

    var data={
        advLessonCombo:advLessonCombo,
        advTeacherCombo: advTeacherCombo,
        minAmount: minAmount,
        maxAmount:maxAmount,
        beginDate:beginDate,
        endDate:endDate
    };

    $.ajax({
       url: 'cs?action=advancedSearchPaymentData',
        type: 'GET',
        data: data,
        dataType: 'html',
        success: function (response) {
            $('#paymentTableDivId').html(response);

        }
    });
    
}














