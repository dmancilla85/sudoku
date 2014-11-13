package sudoku;

import Implementaciones.Matriz;

public class Sudoku {

	public int n = 4;	
	public Matriz<Integer> matriz;
	
	public Matriz<Boolean> filas;
	public Matriz<Boolean> columnas;
	public Matriz<Boolean> cuadrantes;
	
	private int[][] cuadrantesAux;
	
	public Sudoku(Matriz<Integer> matriz, int n) {
		this.n = n;
		
		this.matriz = new Matriz<Integer>();
		filas = new Matriz<Boolean>();
		columnas = new Matriz<Boolean>();
		cuadrantes = new Matriz<Boolean>();
		
		this.matriz = matriz;
		filas.inicializarMatriz(n);
		columnas.inicializarMatriz(n);
		cuadrantes.inicializarMatriz(n);
		
		inicializarMatrizCalculoCuadrantes();
		
		inicializarMatricesAuxiliares();
	}
	
	private void inicializarMatricesAuxiliares() {
		// i: fila
		for (int i = 0; i < n; i++) {
			// j: columna
			for (int j = 0; j < n; j++) {
				Integer valor = matriz.obtenerValor(i, j); 
				if (valor != null) {
					if (matriz.obtenerValor(i, j) == valor) {
						filas.setearValor(i, valor - 1, Boolean.TRUE);
						columnas.setearValor(valor - 1, j, Boolean.TRUE);
						cuadrantes.setearValor(calcularCuadrante(i, j), valor - 1, Boolean.TRUE);
					}
					else
					{
						filas.setearValor(i, valor - 1, Boolean.FALSE);
						columnas.setearValor(valor - 1, j, Boolean.FALSE);
						cuadrantes.setearValor(calcularCuadrante(i, j), valor - 1, Boolean.FALSE);						
					}
				}
			}
		}
	}
	
	private void inicializarMatrizCalculoCuadrantes() {
		cuadrantesAux = new int[(int)Math.sqrt(n)][(int)Math.sqrt(n)];
		
		int x = 0;
		for (int i = 0; i < Math.sqrt(n); i++) {
			for (int j = 0; j < Math.sqrt(n); j++) {
				cuadrantesAux[i][j] = x;
				x++;
			}
		}
	}
	
	public int calcularCuadrante(int i, int j) {
		int x = (int)(i / Math.sqrt(n));
		int y = (int)(j / Math.sqrt(n));
		
		return cuadrantesAux[x][y];
	}
	
	public static bool sudokuValido(int digitos, MatrizTDA<Integer> tablero) {
		
		List<Integer> 	secVer = new List<Integer>; 
		List<Integer> 	secHor = new List<Integer>; 
		boolean 		valido = true;   

		int celdas = Math.sqrt(digitos);
		
		for(int i = 0; i < digitos - 1; i++) {
			int ini = i * celdas;
			int fin = ini + celdas - 1;
			
			// Filas del cuadrante
			for(int ix = ini; ix < fin; ix++) {
				int ini_col = ix * celdas; 
				int fin_col = ini_col + (celdas - 1);
				
				for(int iy = ini_col; iy < fin_col; iy++){
				/*        
				si M[ix, iy] está en secVer
				                    valido -- falso
				                sino
				                    secVer -- secVer + M[ix, iy]  
				                fin si
				 */		
				}
			}
			
			// Columnas del cuadrante
			for(int ix = ini; ix < fin; ix++) {
					int ini_col = ix * celdas; 
					int fin_col = ini_col + (celdas - 1);
							
					for(int iy = ini_col; iy < fin_col; iy++){
					/*        
					si M[ix, iy] está en secVer
					                    valido -- falso
					                sino
					                    secVer -- secVer + M[ix, iy]  
					                fin si*/		
					}
			}
					
		}
		
	}


	
}
