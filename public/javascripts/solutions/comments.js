// The purpose of this code is to practice with jQuery APIs.
// There are a ton of ways this could be improved!
$(function() {
  // hide the comments form
  $("#post-comment").hide();

  // provide a link to show the comments form
  $("<a>").
    attr({href: "#",
          id: "add-comment"}).
    text("add comment").
    insertBefore("#post-comment:first").
    click(function() {
      $("#add-comment, #post-comment").toggle();
    });

  // provide a link to hide the comments form
  $("<a>").
    attr({href: "#"}).
    text("hide").
    prependTo("#post-comment").
    click(function() {
      $("#add-comment, #post-comment").toggle();
    });

  // convert the post to Ajax
  $("#post-comment").submit(function(e) {
    e.preventDefault();
    var comment = $("#post-comment :input").val();
    $.post(
      "/solutions/comments",
      $("#post-comment").serialize(),
      function() {
        $("#add-comment").show();
        $("#post-comment").hide();
        $("<li>").text(comment).prependTo("#comments");
      }
    );
  });

  // add an Ajax spinner
  $("<img>").attr({
    src: "/images/spinner.gif",
    style: "display:none; float:right",
    id: "spinner"  
  }).prependTo("body").bind("ajaxStart", function() { 
    $(this).show(); 
  }).bind("ajaxStop", function() { 
    $(this).hide(); 
  });
});