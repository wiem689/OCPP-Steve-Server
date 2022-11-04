package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class Settings {
	
	
	WebDriver driver;

	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_Settings() {
		driver.get(FileReaderManager.getInstance().getApplicationUrl());
	}
	
	
By SettingsButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[4]/a");
By heartbeat = By.id("heartbeat");
By expirationId = By.id("expiration");
By enabledId = By.id("enabled1");
By protocolId = By.id("protocol");

By hostId = By.id("host");
By portId = By.id("port");;
By fromId = By.id("from");
By usernameId = By.id("username");

By passwordId = By.id("password");
By recipientsId = By.id("recipients");
By enabledFeatures1Id = By.id("enabledFeatures1");
By enabledFeatures2Id = By.id("enabledFeatures2");
By enabledFeatures3Id = By.id("enabledFeatures3");
By enabledFeatures4Id = By.id("enabledFeatures4");
By enabledFeatures5Id = By.id("enabledFeatures5");

By enabledFeatures6Id = By.id("enabledFeatures6");
By changeSettingsButton = By.xpath("//*[@id=\"add_space\"]/input[1]");
By sendTextMailButton = By.xpath("//*[@id=\"add_space\"]/input[2]");	




	public WebElement GetSettingsButton(){
		return driver.findElement(SettingsButton);
	}
	
	public WebElement Getheartbeat(){
		return driver.findElement(heartbeat);
	}
	
	public WebElement GetexpirationId(){
		return driver.findElement(expirationId);
	}
	
	
	public WebElement GetenabledId(){
		return driver.findElement(enabledId);
	}
	
	public WebElement GetprotocolId(){
		return driver.findElement(protocolId);
	}
	
	public WebElement GethostId(){
		return driver.findElement(hostId);
	}
	
	public WebElement GetportId(){
		return driver.findElement(portId);
	}
	
	public WebElement GetfromId(){
		return driver.findElement(fromId);
	}
	
	public WebElement GetusernameId(){
		return driver.findElement(usernameId);
	}
	
	public WebElement GetpasswordId(){
		return driver.findElement(passwordId);
	}

	public WebElement GetrecipientsId(){
		return driver.findElement(recipientsId);
	}
	
	public WebElement GetenabledFeatures1Id(){
		return driver.findElement(enabledFeatures1Id);
	}
	
	public WebElement GetenabledFeatures2Id(){
		return driver.findElement(enabledFeatures2Id);
	}
	
	public WebElement GetenabledFeatures3Id(){
		return driver.findElement(enabledFeatures3Id);
	}
	
	public WebElement GetenabledFeatures4Id(){
		return driver.findElement(enabledFeatures4Id);
	}
	
	public WebElement GetenabledFeatures5Id(){
		return driver.findElement(enabledFeatures5Id);
	}
	
	public WebElement GetenabledFeatures6Id(){
		return driver.findElement(enabledFeatures6Id);
	}
	
	public WebElement GetchangeSettingsButton(){
		return driver.findElement(changeSettingsButton);
	}
	
	public WebElement GetsendTextMailButton(){
		return driver.findElement(sendTextMailButton);
	}
	
	
	
	
}
