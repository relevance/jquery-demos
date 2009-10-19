function formatObject(result) {
    var formatted = "";
    jQuery.each(result, function(name, val) {
        formatted = formatted + name + ": " + val + "\n   ";
    })
    return formatted;
}

function formatArray(result) {
    return "[" + result + "]";
}

function formatFunction(result) {
    return String(result).match(/(function[^{]+)/)[0] + "{ ... }";
}

function formatResult(result) {
    if (result == null) {
        return null;
    }
    if (jQuery.isFunction(result)) {
        return formatFunction(result);
    }
    if (jQuery.isArray(result)) {
        return formatArray(result);
    }
    if (typeof(result) == "object") {
        return formatObject(result);
    }
    return result;   
}

function evalCode() {
  try {
    return eval("(" + jQuery("#code").val() + ")");
  } catch (err) {
    return err.message;
  }
}

