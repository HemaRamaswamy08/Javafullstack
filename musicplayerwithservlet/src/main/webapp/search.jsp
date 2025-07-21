<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Song</title>
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
            text-align: center;
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
        input[type="text"] {
            width: calc(100% - 20px);
            padding: 12px 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 1em;
            box-sizing: border-box;
        }
        input[type="text"]:focus {
            outline: none;
            border-color: #ffc107; /* Yellow/Orange focus */
            box-shadow: 0 0 0 3px rgba(255, 193, 7, 0.25);
        }
        input[type="submit"] {
            background-color: #ffc107; /* Yellow/Orange for search button */
            color: #333;
            padding: 15px 25px;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
            width: 100%;
            box-shadow: 0 4px 8px rgba(255, 193, 7, 0.3);
        }
        input[type="submit"]:hover {
            background-color: #e0a800;
            transform: translateY(-2px);
        }
        input[type="submit"]:active {
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(255, 193, 7, 0.4);
        }
        .back-link {
            display: block;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }
        .back-link:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Search Song</h2>
        <form action="searchSong" method="post"> <!-- No ID needed, no JS listener -->
            <div>
                <label for="musicId">Music ID to Search:</label>
                <input type="text" id="musicId" name="id" required>
            </div>
            <input type="submit" value="Search Song">
        </form>

        <a href="displayAllSongs" class="back-link">Back to Home</a>
    </div>
</body>
</html>