class DemosController < ApplicationController
  def echo
    @args = params.delete_if {|k,v| k == "action" || k == "controller" }
    render :layout => false
  end
end
