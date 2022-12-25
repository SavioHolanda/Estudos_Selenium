package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage {

	public CadastroPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nome")
	WebElement campoNome;

	@FindBy(id = "email")
	WebElement campoEmail;

	@FindBy(id = "senha")
	WebElement campoSenha;

	@FindBy(css = ".btn")
	WebElement botaoCadastrar;

	@FindBy(css = ".alert")
	WebElement mensagemSucesso;

	public void campoNome(String nome) {
		campoNome.sendKeys(nome);
	}

	public void campoEmail(String email) {
		campoEmail.sendKeys(email);
	}

	public void campoSenha(String senha) {
		campoSenha.sendKeys(senha);
	}

	public void botaoCadastrar() {
		botaoCadastrar.click();
	}

	public String mensagemSucesso() {
		return mensagemSucesso.getText();
	}
}