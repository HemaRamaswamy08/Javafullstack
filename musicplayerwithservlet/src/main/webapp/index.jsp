<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Song</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f0f2f5;
            margin: 0;
        }
        .form-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 90%;
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
            font-size: 2em;
        }
        form div {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 20px); /* Adjust for padding */
            padding: 12px 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 1em;
            box-sizing: border-box; /* Include padding in width */
        }
        input[type="text"]:focus,
        input[type="number"]:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.25);
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 15px 25px;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
            width: 100%;
            box-shadow: 0 4px 8px rgba(40, 167, 69, 0.3);
        }
        input[type="submit"]:hover {
            background-color: #218838;
            transform: translateY(-2px);
        }
        input[type="submit"]:active {
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(40, 167, 69, 0.4);
        }
        .back-link {
            display: block; /* Makes it take full width and allows margin-top */
            margin-top: 20px; /* Space above the link */
            color: #007bff; /* Blue color */
            text-decoration: none; /* Remove underline */
            font-weight: bold;
            transition: color 0.3s ease;
            text-align: center; /* Center the link text */
        }
        .back-link:hover {
            color: #0056b3; /* Darker blue on hover */
            text-decoration: underline; /* Underline on hover */
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add New Song</h2>
        <form action="submit" method="post">
            <div>
                <label for="musicId">Music ID:</label>
                <input type="text" id="musicId" name="id" required>
            </div>
            <div>
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div>
                <label for="movie">Movie Name:</label>
                <input type="text" id="movie" name="movie" required>
            </div>
            <div>
                <label for="year">Year:</label>
                <input type="number" id="year" name="year" required>
            </div>
            <input type="submit" value="Submit Song">
        </form>
         <a href="displayAllSongs" class="back-link">Back to Home</a>
    </div>
</body>
</html>
