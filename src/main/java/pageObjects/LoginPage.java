package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	@FindBy(css = ".alert")
	WebElement MensagemLogado;	
	
	public void enter_email(String eemail) {
		email.sendKeys(eemail);
	}
	
	public void enter_senha(String esenha) {
		senha.sendKeys(esenha);
	}
	
	public void enter() {
		button.click();
	}
	
	public String mensagemLogado() {
		return MensagemLogado.getText();
	}
	
	//Metodos
	//para aguardar e caso passe do tempo de o exception
	/*
	 * try { Thread.sleep(2000);} catch (InterruptedException e) {}
	 */

  }