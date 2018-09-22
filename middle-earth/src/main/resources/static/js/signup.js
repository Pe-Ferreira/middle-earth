$(document).ready(function() {
	$('body').on('click', '.create', function() {
		var login = $(".login").val();
		var password = $(".password").val();
		var race = $(".race option:selected").text();
		var region = $(".region option:selected").text();
		$.ajax({
			type : "POST",
			url : '/sign-up/new-user',
			data : {
				'login': login,
				'password' : password,
				'race': race,
				'region': region
			},
			success : function(retorno) {
				$(".created-alert-success").text(retorno);
				$(".created-alert-success").attr("hidden", false);
				setTimeout(function(){
					$(location).attr("href", "/");
					$(".created-alert-success").attr("hidden", true);
				}, 3000);
			}
		});
	});
});