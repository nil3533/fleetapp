
$('document').ready(function() {
$('table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
		});			
		$('#editModal').modal();		
	});

$('.table #deleteButton').on('click',function(event) {
	event.preventDefault();
	var href = $(this).attr('href');
	$(' #delRef').attr('href', href);
	$('#deleteModal').modal();		
});	
});
