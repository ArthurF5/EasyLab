package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Estado;

public class EstadoPersist {
	ConexaoMySQL mConexaoMySQL;

	public Integer retornaID(Estado uf) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT ufID FROM UF WHERE uf LIKE '"+uf.getEstado()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("ufID");
			}
		}catch(SQLException e) {
			System.out.println("RetornarID UF ERROR: "+e.getMessage());
		}
		return retorno;
	}
	
	public Integer cadastrar(Estado estado) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM uf WHERE estado LIKE '"+estado.getEstado()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO uf (uf, estado) VALUES (?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, estado.getUf());
				mPreparedStatement.setString(2, estado.getEstado());
				mPreparedStatement.executeQuery();
				mPreparedStatement.close();
				retorno = 1;
			} else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println("Incluir Usuario ERRO: "+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer excluir(Estado estado) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM uf WHERE id_Uf = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, estado.getId_Estado());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println("Excluir Estado ERROR: "+sqle.getMessage());
			retorno = 2;
		}
		return retorno;
	}
	
	public String buscaUFPorID(Integer id) {
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT nome FROM UF WHERE ufID = "+id;
		String retorno = "";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if (mResultSet.next()) {
				retorno = mResultSet.getString("nome");
			}
		} catch (SQLException e) {
			System.out.println("Retorna UF por ID ERROR: "+e.getMessage());
		}
		return retorno;
	}

	public Estado consulta(String parametroBusca) {
		Estado uf = new Estado();
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM UF WHERE uf LIKE '"+parametroBusca+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				uf.setEstado(mResultSet.getString("uf"));
				uf.setId_Estado(mResultSet.getInt("ufID"));
			}else {
				uf = null;
			}
		}catch(SQLException e) {
			System.out.println("Consulta UF ERROR: "+e.getMessage());
		}
		return uf;
	}

	public ArrayList<Estado> listarTodos(){
		ArrayList<Estado> mUF = new ArrayList<Estado>();
		Estado uf;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM UF ORDER BY uf";;
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				uf = new Estado();
				uf.setEstado(mResultSet.getString("uf"));
				uf.setId_Estado(mResultSet.getInt("ufID"));
				mUF.add(uf);
			}
		}catch(SQLException e) {
			System.out.println("Listar todos UF ERROR: "+e.getMessage());
			mUF = null;
		}
		return mUF;
	}
}
