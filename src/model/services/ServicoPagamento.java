package model.services;

public interface ServicoPagamento {

	Double taxaPagamento(Double quantia);
	
	Double juros(Double quantia, Integer meses);
	
}
