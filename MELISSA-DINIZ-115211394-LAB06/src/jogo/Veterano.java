/**
 * 
 */
package jogo;

/**
 * @author melissadg
 *
 */
public class Veterano extends Usuario{

	public Veterano(String nomeUsuario, String login, double dinheiro) throws Exception {
		super(nomeUsuario, login, dinheiro);
	}

	@Override
	public boolean comprarJogos(Jogo jogoRecebido) {
		// TODO Auto-generated method stub
		return false;
	}

}
