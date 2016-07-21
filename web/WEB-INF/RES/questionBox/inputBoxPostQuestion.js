/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var htmlshow = "";
var outputshow = "";
var inputcount = 1;

var inputs = [];
var outputs = [];
var inputsvalue = [];
var inputheight = [];

$(document).ready(function () {

    $('#inputdesc0').focusin(function () {
        $('#bottomp').removeClass('bottompost');
        $('#bottomp').addClass('showbottom');
    });

    $('#description').click(function () {
        getDisplay();
        htmlshow += '<textarea id="inputdesc' + inputcount + '" class="form-control desc" onkeyup="auto_grow(this)"></textarea><br/>';
        outputshow += '<div class="question-desc"></div><br/>';
        setDisplay('inputdesc' + inputcount);
    });

    $('#code').click(function () {
        getDisplay();
        htmlshow += '<textarea id="inputcode' + inputcount + '" class="form-control code-desc" onkeyup="auto_grow(this)"></textarea><br/>';
        outputshow += '<div class="question-code"><pre></pre></div>';
        setDisplay('inputcode' + inputcount);
    });

    $('#high').click(function () {
        getDisplay();
        htmlshow += '<textarea id="inputhigh' + inputcount + '" class="form-control code-high" onkeyup="auto_grow(this)"></textarea><br/>';
        outputshow += '<div class="question-high"></div>';
        setDisplay('inputhigh' + inputcount);
    });

//That method represents 
    $('#donebtn').click(function () {

        var questionname = $('#questionname').val();
        if (questionname === "") {
            alert("Required Question head !");
        } else {
            inputs[0] = "inputdesc0";
            inputsvalue[0] = $('#inputdesc0').val();
            var xmlfiletext = "\n";
            for (var j = 0; j < inputcount; j++) {
                var inputx = inputs[j];
                var inputtype = inputx.substring(0, inputx.length - 1);
                var lines = $('#' + inputx).val().split('\n');
                if (lines === "") {
                    alert('Empty');
                } else {
                    if (inputtype === "inputdesc") {
                        xmlfiletext += "\n<div class='question-desc'>\n";
                        for (var i = 0; i < lines.length; i++) {
                            xmlfiletext += lines[i] + "<br/>";
                        }
                        xmlfiletext += "\n</div>\n";
                    } else if (inputtype === "inputcode") {
                        xmlfiletext += "\n<div class='question-code'>\n<pre>\n";
                        for (var i = 0; i < lines.length; i++) {
                            xmlfiletext += lines[i] + "<br/>";
                        }
                        xmlfiletext += "\n</pre>\n</div>\n";
                    } else if (inputtype === "inputhigh") {
                        xmlfiletext += "\n<div class='question-high'>\n";
                        for (var i = 0; i < lines.length; i++) {
                            xmlfiletext += lines[i] + "<br/>";
                        }
                        xmlfiletext += "\n</div>\n";
                    }
                }
            }
            xmlfiletext += "\n";
            var qhead = $("#questionname").val();
            var cat = $("#category-select").val();

            var jsonobject =
                    "head=" + qhead +
                    "&category=" + cat +
                    "&body=" + xmlfiletext;

            $.ajax({
                type: "POST",
                url: "saveQuestion?" + jsonobject,
                contentType: "text",
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(errorThrown);
                }
            }).done(function (data, status) {
                $('#res').html(data);
            });
        }
    });

});

function getDisplay() {
    for (var i = 0; i < inputcount; i++) {
        var inp = "#" + inputs[i];
        inputsvalue[i] = $(inp).val();
        inputheight[i] = $(inp).height();
    }
}

function setDisplay(textst) {
    inputs[inputcount] = textst;
    inputcount++;
    $('#display').html(htmlshow);

    for (var i = 0; i < inputcount; i++) {
        var inp = "#" + inputs[i];
        $(inp).val(inputsvalue[i]);
        $(inp).height(inputheight[i]);
    }
}

function auto_grow(element) {
    element.style.height = "5px";
    element.style.height = (element.scrollHeight) + "px";
}

//Answer Box Side Down
$(function () {
//    $('#answer-box').hide();

    $('#inside-menu-new')
            .on('click', function () {
                $('#answer-box').slideDown();
            });
});