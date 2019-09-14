Willy Saronamihardja - wsaronam - 80408898


URL address: http://centaurus-3.ics.uci.edu:1030/inf124_pa3/

MySQL information
username: root
password: willyswares

***NOTE: Please use the buttons that I've created on the website for "going back" and visiting the Shopping Cart for the website functionalities to work properly.


The website starts off on the main page of the E-commerce site, which is a gaming console sales site.  The user has the option to click on each of the consoles 
to visit the detailed description page to view more details of the product and/or add it to the shopping cart.  After the user finishes adding all the products that they want,
they can click on the Shopping Cart button to fill in their information and make the purchase.

Requirements
1. The mainPage servlet handles the displaying of products from the database and the sessionTracking servlet handles the displaying of the last 5 products the user visited.  sessionTracking updates
   the "main page" through the usage of the "include" feature on the mainPage servlet.
2. Using the product servlet, the "product details" page is populated with the product details from a parameter passed from a button click on the mainPage servlet.  There is also a button on
   this page that allows the User the add the product to their shopping cart, which is in the User's session.
3. The viewCart servlet allows the User to see all the products they have in their cart.  The User has the ability to fill in their personal information and submit it to purchase 
   the products they've added to their cart.  Once the User presses Submit, the confirmation servlet is called to check if the information input is valid.  If it isn't the page won't proceed. 
   If it is, the page will proceed to the confirmation servlet through the forward feature.  The purchase information is stored onto the database and the User is shown a order summary page.  
   From there, the User can go back to the Main Page and the session is reset.