import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class PanelTwitter extends JPanel implements VistaTwitter {

	private JButton benviar, bActualizarEstado, bFoto, bseguidores, bseguidos,
			btimeline, bbuscartweets, bseguirSeguidores, bseguirSeguidos,binfo;
	private JLabel lultimoT, lultimoT1, ltoken, ltokensecreto, lAct, lfoto,
			lseguidores, lseguidos, ltimeline, lbuscartweets,
			lseguirSeguidores, lseguirSeguidos,linfo;
	private JTextField textUsuario, textPass, textAct, textFoto,
			textseguidores, textseguidos, texttimeline, textbuscartweets,
			textseguirSeguidores, textseguirSeguidos;
	private JCheckBox ultimosTweetsseguidores, ultimosTweetsseguidos;
	private JTextArea texto;

	public PanelTwitter() {

		benviar = new JButton("Enviar");
		benviar.setEnabled(true);
		bActualizarEstado = new JButton("Actualizar estado");
		bActualizarEstado.setEnabled(true);
		bFoto = new JButton("Actualizar foto");
		bFoto.setEnabled(true);
		bseguidores = new JButton("Obtener seguidores");
		bseguidores.setEnabled(true);
		bseguidos = new JButton("Obtener seguidos");
		bseguidos.setEnabled(true);
		btimeline = new JButton("timeline");
		btimeline.setEnabled(true);
		bbuscartweets = new JButton("Buscar tweets");
		bbuscartweets.setEnabled(true);
		bseguirSeguidores = new JButton("Seguir");
		bseguirSeguidores.setEnabled(true);
		bseguirSeguidos = new JButton("Seguir");
		bseguirSeguidos.setEnabled(true);
		binfo = new JButton("Información");
		binfo.setEnabled(true);
		
		
		ltoken = new JLabel("Token:");
		ltoken.setEnabled(true);
		ltokensecreto = new JLabel("Token secreto");
		ltokensecreto.setEnabled(true);
		lAct = new JLabel("Publicar Tweet");
		lAct.setEnabled(true);
		lfoto = new JLabel("Actualizar foto");
		lfoto.setEnabled(true);
		lultimoT = new JLabel("Descripción  ");
		lultimoT.setEnabled(true);
		lultimoT1 = new JLabel("Descripción  ");
		lultimoT1.setEnabled(true);
		lseguidores = new JLabel("Seguidores de:");
		lseguidores.setEnabled(true);
		lseguidos = new JLabel("seguidos de: ");
		lseguidos.setEnabled(true);
		ltimeline = new JLabel("Timeline");
		ltimeline.setEnabled(true);
		lbuscartweets = new JLabel("Tweets de : ");
		lbuscartweets.setEnabled(true);
		lseguirSeguidores = new JLabel("Seguir a los seguidores de: ");
		lseguirSeguidores.setEnabled(true);
		lseguirSeguidos = new JLabel("Seguir a los seguidos de: ");
		lseguirSeguidos.setEnabled(true);
		linfo = new JLabel("Información de la cuenta:  ");
		linfo.setEnabled(true);
		

		textUsuario = new JTextField();
		textUsuario.setEnabled(true);
		textPass = new JTextField();
		textPass.setEnabled(true);
		textAct = new JTextField();
		textAct.setEnabled(true);
		textFoto = new JTextField();
		textFoto.setEnabled(true);
		textseguidores = new JTextField();
		textseguidores.setEnabled(true);
		textseguidos = new JTextField();
		textseguidos.setEnabled(true);
		texttimeline = new JTextField();
		textseguidos.setEnabled(true);
		textbuscartweets = new JTextField();
		textbuscartweets.setEnabled(true);
		textseguirSeguidores = new JTextField();
		textseguirSeguidores.setEnabled(true);
		textseguirSeguidos = new JTextField();
		textseguirSeguidos.setEnabled(true);

		texto = new JTextArea();
		ultimosTweetsseguidores = new JCheckBox();
		ultimosTweetsseguidos = new JCheckBox();

		JPanel sup1 = new JPanel();
		sup1.setLayout(new GridLayout(1, 5));
		sup1.add(ltoken);
		sup1.add(textUsuario);
		sup1.add(ltokensecreto);
		sup1.add(textPass);
		sup1.add(benviar);

		JPanel sup2 = new JPanel();
		sup2.setLayout(new GridLayout(1, 3));
		sup2.add(lAct);
		sup2.add(textAct);
		sup2.add(bActualizarEstado);

		JPanel sup3 = new JPanel();
		sup3.setLayout(new GridLayout(1, 3));
		sup3.add(lfoto);
		sup3.add(textFoto);
		sup3.add(bFoto);

		JPanel sup4_2 = new JPanel();
		sup4_2.setLayout(new GridLayout(1, 2));
		sup4_2.add(ultimosTweetsseguidores);
		sup4_2.add(lultimoT);

		JPanel sup4_1 = new JPanel();
		sup4_1.setLayout(new GridLayout(1, 2));
		sup4_1.add(sup4_2);
		sup4_1.add(bseguidores);

		JPanel sup4 = new JPanel();
		sup4.setLayout(new GridLayout(1, 4));
		sup4.add(lseguidores);
		sup4.add(textseguidores);
		sup4.add(sup4_1);

		JPanel sup5_2 = new JPanel();
		sup5_2.setLayout(new GridLayout(1, 2));
		sup5_2.add(ultimosTweetsseguidos);
		sup5_2.add(lultimoT1);

		JPanel sup5_1 = new JPanel();
		sup5_1.setLayout(new GridLayout(1, 2));
		sup5_1.add(sup5_2);
		sup5_1.add(bseguidos);

		JPanel sup5 = new JPanel();
		sup5.setLayout(new GridLayout(1, 4));
		sup5.add(lseguidos);
		sup5.add(textseguidos);
		sup5.add(sup5_1);

		JPanel sup6 = new JPanel();
		sup6.setLayout(new GridLayout(1, 3));
		sup6.add(ltimeline);
		sup6.add(texttimeline);
		sup6.add(btimeline);

		JPanel sup7 = new JPanel();
		sup7.setLayout(new GridLayout(1, 3));
		sup7.add(lbuscartweets);
		sup7.add(textbuscartweets);
		sup7.add(bbuscartweets);

		JPanel sup8 = new JPanel();
		sup8.setLayout(new GridLayout(1, 3));
		sup8.add(lseguirSeguidores);
		sup8.add(textseguirSeguidores);
		sup8.add(bseguirSeguidores);

		JPanel sup9 = new JPanel();
		sup9.setLayout(new GridLayout(1, 3));
		sup9.add(lseguirSeguidos);
		sup9.add(textseguirSeguidos);
		sup9.add(bseguirSeguidos);
		
		
		JPanel sup10 = new JPanel();
		sup10.setLayout(new GridLayout(1, 2));
		sup10.add(linfo);
		sup10.add(binfo);
		
		
		// parte superior
		JPanel sup = new JPanel();
		sup.setLayout(new GridLayout(9, 1));
		sup.add(sup1);
		sup.add(sup2);
		sup.add(sup3);
		sup.add(sup4);
		sup.add(sup5);
		sup.add(sup6);
		sup.add(sup7);
		sup.add(sup8);
		sup.add(sup9);
		//sup.add(sup10);

		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());

		centro.add(new JScrollPane(texto,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		JPanel todo = new JPanel();
		todo.setLayout(new GridLayout(2, 1));
		todo.add(sup, BorderLayout.NORTH);
		todo.add(centro, BorderLayout.SOUTH);
		add(todo);

	}

	@Override
	public void controlador(ActionListener ctr) {
		
		 benviar.addActionListener(ctr); 
		 benviar.setActionCommand(ENVIARUSUARIO);
		 bActualizarEstado.addActionListener(ctr); 
		 bActualizarEstado.setActionCommand(ACTUALIZARESTADO);
		 bFoto.addActionListener(ctr); 
		 bFoto.setActionCommand(ACTUALIZARFOTO);
		 bseguidores.addActionListener(ctr); 
		 bseguidores.setActionCommand(SEGUIDORES);
		 bseguidos.addActionListener(ctr); 
		 bseguidos.setActionCommand(SEGUIDOS);
		 btimeline.addActionListener(ctr); 
		 btimeline.setActionCommand(TIMELINE);
		 bbuscartweets.addActionListener(ctr); 
		 bbuscartweets.setActionCommand(BUSCARTWEETS);
		 bseguirSeguidores.addActionListener(ctr); 
		 bseguirSeguidores.setActionCommand(SEGUIRSEGUIDORES);
		 bseguirSeguidos.addActionListener(ctr); 
		 bseguirSeguidos.setActionCommand(SEGUIRSEGUIDOS);
		 binfo.addActionListener(ctr); 
		 binfo.setActionCommand(INFO);
		 
		 

	}

	@Override
	public String usuario() {
		return textUsuario.getText();
	}

	public boolean checkSeguidores() {
		return ultimosTweetsseguidores.isSelected();
	}

	public boolean checkSeguidos() {
		return ultimosTweetsseguidos.isSelected();
	}

	@Override
	public String pass() {
		return textPass.getText();
	}

	@Override
	public String PublicarTweet() {

		return textAct.getText();
	}

	@Override
	public String ActualizarFoto() {
		return textFoto.getText();
	}

	@Override
	public String SeguidoresDe() {

		return textseguidores.getText();
	}

	@Override
	public String SeguidosDe() {
		return textseguidos.getText();
	}

	public String buscarTweetsDe() {
		return textbuscartweets.getText();
	}

	@Override
	public int Timeline() {
		return Integer.parseInt(texttimeline.getText());
	}

	@Override
	public String SeguirSeguidoresDe() {
		return textseguirSeguidores.getText();
	}

	@Override
	public String SeguirSeguidosDe() {
		return textseguirSeguidos.getText();
	}

	@Override
	public void habilitarInicio(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void añadirAHistórico(String mensaje) {
		if (this.texto.getText().isEmpty()) {
			texto.setText(mensaje);
		} else {
			texto.setText(texto.getText() + "\n" + mensaje);
		}

	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ok(String mensaje) {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public int capacidadInicialA() { return
	 * Integer.parseInt(Ja.getText()); }
	 * 
	 * @Override public int capacidadInicialB() { return
	 * Integer.parseInt(Jb.getText()); }
	 * 
	 * public void error(String mensaje) {
	 * verificacion.setForeground(Color.RED);
	 * this.verificacion.setText(mensaje); }
	 * 
	 * public void ok(String mensaje) { verificacion.setForeground(Color.RED);
	 * this.verificacion.setText(mensaje); }
	 * 
	 * public void habilitarInicio(boolean b) { iniciar.setEnabled(!b);
	 * JarraA.setEnabled(!b); JarraB.setEnabled(!b); Ja.setEnabled(!b);
	 * Jb.setEnabled(!b);
	 * 
	 * llenarA.setEnabled(b); llenarB.setEnabled(b); VaciarA.setEnabled(b);
	 * vaciarB.setEnabled(b); sig.setEnabled(b); ant.setEnabled(b);
	 * Finalizar.setEnabled(b); ContenidoA.setEnabled(b);
	 * CapacidadA.setEnabled(b); ContenidoB.setEnabled(b);
	 * CapacidadB.setEnabled(b);
	 * 
	 * }
	 * 
	 * public void capacidadA(int c) { this.CapA.setText(String.valueOf(c));
	 * 
	 * }
	 * 
	 * public void capacidadB(int c) { this.CapB.setText(String.valueOf(c)); }
	 * 
	 * public void contenidoA(int c) { this.ContA.setText(String.valueOf(c)); }
	 * 
	 * public void contenidoB(int c) { this.ContB.setText(String.valueOf(c)); }
	 * 
	 * public void añadirAHistórico(String mensaje) { if
	 * (this.texto.getText().isEmpty()) { texto.setText(mensaje); } else {
	 * texto.setText(texto.getText() + "\n" + mensaje); } }
	 * 
	 * public void limpiar() { this.capacidadA(0); this.capacidadB(0);
	 * this.contenidoA(0); this.contenidoB(0); }
	 */

}
