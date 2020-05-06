$(document).ready(function() {
	$("#alertSuccess").hide();

	$("#alertError").hide();


});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------

	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	console.log($("#hidItemIDUpdate").val());
	console.log($("#formItem").serialize());

	$.ajax({
		url : "ItemsAPI",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});
});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}

	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();

	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}

// UPDATE==========================================
$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			
			
			$("#hidItemIDSave").val(
					$(this).closest("tr").find('#hidItemIDUpdate').val());
			
			$("#u_fname").val($(this).closest("tr").find('td:eq(0)').text());
			$("#u_lname").val($(this).closest("tr").find('td:eq(1)').text());
			$("#u_age").val($(this).closest("tr").find('td:eq(2)').text());
			$("#u_address").val($(this).closest("tr").find('td:eq(3)').text());
			$("#u_sex").val($(this).closest("tr").find('td:eq(4)').text());
			$("#u_email").val($(this).closest("tr").find('td:eq(5)').text());
			$("#u_username").val($(this).closest("tr").find('td:eq(6)').text());
			$("#u_password").val($(this).closest("tr").find('td:eq(7)').text());
			$("#u_type").val($(this).closest("tr").find('td:eq(8)').text());
			$("#u_contact").val($(this).closest("tr").find('td:eq(9)').text());
			
		});

// REMOVE==========================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "ItemsAPI",
		type : "DELETE",
		data : "u_id=" + $(this).data("u_id"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// CLIENTMODEL=========================================================================
function validateItemForm() {

	// NAME
	if ($("#u_fname").val().trim() == "") {
		return "Insert First Name.";
	}
	if ($("#u_lname").val().trim() == "") {
		return "Insert Last Name.";
	}
	if ($("#u_age").val().trim() == "") {
		return "Insert Age.";
	}
	var tmpAge = $("#u_age").val().trim();
	if (!$.isNumeric(tmpAge)) {
		return "Insert a numerical value for Age.";
	}
	
	if ($("#u_address").val().trim() == "") {
		return "Insert Address.";
	}
	if ($("#u_sex").val().trim() == "") {
		return "Insert Sex.";
	}
	if ($("#u_email").val().trim() == "") {
		return "Insert Email.";
	}
	if ($("#u_username").val().trim() == "") {
		return "Insert Username.";
	}
	if ($("#u_password").val().trim() == "") {
		return "Insert Password.";
	}
	if ($("#u_type").val().trim() == "") {
		return "Insert Type.";
	}
	if ($("#u_contact").val().trim() == "") {
		return "Insert Contact.";
	}
	var tmpContact = $("#u_contact").val().trim();
	if (!$.isNumeric(tmpContact)) {
		return "Insert a numerical value for Age.";
	}

	return true;
}


