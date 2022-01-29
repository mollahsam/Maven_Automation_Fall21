package Day8_122621;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mycalc_trycatchException {
    public static void main(String[] args) throws InterruptedException {

        //call the webdrivermanager
        WebDriverManager.chromedriver().setup();
        //call chromeoptions
        ChromeOptions options = new ChromeOptions();
        //set incognito and maximize the driver
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        //set my webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);

        //enter value to purchase price
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        }catch (Exception e){
            System.out.println("unable to enter the value on purchase price " + e);
        }// end of purchase price exception

        //click on show advance action
        try {
            driver.findElement(By.xpath("//*[text(🙁'Show advanced options']")).click();
        }catch (Exception e){
            System.out.println("Unable to click on Show advanced options " + e);
        }//end of show advanced options exception

    }//end of main
}//end of class
