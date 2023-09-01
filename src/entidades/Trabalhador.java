package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enun.Nivel;

public class Trabalhador {

	private String nome;
	private Nivel nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HorasContrato> contratos = new ArrayList<>();
	
	public void addContrato(HorasContrato contrato) {
		contratos.add(contrato);
	}
	
	public void remContrato(HorasContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double pagamento(int ano,int mes) {
		double som = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(HorasContrato c : contratos) {
			cal.setTime(c.getDate());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				som += c.valorTotal();
			}
		}
		return som;
	}
	
	
	public Trabalhador() {
		
	}
	
	public Trabalhador(String nome, Nivel nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	public List<HorasContrato> getContratos() {
		return contratos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public Double getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
