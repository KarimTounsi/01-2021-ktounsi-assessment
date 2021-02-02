$(function () {
    let BASE_URL = 'http://localhost:8080';
    let URL = '/api/employee/';
    function ajax() {
        function getList() {
            $('.list').empty();
            $.ajax({
                url: BASE_URL + URL + 'list/',
                method: $('.list').data('method'),
                dataType: 'json'
            }).done(function (result) {
                result.forEach(function (element) {
                    let newTrElement = $('<tr>');
                    let newThElement = $('<th>');
                    let newTdElement1 = $('<td>');
                    let newTdElement2 = $('<td>');
                    newThElement.text(element.positionName);
                    newTdElement1.text(element.avgSalary);
                    newTdElement2.text(element.years);
                    newTrElement.append(newThElement).append(newTdElement1).append(newTdElement2);
                    $('.list').append(newTrElement);
                });
            });
        }

        getList();
    }

    ajax();
});
