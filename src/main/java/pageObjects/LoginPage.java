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

	@FindBy(id = "email")
	WebElement email;

	@FindBy(name = "senha")
	WebElement senha;

	@FindBy(tagName = "button")
	WebElement button;

	@FindBy(css = ".alert")
	WebElement MensagemLogado;

	@FindBy(xpath = "//a[contains(text(),'Novo usuário?')]")
	WebElement novoUsuario;
	
	@FindBy(css = ".alert:nth-child(2)")
	WebElement obrigatorioEmail;
	
	@FindBy(css = ".alert:nth-child(3)")
	WebElement obrigatorioSenha;
	
	@FindBy(xpath = "//div[contains(text(),'Problemas com o login do usuário')]")
	WebElement loginInvalido;

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

	public void novoUsuario() {
		novoUsuario.click();
	}
	
	public String obrigatorioEmail() {
		return obrigatorioEmail.getText();
	}
	
	public String obrigatorioSenha() {
		return obrigatorioSenha.getText();
	}
	
	public String loginInvalido() {
		return loginInvalido.getText();
	}

	// Metodos
	// para aguardar e caso passe do tempo de o exception
	/*
	 * try { Thread.sleep(2000);} catch (InterruptedException e) {}
	 */

}