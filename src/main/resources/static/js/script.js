// When page IS loaded
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();


    $(button).click(function (e) {
       e.preventDefault();
    });

    });
// Contact form validation

$("#sendbtn").click(function(e){
    e.preventDefault();

    var fn = $("#firstname").val();
    var ln = $("#lastname").val();
    var ph = $("#phonenumber").val();
    var email = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})*$/;
    var exp = /^[a-zA-Z]*$/;
    var num = /^[0-9]*$/;
        

    if(exp.test( $("#firstname").val() ) && num.test( $("#phonenumber").val() ) && ph.length == 11 && (email.test( $("#email").val() ))){
        $("#formerror").html(" ");
        $(".form_alertmsg").html("Message Sent");
        $("#alert").show()
        .hide("fade",2000);  
    }else{
        $("#formerror").html("Name can't contain a Number"+'<br>'+ "Phone number must be atleast 11 digits");
    }




    if (email.test( $("#email").val() )) {
        $("#emailerror").html(" ");
    } else if ( !($("#email").val() ) )
    
    {
            $("#emallerror").html(" Email Required");
    }

     else{$("#emailerror").html("Invalid Email");}

    });

    // ON key Up
    $("#firstname, #lastname, #phonenumber").on('keyup blur paste', function(){

        var fn = $("#firstname").val();
        var ln = $("#lastname").val();
        var exp = /^[a-zA-Z]*$/;
        var num = /^[0-9]*$/;


        if(exp.test( $("#firstname").val() )){
            $("#fnerror").html(" ");
        }else{
            $("#fnerror").html("Name can't contain a Number");
        }

        if (exp.test( $("#lastname").val() )) {
        $("#lnerror").html(" ");
        } else {
            $("#lnerror").html("Name can't contain a number");
        }

        if (num.test( $("#phonenumber").val() )) {
            $("#pnerror").html(" ");
        } else {
            $("#pnerror").html("Invalid Phonenumber");
        }
    
    })
// form validation ends

// Forum validation
$(".forum_num").on('keyup blur paste', function() {
    var num = /^[0-9]*$/;

    if (num.test( $(".forum_num").val() )) {
        $(".forum_error2").html(" ");
        $(".forum_error").html(" ")
    } else {
        $(".forum_error2").html("Number Can't Contain letter");
    }
})


$(".forum_btn").click(function(e){
    e.preventDefault();
    var num = /^[0-9]*$/;

    if(num.test( $(".forum_num").val() )) {

        $(".forum_error").html(" ");
        $(".alertmsg").html("Number added");
        $(".alert").show()
        .hide("fade",2000);

    } else {
        $(".forum_error2").html(" ");
        $(".forum_error").html(" Invalid Phone Number");
        
    }

})

// forum validation ends

//newsletter validation
$(".newsletter_btn").click(function(e){
    e.preventDefault();
    var email = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})*$/;

    if (email.test( $(".newsletter_email").val() )) {
        $(".newsletter_error").html(" ");
        $(".alertmsg").html("subscriptions successful");
        $(".alert").show()
        .hide("fade",2000);

    } else { 
        $(".newsletter_error").html("Invalid Email");
    }
})

// Newsletter validation ends



// Dashboard form

$("#post_submit").click(function(e){
        e.preventDefault();
});
// Ads SLIDERS
var myIndex = 0;
			slide();

			function slide() {
				var i;
				var x= document.getElementsByClassName("mySlides");
				for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";  
			}
			myIndex++;
			if (myIndex > x.length) {myIndex = 1}    
			x[myIndex-1].style.display = "block";  
		setTimeout(slide, 4000); // Change image every 4 seconds
	};




