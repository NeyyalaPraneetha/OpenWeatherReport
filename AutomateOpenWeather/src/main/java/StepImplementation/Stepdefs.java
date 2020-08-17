package StepImplementation;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Stepdefs {
    WebDriver driver;

    int i;
    int j;
    int Count = 5;

   @Before
   public void setup(Scenario Name) {
       System.out.println("************Before Test*******");
       driver = utilities.driverfactory.Open("Chrome");
       driver.get("http://localhost:3000/");
       driver.manage().window().maximize();
       System.out.println("Name: "+ Name.getName());
       System.out.println("Status : "+ Name.getStatus());
   }
    @Given("^the home page of opens Weather map is displayed$")
    public void thehomepageofopensWeathermapisdiplayed() {
        System.out.println("Weather Forcast page is displayed");
    }


    @When("^the user searches with (.*)$")
    public void theUserSearchesWith(String CityName) throws Throwable {
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(CityName);
        driver.findElement(By.name("city")).sendKeys(Keys.ENTER);
    }

    @And("^the user sees (.*) days report$")
    public void theUserClickOnGivenCity_name(int Count) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (i = 1; i <= Count; i++) {
            String dayname = driver.findElement(By.xpath("//*[@id='root']/div/div[" + i + "]/div[1]")).getText();
            System.out.println("Today is " + dayname);
        }
    }

    @Then("^the Weather forcaste is displayed for the (.*) on the page$")
    public void theWeatherForcasteIsDsplayedWithAllDaysOnThePage(String Cityname) {
        String headertext = driver.findElement(By.xpath("//*[@id=\"root\"]/div/h1")).getText();
        System.out.println(headertext + " " + Cityname + " header is displayed");
    }

    @Then("^the error message \"([^\"]*)\"$")
    public void theErrorMessage(String Errormessage) throws Throwable {
        String Actualmesg = driver.findElement(By.xpath("//*[@id='root']/div/div")).getText();
        System.out.println("Actual message is " + Actualmesg);
        Assert.assertEquals(Errormessage, Actualmesg);
    }


    @When("^the user clicks to hide the summary info$")
    public void theUserClicksToHideTheSummaryInfo() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/span")).click();
        String day = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/span[1]/span[1]")).getText();
        System.out.println("day" + day);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/span")).click();
    }

    @Then("^the weather forcast of whole day is not displayed$")
    public boolean theWeatherForcastOfWholeDayIsNotDisplayed() {
        try {
            driver.findElement(By.className("details"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    @When("the user click on EachDay for the sumary forcast")
    public void theUserClickOnEachDayForTheSumaryForcast() {
        for (i = 1; i <= Count; i++) {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div/span")).click();
            String day = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div[1]/span[1]/span[1]")).getText();
            System.out.println("On " + day);
            for (j = 1; j <= 4; j++) {
                String Actualhour = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div[2]/div[" + j + "]/span/span")).getText();
                String MaxMintemp = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div[2]/div[" + j + "]/span[3]")).getText();
                String WindSpeed = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div[2]/div[" + j + "]/span[4]")).getText();
                String Rainfall = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div[2]/div[" + j + "]/span[5]")).getText();
                System.out.println("MAx/MinTemparature at " + Actualhour + " is " + MaxMintemp);
                System.out.println("Windspeed at " + Actualhour + " is " + WindSpeed);
                System.out.println("Rainfall at " + Actualhour + " is " + Rainfall);
            }
            System.out.println("*********End of the day***********");
        }
    }


    @Then("temperature values should be always displayed as roundedoff")
    public void temperatureValuesShouldBeAlwaysDisplayedAsRoundedoff() {

        for (i = 1; i <= Count; i++) {
            String MinMaxtem = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[" + i + "]/div[1]/span[3]/span[1]")).getText();
            String Maxtemp = MinMaxtem.replaceAll("[^a-zA-Z0-9]", " ").trim();
            int Maxvalue = Integer.parseInt(String.valueOf(Maxtemp));
//            double Maxvalue1 = 13.7;
            System.out.println("MaxtempValue is " + Maxvalue);
            Assert.assertTrue("the Value is not roundedoff", Maxvalue == Math.round(Maxvalue));
        }

    }
}
