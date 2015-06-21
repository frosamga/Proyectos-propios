import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class PanelCasino extends JPanel implements vistaCasino{
	
	private JTextField dinero,f1,t1,g1,c1;
	private JButton dos,cinco,apostar;
	private JLabel din,mesa,fichas,tiradas,ganancia,colorRep,imagen;
	private JTextPane areaText;
	private JScrollPane scroll;
	private ImageIcon im;
	
	public PanelCasino(){
		
		dinero= new JTextField(10);
		f1= new JTextField(10);
		t1= new JTextField(10);
		g1= new JTextField(10);
		c1= new JTextField(10);
		im= new ImageIcon("");
		areaText= new JTextPane();
		scroll= new JScrollPane(scroll,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		imagen= new JLabel(im);
		
		dos= new JButton("2,5");
		cinco= new JButton("5");
		apostar= new JButton("Apostar");
		
		din= new JLabel("Dinero que apuestas");
		mesa= new JLabel("Apuesta en mesa");
		fichas= new JLabel("Nº Fichas ");
		tiradas= new JLabel("Tiradas");
		ganancia= new JLabel("Ganancia");
		colorRep= new JLabel("Color más repetido");
		
		
		JPanel sup1_1 = new JPanel();
		sup1_1.setLayout(new GridLayout(1,2));
		sup1_1.add(dos);
		sup1_1.add(cinco);
		
		JPanel sup1 = new JPanel();
		sup1.setLayout(new GridLayout(2,2));
		sup1.add(dinero);
		sup1.add(din);
		sup1.add(mesa);
		sup1.add(sup1_1);
		
		JPanel supMed = new JPanel();
		supMed.setLayout(new GridLayout(4,2));
		supMed.add(fichas);
		supMed.add(f1);
		supMed.add(tiradas);
		supMed.add(t1);
		supMed.add(ganancia);
		supMed.add(g1);
		supMed.add(colorRep);
		supMed.add(c1);
		
		JPanel supInf = new JPanel();
		supInf.setLayout(new GridLayout(2,1));
		supInf.add(apostar);
		supInf.add(scroll);
		
		JPanel izq= new JPanel();
		izq.setLayout(new GridLayout(3,1));
		izq.add(sup1);
		izq.add(supMed);
		izq.add(supInf);
		
		JPanel fin = new JPanel();
		fin.setLayout(new GridLayout(1,2));
		fin.add(izq);
		fin.add(imagen);
		add(fin);
	}
	
}
