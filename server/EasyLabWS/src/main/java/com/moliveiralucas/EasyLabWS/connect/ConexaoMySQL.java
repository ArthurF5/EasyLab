package com.moliveiralucas.EasyLabWS.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {
	private String login = "moliveiralucas";
	private String senha = "Lu993011";
	private String host = "localhost";
	private String dbName = "easylabDB";
	private String url = "jdbc:mysql://" + host + "/" + dbName+"?autoReconnect=true&useSSL=false";
	public Connection conexao = null;
	public Statement stmt = null;
	public ResultSet r = null;
	
	public ConexaoMySQL() {}

	public Connection abreConexaoBD(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException ex){
			return null;
		}
		try{
			// efetua conexao com o banco de dados
			this.conexao = (Connection) DriverManager.getConnection(url,login,senha);
		}catch (SQLException ex){
			return null;
		}
		return this.conexao;
	}
}
