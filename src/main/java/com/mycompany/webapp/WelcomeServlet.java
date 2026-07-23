package com.mycompany.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple Servlet that returns the current server date/time
 * along with a greeting message. Demonstrates a pure-Java backend
 * component serving dynamic content to the frontend (index.jsp).
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String currentTime = sdf.format(new Date());

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Welcome</title>");
            out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Hello, " + escapeHtml(name) + "!</h1>");
            out.println("<p>Server time: " + currentTime + "</p>");
            out.println("<a href='index.jsp'>Back to Home</a>");
            out.println("</div>");
            out.println("</body></html>");
        }
    }

    // Basic protection against HTML injection in the name parameter
    private String escapeHtml(String input) {
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;");
    }
}
