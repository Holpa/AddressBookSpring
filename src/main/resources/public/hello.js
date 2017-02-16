/**
 * Created by ahmadholpa on 2/16/2017.
 */
$(document).ready(function() {
    $.ajax({
        url: "/buddyInfo/1"
    }).then(function(data) {
        $('.greeting-id').append(data.name);
        $('.greeting-content').append(data.phoneNumber);
    });
});