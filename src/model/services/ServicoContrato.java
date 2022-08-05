package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Prestacao;

public class ServicoContrato {

	private ServicoPagamento servicoDePagamento;

	public ServicoContrato(ServicoPagamento servicoDePagamento) {
		this.servicoDePagamento = servicoDePagamento;
	}

	public void processoDeContrato(Contrato contrato, int meses) {
		double cota = contrato.getValorTotal() / meses;
		// cota = 600 / 3 == 200
		for (int i = 1; i <= meses; i++) {
			double cotaParcial = cota + servicoDePagamento.juros(cota, i);
			// cotaParcial = 200 + (200 * i * 0.02) == 202
			double cotaTotal = cotaParcial + servicoDePagamento.taxaPagamento(cotaParcial);
			// cotaTotal = 202 + (202 * 0,02) == 206.4
			Date dataVencimento = adicionaMes(contrato.getData(), i);
			contrato.getPrestacao().add(new Prestacao(dataVencimento, cotaTotal));
		}

	}

	private Date adicionaMes(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}

}
