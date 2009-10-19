$(function() {
    $(".eval-text").click(function() {
        eval("$('#target')." + $(this).text());
    });
});

