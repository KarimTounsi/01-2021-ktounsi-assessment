$(function () {
    let BASE_URL = 'http://localhost:8080';
    let URL = '/api/employee/';
    function ajax() {
        function GetAllEmployee() {
            $('.tableInput').empty();
            $.ajax({
                url: BASE_URL + URL,
                method: $('.tableInput').data('method'),
                dataType: 'json'
            }).done(function (result) {
                result.forEach(function (element) {
                    let newTrElement = $('<tr>');
                    let newThElement = $('<th>');
                    let newTdElement1 = $('<td>');
                    let newTdElement2 = $('<td>');
                    let newTdElement4 = $('<td>');
                    let newTdElement5 = $('<td>');
                    newThElement.text(element.id);
                    newTdElement1.text(element.firstName);
                    newTdElement2.text(element.lastName);
                    newTdElement4.html("<button type=\"button\" class=\"btn btn-info Edit\">Edycja</button>")
                    newTdElement4.attr('id', element.id).data('method', 'PUT');
                    newTdElement5.html("<button type=\"button\" class=\"btn btn-danger delete\">Usuń</button>")
                    newTdElement5.attr('id', element.id).data('method', 'DELETE');
                    newTrElement.append(newThElement).append(newTdElement1).append(newTdElement2).append(newTdElement4).append(newTdElement5);
                    $('.tableInput').append(newTrElement);
                });
            });
        }

        GetAllEmployee();

        function post() {
            $('#addButton').on('click', function (e) {
                e.preventDefault();
                let newEmployee = {
                    firstName: $('#firstName').val(),
                    lastName: $('#lastName').val(),
                    address:{
                        street: $('#street').val(),
                        homeNumber: $('#homeNumber').val(),
                        postCode: $('#postCode').val(),
                        city: $('#city').val(),
                    },
                    email: $('#email').val(),
                    phoneNumber: $('#phoneNumber').val(),
                    dateOfEmployment: $('#dateOfEmployment').val(),
                    salary: $('#salary').val(),
                    department:{
                        name: $('#departmentName').val(),
                        location:{
                            street: $('#departmentStreet').val(),
                            homeNumber: $('#departmentHomeNumber').val(),
                            postCode: $('#departmentPostCode').val(),
                            city: $('#departmentCity').val(),
                        }
                    },
                    position:{
                        name: $('#positionName').val(),
                    },
                };
                $.ajax({
                    url: BASE_URL + URL,
                    method: $(this).data('method'),
                    data: JSON.stringify(newEmployee),
                    contentType: 'application/json'
                }).done(function () {
                    GetAllEmployee();
                    $('#firstName').val('');
                    $('#lastName').val('');
                    $('#street').val('');
                    $('#homeNumber').val('');
                    $('#postCode').val('');
                    $('#city').val('');
                    $('#email').val('');
                    $('#phoneNumber').val('');
                    $('#dateOfEmployment').val('');
                    $('#salary').val('');
                    $('#departmentName').val('');
                    $('#departmentStreet').val('');
                    $('#departmentHomeNumber').val('');
                    $('#departmentPostCode').val('');
                    $('#departmentCity').val('');
                    $('#positionName').val('');
                });
            });
        }

        post();

        function putUpdateEmployee() {
            $('.tableInput').on('click', '.Edit', function (element) {
                element.preventDefault();
                let newEmployee = {
                    id: $(this).parent().attr('id'),
                    firstName: $('#firstName').val(),
                    lastName: $('#lastName').val(),
                    address:{
                        street: $('#street').val(),
                        homeNumber: $('#homeNumber').val(),
                        postCode: $('#postCode').val(),
                        city: $('#city').val(),
                    },
                    email: $('#email').val(),
                    phoneNumber: $('#phoneNumber').val(),
                    dateOfEmployment: $('#dateOfEmployment').val(),
                    salary: $('#salary').val(),
                    department:{
                        name: $('#departmentName').val(),
                        location:{
                            street: $('#departmentStreet').val(),
                            homeNumber: $('#departmentHomeNumber').val(),
                            postCode: $('#departmentPostCode').val(),
                            city: $('#departmentCity').val(),
                        }
                    },
                    position:{
                        name: $('#positionName').val(),
                    },
                };
                $.ajax({
                    url: BASE_URL + URL + $(this).parent().attr('id'),
                    method: $(this).parent().data('method'),
                    data: JSON.stringify(newEmployee),
                    contentType: 'application/json'
                }).done(function () {
                    GetAllEmployee();
                    $('#firstName').val('');
                    $('#lastName').val('');
                    $('#street').val('');
                    $('#homeNumber').val('');
                    $('#postCode').val('');
                    $('#city').val('');
                    $('#email').val('');
                    $('#phoneNumber').val('');
                    $('#dateOfEmployment').val('');
                    $('#salary').val('');
                    $('#departmentName').val('');
                    $('#departmentStreet').val('');
                    $('#departmentHomeNumber').val('');
                    $('#departmentPostCode').val('');
                    $('#departmentCity').val('');
                    $('#positionName').val('');
                });
            });
        }

        putUpdateEmployee();


        function  deleteEmployee() {
            $('.tableInput').on('click', '.delete', function (element) {
                $.ajax({
                    url: BASE_URL + URL + $(this).parent().attr('id'),
                    method: $(this).parent().data('method'),
                }).done(function (result) {
                    GetAllEmployee();
                });
            });
        }

        deleteEmployee();
    }

    ajax();
});
