/**
 * 
 */
package usuario;

import java.util.ArrayList;

import jogo.Jogo;

/**
 * @author melissadg
 *
 */
public abstract class Usuario {
	private String nomeUsuario, login;
	private double dinheiro;
	private ArrayList<Jogo> listaJogos;
	private int x2p;
	private Jogo jogo;

	/**
	 * Construtor do Usuario
	 * 
	 * @param nomeUsuario
	 * @param login
	 * @param dinheiro
	 * @throws Exception
	 */
	public Usuario(String nomeUsuario, String login, double dinheiro) throws Exception {
		testaNomeUsuario(nomeUsuario);
		testaLogin(login);
		testaDinheiro(dinheiro);
		
		this.nomeUsuario = nomeUsuario;
		this.login = login;
		this.dinheiro = dinheiro;
		this.listaJogos = new ArrayList<>();
	}


	/**
	 * Metodo que realiza a compra dos jogos
	 * 
	 * @param jogoRecebido
	 * @return
	 */
	public boolean compraJogos(Jogo jogoRecebido) {
		if (!existeJogo(jogoRecebido)) {
			return listaJogos.add(jogoRecebido);
		}
		//ou exception de jogo ja comprado
		return false;
	}
	
	/**
	 * Metodo que atualiza o valor do x2p do usuario
	 * @param jogoRecebido
	 * @return x2p
	 */
	public int calculaX2p(Jogo jogoRecebido){
		int somaValor = this.getX2p() + (int)jogoRecebido.getPreco() * bonusX2p();
		this.setX2p(somaValor);
		return this.getX2p();
	}
	
	/**
	 * verifica se o jogo ja existe na lista de jogos
	 * @param jogoRecebido
	 * @return true se o jogo estiver na lista de jogos
	 * @throws Exception 
	 */
	public boolean existeJogo(Jogo jogoRecebido) {
		for (Jogo jogo : listaJogos) {
			if (jogo.equals(jogoRecebido)) {
				return true;
			}
		}
		return false;
	}
	
	void registraJogada(String nomeDoJogo, int score, boolean zerou){
		jogo.registraJogada(score, zerou);
	}
	
	/**
	 * Metodo abstrado qusado para pegar o valor do bonus do usuario
	 * @return
	 */
	abstract int bonusX2p();
	
	/**
	 * 
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public boolean adicionaDinheiro(double valor) throws Exception{
		
		if (valor < 0) {
			throw new Exception("Valor precisa ser maior que zero.");
		}else{
			
			this.setDinheiro(this.getDinheiro() + valor);
			return true;
		}
	}
	
	/**
	 * Metodo que testa a validade do nome do usuario
	 * 
	 * @param nome
	 * @throws Exception
	 */
	private void testaNomeUsuario(String nome) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome do usuario nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * Metodo que testa a validade do jogo
	 * 
	 * @param nome
	 * @throws Exception
	 */
	private void testaJogo(Jogo jogo) throws Exception {
		if (jogo == null) {
			throw new Exception("Jogo nao pode ser nulo.");
		}
	}
	
	
	/**
	 * Metodos que testa a validade do login do usuario
	 * 
	 * @param login
	 * @throws Exception
	 */
	private void testaLogin(String login) throws Exception {
		if (login == null || login.trim().equals("")) {
			throw new Exception("Login do usuario nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodos que testa a validade do login do usuario
	 * 
	 * @param login
	 * @throws Exception
	 */
	private void testaDinheiro(double dinheiro) throws Exception {
		if (dinheiro < 0.0) {
			throw new Exception("Dinheiro precisa ser maior ou igual a zero.");
		}
	}

	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}

	public void setListaJogos(ArrayList<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}
	
	/**
	 * @return the x2p
	 */
	public int getX2p() {
		return x2p;
	}


	/**
	 * @param x2p the x2p to set
	 */
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
