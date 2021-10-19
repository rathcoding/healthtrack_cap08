package br.com.healthtrack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	public static Connection obterConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"OPS$XXXX",
					"XXXXX");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
