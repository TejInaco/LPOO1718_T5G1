package helloWorld;

import java.util.Scanner;

public class helloWorld {
	
	public static void main(String[] args) {
		// Explicit initialization
		char[][] mapa = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
		int contador = 0;

		Scanner s = new Scanner(System.in);
		// Coordenada H - mapa[1][1]

		int linha = 1; //linha
		int coluna = 1; //coluna

		
		while (contador < 10) {
			//System.out.println(linha);
			//System.out.println(coluna);
			
			for (int i = 0; i < mapa.length; i++) {
				// for (int j = 0; j < mapa[i].length; i++) {
				System.out.println(mapa[i]);
				// System.out.println( '\t' );

				// }
				// System.out.println( '\n' );

			}
			// Para a leitura do input na consola
			int teclajogada = s.nextInt();

			
			if (teclajogada == 8 && linha != 0) // para cima
			{

				if (empty(mapa, linha-1, coluna)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha-1, coluna);
					linha = linha-1;
				}

			} else if (teclajogada == 4 && coluna != 0)// para a esquerda
			{
				if (empty(mapa, linha, coluna-1)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha, coluna-1);
					coluna = coluna-1;
				}

			} else if (teclajogada == 6 && coluna != 9)// para a direita
			{
				if (empty(mapa, linha, coluna +1)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha, coluna+1);
					coluna = coluna+1;
				}

			} else if (teclajogada == 2 && linha != 9)// para baixo
			{
				if (empty(mapa, linha+1, coluna)) {
					// se celula estiver vazia
					move(mapa, linha, coluna, linha+1, coluna);
					linha = linha+1;
				}

			}
			contador++;
			//System.out.println(linha);
			//System.out.println(coluna);
		}
		s.close();
	}

	/*
	 * Verifica se a célula está vazia
	 * 
	 */
	public static boolean empty(char mapa[][], int linha, int coluna) {
		if (mapa[linha][coluna] == ' ') {
			return true;
		} else {
			return false;

		}
	}

	/*
	 * Mover
	 */
	public static void move(char mapa[][], int linha, int coluna, int newLinha, int newColuna) {
		mapa[linha][coluna] = ' ';
		mapa[newLinha][newColuna] = 'H';
		//linha = newLinha;
		//coluna = newColuna;

	}
}