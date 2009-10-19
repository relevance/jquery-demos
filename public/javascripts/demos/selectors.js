$(function() {
  $("#highlight").submit(function() {
    $("*").css("color", null);
    $($("#selector").val()).css("color", "blue");
    return false;
  });
});
