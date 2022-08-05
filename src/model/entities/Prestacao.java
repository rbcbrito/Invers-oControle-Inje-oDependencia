package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataVecimento;
	private Double quantia;
	
	public Prestacao(Date dataVecimento, Double quantia) {
		this.dataVecimento = dataVecimento;
		this.quantia = quantia;
	}

	public Date getDataVecimento() {
		return dataVecimento;
	}

	public void setDataVecimento(Date dataVecimento) {
		this.dataVecimento = dataVecimento;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return sdf.format(dataVecimento) + " - " + String.format("%.2f", quantia);
	}
	
	
	
}
