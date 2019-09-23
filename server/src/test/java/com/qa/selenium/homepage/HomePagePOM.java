package com.qa.selenium.homepage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {

	private WebDriver driver;
	
	@FindBy(id = "textInput")
	private WebElement textInput;
	
	@FindBy(id = "submitInput")
	private WebElement submitInput;
	
	@FindBy(id = "teams")
	private WebElement teamList;
	
	@FindBys ({
		@FindBy(id = "teams"),
		@FindBy(tagName = "li")
	})
	private List<WebElement> listItems;
	
	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addTeam(String text) {
		textInput.sendKeys(text);
		textInput.submit();
	}
	
	public int teamLength() {
		return listItems.size();
	}
	
	public void deleteTeam(String searchText) {
		findTeam(searchText).findElement(By.tagName("button")).click();
	}
	
	public void updateTeam(String searchText, String replaceText) throws InterruptedException {
		WebElement element = findTeam(searchText);
		
		element.findElement(By.tagName("p")).click();
		WebElement input = element.findElement(By.tagName("input"));
		input.clear();
		input.sendKeys(replaceText);
		input.submit();
//		return findTeam(replaceText).findElement(By.tagName("p")).getText();
	}
	
	private WebElement findTeam(String text) {
		for(WebElement element: listItems) {
			if(element.findElement(By.tagName("p")).getText().equals(text)) {
				return element;
			}
		}
		throw new RuntimeException("WebElement not found");
		
	}
	
}
