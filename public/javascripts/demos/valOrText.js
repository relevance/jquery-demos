jQuery.fn.getTextFn = function() {
  return this.is(":input") ? 
    this.val : this.text;
}

jQuery.fn.valOrText = function() {
  if (arguments[0] === undefined) {
    // "get" case
    var elem = this[0];
    if (elem) {
      return $(elem).getTextFn()
                    .apply($(elem), arguments);
    } else {
      return undefined;
    }
  } else {
    // "set" case
    var args = arguments;
    this.each(function() {
      $(this).getTextFn().apply($(this), args)
    });
    return this;
  }
};