package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllPages;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;
import static utilities.ReusableMethods.*;


public class LoginStepDefs {

    AllPages allPages = new AllPages();

    @Given("Hepsiburada mobil uygulamasi acilir")
    public void mobilAppAcilir() {
        elementToClickable(allPages.androidHomePage().hizmetlerButton);
    }

    @When("Hesabim butonuna tiklanir")
    public void hesabim_butonuna_tiklanir() {
        System.out.println("Element" + allPages.androidHomePage().accountButton);
        elementToClickable(allPages.androidHomePage().accountButton);
    }

    @When("Sayfa basligi {string} oldugu dogrulanir")
    public void sayfaBasligiDogrulanir(String headerText) {
        Assert.assertEquals(allPages.androidAccountPage().guestAccountTitle.getText(), headerText);
    }

    @When("{string} butonuna basilir")
    public void butonunaBasilir(String buttonText) {
        WebElement button = Driver.getDriver().findElement(By.xpath("//android.widget.Button[@text='" + buttonText + "']"));
        elementToClickable(button);
    }

    @When("Eposta inputuna tiklanir ve {string} girilir")
    public void ePostaInputunaTiklanirveDoldurulur(String userMail)  {
        sendKeysElement(allPages.androidHomePage().loginEPostaInput, getProperty(userMail));
    }

    @Then("Sifre alanina tiklanir ve {string} girilir")
    public void sifreInputunaTiklanirveDoldurulur(String userPass)  {
        sendKeysElement(allPages.androidHomePage().loginPasswordInput, (getProperty(userPass)));
    }

    @Then("Kullanici {string} bilgisi dogrulanir")
    public void kullaniciBilgisiDogrulanir(String expectedValue) {
        switch (expectedValue) {
            case "isim-soyisim":
                Assert.assertEquals(getProperty(expectedValue), getElementText(allPages.androidAccountPage().myAccountPageTitle));
                break;
            default:
                break;
        }
    }
}
