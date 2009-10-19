$(function() {
  $("#form").submit(function() {
    $("#result").text(formatResult(evalCode()));
    return false;
  });
});
