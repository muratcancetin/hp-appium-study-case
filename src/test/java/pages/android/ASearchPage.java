package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllPages;

public class ASearchPage extends AllPages {


    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    public WebElement searchBoxInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fiyat Aralığı']")
    public WebElement priceRangeButton;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/editTextPriceMin")
    public WebElement priceMinInput;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/editTextPriceMax")
    public WebElement priceMaxInput;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/btnFiltersApply")
    public WebElement applyPriceFilterButton;

    public String searchedProductTitle = "com.pozitron.hepsiburada:id/tvProductName";

    public String recommendKeywordList = "com.pozitron.hepsiburada:id/search_suggestion_title";

}
