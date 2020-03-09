<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sacred Heart</title>
    <style>
        body {
            background-color: #ffffff
        }

        h1 {
            color: forestgreen;
            text-align: center
        }

        p {
            color: crimson;
            font-family: Calibri;
            font-style: italic
        }

        .c {
            border: 1px solid #333; /* Рамка */
            display: inline-block;
            padding: 5px 15px; /* Поля */
            text-decoration: none; /* Убираем подчёркивание */
            color: #000; /* Цвет текста */
        }

        .c:hover {
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3); /* Тень */
            background: linear-gradient(to bottom, #fcfff4, rgba(193, 193, 193, 0.98)); /* Градиент */
            color: #a00;
        }
    </style>
</head>
<body>
<h1>HOME PAGE</h1>
<p>
    <a href="/patient/save" class="c">To register</a>
    <a href="http://localhost:8080/doctor/getAll" class="c">Our doctors</a>
    <a href="http://localhost:8080/visit" class="c">Sign up for an appointment with the doctor</a>
</p>

</body>
</html>