package Pages;

import Testng.ContactManagerTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class AddContactPage {

    public AddContactPage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerTest.Driver), this);
    }


    @AndroidFindBys({@AndroidFindBy(id="title"),@AndroidFindBy(tagName = "title")})
    private MobileElement titleBys;

    @AndroidFindBy(id = "accountSpinner")
    private MobileElement targetAccountField;

    @AndroidFindBy(id = "contactNameEditText")
    private MobileElement contactNameField;

    @AndroidFindBy(id = "contactPhoneEditText")
    private MobileElement contactPhoneField;

    @AndroidFindBy(id = "contactPhoneTypeSpinner")
    private MobileElement contactPhoneDrop;

    @AndroidFindBy(id = "contactEmailEditText")
    private MobileElement contactEmailField;

    @AndroidFindBy(id = "contactEmailTypeSpinner")
    private MobileElement contactEmailDrop;

    @AndroidFindBy(id = "contactSaveButton")
    private MobileElement contactSaveBtn;

    @AndroidFindBy(id = "CheckedTextView[2]")
    private MobileElement  selectWorkPhone;

    @AndroidFindBy(id = "CheckedTextView[2]")
    private MobileElement selectWorkMail;

    @AndroidFindBy(id = "CheckedTextView[3]")
    private MobileElement  selectMobilePhone;

    @AndroidFindBy(id = "CheckedTextView[3]")
    private MobileElement selectMobileMail;
}
