import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;


/**
 * Esta classe permite o gerenciamento do baralho de cartas
 * e das cartas nas mãos do jogador, realizando operações 
 * como embaralhar e trocar as cartas do jogador.
 * 
 * @author Vitor Augusto Henrique Brisola
 * Nº USP = 9791292
 * @author Guilherme Domingos Faria Silva
 * Nº USP = 9361094
 */
public class Embaralhar{
	private Stack<Carta> baralho = new Stack<Carta>();
	private Stack<Carta> descarte = new Stack<Carta>();
	private Carta[] mao = new Carta[5];


	
	/**
	 * Transforma as cartas da mão do jogador em uma série
	 * de vetores, onde o primeiro valor do vetor é o valor
	 * da carta e o segundo, seu naipe.
	 * valor: (0 -> 2, 1 -> 3,... , 8 -> 10, 9 -> J,
	 * 10 -> Q, 11 -> K, 12 -> A). 
	 * naipe: (0 > Copas, 1 > Espadas, 2 > Ouros, 3 > Paus).
	 * @return Lista de vetores representando as cartas
	 */
	public int[][] getCartas(){
		int[][] cards = new int[5][2];
		
		for(int i = 0; i< 5; i++)
			cards[i] = mao[i].getCarta();
		
		Arrays.sort(cards, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		return cards;
	}
	
	/**
	 * Recoloca as cartas descartadas  no baralho e	 
	 * as embaralha.
	 */
	public void embaralharCartas(){	
		
		// Coloca as cartas do monte de descarte novamente no baralho
		while(descarte.empty() == false){
			baralho.push(descarte.pop());
		}
		
		// Embaralhando cartas
		Collections.shuffle(baralho);
	}
	
	
	/**
	 * Realiza a troca das cartas do jogador,
	 * descartando as cartas selecionadas da 
	 * mão e distribuindo novas cartas do baralho.
	 */
	public void trocar(String cartas_trocadas){
			
		for(int i=0; i < cartas_trocadas.length(); i++){
			// Tratar a string para descobrir cartas a serem trocadas
			int x = Character.getNumericValue(cartas_trocadas.charAt(i)) - 1;
			if(x >= 0 && x < 6){
				// Colocar carta ao final do baralho
				descarte.push(mao[x]);
				// Copiar primeira carta do baralho para as mao do jogador
				mao[x] = baralho.pop();
			}
		}
	}
	
	
	/**
	 * Este método realiza a representação em forma de string
	 * das 5 cartas nas mãos do jogador.
	 */
	public java.lang.String toString(){
		String cards = new String();
		
		// Numero da posicao da carta na mao do jogador
		for(int i=0; i<5; i++)	cards += "    [" + (char)(i+1+48) + "]     ";
		cards += "\n";
		
		// Borda Superior da carta
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(0) + " ";
		cards += "\n";
		
		// Valor da carta no canto superior esquerdo
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(1) + " ";
		cards += "\n";
		
		// Parte vazia da carta
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(2) + " ";
		cards += "\n";
		
		// Naipe da carta ao meio
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(3) + " ";
		cards += "\n";
		
		// Parte vazia da carta
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(2) + " ";
		cards += "\n";
		
		// Valor da carta no canto inferior direito
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(4) + " ";
		cards += "\n";
		
		// Borda inferior da carta
		for(int i=0; i<5; i++)	cards += mao[i].getParteCarta(0) + " ";
		cards += "\n";
		
		return cards;
	}
	
		
	/**
	 *	Cria um novo baralho com uma ordem aleatória das cartas
	 *	e retira 5 cartas do baralho para as mãos do jogador.
	 */
	public Embaralhar(){
		int i,j = 0;
		Carta card;
		
		// Cria um baralho ordenado
		for(i = 0; i < 4; i++){
			for(j = 0; j < 13; j++){
				card = new Carta(j,i);
				baralho.push(card);
			}
		}
		// Aleatoriza o baralho
		embaralharCartas();
		
		// Da cinco cartas ao jogador
		for(i=0; i<5; i++){
			mao[i] = baralho.pop();
			
		}
	}
	
}
