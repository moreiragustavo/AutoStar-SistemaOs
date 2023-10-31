package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;

import model.DAO;
import utils.Validador;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("unused")
public class usuarioos extends JDialog {

	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private JTextField textID;
	private JTextField textNome;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JButton btnPesquisar;
	private JButton btnAdicionar;
	private JButton btnLimparCampos;
	private JButton btnEditar;
	private JButton btnExcluir;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios;
	private JScrollPane scrollPaneUsuarios;
	@SuppressWarnings("rawtypes")
	private JList listaUsuario;
	@SuppressWarnings("rawtypes")
	private JComboBox Combo;
	private JCheckBox chckSenha;
	private JLabel lblPerfil;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuarioos dialog = new usuarioos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public usuarioos() {
		setResizable(false);
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
		setBackground(new Color(0, 128, 255));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPaneUsuarios.setVisible(false);
				textNome.setText(null);
			}
		});
		setTitle("Usuários");
		setIconImage(Toolkit.getDefaultToolkit().getImage(usuarioos.class.getResource("/img2/logo copiar.png")));
		setBounds(100, 100, 800, 600);

		scrollPaneUsuarios = new JScrollPane();
		scrollPaneUsuarios.setBounds(272, 258, 212, 80);
		scrollPaneUsuarios.setVisible(false);
		getContentPane().setLayout(null);
		scrollPaneUsuarios.setBorder(null);
		getContentPane().add(scrollPaneUsuarios);
		setLocationRelativeTo(null);

		listaUsuario = new JList();
		scrollPaneUsuarios.setViewportView(listaUsuario);
		listaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuscarUsuarioLista();
			}
		});

		JLabel txtnome = new JLabel("Nome");
		txtnome.setForeground(new Color(255, 255, 255));
		txtnome.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		txtnome.setBounds(350, 208, 73, 20);
		getContentPane().add(txtnome);

		JLabel txtsenha = new JLabel("Senha");
		txtsenha.setForeground(new Color(255, 255, 255));
		txtsenha.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		txtsenha.setBounds(350, 274, 73, 22);
		getContentPane().add(txtsenha);

		textID = new JTextField();
		textID.setBackground(new Color(255, 255, 255));
		textID.setBorder(null);
		textID.setBounds(350, 108, 51, 20);
		textID.setEditable(false);
		getContentPane().add(textID);
		textID.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(272, 230, 212, 33);
		textNome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				listarUsuarios();

			}

		});
		getContentPane().add(textNome);
		textNome.setColumns(10);
		textNome.setDocument(new Validador(20));

		textLogin = new JTextField();
		textLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textLogin.setBounds(272, 164, 212, 33);
		getContentPane().add(textLogin);
		textLogin.setColumns(10);
		textLogin.setDocument(new Validador(10));

		textID = new JTextField();
		textID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}

			}

		});

		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(537, 318, 80, 68);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
			}
		});
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setBorder(null);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setIcon(new ImageIcon(usuarioos.class.getResource("/img2/pngwing.com (4).png")));
		getContentPane().add(btnPesquisar);

		btnLimparCampos = new JButton("");
		btnLimparCampos.setBounds(548, 397, 69, 80);
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnLimparCampos.setIcon(new ImageIcon(usuarioos.class.getResource("/img2/pngegg (3).png")));
		btnLimparCampos.setToolTipText("LimparCampos");
		btnLimparCampos.setContentAreaFilled(false);
		btnLimparCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnLimparCampos);

		textSenha = new JPasswordField();
		textSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSenha.setText(null);
				textSenha.requestFocus();
				textSenha.setBackground(Color.YELLOW);
			}
		});
		textSenha.setBounds(272, 297, 212, 33);
		getContentPane().add(textSenha);
		getRootPane().setDefaultButton(btnPesquisar);

		btnAdicionar = new JButton("");
		btnAdicionar.setBounds(123, 397, 69, 80);
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBorder(null);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(usuarioos.class.getResource("/img2/addblackcircularbutton_104741 (1).png")));
		getContentPane().add(btnAdicionar);

		btnEditar = new JButton("");
		btnEditar.setBounds(272, 397, 69, 80);
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckSenha.isSelected()) {
					editarUsuario();
				} else {
					editarUsuarioExcetoSenha();
				}
			}
		});
		btnEditar.setBorder(null);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setIcon(new ImageIcon(usuarioos.class.getResource("/img2/pencileditblackcircularbuttoninterfacesymbol_104762 (4).png")));
		btnEditar.setToolTipText("Editar");
		getContentPane().add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.setBounds(415, 401, 69, 76);
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnExcluir.setIcon(new ImageIcon(usuarioos.class.getResource("/img2/crossdeleteblackcircularbutton_79721.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorder(null);
		btnExcluir.setToolTipText("Excluir");
		getContentPane().add(btnExcluir);

		listaUsuarios = new JList();
		listaUsuarios.setBounds(605, 174, -92, -58);
		getContentPane().add(listaUsuarios);
		listaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuscarUsuarioLista();
			}
		});
		listaUsuarios.setBorder(null);

		Combo = new JComboBox();
		Combo.setBackground(new Color(255, 255, 255));
		Combo.setModel(new DefaultComboBoxModel(new String[] { "", "admin", "usuario" }));
		Combo.setBounds(537, 258, 80, 38);
		getContentPane().add(Combo);

		chckSenha = new JCheckBox("Alterar Senha");
		chckSenha.setBackground(new Color(255, 255, 255));
		chckSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckSenha.isSelected()) {
					textSenha.setText(null);
					textSenha.requestFocus();
					textSenha.setBackground(Color.YELLOW);
				} else {
					textSenha.setBackground(Color.WHITE);

				}
			}
		});
		chckSenha.setBounds(318, 352, 124, 38);
		getContentPane().add(chckSenha);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblLogin.setBounds(350, 139, 73, 22);
		getContentPane().add(lblLogin);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblId.setBounds(364, 83, 59, 22);
		getContentPane().add(lblId);

		lblPerfil = new JLabel("Perfil");
		lblPerfil.setForeground(new Color(255, 255, 255));
		lblPerfil.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblPerfil.setBounds(548, 228, 69, 32);
		getContentPane().add(lblPerfil);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 527, 784, 34);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblData.setBounds(262, 0, 397, 34);
		panel.add(lblData);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(usuarioos.class.getResource("/img2/inicio2.png")));
		lblNewLabel.setBounds(0, -27, 784, 579);
		getContentPane().add(lblNewLabel);
	}

	@SuppressWarnings("unchecked")
	private void listarUsuarios() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuario.setModel(modelo);
		String readlista = "select * from usuarios where nome like '" + textNome.getText() + "%'" + "order by nome";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readlista);
			rs = pst.executeQuery();
			while (rs.next()) {
				scrollPaneUsuarios.setVisible(true);
				modelo.addElement(rs.getString(2));
				if (textNome.getText().isEmpty()) {
					scrollPaneUsuarios.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void BuscarUsuarioLista() {
		int linha = listaUsuario.getSelectedIndex();
		if (linha >= 0) {
			String readlistaUsuario = "select * from usuarios where nome like '" + textNome.getText() + "%'"
					+ "order by nome limit " + (linha) + ", 1";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readlistaUsuario);
				rs = pst.executeQuery();
				if (rs.next()) {
					scrollPaneUsuarios.setVisible(false);
					textID.setText(rs.getString(1));
					textNome.setText(rs.getString(2));
					textLogin.setText(rs.getString(3));
					textSenha.setText(rs.getString(4));
					Combo.setSelectedItem(rs.getString(5));
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário Inexistente");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			scrollPaneUsuarios.setVisible(false);

		}

	}

	private void LimparCampos() {
		textID.setText(null);
		textNome.setText(null);
		textLogin.setText(null);
		textSenha.setText(null);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnPesquisar.setEnabled(true);
		btnAdicionar.setEnabled(false);
		scrollPaneUsuarios.setVisible(false);
		Combo.setSelectedItem("");
		chckSenha.setSelected(false);

	}

	private void Buscar() {

		String read = "select * from usuarios where login = ?";

		try {

			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, textLogin.getText());
			rs = pst.executeQuery();

			if (rs.next()) {
				textID.setText(rs.getString(1));
				textNome.setText(rs.getString(2));
				textLogin.setText(rs.getString(3));
				textSenha.setText(rs.getString(4));
				Combo.setSelectedItem(rs.getString(5));
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
				btnPesquisar.setEnabled(true);

			} else {
				JOptionPane.showMessageDialog(null, "Usuário inexistente");
				btnAdicionar.setEnabled(true);
				btnPesquisar.setEnabled(false);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("deprecation")
	private void adicionar() {
		if (textNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Usuário");
			textNome.requestFocus();
		} else if (textLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login do Usuário");
			textLogin.requestFocus();
		} else if (textSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Senha do Usuário");
			textSenha.requestFocus();
		} else {
			String create = "insert into usuarios(nome,login,senha,perfil) values (?,?,md5(?),?)";

			try {
				con = dao.conectar();
				pst = con.prepareStatement(create);
				pst.setString(1, textNome.getText());
				pst.setString(2, textLogin.getText());
				pst.setString(3, textSenha.getText());
				pst.setString(4, Combo.getSelectedItem().toString());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Usuário adicionado");
				LimparCampos();
				con.close();
			} catch (Exception e) {
				System.out.println(e);

			}

		}

	}

	@SuppressWarnings("deprecation")
	private void editarUsuario() {

		String update2 = "update usuarios set nome=?,login=?,senha=md5(?),perfil=? where id=?";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(update2);
			pst.setString(1, textNome.getText());
			pst.setString(2, textLogin.getText());
			pst.setString(3, textSenha.getText());
			pst.setString(4, Combo.getSelectedItem().toString());
			pst.setString(5, textID.getText());
			pst.executeUpdate();
			JOptionPane.showInternalMessageDialog(null, "Dados do Usuário editados com Sucesso");
			LimparCampos();
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	private void editarUsuarioExcetoSenha() {

		String update2 = "update usuarios set nome=?,login=?,perfil=? where id=?";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(update2);
			pst.setString(1, textNome.getText());
			pst.setString(2, textLogin.getText());
			pst.setString(3, Combo.getSelectedItem().toString());
			pst.setString(4, textID.getText());
			pst.executeUpdate();
			JOptionPane.showInternalMessageDialog(null, "Dados do Usuário editados com Sucesso");
			LimparCampos();
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	private void excluirContato() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Usuário?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			// CRUD - Delete
			String delete = "delete from usuarios where id=?";

			try {
				con = dao.conectar();
				pst = con.prepareStatement(delete);
				pst.setString(1, textID.getText());
				pst.executeUpdate();
				LimparCampos();
				JOptionPane.showMessageDialog(null, "Usuário Excluído");
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	
}
