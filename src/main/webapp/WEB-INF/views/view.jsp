<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>View Employee </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-8">
            <form class="needs-validation" novalidate>
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="firstName">Imię</label>
                        <input type="text" class="form-control" id="firstName">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="lastName">Nazwisko</label>
                        <input type="text" class="form-control" id="lastName">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="phoneNumber">Numer telefonu</label>
                        <input type="number" class="form-control" id="phoneNumber">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="dateOfEmployment">Data zatrudnienia</label>
                        <input type="date" class="form-control" id="dateOfEmployment">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="salary">Wynagrodzenie</label>
                        <input type="number" class="form-control" id="salary">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                </div>
                <h5> Adres:</h5>
                <div class="form-row">
                    <div class="col-md-3 mb-3">
                        <label for="street">Ulica</label>
                        <input type="text" class="form-control" id="street">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="homeNumber">Numer domu</label>
                        <input type="text" class="form-control" id="homeNumber">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="postCode">kod pocztowy</label>
                        <input type="text" class="form-control" id="postCode">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="city">Miasto</label>
                        <input type="text" class="form-control" id="city">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                </div>
                <h5> Dział:</h5>
                <div class="form-row">
                    <div class="col-md-2 mb-3">
                        <label for="departmentName">Nazwa</label>
                        <input type="text" class="form-control" id="departmentName">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="departmentStreet">Ulica</label>
                        <input type="text" class="form-control" id="departmentStreet">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="departmentHomeNumber">Numer domu</label>
                        <input type="text" class="form-control" id="departmentHomeNumber">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="departmentPostCode">Kod pocztowy</label>
                        <input type="text" class="form-control" id="departmentPostCode">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="departmentCity">Miasto</label>
                        <input type="text" class="form-control" id="departmentCity">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                </div>
                <h5>Stanowisko:</h5>
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <label for="positionName">Nazwa</label>
                        <input type="text" class="form-control" id="positionName">
                        <div class="valid-tooltip">
                            Looks good!
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary" id="addButton" data-method="POST" type="submit">Wprowadź</button>
                    <a class="btn btn-second ml-3" href="/list">
                        Strona z listą
                    </a>
            </form>
        </div>
        <div class="col-md-4">
            <table class="table mt-6">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Imię</th>
                    <th scope="col">Nazwisko</th>
                    <th scope="col">Edycja</th>
                    <th scope="col">Usuwanie</th>
                </thead>
                <tbody class="tableInput" data-method="GET">
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="<c:url value="/resources/js/app-rest-employee.js"/>"></script>
</body>
</html>


