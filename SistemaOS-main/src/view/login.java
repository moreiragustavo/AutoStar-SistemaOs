package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class login extends JFrame {

	private static final long serialVersionUID = 1;

	DAO dao = new DAO();
	private PreparedStatement pst;
	private Connection con;
	private ResultSet rs;

	principal principal = new principal();

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JLabel lblData;
	private JPanel panel;
	private JButton lblStatus;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setarData();
			}

			private void setarData() {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));

			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img2/logodaempresa.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLogin.setBounds(239, 204, 293, 46);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel_1.setBounds(354, 281, 178, 20);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBorder(UIManager.getBorder("ComboBox.border"));
		txtSenha.setBounds(239, 312, 293, 46);
		contentPane.add(txtSenha);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 507, 784, 54);
		contentPane.add(panel);
		panel.setLayout(null);

		lblData = new JLabel("");
		lblData.setBounds(262, 11, 505, 32);
		panel.add(lblData);
		lblData.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblData.setForeground(new Color(0, 0, 0));
		lblData.setBackground(new Color(0, 0, 0));
		
				lblStatus = new JButton("");
				lblStatus.setBounds(725, 0, 49, 54);
				panel.add(lblStatus);
				lblStatus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						status();
					}
				});
				lblStatus.setIcon(new ImageIcon(login.class.getResource("/img/dbon.png")));
				lblStatus.setBorder(null);
				lblStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblStatus.setContentAreaFilled(false);
				lblStatus.setToolTipText("Status");

		lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel_2.setBounds(354, 173, 178, 20);
		contentPane.add(lblNewLabel_2);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/img2/logodaempresa.png")));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		lblNewLabel.setBounds(314, 17, 153, 129);
		contentPane.add(lblNewLabel);

		lblNewLabel_3 = new JLabel("Mecânica AutoStar");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(291, 132, 196, 14);
		contentPane.add(lblNewLabel_3);
				
				lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNewLabel_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("inicio");
						Logar();
					}
				});
				lblNewLabel_5.setIcon(new ImageIcon(login.class.getResource("/img2/btnacessar2.png")));
				lblNewLabel_5.setBounds(327, 406, 160, 36);
				contentPane.add(lblNewLabel_5);
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/img2/inicio.jpg")));
				lblNewLabel_4.setBounds(0, 0, 784, 561);
				contentPane.add(lblNewLabel_4);

	}

	private void Logar() {
		String capturaSenha = new String(txtSenha.getPassword());

		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtSenha.requestFocus();
		} else {

			String read = "select * from usuarios where login=? and senha=md5(?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read);
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				rs = pst.executeQuery();
				if (rs.next()) {

					String perfil = rs.getString(5);
					if (perfil.equals("admin")) {
						principal.setVisible(true);
						principal.lblUsuario.setText(rs.getString(2));
						this.dispose();

						principal.btnRelatorios.setEnabled(true);
						principal.btnUsuarios.setEnabled(true);

						principal.panelRodape.setBackground(Color.lightGray);
					} else {
						principal.setVisible(true);
						principal.lblUsuario.setText(rs.getString(2));
						this.dispose();

					}

				} else {
					JOptionPane.showMessageDialog(null, "Usuário e/ou senha Inválido(s)");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void status() {
		try {
			con = dao.conectar();
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(login.class.getResource("/img/dboff.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(login.class.getResource("/img/dbon.png")));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
