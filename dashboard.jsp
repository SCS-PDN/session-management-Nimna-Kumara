<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Dashboard</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
    <a href="LogoutServlet">Logout</a>
    
    <h2>Available Courses</h2>
    <table border="1">
        <tr>
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Instructor</th>
            <th>Action</th>
        </tr>

        <% List<Course> courses = (List<Course>) request.getAttribute("courses");%>

        <%-- Will be populated by DashboardServlet --%>

        for (Course course : courses){
            <tr>
                <td><%= course.getCourseId() %></td>
                <td><%= course.getCourseName() %></td>
                <td><%= course.getInstructor() %></td>
                <td><a href="EnrollServlet?courseId=<%= course.getCourseId() %>">Enroll</a></td>
            </tr>
        }
    </table>

    <h2>Your Enrolled Courses</h2>
    <ul>
        <%-- Will display enrolled courses from session --%>
        <%List<String> enrolled = (List<String>) request.getAttribute("enrolledCourses");%>

         for (String courseId : enrolled) {
            <li><%= courseName %><%= courseId %></li>
         }

    </ul>
</body>
</html>