package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.modelo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAlumno;
	private JTextField txtNota;
	private JTextField txtModulo;
	private modelo modelo;
	private DefaultTableModel dtmtabla;
	
	public void setmod(modelo mod) {
		this.modelo = mod;
	}

	public tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnAnadir = new JButton("a\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String alumno = txtAlumno.getText();
				String nota = txtNota.getText();
				String modulo = txtModulo.getText();
				modelo.btnanadir(alumno, nota, modulo);
				Object[] fila = { txtAlumno.getText(), txtNota.getText(), txtModulo.getText() };
				dtmtabla.addRow(fila);
				txtAlumno.setText("");
				txtNota.setText("");
				txtModulo.setText("");

			}
		});

		JButton btnBorrar = new JButton("borrar");

		JButton btnModificar = new JButton("modificar");

		txtAlumno = new JTextField();
		txtAlumno.setColumns(10);

		txtNota = new JTextField();
		txtNota.setColumns(10);

		txtModulo = new JTextField();
		txtModulo.setColumns(10);
		
		JLabel lblAlumno = new JLabel("alumno");
		
		JLabel lblNota = new JLabel("nota");
		
		JLabel lblModulo = new JLabel("modulo");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAnadir)
									.addGap(40)
									.addComponent(btnBorrar))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAlumno))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNota)
										.addComponent(txtNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblModulo)
								.addComponent(btnModificar)
								.addComponent(txtModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlumno)
						.addComponent(lblNota)
						.addComponent(lblModulo))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnadir)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addGap(35))
		);

		table = new JTable();
		dtmtabla = new DefaultTableModel(new Object[][] {},
				new String[] { "CAT_FORMATO", "FORMATO", "DIMENSIONES FORMATO" });
		//tabla.setModel(dtmtabla);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
