<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Song</title>
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
            border-color: #6f42c1; /* Purple focus */
            box-shadow: 0 0 0 3px rgba(111, 66, 193, 0.25);
        }
        input[type="submit"] {
            background-color: #6f42c1; /* Purple for update button */
            color: white;
            padding: 15px 25px;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
            width: 100%;
            box-shadow: 0 4px 8px rgba(111, 66, 193, 0.3);
        }
        input[type="submit"]:hover {
            background-color: #5a359c;
            transform: translateY(-2px);
        }
        input[type="submit"]:active {
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(111, 66, 193, 0.4);
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
        <h2>Update Song</h2>
        <form action="updateSong" method="post">
            <div>
                <label for="musicId">Music ID (required):</label>
                <input type="text" id="musicId" name="id" required>
            </div>
            <div>
                <label for="newTitle">New Title (optional):</label>
                <input type="text" id="newTitle" name="newTitle">
            </div>
            <div>
                <label for="newMovie">New Movie Name (optional):</label>
                <input type="text" id="newMovie" name="newMovie">
            </div>
            <input type="submit" value="Update Song">
        </form>
        <a href="displayAllSongs" class="back-link">Back to Home</a>
    </div>

    <script>
        // Get the URL parameters
        const urlParams = new URLSearchParams(window.location.search);
        // Get the 'id' parameter
        const musicId = urlParams.get('id');

        // If an ID is present, set it as the value of the musicId input field
        if (musicId) {
            document.getElementById('musicId').value = musicId;
        }
    </script>
</body>
</html>
