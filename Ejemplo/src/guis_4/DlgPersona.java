package guis_4;

import clases.Persona;
import arreglos.ArregloPersonas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class DlgPersona extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblPeso;
	private JLabel lblEstatura;
	private JLabel lblEstadoCivil;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtPeso;
	private JTextField txtEstatura;
	private JComboBox <String> cboEstadoCivil;
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblPersona;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgPersona dialog = new DlgPersona();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgPersona() {
		setResizable(false);
		setTitle("Mantenimiento | Persona");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 35, 70, 23);
		getContentPane().add(lblNombre);
	
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 60, 70, 23);
		getContentPane().add(lblDni);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 85, 70, 23);
		getContentPane().add(lblPeso);
		
		lblEstatura = new JLabel("Estatura");
		lblEstatura.setBounds(10, 110, 70, 23);
		getContentPane().add(lblEstatura);
		
		lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(10, 135, 86, 23);
		getContentPane().add(lblEstadoCivil);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(90, 10, 86, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(90, 35, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(90, 60, 86, 23);
		getContentPane().add(txtDni);
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(90, 85, 50, 23);
		getContentPane().add(txtPeso);
		txtPeso.setEditable(false);
		txtPeso.setColumns(10);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(90, 110, 50, 23);
		getContentPane().add(txtEstatura);
		txtEstatura.setEditable(false);
		txtEstatura.setColumns(10);

		cboEstadoCivil = new JComboBox <String> ();
		cboEstadoCivil.setModel(new DefaultComboBoxModel <String> 
		                       (new String[] {"Soltero", "Casado", "Viudo", "Divorciado"}));
		cboEstadoCivil.setBounds(90, 135, 86, 23);
		getContentPane().add(cboEstadoCivil);
		cboEstadoCivil.setEnabled(false);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 775, 390);
		getContentPane().add(scrollPane);

		tblPersona = new JTable();
		tblPersona.addKeyListener(this);
		tblPersona.addMouseListener(this);
		tblPersona.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPersona);

		modelo = new DefaultTableModel();
		modelo.addColumn("C�DIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("DNI");
		modelo.addColumn("PESO (kg)");
		modelo.addColumn("ESTATURA (mts)");
		modelo.addColumn("ESTADO CIVIL");
		modelo.addColumn("IMC = peso/estatura�");
		modelo.addColumn("GRADO");
		tblPersona.setModel(modelo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(635, 10, 150, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.addActionListener(this);
		btnModificar.setBounds(635, 35, 150, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(635, 60, 150, 23);
		getContentPane().add(btnEliminar);
		
		ajustarAnchoColumnas();
		listar(0);
		editarFila();
		habilitarEntradas(false);
	}
	
	//  Declaraci�n global
	ArregloPersonas ap = new ArregloPersonas();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		if (btnAdicionar.getForeground() == Color.BLACK) {
			btnAdicionar.setForeground(Color.BLUE);
			btnModificar.setForeground(Color.BLACK);
			btnEliminar.setForeground(Color.BLACK);
			habilitarEntradas(true);
			limpieza();
			txtNombre.requestFocus();
		}
		else
			adicionarModificar();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (ap.tama�o() > 0)
			if (btnModificar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLACK);
				btnModificar.setForeground(Color.BLUE);
				btnEliminar.setForeground(Color.BLACK);
				editarFila();
				habilitarEntradas(true);
				txtNombre.requestFocus();
			}
			else
				adicionarModificar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (ap.tama�o() > 0) {
			btnAdicionar.setForeground(Color.BLACK);
			btnModificar.setForeground(Color.BLACK);
			btnEliminar.setForeground(Color.BLUE);
			editarFila();
			habilitarEntradas(false);
			int codigo = leerCodigo(),
			    ok = confirmar("� desea eliminar C�DIGO " + codigo + " ?");
			if (ok == 0) {
				Persona x = ap.buscar(codigo);
				int posFila = tblPersona.getSelectedRow();
				if (posFila == ap.tama�o()-1)
					posFila --;
				ap.eliminar(x);
				listar(posFila);
				editarFila();
			}
			btnEliminar.setForeground(Color.BLACK);
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();		
	}
	public void keyTyped(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblPersona) {
			mouseClickedTblPersona(arg0);
		}
	}
	protected void mouseClickedTblPersona(MouseEvent arg0) {
		btnAdicionar.setForeground(Color.BLACK);
		btnModificar.setForeground(Color.BLACK);
		habilitarEntradas(false);
		editarFila();
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	//  M�todos tipo void (sin par�metros)
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblPersona.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // dni
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // peso
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // estatura
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // estadoCivil
		tcm.getColumn(6).setPreferredWidth(anchoColumna(17));  // imc
		tcm.getColumn(7).setPreferredWidth(anchoColumna(10));  // grado
	}
	void listar(int posFila) {
		modelo.setRowCount(0);
		Persona x;
		for (int i=0; i<ap.tama�o(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigo(),
					          x.getNombre(),
					          x.getDni(),
					          x.getPeso(),
					          x.getEstatura(),
					          enTextoEstadoCivil(x.getEstado()),
					          ajustar(x.imc()),
					          x.grado() };
			modelo.addRow(fila);
		}
		tblPersona.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void editarFila() {
		if (ap.tama�o() == 0)
			limpieza();
		else {
			Persona x = ap.obtener(tblPersona.getSelectedRow());
			txtCodigo.setText("" + x.getCodigo());
			txtNombre.setText(x.getNombre());
			txtDni.setText(x.getDni());
			txtPeso.setText("" + x.getPeso());
			txtEstatura.setText("" + x.getEstatura());
			cboEstadoCivil.setSelectedIndex(x.getEstado());
		}
	}
	void limpieza() {
		txtCodigo.setText("" + ap.codigoCorrelativo());
		txtNombre.setText("");
		txtDni.setText("");
		txtPeso.setText("");
		txtEstatura.setText("");
		cboEstadoCivil.setSelectedIndex(0);
	}
	void adicionarModificar() {
		int codigo = ap.codigoCorrelativo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String dni = leerDni();
			if (dni.length() > 0) {
				try {
					double peso = leerPeso();
					try {
						double estatura = leerEstatura();
						int estado = leerPosEstado(),
							posFila = tblPersona.getSelectedRow();
						if (btnAdicionar.getForeground() == Color.BLUE) {
							if (ap.buscar(dni) == null) {
								Persona nueva = new Persona(codigo, nombre, dni, peso, estatura, estado);
								posFila = ap.tama�o();
								ap.adicionar(nueva);
								limpieza();
								txtCodigo.setText("" + ap.codigoCorrelativo());
								txtNombre.requestFocus();
							}
							else 
								error("El DNI " + dni + " ya existe", txtDni);
						}
						if (btnModificar.getForeground() == Color.BLUE) {
							Persona x = ap.obtener(posFila);
							x.setNombre(nombre);
							x.setDni(dni);
							x.setPeso(peso);
							x.setEstatura(estatura);
							x.setEstado(estado);
							btnModificar.setForeground(Color.BLACK);
							habilitarEntradas(false);
						}
						listar(posFila);
					}
					catch (Exception e) {
						error("Ingrese ESTATURA correcta", txtEstatura);
					}
				}
				catch (Exception e) {
					error("Ingrese PESO correcto", txtPeso);
				}		
			}
			else
				error("ingrese DNI correcto", txtDni);
		}
		else
			error("ingrese NOMBRE correcto", txtNombre);
	}
	//  M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		if (btnModificar.getForeground() == Color.BLUE)
			txtDni.setEditable(false);
		else
			txtDni.setEditable(sino);
		txtPeso.setEditable(sino);
		txtEstatura.setEditable(sino);
		cboEstadoCivil.setEnabled(sino);
	}
	//  M�todos que retornan valor (sin par�metros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	double leerPeso() {
		return Double.parseDouble(txtPeso.getText().trim());
	}
	double leerEstatura() {
		return Double.parseDouble(txtEstatura.getText().trim());
	}
	int leerPosEstado() {
		return cboEstadoCivil.getSelectedIndex();
	}
	//  M�todos que retornan valor (con par�metros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	String enTextoEstadoCivil(int i) {
		return cboEstadoCivil.getItemAt(i);
	}
	double ajustar(double numero) {
		return (int)(numero * 10) / 10.0;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
}