<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Frontend Webapp</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Simple Java Maven Frontend App</h1>
        <p>Ye page pure Java (JSP) se render ho raha hai — koi JavaScript framework nahi.</p>

        <form action="welcome" method="get">
            <label for="name">Apna naam daalo:</label>
            <input type="text" id="name" name="name" placeholder="e.g. Kirti" required>
            <button type="submit">Submit</button>
        </form>

        <hr>
        <p><strong>Build Info:</strong></p>
        <ul>
            <li>Packaging: WAR</li>
            <li>Server-side rendering: JSP + Servlet</li>
            <li>Deployable to: Apache Tomcat</li>
        </ul>
    </div>
</body>
</html>
