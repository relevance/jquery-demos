$(function() {
    $.fn["evalCode"] = function() {
        this.each(function() {
            eval($(this).text());
        });
    }
    $("#load").click(function() {
        $("#load-code").text("$('#" + 
                             $("#selector").val() +
                             "').load('" +
                             $("#url").val() +
                             "', " + 
                             $("#params").val() +
                             ")").evalCode();
    });
});
