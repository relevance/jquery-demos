$(function() {
  $("#highlight").submit(function() {
    $("*").removeClass("highlight");
    $($("#selector").val()).addClass("highlight");
    return false;
  });
});
