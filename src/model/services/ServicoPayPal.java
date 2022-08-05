package model.services;

public class ServicoPayPal implements ServicoPagamento {

	private static final double TAXA_DE_JUROS = 0.02;
	private static final double JUROS_MENSAL = 0.01;
	
	@Override
	public Double taxaPagamento(Double quantia) {
		return quantia * TAXA_DE_JUROS;
	}

	@Override
	public Double juros(Double quantia, Integer meses) {
		return quantia * meses * JUROS_MENSAL;
	}

}
