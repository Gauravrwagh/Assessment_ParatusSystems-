package stepDefination;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.GmailLoginPage;
import utilities.TestBase;

public class TC001_ComposeAndSendEmail extends TestBase {

	private GmailLoginPage gp;
	
	@After(order=0)
    public void closeBrowser(){
		tearDown();
    }	

	@Given("user is on login page of gmail")
	public void user_is_on_login_page_of_gmail() {
		initialization();
		gp =new GmailLoginPage(TestBase.driver);
	}

	@When("user enter emailID and clicks on next button")
	public void user_enter_email_id_and_clicks_on_next_button() {
	    gp.enterEmailOrPhone("youremail@gmail.com");
	    gp.clickNextButton();
	}

	@When("user enter password and clicks on next button")
	public void user_enter_password_and_clicks_on_next_button() {
	    gp.enterPassword("yourPassword");
	    gp.clickNextButton();
	}

	@Then("user logged in successfully and navigate to gmail homepage")
	public void user_logged_in_successfully_and_navigate_to_gmail_homepage() {
	   Assert.assertEquals(true, gp.isDisplayGmailLogo());
	}

	@Then("user start composing new message by clicking compose button")
	public void user_start_composing_new_message_by_clicking_compose_button() {
	    gp.clickComposeButton();
	}

	@Given("user on new message frame and filled all fields")
	public void user_on_new_message_frame_and_filled_all_fields() {
	    gp.enterRecipientsEmailId("recipients@gmail.com");
	    gp.enterSubject("Test");
	    gp.enterMessageBody("Message Body");
	}

	@When("user cliks on send button")
	public void user_cliks_on_send_button() {
	    gp.clickSendButton();
	}

	@Then("the email should be sent successfully")
	public void the_email_should_be_sent_successfully() {
	    Assert.assertEquals(true, gp.isConfirmationMessageDisplayed());
	}

	@When("user enters recipients emailID and Message in message body")
	public void user_enters_recipients_email_id_and_message_in_message_body() {
	    gp.enterRecipientsEmailId("recipients@gmail.com");
	    gp.enterMessageBody("Message Body");
	}

	@When("user tries to send mail without entering subject")
	public void user_tries_to_send_mail_without_entering_subject() {
	    gp.clickSendButton();
	}

	@Then("the email should be sent successfully without subject")
	public void the_email_should_be_sent_successfully_without_subject() {
	    Assert.assertEquals(true, gp.isConfirmationMessageDisplayed());
	}

	@When("user enters recipients emailID and subject")
	public void user_enters_recipients_email_id_and_subject() {
	    gp.enterRecipientsEmailId("recipients@gmail.com");
	    gp.enterSubject("Test");

	}

	@When("user tries to send mail without entering message in message body")
	public void user_tries_to_send_mail_without_entering_message_in_message_body() {
	    gp.clickSendButton();
	}

	@Then("the email should be sent successfully with empty message body")
	public void the_email_should_be_sent_successfully_with_empty_message_body() {
	    Assert.assertEquals(true, gp.isConfirmationMessageDisplayed());

	}

	@When("user enters recipients emailID only")
	public void user_enters_recipients_email_id_only() {
	    gp.enterRecipientsEmailId("recipients@gmail.com");

	}

	@When("user tries to send mail with empty message body and subject field")
	public void user_tries_to_send_mail_with_empty_message_body_and_subject_field() {
	    gp.clickSendButton();
	}

	@Then("alert pop up should display and user accept the popup by clicking ok button")
	public void alert_pop_up_should_display_and_user_accept_the_popup_by_clicking_ok_button() {
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}

	@Then("the email should be sent successfully with empty message body and subject")
	public void the_email_should_be_sent_successfully_with_empty_message_body_and_subject() {
	    Assert.assertEquals(true, gp.isConfirmationMessageDisplayed());
	}

	@When("user enters wrong emailID in recipients field")
	public void user_enters_wrong_email_id_in_recipients_field() {
	    gp.enterRecipientsEmailId("wrongmailID");
	}

	@When("user tries to send mail with message body and subject field")
	public void user_tries_to_send_mail_with_message_body_and_subject_field() {
	    gp.enterSubject("Test");
	    gp.enterMessageBody("Message text");
	}

	@Then("recipients address not properlly formed  pop up should display")
	public void recipients_address_not_properlly_formed_pop_up_should_display() {
	    Assert.assertEquals(true, gp.isWrongEmailIDPopupDisplay());

	}

	@When("user enter all fields")
	public void user_enter_all_fields() {
		gp.enterRecipientsEmailId("recipients@gmail.com");
	    gp.enterSubject("Test");
	    gp.enterMessageBody("Message Body");	    
	}
    
	@When("user enter subject and message in message body and click on send button without entering recipients email id")
	public void user_enter_subject_and_message_in_message_body_and_click_on_send_button_without_entering_recipients_email_id() {
	    gp.enterSubject("Test");
		gp.enterMessageBody("Message Text");
		gp.clickSendButton();
	}
	@Then("Please specify at least one recipient popup message should display")
	public void please_specify_at_least_one_recipient_popup_message_should_display() {
	    Assert.assertEquals(true, gp.isSpecifyAtLeastOneRecipientPopupDisplayed());
	}
	
}
