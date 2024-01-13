<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/scrollreveal"></script>
    <title>Project Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            width: 100%;
     		height: 100vh;
     		background-image: linear-gradient(rgba(0, 0, 50, 0.7), rgba(0, 0, 50, 0.7)), url(https://empmonitor.com/blog/wp-content/uploads/2021/08/Work-from-home.jpg);
      		background-position: center;
      		background-size: cover;
        }

        .dashboard-container {
            max-width: 70%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
      		color: #0078c8;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #0F52BA;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .action-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
        }

        button.logout-btn {
            background-color: #dc3545;
        }

        button:hover {
        	transition : 0.8s;
            background-color: #0056b3;
        }

        @media (max-width: 600px) {
            table {
                font-size: 14px;
            }
        }
    </style>
</head>

<body>

	<spring:url var="url" value="/login/logout" />

    <div class="dashboard-container">
        <h1>${requestScope.empDetails.firstName} Projects</h1>
        


        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="emp" items="${requestScope.empProj}" >
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.title}</td>
                    <td>${emp.startDate}</td>
                    <td>${emp.endDate}</td>
                </tr>
            </c:forEach>
               
            </tbody>
        </table>

        <div class="action-buttons">
            
            <a href=""><button type="button">Add Candidate</button></a>
            <a href="${url}"><button class="logout-btn">Logout</button></a>

        </div>
    </div>
    <script>
    
    ScrollReveal({
        duration: 2000,
        delay: 0
    });

    ScrollReveal().reveal('.dashboard-container', { scale: 0.85 });
    
    </script>
</body>

</html>
