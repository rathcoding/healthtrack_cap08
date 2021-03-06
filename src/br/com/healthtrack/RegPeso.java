package br.com.healthtrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Entidade a ser persistida no Banco de Dados

public class RegPeso {
	private int id;
	private Calendar data;
	private Double peso;
	private int cd_usuario;
	
	public RegPeso (int id, Calendar data, Double peso, int cd_usuario) {
		this.id = id;
		this.data = data;
		this.peso = peso;
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
	
	public void setPeso (Double peso) {
		this.peso = peso;
	}
	
	public Double getPeso () {
		return this.peso;
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
		return 	"RegPeso [id=" + this.id + 
				", data=" + formatter.format(data) +
				", peso=" + this.peso +
				", cd_usuario=" + this.cd_usuario + "]";
	}	
	
}
