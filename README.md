QA Exercise Forio
The API is to Auto test the login page

Login Automation Check using Selenium Web Driver Test 

*** Note : I have tested this application on Mac, Using Mac Driver for Chrome Browser, Kindly follow the ReadMe file for any Changes in the Drivers and Browser


pre Requisite
1. Java 
2. Maven
3. git (Optional)

We can clone the Source for Test from 
https://github.com/anilnpu/QATest.git

Created a Account by Signing Up @http://forio.com/epicenter

@Configuration
One can find the Config file in the project workspace directory
Below brief about the filed in the config file
----------------------------------- Config.prop ----------------------------------------
#Type Below the Web Driver Name Firefox/Chrome/Safari
browser=Chrome
#Copy Any of the Driver in the Driver Folder and pecify the driver name
webdriver=driver/chrome
#End Point is the URL on which we are about to auto test 
endPoint=https://forio.com/epicenter/sign-in
#Please end the credentials in #uName1=Pass1#uName2=Pass2...
credentials=qatest@forio.com=qatestforio8#qatest@forio.com=qatestforio88
-----------------------------------------------------------------------------------------

.................... Git Hub -----------------------------------
Clone the Github link so also to download the source

Nabigate to the Project workSpace

#For Cleaning project workspace and running test 
mvn clean test 

#For Testing the Project
mvn test 



