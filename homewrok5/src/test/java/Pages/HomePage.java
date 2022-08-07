package Pages;

import Testng.ContactManagerTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
@Data
public class HomePage {
    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerTest.Driver), this);

    }

    @AndroidFindBy(id = "addContactButton")
    private MobileElement addContactBtn;


}
