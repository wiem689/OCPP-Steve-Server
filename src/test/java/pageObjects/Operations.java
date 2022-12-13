package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class Operations {

	WebDriver driver;

	public Operations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_Operations() {
		driver.get(FileReaderManager.getInstance().getApplicationUrl());
	}
	
	
	
	//change availability
	
		By SelectAllButton = By.xpath("//*[@id=\"params\"]/table[1]/tbody/tr/td[1]/input[1]");
		By SelectNoneButton = By.xpath("//*[@id=\"params\"]/table[1]/tbody/tr/td[1]/input[2]");
		By chargePointSelectListId = By.id("chargePointSelectList");
		By connectorId = By.id("connectorId");
		By submitbutton = By.className("submit-button");
		By availType = By.id("availType");
		By OperationButton1 = By.xpath("/html/body/div[1]/div[2]/div/ul/li[3]/a"); 
		By OperationButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[3]/ul/li[3]/a");
		
		By cpd = By.className("cpd");
		
	
		
		//change configuration 
		
		By keyTypeId = By.id("keyType");
		By confKeyId = By.id("confKey");
		By customConfKeyId = By.id("customConfKey");
		By valueId = By.id("value");
		By changeConfigButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[2]/a");
		
		By Valueconf = By.xpath("/html/body/div[1]/div[3]/div/div/table/thead/tr/th[2]");
		By readOnly = By.xpath("/html/body/div[1]/div[3]/div/div/table/tbody/tr/td[3]");
		By Keyconf = By.xpath("/html/body/div[1]/div[3]/div/div/table/thead/tr/th[1]");
	   
	   
	
		
	    //Get Diagnostics 
		
		By locationId = By.id("location");
		By retriesId = By.id("retries");
		By retryIntervalId = By.id("retryInterval");
		By startId = By.id("start");
		By stopId = By.id("stop");
		By getDiagnosticsButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[4]/a");
		
		By performDiagnosticsButton = By.xpath("//*[@id=\"params\"]/table[2]/tbody/tr[6]/td[2]/div/input");
		
		By res = By.className("res");
		
		//clear cache 
		
		By clearCacheButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a");
		
		
		//remote start transaction 
		
		By connectorId2 = By.id("connectorId");
		By idTagId = By.id("idTag");
		By remotestarttransactionButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[5]/a");
		By transactionId = By.id("transactionId");
		By remotestoptransactionButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[6]/a");
		
		
		
		//reset
		
		By resetTypeId = By.id("resetType");
		By resetButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[7]/a");
		
		
		//Unlock Connector 
		
		By UnlockConnectorButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[8]/a");
		
		//Update Firmware 
		
		By UpdateFirmwareButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a");
		By retrieveId = By.id("retrieve");
		By performUpdateFirmwareButton = By.xpath("//*[@id=\"params\"]/table[2]/tbody/tr[5]/td[2]/div/input");
	    
		
		
		//Reservation 
		
		By ReserveNowButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[10]/a");
		By expiryId = By.id("expiry");
		By CancelReservationButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[11]/a");
		By reservationId = By.id("reservationId");
		By performReservationButton = By.xpath("//*[@id=\"params\"]/table[2]/tbody/tr[4]/td[2]/div");
		By performCancelReservationButton = By.xpath("//*[@id=\"params\"]/table[2]/tbody/tr[2]/td[2]/div/input");                                     
		
		
		
		//Data Transfer 
		
		By vendorId = By.id("vendorId");
		By messageId = By.id("messageId");
		By dataId = By.id("data");
		By DataTransferButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[12]/a");
		
		
		//Get Configuration 
		
		By GetConfigurationButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[13]/a");
		By SelectAllButton2 = By.xpath("//*[@id=\"params\"]/table[2]/tbody/tr[1]/td[1]/input[1]");
		By SelectNoneButton2 = By.xpath("//*[@id=\"params\"]/table[2]/tbody/tr[1]/td[1]/input[2]");
		
		By confKeyListId = By.id("confKeyList");
		By commaSeparatedCustomConfKeysId = By.id("commaSeparatedCustomConfKeys");
		By GetDetailsConf = By.xpath("/html/body/div[1]/div[3]/div/table/tbody/tr/td[2]/a");
		
		
		
		//Get and set local list version
		
		
		By GetLocalListVersionButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[14]/a");
		By SetLocalListVersionButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[15]/a");
		By listVersionId = By.id("listVersion");
		By updateTypeId = By.id("updateType");
		By addUpdateListId = By.id("addUpdateList");
		By deleteListId = By.id("deleteList");
		By sendEmptyListWhenFullId = By.id("sendEmptyListWhenFull");
		
		
		//Trigger Message 
		
		By GetTriggerMessageButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[16]/a");
		By triggerMessageId = By.id("triggerMessage");
		By durationInSecondsId = By.id("durationInSeconds");
		By chargingRateUnitId = By.id("chargingRateUnit");
		By GetCompositeButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[17]/a");
		
		
		//Clear Charging Profile 
		
		By ClearChargingButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[18]/a");
		By filterTypeId = By.id("filterType");
		By chargingProfilePkId = By.id("chargingProfilePk");
		By chargingProfilePurposeId = By.id("chargingProfilePurpose");
		By stackLevelId = By.id("stackLevel");
		
		
		
		//Set Charging Profile
		
		By SetChargingButton = By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[19]/a");
		
		
		
	// getters change availability
		
		public WebElement GetSelectAllButton(){
			return driver.findElement(SelectAllButton);
		}
		
		public WebElement GetSelectNoneButton(){
			return driver.findElement(SelectNoneButton);
		}
		
		public WebElement GetchargePointSelectListId(){
			return driver.findElement(chargePointSelectListId);
		}
		
		public WebElement GetconnectorId(){
			return driver.findElement(connectorId);
		}
		   
		public WebElement Getsubmitbutton(){
			return driver.findElement(By.xpath("//*[@class=\"submit-button\"]//input"));
		}
		
		public WebElement GetavailType(){
			return driver.findElement(availType);
		}
		
		public WebElement GetaOperationButton1(){
			return driver.findElement(OperationButton1);
		}
		
		public WebElement GetaOperationButton(){
			return driver.findElement(OperationButton);
		}
		
		
		public WebElement Getcpd() {
			return driver.findElement(cpd);
		}
		
		public Boolean GetcpdExist(){
			return !driver.findElements(cpd).isEmpty();
		}
		
		
		
		
		//getters change configuration 
		
		public WebElement GetkeyTypeId(){
			return driver.findElement(keyTypeId);
		}
		
		public WebElement GetconfKeyId(){
			return driver.findElement(confKeyId);
		}
		
		public WebElement GetcustomConfKeyId(){
			return driver.findElement(customConfKeyId);
		}
		
		public WebElement GetvalueId(){
			return driver.findElement(valueId);
		}

		public WebElement GetchangeConfigButton(){
			return driver.findElement(changeConfigButton);
		}
		
		public WebElement GetValue(){
			return driver.findElement(Valueconf);
		}
		
		public WebElement GetreadOnly(){
			return driver.findElement(readOnly);
		}
		
		
		public WebElement GetKey(){
			return driver.findElement(Keyconf);
		}
		
		//getters Diagnostics 
		 
		
		
		public WebElement GetlocationId(){
			return driver.findElement(locationId);
		}
		
		public WebElement GetretriesId(){
			return driver.findElement(retriesId);
		}
		
		public WebElement GetretryIntervalId(){
			return driver.findElement(retryIntervalId);
		}
		
		public WebElement GetstartId(){
			return driver.findElement(startId);
		}

		
		public WebElement GetstopId(){
			return driver.findElement(stopId);
		}
		
		public WebElement GetgetDiagnosticsButton(){
			return driver.findElement(getDiagnosticsButton);
		}
		
		public WebElement GetperformDiagnosticsButton(){
			return driver.findElement(performDiagnosticsButton);
		}
		
		public WebElement Getres() {
			return driver.findElement(res);
		}
		
		public Boolean GetresExist(){
			return !driver.findElements(res).isEmpty();
		}
		
		//Clear Cache 
		
		public WebElement GetclearCacheButton(){
			return driver.findElement(clearCacheButton);
		}
		
		// getters remote start transaction
		
		public WebElement GetconnectorId2(){
			return driver.findElement(connectorId2);
		}
		
		public WebElement GetidTagId(){
			return driver.findElement(idTagId);
		}
		
		public WebElement GetremotestarttransactionButton(){
			return driver.findElement(remotestarttransactionButton);
		}
		
		public WebElement GettransactionId(){
			return driver.findElement(transactionId);
		}
		public WebElement GetremotestoptransactionButton(){
			return driver.findElement(remotestoptransactionButton);
		}
		
		//getters reset 
		
		public WebElement GetresetTypeId(){
			return driver.findElement(resetTypeId);
		}
		
		public WebElement GetresetButton(){
			return driver.findElement(resetButton);
		}
		
		//getters Unlock Connector
		
		public WebElement GetUnlockConnectorButton(){
			return driver.findElement(UnlockConnectorButton);
		}
		
		//getters Update Firmware
		
		public WebElement GetUpdateFirmwareButton(){
			return driver.findElement(UpdateFirmwareButton);
		}
		
		public WebElement GetretrieveId(){
			return driver.findElement(retrieveId);
		}
		
		public WebElement GetperformUpdateFirmwareButton(){
			return driver.findElement(performUpdateFirmwareButton);
		}
		
		
		
		//getters Reserve Now 
		
		public WebElement GetReserveNowButton(){
			return driver.findElement(ReserveNowButton);
		}
		
		public WebElement GetexpiryId(){
			return driver.findElement(expiryId);
		}
		
		public WebElement GetCancelReservationButton(){
			return driver.findElement(CancelReservationButton);
		}
		
		public WebElement GetreservationId(){
			return driver.findElement(reservationId);
		}
		
		public WebElement GetperformReservationButton(){
			return driver.findElement(performReservationButton);
		}
		
		public WebElement GetperformCancelReservationButton(){
			return driver.findElement(performCancelReservationButton);
		}
		
		
		
		// Getters Data Transfer 
		
		public WebElement GetvendorId(){
			return driver.findElement(vendorId);
		}
		public WebElement GetmessageId(){
			return driver.findElement(messageId);
		}
		
		public WebElement GetdataId(){
			return driver.findElement(dataId);
		}
		
		public WebElement GetDataTransferButton(){
			return driver.findElement(DataTransferButton);
		}
		
		//Getters Get Configuration 
		
		public WebElement GetConfigurationButton(){
			return driver.findElement(GetConfigurationButton);
		}
		public WebElement GetSelectAllButton2(){
			return driver.findElement(SelectAllButton2);
		}
		
		public WebElement GetSelectNoneButton2(){
			return driver.findElement(SelectNoneButton2);
		}
		
		public WebElement GetconfKeyListId(){
			return driver.findElement(confKeyListId);
		}
		
		public WebElement GetcommaSeparatedCustomConfKeysId(){
			return driver.findElement(commaSeparatedCustomConfKeysId);
		}
		
		public WebElement GetGetDetailsConf(){
			return driver.findElement(GetDetailsConf);
		}
		
		
		
		//Getters Get Local List Version 
		
		public WebElement GetLocalListVersionButton(){
			return driver.findElement(GetLocalListVersionButton);
		}
		
		public WebElement SetLocalListVersionButton(){
			return driver.findElement(SetLocalListVersionButton);
		}
		
		public WebElement GetlistVersionId(){
			return driver.findElement(listVersionId);
		}
		
		public WebElement GetupdateTypeId(){
			return driver.findElement(updateTypeId);
		}
		
		public WebElement GetaddUpdateListId(){
			return driver.findElement(addUpdateListId);
		}
		
		public WebElement GetdeleteListId(){
			return driver.findElement(deleteListId);
		}
		
		public WebElement GetsendEmptyListWhenFullId(){
			return driver.findElement(sendEmptyListWhenFullId);
		}
		
		//Getters Trigger Message 
		
		public WebElement GetTriggerMessageButton(){
			return driver.findElement(GetTriggerMessageButton);
		}
		
		public WebElement GettriggerMessageId(){
			return driver.findElement(triggerMessageId);
		}
		
		//Getters Composite Schedule 
		
		public WebElement GetdurationInSecondsId(){
			return driver.findElement(durationInSecondsId);
		}
		
		public WebElement GetchargingRateUnitId(){
			return driver.findElement(chargingRateUnitId);
		}
		
		public WebElement GetCompositeButton(){
			return driver.findElement(GetCompositeButton);
		}
		
		//Clear Charging Profile 
		
		public WebElement GetClearChargingButton(){
			return driver.findElement(ClearChargingButton);
		}
		
		public WebElement GetfilterTypeId(){
			return driver.findElement(filterTypeId);
		}
		public WebElement GetchargingProfilePkId(){
			return driver.findElement(chargingProfilePkId);
		}
		
		public WebElement GetchargingProfilePurposeId(){
			return driver.findElement(chargingProfilePurposeId);
		}
		
		
		
		public WebElement GetstackLevelId(){
			return driver.findElement(stackLevelId);
		}
		
		//Set Charging profile 
		
		public WebElement GetSetChargingButton(){
			return driver.findElement(SetChargingButton);
		}
		
		
		

}
