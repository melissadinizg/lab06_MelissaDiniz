/**
 * 
 */
package jogo;

/**
 * @author melissadg
 *
 */
public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore, vezesJogadas, vezesZeradas;
	private boolean zerou;
	private Jogabilidade tipo;
	
	/**
	 * Construtor do jogo
	 * @param nome
	 * @param preco
	 * @throws Exception 
	 */
	public Jogo(String nome, double preco) throws Exception{
		testaNomeJogo(nome);
		testaPrecoJogo(preco);
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesZeradas = 0;
		
	}
	
	/**
	 * 
	 * @param score
	 * @param zerou
	 */
	public void registraJogada(int score, boolean zerou){
		if(maiorScore < score){
			maiorScore = score;
		}if(zerou == true){
			
			vezesZeradas ++;
		}
	}
	
	/**
	 * Metodo que testa a validade do nome do jogo
	 * 
	 * @param nome
	 * @throws Exception
	 */
	private void testaNomeJogo(String nome) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome do jogo nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que testa a validade do preco do jogo
	 * 
	 * @param nome
	 * @throws Exception
	 */
	private void testaPrecoJogo(double preco) throws Exception {
		if (preco <= 0.0) {
			throw new Exception("Preco do jogo nao deve ser menor que zero.");
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
}
