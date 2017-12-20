var httpRequest;
var url = "http://localhost:8080";
var postFix = "";
var requestData = {};

function doRequest() {
    $.ajax({
        url: url,
        datatype: 'json',
        data: buildrequest(),
        success: function (json) {
            alert('success');
        },
        error: function (json) {
            alert(json);
        }
    });
    loadTable();
}

function loadTable() {
    $.ajax({
        url: '/list',
        success: function (html) {
            $("#data").html(html);
        },
        error: function (request, response, status) {
            console.log(response);
            console.log(status);
            console.log(request.responseText);
        }
    });
}

function buildrequest() {
    var data = {};
    data = requestData;
    requestData = {};
    postFix = "";
    return data;
}

function addRow() {
    url = "/addRow";
    requestData = $('#controlForm').serialize();
    doRequest();
}

function editRow(rawID) {
    alert("no implementation!!!!");
}

function deleteRow(rawID) {

    var id = rawID.toString().replace("delete", "");
    url = "/deleteRow";
    requestData["id"] = id;
    doRequest();
}
