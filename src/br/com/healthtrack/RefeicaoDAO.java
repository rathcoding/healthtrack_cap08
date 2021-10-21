package br.com.healthtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RefeicaoDAO {
	
	private Connection conexao;
	
	public void cadastrar (RegRefeicao refeicao) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "INSERT INTO T_HTK_REFEICAO(cd_refeicao, dt_refeicao, vl_caloria, ds_refeicao, cd_usuario) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, refeicao.getId());
			stmt.setDate(2, new java.sql.Date(refeicao.getData().getTimeInMillis()));
			stmt.setDouble(3, refeicao.getCalorias());
			stmt.setString(4, refeicao.getDescricao());
			stmt.setInt(5, refeicao.getCD_usuario());
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
	
	public List<RegRefeicao> getAll(){
		
		List<RegRefeicao> lista = new ArrayList<RegRefeicao>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_REFEICAO");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				int cd_refeicao = rs.getInt("cd_refeicao");
				java.sql.Date rawdate = rs.getDate("dt_refeicao");
				Calendar dt_refeicao = Calendar.getInstance();
				dt_refeicao.setTimeInMillis(rawdate.getTime());
				int vl_calorias = rs.getInt("vl_caloria");
				String ds_refeicao = rs.getString("ds_refeicao");
				int cd_usuario = rs.getInt("cd_usuario");
				RegRefeicao refeicao = new RegRefeicao(cd_refeicao, dt_refeicao, vl_calorias, ds_refeicao, cd_usuario);
				lista.add(refeicao);
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
