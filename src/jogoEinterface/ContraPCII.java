package jogoEinterface;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ContraPCII {

	private int x;
	private boolean terminaJogo = true;
	private String termina;
	private boolean vez = true;
	private boolean confPreta = false;
	private boolean confBranca = false;
	private boolean fim = false;
	Scanner sc = new Scanner(System.in);
	Tabuleiro tabuleiro = new Tabuleiro();
	Random gerador = new Random();
	private int movBraco;
	private boolean primeiroMov = true;
	
	public ContraPCII() {
		Tabuleiro.getInstance().NovoTabuleiro();	
	}

	public void MovimentoPecas(int posxp, int posyp, int posxs, int posys) {

		if (!tabuleiro.FimDoJogo()) {
			tabuleiro.setConfPreta(false);
			if (!vez) {
				confPreta = false;
				if (tabuleiro.getTabuleiro()[posyp][posxp] != 2) {
					System.out.println("Nao ha peca preta");
				} else {

					if (posxs == (posxp - 1) && posys == (posyp + 1)) {
						tabuleiro.PretoEsq(posxp, posyp);
					} else if (posxs == posxp && posys == (posyp + 1)) {
						tabuleiro.PretoFrente(posxp, posyp);
					} else if (posxs == (posxp + 1) && posys == (posyp + 1)) {
						tabuleiro.PretoDir(posxp, posyp);
					} else {
						JOptionPane.showMessageDialog(null, "Movimento invalido");
					}
				}
			}

			if (vez) {
				vez = false;
				confBranca = false;
				tabuleiro.setConfBranco(false);
				
				if (!primeiroMov && posxs != 0 && tabuleiro.getTabuleiro()[posys + 1][posxs - 1] == 1 ) {
					tabuleiro.BrancoDir( posxs - 1 , posys + 1);
				}else if(!primeiroMov && posxs != 7 && tabuleiro.getTabuleiro()[posys + 1][posxs + 1] == 1){
					tabuleiro.BrancoEsq(posxs + 1, posys + 1);
				}else{
				primeiroMov = false;
				while (!tabuleiro.isConfBranco()) {
						 posxp = gerador.nextInt(8);
						 posyp = gerador.nextInt(8);
						if (tabuleiro.getTabuleiro()[posyp][posxp] != 1) {
							continue;
						} else {
							movBraco = gerador.nextInt(3);
							if (movBraco == 0) {
								tabuleiro.BrancoEsq(posxp, posyp);
							} else if (movBraco == 1) {
								tabuleiro.BrancoFrente(posxp, posyp);
							} else if (movBraco == 2) {
								tabuleiro.BrancoDir(posxp, posyp);
							} else {
								JOptionPane.showMessageDialog(null, "Movimento invalido");
							}
						}
					}
				}
			}
		}

		fim = tabuleiro.FimDoJogo();
		// }
	}

	public void Voltar() {
		if (!fim) {
			tabuleiro.Voltar();
			if (vez && tabuleiro.hist.getIndex() > 1) {
				vez = false;
			} else {
				vez = true;
			}
		}
	}

	public void Seguir() {

	}

	public void NovoJogo() {
		tabuleiro.Imprime();
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

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

}
