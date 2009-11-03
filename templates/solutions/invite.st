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

<h3>Solution</h3>

<p>The form on the left is a simple "send an invite" message that might appear in a social networking application. It has been improved using jQuery:</p>

<ol>
<li>The "add another" button adds another address line in the recipients section.</li>
<li>Form submission disables the form, to prevent users from accidentally submitting the form twice.</li>
<li>The form does not enable until there is an invite message.</li>
</ol>

<h3>Questions</h3>

<ul>
<li>Is the form usable without JavaScript?</li>
<li>Assuming recipients should be email addresses, how would you validate them?</li>
<li>How would you add a "remove recipient" feature?</li>
</ul>

<a href="/labs/invite">Back to lab</a>

</div>

