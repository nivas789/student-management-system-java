//package MVC;
//
////StudentServletpackage MVC;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/StudentServlet")
//public class StudentServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String action = request.getParameter("action");
//
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//
//        Connection con = null;
//		try {
//			con = DBConnection.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        try {
//
//            // INSERT
//            if ("insert".equals(action)) {
//
//                int id = Integer.parseInt(request.getParameter("id"));
//
//                String name = request.getParameter("name");
//
//                int age = Integer.parseInt(request.getParameter("age"));
//
//                String course = request.getParameter("course");
//
//                Student student =
//                        new Student(id, name, age, course);
//
//                PreparedStatement ps = con.prepareStatement(
//                        "INSERT INTO student VALUES (?, ?, ?, ?)"
//                );
//
//                ps.setInt(1, student.getId());
//                ps.setString(2, student.getName());
//                ps.setInt(3, student.getAge());
//                ps.setString(4, student.getCourse());
//
//                ps.executeUpdate();
//
//                out.println("<h2>Student inserted successfully!</h2>");
//
//                out.println("<br><a href='index.html'>Home</a>");
//            }
//
//            // UPDATE
//            else if ("update".equals(action)) {
//
//                int id = Integer.parseInt(request.getParameter("id"));
//
//                String name = request.getParameter("name");
//
//                int age = Integer.parseInt(request.getParameter("age"));
//
//                String course = request.getParameter("course");
//
//                PreparedStatement ps = con.prepareStatement(
//                        "UPDATE student SET name=?, age=?, course=? WHERE id=?"
//                );
//
//                ps.setString(1, name);
//                ps.setInt(2, age);
//                ps.setString(3, course);
//                ps.setInt(4, id);
//
//                int result = ps.executeUpdate();
//
//                if (result > 0) {
//
//                    out.println("<h2>Student updated successfully!</h2>");
//
//                } else {
//
//                    out.println("<h2>Student not found!</h2>");
//                }
//
//                out.println("<br><a href='index.html'>Home</a>");
//            }
//
//            // DELETE
//            else if ("delete".equals(action)) {
//
//                int id = Integer.parseInt(request.getParameter("id"));
//
//                PreparedStatement ps = con.prepareStatement(
//                        "DELETE FROM student WHERE id=?"
//                );
//
//                ps.setInt(1, id);
//
//                int result = ps.executeUpdate();
//
//                if (result > 0) {
//
//                    out.println("<h2>Student deleted successfully!</h2>");
//
//                } else {
//
//                    out.println("<h2>Student not found!</h2>");
//                }
//
//                out.println("<br><a href='index.html'>Home</a>");
//            }
//
//            con.close();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            out.println("<h2>Error occurred!</h2>");
//        }
//    }
//
//
//    // VIEW STUDENTS
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String action = request.getParameter("action");
//
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//
//        if ("view".equals(action)) {
//
//            Connection con = DBConnection.getConnection();
//
//            try {
//
//                PreparedStatement ps = con.prepareStatement(
//                        "SELECT * FROM student"
//                );
//
//                ResultSet rs = ps.executeQuery();
//
//                out.println("<html>");
//                out.println("<body>");
//
//                out.println("<h2>STUDENT DETAILS</h2>");
//
//                out.println("<table border='1'>");
//
//                out.println("<tr>");
//                out.println("<th>ID</th>");
//                out.println("<th>Name</th>");
//                out.println("<th>Age</th>");
//                out.println("<th>Course</th>");
//                out.println("</tr>");
//
//                while (rs.next()) {
//
//                    out.println("<tr>");
//
//                    out.println("<td>"
//                            + rs.getInt("id")
//                            + "</td>");
//
//                    out.println("<td>"
//                            + rs.getString("name")
//                            + "</td>");
//
//                    out.println("<td>"
//                            + rs.getInt("age")
//                            + "</td>");
//
//                    out.println("<td>"
//                            + rs.getString("course")
//                            + "</td>");
//
//                    out.println("</tr>");
//                }
//
//                out.println("</table>");
//
//                out.println("<br>");
//
//                out.println("<a href='index.html'>Home</a>");
//
//                out.println("</body>");
//                out.println("</html>");
//
//                con.close();
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//
//                out.println("<h2>Error occurred!</h2>");
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//package MVC;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/StudentServlet")
//public class StudentServlet extends HttpServlet {
//
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//    protected void doPost(HttpServletRequest request,
//                           HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//
//        try {
//
//            String action = request.getParameter("action");
//
//            if ("insert".equals(action)) {
//
//                int id = Integer.parseInt(request.getParameter("id"));
//                String name = request.getParameter("name");
//                int age = Integer.parseInt(request.getParameter("age"));
//                String course = request.getParameter("course");
//
//                Connection con = DBConnection.getConnection();
//
//                PreparedStatement ps = con.prepareStatement(
//                    "INSERT INTO student (id, name, age, course) VALUES (?, ?, ?, ?)"
//                );
//
//                ps.setInt(1, id);
//                ps.setString(2, name);
//                ps.setInt(3, age);
//                ps.setString(4, course);
//
//                ps.executeUpdate();
//
//                out.println("<h2>Student inserted successfully!</h2>");
//
//                ps.close();
//                con.close();
//            }
//
//        } catch (Exception e) {
//
//            out.println("<h2>DATABASE ERROR</h2>");
//
//            out.println("<pre>");
//            out.println(e.getMessage());
//            out.println("</pre>");
//
//            e.printStackTrace();
//        }
//    }
//}


package MVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // =========================
    // INSERT / UPDATE / DELETE
    // =========================
    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        try {

            // =========================
            // INSERT STUDENT
            // =========================
            if ("insert".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                String course = request.getParameter("course");

                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student (id, name, age, course) VALUES (?, ?, ?, ?)"
                );

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, course);

                ps.executeUpdate();

                out.println("<html><body>");
                out.println("<h2>Student inserted successfully!</h2>");
                out.println("<br>");
                out.println("<a href='index.html'>Home</a>");
                out.println("</body></html>");

                ps.close();
                con.close();
            }

            // =========================
            // UPDATE STUDENT
            // =========================
            else if ("update".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                String course = request.getParameter("course");

                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(
                    "UPDATE student SET name=?, age=?, course=? WHERE id=?"
                );

                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, course);
                ps.setInt(4, id);

                int result = ps.executeUpdate();

                out.println("<html><body>");

                if (result > 0) {
                    out.println("<h2>Student updated successfully!</h2>");
                } else {
                    out.println("<h2>Student not found!</h2>");
                }

                out.println("<br>");
                out.println("<a href='index.html'>Home</a>");

                out.println("</body></html>");

                ps.close();
                con.close();
            }

            // =========================
            // DELETE STUDENT
            // =========================
            else if ("delete".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));

                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM student WHERE id=?"
                );

                ps.setInt(1, id);

                int result = ps.executeUpdate();

                out.println("<html><body>");

                if (result > 0) {
                    out.println("<h2>Student deleted successfully!</h2>");
                } else {
                    out.println("<h2>Student not found!</h2>");
                }

                out.println("<br>");
                out.println("<a href='index.html'>Home</a>");

                out.println("</body></html>");

                ps.close();
                con.close();
            }

            else {
                out.println("<h2>Invalid action!</h2>");
            }

        } catch (Exception e) {

            out.println("<html><body>");
            out.println("<h2>DATABASE ERROR</h2>");
            out.println("<pre>");
            out.println(e.getMessage());
            out.println("</pre>");
            out.println("<br>");
            out.println("<a href='index.html'>Home</a>");
            out.println("</body></html>");

            e.printStackTrace();
        }
    }


    // =========================
    // VIEW STUDENTS
    // =========================
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if ("view".equals(action)) {

            try {

                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM student"
                );

                ResultSet rs = ps.executeQuery();

                out.println("<html>");
                out.println("<head>");
                out.println("<title>View Students</title>");
                out.println("</head>");

                out.println("<body>");

                out.println("<h1>STUDENT DETAILS</h1>");

                out.println("<table border='1' cellpadding='10'>");

                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>Name</th>");
                out.println("<th>Age</th>");
                out.println("<th>Course</th>");
                out.println("</tr>");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    out.println("<tr>");

                    out.println("<td>"
                            + rs.getInt("id")
                            + "</td>");

                    out.println("<td>"
                            + rs.getString("name")
                            + "</td>");

                    out.println("<td>"
                            + rs.getInt("age")
                            + "</td>");

                    out.println("<td>"
                            + rs.getString("course")
                            + "</td>");

                    out.println("</tr>");
                }

                out.println("</table>");

                if (!found) {
                    out.println("<h3>No students found.</h3>");
                }

                out.println("<br>");
                out.println("<a href='index.html'>Home</a>");

                out.println("</body>");
                out.println("</html>");

                rs.close();
                ps.close();
                con.close();

            } catch (Exception e) {

                out.println("<h2>DATABASE ERROR</h2>");

                out.println("<pre>");
                out.println(e.getMessage());
                out.println("</pre>");

                e.printStackTrace();
            }

        } else {

            out.println("<h2>Invalid action!</h2>");
            out.println("<br>");
            out.println("<a href='index.html'>Home</a>");
        }
    }
}