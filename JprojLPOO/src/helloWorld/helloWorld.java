package helloWorld;

import java.util.Scanner;


public class helloWorld {  //Capitalized class names - TO IMPROVE
	
	public static void main(String[] args) {
		// Explicit initialization otherwise required a » new « statement 
		char[][] mapa = { 
				//index starts at 0
				//array copy: int[] b = (int[])a.clone();
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

		// Coordenada H - mapa[1][1]
		int linha = 1; //linha
		int coluna = 1; //coluna
		boolean readyToFinished = false;
		String msgVictory = "Victory !! You escape prison.";
		Scanner s = new Scanner(System.in);
		
		while ( isReadyToFinished(readyToFinished, linha, coluna) ) {
										System.out.println(linha);
										System.out.println(coluna);
//Map Printing
			for (int i = 0; i < mapa.length; i++) {   // for (int j = 0; j < mapa[i].length; i++) {
				System.out.println(mapa[i]);			// System.out.println( '\t' ); // System.out.println( '\t' );
			}
			
// Para a leitura do input na consola
			int teclajogada = s.nextInt();
//Cima			
			if (teclajogada == 8 && linha != 0) // para cima
			{
				if (empty(mapa, linha-1, coluna)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha-1, coluna);					
					linha = linha-1;
				}
//Esquerda
			} else if (teclajogada == 4 && coluna != 0 ) {// para a esquerda
	
				if (empty(mapa, linha, coluna-1)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha, coluna-1);
					
					coluna = coluna-1;
				}
//Direita
			} else if (teclajogada == 6 && coluna != 9)// para a direita
			{
				if (empty(mapa, linha, coluna +1)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha, coluna+1);
					coluna = coluna+1;
				}
//Baixo
			} else if ( teclajogada == 2 && linha != 9 ) {// para baixo
				if (empty(mapa, linha+1, coluna)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha+1, coluna);
					linha = linha+1;
				}

			}
			if( checkLever( linha, coluna) ) {
				mapa[5][0] = 'S'; //doors1
				mapa[6][0] = 'S'; //doors2
				readyToFinished = true;
			}
			
			System.out.println(linha);
			System.out.println(coluna);
					
		}// fim do ciclo while
		System.out.println(msgVictory);
		s.close();
	}
	
	/**
	 * @brief Checks the condition to end the game in victory mode
	 * @param Receives if the Lever as activated and the hero position
	 * @return true if conditions aren't met
	 */
	public static boolean isReadyToFinished( boolean doorsOpen, int lineHero, int colunHero) {
		if(doorsOpen == false ) {
			return true;
		}
		if( lineHero != 5 && colunHero != 0 ) {
			return true;
		}
		if( lineHero != 6 && colunHero != 0 ) {
			return true;
		}
		return false;
	}

	
	/**
	 * @brief Verified if char is  empty
	 * @param Receives the map and the coordinates 
	 * @return true if is empty
	 */
	public static boolean empty(char mapa[][], int linha, int coluna) {
		if (mapa[linha][coluna] == ' ' || 
				mapa[linha][coluna] == 'K' || 
				mapa[linha][coluna] == 'S' ){
			return true;
		} else {
			return false;

		}
	}

	/**
	 * @brief Movement of 'H' between two coordinates
	 * @param Receives the map, Coordinates to change for empty, Coordinates to change for 'H'
	 * @return void
	 */
	public static void move(char mapa[][], int linha, int coluna, int newLinha, int newColuna) {
		mapa[linha][coluna] = ' ';
		mapa[newLinha][newColuna] = 'H';
		
		if ( mapa[8][7] != 'H' && mapa[8][7] != 'K' ) {
			mapa[8][7] = 'K';
		}
		
		
}
	
	/**
	 * @brief Modifies map after activate the lever task#3, actives doors
	 * @param Receives the map, Coordinates of the hero
	 * @return void
	 */
	public static boolean checkLever( int linha, int coluna ) {
		if( linha == 8 && coluna == 7 ) {
			return true;
		} 
		return false;
	}
	
	/*
	 * Check Guard
	 */
	 public static boolean checkGuard() {
		 //confirmar a posicao do guarda
		 // confirmar se a posicao +1 quadrado em cima e em baixo mais esq e diretia
	 return true;
	 }
}