package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;

public class PerfilUsuarioPersist {
	ConexaoMySQL mConexaoMySQL;
	
	public Integer retornaID(PerfilUsuario mPerfilUsuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT id_PerfilUsuario FROM perfilUsuario WHERE perfilUsuario = '"+mPerfilUsuario.getPerfilDeUsuario()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("id_PerfilUsuario");
			}
		}catch(SQLException sqle) {
			System.out.println("Retorna ID PerfilUsuario ERROR: "+sqle.getMessage());
		}
		return retorno;
	}
	
	public Integer cadastrar(PerfilUsuario mPerfilUsuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM perfilUsuario WHERE perfilUsuario = '"+mPerfilUsuario.getPerfilDeUsuario()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO perfilUsuario(perfilUsuario) VALUES(?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, mPerfilUsuario.getPerfilDeUsuario());
				mPreparedStatement.executeQuery();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println("Cadastrar Perfil de Usuario ERROR: "+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer alterar(PerfilUsuario mPerfilUsuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "UPDATE perfilUsuario SET perfilUsuario = ? WHERE id_PerfilUsuario = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, mPerfilUsuario.getPerfilDeUsuario());
			mPreparedStatement.setInt(2, mPerfilUsuario.getId_PerfilUsuario());
			mPreparedStatement.executeUpdate();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer excluir(PerfilUsuario mPerfilUsuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM perfilUsuario WHERE id_PerfilUsuario = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, mPerfilUsuario.getId_PerfilUsuario());
			mPreparedStatement.execute();
			mPreparedStatement.close();
		}catch(SQLException sqle) {
			
		}
		return retorno;
	}
	
	public PerfilUsuario consultar(String parametroBusca) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement= null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "SELECT * FROM perfilUsuario WHERE perfilUsuario = "+parametroBusca;
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mPerfilUsuario.setId_PerfilUsuario(mResultSet.getInt("id_PerfilUsuario"));
				mPerfilUsuario.setPerfilDeUsuario(mResultSet.getString("perfilUsuario"));
			}else {
				mPerfilUsuario = null;
			}
		}catch(SQLException sqle) {
			System.out.println("Consulta Perfil Usuario ERROR: "+sqle.getMessage());
			mPerfilUsuario = null;
		}
		return mPerfilUsuario;
	}
	
	public ArrayList<PerfilUsuario> listarTodos(String parametroBusca){
		ArrayList<PerfilUsuario> listaPerfilUsuario = new ArrayList<PerfilUsuario>();
		PerfilUsuario mPerfilUsuario;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM perfilUsuario ";
		if(!parametroBusca.equals("")) {
			sql += "WHERE perfilUsuario = '"+parametroBusca+"' ";
		}
		sql += "ORDER BY parametroBusca";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mPerfilUsuario = new PerfilUsuario();
				mPerfilUsuario.setId_PerfilUsuario(mResultSet.getInt("id_PerfilUsuario"));
				mPerfilUsuario.setPerfilDeUsuario(mResultSet.getString("perfilUsuario"));
				listaPerfilUsuario.add(mPerfilUsuario);
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			listaPerfilUsuario = null;
		}
		return listaPerfilUsuario;
	}
}
