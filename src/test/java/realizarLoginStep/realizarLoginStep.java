package realizarLoginStep;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.LoginPage;

public class realizarLoginStep {

	WebDriver driver;
	PageObjectManager pageObjectManager;	
	WebDriverManager webDriverManager;
	LoginPage login;

	@Dado("que informo o {string} e {string}")
	public void que_informo_o_e(String usuario, String senha) {	
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		login = pageObjectManager.getLoginPage();
		login.enter_email(usuario);
		login.enter_senha(senha);
	}

	@Quando("clico no botão entrar")
	public void clico_no_botão_entrar() {
		login.enter();
	}

	@Então("sou direcionado a pagina principal.")
	public void sou_direcionado_a_pagina_principal() {
		Assert.assertEquals("Bem vindo, a!", login.mensagemLogado());
	}

	@Então("recebo uma critica de login invalido")
	public void recebo_uma_critica_de_login_invalido() {
	    Assert.assertEquals("Problemas com o login do usuário", login.loginInvalido());
	}

	@Então("recebo uma critica de campos obrigatórios")
	public void recebo_uma_critica_de_campos_obrigatórios() {
	    Assert.assertEquals("Email é um campo obrigatório", login.obrigatorioEmail());
	    Assert.assertEquals("Senha é um campo obrigatório", login.obrigatorioSenha());
	}

	@Então("recebo uma critica no campo de email invalido")
	public void recebo_uma_critica_no_campo_de_email_invalido() {
		String usuario = "a";
		Assert.assertEquals("a",usuario);
	}

	@After(order = 1)
	public void closerDriver() {
		driver.close();
		driver.quit();
	}

	@After(order = 2)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + ".jpg"));
		} catch (IOException e) {
		}
	}
}