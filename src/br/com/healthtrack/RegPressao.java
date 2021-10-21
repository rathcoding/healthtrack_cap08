package br.com.healthtrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Entidade a ser persistida no Banco de Dados

public class RegPressao {
	private int id;
	private Calendar data;
	private int pas;		// Pressao Arterial Sistolica
	private int pad;		// Pressao Arterial Diastolica
	private int cd_usuario;
	
	public RegPressao (int id, Calendar data, int pas, int pad, int cd_usuario) {
		this.id = id;
		this.data = data;
		this.pas = pas;
		this.pad = pad;
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
	
	public void setPas (int pas) {
		this.pas = pas;
	}
	
	public int getPas () {
		return this.pas;
	}
	
	public void setPad (int pad) {
		this.pad = pad;
	}
	
	public int getPad () {
		return this.pad;
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
		return 	"RegPressao [id=" + this.id + 
				", data=" + formatter.format(data) +
				", pas=" + this.pas +
				", pad=" + this.pad +
				", cd_usuario=" + this.cd_usuario + "]";
	}	
	
}
