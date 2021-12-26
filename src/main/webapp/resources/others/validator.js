
    function validate() {
    	
         if (document.forms["employee"]["fname"].value == "") {
              alert("Please enter first name");
              document.forms["employee"]["fname"].focus();
              return false;
         }
         if (document.forms["employee"]["lname"].value == "") {
              alert("Please enter last name");
              document.forms["employee"]["lname"].focus();
              return false;
         }
         if (document.forms["employee"]["userName"].value == "") {
              alert("Please enter user name");
              document.forms["employee"]["userName"].focus();
              return false;
         }
         if (document.forms["employee"]["emailId"].value == "") {
              alert("Please enter email id");
              document.forms["employee"]["emailId"].focus();
              return false;
         }
         if (document.forms["employee"]["empId"].value == "") {
              alert("Please enter emp Id");
              document.forms["employee"]["empId"].focus();
              return false;
         }
         if (document.forms["employee"]["bloodGp"].value == "") {
              alert("Please enter blood group");
              document.forms["employee"]["bloodGp"].focus();
              return false;
         }
         if (document.forms["employee"]["age"].value == "" || document.forms["employee"]["age"].value == 0) {
              alert("Please enter valid age");
              document.forms["employee"]["age"].focus();
              return false;
         }
         
   }
