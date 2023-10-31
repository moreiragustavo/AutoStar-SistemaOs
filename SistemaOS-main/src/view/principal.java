package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import java.awt.Font;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	@SuppressWarnings("unused")
	private Connection con;

	private JPanel contentPane;
	private JLabel lblData;
	private JButton lblStatus;
	public JLabel lblUsuario;
	public JButton btnUsuarios;
	public JButton btnRelatorios;
	public JPanel panelRodape;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_3;
	private JLabel lblNewLabel_5;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JPanel panel_4;
	private JLabel lblNewLabel_6;
	private JPanel panel_5;
	private JLabel lblNewLabel_7;
	private JButton btnProdutos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public principal() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setarData();
			}
		});
		setTitle("Sistema da Mecânica AutoStar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(principal.class.getResource("/img2/testelogoempresa.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelRodape = new JPanel();
		panelRodape.setBackground(new Color(255, 255, 255));
		panelRodape.setBounds(0, 507, 784, 54);
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);

		lblData = new JLabel("");
		lblData.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblData.setBounds(262, 11, 505, 32);
		panelRodape.add(lblData);
		lblData.setForeground(new Color(0, 0, 0));
		lblData.setBackground(new Color(255, 255, 255));

		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(62, 20, 69, 14);
		panelRodape.add(lblNewLabel_1);

		lblUsuario = new JLabel("");
		lblUsuario.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblUsuario.setBackground(new Color(0, 0, 0));
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setBounds(125, 20, 134, 14);
		panelRodape.add(lblUsuario);
		
				lblStatus = new JButton("");
				lblStatus.setBounds(725, 0, 49, 54);
				panelRodape.add(lblStatus);
				lblStatus.setToolTipText("Status");
				lblStatus.setContentAreaFilled(false);
				lblStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblStatus.setBorder(null);
				lblStatus.setIcon(new ImageIcon(principal.class.getResource("/img/dbon.png")));

		btnRelatorios = new JButton("");
		btnRelatorios.setIcon(new ImageIcon(principal.class.getResource("/img2/pngegg (4).png")));
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorios Relatorios = new relatorios();
				Relatorios.setVisible(true);
			}
		});
		btnRelatorios.setBorder(null);
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setToolTipText("Relatórios");
		btnRelatorios.setBounds(157, 258, 105, 96);
		contentPane.add(btnRelatorios);

		JButton btnServicos = new JButton("");
		btnServicos.setIcon(new ImageIcon(principal.class.getResource("/img2/pngegg (5).png")));
		btnServicos.setBackground(new Color(255, 255, 255));
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicos Servicos = new servicos();
				Servicos.setVisible(true);
			}
		});
		btnServicos.setContentAreaFilled(false);
		btnServicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos.setToolTipText("Serviços");
		btnServicos.setBorder(null);
		btnServicos.setBounds(342, 258, 97, 96);
		contentPane.add(btnServicos);

		JButton btnFornecedor = new JButton("");
		btnFornecedor.setIcon(new ImageIcon(principal.class.getResource("/img2/pngwing.com (8).png")));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fornecedores Fornecedor = new fornecedores();
				Fornecedor.setVisible(true);
			}
		});
		btnFornecedor.setToolTipText("Fornecedores");
		btnFornecedor.setContentAreaFilled(false);
		btnFornecedor.setBorder(null);
		btnFornecedor.setBounds(498, 98, 141, 116);
		contentPane.add(btnFornecedor);

		JButton btnSobre = new JButton("");
		btnSobre.setBounds(707, 0, 77, 80);
		contentPane.add(btnSobre);
		btnSobre.setIcon(new ImageIcon(principal.class.getResource("/img2/pngwing.com.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorder(null);
		btnSobre.setToolTipText("Informações");

		JButton btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(principal.class.getResource("/img2/sss.png")));
		btnClientes.setBounds(129, 113, 150, 101);
		contentPane.add(btnClientes);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes Clientes = new clientes();
				Clientes.setVisible(true);
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorder(null);
		btnClientes.setToolTipText("Cliente");

		btnUsuarios = new JButton("");
		btnUsuarios.setBounds(342, 113, 97, 96);
		contentPane.add(btnUsuarios);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioos Usuarioos = new usuarioos();
				Usuarioos.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usuarios");
		btnUsuarios.setBorder(null);
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(principal.class.getResource("/img2/usuarios.png")));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(129, 209, 150, 28);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Clientes");
		lblNewLabel_2.setBounds(41, 0, 109, 28);
		lblNewLabel_2.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		panel.add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(314, 209, 150, 28);
		contentPane.add(panel_1);
		
		lblNewLabel_3 = new JLabel("Usuários");
		lblNewLabel_3.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(41, 0, 109, 28);
		panel_1.add(lblNewLabel_3);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(498, 209, 150, 28);
		contentPane.add(panel_3);
		
		lblNewLabel_5 = new JLabel("Fornecedores");
		lblNewLabel_5.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		lblNewLabel_5.setBounds(20, 0, 130, 28);
		panel_3.add(lblNewLabel_5);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(129, 356, 150, 28);
		contentPane.add(panel_2);
		
		lblNewLabel_4 = new JLabel("Relatórios");
		lblNewLabel_4.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(33, 0, 117, 28);
		panel_2.add(lblNewLabel_4);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(314, 356, 150, 28);
		contentPane.add(panel_4);
		
		lblNewLabel_6 = new JLabel("Serviços");
		lblNewLabel_6.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		lblNewLabel_6.setBounds(41, 0, 109, 28);
		panel_4.add(lblNewLabel_6);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(498, 356, 150, 28);
		contentPane.add(panel_5);
		
		lblNewLabel_7 = new JLabel("Produtos");
		lblNewLabel_7.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(36, 0, 114, 28);
		panel_5.add(lblNewLabel_7);
		
		btnProdutos = new JButton("");
		btnProdutos.setIcon(new ImageIcon(principal.class.getResource("/img2/produtos3.png")));
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtos Produtos = new produtos();
				Produtos.setVisible(true);				
			}
		});
		btnProdutos.setToolTipText("Serviços");
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBorder(null);
		btnProdutos.setBackground(Color.WHITE);
		btnProdutos.setBounds(521, 253, 105, 101);
		contentPane.add(btnProdutos);
		
		JButton btnServicos_1 = new JButton("");
		btnServicos_1.setToolTipText("Serviços");
		btnServicos_1.setContentAreaFilled(false);
		btnServicos_1.setBorder(null);
		btnServicos_1.setBackground(Color.WHITE);
		btnServicos_1.setBounds(529, 258, 97, 96);
		contentPane.add(btnServicos_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(principal.class.getResource("/img2/inicio2.png")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		contentPane.add(lblNewLabel);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sobre Sobre = new sobre();
				Sobre.setVisible(true);
			}
		});

	}

	private void setarData() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
}