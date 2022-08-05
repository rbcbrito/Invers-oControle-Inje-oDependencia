package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Prestacao;
import model.services.ServicoContrato;
import model.services.ServicoPayPal;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato");
		System.out.print("Numero do contrato: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor total do contrato: ");
		double valorTotal = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();

		Contrato contrato = new Contrato(numero, data, valorTotal);

		System.out.println("Parcelamento:");

		ServicoContrato servicoContrato = new ServicoContrato(new ServicoPayPal());

		servicoContrato.processoDeContrato(contrato, n);

		for (Prestacao p : contrato.getPrestacao()) {
			System.out.println(p);
		}

		sc.close();

	}

}
