package cont;

import foo.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

// putanja http://localhost:8080/ch8-el/controller vodi do ovog servleta , vidi web.xml
public class Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Person p = new Person();
		p.setName("Jelena");
		
		Dog d = new Dog();
		d.setName("Lili");
		
		Toy t1 = new Toy();
		t1.setName("stick");
		Toy t2 = new Toy();
		t2.setName("neighbor's cat");
		Toy t3 = new Toy();
		t3.setName("Barbie doll head");	
		
		d.setToys(new Toy[]{t1, t2, t3});
		
		p.setDog(d);
		
		request.setAttribute("person", p);	

		PageContent pc = new PageContent();
		pc.setCurrentTip("<b></b> make things bold.");
		request.setAttribute("pageContent", pc);
		
		PageContent pc1 = new PageContent();
		pc1.setCurrentTip("&lt;b&gt;&lt;/b&gt; make things bold.");
		request.setAttribute("pageContent1", pc1);
		
		request.setAttribute("some.string", 
		"This is some string set as attribute in request scope whose name contains dot which is not allowed for Java variables");		
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionAttribute", "This string is session attribute");
		
				
		
		RequestDispatcher view = request.getRequestDispatcher("/view.jsp");		
		view.forward(request, response);

	}
}