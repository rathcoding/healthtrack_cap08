package br.com.healthtrack;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Testes {

	public static void main(String[] args) throws ParseException {
		
		
		//insertPeso();
		getAllPeso();
		
		//insertRefeicao();
		getAllRefeicao();
		
		//insertPressao();
		getAllPressao();

		//insertExercicio();
		getAllExercicio();

	}

	//===============================================================
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
	//===============================================================
	public static void insertRefeicao() {
		RefeicaoDAO refeicaoDAO = new RefeicaoDAO();

		int[] calorias = {150, 300, 460, 800};
		String[] descricoes = {"Lanche", "Cafe da manha", "Janta", "Almoco"};
		Calendar data = Calendar.getInstance();
		int cd_usuario = 1;
		
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int rand = random.nextInt(4);
			RegRefeicao refeicao = new RegRefeicao(i, data, calorias[rand], descricoes[rand], cd_usuario);
			refeicaoDAO.cadastrar(refeicao);
			data.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public static void getAllRefeicao() {
		
		RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
		List<RegRefeicao> refeicoes = refeicaoDAO.getAll();
		
		for (RegRefeicao reg: refeicoes) {
			System.out.println(reg.toString());			
		}
	}
	//===============================================================
	public static void insertPressao() {
		PressaoDAO pressaoDAO = new PressaoDAO();

		int[] pas = {120, 130, 140};
		int[] pad = {80, 88, 90};
		Calendar data = Calendar.getInstance();
		int cd_usuario = 1;
		
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int rand = random.nextInt(3);
			RegPressao pressao = new RegPressao(i, data, pas[rand], pad[rand], cd_usuario);
			pressaoDAO.cadastrar(pressao);
			data.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public static void getAllPressao() {
		
		PressaoDAO pressaoDAO = new PressaoDAO();
		List<RegPressao> pressao = pressaoDAO.getAll();
		
		for (RegPressao reg: pressao) {
			System.out.println(reg.toString());			
		}
	}
	//===============================================================
	public static void insertExercicio() {
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		
		Calendar data = Calendar.getInstance();
		int[] duracaoMin = {45, 50, 60};
		int cd_usuario = 1;
		
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int rand = random.nextInt(3);		
			int tipo = rand + 1;				// Tipo: [1] Aerobico, [2] Força, [3] Mobilidade
			int intensidade = rand + 1;			// Intensidade: [1] Leve, [2] Moderado, [3] Pesado
			String descricao = new String("Exercicio id " + i);
			RegExercicio exercicio = new RegExercicio(i, data, duracaoMin[rand], tipo, intensidade, descricao, cd_usuario);
			exercicioDAO.cadastrar(exercicio);
			data.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public static void getAllExercicio() {
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		List<RegExercicio> exercicios = exercicioDAO.getAll();
		
		for (RegExercicio reg : exercicios) {
			System.out.println(reg.toString());			
		}
	}
	//===============================================================
}
