package br.com.healthtrack;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public class Testes {

	public static void main(String[] args) throws ParseException {
		
		//insertPeso();

		getAllPeso();
		
	}
	
	public static void insertPeso() {
		PesoDAO pesoDAO = new PesoDAO();

		Double quilos = 50.0;
		Calendar data = Calendar.getInstance();
		int cd_usuario = 1;
		
		for (int i = 0; i < 10; i++) {
			quilos *= 0.99;
			RegPeso peso = new RegPeso(i, data, quilos, cd_usuario);
			pesoDAO.cadastrar(peso);
			data.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public static void getAllPeso() {
		
		PesoDAO pesoDAO = new PesoDAO();
		List<RegPeso> pesos = pesoDAO.getAll();
		
		for (RegPeso reg: pesos) {
			System.out.println(reg.toString());			
		}
	}
	
}
