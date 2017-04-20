<html><body>
<h3>Using EL</h3>
${person.name}'s dog is ${person.dog.name}.<br/>
${person.dog.name}'s toys are: ${person.dog.toys[0].name}, ${person.dog.toys[1].name}, ${person.dog.toys[2].name}.

<h3>EL renders raw text, including html</h3>
<div>
	<b>Tip of the day using EL:</b><br/>
	${pageContent.currentTip}<br/>
	
	<b>Tip of the day using jsp:getProperty:</b><br/>
	<jsp:useBean id="pageContent"  class="foo.PageContent" scope="request" />
	<jsp:getProperty name='pageContent' property='currentTip' />	
</div>

<div>
<!-- vidi kako je pageContent1 formiran u kontroleru umesto < stavlja se &lt;  -->
	<b>Showing HTML tags</b><br/>
	${pageContent1.currentTip}<br/>
</div>

</body></html>