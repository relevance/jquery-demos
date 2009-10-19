jQuery(function() {
    jQuery("#code").val("");
    jQuery("#sandbox").submit(function() {
        return false;
    });
    jQuery("#formatted").click(function() {
        jQuery("#input").text(jQuery("#code").val());
        jQuery("#output").text("=> " + formatResult(evalCode()));
    });
    jQuery("#unformatted").click(function() {
        jQuery("#input").text(jQuery("#code").val());
        jQuery("#output").text("=> " + evalCode());
    });
});
