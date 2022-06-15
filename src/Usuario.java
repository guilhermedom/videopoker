
/**	
 * Esta classe armazena dados sobre o jogador e calcula a premiação em créditos do jogador.
 * @author Vitor Augusto Henrique Brisola
 * Nº USP = 9791292
 * @author Guilherme Domingos Faria Silva
 * Nº USP = 9361094
 */

public class Usuario {
	private int creditos;
	
	/** 
	 * Este construtor instancia um objeto Usuario com os 200 créditos iniciais de um jogador.
	 */
	public Usuario() {
		creditos = 200;
	}
	
	/**
	 * Responsável por calcular a premiação do jogador de acordo com a combinação de cartas obtida de suas mãos. 
	 * Atribuindo o prêmio aos créditos do jogador diretamente e informando seu desempenho na rodada.
	 * @param Todas as cartas presentes na mão do jogador.
	 * @param O valor da aposta na rodada do usuário.
	 */
	public void CalculaCreditos(int[][] cartas, int aposta) {
		
		int comb = 0;
		
		// Royal Straight Flush
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (cartas[j][0] == j + 8 && cartas[j][1] == i)
					comb = 1;
				else {
					comb = 0;
					break;
				}
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu um Royal Straight Flush! Você recebe 200x a sua aposta.");
			creditos += 200 * aposta;
			return;
		}
		
		// Straight Flush
		comb = 0;
		for (int i = 1; i < 5; i++) {
			if (cartas[i][1] == cartas[i-1][1] && cartas[i][0] == cartas[i-1][0] + 1)
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu um Straight Flush! Você recebe 100x a sua aposta.");
			creditos += 100 * aposta;
			return;
		}
		
		// Quadra
		comb = 0;
		for (int i = 1; i < 4; i++) {
			if (cartas[i][0] == cartas[i-1][0])
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu uma Quadra! Você recebe 50x a sua aposta.");
			creditos += 50 * aposta;
			return;
		}
		
		for (int i = 2; i < 5; i++) {
			if (cartas[i][0] == cartas[i-1][0])
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu uma Quadra! Você recebe 50x a sua aposta.");
			creditos += 50 * aposta;
			return;
		}
		
		// Full Hand
		comb = 0;
		int aux = 0;
		for (int i = 1; i < 5; i++) {
			if (cartas[i][0] == cartas[i-1][0]) {
				comb = 1;
				aux++;
			}
			else {
				if (aux > 0) {
					comb = 1;
					aux = 0;
					continue;
				}
				else {
					comb = 0;
					break;
				}
			}
		}
		if (comb == 1 && (aux == 2 || aux == 1)) {
			System.out.println("Você conseguiu um Full Hand! Você recebe 20x a sua aposta.");
			creditos += 20 * aposta;
			return;
		}
		
		// Flush
		comb = 0;
		for (int i = 1; i < 5; i++) {
			if (cartas[i][1] == cartas[i-1][1])
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu um Flush! Você recebe 10x a sua aposta.");
			creditos += 10 * aposta;
			return;
		}
		
		// Straight
		comb = 0;
		for (int i = 1; i < 5; i++) {
			if (cartas[i][0] == cartas[i-1][0] + 1)
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu um Straight! Você recebe 5x a sua aposta.");
			creditos += 5 * aposta;
			return;
		}
		
		// Trinca
		comb = 0;
		for (int i = 1; i < 3; i++) {
			if (cartas[i][0] == cartas[i-1][0])
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu uma Trinca! Você recebe 2x a sua aposta.");
			creditos += 2 * aposta;
			return;
		}
		
		for (int i = 2; i < 4; i++) {
			if (cartas[i][0] == cartas[i-1][0])
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu uma Trinca! Você recebe 2x a sua aposta.");
			creditos += 2 * aposta;
			return;
		}
		
		for (int i = 3; i < 5; i++) {
			if (cartas[i][0] == cartas[i-1][0])
				comb = 1;
			else {
				comb = 0;
				break;
			}
		}
		if (comb == 1) {
			System.out.println("Você conseguiu uma Trinca! Você recebe 2x a sua aposta.");
			creditos += 2 * aposta;
			return;
		}
		
		// Dois pares
		comb = 0;
		for (int i = 1; i < 5; i++) {
			if (cartas[i][0] == cartas[i-1][0]) {
				comb++;
				i++;
			}
		}
		if (comb == 2) {
			System.out.println("Você conseguiu Dois Pares! Você recebe 1x a sua aposta.");
			creditos += aposta;
			return;
		}
		
		// Nenhuma combinação
		System.out.println("Você não conseguiu nenhuma combinação nesta rodada. Você não recebe nada.");
	}

	/**
	 * Método criado para dar acesso externo à variável de créditos do usuário.
	 * @return Créditos do usuário.
	 */
	public int getCreditos() {
		return creditos;
	}
	
	/**
	 * Método criado para que o valor de créditos possa ser alterado externamente, de acordo com as apostas e premiações do jogador.
	 * @param Créditos a serem atribuídos ao usuário.
	 */
	public void setCreditos(int cred) {
		creditos = cred;
	}
}
