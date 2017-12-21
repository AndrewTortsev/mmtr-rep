var httpRequest;
var url = "http://localhost:8080";
var postFix = "";
var requestData = {};

function setEvents() {
    $('button.edit').on("click", function () {
        editRow($(this));
    });
    $('button.add').on("click", function () {
        addRow();
    });
    $('button.save').on("click", function () {
        updateRow($(this));
    });
    $('button.delete').on("click", function () {
        deleteRow($(this).attr("id"));
    });
}

function doRequest() {
    $.ajax({
        url: url,
        datatype: 'json',
        data: buildrequest(),
        success: function (json) {
            console.log("success")
        },
        error: function (json) {
            console.log("error")
        }
    });
    loadTable();
}

function updateRow(button) {
    button.text("Edit");
    button.removeClass('save').addClass('edit');
    var tr = button.closest("tr");
    requestData = getTrInData(tr);
    url = "/updateRow";
    doRequest();
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

function editRow(button) {
    button.text("Save");
    button.removeClass('edit').addClass('save');
    var tr = button.closest("tr");
    var data = getTrData(tr);
    var newTr = renderControls(data, tr);
    merge(tr, newTr);
    setEvents();
}

function merge(tr, newTr) {
    tr.html(newTr.html());
}

function getTrInData(tr) {
    var data = {};
    $.each(tr.find("td"), function (ii, vv) {
        $.each($(vv).find("input"), function (i, v) {
            data[$(v).attr('name')] = $(v).val();
        })
    });
    return data;
}

function getTrData(tr) {
    var data = {};
    //{id:12,f1:1,f2:3}
    $.each(tr.find("td"), function (ii, vv) {
        data[$(vv).data("name")] = $(vv).text();
    });
    return data;
}

function renderControls(data, oldTr) {
    var tr = $('<tr/>');
    for (key in data) {
        var td = $('<td/>');
        var inp = $('<input>', {
            type: (key == "id") ? "hidden" : "text",
            name: key,
            value: data[key]
        });
        $(inp).appendTo(td);
        $(td).appendTo(tr);
    }
    $.each(oldTr.find("th"), function (ii, vv) {
        $(vv).appendTo(tr);
    });
    return tr;
}

function deleteRow(rawID) {

    var id = rawID.toString().replace("delete", "");
    url = "/deleteRow";
    requestData["id"] = id;
    doRequest();
}
