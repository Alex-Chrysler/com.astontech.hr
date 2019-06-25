function buildContactTable() {

    $.getJSON("/api/contact/", {
        ajax: 'true'
    }, function (data) {
        $.each(data, function (index, single) {
            var fullAddress = single.address.addressNumber + " " + single.address.street;
            $('#contact-table').find('tbody')
                .append("<tr>"+
                    "<td>" + single.id + "</td>" +
                    "<td>" + single.companyName + "</td>" +
                    "<td>" + fullAddress + "</td>" +
                    "<td>" + single.address.city + "</td>" +
                    "<td>" + single.address.state + "</td>" +
                    "<td>" + single.address.zipCode + "</td>" +
                    "<td>" + "<button onclick='editContact(" + single.id + ")'>Edit</button>"+ "</td>" +
                    "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "'>Delete</button>"+ "</td>" +
                    "</tr>");

        })
    })

}

function insertContact() {

    $('#contactId').val("");
    $('#contactVersion').val("");
    $('#inputCompanyName').val("");
    $('#inputAddressNumber').val("");
    $('#inputStreet').val("");
    $('#inputCity').val("");
    $('#inputState').val("");
    $('#inputZipCode').val("");

    $('#contactModal').modal('show')

}

function saveContact() {

    var id = $('#contactId').val();
    var version = $('#contactVersion').val();
    var companyName = $('#inputCompanyName').val();
    var addressNumber = $('#inputAddressNumber').val();
    var street = $('#inputStreet').val();
    var city = $('#inputCity').val();
    var state = $('#inputState').val();
    var zipCode = $('#inputZipCode').val();

    var address = {
        addressNumber: addressNumber,
        street: street,
        city: city,
        state: state,
        zipCode: zipCode
    }

    var contact = {
        id: id,
        version: version,
        companyName: companyName,
        address: address
    }
    console.log(contact)

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(contact),
        url: "/api/contact/",
        async: true,
        dataType: "json",
        success: function () {
            window.location.reload();
        }
    })

}

function editContact(id) {
    console.log(id);
    $.getJSON('/api/contact/' + id,{
        ajax:'true'
    }, function (contact) {
        console.log(contact);
        $('#contactId').val(contact.id);
        $('#contactVersion').val(contact.version);
        $('#inputCompanyName').val(contact.companyName);
        $('#inputAddressNumber').val(contact.address.addressNumber);
        $('#inputStreet').val(contact.address.street);
        $('#inputCity').val(contact.address.city);
        $('#inputState').val(contact.address.state);
        $('#inputZipCode').val(contact.address.zipCode);

        $('#contactModal').modal('show')
    })

}

function deleteModal() {


    $('#confirmDeleteModal').on('click', '.btn-ok', function (e) {
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        console.log(id);
        console.log("test");
        $.ajax({
            type: "delete",
            url: "/api/contact/" + id,
            async: true,
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("Error deleting Contact");
            }
        })
    });

    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });

}