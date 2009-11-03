<h2>Comments lab solution</h2>

<p>Below is a (simplistic) solution to the <a href="/labs/comments">comments lab</a>. Here are some improvements and questions to discuss:</p>

<ul>
<li>The "togglable form" concept could be generalized into a jQuery wrapper method.</li>
<li>The comment form should probably be hidden in HTML. (Why?)</li>
<li>What should happen to the comment from during the Ajax submission?</li>
<li>What should happen if submitting a comment fails?</li>
<li>Is the page-level progress indicator appropriate?</li>
</ul>

<div>
<form id="post-comment" method="post">
  <input type="textarea" id="comment" name="comment"/>
  <input type="submit" value="Post Comment"/>
</form>
</div>
        
<h2>Comments</h2>

<ul id="comments">
$comments:labs/comment()$
</ul>