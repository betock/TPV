package DTO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Mesa {
	private int numero;
	private double total;
	private DefaultTableModel modelo;
	private JTable tableResumen;
	
	public Mesa(int numero, double total, DefaultTableModel modelo,
			JTable tableResumen) {
		super();
		this.numero = numero;
		this.total = total;
		this.modelo = modelo;
		this.tableResumen = tableResumen;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public DefaultTableModel getModelo() {
		return modelo;
	}
	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}
	public JTable getTableResumen() {
		return tableResumen;
	}
	public void setTableResumen(JTable tableResumen) {
		this.tableResumen = tableResumen;
	}

}
