package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CadastroPage;
import pageObjects.LoginPage;



public class PageObjectManager {

	private WebDriver driver;


	private LoginPage loginPage;
	private CadastroPage cadastroPage;
	

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}
	
	public CadastroPage geCadastroPage() {

		return (cadastroPage == null) ? cadastroPage = new CadastroPage(driver) : cadastroPage;

	}
}
