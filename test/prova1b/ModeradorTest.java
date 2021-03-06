package prova1b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModeradorTest {

	@Test
	public void novoGrupoComUmParticipanteTest() { 
		Moderador gustavo = new Moderador("Gustavo");
		
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");		
		Assertions.assertEquals(1, turmaOO2.getParticipantes().size());		
		Assertions.assertEquals("Gustavo", turmaOO2.getParticipantes().get(0).getNome());
	}
	@Test
	public void criarGrupoTest() { 
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		Assertions.assertNotNull(turmaOO2);
	}

	@Test
	public void criarGrupoComNomeTest() {
		Moderador gustavo = new Moderador("Gustavo"); 
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		Assertions.assertEquals("Turma OO2", turmaOO2.getNome());
	}
	
	@Test
	public void adicionarParticipanteTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		
		Usuario fulano = new Usuario("Fulano");
		try {
			gustavo.addicionarParticipante(fulano);
		} catch (ObjetoNulo e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		Assertions.assertEquals(2, turmaOO2.getParticipantes().size());
	}
	
	@Test
	public void adicionarVariosParticipantesTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		
		Usuario fulano = new Usuario("Fulano");
		Usuario beltrano = new Usuario("Beltrano");
		Usuario ciclano = new Usuario("Ciclano");
		try {
			gustavo.addicionarParticipante(fulano);
			gustavo.addicionarParticipante(beltrano);			
			gustavo.addicionarParticipante(ciclano);
		} catch (ObjetoNulo e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		Assertions.assertEquals(4, turmaOO2.getParticipantes().size());
	}
	
	@Test
	public void removerParticipanteTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		
		Usuario fulano = new Usuario("Fulano");
		try {
			gustavo.addicionarParticipante(fulano);
			gustavo.removerParticipante(fulano);
		} catch (ObjetoNulo e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

		
		Assertions.assertEquals(1, turmaOO2.getParticipantes().size());
	}
	
	@Test
	public void confirmarRemocaoDeParticipanteTest() {
		Moderador gustavo = new Moderador("Gustavo");
		gustavo.criarGrupo("Turma OO2");
		
		Usuario fulano = new Usuario("Fulano");
		try {
			gustavo.addicionarParticipante(fulano);
		} catch (ObjetoNulo e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
		boolean confirmacao = gustavo.removerParticipante(fulano);
		Assertions.assertEquals(true, confirmacao);
	}
	
	
	@Test
	public void removerParticipanteSemInserirAntesTest() {
		Moderador gustavo = new Moderador("Gustavo");
		gustavo.criarGrupo("Turma OO2");
		
		boolean confirmacao = gustavo.removerParticipante(new Usuario("Fulano"));
		Assertions.assertEquals(false, confirmacao);
	}

	
	@Test
	public void grupoSemMensagemTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		
		Assertions.assertEquals(0, turmaOO2.getMensagens().size());
	}
	
	@Test
	public void enviarMensagemTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		gustavo.enviaMensagem("Oi pessoal", turmaOO2);
		
		Assertions.assertEquals(1, turmaOO2.getMensagens().size());
	}
	
	@Test
	public void enviarVariasMensagensTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		gustavo.enviaMensagem("Oi pessoal", turmaOO2);
		gustavo.enviaMensagem("Tudo bem?", turmaOO2);
		gustavo.enviaMensagem("Como está a prova?", turmaOO2);
		gustavo.enviaMensagem("Estudaram?", turmaOO2);
		
		Assertions.assertEquals(4, turmaOO2.getMensagens().size());
	}
	
	@Test
	public void lerUltimaMensagemTest() {
		Moderador gustavo = new Moderador("Gustavo");
		Grupo turmaOO2 = gustavo.criarGrupo("Turma OO2");
		gustavo.enviaMensagem("Oi pessoal", turmaOO2);
		gustavo.enviaMensagem("Tudo bem?", turmaOO2);
		gustavo.enviaMensagem("Como está a prova?", turmaOO2);
		gustavo.enviaMensagem("Estudaram?", turmaOO2);
		
		Mensagem ultima = turmaOO2.getMensagens().get(turmaOO2.getMensagens().size()-1);
		
		Assertions.assertEquals("Estudaram?", ultima.getShortMensagem());
	}

}
