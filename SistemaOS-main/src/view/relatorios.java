package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("unused")
public class relatorios extends JDialog {

	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private static final long serialVersionUID = 1L;
	private JButton btnServicos;
	private JButton btnFornecedores;
	private JButton btnClientes;
	private JPanel panel;
	private JLabel lblData;
	private JPanel panel_1;
	private JButton btnPatrimnio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatorios dialog = new relatorios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public relatorios() {
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
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setForeground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(relatorios.class.getResource("/img2/logo copiar.png")));
		setTitle("Relatórios");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		btnServicos = new JButton("");
		btnServicos.setIcon(new ImageIcon(relatorios.class.getResource("/img/pngegg (5).png")));
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioServicos();

			}
		});
		btnServicos.setContentAreaFilled(false);
		btnServicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos.setBorder(null);
		btnServicos.setToolTipText("Serviços");
		btnServicos.setBounds(414, 131, 136, 95);
		getContentPane().add(btnServicos);

		btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(relatorios.class.getResource("/img2/sss.png")));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setBorder(null);
		btnClientes.setToolTipText("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnClientes.setBounds(202, 131, 147, 94);
		getContentPane().add(btnClientes);

		panel = new JPanel();
		panel.setBounds(0, 527, 784, 34);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		lblData.setBounds(262, 0, 397, 34);
		panel.add(lblData);

		btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFornecedores();
			}
		});
		btnFornecedores.setIcon(new ImageIcon(relatorios.class.getResource("/img/pngwing.com (8).png")));
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setContentAreaFilled(false);
		btnFornecedores.setBorder(null);
		btnFornecedores.setBounds(414, 263, 136, 103);
		getContentPane().add(btnFornecedores);

		btnPatrimnio = new JButton("");
		btnPatrimnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioPatrimonio();
			}
		});
		btnPatrimnio.setIcon(new ImageIcon(relatorios.class.getResource("/img2/patr.png")));
		btnPatrimnio.setToolTipText("Patrimônio");
		btnPatrimnio.setContentAreaFilled(false);
		btnPatrimnio.setBorder(null);
		btnPatrimnio.setBounds(202, 263, 147, 103);
		getContentPane().add(btnPatrimnio);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(190, 226, 171, 27);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel_1.setBounds(47, 0, 97, 27);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(388, 226, 187, 27);
		getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Serviços");
		lblNewLabel_1_1.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(59, 0, 90, 27);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(190, 366, 171, 27);
		getContentPane().add(panel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Patrimônio");
		lblNewLabel_1_1_1.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(35, 0, 105, 27);
		panel_1_2.add(lblNewLabel_1_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(388, 366, 187, 27);
		getContentPane().add(panel_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fornecedores");
		lblNewLabel_1_1_1_1.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(30, 0, 157, 27);
		panel_1_3.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(relatorios.class.getResource("/img2/inicio2.png")));
		lblNewLabel.setBounds(0, 0, 784, 550);
		getContentPane().add(lblNewLabel);
	}

	private void relatorioClientes() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Clientes:"));
			document.add(new Paragraph(" "));
			String readClientes = "select nome,fone from clientes order by nome";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readClientes);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(2);
				PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
				}
				document.add(tabela);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void relatorioServicos() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("servicos.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Servicos:"));
			document.add(new Paragraph(" "));
			String readServicos = "select servicos.os,servicos.dataOS,servicos.equipamento,servicos.defeito,servicos.valor,clientes.nome from servicos inner join clientes on servicos.idcli = clientes.idcli order by os;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readServicos);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(5);
				PdfPCell col1 = new PdfPCell(new Paragraph("dataOS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Veiculo"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Problema"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Valor"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Nome"));

				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);

				while (rs.next()) {
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));

				}
				document.add(tabela);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("servicos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void relatorioFornecedores() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("servicos.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Fornecedores:"));
			document.add(new Paragraph(" "));
			String readServicos = "select razao,fantasia,cnpj,fone,email from fornecedores order by razao";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readServicos);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(5);
				PdfPCell col1 = new PdfPCell(new Paragraph("Razão"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fantasia"));
				PdfPCell col3 = new PdfPCell(new Paragraph("CNPJ"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Email"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));

				}
				document.add(tabela);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("servicos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void relatorioPatrimonio() {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("patrimonio.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Estoque:"));
			document.add(new Paragraph(" "));
			String readClientes = "select codigo as código, produto, date_format(dataval, '%d/%m/%Y') as validade, estoque, estoquemin as estóque_mínimo from produtos where estoque < estoquemin;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readClientes);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(5);
				PdfPCell col1 = new PdfPCell(new Paragraph("código: "));
				PdfPCell col2 = new PdfPCell(new Paragraph("produto: "));
				PdfPCell col3 = new PdfPCell(new Paragraph("validade: "));
				PdfPCell col4 = new PdfPCell(new Paragraph("estoque: "));
				PdfPCell col5 = new PdfPCell(new Paragraph("estoque mínimo: "));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}
				document.add(tabela);
				document.add(new Paragraph("Validade:"));
				document.add(new Paragraph(" "));
				String read = "select codigo as código, produto, date_format(dataval, '%d/%m/%Y') as validade from produtos where dataval < dataent";
				pst = con.prepareStatement(read);
				rs = pst.executeQuery();
				PdfPTable tabela2 = new PdfPTable(3);
				PdfPCell col6 = new PdfPCell(new Paragraph("código: "));
				PdfPCell col7 = new PdfPCell(new Paragraph("produto: "));
				PdfPCell col8 = new PdfPCell(new Paragraph("validade: "));
				tabela2.addCell(col6);
				tabela2.addCell(col7);
				tabela2.addCell(col8);
				while (rs.next()) {
					tabela2.addCell(rs.getString(1));
					tabela2.addCell(rs.getString(2));
					tabela2.addCell(rs.getString(3));
				}
				document.add(tabela2);
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Patrimônio (Custo):"));
				document.add(new Paragraph(" "));
				String read2 = "select sum(custo * estoque) as Total from produtos";
				pst = con.prepareStatement(read2);
				rs = pst.executeQuery();
				PdfPTable tabela3 = new PdfPTable(1);
				PdfPCell col12 = new PdfPCell(new Paragraph("Patrimônio custo: "));
				tabela3.addCell(col12);
				while (rs.next()) {
					tabela3.addCell(rs.getString(1));
				}
				document.add(tabela3);
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Patrimônio (venda):"));
				document.add(new Paragraph(" "));
				String readVenda = "select sum((custo + (custo * lucro)/100) * estoque) as total from produtos";
				pst = con.prepareStatement(readVenda);
				rs = pst.executeQuery();
				PdfPTable tabela4 = new PdfPTable(1);
				PdfPCell col43 = new PdfPCell(new Paragraph("Patrimônio venda: "));
				tabela4.addCell(col43);
				while (rs.next()) {
					tabela4.addCell(rs.getString(1));
				}
				document.add(tabela4);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("patrimonio.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}