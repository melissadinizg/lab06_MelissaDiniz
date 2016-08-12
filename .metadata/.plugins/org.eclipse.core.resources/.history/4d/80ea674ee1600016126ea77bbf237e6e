/**
 * 
 */
package jogo;
import jogo.Jogo;

/**
 * @author melissadg
 *
 */
public class Veterano extends Usuario{
	private double DESCONTO_VETERANO = 0.3;
	private int x2p;
	
	public Veterano(String nomeUsuario, String login, double dinheiro) throws Exception {
		super(nomeUsuario, login, dinheiro);
		this.x2p = 1000;
	}
	
	public double calculaDesconto(Jogo jogoRecebido) {
		double precoComDesconto = jogoRecebido.getPreco() - (jogoRecebido.getPreco() * DESCONTO_VETERANO);
		
		return precoComDesconto;
	}

	
	}


