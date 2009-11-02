$(function () {
  //disable :input children of the form being submitted
  $("form").submit(function() {
    $(this).find(":input").attr("disabled", true);
  });

  // bind the 'add another' button to add another address line
  $("#add-another").click(function(e) {
    $("<p>").
      insertAfter($("input[name=address]:last").closest("p")).
      append($("input[name=address]:first").
              clone().
              val(""));
    e.preventDefault();
  });
  
  // method to check that the form is valid. Can add more validations here.
  var isFormInvalid = function() {
    return $("#message").val() == "";
  }
  
  // whenever the form changes, update the submit button.
  $("form").change(function(e) {
    $(":submit", this).attr("disabled", isFormInvalid());
  });
  
  // check the form state on page load.
  $("form").triggerHandler("change");
})