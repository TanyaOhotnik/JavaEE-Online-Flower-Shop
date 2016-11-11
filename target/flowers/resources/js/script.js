$(document).ready(function(){
	$("#sign-click").click(function(){
		$(".sign-up").slideUp(function(){
			$(".reg").slideDown(1000);
		});
	});
});