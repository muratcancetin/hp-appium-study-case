package stepDefinitions;

import io.cucumber.java.en.When;

import pages.AllPages;

import static utilities.ReusableMethods.*;
import static utilities.ReusableMethods.selectedTextClick;

public class SRPStepDefs {

    AllPages pages = new AllPages();
    static String productName = "";

    @When("Tum kategoriler butonuna tiklanir")
    public void tumKategorilerButonunaTikla() {
        elementToClickable(pages.androidHomePage().allCategoriesText);
    }

    @When("Search bar tiklanir ve {string} keywordu aratilir")
    public void searchBarTiklanirveKeywordAratilir(String searchKeyword) {
        sendKeysElement(pages.androidSearchPage().searchBoxInput, searchKeyword);
        productName = searchKeyword;
        System.out.println("product :" + productName);
        selectedTextClick(productName.toLowerCase(), pages.androidSearchPage().recommendKeywordList);

    }

    @When("Fiyat araligi filtresine tiklanir")
    public void fiyatAraligiFiltresineTiklanir() {
        elementToClickable(pages.androidSearchPage().priceRangeButton);
    }

    @When("Min {int} Maks {int} fiyat araligi uygulanir")
    public void fiyatAraligiUygulanir(int minPrice, int maksPrice) {
        sendKeysElement(pages.androidSearchPage().priceMinInput, minPrice);

        sendKeysElement(pages.androidSearchPage().priceMaxInput, maksPrice);

        elementToClickable(pages.androidSearchPage().applyPriceFilterButton);
    }

    @When("Listelenen urunlerden birinin detayina gidilir")
    public void urunDetayaGit() {
        selectedTextClick(productName, pages.androidSearchPage().searchedProductTitle);
    }

    @When("{string} textview kontrol edilir")
    public void textViewKontrolEdilir(String text) {
        textViewTextCheck(text);
    }
}
