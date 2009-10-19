$(function() {
  $("#events").submit(function() {
    var count = 0;
    var eventName = $("#event").val()
    $($("#selector").val()).bind(eventName, function() {
      count = count + 1;
      $("#log").prepend("Saw event " + eventName + " " + count + " "); 
    });
    return false;
  });
});
