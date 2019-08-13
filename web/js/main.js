var globBtnId = '';

$(function () {

     $('body').layout({ applyDemoStyles: true });
     $('.ui-layout-center,.ui-layout-west,.ui-layout-east,.ui-layout-north,.ui-layout-south').css('background-color','khaki');


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

     $('#newPaymentDialogId').dialog({

        title: 'New Paygggment',
        height: 350,
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
    });


      $('#newBtnId').click(function () {

          switch (globBtnId){
              case 'studentDataBtnId':
                  $('#newStudentDialogId').load('views/newStudent.jsp',function () {
                      $(this).dialog('open');

                  });
                  break;
              case 'teacherDataBtnId' :
                  $('#newTeacherDialogId').dialog('open');
                  break;
              case 'lessonDataBtnId' :
                  alert('New Lesson')
                  break;
              case 'paymentDataBtnId' :
                  $('#newPaymentDialogId').load('ca?action=newPayment',function () {
                      $(this).dialog('open');
                    //  getStudentCombo();
                    //  getTeacherCombo();
                     // getLessonCombo();
                  });
                  break;
              default:
                  alert('Please, select menu!')
          }




    });

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
            alert('After if!');

            if (response == 'success'){
                alert('Student has benn  successfully added!');
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
function addPayment() {
    alert('This is button for adding new payment!')

}

