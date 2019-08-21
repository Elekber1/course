// var globPaymentId    = 0;
//
// $('#newPaymentDialogId').dialog({
//
//     title: 'New Payment',
//     height: 400,
//     width: 400,
//     autoOpen: false,
//     modal: true,
//     buttons:{
//         "Save": function () {
//             addPayment();
//
//         },
//         "Close": function () {
//             $(this).dialog('close');
//         }
//     }
// });
//
//
// $('#updatePaymentDialogId').dialog({
//
//     title: 'Update Payment',
//     height: 400,
//     width: 400,
//     autoOpen: false,
//     modal: true,
//     buttons:{
//         "Save": function () {
//             updatePayment();
//         },
//         "Close": function () {
//             $(this).dialog('close');
//         }
//     }
// });
//
// $('#paymentDataBtnId').click(function () {
//     getPaymentList();
//
// });
//
//
//
// function getPaymentList() {
//
//     $.ajax({
//         url: 'cs?action=getPaymentList',
//         type: 'GET',
//         dataType: 'html',
//
//         success: function (response) {
//             $('.ui-layout-center').html(response);
//         },
//         error: function (response) {
//             alert('Error');
//         }
//     });
// }
//
// function editPayment(paymentId) {
//     globPaymentId = paymentId;
//     alert(paymentId);
//     $.ajax({
//         url: 'cs?action=editPayment',
//         type: 'GET',
//         data: 'paymentId='+paymentId,
//         dataType: 'html',
//         success: function (response) {
//             $('#editPaymentDialogId').html(response);
//             $('#editPaymentDialogId').dialog('open');
//         }
//
//     });
// }
//
//
// function addPayment() {
//     var studentCombo = $('#studentComboId').val();
//     var teacherCombo = $('#teacherComboId').val();
//     var lessonCombo = $('#lessonComboId').val();
//     var amount = $('#amountId').val();
//
//     if (studentCombo == 0 || teacherCombo == 0|| lessonCombo == 0){
//         alert('Please select combo!');
//     }
//
//     var data = {
//         studentCombo:studentCombo,
//         teacherCombo: teacherCombo,
//         lessonCombo: lessonCombo,
//         amount: amount
//     };
//
//     $.ajax({
//         url: 'cs?action=addPayment',
//         type: 'POST',
//         data: data,
//         dataType: 'text',
//         success: function (response) {
//
//             if (response == 'success'){
//                 alert('Payment has benn  successfully added!');
//                 getPaymentList();
//                 $('#newPaymentDialogId').dialog('close');
//             }else {
//                 alert('Problem! Payment has not benn successfully added!');
//             }
//
//         }
//
//     });
//
// }
//
// function updatePayment() {
//
// }
//
// function deletePayment(paymentId) {
//     globPaymentId = paymentId;
// }
