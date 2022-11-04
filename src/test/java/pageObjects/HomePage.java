package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getApplicationUrl());
	}

	@FindBy(how = How.ID, using = "username")
	private WebElement userName;

	By PasswordInput = By.id("password");
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add_space\"]/input")
	private WebElement submit;

	By tileWrapper = By.className("tileWrapper");
	
	By signOutButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[7]/a");

	By userInput = By.className("userInput");
	
	By aboutButton = By.xpath("/html/body/div[1]/div[2]/div/ul/li[6]/a");
	
	By content = By.className("content");
	
	
	
	public void enter_Username() {
		userName.sendKeys("admin");
	}

	public WebElement GetPasswordInput() {
		return driver.findElement(PasswordInput);
	}

	public WebElement GettileWrapper() {
		return driver.findElement(tileWrapper);
	}

	public Boolean GettileWrapperExist() {
		return !driver.findElements(tileWrapper).isEmpty();
	}

	public void GetSigninButton() {
		submit.click();
	}
	
	public WebElement GetsignOutButton(){
		return driver.findElement(signOutButton);
	}
	
	public WebElement GetuserInput() {
		return driver.findElement(userInput);
	}

	public Boolean GetuserInputExist() {
		return !driver.findElements(userInput).isEmpty();
	}
	

	public Boolean GetsignOutButtonsExist() {
		return !driver.findElements(signOutButton).isEmpty();
	}
	
	public WebElement GetaboutButton(){
		return driver.findElement(aboutButton);
	}
	
	public WebElement Getcontent(){
		return driver.findElement(content);
	}
	public Boolean GetcontentExist() {
		return !driver.findElements(content).isEmpty();
	}
	

}
