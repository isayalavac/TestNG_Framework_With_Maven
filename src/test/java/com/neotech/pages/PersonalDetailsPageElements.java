package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods{
	
	@FindBy(id="pimPersonalDetailsForm")
	public WebElement pimPersonalDetailsForm;
	
	@FindBy(id="employeeId")
	public WebElement peronalDetailId;
	
	public PersonalDetailsPageElements () {
		PageFactory.initElements(driver, this);
	}
		
}
