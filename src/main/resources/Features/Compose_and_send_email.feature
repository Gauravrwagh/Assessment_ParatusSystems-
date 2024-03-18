Feature: compose and send email in Gmail

		Background: user signin to gmail with valid emailid and password
					Given user is on login page of gmail
					When user enter emailID and clicks on next button
					And user enter password and clicks on next button
					Then user logged in successfully and navigate to gmail homepage
					And user start composing new message by clicking compose button

		Scenario: compose and send email with all neccessary fields
					Given user on new message frame and filled all fields
					When user cliks on send button
					Then the email should be sent successfully
					
		Scenario: Compose and send email without subject field
					When user enters recipients emailID and Message in message body
					And user tries to send mail without entering subject	
					Then the email should be sent successfully without subject
					
		Scenario: Compose and send email without message body
					When user enters recipients emailID and subject 
					And user tries to send mail without entering message in message body	
					Then the email should be sent successfully with empty message body
					
					

		Scenario: Compose and send email without entering subject and message body
					When user enters recipients emailID only
					And user tries to send mail with empty message body and subject field	
					Then alert pop up should display and user accept the popup by clicking ok button
					And the email should be sent successfully with empty message body and subject
		
		Scenario: Compose and send email to wrong recipients emailID
					When user enters wrong emailID in recipients field
					And user tries to send mail with message body and subject field	
					Then recipients address not properlly formed  pop up should display 
					
		Scenario: User should not compose and send an email  without entering Recipients Email Id.
					When user enter subject and message in message body and click on send button without entering recipients email id
					Then Please specify at least one recipient popup message should display
				
							
								
					
					