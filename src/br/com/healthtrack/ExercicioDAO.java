package br.com.healthtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExercicioDAO {

	private Connection conexao;
	
	public void cadastrar (RegExercicio exercicio) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "INSERT INTO T_HTK_EXERCICIO(cd_exercicio,	dt_exercicio, qt_duracao_min, cd_tipo, cd_intensidade, ds_exercicio, cd_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, exercicio.getId());
			stmt.setDate(2, new java.sql.Date(exercicio.getData().getTimeInMillis()));
			stmt.setInt(3, exercicio.getDuracaoMin());
			stmt.setInt(4, exercicio.getTipo());
			stmt.setInt(5, exercicio.getIntensidade());
			stmt.setString(6, exercicio.getDescricao());
			stmt.setInt(7, exercicio.getCD_usuario());
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
	
	public List<RegExercicio> getAll(){
		
		List<RegExercicio> lista = new ArrayList<RegExercicio>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_EXERCICIO");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				int cd_exercicio = rs.getInt("cd_exercicio");
				java.sql.Date rawdate = rs.getDate("dt_exercicio");
				Calendar dt_exercicio = Calendar.getInstance();
				dt_exercicio.setTimeInMillis(rawdate.getTime());
				int qt_duracao_min = rs.getInt("qt_duracao_min");
				int cd_tipo = rs.getInt("cd_tipo");
				int cd_intensidade = rs.getInt("cd_intensidade");
				String descricao = rs.getString("ds_exercicio");
				int cd_usuario = rs.getInt("cd_usuario");
				RegExercicio exercicio = new RegExercicio(cd_exercicio, dt_exercicio, qt_duracao_min, cd_tipo, cd_intensidade, descricao, cd_usuario);
				lista.add(exercicio);
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
