<?php
	require("connection.php");

	$selectedproduct = $_GET['selectedproduct'];
		
	$res = $conn->query("SELECT * FROM Products WHERE productid='$selectedproduct'");
	$row = $res->fetch(PDO::FETCH_ASSOC);

	$res2 = $conn->query("SELECT * FROM ShippingInformation WHERE id=0");
	$row2 = $res2->fetch(PDO::FETCH_ASSOC);

	$productid = $row['productid'];
	$productname = $row['productname'];
	$manufacturer = $row['manufacturer'];
	$price = $row['price'];
	$descriptor1 = $row['descriptor1'];
	$descriptor2 = $row['descriptor2'];
	$descriptor3 = $row['descriptor3'];
	$descriptor4 = $row['descriptor4'];

	$sixdaysgroundprice = $row2['6daysgroundprice'];
	$twodaysexpeditedprice = $row2['2daysexpeditedprice'];
	$overnightprice = $row2['overnightprice'];
?>

<html>

	<head>
		<title>Willy's Wares</title>

		<script>
		function validatePurchase()
		{
			var product = document.PurchaseForm.product
			var quantity = document.PurchaseForm.quantity
			var shippingmethod = document.PurchaseForm.shippingmethod
			var firstname = document.PurchaseForm.fname
			var lastname = document.PurchaseForm.lname
			var phonenumber = document.PurchaseForm.phonenumber
			var street = document.PurchaseForm.street
			var city = document.PurchaseForm.city
			var state = document.PurchaseForm.state
			var country = document.PurchaseForm.country
			var zip = document.PurchaseForm.zip
			var cardnumber = document.PurchaseForm.cardnumber
			var expdate = document.PurchaseForm.expdate
			var csv = document.PurchaseForm.csv

			if (firstname.value == "")                                  
			{ 
				alert("Please enter your first name.");
				return false; 
			} 

			if (lastname.value == "")                               
			{ 
				alert("Please enter your last name.");
				return false; 
			} 

			if (phonenumber.value == "")                                   
			{ 
				alert("Please enter a phone number.");
				return false; 
			}

			if (isNaN(phonenumber.value))
			{
				alert("Please enter a valid phone number.");
				return false;
			}
			
			if (street.value == "")
			{
				alert("Please enter a street name.");
				return false;
			}
			
			if (city.value == "")
			{
				alert("Please enter a city name.");
				return false;
			}
			
			if (state.value == "")
			{
				alert("Please enter a state name.");
				return false;
			}
			
			if (zip.value == "")
			{
				alert("Please enter a zip/postal code.");
				return false;
			}
			
			if (isNaN(zip.value))
			{
				alert("Please enter a valid zip/postal code.");
				return false;
			}
			
			if (cardnumber.value == "")
			{
				alert("Please enter a card number.");
				return false;
			}
			
			if (isNaN(cardnumber.value))
			{
				alert("Please enter a valid card number.");
				return false;
			}
			
			if (expdate.value == "")
			{
				alert("Please enter an expiration date.");
				return false;
			}
			
			if (csv.value == "")
			{
				alert("Please enter a CSV.");
				return false;
			}
			
			if (isNaN(csv.value))
			{
				alert("Please enter a valid CSV number.");
				return false;
			}
			
			<?php
			$conn = null;
			?>
			
			return true;
		}
		
		
		function getPlaceInfo(zip) {
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = xhttp.responseText;
					var placeInfo = result.split(',');
					
					document.getElementById('state').value = placeInfo[0];
					document.getElementById('city').value = placeInfo[1];
					
					if (placeInfo[2] != "")
						document.getElementById('tax').value = placeInfo[2];
				}
			};
			
			xhttp.open("GET", "getPlaceInfo.php?zip=" + zip, true);
			xhttp.send();
		}
		</script>
	</head>
	
	<body>
	
		<div style="background-color:red">
			<center>
				<h1 style="font-size:350%; color:lightgreen">Willy's Wares</h1>
				<p1 style="font-size:160%; color:yellow">For all your console gaming needs!</p1>
			</center>
		</div>
		
		<hr>
		
		<div style="background-color:lightblue">
		
			<center>
				<h1 style="font-size:225%"> <?php echo $productname ?> </h1>
			</center>
			
			<center>
			<table cellpadding="15">
				<tr>
					<div>
					<td>
					<img onmouseover="this.width='600'; this.height='440'" onmouseout="this.width='300'; this.height='220'" src=<?php echo $row['imagelink1'] ?> width="300" height="220">
					</td>
					<td>
					<img onmouseover="this.width='600'; this.height='440'" onmouseout="this.width='300'; this.height='220'" src=<?php echo $row['imagelink2'] ?> width="300" height="220">
					</td>
					<td>
					<img onmouseover="this.width='600'; this.height='440'" onmouseout="this.width='300'; this.height='220'" src=<?php echo $row['imagelink3'] ?> width="300" height="220">
					</td>
					<td>
					<img onmouseover="this.width='600'; this.height='440'" onmouseout="this.width='300'; this.height='220'" src=<?php echo $row['imagelink4'] ?> width="300" height="220">
					</td>
					</div>
				</tr>
			</table>
			</center>
			
			<h1>About the Product</h1>
			<p1>
				$<?php echo $price ?>
				<br>
				Manufactured by <?php echo $manufacturer ?>
				<br><br>
				- <?php echo $descriptor1 ?>
				<br>
				- <?php echo $descriptor2 ?>
				<br>
				- <?php echo $descriptor3 ?>
				<br>
				- <?php echo $descriptor4 ?>
			</p1>

			<br><br>

			<h1>Buy it!</h1>

			<form name="PurchaseForm" onsubmit="return validatePurchase()" method="post" action="confirmation.php">
				<table>
					<tr>
						<td>
						Product:<br>
						<input type="text" name="product" value=<?php echo $productid ?> readonly>
						</td>
						<td>
						Quantity:<br>
						<select name="quantity">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
						</td>
						<td>
						Shipping Method:<br>
						<select name="shippingmethod">
						<option value=<?php echo $sixdaysgroundprice ?> selected="selected">6-days ground ($<?php echo $sixdaysgroundprice ?>)</option>
						<option value=<?php echo $twodaysexpeditedprice ?>>2-days expedited ($<?php echo $twodaysexpeditedprice ?>)</option>
						<option value=<?php echo $overnightprice ?>>Overnight ($<?php echo $overnightprice ?>)</option>
						</td>
					</tr>
                    <tr>
						<td>
						First name:<br>
						<input type="text" name="firstname" required>
						</td>
						<td>
						Last name:<br>
						<input type="text" name="lastname" required>
						</td>
						<td>
						Phone number: <i>ex) 1234567890</i><br>
						<input type="text" name="phonenumber" required>
						</td>
                    </tr>
					<tr>
						<td>
						Street:<br>
						<input type="text" name="street" required>
						</td>
						<td>
						City:<br>
						<input type="text" name="city" id="city" required>
						</td>
						<td>
						State:<br>
						<input type="text" name="state" id="state" required>
						</td>
						<td>
						Country:<br>
						<input type="text" name="country" value="United States of America" readonly required>
						</td>
						<td>
						Zip code:<br>
						<input type="text" name="zip" onblur="getPlaceInfo(this.value)" required>
						</td>
					</tr>
					<tr>
						<td>
						Card number:<br>
						<input type="text" name="cardnumber" required>
						</td>
						<td>
						Exp. date: <i>ex) MM-YY</i><br>
						<input type="text" name="expdate" required>
						</td>
						<td>
						CSV:<br>
						<input type="text" name="csv" required>
						</td>
						<td>
						</td>
						<td>
						Tax Rate:<br>
						<input type="text" name="tax" id="tax" value="0" readonly>
					</tr>
				</table>
				<br>
				<input type="submit" name="submit" value="Submit" onClick="return confirm('Are you sure you want to make this purchase?')"/a>
			</form>
			
			<hr>
				
			<h1>About Us</h1>
			<p1>
				Here, at Willy's Wares, we're dedicated to bringing you pristine condition gaming consoles in a quick and efficient manner.  Every employee is dedicated in handling your 
				gaming consoles with finesse and care to make sure you get the excellent service that you deserve.  We're a new company based in Irvine, CA that specializes in dealing with gaming
				consoles and each of our employees are gamers themselves that understand the importance of delicacy in handling gaming consoles.  We hope you have a pleasant experience buying 
				from us!
			</p1>
			
			<h1>The Team</h1>
			<p1>Owner: Willy Saronamihardja</p1>
			<br>
			<p1>Managers: John Smith, Susan Sue, Lilly Ko</p1>
			<br>
			<p1>Staff: Ryan Bo, Jessie Zayn, Laurence Tran, Abigail Turner, Jason Bourne, Bobby Soprano, Roger Murdock, Larry Parker</p1>
			
			<h1>Contact Us</h1>
			<p1>Phone number: (123)456-7890</p1>
			<br>
			<p1>Email: customer-service@willyswares.com</p1>
			<br>
			<p1>Address: 123 Gaming St. Irvine, CA  92612</p1>
			
			<br><br><br>
			<h1>Site Developer</h1>
			<p1>Willy Saronamihardja</p1>
	
		</div>
		
	</body>
	
</html>
