package br.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	// Interação com a Página duas formas de fazer
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="senha")
	WebElement senha;
	
	@FindBy(tagName ="button")
	WebElement button;
	
	@FindBy(linkText = "Sair")
	WebElement Sair;
	
	
	
	public void enter_email(String eemail) {
		email.sendKeys(eemail);
	}
	
	public void enter_senha(String esenha) {
		senha.sendKeys(esenha);
	}
	
	public void enter() {
		button.click();
	}
	
	public String ValidarLogin() {
		return Sair.getText();
	}
	
	//Metodos

  }