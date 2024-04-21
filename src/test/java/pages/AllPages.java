package pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.android.AAccountPage;
import pages.android.AHomePage;
import pages.android.ASearchPage;
import utilities.Driver;


public class AllPages {

    public AllPages() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    private AHomePage homePage;
    private AAccountPage accountPage;
    private ASearchPage searchPage;

    public AHomePage androidHomePage() {
        if (homePage == null) {
            homePage = new AHomePage();
        }
        return homePage;
    }

    public AAccountPage androidAccountPage() {
        if (accountPage == null) {
            accountPage = new AAccountPage();
        }
        return accountPage;
    }

    public ASearchPage androidSearchPage() {
        if (searchPage == null) {
            searchPage = new ASearchPage();
        }
        return searchPage;
    }

}

