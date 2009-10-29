$(function () {
  $("#field").mousemove(function(e) {
    $("#x").text(e.pageX);
    $("#y").text(e.pageY);
  }).hover(null, function(e) {
    $("#x,#y").text("");
  });
});
