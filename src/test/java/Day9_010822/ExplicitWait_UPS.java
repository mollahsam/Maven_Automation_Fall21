package Day9_010822;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait_UPS {
    public static void main(String[] args) {

        WebDriver driver = Reusable_Actions.setDriver();

        //Declare and define your global implicit wait for all web elements
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //navigate to usps
        driver.navigate().to("https://www.ups.com/us/en/Home.page");
        driver.manage().window().fullscreen();//for mac
        //declaring explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);

        //click on Track
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Tracking']"))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Track " + e);
        }

        //click on track a package
        try {
            //click on Track
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Track a Package " + e);
        }

    }//end of main
}//end of class
