package jogoEinterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaContraPCII extends Janela implements ActionListener {


	ContraPCII jogo = new ContraPCII();
	Pontuacao pontos = new Pontuacao();


	@Override
	public void actionPerformed(ActionEvent e) {
		int i, j;
		if (e.getSource().equals(novoJogo)) {
			pontos.setVitBranca(pontos.getVitBranca() + jogo.tabuleiro.pontos.getVitBranca());
			pontos.setVitPreta(pontos.getVitPreta() + jogo.tabuleiro.pontos.getVitPreta());
			branco.setText("Branco:"+ pontos.getVitBranca());
			preto.setText("Preto:"+ pontos.getVitPreta());
			jogo = new ContraPCII();
			verificaTabuleiro();
		} else if (e.getSource().equals(voltar)) {
			jogo.Voltar();
			verificaTabuleiro();
		} else if (e.getSource().equals(seguir)) {
			segue = "s";
			System.out.println("seguir");
		} else {
			for (i = 0; i <= 7; i++) {
				for (j = 0; j <= 7; j++) {
					if (e.getSource() == buttons[i][j] && primeiroClic == false) {
						// System.out.println(i + "|" + j);
						buttons[i][j].setIcon(pecaClicada);
						primeiroClic = true;
						posyp = i;
						posxp = j;
						continue;
					}
					if (e.getSource() == buttons[i][j] && primeiroClic == true) {
						// System.out.println(i + "|" + j);
						primeiroClic = false;
						posys = i;
						posxs = j;
						continue;

					}
				}

			}
			if (primeiroClic == false) {
				jogo.MovimentoPecas(posxp, posyp, posxs, posys);
				jogo.tabuleiro.Imprime();
				if (!jogo.isVez() && jogo.tabuleiro.isConfPreta()) {
					jogo.setVez(true);
					jogo.MovimentoPecas(posxp, posyp, posxs, posys);
				}
				verificaTabuleiro();
			}
		}
	}

	public JButton getVoltar() {
		return voltar;
	}

	public void setVoltar(JButton voltar) {
		this.voltar = voltar;
	}

	public JButton getSeguir() {
		return seguir;
	}

	public void setSeguir(JButton seguir) {
		this.seguir = seguir;
	}

	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}

	public String getVolta() {
		return volta;
	}

	public void setVolta(String volta) {
		this.volta = volta;
	}

	public String getSegue() {
		return segue;
	}

	public void setSegue(String segue) {
		this.segue = segue;
	}

	public boolean isPrimeiroClic() {
		return primeiroClic;
	}

	public void setPrimeiroClic(boolean primeiroClic) {
		this.primeiroClic = primeiroClic;
	}

}
