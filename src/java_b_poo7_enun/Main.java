package java_b_poo7_enun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HorasContrato;
import entidades.Trabalhador;
import entidades.enun.Nivel;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Nome do departamento:");
		String depart = sc.nextLine();	
		System.out.println("Entre os dados do trabalhador:");
		System.out.println("nome:");
		String nome=sc.nextLine();
		System.out.println("Nivel:");
		String nivel=sc.nextLine();
		System.out.println("Salario base:");
		double salarioBase=sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, Nivel.valueOf(nivel), salarioBase, new Departamento(depart));
		
		System.out.println("Quantos contratos tem esse trabalhador?");
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++) {
			sc.nextLine();
			System.out.println("Entre os dados do contrato #" + (i+1));
			System.out.println("Datas (DD/MM/YYYY):");
			Date data = sdf.parse(sc.nextLine());
			System.out.println("Valor por hora:");
			double valorPorHora = sc.nextDouble();
			System.out.println("Quantas horas");
			int horas = sc.nextInt();
			HorasContrato hContrato = new HorasContrato(data, valorPorHora, horas);
			trabalhador.addContrato(hContrato);
		}
		
		System.out.println("Entre mes e ano para calcular o pagamento(MM/YYYY):");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento:" + trabalhador.getDepartamento().getNome());
		System.out.println("Pagamento por " + mes + "/" + ano + ": " + trabalhador.pagamento(ano,mes));
		
		sc.close();
	}
	
}
