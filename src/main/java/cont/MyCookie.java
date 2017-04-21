package cont;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// putanja http://localhost:8080/ch8-el/mycookie vodi do ovog servleta , vidi web.xml
public class MyCookie extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	// proverava da li u browseru ima kuki oldVisitor sa vrednoscu yes. 
	// Ako ima poruka je Nice to see you again, a ako ne poruka je Welcome!
		boolean newuser = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equals("oldVisitor")) && (c.getValue().equals("yes"))) {
					newuser = false;
					break;
				}
			}
		}
		
		String msg;
		if (newuser) {
			Cookie visitorCookie = new Cookie("oldVisitor", "yes");			
			visitorCookie.setMaxAge(60); // cookie se pamti 60 sekundi u browseru
			// tako da 60 s posle postavljanja kukija poruka je Nice to see you again
			// pa se vraca na Welcome
			response.addCookie(visitorCookie);		
			msg = "Welcome!";
		} 
		else {
			msg = "Nice to see you again.";
		}
		
		request.setAttribute("message", msg);
		
		RequestDispatcher view = request.getRequestDispatcher("/cookieresult.jsp");		
		view.forward(request, response);		
	}
}