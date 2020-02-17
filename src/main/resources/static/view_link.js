$(document).ready(function(){
	  $.ajax({
        url: "get_products",
        success: function(response){
               debugger;
        },
        error: function(error){
           alert(JSON.parse(error.responseText).message)
           location.reload()
        }
    });

});