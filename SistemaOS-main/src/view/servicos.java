package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;
import utils.Validador;

import javax.swing.border.TitledBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class servicos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txtOS;
	private JTextField txtData;
	private JTextField txtVeiculo;
	private JTextField txtProblema;
	private JTextField txtValor;
	private JTextField txtID;
	private JButton btnBuscar;
	private JButton btnAdd;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JTextField txtCliente;
	@SuppressWarnings("rawtypes")
	private JList listaCliente;
	private JScrollPane scrollPane;
	private JButton btnOS;
	private JLabel lblValor;
	private JLabel lblProblema;
	private JLabel lblVeculo;
	private JLabel lblDia;
	private JLabel lblOs;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblData;
	private JPanel panel;

	public static void main(String[] args) {
		try {
			servicos dialog = new servicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public servicos() {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(servicos.class.getResource("/img2/logo copiar.png")));
		setTitle("Ordem de Serviço");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		btnAdd = new JButton("");
		btnAdd.setBorder(null);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setIcon(new ImageIcon(servicos.class.getResource("/img/addblackcircularbutton_104741 (1).png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		btnAdd.setBounds(108, 393, 89, 63);
		contentPanel.add(btnAdd);

		btnEditar = new JButton("");
		btnEditar.setBorder(null);
		btnEditar.setIcon(new ImageIcon(
				servicos.class.getResource("/img/pencileditblackcircularbuttoninterfacesymbol_104762 (4).png")));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar();
			}
		});
		btnEditar.setBounds(254, 393, 89, 63);
		contentPanel.add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(servicos.class.getResource("/img/crossdeleteblackcircularbutton_79721.png")));
		btnExcluir.setBorder(null);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Excluir();
			}
		});
		btnExcluir.setBounds(385, 393, 89, 63);
		contentPanel.add(btnExcluir);

		txtOS = new JTextField();
		txtOS.setEditable(false);
		txtOS.setBounds(100, 108, 63, 20);
		contentPanel.add(txtOS);
		txtOS.setColumns(10);

		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(100, 159, 199, 20);
		contentPanel.add(txtData);
		txtData.setColumns(10);

		txtVeiculo = new JTextField();
		txtVeiculo.setBounds(100, 213, 199, 20);
		contentPanel.add(txtVeiculo);
		txtVeiculo.setColumns(10);
		txtVeiculo.setDocument(new Validador(30));

		txtProblema = new JTextField();
		txtProblema.setBounds(100, 267, 199, 23);
		contentPanel.add(txtProblema);
		txtProblema.setColumns(10);

		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();

				}
			}
		});
		txtValor.setBounds(100, 322, 199, 20);
		contentPanel.add(txtValor);
		txtValor.setColumns(10);
		txtValor.setDocument(new Validador(10));

		btnBuscar = new JButton("");
		btnBuscar.setBorder(null);
		btnBuscar.setIcon(new ImageIcon(servicos.class.getResource("/img2/pngwing.com (4).png")));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(210, 95, 89, 45);
		contentPanel.add(btnBuscar);

		btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(servicos.class.getResource("/img/pngegg (3).png")));
		btnLimpar.setBorder(null);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setBounds(535, 393, 89, 63);
		contentPanel.add(btnLimpar);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(411, 137, 270, 119);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtCliente = new JTextField();
		txtCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCliente.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				ListarCliente();
			}
		});
		txtCliente.setBounds(10, 21, 250, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(34, 93, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 94, 46, 19);
		panel.add(lblNewLabel_4);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 250, 50);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		scrollPane.setBorder(null);

		listaCliente = new JList();
		scrollPane.setViewportView(listaCliente);
		listaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuscarNomeCliente();
			}
		});
		listaCliente.setBorder(null);

		btnOS = new JButton("OS");
		btnOS.setAutoscrolls(true);
		btnOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirOS();

			}
		});
		btnOS.setBounds(547, 349, 89, 23);
		contentPanel.add(btnOS);

		lblValor = new JLabel("Valor");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValor.setBounds(100, 300, 89, 23);
		contentPanel.add(lblValor);

		lblProblema = new JLabel("Problema");
		lblProblema.setForeground(new Color(255, 255, 255));
		lblProblema.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProblema.setBounds(100, 244, 112, 23);
		contentPanel.add(lblProblema);

		lblVeculo = new JLabel("Veículo");
		lblVeculo.setForeground(new Color(255, 255, 255));
		lblVeculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVeculo.setBounds(100, 190, 89, 23);
		contentPanel.add(lblVeculo);

		lblDia = new JLabel("Data");
		lblDia.setForeground(new Color(255, 255, 255));
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDia.setBounds(100, 137, 75, 20);
		contentPanel.add(lblDia);

		lblOs = new JLabel("OS");
		lblOs.setForeground(new Color(255, 255, 255));
		lblOs.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOs.setBounds(100, 74, 69, 43);
		contentPanel.add(lblOs);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 527, 784, 34);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblData.setBounds(262, 0, 397, 34);
		panel_1.add(lblData);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(servicos.class.getResource("/img2/inicio2.png")));
		lblNewLabel.setBounds(0, -8, 784, 561);
		contentPanel.add(lblNewLabel);
	}

	@SuppressWarnings("unchecked")
	private void ListarCliente() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaCliente.setModel(modelo);

		String readlistaCliente = "select * from clientes where nome like '" + txtCliente.getText() + "%'"
				+ "order by nome";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readlistaCliente);
			rs = pst.executeQuery();
			while (rs.next()) {
				scrollPane.setVisible(true);
				modelo.addElement(rs.getString(2));
				if (txtCliente.getText().isEmpty()) {
					scrollPane.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void BuscarNomeCliente() {
		int linha = listaCliente.getSelectedIndex();
		if (linha >= 0) {
			String readlistaServico = "select * from clientes where nome like '" + txtCliente.getText() + "%'"
					+ "order by nome limit " + (linha) + " , 1";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readlistaServico);
				rs = pst.executeQuery();
				if (rs.next()) {
					scrollPane.setVisible(false);
					txtID.setText(rs.getString(1));
					txtCliente.setText(rs.getString(2));

				} else {
					JOptionPane.showMessageDialog(null, "Cliente Inexistente");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			scrollPane.setVisible(false);
		}
	}

	private void buscar() {
		String numOS = JOptionPane.showInputDialog("Número da OS");

		String read = "select * from servicos inner join clientes on servicos.idcli = clientes.idcli where os=?";
		try {
			con = dao.conectar();

			pst = con.prepareStatement(read);

			pst.setString(1, numOS);
			rs = pst.executeQuery();
			if (rs.next()) {
				txtOS.setText(rs.getString(1));
				txtData.setText(rs.getString(2));
				txtVeiculo.setText(rs.getString(3));
				txtProblema.setText(rs.getString(4));
				txtValor.setText(rs.getString(5));
				txtID.setText(rs.getString(6));
				txtCliente.setText(rs.getString(8));
			} else {
				JOptionPane.showMessageDialog(null, "Serviço Inexistente");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void Add() {

		if (txtVeiculo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Veículo do Cliente");
			txtVeiculo.requestFocus();
		} else if (txtProblema.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Problema do Veículo do Cliente");
			txtProblema.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Valor do Serviço");
			txtValor.requestFocus();
		} else {
			String create = "insert into servicos (equipamento,defeito,valor,idcli) values (?,?,?,?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(create);
				pst.setString(1, txtVeiculo.getText());
				pst.setString(2, txtProblema.getText());
				pst.setString(3, txtValor.getText());
				pst.setString(4, txtID.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Serviço Registrado");
				Limpar();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private void Limpar() {
		txtID.setText(null);
		txtOS.setText(null);
		txtData.setText(null);
		txtVeiculo.setText(null);
		txtProblema.setText(null);
		txtValor.setText(null);
		txtCliente.setText(null);

	}

	private void Excluir() {
		int confirmar = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Serviço?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirmar == JOptionPane.YES_OPTION) {
			String delete = "delete from servicos where idcli=?";

			try {
				con = dao.conectar();
				pst = con.prepareStatement(delete);
				pst.setString(1, txtID.getText());
				pst.executeUpdate();
				Limpar();
				JOptionPane.showMessageDialog(null, "Serviço Excluído");
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Editar() {
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o OS do Cliente");
			txtOS.requestFocus();
		} else if (txtData.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Data do Serviço");
			txtData.requestFocus();
		} else if (txtVeiculo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Veículo do Cliente");
			txtVeiculo.requestFocus();
		} else if (txtProblema.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Problema do Veículo do Cliente");
			txtProblema.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Valor do Serviço");
			txtValor.requestFocus();
		} else {
			String update = "update servicos set os=?,dataOS=?,equipamento=?,defeito=?,valor=? where idcli=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(1, txtOS.getText());
				pst.setString(2, txtData.getText());
				pst.setString(3, txtVeiculo.getText());
				pst.setString(4, txtProblema.getText());
				pst.setString(5, txtValor.getText());
				pst.setString(6, txtID.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados do Serviço editados com sucesso!");
				Limpar();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	private void imprimirOS() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("os.pdf"));
			document.open();
			String readOS = "select * from servicos where os=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readOS);
				pst.setString(1, txtOS.getText());
				rs = pst.executeQuery();
				if (rs.next()) {
					document.add(new Paragraph("OS: " + rs.getString(1)));
					Paragraph os = new Paragraph("OS: " + rs.getString(1));
					os.setAlignment(Element.ALIGN_RIGHT);
					document.add(os);

					Paragraph veiculo = new Paragraph("Veículo: " + rs.getString(3));
					veiculo.setAlignment(Element.ALIGN_LEFT);
					document.add(veiculo);

					Paragraph problema = new Paragraph("Problema: " + rs.getString(4));
					problema.setAlignment(Element.ALIGN_LEFT);
					document.add(problema);

					Paragraph valor = new Paragraph("Valor R$: " + rs.getString(5));
					valor.setAlignment(Element.ALIGN_LEFT);
					document.add(valor);

					Paragraph dataOS = new Paragraph("DataOS: " + rs.getString(2));
					dataOS.setAlignment(Element.ALIGN_LEFT);
					document.add(dataOS);

					Image imagem = Image.getInstance(servicos.class.getResource("/img/range.jpg"));
					imagem.scaleToFit(500, 350);
					imagem.setAbsolutePosition(10, 330);
					document.add(imagem);
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("os.pdf"));
		} catch (Exception e) {
		}
	}
}
