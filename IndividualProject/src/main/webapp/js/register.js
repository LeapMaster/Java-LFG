/**
 * Created by student on 5/9/17.
 */
$("document").ready(function() {
    $("#registerForm").validate({
        rules: {
            username: {
                minlength: 2,
                maxlength: 15
            },
            first_password: {
                minlength: 2,
                maxlength: 15
            },
            second_password: {
                minlength: 2,
                maxlength: 15,
                equalTo: "#first_password"
            }
        }
    });

})
