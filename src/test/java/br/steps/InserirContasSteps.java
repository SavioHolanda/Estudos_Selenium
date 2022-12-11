package br.steps;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
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

public class InserirContasSteps {

	public WebDriver driver;
	LoginPage login;

	@Dado("que desejo adicionar uma conta")
	public void queDesejoAdicionarUmaConta() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers_Selenium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
		login = new LoginPage(driver);
		login.enter_email("a@a");
		login.enter_senha("a");
		login.enter();
	}

	@Dado("que desejo logar no sistema")
	public void que_desejo_logar_no_sistema() {

	}

	@Quando("informo a conta {string}")
	public void informoAConta(String string) {
		driver.findElement(By.id("nome")).sendKeys(string);
		driver.findElement(By.tagName("button")).click();
	}

	@Então("a conta é inserida com sucesso")
	public void aContaÉInseridaComSucesso() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Conta adicionada com sucesso!", texto);
	}

	@Então("sou notificado que o nome da conta é obrigatório")
	public void souNotificadoQueONomeDaContaÉObrigatório() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Informe o nome da conta", texto);
	}

	@Então("sou notificado que já existe uma conta com esse nome")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Já existe uma conta com esse nome!", texto);
	}

	/*
	 * @After(order = 1) public void screenshot(Scenario cenario) { File file =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
	 * FileUtils.copyFile(file, new
	 * File("target/screenshot/"+cenario.getId()+".jpg")); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
}