<?php
require("connection.php");

$product = $_POST['product'];
$quantity = $_POST['quantity'];
$shippingmethod = $_POST['shippingmethod'];
$firstname = $_POST['firstname'];
$lastname = $_POST['lastname'];
$phonenumber = $_POST['phonenumber'];
$street = $_POST['street'];
$city = $_POST['city'];
$state = $_POST['state'];
$country = $_POST['country'];
$zip = $_POST['zip'];
$taxrate = $_POST['tax'];
$cardnumber = $_POST['cardnumber'];
$expdate = $_POST['expdate'];
$csv = $_POST['csv'];

$stmt = $conn->prepare("INSERT INTO Purchases(productid, amountpurchased, shippingmethod, firstname, lastname, phonenumber, street, city, state, country, zip, taxrate, cardnumber, expdate, csv) VALUES (:productid, :amountpurchased, :shippingmethod, :firstname, :lastname, :phonenumber, :street, :city, :state, :country, :zip, :taxrate, :cardnumber, :expdate, :csv)");
						
$stmt->bindParam(':productid', $product);
$stmt->bindParam(':amountpurchased', $quantity);
$stmt->bindParam(':shippingmethod', $shippingmethod);
$stmt->bindParam(':firstname', $firstname);
$stmt->bindParam(':lastname', $lastname);
$stmt->bindParam(':phonenumber', $phonenumber);
$stmt->bindParam(':street', $street);
$stmt->bindParam(':city', $city);
$stmt->bindParam(':state', $state);
$stmt->bindParam(':country', $country);
$stmt->bindParam(':zip', $zip);
$stmt->bindParam(':taxrate', $taxrate);
$stmt->bindParam(':cardnumber', $cardnumber);
$stmt->bindParam(':expdate', $expdate);
$stmt->bindParam(':csv', $csv);
$stmt->execute();

$res3 = $conn->query("SELECT * FROM Products WHERE productid='$product'");
$row3 = $res3->fetch(PDO::FETCH_ASSOC);

$conn = null;
?>

<html>
	<head>
		<title>Willy's Wares</title>
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
				<h1 style="font-size:225%">Purchase Confirmed!</h1>
			</center>
			
			Thank you for shopping with Willy's Wares!  We'll get you your stuff safe and sound; hang tight!<br>
			Below is the purchase confirmation for your order.  We hope to see you again!<br>
			If you have any questions/issues/problems with your order, feel free to contact us with the information given at the "Contact Us" section located at the bottom of our pages!<br><br><br>
			
			<?php echo $quantity."x  ".$row3['productname'] ?><br><br>
			Total Before Tax: $<?php echo $row3['price']*$quantity+$shippingmethod ?><br>
			Total After Tax: $<?php echo sprintf('%0.2f', $row3['price']*$quantity+$shippingmethod+(($row3['price']*$quantity+$shippingmethod)*$taxrate)) ?><br><br>
			
			Ship to:<br> 
			<?php echo $firstname." ".$lastname ?><br>
			<?php echo $street." ".$city.", ".$state."    ".$zip ?><br><br><br>
			
			<input type="button" value="Return to Main Page" onClick="document.location.href='mainPage.php'"/>
			
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