$(document).ready(function () {
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (item, status){
            $('.myForm #id').val(item.satelliteId);
            $('.myForm #code').val(item.satelliteCode);
            $('.myForm #velocity').val(item.velocity);
            $('.myForm #caFlag').val(item.constellationAssignFlag);
        });

        $('.myForm #exampleModal').modal();
    });
})
