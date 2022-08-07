package Testng;

import Pages.AddContactPage;
import Pages.HomePage;
import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.DeviceFarmUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class ContactManagerTest {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    AddContactPage addContactPage;
    String oreo = DeviceFarm.ANDROID_OREO.path;
    DesiredCapabilities capabilities;

    public ContactManagerTest(){
        oreo = DeviceFarm.ANDROID_OREO.path;
    }

    @BeforeClass
    public void setup() throws MalformedURLException{
        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("app",new File("src/test/resources/Apps/ContactManager.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        homePage = new HomePage();
        addContactPage = new AddContactPage();
    }

    @Test
    public void openAddContactOnOreo() throws NullPointerException, InterruptedException {
        // click the add contact button
        homePage.getAddContactBtn().click();

    }

    @Test
    public void userAddWorkAccount(){
        // click email field and sendname
        addContactPage.getContactNameField().click();
        addContactPage.getContactNameField().sendKeys("workaccount");
        // click phone field and send phone number
        addContactPage.getContactPhoneField().click();
        addContactPage.getContactPhoneField().sendKeys("5555555555");
        // click phonedrop and select work phone
        addContactPage.getContactPhoneDrop().click();
        addContactPage.getSelectWorkPhone().click();
        // click email fiel and send email
        addContactPage.getContactEmailField().click();
        addContactPage.getContactNameField().sendKeys("test123@test.com");
        // click emaildrop and select work email
        addContactPage.getContactEmailDrop().click();
        addContactPage.getSelectWorkMail().click();

        Assert.assertEquals(addContactPage.getContactPhoneDrop().getText(),"Work");

        //click save button
        addContactPage.getContactSaveBtn().click();
    }

    @Test
    public void userAddMobileAccount(){
        // click email field and sendname
        addContactPage.getContactEmailField().click();
        addContactPage.getContactEmailField().sendKeys("workaccount");
        // click phone field and send phone number
        addContactPage.getContactPhoneField().click();
        addContactPage.getContactPhoneField().sendKeys("5555555555");
        // click phonedrop and select mobile phone
        addContactPage.getContactPhoneDrop().click();
        addContactPage.getSelectMobilePhone().click();
        // click email fiel and send email
        addContactPage.getContactEmailField().click();
        addContactPage.getContactNameField().sendKeys("test123@test.com");
        // click emaildrop and select mobile email
        addContactPage.getContactEmailDrop().click();
        addContactPage.getSelectMobileMail().click();

        Assert.assertEquals(addContactPage.getContactPhoneDrop().getText(),"Mobile");

        addContactPage.getContactSaveBtn().click();

    }

    @Test
    public void checkNumberLimit(){
        String number = "";
        // select number for check size
        number = addContactPage.getContactPhoneField().getText();

        Assert.assertEquals(number.length(),9);

    }

    @Test
    public void chechEmailFormat(){

        String email = "";
        email = addContactPage.getContactEmailField().getText();

        // check the email have @
        Assert.assertEquals(email.contains("@"),"true");
    }

    @Test
    public void chechlNameHaveDigit(){

        String name = "";
        name = addContactPage.getContactNameField().getText();
        // if name have ant digit return true and assert retrun false
        Assert.assertEquals(name.contains("1234567890"),"false");
    }

    @Test
    public void checkPhoneisDigit(){

        String number = "";
        boolean check = true;

        number = addContactPage.getContactPhoneField().getText();
        // if number have nondigit character return false

        for(int i = 0; i < number.length(); i++){
            if (number.charAt(i) != '1' ||
                    number.charAt(i) != '2' ||
                    number.charAt(i) != '3' ||
                    number.charAt(i) != '4' ||
                    number.charAt(i) != '5' ||
                    number.charAt(i) != '6' ||
                    number.charAt(i) != '7' ||
                    number.charAt(i) != '8' ||
                    number.charAt(i) != '9' ||
                    number.charAt(i) != '0') {
                check = false;
            }

        }

        Assert.assertEquals(check,"true");
    }

    @Test
    public void nameHaveSpecialCharacter(){

        String name = "";

        name = addContactPage.getContactNameField().getText();
        // if name have special character return false
        Assert.assertEquals(name.contains("+-*/_=!'^$½%&{[]}=)(/"),false);
    }





}
