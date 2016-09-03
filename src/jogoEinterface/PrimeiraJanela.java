package jogoEinterface;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PrimeiraJanela extends JFrame implements ActionListener{
	
	protected JButton normal;
	protected JButton contraPcI;
	protected JButton contraPcII;
	
	public PrimeiraJanela(){
		
		JFrame teste = new JFrame("Breakthrough");
		
		GridLayout gridLayout = new GridLayout(1, 3);
		
		normal = new JButton("Duas pessoas");
		normal.addActionListener(this);
		contraPcI = new JButton("VS PC fase 1");
		contraPcI.addActionListener(this);
		contraPcII = new JButton("VS PC fase 2");
		contraPcII.addActionListener(this);
		
		
		teste.add(normal);
		teste.add(contraPcI);
		teste.add(contraPcII);
		
		teste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		teste.setLayout(gridLayout);
		teste.setSize(400, 100);
		teste.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(normal)) {
			System.out.println("normal");
			Janela teste = new Janela();
			teste.JanelaInicial();
		} else if (e.getSource().equals(contraPcI)) {
			JanelaContraPC teste = new JanelaContraPC();
//			teste.JanelaInicial();
		} else if (e.getSource().equals(contraPcII)) {
			JanelaContraPCII teste = new JanelaContraPCII();
			teste.JanelaInicial();
		}
		
	}
	
}
