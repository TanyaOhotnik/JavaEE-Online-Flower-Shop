(function () {
	function isNumeric(n) {
	  		return !isNaN(parseFloat(n)) && isFinite(n);
	  	}

	$("#name :input").focusout(function(e){
		if(e.currentTarget.value == "") {
			$("#name .result-validate").html("Заполните этот пункт!");
		}
		else {
			$("#name .result-validate").html("");
		}
	});




	$("#surname :input").focusout(function(e){
		if(e.currentTarget.value == "") {
			$("#surname .result-validate").html("Заполните этот пункт!");
		}
		else {
			$("#surname .result-validate").html("");
		}
	});




	$("#email :input").focusout(function(e){
		var emailValue = e.currentTarget.value;
		if(emailValue == "") {
			$("#email .result-validate").html("Заполните этот пункт!");
		}
		else {
			$("#email .result-validate").html("");
				if( !emailValue.indexOf("@") || !emailValue.indexOf(".") || emailValue.length < 9 ) {
					$("#email .result-validate").html("Email введен неверно");
				}
				else {
					$("#email .result-validate").html("");
				}
		}	
	});


		

	$("#phone :input").focusout(function(e){
		var phoneValue = e.currentTarget.value;
		if(phoneValue == "") {
			$("#phone .result-validate").html("Заполните этот пункт!");
		}
		else {
			$("#phone .result-validate").html("");
			if ( phoneValue.length !== 10 || !isNumeric(phoneValue) ) {
				$("#phone .result-validate").html("Телефон введен неверно");
			}
			else {
					$("#phone .result-validate").html("");
				}
		}
	});





	$("#pass :input").focusout(function(e){
		var validPass = false;
		var passValue = e.currentTarget.value;
		if(passValue == "") {
			$("#pass .result-validate").html("Заполните этот пункт!");
		}
		else {
			$("#pass .result-validate").html("");
			if( passValue.length < 6 ) {
				$("#pass .result-validate").html("Пароль не должен быть меньше 6 символов!");
			}
			else {
				$("#pass .result-validate").html("");
				$("#confirm-pass .result-validate").html("Пароли не совпадают!");
			}
		}
	




		$("#confirm-pass :input").focusout(function(e){
			var confirmPassValue = e.currentTarget.value;
			if( confirmPassValue == "") {
				$("#confirm-pass .result-validate").html("Пароли не совпадают!");
			}
			else {
				$("#confirm-pass .result-validate").html("");
				if ( confirmPassValue !== passValue ) {
					$("#confirm-pass .result-validate").html("Пароли не совпадают!");
				}
				else {
					$("#confirm-pass .result-validate").html("");
				}
			}
		});
	});




})();