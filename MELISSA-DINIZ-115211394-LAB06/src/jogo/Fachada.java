/**
 * 
 */
package jogo;

import java.util.ArrayList;

import usuario.Usuario;

/**
 * @author Melissa
 *
 */
public class Fachada {
private ArrayList<Usuario> loja;
	
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
}
