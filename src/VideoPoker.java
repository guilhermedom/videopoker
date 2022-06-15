import java.io.IOException;

/** 
* Esta classe executa o jogo mostrando as saídas para o usuário e recebendo entradas do mesmo.
* @author Vitor Augusto Henrique Brisola
* Nº USP = 9791292
* @author Guilherme Domingos Faria Silva
* Nº USP = 9361094
*/
public class VideoPoker {
	/** 
	 * O método main, único método da classe, apenas cuida da execução do programa como o mesmo deve ser executado.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Embaralhar baralho = new Embaralhar();
		Usuario jogador = new Usuario();
		int op = 1;
		int aposta;
		int rodada = 1;
		
		System.out.println("Você inicia o jogo com 200 créditos.");
		System.out.println("Naipes das cartas: C = Copas, E = Espadas, O = Ouros e P = Paus.");
		while (op == 1)
		{
			System.out.println("Pressione ENTER para iniciar a rodada: ");
			@SuppressWarnings("unused")
			String enter = EntradaTeclado.leString();
			
			System.out.println("Rodada " + rodada);
			baralho.embaralharCartas();
			
			do {
				System.out.println("Digite quantos créditos você irá apostar (maior que 0): ");
				aposta = EntradaTeclado.leInt();
				if (aposta > jogador.getCreditos()) {
					aposta = 0;
					System.out.println("Créditos insuficientes!");
				}
			} while (aposta <= 0);
			
			jogador.setCreditos(jogador.getCreditos() - aposta);
			System.out.println("Aposta feita.\nCréditos não apostados restantes: " + jogador.getCreditos());
			System.out.println("\nVocê tem as seguintes cartas na sua mão: ");
			baralho.trocar("1 2 3 4 5");
			System.out.println(baralho.toString());
			
			for(int i = 0; i < 2; i++) {
				// Escolha das cartas a serem descartadas
				System.out.println("\nEscolha as cartas a serem descartadas (exemplo: 1 3 2), ou pressione ENTER para manter as cartas atuais: ");
				String troca_cartas = new String();
				troca_cartas = EntradaTeclado.leString();
				
				// Trocar cartas selecionadas
				baralho.trocar(troca_cartas);
				System.out.println("\nEstas são as novas cartas na sua mão: ");
				System.out.println(baralho.toString());
			}	
			// Pontuação atualizada
			jogador.CalculaCreditos(baralho.getCartas(), aposta);
			System.out.println("Seus créditos atuais são: " + jogador.getCreditos());
			
			if (jogador.getCreditos() <= 0) {
				System.out.println("\nVocê não tem mais créditos para apostar.");
				break;
			}
			do
			{
				System.out.println("Digite 1 para continuar jogando e 0 para parar de jogar: ");
				op = EntradaTeclado.leInt();
			} while (op != 1 && op != 0);
			rodada++;
		}
		
		System.out.println("\nFim de jogo!\nVocê terminou com " + jogador.getCreditos() + " créditos.");
	}
}
