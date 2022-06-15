/**
 * Simulação de uma carta com valor e naipe,
 * e representação por string.
 * @author Vitor Augusto Henrique Brisola
 * Nº USP = 9791292
 * @author Guilherme Domingos Faria Silva
 * Nº USP = 9361094
 */
public class Carta {
	//  0 -> 2, 1 -> 3, ... ,k ->11  , A ->12
	private int valor;
	// 0 -> Copas, 1-> Espadas, 2 -> Ouros, 3-> Paus
	private int naipe;
	
	
	/**
	 * Transforma o valor e o naipe da carta em um vetor de inteiros.
	 * @return vetor de inteiros de tamanho 2 onde, 1 = valor, 2 = naipe
	 */
	public int[] getCarta(){
		int[] carta = new int[2];
		carta[0] = valor;
		carta[1] = naipe;
		return carta;
	}
	
	/**
	 * Transforma o naipe do caractere em string.
	 * @return Caractere representando o naipe da carta
	 */
	public String getCharNaipe(){
		String y = new String();
		y = "-";
						
		if(naipe == 0){
			y = "C";
		}else if(naipe == 1){
			y = "E";
		}else if(naipe == 2){
			y = "O";
		}else if(naipe == 3){
			y = "P";
		}
		
		return y;
	}
	
	/**
	 * Transforma o valor da carta em caractere.
	 * @return Caractere representando o valor da carta
	 */
	public String getCharValor(){
		String x = new String();
		x = "-";
		
		if (this.valor < 8){
			x = "" + (this.valor + 2);
		}else if(valor == 8){
			x = "10";
		}else if(valor == 9){
			x = "J";
		}else if(valor == 10){
			x = "Q";
		}else if(valor == 11){
			x = "K";
		}else if(valor == 12){
			x = "A";
		}
		
		return x;
	}
	
	
	/**
	 * Representação gráfica das partes de uma carta
	 * @param Qual parte deseja, (0 > Bordas superior e inferior,
	 * 1 > valor da carta no canto esquerdo, 2 > parte vazia,
	 * 3 > naipe da carta ao meio, 4 > valor da carta no canto direito)
	 * @return Representação por string da parte selecionada
	 */
	public String getParteCarta(int parte){
		String s = new String(), x, y;
		
		// Definido caracter respectivo ao valor da carta
		x = getCharValor();
		// Definido caracter respectivo ao naipe da carta
		y = getCharNaipe();
		
		switch(parte){
			case 0:
				s = "+---------+";
				break;
			case 1:
				if(x != "10"){
					s = "|" + x + "        |";
				}else{
					s = "|" + x + "       |";
				}
				break;
			case 2:
				s = "|         |";
				break;
			case 3:
				s = "|    " + y + "    |";
				break;
			case 4: 
				if(x != "10"){
					s = "|        " + x + "|";
				}else{
					s = "|       " + x + "|";
				}
				break;
		}
		
		
		
		return s;
	}
	
	/**
	 * Transforma a representação da carta
	 * em uma string, mostrando o naipe ao centro
	 * e o valor da carta selecionada nos cantos.
	 */
	public java.lang.String toString(){
		String k = new String();
		
		k = getParteCarta(0) + '\n';
		k += getParteCarta(1) + '\n';
		k += getParteCarta(2) + '\n';
		k += getParteCarta(3) + '\n';
		k += getParteCarta(2) + '\n';
		k += getParteCarta(4) + '\n';
		k += getParteCarta(0) + '\n'; 
		
		return k;
	}
	
	// ============= Construtores =============
	 
	
	/**
	 * Cria uma carta de valor e naipe
	 * especificados.
	 */
	public Carta(int v,int n){
		valor = v;
		//System.out.println(n);
		naipe = n;
	}
}
