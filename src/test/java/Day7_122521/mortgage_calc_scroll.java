package Day7_122521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mortgage_calc_scroll { public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();

    options.addArguments("start-maximized");

    WebDriver driver = new ChromeDriver();

    driver.navigate().to("https://www.mortgagecalculator.org");

    Thread.sleep(2500);

    JavascriptExecutor jse = (JavascriptExecutor)driver;

    WebElement homeValueText = driver.findElement(By.xpath("//*[contains(text(), 'Home Value:')]"));
    jse.executeScript("arguments[0].scrollIntoView(true);", homeValueText);

    Thread.sleep(2000);

    driver.quit();

    }//end of main method

}//end of java class
