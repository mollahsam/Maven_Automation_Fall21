package ActionItem_6;

import Day9_010822.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static javax.swing.text.StyleConstants.Size;


public class ActionItem6 {

        WebDriver driver;
        ExtentReports reports;
        ExtentTest logger;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
        //set the path of the report once
        reports = new ExtentReports("src/main/java/HTML_Report/Expressreport.html",true);
    }//end of precondition

    @Test(priority = 1)
    public void ExpressSheet () throws IOException, BiffException, WriteException, InterruptedException {
        //Step 1: read the data from the excel sheet you created
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/ExpressSheet.xls"));
        //Step 2: locating the worksheet that you created for the workbook
        Sheet readableSheet = readableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount = readableSheet.getRows();
        System.out.println("My row count is " + rowCount);

        //Step 3: create a writable file to mimic readable but you can also write back the results to this file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressSheet_Results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount2 = writableSheet.getRows();
        System.out.println("My writable row count is " + rowCount2);


        logger = reports.startTest("Express Test");


        for (int i = 1; i < 4; i++) {

            //store the columns list as variables
            String size = writableSheet.getCell(0,i).getContents();
            String quantity = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phoneNumber = writableSheet.getCell(5,i).getContents();
            String address = writableSheet.getCell(6,i).getContents();
            String zipCode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String state = writableSheet.getCell(9,i).getContents();
            String cardNumber = writableSheet.getCell(10,i).getContents();
            String expMonth = writableSheet.getCell(11,i).getContents();
            String expYear = writableSheet.getCell(12,i).getContents();
            String CVV = writableSheet.getCell(13,i).getContents();


            logger.log(LogStatus.INFO, "Navigate to Express home page");
            driver.navigate().to("https://www.express.com");

            //verify the title says 'Express'
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Express")) {
                System.out.println("Title matches as 'Express'");
            } else {
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }

            Reusable_Actions_Loggers.mouseHover(driver, "//*[@href='/womens-clothing?W_HEADER_WOMENSCLOTHING']", logger, "Women tab");

            Reusable_Actions_Loggers.clickMethod(driver, "//*[@href='/womens-clothing/dresses/cat550007']", logger, "Dress click");

            Reusable_Actions.clickMethod(driver, "//*[contains(@class,'close_button-20856-position')]","Close PopUp");

            Reusable_Actions_Loggers.scrollMethod(driver, "0", "450", logger, "scroll down 450");

            Reusable_Actions_Loggers.multipleClick(driver, "//*[@class='_2fbIe3xmE78JEQRb26pdpQ']",1,logger,"2nd dress" );


            Reusable_Actions_Loggers.clickMethod(driver, "//*[@value='"+size+"']", logger, "Choose dress size");
            Thread.sleep(1000);



            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Add to Bag']", logger, "Add to Bag");

            Thread.sleep(5000);

            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='View Bag']", logger, "View Bag");

            Reusable_Actions_Loggers.selectMethod(driver,""+quantity+"","//*[@id='qdd-0-quantity']",logger,"Add Quantity");

            Reusable_Actions_Loggers.clickMethod(driver, "//*[@id='continue-to-checkout']", logger, "Continue to checkout");

            //Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Checkout']",logger,"Continue to checkout");

            Thread.sleep(2000);

            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Checkout as Guest']", logger, "Checkout as Guest");

            Thread.sleep(2000);

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='firstname']",""+firstName+"",logger,"firstName");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='lastname']",""+lastName+"",logger,"lastName");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='email']",""+email+"",logger,"email");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='confirmEmail']",""+email+"",logger,"confirmEmail");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='phone']",""+phoneNumber+"",logger,"phoneNumber");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='lastname']",""+lastName+"",logger,"lastName");

            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Continue']", logger, "Continue");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.line1']",""+address+"",logger,"address");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.postalCode']",""+zipCode+"",logger,"zipcode");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.city']",""+city+"",logger,"city");

            Reusable_Actions_Loggers.selectMethod(driver,""+state+"","//*[@name='shipping.state']",logger,"State");

            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Continue']", logger, "Continue");

            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Continue']", logger, "Continue");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='creditCardNumber']",""+cardNumber+"",logger,"cardNumber");

            Reusable_Actions_Loggers.selectMethod(driver,""+expMonth+"","//*[@name='expMonth']",logger,"expMonth");

            Reusable_Actions_Loggers.selectMethod(driver,""+expYear+"","//*[@name='expYear']",logger, "expYear");

            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='cvv']",""+CVV+"",logger,"CVV");

            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='NO, THANK YOU']",logger, "Close popup");

            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Place Order']", logger, "Place order");


            Thread.sleep(2000);


            String result = Reusable_Actions_Loggers.getTextMethod(driver, "//*[contains(@class,'_3z2au8LN')]", logger, "Error Message");
            System.out.println(result);



            Label label = new Label(14,i,result);

            writableSheet.addCell(label);


            //Delete all cookies
            driver.manage().deleteAllCookies();
        }//end of loop

        //Writing back into writable file
        writableFile.write();
        writableFile.close();

        //end the logger
        reports.endTest(logger);



    }//end of test


    @AfterSuite
    public void endTest(){
        driver.quit();
        //write/log the informations back to the html report
        reports.flush();
    }//end of after suite

}

