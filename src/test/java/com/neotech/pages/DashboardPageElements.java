package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	
	@FindBy(xpath="//li[@id='menu_pim_viewPimModule']/a/span[2]")
	public WebElement PIM;
	
	@FindBy(linkText="Add Employee")
	public WebElement addEmployeeBtn;
	
	@FindBy(xpath="//div[@id='modal-holder']/div/div/div")
	public WebElement employeeInfoScreen;
	
			@FindBy(id="first-name-box")
			public WebElement firstNameBox;
			
			@FindBy(id="last-name-box")
			public WebElement lastNameBox;
			
			@FindBy(id="employeeId")
			public WebElement employeeId;
			
			@FindBy(id="location")
			public WebElement locationDD;
			
			@FindBy(xpath="//label[@for='hasLoginDetails']")
			public WebElement hasLoginDetails;
					
				   @FindBy(id="username")
				   public WebElement username;
				   
				   @FindBy(id="status_Enabled")
				   public WebElement statusEnabled;
				   
				   @FindBy(id="password")
				   public WebElement password;
				   
				   @FindBy(id="confirmPassword")
				   public WebElement confirmPassword;			   
				   
				   @FindBy(xpath="//div[contains(text(),'Default ESS')]")
				   public WebElement essRoleId;	
				   
				   @FindBy(xpath="//div[contains(text(),'Default Supervisor')]")
				   public WebElement defaultSupervisor;
				   
				   @FindBy(xpath="//select[@id='adminRoleId']")
				   public WebElement adminRoleId;
				   
				   @FindBy(xpath="//label[@id='photo-preview-lable']")
				   public WebElement employeePicture;
				   
				   @FindBy(id="modal-save-button")
				   public WebElement saveButton;
				   
			
	
	@FindBy(id="account-name")
	public WebElement accountName;
	

	
	
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
}
