
    function validate() {
    	
         if (document.forms["users"]["name"].value == "") {
        	 
              alert("Please enter name");
              document.getElementById('userMessage').innerHTML = "Please enter name";
              document.forms["users"]["name"].focus();
              
              return false;
         }
         
         if (document.forms["users"]["username"].value == "") {
        	 
              alert("Please enter user name");
              document.getElementById('userMessage').innerHTML = "Please enter user name";
              document.forms["users"]["username"].focus();
              
              return false;
         }
         
         if (document.forms["users"]["email"].value == "") {
        	 
              alert("Please enter email");
              document.getElementById('userMessage').innerHTML = "Please enter email";
              document.forms["users"]["email"].focus();
              
              return false;
         }
         
         if (document.forms["users"]["password"].value == "") {
        	 
              alert("Please enter password");
              document.getElementById('userMessage').innerHTML = "Please enter password";
              document.forms["users"]["password"].focus();
              
              return false;
         }
         
   }
