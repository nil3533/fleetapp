$('document').ready(function() {
	$('table #editButton').on("click", function() {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(country, status) {
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#codeEdit').val(country.code);
			$('#nationalityEdit').val(country.nationality);
			$('#continentEdit').val(country.continent);
			$('#capitalEdit').val(country.capital);
		});
		
		$('#editCountryModal').modal();
	});
	
	$('table #deleteButton').on("click", function() {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();
		
	});
});
