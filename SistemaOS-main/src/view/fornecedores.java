package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.DAO;
import utils.Validador;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.BevelBorder;

public class fornecedores extends JDialog {

	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private JTextField txtID;
	private JTextField txtRazao;
	private JTextField txtFone;
	private JTextField txtCNPJ;
	private JTextField txtEndereco;
	private JTextField txtCEP;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox cboUF;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUF_1;
	private JButton btnLimpar;
	private JButton btnEditar;
	private JButton btnAdicionar;
	private JButton btnExcluir;
	private JScrollPane scrollPane00;
	@SuppressWarnings("rawtypes")
	private JList listarUsuarios;
	private JTextField txtFantasia;
	private JTextField txtVendedor;
	private JTextField txtIE;
	private JTextField txtEmail;
	private JTextField txtSite;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JLabel lblNewLabel_15;
	private JLabel lblData;
	private JButton btnbuscarCep;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fornecedores dialog = new fornecedores();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public fornecedores() {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(fornecedores.class.getResource("/img2/testelogoempresa.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle("Fornecedores");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		scrollPane00 = new JScrollPane();
		scrollPane00.setVisible(false);
		scrollPane00.setBounds(106, 153, 214, 33);
		getContentPane().add(scrollPane00);

		listarUsuarios = new JList();
		listarUsuarios.setDoubleBuffered(true);
		listarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarUsuarioLista();
			}
		});
		scrollPane00.setViewportView(listarUsuarios);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(106, 74, 26, 14);
		getContentPane().add(lblNewLabel);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(106, 91, 53, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		txtRazao = new JTextField();
		txtRazao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarUsuario();
			}
		});
		txtRazao.setBounds(106, 135, 214, 20);
		getContentPane().add(txtRazao);
		txtRazao.setColumns(10);
		txtRazao.setDocument(new Validador(40));

		txtFone = new JTextField();
		txtFone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		txtFone.setBounds(430, 91, 214, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		txtFone.setDocument(new Validador(15));

		txtCNPJ = new JTextField();
		txtCNPJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		txtCNPJ.setBounds(106, 233, 214, 20);
		getContentPane().add(txtCNPJ);
		txtCNPJ.setColumns(10);
		txtCNPJ.setDocument(new Validador(15));

		lblNewLabel_1 = new JLabel("Razão Social");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_1.setBounds(106, 119, 104, 14);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_2.setBounds(430, 76, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_3.setBounds(106, 216, 76, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_4.setBounds(430, 216, 86, 14);
		getContentPane().add(lblNewLabel_4);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(430, 233, 214, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		txtCEP = new JTextField();
		txtCEP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		txtCEP.setBounds(430, 185, 214, 20);
		getContentPane().add(txtCEP);
		txtCEP.setColumns(10);
		txtCEP.setDocument(new Validador(8));

		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_5.setBounds(430, 172, 79, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_6.setBounds(558, 311, 118, 14);
		getContentPane().add(lblNewLabel_6);

		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {

		});
		txtNumero.setBounds(558, 336, 118, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		txtNumero.setDocument(new Validador(7));

		JLabel lblNewLabel_7 = new JLabel("Cidade");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_7.setBounds(430, 264, 76, 14);
		getContentPane().add(lblNewLabel_7);

		txtCidade = new JTextField();
		txtCidade.setBounds(430, 280, 118, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		txtCidade.setDocument(new Validador(30));

		txtComplemento = new JTextField();
		txtComplemento.setBounds(430, 336, 118, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		txtComplemento.setDocument(new Validador(25));

		JLabel lblNewLabel_8 = new JLabel("Complemento");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_8.setBounds(430, 311, 144, 14);
		getContentPane().add(lblNewLabel_8);

		cboUF_1 = new JComboBox();
		cboUF_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cboUF_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		cboUF_1.setModel(new DefaultComboBoxModel(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUF_1.setBounds(589, 370, 54, 24);
		getContentPane().add(cboUF_1);

		btnbuscarCep = new JButton("BuscarCEP");
		btnbuscarCep.setBackground(Color.WHITE);
		btnbuscarCep.setBorder(null);
		btnbuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnbuscarCep.setBounds(430, 371, 118, 23);
		getContentPane().add(btnbuscarCep);

		JLabel lblNewLabel_9 = new JLabel("Bairro");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_9.setBounds(558, 264, 86, 14);
		getContentPane().add(lblNewLabel_9);

		txtBairro = new JTextField();
		txtBairro.setBounds(558, 280, 118, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		txtBairro.setDocument(new Validador(40));

		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorder(null);
		btnLimpar.setToolTipText("Limpar Campos");
		btnLimpar.setIcon(new ImageIcon(fornecedores.class.getResource("/img2/pngegg (3).png")));
		btnLimpar.setBounds(472, 433, 80, 60);
		getContentPane().add(btnLimpar);

		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorder(null);
		btnEditar.setToolTipText("Editar Fornecedor");
		btnEditar.setIcon(new ImageIcon(fornecedores.class.getResource("/img2/pencileditblackcircularbuttoninterfacesymbol_104762 (4).png")));
		btnEditar.setBounds(292, 433, 80, 60);
		getContentPane().add(btnEditar);

		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBorder(null);
		btnAdicionar.setToolTipText("Adicionar Fornecedor");
		btnAdicionar
				.setIcon(new ImageIcon(fornecedores.class.getResource("/img2/addblackcircularbutton_104741 (1).png")));
		btnAdicionar.setBounds(202, 433, 80, 60);
		getContentPane().add(btnAdicionar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnExcluir.setToolTipText("Excluir Fornecedor");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(
				new ImageIcon(fornecedores.class.getResource("/img2/crossdeleteblackcircularbutton_79721.png")));
		btnExcluir.setBounds(382, 433, 80, 60);
		getContentPane().add(btnExcluir);

		txtFantasia = new JTextField();
		txtFantasia.setBounds(106, 280, 214, 20);
		getContentPane().add(txtFantasia);
		txtFantasia.setColumns(10);

		lblNewLabel_10 = new JLabel("Fantasia");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_10.setBounds(106, 264, 134, 14);
		getContentPane().add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("Vendedor");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_11.setBounds(430, 119, 100, 14);
		getContentPane().add(lblNewLabel_11);

		txtVendedor = new JTextField();
		txtVendedor.setBounds(430, 135, 214, 20);
		getContentPane().add(txtVendedor);
		txtVendedor.setColumns(10);

		lblNewLabel_12 = new JLabel("IE (Inscrição Estadual)");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_12.setBounds(106, 354, 176, 14);
		getContentPane().add(lblNewLabel_12);

		txtIE = new JTextField();
		txtIE.setBounds(106, 372, 214, 20);
		getContentPane().add(txtIE);
		txtIE.setColumns(10);
		txtIE.setDocument(new Validador(15));

		lblNewLabel_13 = new JLabel("E-mail");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_13.setBounds(106, 311, 76, 14);
		getContentPane().add(lblNewLabel_13);

		txtEmail = new JTextField();
		txtEmail.setBounds(106, 323, 214, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		lblNewLabel_14 = new JLabel("Site");
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_14.setBounds(106, 172, 63, 14);
		getContentPane().add(lblNewLabel_14);

		txtSite = new JTextField();
		txtSite.setBounds(106, 185, 214, 20);
		getContentPane().add(txtSite);
		txtSite.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(0, 527, 784, 34);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblData.setBounds(262, 0, 397, 34);
		panel.add(lblData);
		
		lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setIcon(new ImageIcon(fornecedores.class.getResource("/img2/inicio2.png")));
		lblNewLabel_15.setBounds(-2, 0, 786, 561);
		getContentPane().add(lblNewLabel_15);

	}

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCEP.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUF_1.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						System.out.println("OK");
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}
			txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void excluirContato() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste fornecedor?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idfor=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(delete);
				pst.setString(1, txtID.getText());
				pst.executeUpdate();
				limparCampos();

				JOptionPane.showMessageDialog(null, "Fornecedor excluído");
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Não foi Possível Excluir o Fornecedor!\nHá um Serviço Pendente.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void editarContato() {
		if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome do fornecedor");
			txtRazao.requestFocus();
		} else {
			String update = "update fornecedores set razao=?, fantasia=?, vendedor=?, cnpj=?, ie=?, email=?, site=?, fone=?, cep=?, endereco=?, bairro=?, complemento=?, numero=?, cidade=?, uf=? WHERE idfor=? ";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtVendedor.getText());
				pst.setString(4, txtCNPJ.getText());
				pst.setString(5, txtIE.getText());
				pst.setString(6, txtEmail.getText());
				pst.setString(7, txtSite.getText());
				pst.setString(8, txtFone.getText());
				pst.setString(9, txtCEP.getText());
				pst.setString(10, txtEndereco.getText());
				pst.setString(11, txtBairro.getText());
				pst.setString(12, txtComplemento.getText());
				pst.setString(13, txtNumero.getText());
				pst.setString(14, txtCidade.getText());
				pst.setString(15, cboUF_1.getSelectedItem().toString());
				pst.setString(16, txtID.getText());
				pst.executeUpdate();
				limparCampos();
				JOptionPane.showMessageDialog(null, "Dados do fornecedor editados com sucesso");
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(null, "CNPJ Existente");
				txtCNPJ.setText(null);
				txtCNPJ.requestFocus();
			} catch (Exception e1) {
				System.out.println(e1);

			}
		}
	}

	private void limparCampos() {
		txtID.setText(null);
		txtRazao.setText(null);
		txtVendedor.setText(null);
		txtEndereco.setText(null);
		txtCNPJ.setText(null);
		txtIE.setText(null);
		txtEmail.setText(null);
		txtSite.setText(null);
		txtFantasia.setText(null);
		txtCEP.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtFone.setText(null);
		cboUF_1.setSelectedItem(null);
	}

	private void adicionarUsuario() {
		if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor");
			txtRazao.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
			txtFone.requestFocus();
		} else if (txtCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ do fornecedor");
			txtCNPJ.requestFocus();
		} else if (txtCEP.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP do fornecedor");
			txtCEP.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a cidade do fornecedor");
			txtCidade.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o número do fornecedor");
			txtNumero.requestFocus();
		} else {
			String create = "insert into fornecedores(razao,fantasia,vendedor,cnpj,ie,email,site,fone,cep,endereco,bairro,complemento,numero,cidade,uf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {

				con = dao.conectar();

				pst = con.prepareStatement(create);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtVendedor.getText());
				pst.setString(4, txtCNPJ.getText());
				pst.setString(5, txtIE.getText());
				pst.setString(6, txtEmail.getText());
				pst.setString(7, txtSite.getText());
				pst.setString(8, txtFone.getText());
				pst.setString(9, txtCEP.getText());
				pst.setString(10, txtEndereco.getText());
				pst.setString(11, txtBairro.getText());
				pst.setString(12, txtComplemento.getText());
				pst.setString(13, txtNumero.getText());
				pst.setString(14, txtCidade.getText());
				pst.setString(15, cboUF_1.getSelectedItem().toString());

				pst.executeUpdate();

				JOptionPane.showMessageDialog(null, "Fornecedor adicionado");

				limparCampos();

				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(null, "CNPJ Existente");
				txtCNPJ.setText(null);
				txtCNPJ.requestFocus();
			} catch (Exception e1) {

				System.out.println(e1);

			}

		}
	}

	@SuppressWarnings("unchecked")
	private void listarUsuario() {

		DefaultListModel<String> modelo = new DefaultListModel<>();

		listarUsuarios.setModel(modelo);

		String readlista = "select * from fornecedores where razao like '" + txtRazao.getText() + "%'"
				+ "order by razao";
		try {

			con = dao.conectar();

			pst = con.prepareStatement(readlista);

			rs = pst.executeQuery();

			while (rs.next()) {

				scrollPane00.setVisible(true);

				modelo.addElement(rs.getString(2));

				if (txtRazao.getText().isEmpty()) {
					scrollPane00.setVisible(false);
				}

			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarUsuarioLista() {

		int linha = listarUsuarios.getSelectedIndex();
		if (linha >= 0) {
			String readlistaUsuario = "select * from fornecedores where razao like '" + txtRazao.getText() + "%'"
					+ "order by razao limit " + (linha) + " , 1";
			try {

				con = dao.conectar();

				pst = con.prepareStatement(readlistaUsuario);

				rs = pst.executeQuery();
				if (rs.next()) {

					scrollPane00.setVisible(false);

					txtID.setText(rs.getString(1));
					txtRazao.setText(rs.getString(2));
					txtFantasia.setText(rs.getString(3));
					txtVendedor.setText(rs.getString(4));
					txtCNPJ.setText(rs.getString(5));
					txtIE.setText(rs.getString(6));
					txtEmail.setText(rs.getString(7));
					txtSite.setText(rs.getString(8));
					txtFone.setText(rs.getString(9));
					txtCEP.setText(rs.getString(10));
					txtEndereco.setText(rs.getString(11));
					txtBairro.setText(rs.getString(12));
					txtComplemento.setText(rs.getString(13));
					txtNumero.setText(rs.getString(14));
					txtCidade.setText(rs.getString(15));
					cboUF_1.setSelectedItem(rs.getString(16));

				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");

				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {

			scrollPane00.setVisible(false);

		}
	}
}
