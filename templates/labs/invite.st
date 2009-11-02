<form id="post-invite" method="post" style="float:left" >
  
  <p>
    <label for="message">Message:</label><br/>
    <input type="textarea" id="message" name="message"/>
  </p>

  <p>
    <label for="address">Recipients:</label><br/>
    <input type="text" name="address"/>
  </p>

  <p>
    <input type="button" value="add another" id="add-another"/>
  </p>
 
  <p>
    <input type="submit" value="Invite"/>
  </p>

</form>

<div style="float:right">

<h3>Lab</h3>

<p>The form on the left is a simple "send an invite" message that might appear in a social networking application. Make it better as follows:</p>

<ol>
<li>Bind the "add another" button to add another address line in the recipients section.</li>
<li>Bind the form submission to disable the form, to prevent users from accidentally submitting the form twice.</li>
<li>Invite messages cannot be blank. Do not enable the form until there is an invite message.</li>
</ol>

</div>

<h3>Questions</h3>

<ul>
<li>Is the form usable without JavaScript?</li>
<li>Assuming recipients should be email addresses, how would you validate them?</li>
<li>How would you add a "remove recipient" feature?</li>
</ul>
