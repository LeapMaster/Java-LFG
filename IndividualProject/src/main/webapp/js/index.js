/**
 * Created by student on 5/9/17.
 */
$("document").ready(function() {
    $("#newListingForm").validate({
        rules: {
            level: {
                min: 1,
                max:110
            },
            gearRating: {
                min: 1
            },
            description: {
                required: true,
                maxlength: 250
            }
        }
    });
    $("#filteredSearchForm").validate();
})