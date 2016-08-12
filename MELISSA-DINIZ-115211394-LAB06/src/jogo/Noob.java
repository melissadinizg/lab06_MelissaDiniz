/**
 * 
 */
package jogo;

import jogo.Jogo;

/**
 * @author melissadg
 *
 */
public class Noob extends Usuario {
	private double DESCONTO_NOOB = 01;
	private int x2p;

	public Noob(String nomeUsuario, String login, double dinheiro) throws Exception {
		super(nomeUsuario, login, dinheiro);
		this.x2p = 0;
	}

	public double calculaDesconto(Jogo jogoRecebido) {
		double precoComDesconto = jogoRecebido.getPreco() - (jogoRecebido.getPreco() * DESCONTO_NOOB);

		return precoComDesconto;
	}

}

