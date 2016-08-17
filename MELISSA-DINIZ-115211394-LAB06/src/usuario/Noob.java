/**
 * 
 */
package usuario;

import jogo.Jogo;

/**
 * @author melissadg
 *
 */
public class Noob extends Usuario {
	private double DESCONTO_NOOB = 0.1;

	public Noob(String nomeUsuario, String login, double dinheiro) throws Exception {
		super(nomeUsuario, login, dinheiro);
		super.setX2p(0);
	}
<<<<<<< HEAD

	// aki o metodo calcula internamente na classe o proprio desconto e apenas
	// chama o metodo em usuario pra guardar o jogo
	public boolean compraJogos(Jogo jogoRecebido) {

		double precoComDesconto = jogoRecebido.getPreco() - (jogoRecebido.getPreco() * DESCONTO_NOOB);

		if (precoComDesconto <= super.getDinheiro()) {
=======
	//aki o metodo calcula internamente na classe o proprio desconto e apenas chama o metodo em usuario pra guardar o jogo
	public boolean compraJogos(Jogo jogoRecebido){
		double precoComDesconto = jogoRecebido.getPreco() - (jogoRecebido.getPreco() * DESCONTO_NOOB);
		if(precoComDesconto <= super.getDinheiro()){
>>>>>>> dbf142eeb6d1e1640905545ba534c7fe676de32f
			super.setDinheiro(super.getDinheiro() - precoComDesconto);
			return super.compraJogos(jogoRecebido);
		}
		return false;
	}
<<<<<<< HEAD

	/**
	 * Sobreescrita do metodo calculaX2p aplicando o desconto no valor do preco
	 */
	public int bonusX2p() {
		return 10;

	}
}
=======
}
>>>>>>> dbf142eeb6d1e1640905545ba534c7fe676de32f
