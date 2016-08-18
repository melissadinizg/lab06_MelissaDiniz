/**
 * 
 */
package jogo;

import java.util.ArrayList;
import jogo.Jogo;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class Fachada {
	private ArrayList<Usuario> loja;
	private Usuario user;
	private Jogo j;

	public Fachada() {
		loja = new ArrayList<>();
	}

	/**
	 * Faz o upgrade do usuario
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public boolean upgrade(String login) throws Exception {
		
		Usuario user = retornaUser(login);
		
		//se for null eh pq nao existe usuario com o login dado 
		if (user != null) {
			//verifica se eh veterano 
			if (user.getClass() != Veterano.class) {
				
				//pegando os dados do usuario noob
				int x2pNovo = this.user.getX2p();
				String nomeUser = this.user.getNomeUsuario();
				String loginUser = this.user.getLogin();
				double dinheiro = this.user.getDinheiro(); 
				
				if (user.getX2p() >= 1000) {
					this.user = new Veterano(nomeUser, loginUser, dinheiro);
					this.user.setX2p(x2pNovo);
					return true;
				}
			}
		} else {
			throw new Exception("Nao foi possivel upar usuario.");
		}
		return false;
	}

	/**
	 * Adiciona o usuario a lista se ele ainda nao for cadastrado
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean addUsuario(Usuario user) {
		if (!buscaUser(user)) {
			loja.add(user);
			return true;
		}
		return false;
	}

	/**
	 * Adiciona dinheiro na conta do usuario usando o login passado no parametro
	 * 
	 * @param login
	 * @param valor
	 * @throws Exception
	 */
	public void addDinheiro(String login, int valor) throws Exception {
		// se o user existir na loja
		if (buscaUserLogin(login)) {
			// pega o usuario
			Usuario user = retornaUser(login);
			// delega para o metodo de usuario
			user.adicionaDinheiro(valor);
		}
	}

	/**
	 * Vende o jogo para o usuario se possuir dinheiro suficiente
	 * 
	 * @param jogo
	 * @throws Exception
	 */
	public void vendeJogo(Jogo jogo) throws Exception {
		if (jogo != null) {
			user.compraJogos(jogo);
		} else {
			throw new Exception("O jogo nao pode ser nulo.");
		}

	}

	/**
	 * Faz a busca do usuario
	 * 
	 * @param user
	 * @return
	 */
	private boolean buscaUser(Usuario user) {
		if (loja.contains(user)) {
			return true;
		}
		return false;
	}

	/**
	 * Retorna o usuario com um login passado
	 * 
	 * @param login
	 * @return
	 */
	private Usuario retornaUser(String login) {
		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return usuario;
			}
		}
		return null;
	}

	/**
	 * procura o usuario na loja atraves do login
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	private boolean buscaUserLogin(String login) {

		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder("=== Central P2-CG ===\n");
		double precoTotal = 0.0;

		for (Usuario usuario : loja) {

			retorno.append(usuario.getLogin() + "\n");
			retorno.append(usuario.getNomeUsuario() + "- Jogador " + usuario.getClass().getName() + "\n");
			retorno.append("Lista de Jogos: \n");
			for (Jogo jogo : usuario.getListaJogos()) {
				precoTotal = precoTotal + jogo.getPreco();
				retorno.append("+ " + jogo.getNome() + " - " + jogo.getClass().getName() + "\n");

			}
			retorno.append("==> Jogou " + j.getVezesJogadas() + " vez(es)\n");
			retorno.append("==> Zerou " + j.getVezesZeradas() + " vez(es)\n");
			retorno.append("==> Mario score: " + j.getMaiorScore() + "\n");
			retorno.append("Total de preço dos jogos: R$ " + precoTotal + "\n");
			retorno.append("\n--------------------------------------------");

		}
		return retorno.toString();
	}
}
