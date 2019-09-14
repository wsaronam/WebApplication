<?php
	require("connection.php");
?>

<html>

	<head>
		<title>Willy's Wares</title>

		<!--Style written by Eric Du-->
		<style>
			table {
				border-collapse: collapse;
			}
			td {
			width:52.5px;
			text-align:center;
			
			}
			.lefttd {
			border-right:hidden;
			}
    </style>
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
				<h1 style="font-size:225%">Available Consoles</h1>
			</center>
			
			<center>
				<table cellpadding="15" style="border-collapse:separate; border-spacing:0 50px; margin-top:-50px;">
					<tr>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='switch'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=switch" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price'] ?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='3dsxl'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=3dsxl" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price'] ?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='2dsxl'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=2dsxl" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price'] ?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
					</tr>
					<tr>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='ps4pro'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=ps4pro" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price'] ?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='ps4'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=ps4" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price'] ?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='psp'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=psp" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price']?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
					</tr>
					<tr>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='onex'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=onex" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price']?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='ones'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=ones" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price']?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='one'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=one" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price']?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
					</tr>
					<tr>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='rift'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=rift" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price']?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
						<td>
						</td>
						<td>
						<?php
							$res = $conn->query("SELECT * FROM Products WHERE productid='vive'");
							$row = $res->fetch(PDO::FETCH_ASSOC);
						?>
						<a href=<?php echo "product.php?selectedproduct=vive" ?>>
						<center><h2><?php echo $row['productname'] ?></h2></center>
						<img src=<?php echo $row['imagelink1'] ?> width="300" height="220">
						</a>
						<p align="left">$<?php echo $row['price']?></p>
						<p align="left">by <?php echo $row['manufacturer'] ?></h2></center>
						</td>
					</tr>
				</table>
			</center>
			
			<?php
				$conn = null;
			?>
			
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