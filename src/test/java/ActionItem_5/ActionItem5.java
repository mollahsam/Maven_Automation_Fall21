package ActionItem_5;

import Day9_010822.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem5 {


        WebDriver driver;

        @BeforeSuite
        public void SetTheDriver(){ driver = Reusable_Actions.setDriver();
        }



        @Test(priority = 1)
        public void HuluCreate() throws InterruptedException {
            ArrayList<String > email = new ArrayList<>();
            email.add("qaactionitem11279111@gmail.com");
            email.add("qaactionitem11291812@gmail.com");

            ArrayList<String > password = new ArrayList<>();
            password.add("qapassword96");
            password.add("qapassword96");

            ArrayList<String > name = new ArrayList<>();
            name.add("Sam Mol");
            name.add("Sam Mul");

            ArrayList<String > birthMonth = new ArrayList<>();
            birthMonth.add("March");
            birthMonth.add("April");

            ArrayList<String > birthDay = new ArrayList<>();
            birthDay.add("21");
            birthDay.add("22");

            ArrayList<String > birthYear = new ArrayList<>();
            birthYear.add("2000");
            birthYear.add("2001");

            ArrayList<String > gender = new ArrayList<>();
            gender.add("Male");
            gender.add("Female");


            for(int i = 0; i < email.size(); i++){
                driver.navigate().to("https://www.hulu.com/welcome");

                String titlePage = driver.getTitle();
                if (titlePage.equals("Stream TV and Movies Live and Online | Hulu")) {
                    System.out.println("Title matches");

                } else {
                    System.out.println("Title does not match");
                }


                Reusable_Actions.scrollMethod(driver, "0","3300");

                Reusable_Actions.clickMethod(driver, "//*[contains(@class,'plan-card__0_cta')]","Select");

                Reusable_Actions.sendKeysMethod(driver, "//*[@id='email']",""+email.get(i)+"","Email");

                Reusable_Actions.sendKeysMethod(driver, "//*[@id='password']",""+password.get(i)+"","Password ");

                Reusable_Actions.sendKeysMethod(driver, "//*[@id='firstName']",""+name.get(i)+"","Name");

                Reusable_Actions.clickMethod(driver, "//*[contains(@class,'field__month')]","Month");

                Reusable_Actions.clickMethod(driver, "//*[text()='"+birthMonth.get(i)+"']","Month");

                Reusable_Actions.clickMethod(driver, "//*[contains(@class,'field__day')]","Day");

                Reusable_Actions.clickMethod(driver, "//*[text()='"+birthDay.get(i)+"']","Day");

                Reusable_Actions.clickMethod(driver, "//*[contains(@class,'field__year')]","Year");

                Reusable_Actions.clickMethod(driver, "//*[text()='"+birthYear.get(i)+"']","Year");

                Reusable_Actions.clickMethod(driver, "//*[contains(@class,'field gender')]","Gender");

                Reusable_Actions.clickMethod(driver, "//*[text()='"+gender.get(i)+"']","Gender");

                Reusable_Actions.clickMethod(driver, "//*[contains(@class,'button--continue')]","Continue");

                String subscription = Reusable_Actions.getTextMethod(driver, "//*[contains(@class,'ledger__price')]", "MONTHLY");
                System.out.println("MONTHLY: " +subscription);

                String Today = Reusable_Actions.getTextMethod(driver, "//*[contains(@class,'summary__price')]", "DUE TODAY");
                System.out.println("Amount due today is " +Today);

                driver.manage().deleteAllCookies();

            }
        }


        @Test(dependsOnMethods = "HuluCreate")
        public void Signin() throws InterruptedException {

            ArrayList<String > email = new ArrayList<>();
            email.add("qaactionitem1111@gmail.com");
            email.add("qaactionitem1112@gmail.com");

            ArrayList<String > password = new ArrayList<>();
            password.add("qapassword96");
            password.add("qapassword96");

            ArrayList<String > name = new ArrayList<>();
            name.add("Sam Mol");
            name.add("Sam Mul");

            driver.navigate().to("https://www.hulu.com/welcome");

            Reusable_Actions.clickMethod(driver, "//*[contains(@class,'navigation__login-button')]", "Log In");

            Reusable_Actions.sendKeysMethod(driver, "//*[@id='email_id']",""+email.get(0)+"","Email");

            Reusable_Actions.sendKeysMethod(driver, "//*[@id='password_id']",""+password.get(0)+"","Password");

            Reusable_Actions.clickMethod(driver, "//*[text()='LOG IN']", "Log In");

            Reusable_Actions.clickMethod(driver, "//*[text()='"+name.get(0)+"']", "Log In");

            String userName = Reusable_Actions.getTextMethod(driver, "//*[contains(@class,'cu-pi-display-name')]", "username");

            if(userName.equals(name.get(0))){
                System.out.println("Username is verified and matches.");
            } else {
                System.out.println("Incorrect username, unmatched." );
            }

        }//end of test

        @AfterSuite
        public void endSession(){
            driver.quit();

        }//end suite
    }//end of class

