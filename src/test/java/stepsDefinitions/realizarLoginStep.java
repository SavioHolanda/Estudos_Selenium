package stepsDefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	
	@Before
	public void startDriver() {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	@Dado("que informo o {string} e {string}")
	public void que_informo_o_e(String usuario, String senha) {	
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

	@After(order = 0)
	public void closerDriver() {
		driver.close();
	}

	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
		}
	}
}