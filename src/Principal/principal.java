package Principal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.Mesa;
import DTO.Plato;
/*caca git*/
public class principal extends JFrame {
//caca beto
	private JPanel contentPane;
	private JTextField txtVisor;
	private JPanel panel_1;
	private JTextField txtVisorAux;
	private JTable tableResumen;
	int ultimoEsMenos = 0;
	int ultimoEsPlu = 0;
	int vecesPlu = 0;
	int noPermitirPlu = 0;
	int vacio = 0;
	int mesa = 0;
	int mesaAbierta = 0;
	DefaultTableModel modelo = new DefaultTableModel();
	private JTextField txtVisorCantidad;
	private JTextField txtVisorPrecio;
	private JTextField txtMesa;
	int cantidad = 0;
	String nombrePlato = "";
	double precioPlato = 0;
	int numPlato = 0;
	public Mesa mesaTemp = null;
	ArrayList<Plato> platos = new ArrayList<Plato>();
	ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
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
	/**
	 * Create the frame.
	 */
	public principal() {
		cargarMemoriaPlatos();
		cargarMemoriaMesas();
		// cargar memoria de platos
		for (int i = 1; i <= 10; i++) {
			platos.add(new Plato(i, "" + i, "Plato" + i, i));
		}

		// cargar en memoria las mesas
		for (int i = 0; i <= 40; i++) {
			DefaultTableModel modeloVacio = new DefaultTableModel();
			modeloVacio.addColumn("#");
			modeloVacio.addColumn("Cantidad");
			modeloVacio.addColumn("Plato");
			modeloVacio.addColumn("Importe");

			JTable tableResumenVacio = new JTable(modeloVacio);
			tableResumenVacio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableResumenVacio.getColumnModel().getColumn(0)
					.setPreferredWidth(40);
			tableResumenVacio.getColumnModel().getColumn(1)
					.setPreferredWidth(60);
			tableResumenVacio.getColumnModel().getColumn(2)
					.setPreferredWidth(249);
			tableResumenVacio.getColumnModel().getColumn(3)
					.setPreferredWidth(50);

			mesas.add(new Mesa(i, 0, modeloVacio, tableResumenVacio));
		}

		setTitle("TPV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();

		txtVisorAux = new JTextField();
		txtVisorAux.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVisorAux.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtVisorAux.setEditable(false);
		txtVisorAux.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2
				.createParallelGroup(Alignment.LEADING)
				.addGap(0, 422, Short.MAX_VALUE)
				.addGroup(
						gl_panel_2
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(txtVisorAux,
										GroupLayout.DEFAULT_SIZE, 316,
										Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2
				.createParallelGroup(Alignment.LEADING)
				.addGap(0, 89, Short.MAX_VALUE)
				.addGroup(
						gl_panel_2
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(txtVisorAux,
										GroupLayout.DEFAULT_SIZE, 67,
										Short.MAX_VALUE).addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();

		txtMesa = new JTextField();
		txtMesa.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMesa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMesa.setEditable(false);
		txtMesa.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3
				.createParallelGroup(Alignment.LEADING)
				.addGap(0, 482, Short.MAX_VALUE)
				.addGroup(
						gl_panel_3
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(txtMesa,
										GroupLayout.DEFAULT_SIZE, 462,
										Short.MAX_VALUE).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3
				.createParallelGroup(Alignment.LEADING)
				.addGap(0, 89, Short.MAX_VALUE)
				.addGroup(
						gl_panel_3
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(txtMesa,
										GroupLayout.DEFAULT_SIZE, 67,
										Short.MAX_VALUE).addContainerGap()));
		panel_3.setLayout(gl_panel_3);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addComponent(
																				panel_1,
																				Alignment.TRAILING,
																				0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				panel_2,
																				Alignment.TRAILING,
																				GroupLayout.DEFAULT_SIZE,
																				482,
																				Short.MAX_VALUE))
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 36,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING,
																false)
														.addComponent(panel_3,
																0, 0,
																Short.MAX_VALUE)
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																402,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(24)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel_1,
																GroupLayout.PREFERRED_SIZE,
																89,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																panel_3,
																GroupLayout.PREFERRED_SIZE,
																89,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																479,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				panel_2,
																				GroupLayout.PREFERRED_SIZE,
																				89,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				panel,
																				GroupLayout.PREFERRED_SIZE,
																				372,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(12, Short.MAX_VALUE)));

		JTextPane textTitulo = new JTextPane();
		scrollPane.setColumnHeaderView(textTitulo);

		txtVisor = new JTextField();
		txtVisor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtVisor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVisor.setEditable(false);
		txtVisor.setColumns(10);

		txtVisorCantidad = new JTextField();
		txtVisorCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVisorCantidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtVisorCantidad.setEditable(false);
		txtVisorCantidad.setColumns(10);

		txtVisorPrecio = new JTextField();
		txtVisorPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVisorPrecio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtVisorPrecio.setEditable(false);
		txtVisorPrecio.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtVisorCantidad,
								GroupLayout.PREFERRED_SIZE, 85,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtVisorPrecio, GroupLayout.DEFAULT_SIZE,
								168, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtVisor, GroupLayout.PREFERRED_SIZE,
								189, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																txtVisor,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																67,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.LEADING,
																gl_panel_1
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				txtVisorCantidad,
																				GroupLayout.PREFERRED_SIZE,
																				67,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				txtVisorPrecio,
																				GroupLayout.PREFERRED_SIZE,
																				67,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 70, 70, 70, 70, 70, 70, 70 };
		gbl_panel.rowHeights = new int[] { 70, 70, 70, 70, 70 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, };
		panel.setLayout(gbl_panel);

		JButton buttonHash = new JButton("#");
		buttonHash.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_buttonHash = new GridBagConstraints();
		gbc_buttonHash.fill = GridBagConstraints.BOTH;
		gbc_buttonHash.insets = new Insets(0, 0, 5, 5);
		gbc_buttonHash.gridx = 0;
		gbc_buttonHash.gridy = 0;
		panel.add(buttonHash, gbc_buttonHash);

		JButton buttonR = new JButton(
				"<html><body>R</center><br>FEED</body></html>");
		buttonR.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_buttonR = new GridBagConstraints();
		gbc_buttonR.fill = GridBagConstraints.BOTH;
		gbc_buttonR.insets = new Insets(0, 0, 5, 5);
		gbc_buttonR.gridx = 1;
		gbc_buttonR.gridy = 0;
		panel.add(buttonR, gbc_buttonR);

		JButton buttonA = new JButton("<html><body>A<br>FEED</body></html>");
		buttonA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_buttonA = new GridBagConstraints();
		gbc_buttonA.fill = GridBagConstraints.BOTH;
		gbc_buttonA.insets = new Insets(0, 0, 5, 5);
		gbc_buttonA.gridx = 2;
		gbc_buttonA.gridy = 0;
		panel.add(buttonA, gbc_buttonA);

		JButton buttonAMT = new JButton("AMT");
		buttonAMT.setMargin(new Insets(2, 0, 2, 0));
		buttonAMT.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_buttonAMT = new GridBagConstraints();
		gbc_buttonAMT.fill = GridBagConstraints.BOTH;
		gbc_buttonAMT.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAMT.gridx = 3;
		gbc_buttonAMT.gridy = 0;
		panel.add(buttonAMT, gbc_buttonAMT);

		JButton buttonPLU = new JButton("PLU");

		buttonPLU.setMargin(new Insets(2, 10, 2, 10));
		buttonPLU.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_buttonPLU = new GridBagConstraints();
		gbc_buttonPLU.fill = GridBagConstraints.BOTH;
		gbc_buttonPLU.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPLU.gridx = 4;
		gbc_buttonPLU.gridy = 0;
		panel.add(buttonPLU, gbc_buttonPLU);

		JButton buttonSaldo = new JButton(
				"<html><body>SALDO<br>PDTE</body></html>");
		buttonSaldo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_buttonSaldo = new GridBagConstraints();
		gbc_buttonSaldo.fill = GridBagConstraints.BOTH;
		gbc_buttonSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSaldo.gridx = 5;
		gbc_buttonSaldo.gridy = 0;
		panel.add(buttonSaldo, gbc_buttonSaldo);

		JButton buttonAbrir = new JButton(
				"<html><body>ABRIR<br>MESA</body></html>");
		buttonAbrir.setMargin(new Insets(2, 0, 2, 0));
		buttonAbrir.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_buttonAbrir = new GridBagConstraints();
		gbc_buttonAbrir.fill = GridBagConstraints.BOTH;
		gbc_buttonAbrir.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAbrir.gridx = 6;
		gbc_buttonAbrir.gridy = 0;
		panel.add(buttonAbrir, gbc_buttonAbrir);

		JButton buttonMenos = new JButton("-");
		buttonMenos.setMargin(new Insets(0, 14, 0, 14));
		buttonMenos.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_buttonMenos = new GridBagConstraints();
		gbc_buttonMenos.fill = GridBagConstraints.BOTH;
		gbc_buttonMenos.insets = new Insets(0, 0, 5, 5);
		gbc_buttonMenos.gridx = 0;
		gbc_buttonMenos.gridy = 1;
		panel.add(buttonMenos, gbc_buttonMenos);

		JButton button7 = new JButton("7");
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.fill = GridBagConstraints.BOTH;
		gbc_button7.insets = new Insets(0, 0, 5, 5);
		gbc_button7.gridx = 1;
		gbc_button7.gridy = 1;
		panel.add(button7, gbc_button7);
		button7.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button8 = new JButton("8");
		GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.fill = GridBagConstraints.BOTH;
		gbc_button8.insets = new Insets(0, 0, 5, 5);
		gbc_button8.gridx = 2;
		gbc_button8.gridy = 1;
		panel.add(button8, gbc_button8);
		button8.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button9 = new JButton("9");
		GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.fill = GridBagConstraints.BOTH;
		gbc_button9.insets = new Insets(0, 0, 5, 5);
		gbc_button9.gridx = 3;
		gbc_button9.gridy = 1;
		panel.add(button9, gbc_button9);
		button9.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton buttonVarios = new JButton("VARIOS");
		buttonVarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_buttonVarios = new GridBagConstraints();
		gbc_buttonVarios.fill = GridBagConstraints.BOTH;
		gbc_buttonVarios.insets = new Insets(0, 0, 5, 5);
		gbc_buttonVarios.gridx = 4;
		gbc_buttonVarios.gridy = 1;
		panel.add(buttonVarios, gbc_buttonVarios);

		JButton buttonPO = new JButton("PO");
		buttonPO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_buttonPO = new GridBagConstraints();
		gbc_buttonPO.fill = GridBagConstraints.BOTH;
		gbc_buttonPO.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPO.gridx = 5;
		gbc_buttonPO.gridy = 1;
		panel.add(buttonPO, gbc_buttonPO);

		JButton buttonDejar = new JButton(
				"<html><body>DEJAR<br>ABIERTA<br>MESA</body></html>");
		buttonDejar.setMargin(new Insets(2, 0, 2, 0));
		buttonDejar.setFont(new Font("Tahoma", Font.BOLD, 9));
		GridBagConstraints gbc_buttonDejar = new GridBagConstraints();
		gbc_buttonDejar.fill = GridBagConstraints.BOTH;
		gbc_buttonDejar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonDejar.gridx = 6;
		gbc_buttonDejar.gridy = 1;
		panel.add(buttonDejar, gbc_buttonDejar);

		JButton buttonVOID = new JButton("VOID");
		buttonVOID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_buttonVOID = new GridBagConstraints();
		gbc_buttonVOID.fill = GridBagConstraints.BOTH;
		gbc_buttonVOID.insets = new Insets(0, 0, 5, 5);
		gbc_buttonVOID.gridx = 0;
		gbc_buttonVOID.gridy = 2;
		panel.add(buttonVOID, gbc_buttonVOID);

		JButton button4 = new JButton("4");
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.insets = new Insets(0, 0, 5, 5);
		gbc_button4.gridx = 1;
		gbc_button4.gridy = 2;
		panel.add(button4, gbc_button4);
		button4.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button5 = new JButton("5");
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.insets = new Insets(0, 0, 5, 5);
		gbc_button5.gridx = 2;
		gbc_button5.gridy = 2;
		panel.add(button5, gbc_button5);
		button5.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button6 = new JButton("6");
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.fill = GridBagConstraints.BOTH;
		gbc_button6.insets = new Insets(0, 0, 5, 5);
		gbc_button6.gridx = 3;
		gbc_button6.gridy = 2;
		panel.add(button6, gbc_button6);
		button6.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton buttonTabaco = new JButton("TABACO");
		buttonTabaco.setMargin(new Insets(2, 0, 2, 0));
		buttonTabaco.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_buttonTabaco = new GridBagConstraints();
		gbc_buttonTabaco.fill = GridBagConstraints.BOTH;
		gbc_buttonTabaco.insets = new Insets(0, 0, 5, 5);
		gbc_buttonTabaco.gridx = 4;
		gbc_buttonTabaco.gridy = 2;
		panel.add(buttonTabaco, gbc_buttonTabaco);

		JButton buttonCH = new JButton("CH");
		buttonCH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_buttonCH = new GridBagConstraints();
		gbc_buttonCH.fill = GridBagConstraints.BOTH;
		gbc_buttonCH.insets = new Insets(0, 0, 5, 5);
		gbc_buttonCH.gridx = 5;
		gbc_buttonCH.gridy = 2;
		panel.add(buttonCH, gbc_buttonCH);

		JButton buttonFactura = new JButton("FACTU");
		buttonFactura.setMargin(new Insets(2, 5, 2, 5));
		buttonFactura.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_buttonFactura = new GridBagConstraints();
		gbc_buttonFactura.fill = GridBagConstraints.BOTH;
		gbc_buttonFactura.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFactura.gridx = 6;
		gbc_buttonFactura.gridy = 2;
		panel.add(buttonFactura, gbc_buttonFactura);

		JButton buttonX = new JButton("X");
		buttonX.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_buttonX = new GridBagConstraints();
		gbc_buttonX.fill = GridBagConstraints.BOTH;
		gbc_buttonX.insets = new Insets(0, 0, 5, 5);
		gbc_buttonX.gridx = 0;
		gbc_buttonX.gridy = 3;
		panel.add(buttonX, gbc_buttonX);

		JButton button1 = new JButton("1");
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 1;
		gbc_button1.gridy = 3;
		panel.add(button1, gbc_button1);
		button1.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button2 = new JButton("2");
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 2;
		gbc_button2.gridy = 3;
		panel.add(button2, gbc_button2);
		button2.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button3 = new JButton("3");
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.insets = new Insets(0, 0, 5, 5);
		gbc_button3.gridx = 3;
		gbc_button3.gridy = 3;
		panel.add(button3, gbc_button3);
		button3.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton buttonTFN = new JButton("TLFN");
		buttonTFN.setMargin(new Insets(2, 5, 2, 5));
		buttonTFN.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_buttonTFN = new GridBagConstraints();
		gbc_buttonTFN.fill = GridBagConstraints.BOTH;
		gbc_buttonTFN.insets = new Insets(0, 0, 5, 5);
		gbc_buttonTFN.gridx = 4;
		gbc_buttonTFN.gridy = 3;
		panel.add(buttonTFN, gbc_buttonTFN);

		JButton buttonST = new JButton("S    T");
		buttonST.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_buttonST = new GridBagConstraints();
		gbc_buttonST.fill = GridBagConstraints.BOTH;
		gbc_buttonST.gridwidth = 2;
		gbc_buttonST.insets = new Insets(0, 0, 5, 5);
		gbc_buttonST.gridx = 5;
		gbc_buttonST.gridy = 3;
		panel.add(buttonST, gbc_buttonST);

		JButton buttonC = new JButton("C");
		buttonC.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_buttonC = new GridBagConstraints();
		gbc_buttonC.fill = GridBagConstraints.BOTH;
		gbc_buttonC.insets = new Insets(0, 0, 5, 5);
		gbc_buttonC.gridx = 0;
		gbc_buttonC.gridy = 4;
		panel.add(buttonC, gbc_buttonC);

		JButton button0 = new JButton("0");

		GridBagConstraints gbc_button0 = new GridBagConstraints();
		gbc_button0.fill = GridBagConstraints.BOTH;
		gbc_button0.insets = new Insets(0, 0, 5, 5);
		gbc_button0.gridx = 1;
		gbc_button0.gridy = 4;
		panel.add(button0, gbc_button0);
		button0.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton button00 = new JButton("00");
		button00.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_button00 = new GridBagConstraints();
		gbc_button00.fill = GridBagConstraints.BOTH;
		gbc_button00.insets = new Insets(0, 0, 5, 5);
		gbc_button00.gridx = 2;
		gbc_button00.gridy = 4;
		panel.add(button00, gbc_button00);

		JButton buttonPunto = new JButton(".");
		GridBagConstraints gbc_buttonPunto = new GridBagConstraints();
		gbc_buttonPunto.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPunto.fill = GridBagConstraints.BOTH;
		gbc_buttonPunto.gridx = 3;
		gbc_buttonPunto.gridy = 4;
		panel.add(buttonPunto, gbc_buttonPunto);
		buttonPunto.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton buttonVacio = new JButton("");
		buttonVacio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_buttonVacio = new GridBagConstraints();
		gbc_buttonVacio.fill = GridBagConstraints.BOTH;
		gbc_buttonVacio.insets = new Insets(0, 0, 5, 5);
		gbc_buttonVacio.gridx = 4;
		gbc_buttonVacio.gridy = 4;
		panel.add(buttonVacio, gbc_buttonVacio);

		JButton buttonAT = new JButton("AT  /  CT");
		buttonAT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_buttonAT = new GridBagConstraints();
		gbc_buttonAT.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAT.fill = GridBagConstraints.BOTH;
		gbc_buttonAT.gridwidth = 2;
		gbc_buttonAT.gridx = 5;
		gbc_buttonAT.gridy = 4;
		panel.add(buttonAT, gbc_buttonAT);

		// Ã�rea declaraciÃ³n de listeners
		buttonMenos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionMenos();
			}
		});

		buttonC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtVisor.setText("");
			}
		});

		buttonAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionAbrir();
			}
		});

		buttonDejar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionDejar();
			}
		});

		buttonPunto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtVisor.setText(txtVisor.getText() + ".");
			}
		});

		buttonST.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionST();
			}
		});

		buttonX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtVisor.setText(txtVisor.getText() + "x");
			}
		});

		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "0");
			}
		});

		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "1");
			}
		});

		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "2");
			}
		});

		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "3");
			}
		});

		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "4");
			}
		});
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "5");
			}
		});

		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "6");
			}
		});

		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "7");
			}
		});
		button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "8");
			}
		});
		button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accionesComunBotones();
				txtVisor.setText(txtVisor.getText() + "9");
			}
		});

		buttonPLU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionPLU();
			}
		});

		buttonAMT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionAMT();
			}
		});

		contentPane.setLayout(gl_contentPane);
	}

	// funciones auxiliares
	public void cargarMemoriaPlatos() {
		// cargar memoria de platos
		for (int i = 1; i <= 10; i++) {
			platos.add(new Plato(i, "" + i, "Plato" + i, i));
		}
	}
	
	public void cargarMemoriaMesas() {
		// cargar en memoria las mesas
		for (int i = 0; i <= 40; i++) {
			DefaultTableModel modeloVacio = new DefaultTableModel();
			modeloVacio.addColumn("#");
			modeloVacio.addColumn("Cantidad");
			modeloVacio.addColumn("Plato");
			modeloVacio.addColumn("Importe");

			JTable tableResumenVacio = new JTable(modeloVacio);
			tableResumenVacio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableResumenVacio.getColumnModel().getColumn(0)
					.setPreferredWidth(40);
			tableResumenVacio.getColumnModel().getColumn(1)
					.setPreferredWidth(60);
			tableResumenVacio.getColumnModel().getColumn(2)
					.setPreferredWidth(249);
			tableResumenVacio.getColumnModel().getColumn(3)
					.setPreferredWidth(50);

			mesas.add(new Mesa(i, 0, modeloVacio, tableResumenVacio));
		}
	}

	public void comprobarExisteEnLista() {
		int encontrado = 0;

		for (int i = 0; i < modelo.getRowCount() && encontrado == 0; i++) {
			Object valor = modelo.getValueAt(i, 0);

			if (Integer.parseInt(valor.toString()) == (numPlato)) {
				double parcial = (double) modelo.getValueAt(i, 3)
						+ (precioPlato * cantidad);
				modelo.setValueAt((int) modelo.getValueAt(i, 1) + cantidad, i,
						1);
				modelo.setValueAt(parcial, i, 3);
				mesaTemp.setTotal(mesaTemp.getTotal() + precioPlato * cantidad);
				encontrado = 1;
			}
		}

		// Crear fila
		if (encontrado == 0) {
			double parcial = precioPlato * cantidad;
			Object[] arrayPlato = { numPlato, cantidad, nombrePlato, parcial };
			// aÃ±adir la fila de resumen
			modelo.addRow(arrayPlato);
			mesaTemp.setTotal(mesaTemp.getTotal() + parcial);
		}
		txtVisorAux.setText(nombrePlato);
		if (cantidad == 1) {
			txtVisorPrecio.setText(precioPlato * vecesPlu + " Â€");
			txtVisorCantidad.setText("" + vecesPlu);
		} else {
			txtVisorPrecio.setText(precioPlato * cantidad + " Â€");
			txtVisorCantidad.setText("" + cantidad);
			noPermitirPlu = 1;
		}
	}

	public void accionesComunBotones() {
		if (ultimoEsPlu == 1 || ultimoEsMenos == 1) {
			txtVisor.setText("");
			txtVisorAux.setText("");
			txtVisorPrecio.setText("");
			txtVisorCantidad.setText("");
			vecesPlu = 0;
			ultimoEsPlu = 0;
			ultimoEsMenos = 0;
			vacio = 0;
		}
	}

	public void funcionPLU() {
		if (mesa == 0) {
			String texto = "LLEVAR";
			txtMesa.setText(texto);

			mesaTemp = mesas.get(mesa);
			modelo = mesaTemp.getModelo();
			tableResumen = mesaTemp.getTableResumen();

			scrollPane.setViewportView(tableResumen);
		} else {
			String texto = "MESA " + mesa;
			txtMesa.setText(texto);
		}

		if (txtVisor.getText().equals("")) {
			// dar error PENDIENTE
			txtVisorAux.setText("METER NÃšMERO DE PLATO");
		} else {
			if (ultimoEsMenos == 1) {
				txtVisor.setText("");
				txtVisorAux.setText("");
				txtVisorPrecio.setText("");
				txtVisorCantidad.setText("");
				vecesPlu = 0;
				ultimoEsMenos = 0;
			}

			vecesPlu = vecesPlu + 1;

			String cadena = txtVisor.getText();

			try {
				if (cadena.indexOf("x") == -1) {
					cantidad = 1;
					numPlato = Integer.parseInt(cadena);
				} else {
					numPlato = Integer.parseInt(cadena.substring(0,
							cadena.indexOf("x")));
					cadena = cadena.substring(cadena.indexOf("x") + 1);
					cantidad = Integer.parseInt(cadena);

				}
			} catch (Exception e) {
				cantidad = 1;
			}

			// validar si existe el plato en la carta

			Iterator<Plato> iteradorPlato = platos.iterator();
			int encontradoPlato = 0;

			while (iteradorPlato.hasNext() && encontradoPlato == 0) {
				Plato plato = iteradorPlato.next();
				if (plato.getNumero() == numPlato) {
					nombrePlato = plato.getNombre();
					precioPlato = plato.getPrecio();
					encontradoPlato = 1;
				}
			}

			if (encontradoPlato == 0) {
				txtVisorAux.setText("NO EXISTE");
			} else {
				// validar si ya existe ese plato en la lista para sumar o
				// aÃ±adir
				if (noPermitirPlu == 1) {
					txtVisorAux.setText("NO SE PUEDE HACER PLU");
					noPermitirPlu = 0;
					txtVisor.setText("");
					txtVisorPrecio.setText("");
					txtVisorCantidad.setText("");
				} else {
					// comprobarExisteEnLista(modelo, cantidad, numPlato,
					// precioPlato, nombrePlato);
					comprobarExisteEnLista();
				}
			}

			// borrar visor
			// txtVisor.setText("");

		}
		ultimoEsPlu = 1;
	}

	public void funcionST() {
		Date fecha = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm     dd/MM/yyyy");
		txtVisorAux.setText(hourdateFormat.format(fecha));
	}

	public void funcionDejar() {
		if (mesaAbierta == 0) {
			txtVisorAux.setText("NO HAY MESA ABIERTA");
		} else {

			txtVisorAux.setText(mesaTemp.getTotal() + " Â€");
			txtVisor.setText("");
			txtVisorCantidad.setText("");
			txtVisorPrecio.setText("");
			txtMesa.setText("");
			mesa = 0;
			mesaAbierta = 0;

			DefaultTableModel modeloVacio = new DefaultTableModel();
			modeloVacio.addColumn("#");
			modeloVacio.addColumn("Cantidad");
			modeloVacio.addColumn("Plato");
			modeloVacio.addColumn("Importe");

			JTable tableResumenVacio = new JTable(modeloVacio);
			tableResumenVacio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableResumenVacio.getColumnModel().getColumn(0)
					.setPreferredWidth(40);
			tableResumenVacio.getColumnModel().getColumn(1)
					.setPreferredWidth(60);
			tableResumenVacio.getColumnModel().getColumn(2)
					.setPreferredWidth(249);
			tableResumenVacio.getColumnModel().getColumn(3)
					.setPreferredWidth(50);
			scrollPane.setViewportView(tableResumenVacio);
		}
	}

	public void funcionAbrir() {
		try {
			if ((Integer.parseInt(txtVisor.getText()) < 1)
					|| (Integer.parseInt(txtVisor.getText()) > 40)) {
				txtVisorAux.setText("NO EXISTE MESA");
				mesaAbierta = 0;
			} else {
				mesa = Integer.parseInt(txtVisor.getText());
				String texto = "MESA " + mesa;
				txtMesa.setText(texto);
				mesaAbierta = 1;
				txtVisor.setText("");
				txtVisorAux.setText("");

				// localizar mesa
				mesaTemp = mesas.get(mesa);
				modelo = mesaTemp.getModelo();
				tableResumen = mesaTemp.getTableResumen();

				scrollPane.setViewportView(tableResumen);
			}
		} catch (Exception e) {
			txtVisorAux.setText("NO EXISTE MESA");
			mesaAbierta = 0;
		}
	}

	public void funcionMenos() {
		if (txtVisor.getText().equals("")) {
			// dar error PENDIENTE
			txtVisorAux.setText("METER PLATO");
		} else {
			if (ultimoEsPlu == 1) {
				vecesPlu = 0;
				ultimoEsPlu = 0;
			}
			vecesPlu = vecesPlu + 1;
			String cadena = txtVisor.getText();
			int numPlato = 0;
			try {
				if (cadena.indexOf("x") == -1) {
					cantidad = 1;
					numPlato = Integer.parseInt(cadena);
				} else {
					txtVisorAux.setText("BORRAR DE UNO EN UNO");
				}
			} catch (Exception e) {
				cantidad = 1;
			}

			// validar si existe el plato en la carta

			Iterator<Plato> iterador = platos.iterator();
			int encontradoPlato = 0;

			while (iterador.hasNext() && encontradoPlato == 0) {
				Plato plato = iterador.next();
				if (plato.getNumero() == numPlato) {
					nombrePlato = plato.getNombre();
					precioPlato = plato.getPrecio();
					encontradoPlato = 1;
				}
			}

			if (encontradoPlato == 0) {
				txtVisorAux.setText("NO EXISTE");
			} else {
				// localizar mesa
				mesaTemp = mesas.get(mesa);
				modelo = mesaTemp.getModelo();
				tableResumen = mesaTemp.getTableResumen();

				// validar si ya existe ese plato en la lista para restar
				restarPlato();
			}

			// borrar visor
			// txtVisor.setText("");
		}
		ultimoEsMenos = 1;
	}

	public void restarPlato() {
		int encontrado = 0;

		for (int i = 0; i < modelo.getRowCount() && encontrado == 0; i++) {
			Object valor = modelo.getValueAt(i, 0);

			if (Integer.parseInt(valor.toString()) == (numPlato)) {
				modelo.setValueAt((int) modelo.getValueAt(i, 1) - cantidad, i,
						1);
				modelo.setValueAt((double) modelo.getValueAt(i, 3)
						- (precioPlato * cantidad), i, 3);
				mesaTemp.setTotal(mesaTemp.getTotal() - precioPlato * cantidad);
				if ((int) modelo.getValueAt(i, 1) == 0) {
					modelo.removeRow(i);
					nombrePlato = "YA NO QUEDAN";
					txtVisorPrecio.setText("-" + precioPlato * vecesPlu + " Â€");
					txtVisorCantidad.setText("-" + vecesPlu);
					vacio = 1;
				}

				encontrado = 1;
			}
		}

		if (encontrado == 1) {
			txtVisorAux.setText(nombrePlato);
		} else {
			vacio = 1;
			nombrePlato = "NO TIENE ESTE PLATO";
			txtVisorAux.setText(nombrePlato);
		}

		if (vacio != 1) {
			txtVisorPrecio.setText("-" + precioPlato * vecesPlu + " Â€");
			txtVisorCantidad.setText("-" + vecesPlu);
		}
	}

	public void funcionAMT() {

	}

}
