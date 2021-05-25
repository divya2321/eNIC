<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>View locations</title>

    <style type="text/css">
      /* Set the size of the div element that contains the map */
      #map {
        height: 450px;
        /* The height is 400 pixels */
        width: 100%;
        /* The width is the width of the web page */
      }
    </style>
    <script>
 
    var details = [];
    
    function initMap() {
    	  const map = new google.maps.Map(document.getElementById("map"), {
    	    zoom: 7,
    	    center: { lat: 7.461445668435074, lng: 80.74757535230303},
    	  });
    	  setMarkers(map);
    	}
    	// Data for the markers consisting of a name, a LatLng and a zIndex for the
    	// order in which these markers should display on top of each other.
    	

    	function setMarkers(map) {
    	  // Adds markers to the map.
    	  // Marker sizes are expressed as a Size of X,Y where the origin of the image
    	  // (0,0) is located in the top left of the image.
    	  // Origins, anchor positions and coordinates of the marker increase in the X
    	  // direction to the right and in the Y direction down.
    	  const image = {
    	    url: "https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png",
    	    // This marker is 20 pixels wide by 32 pixels high.
    	    size: new google.maps.Size(20, 32),
    	    // The origin for this image is (0, 0).
    	    origin: new google.maps.Point(0, 0),
    	    // The anchor for this image is the base of the flagpole at (0, 32).
    	    anchor: new google.maps.Point(0, 32),
    	  };
    	  
    	  
    	  // Shapes define the clickable region of the icon. The type defines an HTML
    	  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
    	  // The final coordinate closes the poly by connecting to the first coordinate.
    	  const shape = {
    	    coords: [1, 1, 1, 20, 18, 20, 18, 1],
    	    type: "poly",
    	  };

    	  for (let i = 0; i < details.length; i++) {
    	    const data = details[i];
    	    new google.maps.Marker({
    	      position: { lat: data[1], lng: data[2] },
    	      map,
    	      shape: shape,
    	      title: data[0],
    	      zIndex: data[3],
    	    });
    	  }
    	}
    	
    	
    	
    	   function searchNIC(){
    	    	 
    	    	var nicno =  document.getElementById("nic").value; 
    	    	var u = "/org/location/find?nic="+nicno;
    	    	
    	    	  var xhttp = new XMLHttpRequest();
    	    	  xhttp.onreadystatechange = function() {
    	    	    if (this.readyState == 4 && this.status == 200) {
    	    	    	var d = this.responseText;
    	    	     	    	    	
    	    	    	details = eval(d);
    	    	    	initMap();
    	    	    }
    	    	  };
    	    	  xhttp.open("GET", u, true);
    	    	  xhttp.send(); 
    	    	
    	    }

    </script>
  </head>
  <body>
  		<div class="d-flex justify-content-center">
  			<div class="form-group">
						<label for="nic" >NIC number:</label> <br> 
						<input type="text" class="form-control" name="nic" id="nic" >
					</div>
		</div>	
		<div class="d-flex justify-content-center">	
			<button type="button" onclick="searchNIC();" class="btn btn-primary">&nbsp;Find Person&nbsp;</button>
		</div>
				
		<br/>	
				
    <!--The div element for the map -->
    <div id="map"></div>

    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBite5zSDArRH1Bg-UL8DQ5T5saaYZKB4Y&callback=initMap&libraries=&v=weekly"
      async
    ></script>
  </body>
</html>
