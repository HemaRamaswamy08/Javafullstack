<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Song</title>
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
            text-align: center; /* Center content */
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
            width: calc(100% - 20px); /* Adjust for padding */
            padding: 12px 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 1em;
            box-sizing: border-box; /* Include padding in width */
        }
        input[type="text"]:focus {
            outline: none;
            border-color: #dc3545; /* Red focus for delete */
            box-shadow: 0 0 0 3px rgba(220, 53, 69, 0.25);
        }
        input[type="submit"] {
            background-color: #dc3545; /* Red for delete button */
            color: white;
            padding: 15px 25px;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
            width: 100%;
            box-shadow: 0 4px 8px rgba(220, 53, 69, 0.3);
        }
        input[type="submit"]:hover {
            background-color: #c82333;
            transform: translateY(-2px);
        }
        input[type="submit"]:active {
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(220, 53, 69, 0.4);
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
        <h2>Delete Song</h2>
        <form action="deleteSong" method="post">
            <div>
                <label for="musicId">Music ID to Delete:</label>
                <input type="text" id="musicId" name="id" required>
            </div>
            <input type="submit" value="Delete Song">
        </form>
        <a href="home.html" class="back-link">Back to Home</a>
    </div>
    <script type="text/javascript">
    	const urlParams = new URLSearchParams(window.location.search); 
        const musicId = urlParams.get('id');
         
        if(musicId){
        	document.getElementById('musicId').value = musicId;
        }
    </script>
</body>
</html>
