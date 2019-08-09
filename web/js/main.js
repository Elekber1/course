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
                 $(this).dialog('close');
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

    $('#newBtnId').click(function () {

        $('#newStudentDialogId').load('views/newStudent.jsp',function () {
            $(this).dialog('open');
        });

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
        alert('ok!');
 }


