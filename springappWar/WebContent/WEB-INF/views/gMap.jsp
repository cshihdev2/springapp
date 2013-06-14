<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>GMaps Distance Calculator</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
}

#map-canvas {
	height: 70%;
	width: 85%;
	margin: 10px;
	border: solid 2px;
}

#text-canvas {
	height: 15%;
	font-size: 2em;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzn9kMjiYw-QhN8e4qL_hLuaaGB5pEVDU&libraries=geometry&sensor=false"></script>
<script>
	var map;
	var mark1;
	var mark2;
	var lastmarked;

	var EarthRadiusInYards = 6378137 * 1.09361

	function initialize() {
		var mapOptions = {
			zoom : 20,
			center : new google.maps.LatLng(40.001324, -75.311999),
			//center : new google.maps.LatLng(40.001, 75.312),
			mapTypeId : google.maps.MapTypeId.SATELLITE
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		google.maps.event.addListener(map, 'click', function(event) {
			placeMarker(event.latLng);
		});

	}

	function placeMarker(position) {

		var marker = new google.maps.Marker({
			position : position,
			map : map,
			draggable : false,
			shape : {
				type : 'circle'
			}

		});

		if (mark1 == null) {
			mark1 = marker;
			lastmarked = 1;
		} else if (mark2 == null) {
			mark2 = marker;
			lastmarked = 2;
		} else {
			if (lastmarked == 1) {
				marktoremove = mark2;
				mark2 = marker;
				lastmarked = 2;
			} else {
				marktoremove = mark1;
				mark1 = marker;
				lastmarked = 1;
			}
		}

		displayDistance();

		if (marktoremove != null) {
			marktoremove.setMap(null);
			marktoremove = null;
		}

	}

	function displayDistance() {
		distanceInYards = google.maps.geometry.spherical
				.computeDistanceBetween(mark1.getPosition(), mark2
						.getPosition(), EarthRadiusInYards);
		displayText = Math.round(distanceInYards) + ' yards';
		document.getElementById("text-canvas").innerHTML = displayText;
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div>This app will calculate the distance in yards between two marks on the map</div>
	<div id="map-canvas"></div>
	<div id="text-canvas"></div>
</body>
</html>

