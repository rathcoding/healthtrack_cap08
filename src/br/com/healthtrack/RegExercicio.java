package br.com.healthtrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Entidade a ser persistida no Banco de Dados

public class RegExercicio {
	private int id;
	private Calendar data;
	private int duracaoMin;
	private int tipo;			// Tipo: [1] Aerobico, [2] Força, [3] Mobilidade
	private int intensidade; 	// Tipo: [1] Leve, [2] Moderado, [3] Pesado
	private String descricao;
	private int cd_usuario;
	
	public RegExercicio (int id, Calendar data, int duracaoMin, int tipo, int intensidade, String descricao, int cd_usuario) {
		this.id = id;
		this.data = data;
		this.duracaoMin = duracaoMin;
		this.tipo = tipo;
		this.intensidade = intensidade;
		this.descricao = descricao;
		this.cd_usuario = cd_usuario;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public int getId () {
		return this.id;
	}
	
	public void setData (Calendar data) {
		this.data = data;
	}
	
	public Calendar getData () {
		return this.data;
	}
	
	public void setDuracaoMin (int duracaoMin) {
		this.duracaoMin = duracaoMin;
	}
	
	public int getDuracaoMin () {
		return this.duracaoMin;
	}

	public void setTipo (int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo () {
		return this.tipo;
	}

	public void setIntensidade (int intensidade) {
		this.intensidade = intensidade;
	}
	
	public int getIntensidade () {
		return this.intensidade;
	}

	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao () {
		return this.descricao;
	}

	public int getCD_usuario() {
		return cd_usuario;
	}

	public void setCD_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new java.sql.Date(this.getData().getTimeInMillis());
		return	"RegExercicio [id=" + this.id + 
				", data=" + formatter.format(data) +
				", duracaoMin=" + this.duracaoMin +
				", tipo=" + this.tipo +
				", intensidade=" + this.intensidade +
				", descricao=" + this.descricao +
				", cd_usuario=" + this.cd_usuario + "]";
	}	
	
}
