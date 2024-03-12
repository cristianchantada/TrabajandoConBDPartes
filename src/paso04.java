
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Mensajes.Mensaje;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import static PartesFiles.Validator.*;

public class paso04 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNIF;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;

	public static void main(String[] args) {
		new paso04();
	}

	/**
	 * Create the frame.
	 */
	public paso04() {

		setBounds(100, 100, 315, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNIF = new JTextField();
		txtNIF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!nifValidator(txtNIF.getText())) {
					Mensaje.verMensaje("El NIF no es correcto.\nPor favor escribe el NIF correcto");
					txtNIF.requestFocus();
				}
			}
		});
		txtNIF.setBounds(88, 21, 158, 20);
		contentPane.add(txtNIF);
		txtNIF.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 52, 158, 20);
		contentPane.add(txtNombre);

		txtCorreo = new JTextField();
		txtCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!emailValidator(txtCorreo.getText())) {
					Mensaje.verMensaje("El correo no es correcto.\nPor favor escribe el correo correcto");
					txtCorreo.requestFocus();
				}

			}
		});
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(88, 85, 158, 20);
		contentPane.add(txtCorreo);

		txtTelefono = new JTextField();
		txtTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!phoneValidator(txtTelefono.getText())) {
					Mensaje.verMensaje("El telefono no es correcto.\nPor favor escribe el telefono correcto");
					txtTelefono.requestFocus();
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(88, 116, 158, 20);
		contentPane.add(txtTelefono);

		JButton btnInsertar = new JButton("Añadir");
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					String url = "jdbc:mysql://localhost:3306/partes";
					String usuario = "root";
					String pass = "0000";
					
					// b.- Crear tunel de conexión
					Connection conexion = DriverManager.getConnection(url, usuario, pass);
					Statement stmt = conexion.createStatement();

					String sql = "insert into clientes(nif, nombre, email, telefono) values ('" + txtNIF.getText()
							+ "','" + txtNombre.getText() + "','" + txtCorreo.getText() + "','" + txtTelefono.getText()
							+ "')";

					int rowsAffected = stmt.executeUpdate(sql);

					if (rowsAffected > 0) {
						Mensaje.verMensaje("Cliente insertado correctamente");
					} else {
						Mensaje.verMensaje("Error al insertar cliente");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}

			}

		});

		btnInsertar.setBounds(123, 147, 89, 23);
		contentPane.add(btnInsertar);

		JLabel lblnif = new JLabel("NIF");
		lblnif.setBounds(10, 24, 46, 14);
		contentPane.add(lblnif);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 55, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 88, 46, 14);
		contentPane.add(lblCorreo);

		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(10, 119, 46, 14);
		contentPane.add(lblTelfono);

		setVisible(true);
	}

	public void setNIF(String idNIF) {
		txtNIF.setText(idNIF);
	}

	public String getNif() {
		return this.txtNIF.getText();
	}

	public String getNombre() {
		return this.txtNombre.getText();
	}

	public String getEmail() {
		return this.txtCorreo.getText();
	}

	public String getTelefono() {
		return this.txtNIF.getText();
	}

}