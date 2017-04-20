<html><body>
<h3>Using EL</h3>
${person.name}'s dog is ${person.dog.name}.<br/>
${person.dog.name}'s toys are: ${person.dog.toys[0].name}, ${person.dog.toys[1].name}, ${person.dog.toys[2].name}.
<h3>EL renders raw text, including html</h3>
<b>This is bold text</b>

</html></body>