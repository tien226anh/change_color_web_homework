package backgroundcolor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Servlet implementation class BackgroundRandomServlet
 */
@WebServlet(urlPatterns = "/change_background")
public class BackgroundRandomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            InputStream inputStream = Files.newInputStream(Paths.get(getServletContext().getRealPath("/index.html")));
            String html = new String(inputStream.readAllBytes());
            String color1, color2;
            if (request.getParameter("random") != null) {
                color1 = getRandomHexColor();
                color2 = getRandomHexColor();
            } else {
                color1 = "#ff0000";
                color2 = "#0000ff";
            }
            html = html.replace("#ff0000", color1).replace("#0000ff", color2);
            out.println(html);
        }
    }

    private String getRandomHexColor() {
        return "#" + Integer.toHexString((int) (Math.random() * 0xFFFFFF));
    }
}