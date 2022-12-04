package StepDefinition;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _01_LoginStep {
    DialogContent dc = new DialogContent();

    @Given("Naviagate to Luma")
    public void naviagateToLuma() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter email and password and click Login button")
    public void enterEmailAndPasswordAndClickLoginButton() {
        dc.findAndClick("signin");
        dc.findAndSend("email", "grub6@mail.com");
        dc.findAndSend("password", "Abcd1234");
        dc.findAndClick("loginButton");

    }

    @Then("User should login successfuly")
    public void userShouldLoginSuccessfuly() {
        dc.findAndContainsText("textCheckPozitive", "Welcome");
    }

    @And("And Click on the element in the Dialog")
    public void andClickOnTheElementInTheDialog(DataTable elemanlar) {
        List<String> listElemanlar = elemanlar.asList(String.class);
        for (String strButton : listElemanlar) {
            dc.findAndClick(strButton);
        }
    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elemanlar) {
        List<List<String>> listElemanlar = elemanlar.asLists(String.class);

        for (int i = 0; i < listElemanlar.size(); i++)
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1));
        // eleman adı                    eleman değeri
    }

    @Then("Login unsuccessfuly")
    public void loginUnsuccessfuly() {
        dc.findAndContainsText("textCheckNegative", "incorrect");
    }
}
