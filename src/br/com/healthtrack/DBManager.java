package br.com.healthtrack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	public static Connection obterConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"SYSTEM",
					"q1w2e3");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
