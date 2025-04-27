<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="HomePage.html" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather Information Form</title>
    <style>
        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background: #121212;
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: flex-start; /* Ensures that the content aligns to the top */
            min-height: 100vh;
            color: white;
            margin: 0;
        }

        .form-container {
            background-color: #1e1e1e;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 255, 153, 0.3);
            width: 100%;
            max-width: 700px; /* Reduced max-width for a smaller form */
            display: flex;
            flex-wrap: wrap;
            gap: 20px; /* Increased gap between inputs */
            margin-top: 120px; /* Increased margin-top value for more space */
        }

        .form-container h2 {
            text-align: center;
            color: #00ff99;
            width: 100%;
            margin-bottom: 15px; /* Reduced margin */
        }

        .form-group {
            width: 45%; /* Ensures two fields per row */
            display: inline-block;
            margin-bottom: 25px; /* Increased margin for gap between fields */
        }

        .form-group label {
            margin-bottom: 6px; /* Reduced label margin */
            color: #ccc;
            font-weight: bold;
            font-size: 14px; /* Reduced font size */
        }

        .form-group input {
            width: 100%;
            padding: 10px; /* Reduced padding */
            border: 2px solid #00ff99;
            border-radius: 8px;
            background-color: #2c2c2c;
            color: white;
            font-size: 14px; /* Reduced font size */
            outline: none;
            transition: all 0.3s ease;
        }

        .form-group input[readonly] {
            background-color: #2c2c2c;
            cursor: not-allowed; /* Change cursor to not-allowed to indicate read-only */
        }

        /* Hover effect on inputs */
        .form-group input:hover {
            border-color: #00cc66;
        }

        /* Mobile responsiveness */
        @media (max-width: 768px) {
            .form-group {
                width: 100%; /* Stacks the inputs vertically on smaller screens */
            }
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h2>Weather Details</h2>
        <form action="WeatherServlet" method="post">
            <!-- First row: City and Country -->
            <div class="form-group">
                <label for="city">City Name</label>
                <input type="text" id="city" name="city" value="<%= request.getAttribute("city") %>" readonly>
            </div>

            <div class="form-group">
                <label for="country">Country</label>
                <input type="text" id="country" name="country" value="<%= request.getAttribute("country") %>"readonly>
            </div>

            <!-- Second row: Temperature and Minimum Temperature -->
            <div class="form-group">
                <label for="temperature">Temperature (°C)</label>
                <input type="text" id="temperature" name="temperature" value="<%= request.getAttribute("temp") %>" readonly>
            </div>

            <div class="form-group">
                <label for="minTemp">Minimum Temperature (°C)</label>
                <input type="text" id="minTemp" name="minTemp" value="<%= request.getAttribute("min-temp") %>" readonly>
            </div>

            <!-- Third row: Maximum Temperature and Humidity -->
            <div class="form-group">
                <label for="maxTemp">Maximum Temperature (°C)</label>
                <input type="text" id="maxTemp" name="maxTemp" value="<%= request.getAttribute("max-temp") %>" readonly>
            </div>

            <div class="form-group">
                <label for="humidity">Humidity (%)</label>
                <input type="text" id="humidity" name="humidity" value="<%= request.getAttribute("humidity") %>" readonly>
            </div>

            <!-- Fourth row: Pressure and Cloudiness -->
            <div class="form-group">
                <label for="pressure">Pressure (hPa)</label>
                <input type="text" id="pressure" name="pressure" value="<%= request.getAttribute("pressure") %>" readonly>
            </div>

            <div class="form-group">
                <label for="cloud">Cloudiness (%)</label>
                <input type="text" id="cloud" name="cloud" value="<%= request.getAttribute("cloud") %>" readonly>
            </div>

            <!-- Fifth row: Wind Speed and Wind Direction -->
            <div class="form-group">
                <label for="windSpeed">Wind Speed (m/s)</label>
                <input type="text" id="windSpeed" name="windSpeed" value="<%= request.getAttribute("wind-speed") %>" readonly>
            </div>

            <div class="form-group">
                <label for="windDirection">Wind Direction (°)</label>
                <input type="text" id="windDirection" name="windDirection" value="<%= request.getAttribute("wind-direction") %>" readonly>
            </div>

            <!-- Sixth row: Sunrise and Sunset -->
            <div class="form-group">
                <label for="sunrise">Sunrise (Timestamp)</label>
                <input type="text" id="sunrise" name="sunrise" value="<%= request.getAttribute("sunrise") %>" readonly>
            </div>

            <div class="form-group">
                <label for="sunset">Sunset (Timestamp)</label>
                <input type="text" id="sunset" name="sunset" value="<%= request.getAttribute("sunset") %>" readonly>
            </div>
        </form>
    </div>
</body>
</html>
