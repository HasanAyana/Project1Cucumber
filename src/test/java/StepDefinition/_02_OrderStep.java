package StepDefinition;

import Pages.DialogContent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _02_OrderStep {
    DialogContent dc = new DialogContent();


    @And("Click product")
    public void clickProduct(DataTable elemanlar) {
        List<String> listElemanlar = elemanlar.asList(String.class);
        for (String strButton : listElemanlar) {
            dc.findAndClick(strButton);
        }
    }

    @And("Fill the form")
    public void fillTheForm(DataTable elemanlar) {
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri
    }

    @And("Order successfully")
    public void orderSuccessfully() {
       dc.findAndContainsText("orderText","Thank");
    }

    @And("Url verify")
    public void urlVerify() {
        dc.verifyContainsTextFunction(dc.orderSummaryText,"Order Summary");
    }
}