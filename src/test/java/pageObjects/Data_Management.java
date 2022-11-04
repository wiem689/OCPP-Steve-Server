package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import managers.PageObjectManager;

public class Data_Management {
	
	WebDriver driver;

	public Data_Management(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_Data_Management() {
		driver.get(FileReaderManager.getInstance().getApplicationUrl());
	}
	
	By managementButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[1]/a");
	
	By managementButton1 = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/a");
	
	
	By chargeBoxId = By.id("chargeBoxId");
	By descriptionId = By.id("description");
	By ocppVersionId = By.id("ocppVersion");
	By heartbeatPeriodId = By.id("heartbeatPeriod");
	
	By GetButton = By.xpath("//*[@id=\"add_space\"]/input");
	By resAction = By.className("res action");
	By AddNewButton = By.xpath("//*[@id=\"command\"]/input");
	By userInput = By.className("userInput");
	By insertConnectorStatusAfterTransactionMsg1Id = By.id("insertConnectorStatusAfterTransactionMsg1");
	By registrationStatusId = By.id("registrationStatus");
	By addressStreetId = By.id("address.street"); 
	
	By addressHouseNumberId = By.id("address.houseNumber");
	By addressZipCodeId = By.id("address.zipCode");
	
	By addressCityId = By.id("address.city");
	By addressCountryId = By.id("address.country");
	By adminAddressId = By.id("adminAddress");
	
	By locationLatitudeId = By.id("locationLatitude");
	By locationLongitudeId = By.id("locationLongitude");
	By noteId = By.id("note");
	By AddButton = By.xpath("//*[@id=\"add_space\"]/input[1]");  
	By AddNewChargePointsButton = By.xpath("//*[@id=\"add_space\"]/input[1]");  
	
	By backToOverviewButton = By.xpath("//*[@id=\"add_space\"]/input[2]");
	
	By redSubmitButton= By.className("redSubmit");
	
	By selectChargeBoxId = By.xpath("//*[@id=\"overview\"]/table/tbody/tr[4]/td[1]/a");
		
		
	
	//add new occptag button
	
	By occpButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[2]/a");
	
	By idTagId = By.id("idTag");
	By parentIdTagId = By.id("parentIdTag");
	
	By ExpiredId = By.id("expired");
	By inTransactionId = By.id("inTransaction");
	By blockedId = By.id("blocked");
	By ocppTagFormId = By.id("ocppTagForm");
	
	//add new occptag form
		//same button add 
		By expirationId = By.id("expiration");
		By maxActiveTransactionCountId = By.id("maxActiveTransactionCount");
		//same button add and overview button 
		
		By addOccpButton = By.className("add");
		
		
		
		
		//Users 
		
		By usersManagementButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[3]/a");
		By userPkId = By.id("userPk");
		By ocppIdTagId = By.id("ocppIdTag");
		By nameId = By.id("name");
		By emailId = By.id("email");
		
		
		//Add User Form 
		
		
		By usersButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[3]/a");
		By firstNameId = By.id("firstName");
		By lastNameId = By.id("lastName");
		By birthDayId = By.id("birthDay");
		By sexId = By.id("sex");
		By phoneId = By.id("phone");
		By eMailId = By.id("eMail");
		
		//Charging Profiles
				By ChargingProfilesButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[4]/a");
				By chargingProfilePkId = By.id("chargingProfilePk");
				By stackLevelId = By.id("stackLevel");
				By profilePurposeId = By.id("profilePurpose");
				By profileKindId = By.id("profileKind");
				
				By recurrencyKindId = By.id("recurrencyKind");
				By validFromId = By.id("validFrom");
				By validToId = By.id("validTo");
				By ChargingProfilesGetButton = By.xpath("//*[@id=\"add_space\"]/input");
				
				
				
				
				// add new charging profile 
				
				By durationInSecondsId = By.id("durationInSeconds");
				By startScheduleId = By.id("startSchedule");
				By chargingRateUnitId = By.id("chargingRateUnit");
				By minChargingRateId = By.id("minChargingRate");
				By chargingProfilePurposeId = By.id("chargingProfilePurpose");
				By chargingProfileKindId = By.id("chargingProfileKind");
				
				
				
				By addRowId = By.id("addRow");
				By scheduleStartPeriod= By.xpath("//*[@id=\"schedulePeriodMapzz1663752894217.startPeriodInSeconds\"]");
				By schedulePeriodMapzz1662475491343PowerLimitId = By.id("schedulePeriodMapzz1662475491343.powerLimit");
				By schedulePeriodMapzz1662475491343NumberPhasesId = By.id("schedulePeriodMapzz1662475491343.numberPhases");
				By removeRowButton = By.className("removeRow");
		
				
				//Reservations 
				By managementReservationsButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[5]/a");
				By ReservationsButton = By.xpath("//*[@id=\"status\"]");
				By chargeBoxIdId = By.id("chargeBoxId");
				By statusId = By.id("status");
				By periodTypeSelectId = By.id("periodTypeSelect");
				By intervalPeriodTypeFromId = By.id("intervalPeriodTypeFrom");
				By intervalPeriodTypeToId = By.id("intervalPeriodTypeTo");
				
				
				//Transactions 
				
				By managementTransactionsButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[2]/ul/li[6]/a");
				
				By transactionPkId = By.id("transactionPk");
				By typeId = By.id("type");
				By returnCSV1Id = By.xpath("//*[@id=\"params\"]/table/tbody/tr[8]/td[2]");
				
				
		
		
	//getters charge points 
	





	public WebElement GetchargeBoxId(){
		return driver.findElement(chargeBoxId);
	}
	
	
	public WebElement GetdescriptionId(){
		return driver.findElement(descriptionId);
	}
	
	public WebElement GetocppVersionId(){
		return driver.findElement(ocppVersionId);
	}
	
	public WebElement GetheartbeatPeriodId(){
		return driver.findElement(heartbeatPeriodId);
	}
	
	public WebElement GetButton(){
		return driver.findElement(GetButton);
	}
	
	public WebElement GetresAction() {
		return driver.findElement(resAction);
	}
	
	public Boolean GetresActionExist(){
		return !driver.findElements(resAction).isEmpty();
	}
	
	public WebElement GetAddNewButton(){
		return driver.findElement(AddNewButton);
	}
	
	public WebElement GetuserInput() {
		return driver.findElement(userInput);
	}
	
	public Boolean GetuserInputExist(){
		return !driver.findElements(userInput).isEmpty();
	}
	
	public WebElement GetinsertConnectorStatusAfterTransactionMsg1Id(){
		return driver.findElement(insertConnectorStatusAfterTransactionMsg1Id);
	}
	
	public WebElement GetregistrationStatusId(){
		return driver.findElement(registrationStatusId);
	}
	
	
	public WebElement GetaddressStreetId(){
		return driver.findElement(addressStreetId);
	}
	
	public WebElement GetaddressHouseNumberId(){
		return driver.findElement(addressHouseNumberId);
	}
	public WebElement GetaddressZipCodeId(){
		return driver.findElement(addressZipCodeId);
	}
	
	public WebElement GetaddressCityId(){
		return driver.findElement(addressCityId);
	}
	
	public WebElement GetaddressCountryId(){
		return driver.findElement(addressCountryId);
	}
	
	public WebElement GetadminAddressId(){
		return driver.findElement(adminAddressId);
	}
	
	public WebElement GetlocationLatitudeId(){
		return driver.findElement(locationLatitudeId);
	}
	
	public WebElement GetlocationLongitudeId(){
		return driver.findElement(locationLongitudeId);
	}
	
	public WebElement GetnoteId(){
		return driver.findElement(noteId);
	}
	
	public WebElement GetAddButton(){
		return driver.findElement(AddButton);
	}
	
	public WebElement GetAddNewChargePointsButton(){
		return driver.findElement(AddNewChargePointsButton);
	}
	
	public WebElement GetbackToOverviewButton(){
		return driver.findElement(backToOverviewButton);
	}
	
	
	public WebElement GetredSubmitButton(){
		return driver.findElement(redSubmitButton);
	}
	
	
	
	
	public WebElement GetmanagementButton1(){
		return driver.findElement(managementButton1);
	}
	
	public WebElement GetmanagementButton(){
		return driver.findElement(managementButton);
	}
	
	public WebElement GetselectChargeBoxId(){
		return driver.findElement(selectChargeBoxId);
	}
	
	
	
	
	//getters Occp Tags
	
	
	public WebElement GetoccpButton(){
		return driver.findElement(occpButton);
	}
	
	public WebElement GetidTagId(){
		return driver.findElement(idTagId);
	}
	
	public WebElement GetparentIdTagId(){
		return driver.findElement(parentIdTagId);
	}
	
	public WebElement GetExpiredId(){
		return driver.findElement(ExpiredId);
	}
	
	public WebElement GetinTransactionId(){
		return driver.findElement(inTransactionId);
	}
	
	public WebElement GetblockedId(){
		return driver.findElement(blockedId);
	}
	
	//add new occp form
	
	public WebElement GetocppTagFormId() {
		return driver.findElement(ocppTagFormId);
	}
	
	public Boolean GetocppTagFormIdExist(){
		return !driver.findElements(ocppTagFormId).isEmpty();
	}
	
	public WebElement GetexpirationId(){
		return driver.findElement(expirationId);
	}
	
	public WebElement GetmaxActiveTransactionCountId(){
		return driver.findElement(maxActiveTransactionCountId);
	}
	
	public WebElement GetaddOccpButton(){
		return driver.findElement(addOccpButton);
	}
	
	
	//Users
	
		public WebElement GetuserPkId(){
			return driver.findElement(userPkId);
		}
		
		public WebElement GetocppIdTagId(){
			return driver.findElement(ocppIdTagId);
		}
		
		public WebElement GetnameId(){
			return driver.findElement(nameId);
		}
		
		public WebElement GetemailId(){
			return driver.findElement(emailId);
		}
		
		//Add New User Form 
		
		public WebElement GetusersButton(){
			return driver.findElement(usersButton);
		}
		
		public WebElement GetfirstNameId(){
			return driver.findElement(firstNameId);
		}
		
		public WebElement GetlastNameId(){
			return driver.findElement(lastNameId);
		}
		
		public WebElement GetbirthDayId(){
			return driver.findElement(birthDayId);
		}
		
		public WebElement GetsexId(){
			return driver.findElement(sexId);
		}
		
		public WebElement GetphoneId(){
			return driver.findElement(phoneId);
		}
		
		public WebElement GeteMailId(){
			return driver.findElement(eMailId);
		}
	
	
		public WebElement GetusersManagementButton(){
			return driver.findElement(usersManagementButton);
		}
		
		//Charging Profiles 
		
		public WebElement GetChargingProfilesButton(){
			return driver.findElement(ChargingProfilesButton);
		}
		
		public WebElement GetchargingProfilePkId(){
			return driver.findElement(chargingProfilePkId);
		}
		
		
		public WebElement GetstackLevelId(){
			return driver.findElement(stackLevelId);
		}
		
		public WebElement GetprofilePurposeId(){
			return driver.findElement(profilePurposeId);
		}
		
		public WebElement GetprofileKindId(){
			return driver.findElement(profileKindId);
		}
		
		
		public WebElement GetrecurrencyKindId(){
			return driver.findElement(recurrencyKindId);
		}
		
		public WebElement GetvalidFromId(){
			return driver.findElement(validFromId);
		}
		
		public WebElement GetvalidToId(){
			return driver.findElement(validToId);
		}
		
		
		
		//Add new Charging Profiles
		
		
		public WebElement GetdurationInSecondsId(){
			return driver.findElement(durationInSecondsId);
		}
		
		
		public WebElement GetstartScheduleId(){
			return driver.findElement(startScheduleId);
		}
		
		public WebElement GetchargingRateUnitId(){
			return driver.findElement(chargingRateUnitId);
		}
		
		public WebElement GetminChargingRateId(){
			return driver.findElement(minChargingRateId);
		}
		
		public WebElement GetchargingProfilePurposeId(){
			return driver.findElement(chargingProfilePurposeId);
		}
		
		public WebElement GetchargingProfileKindId(){
			return driver.findElement(chargingProfileKindId);
		}
		
		
		
		public WebElement GetaddRowIdButton(){
			return driver.findElement(addRowId);
		}
		
		public WebElement GetscheduleStartPeriod(){
			return driver.findElement(scheduleStartPeriod);
		}
		
		public WebElement GetschedulePeriodMapzz1662475491343PowerLimitId(){
			return driver.findElement(schedulePeriodMapzz1662475491343PowerLimitId);
		}
		
		public WebElement GetschedulePeriodMapzz1662475491343NumberPhasesId(){
			return driver.findElement(schedulePeriodMapzz1662475491343NumberPhasesId);
		}
		
		
		
		
		
		
		public WebElement GetremoveRowButton(){
			return driver.findElement(removeRowButton);
		}
		
		public WebElement GetChargingProfilesGetButton(){
			return driver.findElement(ChargingProfilesGetButton);
		}
		      
		
		//Getters Reservations 
		
		public WebElement GetReservationsButton(){
			return driver.findElement(ReservationsButton);
		}
		
		public WebElement GetmanagementReservationsButton(){
			return driver.findElement(managementReservationsButton);
		}
		public WebElement GetchargeBoxIdId(){
			return driver.findElement(chargeBoxIdId);
		}
		
		public WebElement GetstatusId(){
			return driver.findElement(statusId);
		}
		
		public WebElement GetperiodTypeSelectId(){
			return driver.findElement(periodTypeSelectId);
		}
		
		public WebElement GetintervalPeriodTypeFromId(){
			return driver.findElement(intervalPeriodTypeFromId);
		}
		
		public WebElement GetintervalPeriodTypeToId(){
			return driver.findElement(intervalPeriodTypeToId);
		}
		
	//Getters Transactions
		
		public WebElement GetmanagementTransactionsButton(){
			return driver.findElement(managementTransactionsButton);
		}
		
		public WebElement GettransactionPkId(){
			return driver.findElement(transactionPkId);
		}
		
		
		public WebElement GettypeId(){
			return driver.findElement(typeId);
		}
		
		
		public WebElement GetreturnCSV1Id(){
			return driver.findElement(returnCSV1Id);
		}
		
			
}
