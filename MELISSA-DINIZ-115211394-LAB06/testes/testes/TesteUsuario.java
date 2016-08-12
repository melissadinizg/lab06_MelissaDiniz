/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.RPG;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author Melissa
 *
 */
public class TesteUsuario {
	private Usuario maria;
	private Usuario joao;
	private Usuario kleber;

	@Before
	public void criaUsuario() throws Exception {
		maria = new Noob("Maria", "maria123", 500.0);
		joao = new Veterano("Joao", "j123", 10.0);
		kleber = new Noob("Kleber", "klebinho", 150);
	}
	
	@Test
	public void testCompraJogo() throws Exception{
		Jogo jogo1 = new RPG("Jogo1", 15.0);
		Jogo jogo2 = new Luta("Jogo2", 35.0);
		
		assertTrue(maria.compraJogos(jogo2));
	}
	
	@Test
	public void testUsuario(){
		//testa getNome e getLogin
		assertEquals("Joao", joao.getNomeUsuario());
		assertNotEquals("Lucas", joao.getNomeUsuario());
		assertEquals("j123", joao.getLogin());
		
		//excecao nome vazio
		try {
			maria = new Noob("", "maria1", 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao login nulo
		try {
			maria = new Veterano("Maria", null, 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Login do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao valor dinheiro negativo
		try {
			maria = new Veterano("Maria", "mariacg", -2.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Dinheiro precisa ser maior ou igual a zero.", e.getMessage());
		}
	}
}