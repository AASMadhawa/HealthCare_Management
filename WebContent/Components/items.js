$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertSuccess").hide();

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
			$("#u_id").val($(this).closest("tr").find('td:eq(0)').text());
			$("#u_fname").val($(this).closest("tr").find('td:eq(1)').text());
			$("#u_lname").val($(this).closest("tr").find('td:eq(2)').text());
			$("#u_age").val($(this).closest("tr").find('td:eq(3)').text());
			$("#u_address").val($(this).closest("tr").find('td:eq(4)').text());
			$("#u_sex").val($(this).closest("tr").find('td:eq(5)').text());
			$("#u_email").val($(this).closest("tr").find('td:eq(6)').text());
			$("#u_username").val($(this).closest("tr").find('td:eq(7)').text());
			$("#u_password").val($(this).closest("tr").find('td:eq(8)').text());
			$("#u_type").val($(this).closest("tr").find('td:eq(9)').text());
			$("#u_contact").val($(this).closest("tr").find('td:eq(10)').text());
			
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
	// CODE
	if ($("#itemCode").val().trim() == "") {
		return "Insert Item Code.";
	}
	// NAME
	if ($("#itemName").val().trim() == "") {
		return "Insert Item Name.";
	}

	// PRICE-------------------------------
	if ($("#itemPrice").val().trim() == "") {
		return "Insert Item Price.";
	}
	// is numerical value
	var tmpPrice = $("#itemPrice").val().trim();
	if (!$.isNumeric(tmpPrice)) {
		return "Insert a numerical value for Item Price.";
	}
	// convert to decimal price
	$("#itemPrice").val(parseFloat(tmpPrice).toFixed(2));
	// DESCRIPTION------------------------
	if ($("#itemDesc").val().trim() == "") {
		return "Insert Item Description.";
	}
	return true;
}


