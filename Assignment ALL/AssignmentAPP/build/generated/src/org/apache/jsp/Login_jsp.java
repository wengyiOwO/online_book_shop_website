package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/HeaderNoLogin.jsp");
    _jspx_dependants.add("/FooterNoLogin.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Book Book Chui</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/templatemo.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/custom.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Load fonts style after rendering the layout styles -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/fontawesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Load map styles -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.css\" integrity=\"sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==\" crossorigin=\"\" />\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Start Top Nav -->\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block\" id=\"templatemo_nav_top\">\r\n");
      out.write("            <div class=\"container text-light\">\r\n");
      out.write("                <div class=\"w-100 d-flex justify-content-between\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <i class=\"fa fa-envelope mx-2\"></i>\r\n");
      out.write("                        <a class=\"navbar-sm-brand text-light text-decoration-none\" href=\"mailto:bookbookchui@bookstore.com\">bookbookchui@bookstore.com</a>\r\n");
      out.write("                        <i class=\"fa fa-phone mx-2\"></i>\r\n");
      out.write("                        <a class=\"navbar-sm-brand text-light text-decoration-none\" href=\"tel:013-3201802\">013-3201802</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        \r\n");
      out.write("                        <a class=\"text-light\" href=\"https://fb.com\" target=\"_blank\" rel=\"sponsored\"><i class=\"fab fa-facebook-f fa-sm fa-fw me-2\"></i></a>\r\n");
      out.write("                        <a class=\"text-light\" href=\"https://www.instagram.com/\" target=\"_blank\"><i class=\"fab fa-instagram fa-sm fa-fw me-2\"></i></a>\r\n");
      out.write("                        <a class=\"text-light\" href=\"https://twitter.com/\" target=\"_blank\"><i class=\"fab fa-twitter fa-sm fa-fw me-2\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!-- Close Top Nav -->\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Header -->\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light shadow\">\r\n");
      out.write("        <div class=\"container d-flex justify-content-between align-items-center\">\r\n");
      out.write("            <img class=\"img-fluid\" src=\"./assets/img/Logo2.png\" width=\"100\" height=\"100\" alt=\"\">\r\n");
      out.write("            <a class=\"navbar-brand text-success logo h1 align-self-center\" href=\"MainMenuNoLogin.jsp\">\r\n");
      out.write("                BOOK BOOK CHUI\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("            <button class=\"navbar-toggler border-0\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#templatemo_main_nav\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between\" id=\"templatemo_main_nav\">\r\n");
      out.write("                <div class=\"flex-fill\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav d-flex mx-lg-auto\">\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a class=\"nav-link\" href=\"MainMenuNoLogin\">Home</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a class=\"nav-link\" href=\"Login.jsp\">Catalogue</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"navbar align-self-center d-flex\">\r\n");
      out.write("                    <a class=\"nav-icon position-relative text-decoration-none\" href=\"Login.jsp\">\r\n");
      out.write("                        <i class=\"fa fa-fw fa-cart-arrow-down text-dark mr-1\"></i>\r\n");
      out.write("                        <span class=\"position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a class=\"nav-icon position-relative text-decoration-none\" href=\"Login.jsp\">\r\n");
      out.write("                        <i class=\"fa fa-fw fa-user text-dark mr-3\"></i>\r\n");
      out.write("                        <span class=\"position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark\">Login Now</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <!-- Close Header -->\r\n");
      out.write("</head>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Start Contact -->\r\n");
      out.write("    <div class=\"container py-5\">\r\n");
      out.write("        <div class=\"row py-5\">\r\n");
      out.write("            <form class=\"col-md-9 m-auto\" method=\"post\" action=\"LoginCon\">\r\n");
      out.write("\r\n");
      out.write("                <h3>Login</h3>\r\n");
      out.write("                <p></p>\r\n");
      out.write("                <p></p>\r\n");
      out.write("                <p></p>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"mb-3\">\r\n");
      out.write("                    <label for=\"inputemail\">Email</label>\r\n");
      out.write("                    <input type=\"email\" class=\"form-control mt-1\" id=\"email\" name=\"email\" placeholder=\"Email\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <span class=\"text-danger\">\r\n");
      out.write("                ");

                        if (session.getAttribute("emailError") != null && session.getAttribute("emailError") != "") {
      out.write("\r\n");
      out.write("                ");
 out.print(session.getAttribute("emailError")); 
      out.write("\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("                </span>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"mb-3\">\r\n");
      out.write("                    <label for=\"inputpassword\">Password</label>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control mt-1\" id=\"password\" name=\"password\" placeholder=\"Password\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <span class=\"text-danger\">\r\n");
      out.write("                ");

                        if (session.getAttribute("passwordError") != null && session.getAttribute("passwordError") != "") {
      out.write("\r\n");
      out.write("                ");
 out.print(session.getAttribute("passwordError")); 
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                ");
session.removeAttribute("passwordError");
      out.write("\r\n");
      out.write("                ");
session.removeAttribute("emailError");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </span>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col text-end mt-2\">\r\n");
      out.write("                        Don't have a account?<a href=\"Register.jsp\">Register now!</a>\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success btn-lg px-3\">Login</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End Contact -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <!-- Start Footer -->\n");
      out.write("        <footer class=\"bg-dark\" id=\"tempaltemo_footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 pt-5\">\n");
      out.write("                        <h2 class=\"h2 text-success border-bottom pb-3 border-light logo\">Book Book Chui</h2>\n");
      out.write("                        <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fas fa-map-marker-alt fa-fw\"></i>\n");
      out.write("                                1 Utama Shopping Centre, S220, Second Floor, 1, Lebuh Bandar Utama, Bandar Utama, 47800 Petaling Jaya, Selangor\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fa fa-phone fa-fw\"></i>\n");
      out.write("                                <a class=\"text-decoration-none\" href=\"tel:013-3201802\">013-3201802</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fa fa-envelope fa-fw\"></i>\n");
      out.write("                                <a class=\"text-decoration-none\" href=\"mailto:bookbookchui@bookstore.com\">bookbookchui@bookstore.com</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                   \n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 pt-5\">\n");
      out.write("                        <h2 class=\"h2 text-light border-bottom pb-3 border-light\">Further Info</h2>\n");
      out.write("                        <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"MainMenuNoLogin\">Home</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"Login.jsp\">Products</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row text-light mb-4\">\n");
      out.write("                    <div class=\"col-12 mb-3\">\n");
      out.write("                        <div class=\"w-100 my-3 border-top border-light\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-auto me-auto\">\n");
      out.write("                        <ul class=\"list-inline text-left footer-icons\">\n");
      out.write("                            <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                                <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"http://facebook.com/\"><i class=\"fab fa-facebook-f fa-lg fa-fw\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                                <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"https://www.instagram.com/\"><i class=\"fab fa-instagram fa-lg fa-fw\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                                <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"https://twitter.com/\"><i class=\"fab fa-twitter fa-lg fa-fw\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </footer>\n");
      out.write("        <!-- End Footer -->\n");
      out.write("        <!-- Start Script -->\n");
      out.write("        <script src=\"assets/js/jquery-1.11.0.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery-migrate-1.2.1.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/templatemo.js\"></script>\n");
      out.write("        <script src=\"assets/js/custom.js\"></script>\n");
      out.write("        <!-- End Script -->\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
