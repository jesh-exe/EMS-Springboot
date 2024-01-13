<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://unpkg.com/scrollreveal"></script>
  <title>Employee Details</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
      width: 100%;
      height: 100vh;
      background-image: linear-gradient(rgba(0, 0, 50, 0.7), rgba(0, 0, 50, 0.7)), url(https://empmonitor.com/blog/wp-content/uploads/2021/08/Work-from-home.jpg);
      background-position: center;
      background-size: cover;
    }

    .mainContainer{
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
    }

    .container {
      /* max-width: 800px;
      margin: 20px auto; */
      display: flex;
      flex-direction: column;
      flex-wrap: wrap;
      /* flex-grow: 1; */
      /* flex-flow: column; */
      /* justify-items: center; */
      width: 60%;
      background-color: #fff;
      border-radius: 18px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      overflow: hidden;
    }

    .container1,
    .container2 {
      width: 40%;
      overflow: hidden;
      /* word-wrap: normal; */

    }

    .container2 {
      text-align: right;
    }

    header {
      background-color: #3498db;
      color: #fff;
      text-align: center;
      padding: 20px;
    }

    h1 {
      margin: 0;
      font-size: 40px;
    }

    h3 {
      text-align: center;
      text-decoration: underline;
    }

    .details-block {
      padding: 20px;
      padding-top: 0px;
      border-bottom: 1px solid #ddd;
      display: flex;
      justify-content: space-around;
      flex-wrap: wrap;
    }

    .label {
      font-weight: bold;
      color: #555;
    }

    .value {
      margin-bottom: 10px;
      color: #333;
    }

    /* .container1{
      d
    } */


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
      .container {
        border-radius: 0;
      }
    }
  </style>
</head>

<body>

	
  <!-- <div class="image">

  </div> -->
  <div class="mainContainer">

    <div class="container">

      <header>
        <h1>Employee Details</h1>
      </header>

      <!-- Personal Details Block -->
      <div class="label">
        <h3>Personal Details</h3>
      </div>
      <div class="details-block">
        <div class="container1">
          <div class="label">Employee ID:</div>
          <div class="value">${empDet.id}</div>

          <div class="label">First Name:</div>
          <div class="value">${empDet.firstName}</div>

          <div class="label">Email:</div>
          <div class="value">${empDet.email}</div>
        </div>

        <div class="container2">
          <div class="label">Aadhar Card:</div>
          <div class="value">${empDet.aadhaarDetails.aadhaarNumber}</div>

          <div class="label">Last Name:</div>
          <div class="value">${empDet.lastName}</div>

        </div>
      </div>

      <!-- Address Details Block -->
      <div class="label">
      <h3>Address Details</h3>
      </div>
      <div class="details-block">
        <div class="container1">
          <div class="label">City:</div>
          <div class="value">${empAddr.city}</div>

          <div class="label">Country</div>
          <div class="value">${empAddr.country}</div>

        </div>
        <div class="container2">
          <div class="label">State:</div>
          <div class="value">${empAddr.state}</div>

          <div class="label">ZIP Code:</div>
          <div class="value">${empAddr.zipCode}</div>
        </div>
      </div>

      <!-- Employment Details Block -->
	 <div class="label">
      <h3>Job Related Details</h3>
	 </div>
      <div class="details-block">
        <div class="container1">

          <div class="label">Department:</div>
          <div class="value">${empDet.myDepartment.name}</div>

          <div class="label">Salary:</div>
          <div class="value">${empDet.salary}</div>

          <div class="label">Joining Date:</div>
          <div class="value">${empDet.joinDate}</div>

        </div>
        <div class="container2">

		<spring:url var="url" value="/employee/projects"></spring:url>

          <div>
            <a href="${url}/${empDet.email}">
              <button>
                Show Projects
              </button>
            </a>
          </div>
          <br>
          <div>
            <a href="">
              <button>
                Board on Project
              </button>
            </a>
          </div>
          <br>
          <div>
            <a href="">
              <button>
                Deboard from Project
              </button>
            </a>
          </div>
        </div>
      </div>

    </div>
  </div>
  
  <script>
    
    ScrollReveal({
        duration: 2000,
        delay: 0
    });

    ScrollReveal().reveal('.mainContainer', { scale: 0.85 });
    
    </script>

</body>

</html>