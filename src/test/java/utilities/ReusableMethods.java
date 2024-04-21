package utilities;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static utilities.Driver.driver;

public class ReusableMethods {

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    public static void elementToClickable(WebElement element) {
        try {
            waitForElement(element);
            element.click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    public static void waitForElement(WebElement element) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NullPointerException e) {

            e.printStackTrace();
        }

    }

    public static String getElementText(WebElement element) {
        waitForElement(element);
        System.out.println("Element Text : " + element.getText());
        return element.getText();
    }


    public static void sendKeysElement(WebElement element, String key) {
        try {
            waitForElement(element);
            element.click();
            element.sendKeys(key);
            waitFor(2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static void sendKeysElement(WebElement element, int key) {
        try {
            waitForElement(element);
            element.click();
            element.sendKeys(String.valueOf(key));
            waitFor(2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static void waitFor(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectedTextClick(String expectedText, String searchedElement) {
        // Aynı locator değerine sahip tüm elementleri bul
        System.out.println("Text : " + expectedText);
        List<WebElement> elements = driver.findElements(By.id(searchedElement));

        // Eşleşen metni ara
        WebElement selectedElement = null;

        for (WebElement element : elements) {
            String text = element.getText();
            if (text.contains(expectedText)) {
                System.out.println("Element" + element);
                selectedElement = element;
                break;
            }
        }

        // Eşleşen ilk elementi seç
        if (selectedElement != null) {
            selectedElement.click();  // Elemente tıkla
        } else {
            System.out.println("Eşleşen metin bulunamadı.");
        }
    }

    public static void textViewTextCheck(String textValue){
        WebElement textViewElement = driver.findElement(By.xpath("//android.widget.TextView[@text='"+textValue+"']"));
        Assert.assertEquals(getElementText(textViewElement), textValue);
    }
}
