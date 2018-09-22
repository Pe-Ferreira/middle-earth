$(document).ready(function() {
	$('body').on('click', '.execute', function() {
		var commandId = $(this).data('id');
		$.ajax({
			type : "POST",
			url : '/dashboard/troops/execute/',
			data : {
				'commandId': commandId
			},
			success : function(retorno) {
				alert(retorno);
				setTimeout(function(){
					location.reload(true);
				}, 2000);
			}
		});
	});
});