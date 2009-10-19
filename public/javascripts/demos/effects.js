$(function() {
  $(".call-value").click(function() {
    $("#target")[$(this).val()]();
  });
  $(".eval-value").click(function() {
    eval("$('#target')." + $(this).val());
  });
});

