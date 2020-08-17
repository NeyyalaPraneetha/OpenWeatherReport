# OpenWeather

Used selenium Webdriver and Java to Automate this appilaction.
Have used Intellij as my IDE to build the Cucumber framework using Gerkhin language.

Need to install few jars and drivers to execute this:

1. Java jdk 1.8
2. Intellij Ultimate 2020 version as community version version wont support .js files
3. As its maven project all the dependencies are on pom xml and its from repo.
4. Install Apache-maven 3.6.3

I have created feature file using the below acceptance criteria:

This application displays the 5 day weather forecast for a given location.

**Features**
Enter city name, get 5 day weather forecast
Select day, get 3 hourly forecast
Select day again, hide 3 hourly forecast
Daily forecast should summarise the 3 hour data:
Most dominant (or current) condition
Most dominant (or current) wind speed and direction
Aggregate rainfall
Minimum and maximum temperatures
Checking the value is rounded using assertions

I have created **Stepdefs** file under StepImplementaion folder as stepdef.java

Created a utility called **Driverfactory** to launch the browser and exit . 

Have created **testRunner** to execute the tests using Junit and Cucumber tests

Implemented Hooks for cucumber reports.

Can show a demo/ execution if required.




