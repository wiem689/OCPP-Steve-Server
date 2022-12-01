package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.Data_Management;
import pageObjects.HomePage;
import pageObjects.Operations;
import pageObjects.Settings;
import pageObjects.Utils;

public class HomePageSteps {
	private static final boolean Value = false;
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode Data;
	String availType = "";
	String device_id = "";
	String connector_id;

	String key;
	String Paramater_value;
	String read_only;

	// String[] chargers_ids = new String[2];

	List<String> chargers_ids = new ArrayList<>();

	// Login
	
	public static boolean isInteger(String str) {

		if(str==null)
		{
			return false;
		}
		int length = str.length();
		
		if(length==0){
			return false;
		}
		int i=0;
		if(str.charAt(0)=='-')
		{
			if(length==1)
			{
				return false;
			}
			i=1;
		}

	for(;i<length;i++){
		char c = str.charAt(i);
		if(c <'0' || c > '9'){
			return false;
		} 
	}
		return true;

	}

	@Given("^user is on login Page$")
	public void user_is_on_login_Page() throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		driver = pageObjectManager.getDriver();
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();
	}

	@When("^the user put username$")
	public void the_user_put_username() throws Throwable {
		homePage.enter_Username();
	}

	@And("^enter password$")
	public void Enterpassword() throws InterruptedException {
		homePage.GetPasswordInput().sendKeys("1234");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@And("^I click singnin button$")
	public void click_signIn_Button() throws Throwable {
		homePage.GetSigninButton();
	}

	@Then("^the user is connected$")
	public void VerifyUserConnected() throws InterruptedException {

	}

	// LogOut

	@And("^I click LogOut$")
	public void Click_Logout() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.GetsignOutButton().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@Then("^verify signOut$")
	public void verify_singOut() throws InterruptedException {

		Assert.assertTrue(homePage.GetuserInputExist());
	}

	@Then("^user connetcted and verify logOut exist$")
	public void verify_singOut_Exist() throws InterruptedException {

		Assert.assertTrue(homePage.GetsignOutButtonsExist());
	}

	// About

	@And("^I click about button$")
	public void Click_about_button() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.GetaboutButton().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@Then("^display the about interface$")
	public void display_about_interface() throws InterruptedException {

		Assert.assertTrue(homePage.GetcontentExist());
	}

	@And("^I click on operations V1.6 button$")
	public void Click_operation_button() throws InterruptedException {

		Operations operations = new Operations(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(operations.GetaOperationButton1());
		actions.perform();
		operations.GetaOperationButton().click();

	}

	@And("^I select charge point '(.*)'$")
	public void Select_charge_point_list(String chargePointSelectList)
			throws InterruptedException, JsonMappingException, JsonProcessingException, IOException {

		Operations operations = new Operations(driver);
		if (chargePointSelectList.equalsIgnoreCase("wiem")) {
			new Select(operations.GetchargePointSelectListId()).selectByValue("JSON;wiem;-");

		} else if (chargePointSelectList.equalsIgnoreCase("wiem_pole")) {
			new Select(operations.GetchargePointSelectListId()).selectByValue("JSON;wiem_pole;-");

		} else if (chargePointSelectList.equalsIgnoreCase("wiem_pole_real")) {
			new Select(operations.GetchargePointSelectListId()).selectByValue("JSON;wiem_pole_real;-");

		}
	
	}

	@And("^I click all charge point$")
	public void Select_charge_point() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetSelectAllButton().click();

	}

	@And("^I click none charge point$")
	public void Select_none_charge_point() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetSelectNoneButton().click();
	}

	@And("^I select connecter ID as '(\\d+)'$")
	public void Select_connector_id(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetconnectorId().sendKeys(ID);
	}

	@And("^I select availability Type as '(.*)'$")
	public void Select_availability_type(String availtype) throws InterruptedException {

		this.availType = availtype;
		Operations operations = new Operations(driver);
		if (availtype.equalsIgnoreCase("INOPERATIVE")) {
			new Select(operations.GetavailType()).selectByValue("INOPERATIVE");
		} else if (availtype.equalsIgnoreCase("OPERATIVE")) {
			new Select(operations.GetavailType()).selectByValue("OPERATIVE");
		}
	}

	@And("^I click perform button change availability with Initial State as '(.*)'$")
	public void click_perform_button_change_availability_initial_state(String initState)
			throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement l = wait.until(ExpectedConditions.elementToBeClickable(By.id("connectorId")));
		l.click();
		String connector_id = l.getAttribute("value");

		JsonNode charger_Data;
		String charger_locked_state;

		if (initState.contains("-")) {
			String str[] = initState.split("-");
			List<String> initStateArray = Arrays.asList(str);

			if (chargers_ids.size() == initStateArray.size() && chargers_ids.size() >= 1) {
				System.out.println("New");
				for (int i = 0; i < initStateArray.size(); i++) {

					JsonNode charger_Data_ = objectMapper.readTree(Utils.getReported(chargers_ids.get(i)));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					String charger_locked_state_ = charger_Data_.get("locked").asText();
					System.out.println(
							"Current Connector: " + chargers_ids.get(i) + " locked State : " + charger_locked_state_);

					if (charger_locked_state_.equals(initStateArray.get(i))) {
						System.out.println("locked state equals initState");
					} else {
						if (initStateArray.get(i).equals("0")) {
							Utils.lockDevice(chargers_ids.get(i), false);
							// Thread.sleep(5000);
							// JsonNode charger_Data_after =
							// objectMapper.readTree(Utils.getReported(chargers_ids.get(i)));
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

							// Thread.sleep(5000);

							// String charger_locked_state_after =
							// charger_Data_after.get("locked").asText();
							/*
							 * System.out.println("Current Connector: " + chargers_ids.get(i) +
							 * " locked State after Change : " + charger_locked_state_after);
							 */
						} else {
							Utils.lockDevice(chargers_ids.get(i), true);
							// Thread.sleep(5000);
							// JsonNode charger_Data_after =
							// objectMapper.readTree(Utils.getReported(chargers_ids.get(i)));
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							// Thread.sleep(5000);
							// String charger_locked_state_after =
							// charger_Data_after.get("locked").asText();
							/*
							 * System.out.println("Current Connector: " + chargers_ids.get(i) +
							 * " locked State after Change : " + charger_locked_state_after);
							 */
						}

					}
				}
			}

		} else {

			if (initState.equals("0")) {

				if (connector_id.equals("0") || connector_id.equals("")) {

					if (chargers_ids.size() >= 1 && !chargers_ids.equals("null")) {

						for (String charger_id : chargers_ids) {

							//System.out.println(charger_id);

							charger_Data = objectMapper.readTree(Utils.getReported(charger_id));
							charger_locked_state = charger_Data.get("locked").asText();
							
							System.out.println(
									"Current Connector: " + charger_id + " locked State : " + charger_locked_state);

							if (charger_locked_state.equals(initState)) {
								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							} else {
								Utils.lockDevice(charger_id, false);
								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							}
						}

					}

				} else {

					charger_Data = objectMapper
							.readTree(Utils.getReported(chargers_ids.get(Integer.parseInt(connector_id) - 1)));
					charger_locked_state = charger_Data.get("locked").asText();
					
					System.out.println(
							"Current Connector: " + connector_id + " locked State : " + charger_locked_state);


					if (charger_locked_state.equals(initState)) {

						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					}

					if (!charger_locked_state.equals(initState)) {
						Utils.lockDevice(chargers_ids.get(Integer.parseInt(connector_id) - 1), false);
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					}

				}

			} else if (initState.equals("1")) {

				if (connector_id.equals("0") || connector_id.equals("")) {

					if (chargers_ids.size() >= 1 && !chargers_ids.equals("null")) {

						for (String charger_id : chargers_ids) {

							charger_Data = objectMapper.readTree(Utils.getReported(charger_id));
							charger_locked_state = charger_Data.get("locked").asText();
							
							System.out.println(
									"Current Connector: " + charger_id + " locked State : " + charger_locked_state);

							if (charger_locked_state.equals(initState)) {
								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							} else {
								Utils.lockDevice(charger_id, true);
								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							}

						}

					}

				} else {

					charger_Data = objectMapper
							.readTree(Utils.getReported(chargers_ids.get(Integer.parseInt(connector_id) - 1)));
					charger_locked_state = charger_Data.get("locked").asText();
					
					System.out.println(
							"Current Connector: " + connector_id + " locked State : " + charger_locked_state);
					
					if (charger_locked_state.equals(initState)) {

						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					}

					if (!charger_locked_state.equals(initState)) {
						Utils.lockDevice(chargers_ids.get(Integer.parseInt(connector_id) - 1), true);
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					}

				}
			}

		}
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// compare with getreported

		Thread.sleep(6000);

		if (availType.equals("OPERATIVE")) {
			if (connector_id.equals("0") || connector_id.equals("")) {

				for (String charger_id : chargers_ids) {
					Thread.sleep(3000);
					JsonNode new_charger_Data = objectMapper.readTree(Utils.getReported(charger_id));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Thread.sleep(3000);
					String new_charger_locked_state = new_charger_Data.get("locked").asText();

					if (new_charger_locked_state.equals("0")) {
						System.out.println("Connector " + charger_id + " : correct result ");
					}

					else {
						System.out.println("Connector " + charger_id + " : incorrect result ");

					}
				}

			} else {
				JsonNode new_charger_Data = objectMapper
						.readTree(Utils.getReported(chargers_ids.get(Integer.parseInt(connector_id) - 1)));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String new_charger_locked_state = new_charger_Data.get("locked").asText();
				if (new_charger_locked_state.equals("0")) {
					System.out.println(
							"Connector " + chargers_ids.get(Integer.parseInt(connector_id) - 1) + " : correct result ");
				}

				else {
					System.out.println("Connector " + chargers_ids.get(Integer.parseInt(connector_id) - 1)
							+ " : incorrect result ");

				}

			}

		}

		// INOPERATIVE

		else {

			if (connector_id.equals("0") || connector_id.equals("")) {

				for (String charger_id : chargers_ids) {
					JsonNode new_charger_Data = objectMapper.readTree(Utils.getReported(charger_id));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Thread.sleep(3000);
					String new_charger_locked_state = new_charger_Data.get("locked").asText();

					if (new_charger_locked_state.equals("1")) {
						System.out.println("Connector " + charger_id + " : correct result ");
					}

					else {
						System.out.println("Connector " + charger_id + " : incorrect result ");

					}
				}

			} else {
				JsonNode new_charger_Data = objectMapper
						.readTree(Utils.getReported(chargers_ids.get(Integer.parseInt(connector_id) - 1)));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String new_charger_locked_state = new_charger_Data.get("locked").asText();
				if (new_charger_locked_state.equals("1")) {
					System.out.println(
							"Connector " + chargers_ids.get(Integer.parseInt(connector_id) - 1) + " : correct result ");
				}

				else {
					System.out.println("Connector " + chargers_ids.get(Integer.parseInt(connector_id) - 1)
							+ " : incorrect result ");

				}

			}

		}

	}

	@Then("^User is on the task result$")
	public void VerifyUserOnTaskResult() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Operations operations = new Operations(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(operations.GetcpdExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();

	}
	
	

// *********************************************************
	// change configuration

	@And("^I select Key Type '(.*)'$")
	public void Select_Key_type(String keytype) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (keytype.equalsIgnoreCase("Predefined")) {
			new Select(operations.GetkeyTypeId()).selectByValue("PREDEFINED");
		} else if (keytype.equalsIgnoreCase("Custom")) {
			new Select(operations.GetkeyTypeId()).selectByValue("CUSTOM");
		}

	}

	@And("^I select Configuration Key '(.*)'$")
	public void Select_Configuration_Key(String configkey) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (configkey.equalsIgnoreCase("AllowOfflineTxForUnknownId")) {
			new Select(operations.GetconfKeyId()).selectByValue("AllowOfflineTxForUnknownId");
		} else if (configkey.equalsIgnoreCase("AuthorizationCacheEnabled")) {
			new Select(operations.GetconfKeyId()).selectByValue("AuthorizationCacheEnabled");
		} else if (configkey.equalsIgnoreCase("AuthorizeRemoteTxRequests")) {
			new Select(operations.GetconfKeyId()).selectByValue("AuthorizeRemoteTxRequests");
		} else if (configkey.equalsIgnoreCase("BlinkRepeat")) {
			new Select(operations.GetconfKeyId()).selectByValue("BlinkRepeat");
		} else if (configkey.equalsIgnoreCase("ClockAlignedDataInterval")) {
			new Select(operations.GetconfKeyId()).selectByValue("ClockAlignedDataInterval");
		} else if (configkey.equalsIgnoreCase("ConnectionTimeOut")) {
			new Select(operations.GetconfKeyId()).selectByValue("ConnectionTimeOut");
		} else if (configkey.equalsIgnoreCase("ConnectorPhaseRotation")) {
			new Select(operations.GetconfKeyId()).selectByValue("ConnectorPhaseRotation");
		} else if (configkey.equalsIgnoreCase("HeartbeatInterval")) {
			new Select(operations.GetconfKeyId()).selectByValue("HeartbeatInterval");
		} else if (configkey.equalsIgnoreCase("LightIntensity")) {
			new Select(operations.GetconfKeyId()).selectByValue("LightIntensity");
		} else if (configkey.equalsIgnoreCase("LocalAuthListEnabled")) {
			new Select(operations.GetconfKeyId()).selectByValue("LocalAuthListEnabled");
		} else if (configkey.equalsIgnoreCase("LocalAuthorizeOffline")) {
			new Select(operations.GetconfKeyId()).selectByValue("LocalAuthorizeOffline");
		} else if (configkey.equalsIgnoreCase("LocalPreAuthorize")) {
			new Select(operations.GetconfKeyId()).selectByValue("LocalPreAuthorize");
		} else if (configkey.equalsIgnoreCase("MaxEnergyOnInvalidId")) {
			new Select(operations.GetconfKeyId()).selectByValue("MaxEnergyOnInvalidId");
		} else if (configkey.equalsIgnoreCase("MeterValueSampleInterval")) {
			new Select(operations.GetconfKeyId()).selectByValue("MeterValueSampleInterval");
		} else if (configkey.equalsIgnoreCase("MeterValuesAlignedData")) {
			new Select(operations.GetconfKeyId()).selectByValue("MeterValuesAlignedData");
		} else if (configkey.equalsIgnoreCase("MeterValuesSampledData")) {
			new Select(operations.GetconfKeyId()).selectByValue("MeterValuesSampledData");
		} else if (configkey.equalsIgnoreCase("MinimumStatusDuration")) {
			new Select(operations.GetconfKeyId()).selectByValue("MinimumStatusDuration");
		} else if (configkey.equalsIgnoreCase("ResetRetries")) {
			new Select(operations.GetconfKeyId()).selectByValue("ResetRetries");
		} else if (configkey.equalsIgnoreCase("StopTransactionOnEVSideDisconnect")) {
			new Select(operations.GetconfKeyId()).selectByValue("StopTransactionOnEVSideDisconnect");
		} else if (configkey.equalsIgnoreCase("StopTransactionOnInvalidId")) {
			new Select(operations.GetconfKeyId()).selectByValue("StopTransactionOnInvalidId");
		} else if (configkey.equalsIgnoreCase("StopTxnAlignedData")) {
			new Select(operations.GetconfKeyId()).selectByValue("StopTxnAlignedData");
		} else if (configkey.equalsIgnoreCase("StopTxnSampledData")) {
			new Select(operations.GetconfKeyId()).selectByValue("StopTxnSampledData");
		} else if (configkey.equalsIgnoreCase("TransactionMessageAttempts")) {
			new Select(operations.GetconfKeyId()).selectByValue("TransactionMessageAttempts");
		} else if (configkey.equalsIgnoreCase("TransactionMessageRetryInterval")) {
			new Select(operations.GetconfKeyId()).selectByValue("TransactionMessageRetryInterval");
		} else if (configkey.equalsIgnoreCase("UnlockConnectorOnEVSideDisconnect")) {
			new Select(operations.GetconfKeyId()).selectByValue("UnlockConnectorOnEVSideDisconnect");
		} else if (configkey.equalsIgnoreCase("WebSocketPingInterval")) {
			new Select(operations.GetconfKeyId()).selectByValue("WebSocketPingInterval");
		}

		// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Value '(.*)'$")
	public void enter_value(String value) throws InterruptedException {

		if (read_only.equals("false")) {

			if (Paramater_value.equals("true") || Paramater_value.equals("false")) {
				if (value.equals("true") || value.equals("false")) {

					System.out.println(key + " Entered Value Type is Correct (Boolean) ");

				} else {
					System.out.println(key + " Entered Value Type is Wrong");
				}

			} else {
				if (key.equals("BlinkRepeat")) {
					
					if(isInteger(value))
					{
						if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 5) {
							System.out.println(key + " Entered Value invalid Range ) ");

						} else {
							System.out.println(key + " Entered Value Type is Correct (on the correcte range 0 -> 5 ");

						}
					}else
					{
						System.out.println(key + " Entered Value Type is Wrong ) ");

					}


				} else if (key.equals("ClockAlignedDataInterval") || key.equals("HeartbeatInterval")
						|| key.equals("MeterValueSampleInterval") || key.equals("MinimumStatusDuration")
						|| key.equals("TransactionMessageRetryInterval") || key.equals("WebSocketPingInterval")) {
					
					if(isInteger(value))
					{
						if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 86400) {
							System.out.println(key + " Entered Value invalid Range ");

						} else {
							System.out.println(
									key + " Entered Value Type is Correct (on the correcte range 0 -> 86400 )");

						}
						
					}else
					{
						System.out.println(key + " Entered Value Type is Wrong ) ");

					}
					

				} else if (key.equals("ConnectionTimeOut")) {
					

					if(isInteger(value))
					{
						if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 120) {
							System.out.println(key + " Entered Value invalid Range ");

						} else {
							System.out.println(key + " Entered Value Type is Correct (on the correcte range )");

						}
					}else
					{
						System.out.println(key + " Entered Value Type is Wrong ) ");

					}

					

				} else if (key.equals("LightIntensity")) {
					if(isInteger(value))
					{
						if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 100) {
							System.out.println(key + " Entered Value invalid Range ");

						} else {
							System.out
									.println(key + " Entered Value Type is Correct (on the correcte range  0 -> 100) ");

						}
					}else
					{
						System.out.println(key + " Entered Value Type is Wrong ) ");

					}
					

				} else if (key.equals("MaxEnergyOnInvalidId")) {
					if(isInteger(value))
					{
						if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 30000) {
							System.out.println(key + " Entered Value invalid Range ");

						} else {
							System.out.println(
									key + " Entered Value Type is Correct (on the correcte range 0 -> 30000 ) ");

						}
					}else
					{
						System.out.println(key + " Entered Value Type is Wrong ) ");

					}
					

				} else if (key.equals("ResetRetries") || key.equals("TransactionMessageAttempts")) {
					if(isInteger(value))
					{
						if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 30) {

							System.out.println(key + " Entered Value invalid Range ");

						} else {
							System.out.println(key + " Entered Value Type is Correct (on the correcte range 0 -> 30 )");
						}
					}else
					{
						System.out.println(key + " Entered Value Type is Wrong ) ");

					}
					
					
				}
			}
		}

		Operations operations = new Operations(driver);
		operations.GetvalueId().sendKeys(value);

	} 

	// vérifier comma separated list

	@And("^I enter Custom Configuration Key '(.*)'$")
	public void enter_costum_config_key(String constumConfig) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetcustomConfKeyId().sendKeys(constumConfig);
	}

	@And("^I click change configuration$")
	public void change_configuration() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetchangeConfigButton().click();
	}

	@And("^I click perform button change configuration$")
	public void click_perform_button_change_configuration() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Then("^User is on the task result Transaction$")
	public void VerifyUserOnTaskResultTransaction() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Operations operations = new Operations(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(operations.GetcpdExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/table/tbody/tr"));
		
		for (WebElement row : rows) {
			if (row.findElement(By.xpath("td[2]")).getText().equals("Accepted")) {
				
				System.out.println("Correct rslt : The result is Accepted");
				
				}else if (row.findElement(By.xpath("td[2]")).getText().equals("Rejected"))  {
					
					System.out.println("Incorrecte rslt : The result is Rejected");
				}
			}

	}
	
	@Then("^User is on the task result after stop transaction$")
	public void VerifyUserOnTaskResultAfterStop() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Operations operations = new Operations(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(operations.GetcpdExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/table/tbody/tr"));
		System.out.println("Table size :" + rows.size());
		for (WebElement row : rows) {
			if (row.findElement(By.xpath("td[2]")).getText().equals("Accepted")) {
				
				System.out.println("Correct rslt : The result is Accepted");
				
				}else if (row.findElement(By.xpath("td[2]")).getText().equals("Rejected"))  {
					
					System.out.println("Incorrecte rslt : The result is Rejected");
				}
			}

		Thread.sleep(5000);
	}
	

//**********************************************************************************************
	// Get Diagnostics

	@And("^I enter Location '(.*)'$")
	public void enter_Location(String location) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetlocationId().sendKeys(location);
	}

	@And("^I enter Retries '(.*)'$")
	public void enter_Retries(String retries) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetretriesId().sendKeys(retries);
	}

	@And("^I enter Retry Interval  '(.*)'$")
	public void enter_Retry_Interval(String retryInterval) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetretryIntervalId().sendKeys(retryInterval);
	}

	@And("^I enter Start Date '(.*)'$")
	public void enter_Start_Date(String startDate) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetstartId().sendKeys(startDate);
	}

	@And("^I enter Stop Date '(.*)'$")
	public void enter_Stop_Date(String stopDate) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetstopId().sendKeys(stopDate);
	}

	@And("^I click get Diagnostics$")
	public void get_Diagnostics() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetgetDiagnosticsButton().click();
	}

	@And("^I click diagnostics perform button$")
	public void click_Diagnostics_perform_button() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetgetDiagnosticsButton().click();
	}

	@Then("^User is on the task result diagnostics$")
	public void VerifyUserOnTaskResultDiagnostics() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Operations operations = new Operations(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(operations.GetresExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

//******************************************************************************************************************
	// remote start transaction
	
	@And("^I click on all connector status$")
	public void Select_All_Connector_Status() throws InterruptedException {
		
		
	
        Data_Management dataManagement = new Data_Management(driver);
        dataManagement.GetConnectorStatusButton().click();
        
        
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"connectorStatusTable\"]/tbody/tr[1]"));
	
		for (WebElement row : rows) {
			if (row.findElement(By.xpath("td[4]")).getText().equals("Preparing")) {
				
				System.out.println("Preparing : 60s time out connection ");
				
				}else if (row.findElement(By.xpath("td[4]")).getText().equals("Charging"))  {
					
					System.out.println("Charging : the car already Charging ");
				}else if (row.findElement(By.xpath("td[4]")).getText().equals("	Available"))  {
					
					System.out.println("Available : the connector is available to be PluggedIn ");
				}else if (row.findElement(By.xpath("td[4]")).getText().equals("Unavailable"))  {
					
					System.out.println("Unavailable : Connector Unavailable");
				}
			}
		Thread.sleep(62000);
        
	}

	
	

	@And("^I select ConnectorId2 '(.*)'$")
	public void Select_ConnectorId2(String connectorID2) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (connectorID2.equalsIgnoreCase("Not for a specific connector")) {
			new Select(operations.GetconnectorId2()).selectByValue("0");
		} else if (connectorID2.equalsIgnoreCase("1")) {
			new Select(operations.GetconnectorId2()).selectByValue("1");
		} else if (connectorID2.equalsIgnoreCase("2")) {
			new Select(operations.GetconnectorId2()).selectByValue("2");
		}

	}

	@And("^I select OCPP ID Tag'(.*)'$")
	public void Select_OCPP_ID_Tag(String ocppId) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (ocppId.equalsIgnoreCase("040f0032")) {
			new Select(operations.GetidTagId()).selectByValue("040f0032");
		} else if (ocppId.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
			new Select(operations.GetidTagId()).selectByValue("7250939c52dc4d7cb59c");
		} else if (ocppId.equalsIgnoreCase("5c5e6ada")) {
			new Select(operations.GetidTagId()).selectByValue("5c5e6ada");
		} else if (ocppId.equalsIgnoreCase("9c756eda")) {
			new Select(operations.GetidTagId()).selectByValue("9c756eda");
		}
	}

	@And("^I click get remote start transaction$")
	public void get_remote_start_transaction() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetremotestarttransactionButton().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select ID of the Active Transaction$")
	public void Select_ID_Active_Transaction() throws InterruptedException {
		Thread.sleep(5000);
		Operations operations = new Operations(driver);

		operations.GettransactionId().click();

	}

	@And("^I click get remote stop transaction$")
	public void get_remote_stop_transaction() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetremotestoptransactionButton().click();
	}

	@And("^I click remote start transaction perform button'(.*)'$")
	public void click_remote_start_transaction_perform_button(String initState)
			throws InterruptedException, JsonMappingException, JsonProcessingException, IOException {
        
		// JYLP6Y : TRYDAN
		// JsonNode charger_Data_ =
		// objectMapper.readTree(Utils.getReported(chargers_ids.get(i)));
		JsonNode charge_state = objectMapper.readTree(Utils.GetCurrentStateCharge(chargers_ids.get(0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		JsonNode charger_Data;
		String charger_locked_state;
	

		String charge_state_variable = charge_state.get("charge_state").toString();
		String charge_seconds = charge_state.get("seconds").toString();
		
		String charge_state_variable2 = charge_state_variable.replaceAll("^\"|\"$", "");
		String charge_seconds2 = charge_seconds.replaceAll("^\"|\"$", "");
		
		
		Thread.sleep(3000);
		
          System.out.println(
				"Data before Start Remote Transaction: \n charge_state : " + charge_state_variable + "| seconds : " + charge_seconds);
        
        	  
          Thread.sleep(3000);
          if(isInteger(charge_state_variable2) && isInteger(charge_seconds2))
          {

      		if (Integer.parseInt(charge_state_variable2) == 0 ) {
      			System.out.println("Current Connector Not Occupied");
      		} 
      		
      		else if (Integer.parseInt(charge_state_variable2) == 1 && Integer.parseInt(charge_seconds2) == 0) {
    			System.out.println("Current Connector Occupied And Not Charging");

    		} else if (Integer.parseInt(charge_state_variable2) == 1 && Integer.parseInt(charge_seconds2) > 0) {

    			System.out.println("Problem with charging seconds");
    		}

    		if (Integer.parseInt(charge_state_variable2) == 2 && Integer.parseInt(charge_seconds2) == 0) {
    			System.out.println("Problem with charging");

    		} else if (Integer.parseInt(charge_state_variable2) == 2 && Integer.parseInt(charge_seconds2) > 0) {

    			System.out.println("Current Connector Occupied And Charging");
    		}
    		
    		   
          }else
             {
           	  System.out.println("Charge state or charge seconds type incorrect");
             }
          
         
          
          
          JsonNode charger_Data_ = objectMapper.readTree(Utils.getReported(chargers_ids.get(0)));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			String charger_locked_state_ = charger_Data_.get("locked").asText();
			System.out.println(
					"Current Connector: " + chargers_ids.get(0) + " locked State : " + charger_locked_state_);

          

		if (charger_locked_state_.equals(initState)) {
							System.out.println("locked state equals initState");
						} else {
								Utils.lockDevice(chargers_ids.get(0), true);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
			
						}
		
		if(isInteger(charge_state_variable2) ) {
		 if(Integer.parseInt(charge_state_variable2)== 2 ) {
	  			
	  			System.out.println("the result should be Rejected:  Connector is already charging with another OCPP ID ");
	  			
	  		} else if(initState.equals("1")) {
	  			
	  			System.out.println("the result should be Rejected: Connector is Unvailable ");
	  			
	  		}else{
	  			System.out.println("the result should be Accepted : the connector not connected with any OCPP Id and it will start to charging ");
	  			
	  		}
		 } 
		
	          
	
		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		
		Thread.sleep(3000);

		JsonNode charge_state_after = objectMapper.readTree(Utils.GetCurrentStateCharge(chargers_ids.get(0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String charge_state_variable_after = charge_state_after.get("charge_state").toString();
		String charge_seconds_after = charge_state_after.get("seconds").toString();
		System.out.println("Data after Start click Remote Transaction: \n charge_state : " + charge_state_variable_after + "| seconds : "
				+ charge_seconds_after);
		
		Thread.sleep(7000);
		
	}

	@And("^I click remote stop transaction perform button$")
	public void click_remote_stop_transaction_perform_button()
			throws InterruptedException, JsonMappingException, JsonProcessingException, IOException {

		JsonNode charge_state = objectMapper.readTree(Utils.GetCurrentStateCharge(chargers_ids.get(0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String charge_state_variable = charge_state.get("charge_state").toString();
		String charge_seconds = charge_state.get("seconds").toString();
		
		String charge_state_variable2 = charge_state_variable.replaceAll("^\"|\"$", "");
		String charge_seconds2 = charge_seconds.replaceAll("^\"|\"$", "");

		System.out.println(
				"Data before Stop Remote Transaction : \n charge_state : " + charge_state_variable + "| seconds : " + charge_seconds);

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		
		Thread.sleep(4000);

		JsonNode charge_state_after = objectMapper.readTree(Utils.GetCurrentStateCharge(chargers_ids.get(0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String charge_state_variable_after = charge_state_after.get("charge_state").toString();
		String charge_seconds_after = charge_state_after.get("seconds").toString();
   
		String charge_state_variable_after2 = charge_state_variable_after.replaceAll("^\"|\"$", "");
		String charge_seconds_after2 = charge_seconds_after.replaceAll("^\"|\"$", "");
	 
		 Thread.sleep(3000);

		System.out.println("Data After Stop Remote Transaction : \n charge_state : " + charge_state_variable_after + "| seconds : "
				+ charge_seconds_after);
		
		if(isInteger(charge_state_variable_after2) && isInteger(charge_seconds_after2))
        {
		
		if (Integer.parseInt(charge_state_variable_after2) == 0 ) {
			System.out.println("Resultt should be Accepted  : Stop Transaction Sucess");
		}
		
		
		}  else {
			System.out.println("Result should be Rejected : Stop Transaction Failure");
		}
		

	}

	@Then("^User is on the task result Configuration$")
	public void VerifyUserOnTaskResultConfiguration() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Operations operations = new Operations(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(operations.GetcpdExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// Reset

	@And("^I select Reset Type'(.*)'$")
	public void Select_Reset_Type(String resetType) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (resetType.equalsIgnoreCase("HARD")) {
			new Select(operations.GetresetTypeId()).selectByValue("HARD");
		} else if (resetType.equalsIgnoreCase("SOFT")) {
			new Select(operations.GetresetTypeId()).selectByValue("SOFT");
		}
	}
	

	@And("^I click get remote reset$")
	public void get_reset() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetresetButton().click();
	}

	@And("^I click reset perform button$")
	public void click_reset_perform_button() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
	}

	// unlock connector

	@And("^I click get Unlock Connector$")
	public void get_Unlock_Connector() throws InterruptedException {
		Operations operations = new Operations(driver);
		operations.GetUnlockConnectorButton().click();
	}

	@And("^I click unlock connector perform button$")
	public void click_unlock_connector_perform_button() throws InterruptedException, JsonMappingException, JsonProcessingException, IOException {

		JsonNode charge_state = objectMapper.readTree(Utils.GetCurrentStateCharge(chargers_ids.get(0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String charge_state_variable = charge_state.get("charge_state").toString();
		String charge_seconds = charge_state.get("seconds").toString();
		
		String charge_state_variable2 = charge_state_variable.replaceAll("^\"|\"$", "");
		String charge_seconds2 = charge_seconds.replaceAll("^\"|\"$", "");

		System.out.println(
				"Data before Unlock Connector : \n charge_state : " + charge_state_variable + "| seconds : " + charge_seconds);

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		
		Thread.sleep(4000);

		JsonNode charge_state_after = objectMapper.readTree(Utils.GetCurrentStateCharge(chargers_ids.get(0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String charge_state_variable_after = charge_state_after.get("charge_state").toString();
		String charge_seconds_after = charge_state_after.get("seconds").toString();
   
		String charge_state_variable_after2 = charge_state_variable_after.replaceAll("^\"|\"$", "");
		String charge_seconds_after2 = charge_seconds_after.replaceAll("^\"|\"$", "");
	 
		 Thread.sleep(3000);

		System.out.println("Data After Unlock Connector : \n charge_state : " + charge_state_variable_after + "| seconds : "
				+ charge_seconds_after);
		
		if(isInteger(charge_state_variable_after2) && isInteger(charge_seconds_after2))
        {
		
		if (Integer.parseInt(charge_state_variable_after2) == 0 ) {
			System.out.println("Resultt should be Unlocked  : Unlock Connector Sucess");
		}
		
		
		}  else {
			System.out.println("Result should be Rejected : Unlock Connector Failure");
		}
		

	}
	
	
	@Then("^User is on the task result Unlock Transaction$")
	public void VerifyUserOnTaskResultAfterUnlock() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Operations operations = new Operations(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(operations.GetcpdExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/table/tbody/tr"));
		System.out.println("Table size :" + rows.size());
		for (WebElement row : rows) {
			if (row.findElement(By.xpath("td[2]")).getText().equals("Unlocked")) {
				
				System.out.println("Correct rslt : The result is Unlocked");
				
				}else if (row.findElement(By.xpath("td[2]")).getText().equals("Rejected"))  {
					
					System.out.println("Incorrecte rslt : The result is Rejected");
				}
			}

		Thread.sleep(5000);
	}
	
	
	

	// Update Firmware

	@And("^I click get Update Firmware$")
	public void get_Update_Firmware() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetUpdateFirmwareButton().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Retrieve Date '(.*)'$")
	public void enter_Retrieve_Date(String retrieveDate) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetretrieveId().sendKeys(retrieveDate);
	}

	@And("^I click perform button Update Firmware$")
	public void perform_Button_Update_Firmware() throws InterruptedException {

		
		Operations operations = new Operations(driver);
		operations.GetperformUpdateFirmwareButton();
	}

	// Reservation Now

	@And("^I click reservation now$")
	public void get_Reservation_Now() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetReserveNowButton().click();
	}

	@And("^I enter expiry Date '(.*)'$")
	public void enter_Expiry_Date(String expiryDate) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetexpiryId().sendKeys(expiryDate);
	}

	@And("^I click cancel reservation$")
	public void get_Cancel_Reservation() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetCancelReservationButton().click();
	}

	@And("^I select Existing Reservation '(.*)'$")
	public void Select_Existing_Reservation(String existingReservation) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (existingReservation.equalsIgnoreCase("")) {
			new Select(operations.GetreservationId()).selectByValue("");
		}

	}

	@And("^I click perform reservation button$")
	public void perform_Button_Reservation() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetperformReservationButton().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click perform cancel reservation button$")
	public void perform_Button_Cancel_Reservation() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetperformCancelReservationButton().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	// Data Transfer

	@And("^I Enter Vendor ID '(.*)'$")
	public void Select_vendor_id(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetvendorId().sendKeys(ID);
	}

	@And("^I Enter Message ID '(.*)'$")
	public void Select_Message_id(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetmessageId().sendKeys(ID);
	}

	@And("^I Enter Data '(.*)'$")
	public void Select_Data(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetdataId().sendKeys(ID);
	}

	@And("^I click data transfer$")
	public void get_data_transfer() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetDataTransferButton().click();
	}

	@And("^I click perform button data transfer$")
	public void click_perform_button_data_transfer() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Get Configuration

	@And("^I click get configuration$")
	public void get_configuration() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetConfigurationButton().click();
	}

	@And("^I click all parameters$")
	public void Select_parameters() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetSelectAllButton2().click();
	}

	@And("^I click none parameters$")
	public void Select_none_parameters() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetSelectNoneButton2().click();
	}

	@And("^I select parameters '(.*)'$")
	public void Select_Parameters_List(String parametersSelectList) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (parametersSelectList.equalsIgnoreCase("AllowOfflineTxForUnknownId")) {
			new Select(operations.GetconfKeyListId()).selectByValue("AllowOfflineTxForUnknownId");

		}
		if (parametersSelectList.equalsIgnoreCase("AuthorizationCacheEnabled")) {
			new Select(operations.GetconfKeyListId()).selectByValue("AuthorizationCacheEnabled");

		}
		if (parametersSelectList.equalsIgnoreCase("AuthorizeRemoteTxRequests")) {
			new Select(operations.GetconfKeyListId()).selectByValue("AuthorizeRemoteTxRequests");

		}
		if (parametersSelectList.equalsIgnoreCase("BlinkRepeat")) {
			new Select(operations.GetconfKeyListId()).selectByValue("BlinkRepeat");

		}
		if (parametersSelectList.equalsIgnoreCase("ChargeProfileMaxStackLevel")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ChargeProfileMaxStackLevel");

		}
		if (parametersSelectList.equalsIgnoreCase("ChargingScheduleAllowedChargingRateUnit")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ChargingScheduleAllowedChargingRateUnit");

		}
		if (parametersSelectList.equalsIgnoreCase("ChargingScheduleMaxPeriods")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ChargingScheduleMaxPeriods");

		}
		if (parametersSelectList.equalsIgnoreCase("ClockAlignedDataInterval")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ClockAlignedDataInterval");

		}
		if (parametersSelectList.equalsIgnoreCase("ConnectionTimeOut")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ConnectionTimeOut");

		}
		if (parametersSelectList.equalsIgnoreCase("ConnectorPhaseRotation")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ConnectorPhaseRotation");

		}
		if (parametersSelectList.equalsIgnoreCase("ConnectorPhaseRotationMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ConnectorPhaseRotationMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("ConnectorSwitch3to1PhaseSupported")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ConnectorSwitch3to1PhaseSupported");

		}
		if (parametersSelectList.equalsIgnoreCase("GetConfigurationMaxKeys")) {
			new Select(operations.GetconfKeyListId()).selectByValue("GetConfigurationMaxKeys");

		}
		if (parametersSelectList.equalsIgnoreCase("HeartbeatInterval")) {
			new Select(operations.GetconfKeyListId()).selectByValue("HeartbeatInterval");

		}
		if (parametersSelectList.equalsIgnoreCase("LightIntensity")) {
			new Select(operations.GetconfKeyListId()).selectByValue("LightIntensity");

		}
		if (parametersSelectList.equalsIgnoreCase("LocalAuthListEnabled")) {
			new Select(operations.GetconfKeyListId()).selectByValue("LocalAuthListEnabled");

		}
		if (parametersSelectList.equalsIgnoreCase("LocalAuthListMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("LocalAuthListMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("LocalAuthorizeOffline")) {
			new Select(operations.GetconfKeyListId()).selectByValue("LocalAuthorizeOffline");

		}
		if (parametersSelectList.equalsIgnoreCase("LocalPreAuthorize")) {
			new Select(operations.GetconfKeyListId()).selectByValue("LocalPreAuthorize");

		}
		if (parametersSelectList.equalsIgnoreCase("MaxChargingProfilesInstalled")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MaxChargingProfilesInstalled");

		}
		if (parametersSelectList.equalsIgnoreCase("MaxEnergyOnInvalidId")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MaxEnergyOnInvalidId");

		}
		if (parametersSelectList.equalsIgnoreCase("MeterValueSampleInterval")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MeterValueSampleInterval");

		}
		if (parametersSelectList.equalsIgnoreCase("MeterValuesAlignedData")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesAlignedData");

		}
		if (parametersSelectList.equalsIgnoreCase("MeterValuesAlignedDataMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesAlignedDataMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("MeterValuesSampledData")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesSampledData");

		}
		if (parametersSelectList.equalsIgnoreCase("MeterValuesSampledDataMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesSampledDataMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("MinimumStatusDuration")) {
			new Select(operations.GetconfKeyListId()).selectByValue("MinimumStatusDuration");

		}
		if (parametersSelectList.equalsIgnoreCase("NumberOfConnectors")) {
			new Select(operations.GetconfKeyListId()).selectByValue("NumberOfConnectors");

		}
		if (parametersSelectList.equalsIgnoreCase("ReserveConnectorZeroSupported")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ReserveConnectorZeroSupported");

		}
		if (parametersSelectList.equalsIgnoreCase("ResetRetries")) {
			new Select(operations.GetconfKeyListId()).selectByValue("ResetRetries");

		}
		if (parametersSelectList.equalsIgnoreCase("SendLocalListMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("SendLocalListMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("StopTransactionOnEVSideDisconnect")) {
			new Select(operations.GetconfKeyListId()).selectByValue("StopTransactionOnEVSideDisconnect");

		}
		if (parametersSelectList.equalsIgnoreCase("StopTransactionOnInvalidId")) {
			new Select(operations.GetconfKeyListId()).selectByValue("StopTransactionOnInvalidId");

		}
		if (parametersSelectList.equalsIgnoreCase("StopTxnAlignedData")) {
			new Select(operations.GetconfKeyListId()).selectByValue("StopTxnAlignedData");

		}
		if (parametersSelectList.equalsIgnoreCase("StopTxnAlignedDataMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("StopTxnAlignedDataMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("StopTxnSampledData")) {
			new Select(operations.GetconfKeyListId()).selectByValue("StopTxnSampledData");

		}
		if (parametersSelectList.equalsIgnoreCase("StopTxnSampledDataMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("StopTxnSampledDataMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("SupportedFeatureProfiles")) {
			new Select(operations.GetconfKeyListId()).selectByValue("SupportedFeatureProfiles");

		}
		if (parametersSelectList.equalsIgnoreCase("SupportedFeatureProfilesMaxLength")) {
			new Select(operations.GetconfKeyListId()).selectByValue("SupportedFeatureProfilesMaxLength");

		}
		if (parametersSelectList.equalsIgnoreCase("SupportedFileTransferProtocols")) {
			new Select(operations.GetconfKeyListId()).selectByValue("SupportedFileTransferProtocols");

		}
		if (parametersSelectList.equalsIgnoreCase("TransactionMessageAttempts")) {
			new Select(operations.GetconfKeyListId()).selectByValue("TransactionMessageAttempts");

		}
		if (parametersSelectList.equalsIgnoreCase("TransactionMessageRetryInterval")) {
			new Select(operations.GetconfKeyListId()).selectByValue("TransactionMessageRetryInterval");

		}
		if (parametersSelectList.equalsIgnoreCase("UnlockConnectorOnEVSideDisconnect")) {
			new Select(operations.GetconfKeyListId()).selectByValue("UnlockConnectorOnEVSideDisconnect");

		}
		if (parametersSelectList.equalsIgnoreCase("WebSocketPingInterval")) {
			new Select(operations.GetconfKeyListId()).selectByValue("WebSocketPingInterval");

		}

		// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I Enter Custom Config Key '(.*)'$")
	public void Select_Custom_Config(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetcommaSeparatedCustomConfKeysId().sendKeys(ID);
	}

	@And("^I click perform button get Configuration$")
	public void click_perform_button_get_configuration() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Then("^I click details button get Configuration$")
	public void click_details_button_get_configuration() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetGetDetailsConf().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		key = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/table/tbody/tr/td[1]")).getText();
		Paramater_value = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/table/tbody/tr/td[2]"))
				.getText();
		read_only = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/table/tbody/tr/td[3]")).getText();

		if (read_only.equals("true")) {
			System.out.println(key + " is read-only it wont be changed !");
		}

	}

	@Then("^I click details button get Configuration after change$")
	public void click_details_button_get_configuration_After_Change() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetGetDetailsConf().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		String value_new = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/table/tbody/tr/td[2]"))
				.getText();
		

		if (value_new.equals(Paramater_value)) {
			System.out.println(key + " Value is not changed !");
		} else {
			System.out.println(
					key + " Value is changed !  Old value : " + Paramater_value + " | New Value : " + value_new);
		}

		driver.close();

	}

	// Get Local List Version

	@And("^I click get Local List Version$")
	public void get_Local_List() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetLocalListVersionButton().click();

	}

	@And("^I click perform button get local list version$")
	public void click_perform_button_get_local_list_version() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

	// set local list version

	@And("^I click set Local List Version$")
	public void set_Local_List() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.SetLocalListVersionButton().click();

	}

	@And("^I Enter List Version '(.*)'$")
	public void Select_List_Version(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetlistVersionId().sendKeys(ID);
	}

	@And("^I select Get Update Type'(.*)'$")
	public void Select_Update_Type(String updateType) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (updateType.equalsIgnoreCase("DIFFERENTIAL")) {
			new Select(operations.GetupdateTypeId()).selectByValue("DIFFERENTIAL");
		} else if (updateType.equalsIgnoreCase("FULL")) {
			new Select(operations.GetupdateTypeId()).selectByValue("FULL");
		}

	}
	
	

	@And("^I select Add Update List '(.*)'$")
	public void Select_Add_Update_list(String addUpdaterList) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (addUpdaterList.equalsIgnoreCase("040f0032")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("040f0032");

		}
		if (addUpdaterList.equalsIgnoreCase("4b1f32bb")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("4b1f32bb");

		}
		if (addUpdaterList.equalsIgnoreCase("5392461f")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("5392461f");

		}
		if (addUpdaterList.equalsIgnoreCase("5c5e6ada")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("5c5e6ada");

		}
		if (addUpdaterList.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("7250939c52dc4d7cb59c");

		}
		if (addUpdaterList.equalsIgnoreCase("9c756eda")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("9c756eda");

		}
		if (addUpdaterList.equalsIgnoreCase("A0-00-00-00")) {
			new Select(operations.GetaddUpdateListId()).selectByValue("A0-00-00-00");

		}

	}

	@And("^I select Delete List '(.*)'$")
	public void Select_Delete_list(String deleteList) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (deleteList.equalsIgnoreCase("040f0032")) {
			new Select(operations.GetdeleteListId()).selectByValue("040f0032");

		}
		if (deleteList.equalsIgnoreCase("4b1f32bb")) {
			new Select(operations.GetdeleteListId()).selectByValue("4b1f32bb");

		}
		if (deleteList.equalsIgnoreCase("5392461f")) {
			new Select(operations.GetdeleteListId()).selectByValue("5392461f");

		}
		if (deleteList.equalsIgnoreCase("5c5e6ada")) {
			new Select(operations.GetdeleteListId()).selectByValue("5c5e6ada");

		}
		if (deleteList.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
			new Select(operations.GetdeleteListId()).selectByValue("7250939c52dc4d7cb59c");

		}
		if (deleteList.equalsIgnoreCase("9c756eda")) {
			new Select(operations.GetdeleteListId()).selectByValue("9c756eda");

		}
		if (deleteList.equalsIgnoreCase("A0-00-00-00")) {
			new Select(operations.GetdeleteListId()).selectByValue("A0-00-00-00");

		}

	}
	
	@And("^I click send empty list$")
	public void send_Empty_List() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetsendEmptyListWhenFullId().click();
	}

	@And("^I click perform button set local list version$")
	public void click_perform_button_set_local_list_version() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Trigger Message

	@And("^I click Get Trigger Message$")
	public void get_Trigger_Message() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetTriggerMessageButton().click();
	}

	@And("^I select Trigger Message '(.*)'$")
	public void Select_Trigger_Message(String triggerMessage) throws InterruptedException {

		Operations operations = new Operations(driver);
		if (triggerMessage.equalsIgnoreCase("BootNotification")) {
			new Select(operations.GettriggerMessageId()).selectByValue("BootNotification");

		}
		if (triggerMessage.equalsIgnoreCase("DiagnosticsStatusNotification")) {
			new Select(operations.GettriggerMessageId()).selectByValue("DiagnosticsStatusNotification");

		}
		if (triggerMessage.equalsIgnoreCase("FirmwareStatusNotification")) {
			new Select(operations.GettriggerMessageId()).selectByValue("FirmwareStatusNotification");

		}
		if (triggerMessage.equalsIgnoreCase("Heartbeat")) {
			new Select(operations.GettriggerMessageId()).selectByValue("Heartbeat");

		}
		if (triggerMessage.equalsIgnoreCase("MeterValues")) {
			new Select(operations.GettriggerMessageId()).selectByValue("MeterValues");

		}
		if (triggerMessage.equalsIgnoreCase("StatusNotification")) {
			new Select(operations.GettriggerMessageId()).selectByValue("StatusNotification");

		}

	}

	@And("^I click perform button put trigger msg$")
	public void click_perform_button_put_trigger_msg() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Get Composite Schedule

	@And("^I Enter Composite Schedule '(.*)'$")
	public void Select_Composite_Schedule(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetdurationInSecondsId().sendKeys(ID);
	}

	@And("^I select Charging Rate Unit '(.*)'$")
	public void Select_Charging_Rate_Unit(String chargingRate) throws InterruptedException {

		Operations operations = new Operations(driver);

		if (chargingRate.equalsIgnoreCase("-- Empty --")) {
			new Select(operations.GetchargingRateUnitId()).selectByValue("");

		}
		if (chargingRate.equalsIgnoreCase("W")) {
			new Select(operations.GetchargingRateUnitId()).selectByValue("W");

		}
		if (chargingRate.equalsIgnoreCase("A")) {
			new Select(operations.GetchargingRateUnitId()).selectByValue("A");

		}

	}

	@And("^I click Get Composite Schedule$")
	public void get_Composite_Schedule() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetCompositeButton().click();
	}

	@And("^I click perform button get composite schedule$")
	public void click_perform_button_get_composite_schedule() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.Getsubmitbutton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	// Clear Charging Profile

	@And("^I click Clear Charging Profile$")
	public void get_Clear_Charging_Profile() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetClearChargingButton().click();
	}

	@And("^I select Filter Type '(.*)'$")
	public void Select_Filter_Type(String filterType) throws InterruptedException {

		Operations operations = new Operations(driver);

		if (filterType.equalsIgnoreCase("ChargingProfileId")) {
			new Select(operations.GetfilterTypeId()).selectByValue("ChargingProfileId");

		}
		if (filterType.equalsIgnoreCase("OtherParameters")) {
			new Select(operations.GetfilterTypeId()).selectByValue("OtherParameters");

		}
	}

	@And("^I select Charging Profile ID '(.*)'$")
	public void Select_Charging_Profile(String chargingProfile) throws InterruptedException {

		Operations operations = new Operations(driver);

		if (chargingProfile.equalsIgnoreCase("")) {
			new Select(operations.GetchargingProfilePkId()).selectByValue("");

		}
		if (chargingProfile.equalsIgnoreCase("")) {
			new Select(operations.GetchargingProfilePkId()).selectByValue("");

		}
	}

	@And("^I select Charging Profile Purpose '(.*)'$")
	public void Select_Charging_Profile_Purpose(String chargingProfilePurpose) throws InterruptedException {

		Operations operations = new Operations(driver);

		if (chargingProfilePurpose.equalsIgnoreCase("CHARGE_POINT_MAX_PROFILE")) {
			new Select(operations.GetchargingProfilePurposeId()).selectByValue("CHARGE_POINT_MAX_PROFILE");

		}
		if (chargingProfilePurpose.equalsIgnoreCase("TX_DEFAULT_PROFILE")) {
			new Select(operations.GetchargingProfilePurposeId()).selectByValue("TX_DEFAULT_PROFILE");

		}
		if (chargingProfilePurpose.equalsIgnoreCase("TX_PROFILE")) {
			new Select(operations.GetchargingProfilePurposeId()).selectByValue("TX_PROFILE");

		}

	}

	@And("^I Enter Stack Level '(.*)'$")
	public void Select_Stack_Level(String ID) throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetstackLevelId().sendKeys(ID);
	}

	// Set Charging Profile

	@And("^I click Set Charging Profile$")
	public void get_Set_Charging_Profile() throws InterruptedException {

		Operations operations = new Operations(driver);
		operations.GetSetChargingButton().click();
	}

	// Settings

	@And("^I click Settings button$")
	public void click_Settings_button() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetSettingsButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I enter Heartbeat Interval '(.*)'$")
	public void enter_Heartbeat_Interval(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.Getheartbeat().sendKeys(ID);
	}

	@And("^I enter Expiration '(.*)'$")
	public void enter_Expiration(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetexpirationId().sendKeys(ID);
	}

	@And("^I click Enable Notifications$")
	public void click_Enable_Notifications() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledId().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I enter Protocol '(.*)'$")
	public void enter_Protocol(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetprotocolId().sendKeys(ID);
	}

	@And("^I enter Host '(.*)'$")
	public void enter_Host(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GethostId().sendKeys(ID);
	}

	@And("^I enter Port '(.*)'$")
	public void enter_Port(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetportId().sendKeys(ID);
	}

	@And("^I enter Form '(.*)'$")
	public void enter_Form(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetfromId().sendKeys(ID);
	}

	@And("^I enter User name '(.*)'$")
	public void enter_User_name(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetusernameId().sendKeys(ID);
	}

	@And("^I enter Password '(.*)'$")
	public void enter_Password(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetpasswordId().sendKeys(ID);
	}

	@And("^I enter Recipients '(.*)'$")
	public void enter_Recipients(String ID) throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetrecipientsId().sendKeys(ID);
	}

	@And("^I click charging sends Notifications$")
	public void click_charging_Notifications() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledFeatures1Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click connector gets faulted$")
	public void click_connector_gets_faulted() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledFeatures2Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click JSON charging station connects$")
	public void click_ccharging_station_connects() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledFeatures3Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click JSON charging station disconnects$")
	public void click_charging_station_disconnects() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledFeatures4Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click charging station starts a transaction$")
	public void click_charging_starts_transaction() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledFeatures5Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click charging station ends a transaction$")
	public void click_charging_ends_transaction() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetenabledFeatures6Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click change settings button$")
	public void click_Change_Settings_button() throws InterruptedException {

		Settings settings = new Settings(driver);
		settings.GetchangeSettingsButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Data_Management

	@And("^I click on data management charge points button$")
	public void Click_management_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(dataManagement.GetmanagementButton1());
		actions.perform();
		dataManagement.GetmanagementButton().click();

	}

	@And("^I select '(.*)'$")
	public void select(String chargeBox) throws InterruptedException {

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='overview']/table/tbody/tr"));
		// Table Size
		System.out.println("Table size :" + rows.size());
		// Table First Column : Chargebox ID
		for (WebElement row : rows) {
			if (row.findElement(By.xpath("td[1]/a")).getText().equals(chargeBox)) {
				device_id = chargeBox;
				row.findElement(By.xpath("td[1]/a")).click();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement S = driver.findElement(By.xpath("//*[@id=\'chargePointForm\']/table[1]/tbody/tr[6]/td[2]"));
				String serials = S.getText().replaceAll("\\s", "");
				serials = serials.replaceAll("\\s", "");
				if (serials.contains("-")) {
					String str[] = serials.split("-");

					chargers_ids = Arrays.asList(str); // QY377MV - NWAIB8V

				} else {
					chargers_ids.add(0, serials);

				}

				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);

	}

	@And("^I enter ChargeBox ID '(.*)'$")
	public void enter_value_charge_box(String chargeBox) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetchargeBoxId().sendKeys(chargeBox);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Description '(.*)'$")
	public void enter_description(String description) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetdescriptionId().sendKeys(description);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Ocpp Version '(.*)'$")
	public void Select_OcppVersion(String ocppVersion) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (ocppVersion.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetocppVersionId()).selectByValue("");
		}
		if (ocppVersion.equalsIgnoreCase("ocpp1.2")) {
			new Select(dataManagement.GetocppVersionId()).selectByValue("V_12");
		}
		if (ocppVersion.equalsIgnoreCase("ocpp1.5")) {
			new Select(dataManagement.GetocppVersionId()).selectByValue("V_15");
		}
		if (ocppVersion.equalsIgnoreCase("ocpp1.6")) {
			new Select(dataManagement.GetocppVersionId()).selectByValue("V_16");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select heartbeatPeriod '(.*)'$")
	public void Select_heartbeatPeriod(String heartbeatPeriod) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (heartbeatPeriod.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("ALL");
		}
		if (heartbeatPeriod.equalsIgnoreCase("Today")) {
			new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("TODAY");
		}
		if (heartbeatPeriod.equalsIgnoreCase("Yesterday")) {
			new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("YESTERDAY");
		}
		if (heartbeatPeriod.equalsIgnoreCase("Earlier")) {
			new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("EARLIER");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click Get button$")
	public void click_get_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Then("^User in charge point result$")
	public void VerifyUserOnChargePointResult() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Data_Management dataManagement = new Data_Management(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(dataManagement.GetresActionExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@And("^I click AddNew button$")
	public void click_AddNew_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetAddNewButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Then("^User in add charge point result$")
	public void VerifyUserOnAddChargerPointResult() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Data_Management dataManagement = new Data_Management(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(dataManagement.GetuserInputExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// Add new Charge point

	@And("^I click Insert connector status$")
	public void click_insert_connector_status() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetinsertConnectorStatusAfterTransactionMsg1Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I select Registration status '(.*)'$")
	public void Select_RegistrationStatus(String registrationStatus) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (registrationStatus.equalsIgnoreCase("Accepted")) {
			new Select(dataManagement.GetregistrationStatusId()).selectByValue("Accepted");
		}
		if (registrationStatus.equalsIgnoreCase("Rejected")) {
			new Select(dataManagement.GetregistrationStatusId()).selectByValue("Rejected");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Street '(.*)'$")
	public void enter_Street(String street) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetaddressStreetId().sendKeys(street);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter House Number '(.*)'$")
	public void enter_House_Number(String houseNumber) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetaddressHouseNumberId().sendKeys(houseNumber);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Zip code '(.*)'$")
	public void enter_Zip_Code(String zipCode) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetaddressZipCodeId().sendKeys(zipCode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter City '(.*)'$")
	public void enter_City(String City) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetaddressCityId().sendKeys(City);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Country '(.*)'$")
	public void Select_Country(String country) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (country.equalsIgnoreCase("Afghanistan")) {
			new Select(dataManagement.GetaddressCountryId()).selectByValue("AF");
		}
		if (country.equalsIgnoreCase("American Samoa")) {
			new Select(dataManagement.GetaddressCountryId()).selectByValue("AS");
		}
		if (country.equalsIgnoreCase("Albania")) {
			new Select(dataManagement.GetaddressCountryId()).selectByValue("AL");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Admin Address '(.*)'$")
	public void enter_Admin_Address(String adminAdress) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetadminAddressId().sendKeys(adminAdress);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Latitude '(.*)'$")
	public void enter_Latitude(String latitude) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetlocationLatitudeId().sendKeys(latitude);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Longitude '(.*)'$")
	public void enter_Longitude(String longitude) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetlocationLongitudeId().sendKeys(longitude);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Additional Note '(.*)'$")
	public void enter_Additional_Note(String additionalNote) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetnoteId().sendKeys(additionalNote);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click Add button$")
	public void click_Add_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetAddButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click Add New Charge points button$")
	public void click_Add_New_Charge_Points_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetAddNewChargePointsButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click Back To Overview button$")
	public void click_Back_To_Overview_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetbackToOverviewButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I click Delete button$")
	public void click_Delete_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetredSubmitButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Occp Tags

	@And("^I click on data management Occp Tags  button$")
	public void Click_management_Occp_Tags_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(dataManagement.GetmanagementButton1());
		actions.perform();
		dataManagement.GetoccpButton().click();
	}

	@And("^I select Id Tag '(.*)'$")
	public void Select_Id_Tag(String idTag) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (idTag.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetidTagId()).selectByValue("");

		}
		if (idTag.equalsIgnoreCase("040f0032")) {
			new Select(dataManagement.GetidTagId()).selectByValue("040f0032");
		}
		if (idTag.equalsIgnoreCase("4b1f32bb")) {
			new Select(dataManagement.GetidTagId()).selectByValue("4b1f32bb");
		}
		if (idTag.equalsIgnoreCase("5392461f")) {
			new Select(dataManagement.GetidTagId()).selectByValue("5392461f");
		}
		if (idTag.equalsIgnoreCase("5c5e6ada")) {
			new Select(dataManagement.GetidTagId()).selectByValue("5c5e6ada");
		}
		if (idTag.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
			new Select(dataManagement.GetidTagId()).selectByValue("7250939c52dc4d7cb59c");
		}
		if (idTag.equalsIgnoreCase("9c756eda")) {
			new Select(dataManagement.GetidTagId()).selectByValue("9c756eda");
		}
		if (idTag.equalsIgnoreCase("A0-00-00-00")) {
			new Select(dataManagement.GetidTagId()).selectByValue("A0-00-00-00");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Parent ID Tag '(.*)'$")
	public void Select_Parent_Id_Tag(String idParentTag) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (idParentTag.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetparentIdTagId()).selectByValue("");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Expired '(.*)'$")
	public void Select_Expired(String expired) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (expired.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetExpiredId()).selectByValue("ALL");

		}
		if (expired.equalsIgnoreCase("True")) {
			new Select(dataManagement.GetExpiredId()).selectByValue("TRUE");
		}
		if (expired.equalsIgnoreCase("False")) {
			new Select(dataManagement.GetExpiredId()).selectByValue("FALSE");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select In Transaction '(.*)'$")
	public void Select_In_Transaction(String inTransaction) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (inTransaction.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetinTransactionId()).selectByValue("ALL");

		}
		if (inTransaction.equalsIgnoreCase("True")) {
			new Select(dataManagement.GetinTransactionId()).selectByValue("TRUE");
		}
		if (inTransaction.equalsIgnoreCase("False")) {
			new Select(dataManagement.GetinTransactionId()).selectByValue("FALSE");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Blocked '(.*)'$")
	public void Select_Blocked(String blocked) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (blocked.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetblockedId()).selectByValue("ALL");

		}
		if (blocked.equalsIgnoreCase("True")) {
			new Select(dataManagement.GetblockedId()).selectByValue("TRUE");
		}
		if (blocked.equalsIgnoreCase("False")) {
			new Select(dataManagement.GetblockedId()).selectByValue("FALSE");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	// add new occp form

	@Then("^User in add Occp$")
	public void VerifyUserOnAddOccp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Data_Management dataManagement = new Data_Management(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(dataManagement.GetocppTagFormIdExist());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@And("^I enter new idTag '(.*)'$")
	public void enter_new_idTag(String newIdTag) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetidTagId().sendKeys(newIdTag);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter New Expiry Date Time '(.*)'$")
	public void enter_new_Expiry_Date_Time(String newExpiryDateTime) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetexpirationId().sendKeys(newExpiryDateTime);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter New Max Active Transaction Count '(.*)'$")
	public void enter_new_Max_Active_Transaction(String newActiveTransaction) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetmaxActiveTransactionCountId().sendKeys(newActiveTransaction);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click ADD occp button$")
	public void click_Add_OCCP_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetaddOccpButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Users

	@And("^I click on data management Users button$")
	public void Click_management_Users_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(dataManagement.GetmanagementButton1());
		actions.perform();
		dataManagement.GetusersManagementButton().click();
	}

	@And("^I enter User ID '(.*)'$")
	public void enter_User_ID(String userId) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetuserPkId().sendKeys(userId);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Ocpp ID Tag '(.*)'$")
	public void enter_Occp_ID_Tag(String occpIdTag) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetocppIdTagId().sendKeys(occpIdTag);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter name '(.*)'$")
	public void enter_Name(String name) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetnameId().sendKeys(name);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter email '(.*)'$")
	public void enter_Email(String email) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetemailId().sendKeys(email);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	// same button GET
	// same Add Button

	// Add New User Form

	@And("^I enter firstName '(.*)'$")
	public void enter_FirstName(String firstName) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetfirstNameId().sendKeys(firstName);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Last name '(.*)'$")
	public void enter_Last_Name(String lastName) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetlastNameId().sendKeys(lastName);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Birthday '(.*)'$")
	public void enter_Birthday(String birthday) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetbirthDayId().sendKeys(birthday);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Sex '(.*)'$")
	public void Select_Sex(String sex) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (sex.equalsIgnoreCase("Female")) {
			new Select(dataManagement.GetsexId()).selectByValue("FEMALE");

		}
		if (sex.equalsIgnoreCase("Male")) {
			new Select(dataManagement.GetsexId()).selectByValue("MALE");
		}
		if (sex.equalsIgnoreCase("Other")) {
			new Select(dataManagement.GetsexId()).selectByValue("OTHER");
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter phone '(.*)'$")
	public void enter_Phone(String phone) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetphoneId().sendKeys(phone);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter E-mail '(.*)'$")
	public void enter_E_mail(String email) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GeteMailId().sendKeys(email);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	// same note and adress infos

	@And("^I select OccpTagIdUser '(.*)'$")
	public void Select_Occp_Tag_Id_User(String OccpTagId) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (OccpTagId.equalsIgnoreCase("-- Empty --")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("");

		}
		if (OccpTagId.equalsIgnoreCase("4b1f32bb")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("4b1f32bb");

		}
		if (OccpTagId.equalsIgnoreCase("040f0032")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("040f0032");

		}
		if (OccpTagId.equalsIgnoreCase("5392461f")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("5392461f");

		}
		if (OccpTagId.equalsIgnoreCase("5c5e6ada")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("5c5e6ada");

		}
		if (OccpTagId.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("7250939c52dc4d7cb59c");

		}
		if (OccpTagId.equalsIgnoreCase("A0-00-00-00")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("A0-00-00-00");

		}
		if (OccpTagId.equalsIgnoreCase("9c756eda")) {
			new Select(dataManagement.GetocppIdTagId()).selectByValue("9c756eda");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	// Same buttons add and overtoview

	// Charging profile

	@And("^I click on data management Charging Profiles button$")
	public void Click_management_Charging_Profile_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(dataManagement.GetmanagementButton1());
		actions.perform();
		dataManagement.GetChargingProfilesButton().click();
	}

	@And("^I enter Charging Profile Id '(.*)'$")
	public void enter_Charging_Profile_Id(String chargingProfileId) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetchargingProfilePkId().sendKeys(chargingProfileId);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Stack Level '(.*)'$")
	public void enter_Stack_Level(String stackLevel) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetstackLevelId().sendKeys(stackLevel);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Profile Purpose '(.*)'$")
	public void Select_Profile_Purpose(String profilePurpose) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (profilePurpose.equalsIgnoreCase("-- Empty --")) {
			new Select(dataManagement.GetprofilePurposeId()).selectByValue("");

		}
		if (profilePurpose.equalsIgnoreCase("CHARGE_POINT_MAX_PROFILE")) {
			new Select(dataManagement.GetprofilePurposeId()).selectByValue("CHARGE_POINT_MAX_PROFILE");

		}
		if (profilePurpose.equalsIgnoreCase("TX_DEFAULT_PROFILE")) {
			new Select(dataManagement.GetprofilePurposeId()).selectByValue("TX_DEFAULT_PROFILE");

		}
		if (profilePurpose.equalsIgnoreCase("TX_PROFILE")) {
			new Select(dataManagement.GetprofilePurposeId()).selectByValue("TX_PROFILE");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Profile Kind '(.*)'$")
	public void Select_Profile_Kind(String profileKind) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (profileKind.equalsIgnoreCase("-- Empty --")) {
			new Select(dataManagement.GetprofileKindId()).selectByValue("");

		}
		if (profileKind.equalsIgnoreCase("ABSOLUTE")) {
			new Select(dataManagement.GetprofileKindId()).selectByValue("ABSOLUTE");

		}
		if (profileKind.equalsIgnoreCase("RECURRING")) {
			new Select(dataManagement.GetprofileKindId()).selectByValue("RECURRING");

		}
		if (profileKind.equalsIgnoreCase("RELATIVE")) {
			new Select(dataManagement.GetprofileKindId()).selectByValue("RELATIVE");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Recurrency Kind '(.*)'$")
	public void Select_Recurrency_Kind(String profileKind) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (profileKind.equalsIgnoreCase("-- Empty --")) {
			new Select(dataManagement.GetrecurrencyKindId()).selectByValue("");

		}
		if (profileKind.equalsIgnoreCase("DAILY")) {
			new Select(dataManagement.GetrecurrencyKindId()).selectByValue("DAILY");

		}
		if (profileKind.equalsIgnoreCase("WEEKLY")) {
			new Select(dataManagement.GetrecurrencyKindId()).selectByValue("WEEKLY");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Valid From '(.*)'$")
	public void enter_Valid_From(String validForm) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetvalidFromId().sendKeys(validForm);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Valid To '(.*)'$")
	public void enter_Valid_To(String validFormTo) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetvalidToId().sendKeys(validFormTo);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}
	// same get button and addnew

	@And("^I click get charging profile button$")
	public void click_Get_Charging_Profile_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetChargingProfilesGetButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Add New Charging Profiles

	@And("^I select Charging Profile Purpose2 '(.*)'$")
	public void Select_Charging_Profile_Purpose2(String chargingProfilePurpose) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (chargingProfilePurpose.equalsIgnoreCase("CHARGE_POINT_MAX_PROFILE")) {
			new Select(dataManagement.GetchargingProfilePurposeId()).selectByValue("CHARGE_POINT_MAX_PROFILE");

		}
		if (chargingProfilePurpose.equalsIgnoreCase("TX_DEFAULT_PROFILE")) {
			new Select(dataManagement.GetchargingProfilePurposeId()).selectByValue("TX_DEFAULT_PROFILE");

		}
		if (chargingProfilePurpose.equalsIgnoreCase("TX_PROFILE")) {
			new Select(dataManagement.GetchargingProfilePurposeId()).selectByValue("TX_PROFILE");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Charging Profile Kind '(.*)'$")
	public void Select_Charging_Profile_Kind(String chargingProfileKind) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (chargingProfileKind.equalsIgnoreCase("ABSOLUTE")) {
			new Select(dataManagement.GetchargingProfileKindId()).selectByValue("ABSOLUTE");

		}
		if (chargingProfileKind.equalsIgnoreCase("RECURRING")) {
			new Select(dataManagement.GetchargingProfileKindId()).selectByValue("RECURRING");

		}
		if (chargingProfileKind.equalsIgnoreCase("RELATIVE")) {
			new Select(dataManagement.GetchargingProfileKindId()).selectByValue("RELATIVE");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Duration '(.*)'$")
	public void enter_Duration(String duration) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetdurationInSecondsId().sendKeys(duration);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Start Schedule '(.*)'$")
	public void enter_Start_Schedule(String startSchedule) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetstartScheduleId().sendKeys(startSchedule);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Charging Rate Unit2 '(.*)'$")
	public void Select_Charging_Rate_Unit2(String chargingRateUnit) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (chargingRateUnit.equalsIgnoreCase("A")) {
			new Select(dataManagement.GetchargingRateUnitId()).selectByValue("A");

		}
		if (chargingRateUnit.equalsIgnoreCase("W")) {
			new Select(dataManagement.GetchargingRateUnitId()).selectByValue("W");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Min Charging Rate  '(.*)'$")
	public void enter_Min_Charging_Rate(String minChargingRate) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetminChargingRateId().sendKeys(minChargingRate);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click Add Period$")
	public void click_Add_Period() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetaddRowIdButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("^I enter Start Period  '(.*)'$")
	public void enter_Start_Period(String startPeriod) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetscheduleStartPeriod().sendKeys(startPeriod);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Power Limit  '(.*)'$")
	public void enter_Power_Limit(String powerLimit) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetschedulePeriodMapzz1662475491343PowerLimitId().sendKeys(powerLimit);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter Number Phases  '(.*)'$")
	public void enter_Number_Phases(String numberPhases) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetschedulePeriodMapzz1662475491343NumberPhasesId().sendKeys(numberPhases);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click Delete Period$")
	public void click_Delete_Period() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetremoveRowButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// same buttons add and back

	// Management Reservations

	@And("^I click on data management Reservation button$")
	public void Click_management_Reservations_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(dataManagement.GetmanagementButton1());
		actions.perform();
		dataManagement.GetmanagementReservationsButton().click();
	}

	@And("^I select Charge Box Id '(.*)'$")
	public void Select_Charge_Box_Id(String chargeBoxId) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (chargeBoxId.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetchargeBoxIdId()).selectByValue("");

		}
		if (chargeBoxId.equalsIgnoreCase("local")) {
			new Select(dataManagement.GetchargeBoxIdId()).selectByValue("local");

		}
		if (chargeBoxId.equalsIgnoreCase("jaime")) {
			new Select(dataManagement.GetchargeBoxIdId()).selectByValue("jaime");

		}
		if (chargeBoxId.equalsIgnoreCase("luke")) {
			new Select(dataManagement.GetchargeBoxIdId()).selectByValue("luke");

		}
		if (chargeBoxId.equalsIgnoreCase("wiem")) {
			new Select(dataManagement.GetchargeBoxIdId()).selectByValue("wiem");

		}
		if (chargeBoxId.equalsIgnoreCase("wiem1")) {
			new Select(dataManagement.GetchargeBoxIdId()).selectByValue("wiem1");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Reservation Status '(.*)'$")
	public void Select_Reservation_Status(String reservStatus) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (reservStatus.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetReservationsButton()).selectByValue("");

		}
		if (reservStatus.equalsIgnoreCase("WAITING")) {
			new Select(dataManagement.GetReservationsButton()).selectByValue("WAITING");

		}
		if (reservStatus.equalsIgnoreCase("ACCEPTED")) {
			new Select(dataManagement.GetReservationsButton()).selectByValue("ACCEPTED");

		}
		if (reservStatus.equalsIgnoreCase("USED")) {
			new Select(dataManagement.GetReservationsButton()).selectByValue("USED");

		}
		if (reservStatus.equalsIgnoreCase("CANCELLED")) {
			new Select(dataManagement.GetReservationsButton()).selectByValue("CANCELLED");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Period Type '(.*)'$")
	public void Select_Period_Type(String periodType) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (periodType.equalsIgnoreCase("Active")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("ACTIVE");

		}
		if (periodType.equalsIgnoreCase("From/To")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("FROM_TO");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter From  '(.*)'$")
	public void enter_From(String form) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetintervalPeriodTypeFromId().sendKeys(form);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I enter FromTo  '(.*)'$")
	public void enter_From_To(String formTo) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetintervalPeriodTypeToId().sendKeys(formTo);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}
	// same button get

	// Management Transactions

	@And("^I click on data management Transactions button$")
	public void Click_management_Transactions_button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		Actions actions = new Actions(driver);

		actions.moveToElement(dataManagement.GetmanagementButton1());
		actions.perform();
		dataManagement.GetmanagementTransactionsButton().click();

	}

	@And("^I enter Transaction ID  '(.*)'$")
	public void enter_Transaction_ID(String transactionId) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GettransactionPkId().sendKeys(transactionId);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Transaction Type '(.*)'$")
	public void Select_Transaction_Type(String transactionType) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (transactionType.equalsIgnoreCase("All")) {
			new Select(dataManagement.GettypeId()).selectByValue("ALL");

		}
		if (transactionType.equalsIgnoreCase("Active")) {
			new Select(dataManagement.GettypeId()).selectByValue("ACTIVE");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I select Period Type Transactions'(.*)'$")
	public void Select_Period_Type_Transaction(String periodTypetrans) throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		if (periodTypetrans.equalsIgnoreCase("All")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("ALL");

		}
		if (periodTypetrans.equalsIgnoreCase("Today")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("TODAY");

		}
		if (periodTypetrans.equalsIgnoreCase("Last 10 days")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("LAST_10");

		}
		if (periodTypetrans.equalsIgnoreCase("Last 30 days")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("LAST_30");

		}
		if (periodTypetrans.equalsIgnoreCase("Last 90 days")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("LAST_90");

		}
		if (periodTypetrans.equalsIgnoreCase("From/To")) {
			new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("FROM_TO");

		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@And("^I click Get as CSV? button$")
	public void click_Get_CSV_Button() throws InterruptedException {

		Data_Management dataManagement = new Data_Management(driver);
		dataManagement.GetreturnCSV1Id().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
