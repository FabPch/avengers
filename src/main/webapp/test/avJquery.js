/**
 * Created by formation on 30/11/2016.
 */
$(function() {

    // var offset = $("#box").offset();
    // var action = false;
    // var posLeft;
    // var posTop;
    //
    // $("#formav").submit( function(e) {
    //     alert('envoyé!');
    //     e.preventDefault();
    // });
    //
    // $("body").mousemove(function() {
    //
    //     if (action) {
    //         offset.left = e.clientX;
    //         offset.top = e.clientY;
    //     }
    // })
    //
    // $("#box").mouseup(function(e) {
    //
    // })
    //
    // $("#box").click(function() {
    //     action = true;
    //     $("body").mousedown(function() {
    //         action = false;
    //     })
    //     bouger();
    //     console.log(offset);
    //
    //     // $(this).offset(offset);
    // })
    //
    // var bouger = function() {
    //
    //     if (action) {
    //         $("#box").mouseover(function (e) {
    //
    //             offset.left = e.clientX;
    //             offset.top = e.clientY;
    //             $(this).offset(offset);
    //         })
    //     };
    // };
    //
    // $("#box").mouseup(function(e) {
    //     action = false;
    // });

    //AJAX

    var demandeGet = function() {

        var url = 'http://172.28.11.18:8080/avengers/app/rest/avengers/';
        $.get(url).done(function (data) {
        })
    }

    //Animation
    $("#hide").click(function() {
        $("#box").hide('fast', function() {
            console.log('disparu');
        });
    });
    $("#show").click(function() {
        $("#box").show('slow', function() {
            console.log('affiché');
        });
    });
    $("#toggle").click(function() {
        $("#box").toggle(3000);
    });
    $("#FadeIn").click(function() {
        $("#box").fadeIn(2000);
    });

    //Menus
    $("li").click(function () {
        $("li>ul").hide();
        $("ul", this).toggle('slow');
    })

    //Caroussel




});