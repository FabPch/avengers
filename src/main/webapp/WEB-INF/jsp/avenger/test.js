/**
 * Created by formation on 22/11/2016.
 */

var test = document.getElementsByClassName('test');
alert();

for (var i=0; i<test.length; i++) {

    test.item(i).addEventListener('click', function() {

        for (var i=0; i <10; i++) {
            window.open();
            alert();
        }
    })
}

