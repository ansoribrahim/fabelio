$(document).ready(function(){
	$( ".link_input" ).change(function() {
	  $.ajax({
            url: "get_product_info?url=" + $( ".link_input" ).val(),
            success: function(response){
                    $(".product_name").text(response.productName)
                    $(".product_price").text("Harga : " + response.price)
                    $(".product_description").text(response.description)
                    $(".save_button").removeClass("hidden")

                    for (var i = 0; i < response.images.length; i++) {
                      $(".product_img").append("<img class='image_from_fabelio' src='" + response.images[i].img + "'></img>")
                    }

            },
            error: function(error){
               alert(JSON.parse(error.responseText).message)
               location.reload()
            }
    });
	});

	$( ".save_button" ).click(function() {
  	  $.ajax({
					type: "POST",
          url: "product?url=" + $( ".link_input" ).val(),
          success: function(response){
            alert("sukses menyimpan data")
            location.reload()
          },
          error: function(error){
             alert(JSON.parse(error.responseText).message)
          }
      });
  	});
});