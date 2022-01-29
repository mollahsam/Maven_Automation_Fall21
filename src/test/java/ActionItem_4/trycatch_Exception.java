package ActionItem_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class trycatch_Exception {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11377");
        zipcodes.add("10065");
        zipcodes.add("10011");

        //webdriver manager to open by driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //start maximized
        options.addArguments("fullscreen");
        options.addArguments("incognito");
        //options.addArguments("headless");
        //set the driver
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < zipcodes.size(); i++) {

            try {
                //navigate to weightwatcher.com
                driver.navigate().to("https://www.weightwatchers.com");
            } catch (Exception e) {
                System.out.println("Can't go to website");
            }

            Thread.sleep(1000);


            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
            } catch (Exception e) {
                System.out.println("Can't click attend");
            }
            Thread.sleep(1000);

            try {
                driver.findElement(By.xpath("//*[@class='MenuItem_subtitle__3LoiE']")).click();
            } catch (Exception e) {
                System.out.println("Can't click virtual");
            }
            Thread.sleep(1000);

            try {
                driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
            } catch (Exception e) {
                System.out.println("Can't click search bar");
            }
            Thread.sleep(1000);

            try {
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipcodes.get(i));
            } catch (Exception e) {
                System.out.println("Can't enter zipcode");
            }

            Thread.sleep(1000);

            try {
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
            } catch (Exception e) {
                System.out.println("Can't click search arrow");
            }

            Thread.sleep(3000);

            //CONDITIONAL STATEMENT

            try {
                List<WebElement> link = driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']"));
                if (i == 0) {
                    //then click on 2nd result
                    link.get(1).click();
                } else if (i == 1) {
                    link.get(2).click();
                } else {
                    link.get(3).click();
                }//end of conditional
            } catch (Exception e) {
                System.out.println("Can't click link");
            }


            Thread.sleep(1000);

            try {
                //capture address of studio'
                String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();

                String[] actualaddress = address.split("Studio reopened");

                System.out.println("Address is " + actualaddress[0]);
            } catch (Exception e) {
                System.out.println("Can't get address");
            }

            Thread.sleep(1000);


            //scroll function
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            try {

                jse.executeScript("scroll(0,1000)");
            } catch (Exception e) {
                System.out.println("Can't scroll");
            }

            Thread.sleep(1000);

            try {
                //capture entire schedule table and print out schedule
                String VirtualSchedule = driver.findElement(By.xpath("//*[@id='virtualWorkshopSchedule']")).getText();
                String[] virtual = VirtualSchedule.split("troubleshoot.");
                System.out.println("Schedule is " + virtual[1]);
            } catch (Exception e) {
                System.out.println("Can't get schedule");
            }

        }//end of loop
        driver.quit();

    }//end of main
}//end of java class