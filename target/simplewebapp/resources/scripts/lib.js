var httpRequest;
var url = "http://localhost:8080";

function iniRequest() {
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    httpRequest.onreadystatechange = feedback;
}

function feedback() {
    if (httpRequest.readyState == 4) {
        //processing response
    } else {

    }
    if (httpRequest.status == 200) {
        //cool
    } else {

    }
}

function addRow() {
    var field01 = $("input[name='f1']").val();
    var field02 = $("input[name='f2']").val();
    var field03 = $("input[name='f3']").val();
    var R = url.concat("/addRow?f1=").concat(field01).concat("&f2=").concat(field02).concat("&f3=").concat(field03);
    httpRequest.open('GET', R, true);
    httpRequest.send(null);
}

function editRow(rawID) {
    var id = rawID.toString().replace("edit", "");
    var nf1 = "f1" + id;
    var nf2 = "f2" + id;
    var nf3 = "f3" + id;
    var field01 = $("input[name="+nf1+"]").val();
    var field02 = $("input[name="+nf2+"]").val();
    var field03 = $("input[name="+nf3+"]").val();
    var R = url.concat("/updateRow?id=").concat(id).concat("$f1=").concat(field01).concat("&f2=").concat(field02).concat("&f3=").concat(field03);
    httpRequest.open('POST', R, true);
    httpRequest.send(null);
}

function deleteRow(rawID) {

    var id = rawID.toString().replace("delete", "");
    var R = url.concat("/deleteRow?id=").concat(id);
    httpRequest.open('DELETE', R, true);
    httpRequest.send(null);
}

function handeB(rawID, button) {
    switch (button.text()) {
        case "Add":
            addRow();
            break;
        case "Edit":
            editRow(rawID);
            break;
        case "Delete":
            deleteRow(rawID);
            break;
        default:
            break;
    }
}