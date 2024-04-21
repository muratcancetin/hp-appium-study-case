package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.AllPages;

public class AHomePage extends AllPages {

    @AndroidFindBy(id="com.pozitron.hepsiburada:id/menuItemAccountFakeView")
    public WebElement accountButton;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/menuItemAllFakeView")
    public WebElement hizmetlerButton;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id='txtUserName']")
    public WebElement loginEPostaInput;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id='txtPassword']")
    public WebElement loginPasswordInput;

    @AndroidFindBy(xpath ="//android.widget.Button[@resource-id='btnGoogle']")
    public WebElement googleButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Tüm Kategoriler']")
    public WebElement allCategoriesText;


}
