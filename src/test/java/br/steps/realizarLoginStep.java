package br.steps;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class realizarLoginStep {

	WebDriver driver;
	LoginPage login;

	@Dado("que informo o {string} e {string}")
	public void que_informo_o_e(String usuario, String senha) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers_Selenium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seubarriga.wcaquino.me/login");
		login = new LoginPage(driver);
		login.enter_email("a@a");
		login.enter_senha("a");
	}

	@Quando("clico no botão entrar")
	public void clico_no_botão_entrar() {
		login.enter();
	}

	@Então("sou direcionado a pagina principal.")
	public void sou_direcionado_a_pagina_principal() {
		Assert.assertEquals("Sair", login.ValidarLogin());
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
