package jogoEinterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaContraPC extends Janela implements ActionListener {

	ContraPC jogo = new ContraPC();
	Pontuacao pontos = new Pontuacao();
	
	
	public JanelaContraPC(){
		super.JanelaInicial();
		this.jogo.MovimentoPecas(posxp, posyp, posxs, posys);
		super.verificaTabuleiro();
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		int i, j;
 		if (e.getSource().equals(novoJogo)) {
			pontos.setVitBranca(pontos.getVitBranca() + Tabuleiro.getInstance().pontos.getVitBranca());
			pontos.setVitPreta(pontos.getVitPreta() + Tabuleiro.getInstance().pontos.getVitPreta());
			branco.setText("Branco:"+ pontos.getVitBranca());
			preto.setText("Preto:"+ pontos.getVitPreta());
			jogo = new ContraPC();
			super.verificaTabuleiro();
		} else if (e.getSource().equals(voltar)) {
			jogo.Voltar();
			super.verificaTabuleiro();
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
				Tabuleiro.getInstance().Imprime();
				

				if (!jogo.isVez() && Tabuleiro.getInstance().isConfPreta()) {
					jogo.setVez(true);
					jogo.MovimentoPecas(posxp, posyp, posxs, posys);
				}
				super.verificaTabuleiro();
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
