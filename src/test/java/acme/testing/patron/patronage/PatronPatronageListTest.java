package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, 
		final String legalStuff, final String budget, final String creationMoment, final String initDate, 
		final String finishDate, final String link, final String name, final String surname, final String email,
		final String company, final String statement, final String inventorLink, final String patron ) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "Patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, initDate);
		super.checkColumnHasValue(recordIndex, 1, finishDate);
		super.checkColumnHasValue(recordIndex, 2, budget);
		super.checkColumnHasValue(recordIndex, 3, status);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("initDate", initDate);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.checkInputBoxHasValue("link", link);
		
//		super.clickOnButton("Inventor");
//		super.checkFormExists();
//		super.checkInputBoxHasValue("identity.name", name);
//		super.checkInputBoxHasValue("identity.surname", surname);
//		super.checkInputBoxHasValue("identity.email", email);
		
		super.signOut();
	}
}