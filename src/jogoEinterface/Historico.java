package jogoEinterface;

import java.util.ArrayList;
import java.util.List;

public class Historico {

	private List<int[][]> tabu = new ArrayList();
	private int index = 0;
	private boolean seguir = false;
	
	public void addJogada(int tabuleiro[][]) {
		int tabul[][] = new int[8][8];
		int i, j;
		for (i = 0; i <= 7; i++) {
			for (j = 0; j <= 7; j++) {
				tabul[i][j] = tabuleiro[i][j];
			}
		}

		tabu.add(index, tabul);
		index++;
		if(seguir){
			seguir = false;
			for(i=index; i < tabu.size(); i++ ){
				tabu.remove(i);
			}
		}
		
	}

	public int[][] Voltar() {
		seguir =  true;
		int tabuAux[][] = new int[8][8];
		if (index > 1) {
			index--;
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 7; j++) {
					tabuAux[i][j] = tabu.get(index-1)[i][j];
				}
			}
			return tabuAux;
		}else{
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 7; j++) {
					tabuAux[i][j] = tabu.get(0)[i][j];
				}
			}
			return tabuAux;
		}
		
}

	public int[][] Seguir() {
		if(seguir){
			index++;
			return tabu.get(index);
		}
		return tabu.get(index - 1);
	}

	public List<int[][]> getTabu() {
		return tabu;
	}

	public void setTabu(List<int[][]> tabu) {
		this.tabu = tabu;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
