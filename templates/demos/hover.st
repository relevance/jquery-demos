<style>
#outer {
  background-color: #4444dd;
  padding: 20;
  float: left;
}
#inner {
  background-color: #44dd44;
  width: 200;
  height: 100;
}
#controls {
  float: right;
}
</style>

<div id="outer">
  <div id="inner">
  </div>
</div>

<div id="controls">
  <form>
    <div>   
      <label>mouseover/mouseout</label>
      <input type="radio" name="mouseover" value="on"/> on 
      <input type="radio" name="mouseover" value="off" checked="checked"/> off
    </div>
    <div>
      <label>mouseenter/mouseleave</label>
      <input type="radio" name="mouseenter" value="on"/> on 
      <input type="radio" name="mouseenter" value="off" checked="checked"/> off
    </div>
    <div>
      <label>hover</label>
      <input type="radio" name="hover" value="on"/> on 
      <input type="radio" name="hover" value="off" checked="checked"/> off
    </div>
  </form>
  <div id="console">
  </div>
</div>

  
