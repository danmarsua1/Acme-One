package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class ItemListAllTest extends TestHarness{


    @ParameterizedTest
    @CsvFileSource(resources = "/inventor/item/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void positiveTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String link) {
        super.signIn("inventor1", "inventor1");

        super.clickOnMenu("Inventor", "Items");
        super.checkListingExists();
        super.sortListing(0, "desc");

        super.checkColumnHasValue(recordIndex, 0, name);
        super.checkColumnHasValue(recordIndex, 1, type);
        super.checkColumnHasValue(recordIndex, 2, description);

        super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
        super.checkInputBoxHasValue("code", code);
        super.checkInputBoxHasValue("type", type);
        super.checkInputBoxHasValue("name", name);
        super.checkInputBoxHasValue("description", description);
        super.checkInputBoxHasValue("technology", technology);
        super.checkInputBoxHasValue("retailPrice", retailPrice);
        super.checkInputBoxHasValue("link", link);

        super.signOut();
    }

}