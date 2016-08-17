/**
 * 
 */
package jogo;

import java.util.ArrayList;
import jogo.Jogo;
import usuario.Usuario;
/**
 * @author Melissa Diniz - 115211394
 *
 */
public class Fachada {
	private ArrayList<Usuario> loja;
	private Usuario user;
	private Jogo j;
	
	public Fachada(){
		loja = new ArrayList<>();
	}
	
	public void vendeJogo(){
		
	}
	
	public boolean addUsuario(Usuario user){
		if (!buscaUser(user)) {
			loja.add(user);
			return true;
		}return false;
	}
	
	public void addDinheiro(String login, int valor) throws Exception{
		//se o user existir na loja
		if (buscaUseLogin(login)) {
			//pega o usuario
			Usuario user = retornaUser(login);
			//delega para o metodo de usuario
			user.adicionaDinheiro(valor);
		}
	}
	
	public void vendeJogo(Jogo jogo){
		user.compraJogos(jogo);
	}
	

	private boolean buscaUser(Usuario user){
		if (loja.contains(user)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o usuario com um login passado
	 * @param login
	 * @return
	 */
	private Usuario retornaUser(String login){
		for (Usuario usuario : loja) {
			if(usuario.getLogin().equalsIgnoreCase(login)){
				return usuario;
			}
		}return null;
	}
	
	/**
	 * procura o usuario na loja atraves do login
	 * @param login
	 * @return
	 * @throws Exception
	 */
	private boolean buscaUseLogin(String login) throws Exception{
		
		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return true;
			}else{
				throw new Exception("Nao existe usuario com esse login.");
			}
		}return false;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder("=== Central P2-CG ===\n");
		double precoTotal = 0.0;
		
		for (Usuario usuario : loja) {
			
			retorno.append(usuario.getLogin()+"\n");
			retorno.append(usuario.getNomeUsuario() + "- Jogador " + usuario.getClass().getName()+"\n");
			retorno.append("Lista de Jogos: \n");
			for (Jogo jogo : usuario.getListaJogos()) {
				precoTotal = precoTotal + jogo.getPreco();
				retorno.append("+ " + jogo.getNome() + " - " + jogo.getClass().getName()+"\n");
				
			}
			retorno.append("==> Jogou " + j.getVezesJogadas() + " vez(es)\n");
			retorno.append("==> Zerou " + j.getVezesZeradas() + " vez(es)\n");
			retorno.append("==> Mario score: " + j.getMaiorScore() + "\n");
			retorno.append("Total de preço dos jogos: R$ " + precoTotal+"\n");
			retorno.append("\n--------------------------------------------");


		}
		return retorno.toString();
	}
}
