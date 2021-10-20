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
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "INSERT INTO T_HTK_PESO(cd_pesagem, dt_pesagem, vl_peso, cd_usuario) VALUES (?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getId());
			stmt.setDate(2, new java.sql.Date(peso.getData().getTimeInMillis()));
			stmt.setDouble(3, peso.getPeso());
			stmt.setInt(4, peso.getCD_usuario());
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
		
		List<RegPeso> lista = new ArrayList<RegPeso>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_PESO");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				int cd_pesagem = rs.getInt("cd_pesagem");
				java.sql.Date rawdate = rs.getDate("dt_pesagem");
				Calendar dt_pesagem = Calendar.getInstance();
				dt_pesagem.setTimeInMillis(rawdate.getTime());
				double vl_peso = rs.getDouble("vl_peso");
				int cd_usuario = rs.getInt("cd_usuario");
				RegPeso pesagem = new RegPeso(cd_pesagem, dt_pesagem, vl_peso, cd_usuario);
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
