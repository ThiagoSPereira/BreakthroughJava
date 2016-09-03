package jogoEinterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

	protected int posxp;
	protected int posyp;
	protected int posxs;
	protected int posys;
	protected String volta = null;
	protected String segue = null;
	protected boolean primeiroClic = false;
	protected JButton[][] buttons;
	protected JButton voltar;
	protected JButton seguir;
	protected JButton aux1;
	protected JButton aux2;
	protected JButton novoJogo;
	JogoAcao jogo = new JogoAcao();
	Pontuacao pontos = new Pontuacao();
	
	protected ImageIcon pecaBranca = new ImageIcon(getClass().getResource("white.png"));
	protected ImageIcon pecaPreta = new ImageIcon(getClass().getResource("black.png"));
	protected ImageIcon pecaClicada = new ImageIcon(getClass().getResource("blue.png"));
	protected JLabel branco = new JLabel("Branco:"+ pontos.getVitBranca());
	protected JLabel preto = new JLabel("Preto:"+ pontos.getVitPreta());
	
	
	public void JanelaInicial() {

		Tabuleiro.getInstance().Imprime();
		pecaBranca.setImage(pecaBranca.getImage().getScaledInstance(50, 50, 100));
		pecaPreta.setImage(pecaPreta.getImage().getScaledInstance(50, 50, 100));
		pecaClicada.setImage(pecaClicada.getImage().getScaledInstance(50, 50, 100));
		
		Container centro = getContentPane();
		Container norte = new JPanel();
		Container sul = new JPanel();
		Container leste = new JPanel();
		sul.setLayout(new GridLayout(1, 1));
		leste.setLayout(new GridLayout(2, 1));
		JFrame janela = new JFrame("Breakthrough");

		BorderLayout layout = new BorderLayout(5, 5);
		janela.setLayout(layout);
		janela.setSize(700, 600);
		janela.setVisible(true);

		GridLayout gridLayout2 = new GridLayout(8, 8);
		centro.setLayout(gridLayout2);
		GridLayout gridLayout3 = new GridLayout(1, 2);
		buttons = new JButton[8][8]; // create array of JButtons

		voltar = new JButton("Voltar");
		voltar.addActionListener(this);
		seguir = new JButton("Seguir");
		seguir.addActionListener(this);
		norte.setLayout(gridLayout3);
		norte.add(voltar);
		norte.add(seguir);
		novoJogo = new JButton("Novo Jogo");
		novoJogo.addActionListener(this);
		sul.add(novoJogo);
		leste.add(branco);
		leste.add(preto);
		
		for (int i = 0; i <= 7; i++) {
			if (i <= 1) {
				for (int j = 0; j <= 7; j++) {
					buttons[i][j] = new JButton(pecaPreta);
					buttons[i][j].addActionListener(this);
					centro.add(buttons[i][j]);
				}
			}
			if (i > 1 && i <= 5) {
				for (int j = 0; j <= 7; j++) {
					buttons[i][j] = new JButton();
					buttons[i][j].addActionListener(this);
					centro.add(buttons[i][j]);
				}
			}
			if (i >= 6) {
				for (int j = 0; j <= 7; j++) {
					buttons[i][j] = new JButton(pecaBranca);
					buttons[i][j].addActionListener(this);
					centro.add(buttons[i][j]);
				}
			}

			// add button to JFrame
		} // end for

		janela.add(BorderLayout.CENTER, centro);
		janela.add(BorderLayout.NORTH, norte);
		janela.add(BorderLayout.SOUTH, sul);
		janela.add(BorderLayout.EAST, leste);
		
		//verificaTabuleiro();
	}

	public void verificaTabuleiro() {
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (Tabuleiro.getInstance().getTabuleiro()[i][j] == 1) {
					buttons[i][j].setIcon(pecaBranca);
				}else if (Tabuleiro.getInstance().getTabuleiro()[i][j] == 2) {
					buttons[i][j].setIcon(pecaPreta);
				}else {
					buttons[i][j].setIcon(null);
					}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i, j;
		if (e.getSource().equals(novoJogo)) {
			pontos.setVitBranca(pontos.getVitBranca() + Tabuleiro.getInstance().pontos.getVitBranca());
			pontos.setVitPreta(pontos.getVitPreta() + Tabuleiro.getInstance().pontos.getVitPreta());
			branco.setText("Branco:"+ pontos.getVitBranca());
			preto.setText("Preto:"+ pontos.getVitPreta());
			jogo = new JogoAcao();
			verificaTabuleiro();
		} else if (e.getSource().equals(voltar)) {
			jogo.Voltar();
			verificaTabuleiro();
		} else if (e.getSource().equals(seguir)) {
			jogo.Seguir();
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
				verificaTabuleiro();
				if (jogo.isVez() && Tabuleiro.getInstance().isConfBranco()) {
					jogo.setVez(false);
				} else if (!jogo.isVez() && Tabuleiro.getInstance().isConfPreta()) {
					jogo.setVez(true);
				}
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
