package br.com.healthtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PressaoDAO {
	
	private Connection conexao;
	
	public void cadastrar (RegPressao pressao) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "INSERT INTO T_HTK_PRESSAO(cd_pressao, dt_pressao, vl_pas, vl_pad, cd_usuario) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressao.getId());
			stmt.setDate(2, new java.sql.Date(pressao.getData().getTimeInMillis()));
			stmt.setInt(3, pressao.getPas());
			stmt.setInt(4, pressao.getPad());
			stmt.setInt(5, pressao.getCD_usuario());
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
	
	public List<RegPressao> getAll(){
		
		List<RegPressao> lista = new ArrayList<RegPressao>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_PRESSAO");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				int cd_pressao = rs.getInt("cd_pressao");
				java.sql.Date rawdate = rs.getDate("dt_pressao");
				Calendar dt_pressao = Calendar.getInstance();
				dt_pressao.setTimeInMillis(rawdate.getTime());
				int vl_pas = rs.getInt("vl_pas");
				int vl_pad = rs.getInt("vl_pad");
				int cd_usuario = rs.getInt("cd_usuario");
				RegPressao pressao = new RegPressao(cd_pressao, dt_pressao, vl_pas, vl_pad, cd_usuario);
				lista.add(pressao);
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
