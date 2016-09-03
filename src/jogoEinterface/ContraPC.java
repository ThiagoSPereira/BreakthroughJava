package jogoEinterface;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ContraPC {

	private int x;
	private boolean terminaJogo = true;
	private String termina;
	private boolean vez = true;
	private boolean confPreta = false;
	private boolean confBranca = false;
	private boolean fim = false;
	Scanner sc = new Scanner(System.in);
	
	Random gerador = new Random();
	private int movBraco;

	public ContraPC() {
		Tabuleiro.getInstance().NovoTabuleiro();		
	}

	public void MovimentoPecas(int posxp, int posyp, int posxs, int posys) {

		if (!Tabuleiro.getInstance().FimDoJogo()) {
			Tabuleiro.getInstance().setConfPreta(false);
			if (!vez) {
				confPreta = false;

				if (Tabuleiro.getInstance().getTabuleiro()[posyp][posxp] != 2) {
					System.out.println("Nao ha peca preta");
				} else {

					if (posxs == (posxp - 1) && posys == (posyp + 1)) {
						Tabuleiro.getInstance().PretoEsq(posxp, posyp);
					} else if (posxs == posxp && posys == (posyp + 1)) {
						Tabuleiro.getInstance().PretoFrente(posxp, posyp);
					} else if (posxs == (posxp + 1) && posys == (posyp + 1)) {
						Tabuleiro.getInstance().PretoDir(posxp, posyp);
					} else {
						JOptionPane.showMessageDialog(null, "Movimento invalido");
					}
				}
			}

			if (vez) {
				vez = false;
				confBranca = false;
				Tabuleiro.getInstance().setConfBranco(false);
				while (!Tabuleiro.getInstance().isConfBranco()) {
					posxp = gerador.nextInt(8);
					posyp = gerador.nextInt(8);
					if (Tabuleiro.getInstance().getTabuleiro()[posyp][posxp] != 1) {
						continue;
					} else {
						movBraco = gerador.nextInt(3);
						if (movBraco == 0) {
							Tabuleiro.getInstance().BrancoEsq(posxp, posyp);
						} else if (movBraco == 1) {
							Tabuleiro.getInstance().BrancoFrente(posxp, posyp);
						} else if (movBraco == 2) {
							Tabuleiro.getInstance().BrancoDir(posxp, posyp);
						} else {
							JOptionPane.showMessageDialog(null, "Movimento invalido");
						}
					}
				}
			}
		}

		fim = Tabuleiro.getInstance().FimDoJogo();
		// }
	}

	public void Voltar() {
		if (!fim) {
			Tabuleiro.getInstance().Voltar();
			if (vez && Tabuleiro.getInstance().hist.getIndex() > 1) {
				vez = false;
			} else {
				vez = true;
			}
		}
	}

	public void Seguir() {

	}

	public void NovoJogo() {
		Tabuleiro.getInstance().Imprime();
		System.out.println("Continuar jogo? 's' Sim 'n' Nao");
		vez = true;
		if (termina.equals("n")) {
			terminaJogo = false;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
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

	public boolean isConfPreta() {
		return confPreta;
	}

	public void setConfPreta(boolean confPreta) {
		this.confPreta = confPreta;
	}

	public boolean isConfBranca() {
		return confBranca;
	}

	public void setConfBranca(boolean confBranca) {
		this.confBranca = confBranca;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	

}
