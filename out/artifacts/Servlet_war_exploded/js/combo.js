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
       url: 'cs?action=getTeacherCombo',
       type: 'GET',
       dataType: 'html',
       success: function (data) {
           $('#teacherComboId').html(data);

       } 
    });
}

function getLessonCombo() {
    
    $.ajax({
       url: 'cs?action=getLessonCombo',
       type: 'GET',
       dataType: 'html',
       success: function (data) {
           $('#lessonComboId').html(data);

       } 
    });
}

function getTeacherComboByLessonId(lessonId) {
        $.ajax({
           url: 'cs?action=getTeacherComboByLessonId',
            type: 'GET',
            data: 'lessonId='+lessonId,
            dataType: 'html',
            success: function (data) {
                $('#advTeacherComboId').html(data);
            }
        });
    
}

















