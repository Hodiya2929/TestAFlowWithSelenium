# TestAFlowWithSelenium
Test a functional flow in Github website: login, create a repository and a new issue.

This project uses Maven build tool, TestNG testing framework and Selenium.

The purpose of the project is to test a flow: login, then create a new project and lastly a new issue. 

I suppose that if you try to clone and run - probably it will fail, the reason is that after signning in Github "wants" an email verification. 

But my main purposes was to practise in:

1. how to integrate the different technologies together 
2. "How to write it right" - I used Page Object Model (POM) in this project and the test (and many tests to come) "enjoy the benefit".

In order to run:

1. Clone the project to a folder.
2. From this folder - open CLI and type: mvn clean test -Dsurefire.suiteXmlFiles=testng.xml

Very Important:

The code uses Chrome/Firefox webdrivers. And it assumes that the drivers are in:

C:\BrowserDrivers

So in order to run this project you have to download a webdriver (Chrome/Firefox) that match your browser version in the path. (C:\BrowserDrivers).

The program has in the resource folder a file with the name Identification.xml and it contains the user-name and password for the Github account. The program parse the xml using JDOM.


