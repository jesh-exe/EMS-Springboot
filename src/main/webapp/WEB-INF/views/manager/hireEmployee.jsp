<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- This is the taglib of Spring Framework provided Tag Library
	 prefix decides the tag name to be used -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://unpkg.com/scrollreveal"></script>
    <title>Hire Employee Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI';
            background-color: #f4f4f4;
            width: 100%;
            height: 100vh;
            background-image: linear-gradient(rgba(0, 0, 50, 0.7),
                    rgba(0, 0, 50, 0.7)),
                url(https://empmonitor.com/blog/wp-content/uploads/2021/08/Work-from-home.jpg);
            background-position: center;
            background-size: cover;
        }

        .container {
            /* width: 30%; */
            max-width: 800px;
            margin: 50px auto;
            background: rgba(255, 255, 255);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;

        }

        .container1,
        .container2 {
            width: 37%;
        }

        .sub-container {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }

        h1 {
            text-align: center;
            color: #1976D2;
        }

        form {
            display: grid;
            gap: 20px;
        }

        label {
            font-weight: bold;
            font-size: small;
        }

        input,
        select {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-family: 'Segoe UI';
			margin-bottom: 20px;
        }

        button {
            width: 30%;
            background: #1976D2;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #1565C0;
        }

        #btn-cnt {
            display: flex;
            justify-content: center;
        }

        @media screen and (max-width: 600px) {
            .container {
                padding: 10px;
                width: 80%;
            }
        }

        footer {
            text-align: center;
            width: 100%;
            background-color: rgb(84, 147, 255);
            color: white;
            font-size: medium;
            position: fixed;
            bottom: 0;
        }
    </style>
</head>

<body>
    <div class="container">

        <h1>Hire Employee</h1>
        <!-- This is used to provide a better readability and better approach to write url -->
        <spring:url var="url" value="/employee/hireEmployee" />
		<form action="${url}" method="post">
       		<div class="sub-container">
                <div class="container1">

                    <label for="fname">First Name</label> <input type="text" id="fname" name="fname" required> <label
                        for="lname">Last
                        Name</label> <input type="text" id="lname" name="lname" required> <label for="email">Email
                        ID</label> <input type="text" id="email" name="email" required> <label
                        for="pass">Password</label>
                    <input type="password" id="pass" name="pass" required> <label for="joinDate">Date of
                        Joining:</label> <input type="date" id="doj" name="joinDate" required> <label for="type">Select
                        Type</label> <select name="type">
                        <option value="FULL_TIME">Full Time</option>
                        <option value="PART_TIME">Part Time</option>
                        <option value="CONTRACT">Contract</option>
                    </select> <label for="salary">Salary</label> <input type="number" id="sal" name="salary" required
                        min="15000">

                </div>

                <div class="container2">

                    <label for="aadhaar">Aadhaar Number</label> <input type="text" id="aadhaar" name="aadhaar" required>
                    <label for="doc">Date of Creation</label> <input type="date" id="doc" name="doc" required>
                    <label for="city">City</label> <input type="text" id="city" name="city" required>
                    <label for="state">State</label><input type="text" id="state" name="state" required>
                    <label for="country">Country</label> <input type="text" id="country" name="country" required>
                    <label for="zip">Zip Code</label> <input type="number" id="zip" name="zip" required
                        min="100000" max="1000000">
                    <label for="type">Department</label>
                    <select name="type">
                        <option value="FULL_TIME">Full Time</option>
                        <option value="PART_TIME">Part Time</option>
                        <option value="CONTRACT">Contract</option>
					</select> 
                        
                </div>
                
        	</div>
   		 	<div id="btn-cnt">
   		 
    			<button type="submit">Add Employee</button>
				&nbsp; &nbsp;
				<button type="reset">Clear</button>
		    </div>
		</form>
    </div>
    <footer>
        <div>Designed by @Jayesh Murodiya</div>
    </footer>
    
    <script>
    
    ScrollReveal({
        duration: 2000,
        delay: 0
    });

    ScrollReveal().reveal('.container', { scale: 0.85 });
    
    </script>
    
</body>

</html>