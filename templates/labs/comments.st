<script src="/javascripts/labs/comments.js" type="text/javascript"/></script>

<h2>Comment Form</h2>

<p>Your mission in this exercise is to simplify the addition of comments using Ajax. If you add a comment using the form below, you will see that the UI already works--but with a full page refresh. You can make it better. Open the file public/javascripts/labs/comments.js and make the following changes:</p>

<ol>
<li><p>Hide the comment form on page load.</p></li>
<li><p>Create an "add comment" link that shows the comment form (and hides itself).</p></li>
<li><p>Add a "hide" link to the comment form that hides the comment form again (and shows the add comments link.</p></li>
<li><p>Add a submit handler to the comment form that submits the comment via Ajax.</p></li>
<li><p>When a comment submit succeeds, add the comment to the list of comments and hide the comment form.</p></li>
<li><p>Add an animated gif that spins whenever an Ajax request is in progress.</p></li>
</ol>

<form id="post-comment" method="post">
  <input type="textarea" id="comment" name="comment"/>
  <input type="submit" value="Post Comment"/>
</form>
        
<h2>Comments</h2>

<ul id="comments">
$comments:labs/comment()$
</ul>