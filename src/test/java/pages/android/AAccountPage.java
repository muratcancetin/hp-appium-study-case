package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.AllPages;

public class AAccountPage extends AllPages {

    @AndroidFindBy(id = "android:id/message")
    public WebElement successLoginMessageModal;

    @AndroidFindBy(id="com.pozitron.hepsiburada:id/tvToolbarTitle")
    public WebElement guestAccountTitle;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvUserNameFull")
    public WebElement myAccountPageTitle;
}
