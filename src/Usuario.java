
/**	
 * Esta classe armazena dados sobre o jogador e calcula a premia��o em cr�ditos do jogador.
 * @author Vitor Augusto Henrique Brisola
 * N� USP = 9791292
 * @author Guilherme Domingos Faria Silva
 * N� USP = 9361094
 */

public class Usuario {
	private int creditos;
	
	/** 
	 * Este construtor instancia um objeto Usuario com os 200 cr�ditos iniciais de um jogador.
	 */
	public Usuario() {
		creditos = 200;
	}
	
	/**
	 * Respons�vel por calcular a premia��o do jogador de acordo com a combina��o de cartas obtida de suas m�os. 
	 * Atribuindo o pr�mio aos cr�ditos do jogador diretamente e informando seu desempenho na rodada.
	 * @param Todas as cartas presentes na m�o do jogador.
	 * @param O valor da aposta na rodada do usu�rio.
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
			System.out.println("Voc� conseguiu um Royal Straight Flush! Voc� recebe 200x a sua aposta.");
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
			System.out.println("Voc� conseguiu um Straight Flush! Voc� recebe 100x a sua aposta.");
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
			System.out.println("Voc� conseguiu uma Quadra! Voc� recebe 50x a sua aposta.");
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
			System.out.println("Voc� conseguiu uma Quadra! Voc� recebe 50x a sua aposta.");
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
			System.out.println("Voc� conseguiu um Full Hand! Voc� recebe 20x a sua aposta.");
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
			System.out.println("Voc� conseguiu um Flush! Voc� recebe 10x a sua aposta.");
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
			System.out.println("Voc� conseguiu um Straight! Voc� recebe 5x a sua aposta.");
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
			System.out.println("Voc� conseguiu uma Trinca! Voc� recebe 2x a sua aposta.");
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
			System.out.println("Voc� conseguiu uma Trinca! Voc� recebe 2x a sua aposta.");
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
			System.out.println("Voc� conseguiu uma Trinca! Voc� recebe 2x a sua aposta.");
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
			System.out.println("Voc� conseguiu Dois Pares! Voc� recebe 1x a sua aposta.");
			creditos += aposta;
			return;
		}
		
		// Nenhuma combina��o
		System.out.println("Voc� n�o conseguiu nenhuma combina��o nesta rodada. Voc� n�o recebe nada.");
	}

	/**
	 * M�todo criado para dar acesso externo � vari�vel de cr�ditos do usu�rio.
	 * @return Cr�ditos do usu�rio.
	 */
	public int getCreditos() {
		return creditos;
	}
	
	/**
	 * M�todo criado para que o valor de cr�ditos possa ser alterado externamente, de acordo com as apostas e premia��es do jogador.
	 * @param Cr�ditos a serem atribu�dos ao usu�rio.
	 */
	public void setCreditos(int cred) {
		creditos = cred;
	}
}
