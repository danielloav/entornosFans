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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAlumno;
	private JTextField txtNota;
	private JTextField txtModulo;
	private modelo modelo;
	private DefaultTableModel dtmt;
	private JTextField txtProfesor;

	public void setmod(modelo mod) {
		this.modelo = mod;
	}

	public tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 374);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnAnadir = new JButton("a\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String alumno = txtAlumno.getText();
				String nota = txtNota.getText();
				String modulo = txtModulo.getText();
				String profesor = txtProfesor.getText();
				modelo.btnanadir(alumno, nota, modulo, profesor);
				Object[] fila = { txtAlumno.getText(), txtNota.getText(), txtModulo.getText(),txtProfesor.getText() };
				dtmt.addRow(fila);
				txtAlumno.setText("");
				txtNota.setText("");
				txtModulo.setText("");
				txtProfesor.setText("");
				JOptionPane.showMessageDialog(null, "Añadido!!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton btnBorrar = new JButton("borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dtmt.removeRow(table.getSelectedRow());
				txtAlumno.setText("");
				txtNota.setText("");
				txtModulo.setText("");
				txtProfesor.setText("");
				JOptionPane.showMessageDialog(null, "borrado!!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton btnModificar = new JButton("modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setValueAt(txtAlumno.getText(), table.getSelectedRow(), 0);
				table.setValueAt(txtNota.getText(), table.getSelectedRow(), 1);
				table.setValueAt(txtModulo.getText(), table.getSelectedRow(), 2);
				table.setValueAt(txtProfesor.getText(), table.getSelectedRow(), 2);

			}
		});

		txtAlumno = new JTextField();
		txtAlumno.setColumns(10);

		txtNota = new JTextField();
		txtNota.setColumns(10);

		txtModulo = new JTextField();
		txtModulo.setColumns(10);

		JLabel lblAlumno = new JLabel("alumno");

		JLabel lblNota = new JLabel("nota");

		JLabel lblModulo = new JLabel("modulo");

		txtProfesor = new JTextField();
		txtProfesor.setColumns(10);

		JLabel lblProfesor = new JLabel("profesor");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAlumno)
								.addComponent(btnAnadir)
								.addComponent(txtAlumno, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(txtNota, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(26)
											.addComponent(lblNota)))
									.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblModulo)
										.addComponent(txtModulo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addComponent(btnBorrar)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnModificar)
									.addGap(139))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtProfesor, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProfesor))
									.addGap(103)))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAlumno)
								.addComponent(lblNota)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProfesor)
								.addComponent(lblModulo))))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnadir)
						.addComponent(btnModificar)
						.addComponent(btnBorrar))
					.addGap(35))
		);
		//aqui damos dinamismo a la tabla, para insertar
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtAlumno.setText((String) dtmt.getValueAt(table.getSelectedRow(), 0));
				txtNota.setText((String) dtmt.getValueAt(table.getSelectedRow(), 1));
				txtModulo.setText((String) dtmt.getValueAt(table.getSelectedRow(), 2));
				txtProfesor.setText((String) dtmt.getValueAt(table.getSelectedRow(), 3));

			}
		});
		dtmt = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre alumno","Nota","Modulo", "profesor"});
		table.setModel(dtmt);

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
