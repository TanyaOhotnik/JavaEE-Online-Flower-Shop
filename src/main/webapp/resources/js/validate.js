(function () {
    $('#registration\\:goRegister').attr('disabled', 'disabled');
    $('#registration :input').keyup(function () {

        var empty = false;
        $('#registration :input').each(function () {
            if ($(this).val() == '') {
                empty = true;
            }
        });

        if (empty) {
            $('#registration\\:goRegister').attr('disabled', 'disabled');
        } else {
            $('#registration\\:goRegister').removeAttr('disabled');
        }
    });


    function isNumeric(n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }

    $("#registration\\:name :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#registration\\:name .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#registration\\:name .result-validate").html("");
        }
    });


    $("#registration\\:surname :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#registration\\:surname .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#registration\\:surname .result-validate").html("");
        }
    });


    $("#registration\\:email :input").focusout(function (e) {
        var emailValue = e.currentTarget.value;
        if (emailValue == "") {
            $("#registration\\:email .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#registration\\:email .result-validate").html("");
            if (!emailValue.indexOf("@") || !emailValue.indexOf(".") || emailValue.length < 9) {
                $("#registration\\:email .result-validate").html("Email введен неверно");
            }
            else {
                $("#registration\\:email .result-validate").html("");
            }
        }
    });


    $("#registration\\:phone :input").focusout(function (e) {
        var phoneValue = e.currentTarget.value;
        if (phoneValue == "") {
            $("#registration\\:phone .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#registration\\:phone .result-validate").html("");
            if (phoneValue.length !== 10 || !isNumeric(phoneValue)) {
                $("#registration\\:phone .result-validate").html("Телефон введен неверно");
            }
            else {
                $("#registration\\:phone .result-validate").html("");
            }
        }
    });


    $("#registration\\:pass :input").focusout(function (e) {
        var validPass = false;
        var passValue = e.currentTarget.value;
        if (passValue == "") {
            $("#registration\\:pass .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#registration\\:pass .result-validate").html("");
            if (passValue.length < 6) {
                $("#registration\\:pass .result-validate").html("Пароль не должен быть меньше 6 символов!");
            }
            else {
                $("#registration\\:pass .result-validate").html("");
                $("#registration\\:confirm-pass .result-validate").html("Пароли не совпадают!");
            }
        }


        $("#registration\\:confirm-pass :input").focusout(function (e) {
            var confirmPassValue = e.currentTarget.value;
            if (confirmPassValue == "") {
                $("#registration\\:confirm-pass .result-validate").html("Пароли не совпадают!");
            }
            else {
                $("#registration\\\:confirm-pass .result-validate").html("");
                if (confirmPassValue !== passValue) {
                    $("#registration\\\:confirm-pass .result-validate").html("Пароли не совпадают!");
                }
                else {
                    $("#registration\\\:confirm-pass .result-validate").html("");
                }
            }
        });
    });


})();