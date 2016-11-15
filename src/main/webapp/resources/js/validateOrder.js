(function () {
    $('#addInfo\\:makeOrder').attr('disabled', 'disabled');
    $('#addInfo :input').keyup(function () {

        var empty = false;
        $('#addInfo :input').each(function () {
            if ($(this).val() == '') {
                empty = true;
            }
        });

        if (empty) {
            $('#addInfo\\:makeOrder').attr('disabled', 'disabled');
        } else {
            $('#addInfo\\:makeOrder').removeAttr('disabled');
        }
    });
    

    $("#addInfo\\:date :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#addInfo\\:date .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addInfo\\:date .result-validate").html("");
        }
    });


    $("#addInfo\\:address :input").focusout(function (e) {
        if (e.currentTarget.value == "") {
            $("#addInfo\\:address .result-validate").html("Заполните этот пункт!");
        }
        else {
            $("#addInfo\\:address .result-validate").html("");
        }
    });




})();