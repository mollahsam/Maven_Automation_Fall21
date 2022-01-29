package ActionItem_3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Automation { public static void main(String[] args) throws InterruptedException {

    //set an array
    String[] sport = new String[6];
    sport[0] = "Basketball";
    sport[1] = "Football";
    sport[2] = "Soccer";
    sport[3] = "Tennis";
    sport[4] = "Golf";
    sport[5] = "Boxing";


    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    //define the web driver you are using
    WebDriver driver = new ChromeDriver();

    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");


    for (int i = 0; i < sport.length; i++) {
        //open bing website
        driver.navigate().to("bing.com");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[name='q']")).sendKeys(sport[i]);

        driver.findElement(By.xpath("//*[@class = 'search icon tooltip']")).submit();

        Thread.sleep(3000);

        String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

        String[] arrayResult = result.split(" ");

        System.out.println("For the sports " + sport[i] + " my search result is " + arrayResult[0]);

    }//end of loop

    driver.quit();

}//end of main
}//end of java class

