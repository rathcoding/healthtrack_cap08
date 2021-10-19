package br.com.healthtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PesoDAO {
	
	private Connection conexao;
	
	public void cadastrar (RegPeso peso) {
		
		//this.fakeDB.add(peso); // Simula INSERT na tabela de Registro de Pesos
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "INSERT INTO T_PESO(CD_PESAGEM, DT_PESAGEM, VL_PESO, CD_USUARIO) VALUES (SQ_PESO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getId());
			stmt.setDate(2, new java.sql.Date(peso.getData().getTimeInMillis()));
			stmt.setDouble(3, peso.getPeso());
			stmt.setInt(1, peso.getCD_usuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<RegPeso> getAll(){
		
		// Simula um SELECT * na tabela de Registro de Pesos e preparo de lista para retorno
		
		List<RegPeso> lista = new ArrayList<RegPeso>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_PESO");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				int id = rs.getInt("ID");
				java.sql.Date rawdate = rs.getDate("DATA");
				Calendar data = Calendar.getInstance();
				data.setTimeInMillis(rawdate.getTime());
				double peso = rs.getDouble("PESO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				RegPeso pesagem = new RegPeso(id, data, peso, cd_usuario);
				lista.add(pesagem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
}
