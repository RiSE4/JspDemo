import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> userList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/simple_form?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
            );

            PreparedStatement ps =
                conn.prepareStatement("SELECT name FROM sample_user");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userList.add(rs.getString("name"));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("users", userList);

        RequestDispatcher rd =
            request.getRequestDispatcher("/result.jsp");
        rd.forward(request, response);
    }
}