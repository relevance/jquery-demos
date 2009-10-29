$(function() {
  var log = function(e) {
    $("<div>").text(e.type + " called on " + e.target.id).appendTo($("#console"));
    e.stopPropagation();
  };
  var nodes = $("#outer, #inner");
  $("[name=mouseover]").change(function() {
    if ($(this).val() == "on") {
      nodes.bind("mouseover mouseout", log);
    } else {
      nodes.unbind("mouseover mouseout");
    }
  });
  $("[name=mouseenter]").change(function() {
    if ($(this).val() == "on") {
      nodes.bind("mouseenter mouseleave", log);
    } else {
      nodes.unbind("mouseenter mouseleave");
    }
  });
  $("[name=hover]").change(function() {
    if ($(this).val() == "on") {
      nodes.hover(log, log);
    } else {
      nodes.unbind("mouseenter mouseleave");
    }
  });
  $(":radio").change(function() {
    $("#console").empty();
  });
  $(":radio[value=off]").click();
});
