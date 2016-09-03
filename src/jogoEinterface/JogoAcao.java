package jogoEinterface;

import java.util.Scanner;

import javax.swing.JOptionPane;

import jogoEinterface.Tabuleiro;

public class JogoAcao {

	private int x;
	private boolean terminaJogo = true;
	private String termina;
	private boolean vez = true;
	private boolean confPreta = false;
	private boolean confBranca = false;
	private boolean fim = false;

	Scanner sc = new Scanner(System.in);
	

	public JogoAcao() {
		Tabuleiro.getInstance().NovoTabuleiro();	
	}

	public void MovimentoPecas(int posxp, int posyp, int posxs, int posys) {

		Tabuleiro.getInstance().setConfBranco(false);

		if (!Tabuleiro.getInstance().FimDoJogo()) {
			if (vez) {
				confBranca = false;

				if (Tabuleiro.getInstance().getTabuleiro()[posyp][posxp] != 1) {
					System.out.println("Nao ha peca branca");
				} else {
					confBranca = true;

					if (posxs == (posxp - 1) && posys == (posyp - 1)) {
						Tabuleiro.getInstance().BrancoEsq(posxp, posyp);
					} else if (posxs == posxp && posys == (posyp - 1)) {
						Tabuleiro.getInstance().BrancoFrente(posxp, posyp);
					} else if (posxs == (posxp + 1) && posys == (posyp - 1)) {
						Tabuleiro.getInstance().BrancoDir(posxp, posyp);
					} else {
						JOptionPane.showMessageDialog(null, "Movimento invalido");
					}
				}
			}
		}

		if (!vez) {
			confPreta = false;
			Tabuleiro.getInstance().setConfPreta(false);

			if (Tabuleiro.getInstance().getTabuleiro()[posyp][posxp] != 2) {
				JOptionPane.showMessageDialog(null, "Não ha pecas");
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
		if (!fim) {
			Tabuleiro.getInstance().Seguir();
		}
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
