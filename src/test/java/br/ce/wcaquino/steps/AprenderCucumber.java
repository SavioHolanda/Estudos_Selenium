package br.ce.wcaquino.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumber {

	@Dado("que criei o arquivo corretamente")
	public void queCrieiOArquivoCorretamente() throws Throwable{

	}
	@Quando("executá-lo")
	public void executáLo() throws Throwable{

	}
	@Então("a especificação deve finalizar com sucesso")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable{

	}

	private int contador = 0;
	
	@Dado("que o valor do contator é {int}")
	public void queOValorDoContatorÉ(int int1) throws Throwable{
		contador = int1;
	}
	@Quando("eu incrementar em {int}")
	public void euIncrementarEm(int int1) throws Throwable{
		contador = contador + int1;

	}
	@Então("o valor do contador será {int}")
	public void oValorDoContadorSerá(int int1) throws Throwable{
		Assert.assertEquals(int1, contador);
	}
	
	Date entrega = new Date();

	@Dado("que a entrega é dia {int}\\/{int}\\/{int}")
	public void queAEntregaÉDia(int dia, int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		entrega = cal.getTime();
	}
	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int int1, String tempo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if(tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, int1);
		}
		if(tempo.equals("meses")) {
			cal.add(Calendar.MONTH, int1);
		}
		entrega = cal.getTime();
	}

	@Então("a entrega será efetuada dia {string}")
	public void aEntregaSeráEfetuadaDia(String data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data,dataFormatada);
	}
}