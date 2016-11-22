(function () {
    $('#addForm\\:addItem').attr('disabled', 'disabled');
    $('#addForm :input').keyup(function () {

        var empty = false;
        $('#addForm :input').each(function () {
            if ($(this).val() == '') {
                empty = true;
            }
        });

        if (empty) {
            $('#addForm\\:addItem').attr('disabled', 'disabled');
        } else {
            $('#addForm\\:addItem').removeAttr('disabled');
        }
    });
    

    $("#addForm\\:photo :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#addForm\\:photo .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addForm\\:photo .result-validate").html("");
        }
    });


    $("#addForm\\:vendorCode :input").focusout(function (e) {
        var code = e.currentTarget.value;
        if (code == "") {
            $("#addForm\\:vendorCode .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addForm\\:vendorCode .result-validate").html("");
            if (code.length !== 5 || !isNumeric(code)) {
                $("#addForm\\:vendorCode .result-validate").html("Артикул введен неверно");
            }
            else {
                $("#addForm\\:vendorCode .result-validate").html("");
            }
        }
    });

    $("#addForm\\:price :input").focusout(function (e) {
        var pr = e.currentTarget.value;
        if (pr == "") {
            $("#addForm\\:price .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addForm\\:price .result-validate").html("");
            if (!isNumeric(pr)) {
                $("#addForm\\:price .result-validate").html("Цена введена неверно");
            }
            else {
                $("#addForm\\:price .result-validate").html("");
            }
        }
    });

    $("#addForm\\:name :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#addForm\\:name .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addForm\\:name .result-validate").html("");
        }
    });
    $("#addForm\\:description :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#addForm\\:description .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addForm\\:description .result-validate").html("");
        }
    });




})();