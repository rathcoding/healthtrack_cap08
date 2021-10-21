package br.com.healthtrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Entidade a ser persistida no Banco de Dados

public class RegRefeicao {
	private int id;
	private Calendar data;
	private int calorias;
	private String descricao;
	private int cd_usuario;
	
	public RegRefeicao (int id, Calendar data, int calorias, String descricao, int cd_usuario) {
		this.id = id;
		this.data = data;
		this.calorias = calorias;
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
	
	public void setCalorias (int calorias) {
		this.calorias = calorias;
	}
	
	public int getCalorias () {
		return this.calorias;
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
		return 	"RegRefeicao [id=" + this.id + 
				", data=" + formatter.format(data) +
				", calorias=" + this.calorias +
				", descricao=" + this.descricao +
				", cd_usuario=" + this.cd_usuario + "]";
	}	
	
}
