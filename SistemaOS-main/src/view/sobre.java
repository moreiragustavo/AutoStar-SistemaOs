package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class sobre extends JDialog {

	private static final long serialVersionUID = -5512666712820487201L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnGitHub;
	private JButton btnGitHub_1;
	private JButton btnGitHub_2;
	private JButton btnGitHub_2_1;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		try {
			sobre dialog = new sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public sobre() {
		setResizable(false);
		setTitle("Sistema da Mecânica CarMech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(sobre.class.getResource("/img2/logodaempresa.png")));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Mecânica AutoStar\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNewLabel.setBounds(306, 129, 185, 30);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(sobre.class.getResource("/img2/logodaempresa.png")));
		lblNewLabel_5.setBounds(324, 24, 136, 103);
		contentPanel.add(lblNewLabel_5);

		btnGitHub = new JButton("");
		btnGitHub.setContentAreaFilled(false);
		btnGitHub.setBorderPainted(false);
		btnGitHub.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				link("https://github.com/moreiragustavo?tab=repositories");
			}
		});
		btnGitHub.setIcon(new ImageIcon(sobre.class.getResource("/img2/github.png")));
		btnGitHub.setBorder(null);
		btnGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGitHub.setBounds(491, 217, 42, 46);
		contentPanel.add(btnGitHub);
		
		JLabel lblVerso = new JLabel("Versão: ");
		lblVerso.setForeground(Color.WHITE);
		lblVerso.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblVerso.setBounds(71, 170, 260, 36);
		contentPanel.add(lblVerso);
		
		JLabel lblBeta = new JLabel("Beta");
		lblBeta.setForeground(new Color(255, 255, 128));
		lblBeta.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblBeta.setBounds(152, 171, 260, 35);
		contentPanel.add(lblBeta);
		
		JLabel lblSobreOProjeto = new JLabel("Sobre o Projeto");
		lblSobreOProjeto.setForeground(Color.WHITE);
		lblSobreOProjeto.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblSobreOProjeto.setBounds(71, 217, 248, 35);
		contentPanel.add(lblSobreOProjeto);
		
		JLabel lblBeta_1 = new JLabel("Desenvolvedores");
		lblBeta_1.setForeground(new Color(255, 255, 128));
		lblBeta_1.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblBeta_1.setBounds(526, 160, 248, 46);
		contentPanel.add(lblBeta_1);
		
		JLabel lblGustavoCavalcante = new JLabel("Gustavo Cavalcante");
		lblGustavoCavalcante.setForeground(Color.WHITE);
		lblGustavoCavalcante.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblGustavoCavalcante.setBounds(536, 217, 250, 46);
		contentPanel.add(lblGustavoCavalcante);
		
		btnGitHub_1 = new JButton("");
		btnGitHub_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/joaovitorp05?tab=repositories");
			}
		});
		btnGitHub_1.setIcon(new ImageIcon(sobre.class.getResource("/img2/github.png")));
		btnGitHub_1.setContentAreaFilled(false);
		btnGitHub_1.setBorderPainted(false);
		btnGitHub_1.setBorder(null);
		btnGitHub_1.setBounds(491, 274, 42, 46);
		contentPanel.add(btnGitHub_1);
		
		JLabel lblJooVitor = new JLabel("João Vitor");
		lblJooVitor.setForeground(Color.WHITE);
		lblJooVitor.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblJooVitor.setBounds(536, 274, 250, 46);
		contentPanel.add(lblJooVitor);
		
		btnGitHub_2 = new JButton("");
		btnGitHub_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/RyaanVictor?tab=repositories");
			}
		});
		btnGitHub_2.setIcon(new ImageIcon(sobre.class.getResource("/img2/github.png")));
		btnGitHub_2.setContentAreaFilled(false);
		btnGitHub_2.setBorderPainted(false);
		btnGitHub_2.setBorder(null);
		btnGitHub_2.setBounds(491, 388, 42, 46);
		contentPanel.add(btnGitHub_2);
		
		JLabel lblRyanVictor = new JLabel("Ryan Victor");
		lblRyanVictor.setForeground(Color.WHITE);
		lblRyanVictor.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblRyanVictor.setBounds(536, 388, 250, 46);
		contentPanel.add(lblRyanVictor);
		
		JLabel lblNicolasMartins = new JLabel("Nicolas Martins");
		lblNicolasMartins.setForeground(Color.WHITE);
		lblNicolasMartins.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblNicolasMartins.setBounds(536, 331, 250, 46);
		contentPanel.add(lblNicolasMartins);
		
		btnGitHub_2_1 = new JButton("");
		btnGitHub_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/nicolasmartins2907?tab=repositories");
			}
		});
		btnGitHub_2_1.setIcon(new ImageIcon(sobre.class.getResource("/img2/github.png")));
		btnGitHub_2_1.setContentAreaFilled(false);
		btnGitHub_2_1.setBorderPainted(false);
		btnGitHub_2_1.setBorder(null);
		btnGitHub_2_1.setBounds(491, 331, 42, 46);
		contentPanel.add(btnGitHub_2_1);
		
		JLabel lblProjetoCriadoPara = new JLabel("Projeto criado para administrar\r\n\r\n");
		lblProjetoCriadoPara.setForeground(new Color(255, 255, 128));
		lblProjetoCriadoPara.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblProjetoCriadoPara.setBounds(71, 248, 308, 46);
		contentPanel.add(lblProjetoCriadoPara);
		
		JLabel lblOSistemaDe = new JLabel("\r\no sistema de uma mecânica \r\npor ");
		lblOSistemaDe.setForeground(new Color(255, 255, 128));
		lblOSistemaDe.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblOSistemaDe.setBounds(71, 274, 308, 30);
		contentPanel.add(lblOSistemaDe);
		
		JLabel lblCompletoUsandoBanco = new JLabel("completo, usando banco de dados\r\n\r\n");
		lblCompletoUsandoBanco.setForeground(new Color(255, 255, 128));
		lblCompletoUsandoBanco.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblCompletoUsandoBanco.setBounds(71, 292, 341, 36);
		contentPanel.add(lblCompletoUsandoBanco);
		
		JLabel lblParaGerenciarTodas = new JLabel("para gerenciar todas as informações\r\n\r\n\r\n");
		lblParaGerenciarTodas.setForeground(new Color(255, 255, 128));
		lblParaGerenciarTodas.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblParaGerenciarTodas.setBounds(71, 315, 360, 36);
		contentPanel.add(lblParaGerenciarTodas);
		
		JLabel lblEDadosDa = new JLabel("e dados da Mecânica.");
		lblEDadosDa.setForeground(new Color(255, 255, 128));
		lblEDadosDa.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		lblEDadosDa.setBounds(71, 341, 360, 36);
		contentPanel.add(lblEDadosDa);
		{
			lblNewLabel_1 = new JLabel("\r\n");
			lblNewLabel_1.setIcon(new ImageIcon(sobre.class.getResource("/img2/inicio2.png")));
			lblNewLabel_1.setBounds(0, 0, 784, 560);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(312, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(364, 5, 65, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}

	}

	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
