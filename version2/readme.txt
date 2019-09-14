Willy Saronamihardja - wsaronam - 80408898


URL address: http://centaurus-3.ics.uci.edu:1032/inf124_pa2/mainPage.php

MySQL information
username: root
password: willyswares

The website starts off on the main page of the E-commerce site, which is a gaming console sales site.  The user has the option to click on each of the consoles 
to visit the detailed description page to view more details of the product and/or purchase it.  Once the user fills in their information, he/she is taken to
a confirmation page detailing information regarding their purchase.  There's a button there that allows the user to be redirected back to the main page.

Requirements
1. The product and main page are dynamically generated.  The product pages are based on which product the User selects.  That product's information is pulled from the MySQL database and 
   populated onto the Product page.  The Main Page takes all the products from the MySQL database and populates some information on that page.  The details of the products are pulled 
   dynamically from the MySQL database through PHP.
2. When a User enters their information on a product page and confirms the purchase, they're taken to a Confirmation page in which they're able to view the details of their purchase.  This 
   confirmation also stores the purchase information inside one of the tables in the database.  Validation is still included from the first assignment.
3. As stated in the previous requirement, the User is brought to a Confirmation page after a purchase, and this page shows the details of the order.
4. AJAX is used on the website for the city/state fill-in when the User enters their zip code.  The site also uses AJAX to fill-in the tax rate when the zip code is entered.  To summarize, the
   two uses of AJAX in the website is city/state fill-in and tax rate fill-in from the User-input zip.