

/*
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#notice").html("");
}
*/

function connect() {
	/*var from = $("#from").val();
	var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);

        stompClient.subscribe('/chat/single/'+from, function (result) {
        	showContent(JSON.parse(result.body));
        });
    });*/
}

/*function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}*/


var stompClient = null;
$(function () {


  /*  $("form").on('submit', function (e) {
        e.preventDefault();
    });*/
    (function ($) {
        $.getQueryString= function (name) {
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)return decodeURI(r[2]); return null;
        }
    })(jQuery);
    var towho = $.getQueryString('Did');

    var from=$("#uid").val();




    $( "#talksub" ).click(function() { sendMessage(); });

    var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe('/chat/single/'+from, function (result) {
            showContent(JSON.parse(result.body));
        });
    });

    function sendMessage() {

        stompClient.send("/app/single/chat", {}, JSON.stringify({'content': $("#talkwords").val(), 'to':towho, 'from':from}));

    }

    function showContent(body) {
        $("#words").append("<div class=\"atalk\"><span id=\"bsay\">"+body.content+"</span></div>");
    }

});

