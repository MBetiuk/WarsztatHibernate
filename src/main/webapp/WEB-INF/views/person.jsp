<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>FORM</h1>
<form action="/person" method="post">
    login: <input type="text" name="login" placeholder='Podaj login' /> <br/>
    password: <input type='password' name="password"  placeholder='Podaj haslo' /> <br/>
    email: <input type='text' name="email" placeholder='Email' /> <br/>
    <input type='submit' value='Wyslij' />
</form>
<%--<h1>SELECT</h1>--%>
<%--<form>--%>
<%--    <select name="gender">--%>
<%--        <option value="">Select...</option>--%>
<%--        <option value="M">Male</option>--%>
<%--        <option value="F">Female</option>--%>
<%--    </select>--%>
<%--    <input type='submit' value='Wyslij' />--%>
<%--</form>--%>
<%--<h1>SELECT2</h1>--%>
<%--<form>--%>
<%--    <select name="colors" multiple>--%>
<%--        <option value="">Select...</option>--%>
<%--        <option value="red">Red</option>--%>
<%--        <option value="black">Black</option>--%>
<%--        <option value="green">Green</option>--%>
<%--        <option value="yellow">Yellow</option>--%>
<%--    </select>--%>
<%--    <input type='submit' value='Wyslij' />--%>
<%--</form>--%>
<%--<h1>checkbox</h1>--%>
<%--<form>--%>
<%--    Wybierz dodatki:--%>
<%--    <input type="checkbox" name="toppings" value="cheese"/>Dodatkowy ser--%>
<%--    <input type="checkbox" name="toppings" value="ham"/>Dodatkowa szynka--%>
<%--    <input type="checkbox" name="toppings" value="pineapple"/>Ananas--%>
<%--    <input type="checkbox" name="toppings" value="tomato"/>Pomidor--%>
<%--    <input type="checkbox" name="toppings" value="salami"/>Salami--%>
<%--    <input type='submit' value='Wyslij' />--%>
<%--</form>--%>
<%--<h1>RADIO</h1>--%>
<%--<form>--%>
<%--    Wybierz formę płatności:--%>
<%--    <input type="radio" name="payment" value="card" checked/>Karta kredytowa--%>
<%--    <input type="radio" name="payment" value="cash"/>Gotówka--%>
<%--    <input type="radio" name="payment" value="transfer"/>Przelew--%>
<%--    <input type='submit' value='Wyslij' />--%>
<%--</form>--%>
</body>
</html>
