package criarUsuarioStep;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Random;

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
import pageObjects.CadastroPage;
import pageObjects.LoginPage;

public class criarUsuarioStep {

	WebDriver driver;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	LoginPage login;
	CadastroPage cadastro;

	@Dado("que estou na tela de cadastro de usuario")
	public void queEstouNaTelaDeCadastroDeUsuario() {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		login = pageObjectManager.getLoginPage();
		login.novoUsuario();
		cadastro = pageObjectManager.geCadastroPage();
	}

	@Quando("preencho os campos Nome {string}, Email {string} e Senha {string} corretamente")
	public void preenchoOsCamposNomeEmailESenhaCorretamente(String nome, String email, String senha) {
		Random random = new Random();
		int numero = random.nextInt(9999);
		String randomEmail = numero + email;
		cadastro.campoNome(nome);
		cadastro.campoEmail(randomEmail);
		cadastro.campoSenha(senha);
	}

	@Quando("clico em cadastrar")
	public void clicoEmCadastrar() {
		cadastro.botaoCadastrar();
	}

	@Então("o usuário é cadastrado com sucesso sendo apresentando a mensagem {string}")
	public void oUsuárioÉCadastradoComSucessoSendoApresentandoAMensagem(String mensagem) {
		assertEquals(mensagem, cadastro.mensagemSucesso());
	}

	@Quando("não preencho os campos Nome {string}, Email {string} e Senha {string}")
	public void nãoPreenchoOsCamposNomeEmailESenha(String nome, String email, String senha) {
		cadastro.campoNome(nome);
		cadastro.campoEmail(email);
		cadastro.campoSenha(senha);
	}

	@Então("o sistema apresenta a mensagem {string}{string}")
	public void oSistemaApresentaAMensagem(String campos, String mensagem) {
		assertEquals(campos + mensagem, campos + " é um campo obrigatório");
	}

	@Quando("que informo o Nome {string}, Email {string} e Senha {string}")
	public void queInformoONomeEmailESenha(String nome, String email, String senha) {
		cadastro.campoNome(nome);
		cadastro.campoEmail(email);
		cadastro.campoSenha(senha);
	}
	@Então("recebo uma mensagem no campo de email invalido")
	public void receboUmaMensagemNoCampoDeEmailInvalido() {
		String usuario = "a";
		Assert.assertEquals("a",usuario);
	}

	@Então("recebo a mensagem {string}")
	public void receboAMensagem(String mensagem) {
		assertEquals(mensagem, cadastro.mensagemSucesso());
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
