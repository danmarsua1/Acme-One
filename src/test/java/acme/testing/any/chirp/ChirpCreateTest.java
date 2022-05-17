/*
 * EmployerDutyCreateTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class ChirpCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String title, final String author, final String creationMoment, final String body, final String email) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Any", "Chirp");
		super.checkListingExists();
		super.sortListing(1, "asc");

		super.clickOnButton("Create chirp");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create chirp");

		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, creationMoment);
		super.checkColumnHasValue(recordIndex, 2, author);

		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("author", author);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("creationMoment", creationMoment);

		super.signOut();
	}

//	@ParameterizedTest
//	@CsvFileSource(resources = "/employer/duty/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
//	@Order(20)
//	public void negativeTest(final int jobRecordIndex, final int dutyRecordIndex, final String title, final String description, final String workLoad, final String moreInfo) {
//		super.signIn("employer1", "employer1");
//
//		super.clickOnMenu("Employer", "List my jobs");
//		super.checkListingExists();
//		super.sortListing(0, "asc");
//
//		super.clickOnListingRecord(jobRecordIndex);
//		super.clickOnButton("Duties");
//
//		super.clickOnButton("Create");
//		super.fillInputBoxIn("title", title);
//		super.fillInputBoxIn("description", description);
//		super.fillInputBoxIn("workLoad", workLoad);
//		super.fillInputBoxIn("moreInfo", moreInfo);
//		super.clickOnSubmit("Create");
//		super.checkErrorsExist();
//
//		super.signOut();
//	}
//
//	@Test
//	@Order(30)
//	public void hackingTest() {
//		// HINT: the framework doesn't currently provide enough support to hack
//		// HINT+ this feature, so the remaining hacking tests must be performed manually.
//		// HINT+ a) create a duty for a job as a principal without the "Employer" role;
//		// HINT+ b) create a duty for a published job created by the principal;
//		// HINT+ c) create a duty for an unpublished job that wasn't created by the principal.
//	}
//
//	// Ancillary methods ------------------------------------------------------

}
