<html><body>
<h3>EL implicit object - param </h3>
Request parameter name is : ${param.name} <br/>
Request parameter empID is : ${param.empID} <br/>
Request parameter food is : ${param.food} <br/>
First food request parameter is: ${paramValues.food[0]}<br/>
Second food request parameter is: ${paramValues.food[1]}<br/>
Request parameter name is : ${paramValues.name[0]}<br/>

<h3>EL implicit object - header </h3>
<p>Instead of request.getHeader("host") we're using EL and its implicit object - header</p>
Host (with [] operator) is: ${header["host"]}<br/>
Host (with . operator) is: ${header.host}<br/>
Host header has only one value. If header has more values use headerValues.<br/>

<h3>Getting the request method (POST, GET)</h3>
<p>Instead of request.getMethod() we're using EL. There is no implicit request object.
There is implicit object requestScope but that object is not request object. 
Request scope is a map of request scope attributes. </p>
<p>We want a property of request object. For that property we have to go through 
pageContext. pageContext has a request object as its property, and request object has 
a method property. </p>
<p>Method is: ${pageContext.request.method}</p>

<h3>Printing the value of context init parameter</h3>
<p>Instead of application.getInitParameter("mainEmail") we're using EL.</p>
<p>Email is: ${initParam.mainEmail}</p>
</body></html>