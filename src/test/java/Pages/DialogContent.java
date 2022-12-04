package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Sign In")
    private WebElement signin;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(name = "login[password]")
    private WebElement password;
    @FindBy(id = "send2")
    private WebElement loginButton;
    @FindBy(xpath = "//span[text()='Welcome, Grup6 techno!']")
    private WebElement textCheckPozitive;
    @FindBy(xpath = "//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
    private WebElement textCheckNegative;
    @FindBy(xpath = "//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/2a213d0c937b30e310c8ee797a880cef/m/b/mb02-gray-0.jpg']")
    private WebElement backPack;
    @FindBy(xpath = "//span[text()='Add to Cart']")
    private WebElement addToCart;
    @FindBy(xpath = "//a[text()='shopping cart']")
    private WebElement shopingCart;
    @FindBy(xpath = "//span[text()='Proceed to Checkout']")
    private WebElement proceedtoCheckout;

    @FindBy(xpath = "//span[text()='$0.00']")
    private WebElement ratioButton;
    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;
    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    private WebElement orderText;
    @FindBy(xpath = "//button[@title='Place Order']")
    public WebElement placeOrderButton;
    @FindBy(xpath = "//span[text()='Order Summary']")
    public WebElement orderSummaryText;
    @FindBy(name = "billing-address-same-as-shipping")
    public WebElement checkBox;


    WebElement myElement;

    public void findAndSend(String strlement, String value) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;

        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "signin":
                myElement = signin;
                break;
            case "loginButton":
                myElement = loginButton;
                break;
            case "backPack":
                myElement = backPack;
                break;
            case "addToCart":
                myElement = addToCart;
                break;
            case "shopingCart":
                myElement = shopingCart;
                break;
            case "proceedtoCheckout":
                myElement = proceedtoCheckout;
                break;
            case "ratioButton":
                myElement = ratioButton;
                break;
            case "nextButton":
                myElement = nextButton;
                break;
            case "placeOrderButton":
                myElement = placeOrderButton;
                break;
            case "checkBox":
                myElement = checkBox;
                break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "textCheckPozitive":
                myElement = textCheckPozitive;
                break;
            case "textCheckNegative":
                myElement = textCheckNegative;
                break;
            case "orderText":
                myElement = orderText;
                break;
            case "orderSummaryText":
                myElement = orderSummaryText;
                break;

        }

        verifyContainsTextFunction(myElement, text);
    }

    public void findAndDelete(String searchText) {

        findAndSend("searchInput", searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //wait.until(ExpectedConditions.stalenessOf(deleteButton)); stale zamanını yakalayamadım
        //wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody[@role='rowgroup']//tr"),5));
        // progressbar ın çocukları 0 olana kadar bekle
        waitUntilLoading();

        findAndClick("deleteButton"); // silme butonua bas, çöp kutusu
        findAndClick("deleteDialogBtn"); // dilogdaki silme butonuna bas

    }


}
