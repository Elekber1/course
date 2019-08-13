function getStudentCombo() {

    $.ajax({
        url: 'cs?action=getStudentCombo',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#studentComboId').html(data);
        }
    });
}

function getTeacherCombo() {
    
    $.ajax({
       url: 'cs?action:=getTeacherCombo',
       type: 'GET',
       dataType: 'html',
       success: function () {
           $('#teacherComboId').html(data);

       } 
    });
}

function getLessonCombo() {
    
    $.ajax({
       url: 'cs?action=getLessonCombo',
       type: 'GET',
       dataType: 'html',
       success: function () {
           $('#lessonComboId').html(data);

       } 
    });
}
















