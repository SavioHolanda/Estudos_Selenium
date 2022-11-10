package br.ce.wcaquino.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class AlugarFilmesSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;

	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(int int1) {
		filme = new Filme();
		filme.setEstoque(int1);
	
	}
	@Dado("o preço do aluguel seja R$ {int}")
	public void oPreçoDoAluguelSejaR$(int int1) {
	   filme.setAluguel(int1);
	}
	@Quando("alugar")
	public void alugar() {
	    aluguel.alugar(filme);
	    nota = aluguel.alugar(filme);
	}
	@Então("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(int int1) {
	    Assert.assertEquals(int1, nota.getPreco());
	}
	@Então("a data de entrega será no dia seguinte")
	public void aDataDeEntregaSeráNoDiaSeguinte() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,1);
		
		Date dataRetorno = nota.getDataEntrega();
		Calendar calRetorno = Calendar.getInstance();
		calRetorno.setTime(dataRetorno);
		
		Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
		Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));

	}
	@Então("o o estoque do final sejá {int} unidade")
	public void oOEstoqueDoFinalSejáUnidade(int int1) {
		Assert.assertEquals(int1, filme.getEstoque());
	}
	
	
	

	@Dado("um file com o estoque de {int} unidades")
	public void umFileComOEstoqueDeUnidades(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Então("não será possivel por falta de estoque")
	public void nãoSeráPossivelPorFaltaDeEstoque() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Então("o estoque do filme será {int} unidades")
	public void oEstoqueDoFilmeSeráUnidades(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
