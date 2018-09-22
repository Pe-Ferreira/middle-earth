$(document).ready(function() {
	$('body').on('click', '.btn-goblin-command', function() {
		var command = $(".goblin-command").val();
		$.ajax({
			type : "POST",
			url : '/dashboard/admin/send-command',
			data : {
				'raceKey': 'G',
				'command' : command
			},
			success : function(retorno) {
				$(".globin-alert-success").text(retorno);
				$(".globin-alert-success").attr("hidden", false);
				setTimeout(function(){
					$(".globin-alert-success").attr("hidden", true);
					$(".btn-goblin-command").attr("active", false)
					$(".goblin-command").val("");
				}, 3000);
			}
		});
	});
	$('body').on('click', '.btn-urukhai-command', function() {
		var command = $(".urukhai-command").val();
		$.ajax({
			type : "POST",
			url : '/dashboard/admin/send-command',
			data : {
				'raceKey': 'U',
				'command' : command
			},
			success : function(retorno) {
				$(".urukhai-alert-success").text(retorno);
				$(".urukhai-alert-success").attr("hidden", false);
				setTimeout(function(){
					$(".urukhai-alert-success").attr("hidden", true);
					$(".btn-urukhai-command").attr("active", false)
					$(".urukhai-command").val("");
				}, 3000);
			}
		});
	});
	$('body').on('click', '.btn-snaga-command', function() {
		var command = $(".snaga-command").val();
		$.ajax({
			type : "POST",
			url : '/dashboard/admin/send-command',
			data : {
				'raceKey': 'S',
				'command' : command
			},
			success : function(retorno) {
				$(".snaga-alert-success").text(retorno);
				$(".snaga-alert-success").attr("hidden", false);
				setTimeout(function(){
					$(".snaga-alert-success").attr("hidden", true);
					$(".btn-snaga-command").attr("active", false)
					$(".snaga-command").val("");
				}, 3000);
			}
		});
	});
	$('body').on('click', '.turn-off', function() {
		var orcId = $(this).data('id');
		console.log(orcId);
		$.ajax({
			type : "POST",
			url : '/dashboard/admin/remove-orc',
			data : {
				'orcId': orcId
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