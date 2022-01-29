package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reusable_Actions_Loggers {
    //create a reusable method for WebDriver and chromeoptions
    public static WebDriver setDriver(){
        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //to maximize my driver
        options.addArguments("start-maximized");
        //options.addArguments("fullscreen"); //for mac users
        //set as incognito mode
        options.addArguments("incognito");
        //set as headless(running the driver on background)
        //options.addArguments("headless");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver(options);
        return  driver;
    }//end of webdriver method

    //method to hover on any web element
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Hovering on element " + elementName);
        logger.log(LogStatus.INFO,"Hovering on element " + elementName);
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            //logger.log(LogStatus.PASS,"Successfully hover to element " +elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to hover on " + elementName + " Error:" + e);
        }
    }//end of hover method


    //creating void click method for any web element (unique)
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
        }
    }//end of click method


    //creating void click method for multiple generic element names (not unique)
    public static void multipleClick (WebDriver driver, String xpath, Integer number,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        try {
            //driver.findElements(By.xpath(xpath)).get(n).click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(number).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
        }
    }//end of click method



    //creating void submit method for any web element
    public static void submitMethod(WebDriver driver, String xpath,ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Submitting on element " + elementName);
        logger.log(LogStatus.INFO,"Submitting on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to submit on " + elementName + " Error:" + e);
        }
    }//end of submit method


    //creating void sendkeys method for any web element
    public static void sendKeysMethod(WebDriver driver, String xpath, String userData, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Typing on element " + elementName);
        logger.log(LogStatus.INFO,"Typing on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //clear first
            element.clear();
            //enter user data
            element.sendKeys(userData);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to type on " + elementName + " Error:" + e);
        }
    }//end of click sendKeysMethod

    //creating return getText method for any text web element
    public static String getTextMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Capturing text on element " + elementName);
        logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
        //declare a global variable to capture the text so I can return it
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //capture text
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on " + elementName + " Error:" + e);
        }
        return result;
    }//end of click getTextMethod


    //creating scroll by pixel method for any webpage
    public static void scrollMethod(WebDriver driver, String x, String y,ExtentTest logger, String feature){
        System.out.println("Utilizing feature " + feature);
        logger.log(LogStatus.INFO,"Scrolling" );
        try {
            //since we are not waiting for a specific element, input regular wait time
            Thread.sleep(4000);
            //call for scroll function
            JavascriptExecutor jsef = (JavascriptExecutor)driver;
            //scroll to the view by pixels
            jsef.executeScript("scroll("+x+","+y+")");
        } catch (Exception e) {
            System.out.println("Unable to utilize feature " + feature + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to scroll. Error: " + e);
        }
    }//end of scroll method



    //Creating select method
    public static void selectMethod(WebDriver driver, String textInput, String xpath, ExtentTest logger, String elementName) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver,15);
        Thread.sleep(2000);
        System.out.println("Selecting element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        WebElement startList = driver.findElement(By.xpath(xpath));
        //select command can only be used when the drop down element is under 'Select' tag
        Select sDropDown = new Select(startList);
        try {
            //select by visible text
            sDropDown.selectByVisibleText(textInput);
        } catch (Exception e){
            System.out.println("Unable to select from "+elementName+ " Error: " +e);
            logger.log(LogStatus.FAIL,"Unable to select on " + elementName + " Error:" + e);
        }//end of try catch
    }//end of selectMethod method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

        public static String getDateTime() {
            SimpleDateFormat sdfDateTime;
            String strDateTime;
            sdfDateTime = new SimpleDateFormat("yyyyMMdd'_'HHmmss'_'SSS");
            Date now = new Date();
            strDateTime = sdfDateTime.format(now);
            return strDateTime;
        }




}//end of java class

