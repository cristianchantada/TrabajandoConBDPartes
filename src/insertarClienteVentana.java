
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Mensajes.Mensaje;
import controllers.Cliente;
import models.ClienteDao;
import java.awt.event.*;
import static Validacion.Validator.*;

public class insertarClienteVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JButton btnInsertar = new JButton("Añadir");
	public JTextField txtNIF = new JTextField();
	private JTextField txtNombre = new JTextField();
	private JTextField txtCorreo = new JTextField();
	private JTextField txtTelefono = new JTextField();;

	public static void main(String[] args) {
		new insertarClienteVentana();
	}

	public insertarClienteVentana() {

		setBounds(100, 100, 315, 210);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
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

		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 52, 158, 20);
		contentPane.add(txtNombre);

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

		
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Cliente cliente = new Cliente();
				cliente.setNif(txtNIF.getText());
				cliente.setNombre(txtNombre.getText());
				cliente.setCorreo(txtCorreo.getText());
				cliente.setTelefono(txtTelefono.getText());
				
				ClienteDao clienteDao = new ClienteDao();
				clienteDao.save(cliente);
			}
		});
		btnInsertar.setBounds(123, 147, 89, 23);
		contentPane.add(btnInsertar);

		insertarLabels();
		
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
	
	public static void insertarLabels() {


	}

}