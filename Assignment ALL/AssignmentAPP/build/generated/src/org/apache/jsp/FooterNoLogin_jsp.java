package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FooterNoLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <!-- Start Footer -->\n");
      out.write("    <footer class=\"bg-dark\" id=\"tempaltemo_footer\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-md-4 pt-5\">\n");
      out.write("                    <h2 class=\"h2 text-success border-bottom pb-3 border-light logo\">Book Book Chui</h2>\n");
      out.write("                    <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                        <li>\n");
      out.write("                            <i class=\"fas fa-map-marker-alt fa-fw\"></i>\n");
      out.write("                            1 Utama Shopping Centre, S220, Second Floor, 1, Lebuh Bandar Utama, Bandar Utama, 47800 Petaling Jaya, Selangor\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <i class=\"fa fa-phone fa-fw\"></i>\n");
      out.write("                            <a class=\"text-decoration-none\" href=\"tel:013-3201802\">013-3201802</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <i class=\"fa fa-envelope fa-fw\"></i>\n");
      out.write("                            <a class=\"text-decoration-none\" href=\"mailto:bookbookchui@bookstore.com\">bookbookchui@bookstore.com</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-md-4 pt-5\">\n");
      out.write("                    <h2 class=\"h2 text-light border-bottom pb-3 border-light\">Further Info</h2>\n");
      out.write("                    <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                        <li><a class=\"text-decoration-none\" href=\"MainMenuNoLogin\">Home</a></li>\n");
      out.write("                        <li><a class=\"text-decoration-none\" href=\"Login.jsp\">Products</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row text-light mb-4\">\n");
      out.write("                <div class=\"col-12 mb-3\">\n");
      out.write("                    <div class=\"w-100 my-3 border-top border-light\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-auto me-auto\">\n");
      out.write("                    <ul class=\"list-inline text-left footer-icons\">\n");
      out.write("                        <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                            <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"http://facebook.com/\"><i class=\"fab fa-facebook-f fa-lg fa-fw\"></i></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                            <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"https://www.instagram.com/\"><i class=\"fab fa-instagram fa-lg fa-fw\"></i></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                            <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"https://twitter.com/\"><i class=\"fab fa-twitter fa-lg fa-fw\"></i></a>\n");
      out.write("                        </li>\n");
      out.write("                        <p>");
      out.print( getServletContext().getInitParameter("copyrights") );
      out.write("<p>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </footer>\n");
      out.write("    <!-- End Footer -->\n");
      out.write("    <!-- Start Script -->\n");
      out.write("    <script src=\"assets/js/jquery-1.11.0.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/jquery-migrate-1.2.1.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/templatemo.js\"></script>\n");
      out.write("    <script src=\"assets/js/custom.js\"></script>\n");
      out.write("    <!-- End Script -->\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
