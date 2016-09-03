package jogoEinterface;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Tabuleiro {
	
	private static Tabuleiro inst = null;
	
	public static Tabuleiro getInstance(){
		if(inst == null){
			inst  = new Tabuleiro();
		}
		return inst;
	}

	private int tabuleiro[][] = new int[8][8];

	private int i = 0;
	private int j = 0;
	private boolean confPreta = false;
	private boolean confBranco = false;
	Historico hist = new Historico();
	Pontuacao pontos = new Pontuacao();
	private boolean terminaJogo = true;
	private String termina;
	private boolean vez = true;
	private boolean seguir = false;
	Scanner sc = new Scanner(System.in);

	public void NovoTabuleiro() {

		for (i = 0; i <= 7; i++) {
			if (i <= 1) {
				for (j = 0; j <= 7; j++) {
					tabuleiro[i][j] = 2;
				}
			}
			if (i > 1 && i <= 5) {
				for (j = 0; j <= 7; j++) {
					tabuleiro[i][j] = 0;
				}
			}
			if (i >= 6) {
				for (j = 0; j <= 7; j++) {
					tabuleiro[i][j] = 1;
				}
			}

		}
		hist.addJogada(tabuleiro);
	}

	public void Imprime() {
		for (i = 0; i <= 7; i++) {
			for (j = 0; j <= 7; j++) {
				System.out.print(tabuleiro[i][j]);
			}
			System.out.println("");
		}
	}

	public int[] JogadasBrancas(int i, int j) {
		int vetor[] = new int[3];
		vetor[0] = 0;
		vetor[1] = 0;
		vetor[2] = 0;
		if (tabuleiro[i][j] != 1) {

		} else {
			if (j == 0) {
				if (tabuleiro[i - 1][j] != 1 && tabuleiro[i - 1][j] != 2) {
					vetor[1] = 1;
				}
				if (tabuleiro[i - 1][j + 1] != 1) {
					vetor[2] = 1;
				}
			}
			if (j == 7) {
				if (tabuleiro[i - 1][j] != 1 && tabuleiro[i - 1][j] != 2) {
					vetor[1] = 1;
				}
				if (tabuleiro[i - 1][j - 1] != 1) {
					vetor[0] = 1;
				}

			}
			if (j != 0 && j != 7) {
				if (tabuleiro[i - 1][j] != 1 && tabuleiro[i - 1][j] != 2) {
					vetor[1] = 1;
				}
				if (tabuleiro[i - 1][j - 1] != 1) {
					vetor[0] = 1;
				}

				if (tabuleiro[i - 1][j + 1] != 1) {
					vetor[2] = 1;
				}

			}

		}
		return vetor;

	}

	public void BrancoFrente(int j, int i) {
		int vetor[] = JogadasBrancas(i, j);
		if (vetor[1] == 1) {
			tabuleiro[i][j] = 0;
			tabuleiro[i - 1][j] = 1;
			confBranco = true;
			hist.addJogada(tabuleiro);
		}
	}

	public void BrancoEsq(int j, int i) {
		int vetor[] = JogadasBrancas(i, j);
		if (vetor[0] == 1) {
			tabuleiro[i][j] = 0;
			tabuleiro[i - 1][j - 1] = 1;
			confBranco = true;
			hist.addJogada(tabuleiro);
		}
	}

	public void BrancoDir(int j, int i) {
		int vetor[] = JogadasBrancas(i, j);
		if (vetor[2] == 1) {
			tabuleiro[i][j] = 0;
			tabuleiro[i - 1][j + 1] = 1;
			confBranco = true;
			hist.addJogada(tabuleiro);
		}
	}

	public int[] JogadasPretas(int i, int j) {
		int vetor[] = new int[3];
		vetor[0] = 0;
		vetor[1] = 0;
		vetor[2] = 0;

		if (tabuleiro[i][j] != 2) {
			System.out.println("não ha pecas pretas");
		} else {
			if (j == 0) {
				if (tabuleiro[i + 1][j] != 1 && tabuleiro[i + 1][j] != 2) {
					vetor[1] = 1;
				}
				if (tabuleiro[i + 1][j + 1] != 2) {
					vetor[2] = 1;
				}
			}
			if (j == 7) {
				if (tabuleiro[i + 1][j] != 1 && tabuleiro[i + 1][j] != 2) {
					vetor[1] = 1;
				}
				if (tabuleiro[i + 1][j - 1] != 2) {
					vetor[0] = 1;
				}

			}
			if (j != 0 && j != 7) {
				if (tabuleiro[i + 1][j] != 1 && tabuleiro[i + 1][j] != 2) {
					vetor[1] = 1;
				}
				if (tabuleiro[i + 1][j - 1] != 2) {
					vetor[0] = 1;
				}

				if (tabuleiro[i + 1][j + 1] != 2) {
					vetor[2] = 1;

				}

			}

		}
		return vetor;

	}

	public void PretoFrente(int j, int i) {
		int vetor[] = JogadasPretas(i, j);
		if (vetor[1] == 1) {
			tabuleiro[i][j] = 0;
			tabuleiro[i + 1][j] = 2;
			confPreta = true;
			hist.addJogada(tabuleiro);
		}
	}

	public void PretoEsq(int j, int i) {
		int vetor[] = JogadasPretas(i, j);
		if (vetor[0] == 1) {
			tabuleiro[i][j] = 0;
			tabuleiro[i + 1][j - 1] = 2;
			confPreta = true;
			hist.addJogada(tabuleiro);
		}
	}

	public void PretoDir(int j, int i) {
		int vetor[] = JogadasPretas(i, j);
		if (vetor[2] == 1) {
			tabuleiro[i][j] = 0;
			tabuleiro[i + 1][j + 1] = 2;
			confPreta = true;
			hist.addJogada(tabuleiro);
		}
	}

	public boolean FimDoJogo() {
		int aux;
		for (aux = 0; aux < 8; aux++) {
			if (tabuleiro[0][aux] == 1) {
				System.out.println("Jogador 1 venceu");
				pontos.setVitBranca(1);
				Imprime();
				JOptionPane.showMessageDialog(null, "O jogo acabou Branco ganhou!");

				return true;
			}
			if (tabuleiro[7][aux] == 2) {
				System.out.println("Jogador 2 venceu");
				pontos.setVitPreta(1);
				Imprime();
				JOptionPane.showMessageDialog(null, "O jogo acabou Preto ganhou!");

				return true;
			}
		}
		return false;
	}

	public void Voltar() {
		seguir = true;
		tabuleiro = hist.Voltar();
	}

	public void Seguir() {
		if (seguir) {
			tabuleiro = hist.Seguir();
		}
	}

	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public boolean isConfPreta() {
		return confPreta;
	}

	public void setConfPreta(boolean confPreta) {
		this.confPreta = confPreta;
	}

	public boolean isConfBranco() {
		return confBranco;
	}

	public void setConfBranco(boolean confBranco) {
		this.confBranco = confBranco;
	}

	public Historico getHist() {
		return hist;
	}

	public void setHist(Historico hist) {
		this.hist = hist;
	}

	public Pontuacao getPontos() {
		return pontos;
	}

	public void setPontos(Pontuacao pontos) {
		this.pontos = pontos;
	}

	public boolean isTerminaJogo() {
		return terminaJogo;
	}

	public void setTerminaJogo(boolean terminaJogo) {
		this.terminaJogo = terminaJogo;
	}

	public String getTermina() {
		return termina;
	}

	public void setTermina(String termina) {
		this.termina = termina;
	}

	public boolean isVez() {
		return vez;
	}

	public void setVez(boolean vez) {
		this.vez = vez;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
