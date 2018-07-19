<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<link rel="stylesheet" type="text/css" href="static/style/style.css">
<title>Админ Страница</title>
</head>
<body>

	<c:choose><c:when test="${mode == 'MODE_POCETNA'}">
	<header id="home">
		<div class="hero">
			<div class="overlay"></div>
			<h1>Добро дошли</h1>
		</div>
	</header>
	</c:when></c:choose>
	
	<div class="sticky-wrapper">
		<nav>
			<ul>
				<li><a href="pocetna">Почетна</a></li>
				<li><a href="novi_korisnik">Додај корисника</a></li>
				<li><a href="svi_korsnici">Сви корисници</a></li>
				<li><a href="login">Login</a></li>
			</ul>
		</nav>
	</div>

	<c:choose><c:when test="${mode == 'MODE_PRIKAZKORISNIKA'}">
	<h2 style="font-size: 200%; color: green; padding-left: 50px">Приказ свих корисника</h2>
	<table id="customers">
		<tr>
			<th>ID број</th>
			<th>Корисничко име</th>
			<th>Име</th>
			<th>Презиме</th>
			<th>Година</th>
			<th>Лозинка</th>
			<th>Обриши</th>
			<th>Измени</th>
		</tr>
		<c:forEach var="korisnik" items="${korisnici}">
		<tr>
			<td>${korisnik.id}</td>
			<td>${korisnik.korisnickoIme}</td>
			<td>${korisnik.ime}</td>
			<td>${korisnik.prezime}</td>
			<td>${korisnik.godina}</td>
			<td>${korisnik.lozinka}</td>
			<td><a href="/obrisi_korisnika?id=${korisnik.id }">
				<img alt="obrisi" src="static/img/delete.png" style="display: block; margin-left: auto; margin-right: auto"></a>
			</td>
			<td><a href="/prikazi_korisnika?id=${korisnik.id }">
				<img alt="edit" src="static/img/edit.png" style="display: block; margin-left: auto; margin-right: auto"></a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</c:when>
	
	<c:when test="${mode == 'MODE_REGISTRACIJA'}">
	<h2 style="font-size: 200%; color: green; padding-left: 50px">Унеси новог корисника</h2>
	<div id="form">
		<form action="/snimi_korisnika" method="POST">
			<label style="color: black">Корисничко име</label> 
			<input type="text" name="korisnickoIme" placeholder="Унесите ваше корисничко име ...">
			
			<label style="color: black">Име</label> 
			<input type="text" name="ime" placeholder="Унесите ваше име ...">
			
			<label style="color: black">Презиме</label> 
			<input type="text" name="prezime" placeholder="Унесите ваше презиме ...">

			<label style="color: black">Година</label> 
			<input type="text" name="godina" placeholder="Унесите број ваших година ..."> 
			
			<label style="color: black">Лозинка</label> 
			<input type="password" name="lozinka" placeholder="Унесите вашу лозинку ..."> 
			
			<input type="submit" value="Потврди">
		</form>
	</div>
	</c:when>
	
	<c:when test="${mode == 'MODE_IZMENA'}">
	<h2 style="font-size: 200%; color: green; padding-left: 50px">Измени податке постојећег корисника</h2>
	<div id="form">
		<form action="/snimi_izmenu" method="POST">
			<input type="hidden" name="id" value="${korisnik.id }" >
		
			<label style="color: black">Корисничко име</label> 
			<input type="text" name="korisnickoIme" value="${korisnik.korisnickoIme }">
			
			<label style="color: black">Име</label> 
			<input type="text" name="ime" value="${korisnik.ime }">
			
			<label style="color: black">Презиме</label> 
			<input type="text" name="prezime" value="${korisnik.prezime }">

			<label style="color: black">Година</label> 
			<input type="text" name="godina" value="${korisnik.godina }"> 
			
			<label style="color: black">Лозинка</label> 
			<input type="text" name="lozinka" value="${korisnik.lozinka }"> 
			
			<input type="submit" value="Потврди">
		</form>
	</div>
	</c:when>
	<c:when test="${mode == 'MODE_LOGIN'}">
	<div class="login-card">
   	  <h1>Log-in</h1><br>
   	  <div style="text-align: center; background-color: #f44336; color: white;">${error}</div>
	  <form action="/provera_korisnika" method="POST">
	    <input type="text" name="korisnickoIme" placeholder="Унесите корисничко име">
	    <input type="password" name="lozinka" placeholder="Унесите лозинку">
	    <input type="submit" name="login" class="login login-submit" value="Улогуј се">
	  </form>
	    
	  <div class="login-help">
	    <a href="novi_korisnik">Региструј се</a>
	  </div>
	</div>
	</c:when>
	</c:choose>

	
</body>
</html>