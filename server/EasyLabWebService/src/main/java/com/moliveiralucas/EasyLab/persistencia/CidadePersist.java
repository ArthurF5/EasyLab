package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Cidade;

public class CidadePersist {
	ConexaoMySQL mConexaoMySQL;
	public Integer retornaID(Cidade cidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT id_Cidade FROM cidade WHERE cidade LIKE '"+cidade.getCidade()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("id_Cidade");
			}
		}catch(SQLException sqle){
			System.out.println("Retorna ID Cidade ERROR: "+sqle.getMessage());
		}
		return retorno;
	}

	public Integer cadastrar(Cidade cidade) {
		Integer retorno;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM cidade WHERE cidade LIKE '"+cidade.getCidade()+"' AND id_Estado = "+cidade.getEstado().getId_Estado();
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO cidade(cidade, id_UF) VALUES(?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, cidade.getCidade());
				mPreparedStatement.setInt(2, cidade.getEstado().getId_Estado());
				mPreparedStatement.executeUpdate();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println("Cadastrar Cidade ERRO: "+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}

	public Integer excluir(Cidade cidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM cidade WHERE id_Cidade = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, cidade.getId_Cidade());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println("Excluir Cidade ERROR: "+sqle.getMessage());
			retorno = 2;
		}
		return retorno;
	}
	
	public Integer alterar(Cidade cidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "UPDATE cidade SET cidade = ?, id_UF = ? WHERE id_Cidade = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, cidade.getCidade());
			mPreparedStatement.setInt(2, cidade.getEstado().getId_Estado());
			mPreparedStatement.setInt(3,cidade.getId_Cidade());
			mPreparedStatement.executeUpdate();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println("Alterar cidade ERROR: "+sqle.getMessage());
			retorno = 2;
		}
		return retorno;
	}
	
	public Cidade consultaCidade(String parametroBusca) {
		Cidade cidade = new Cidade();
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM cidade WHERE cidade LIKE '"+parametroBusca+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				cidade.setCidade(mResultSet.getString("cidade"));
				cidade.setId_Cidade(mResultSet.getInt("cidadeID"));
			}else {
				cidade = null;
			}
		}catch(SQLException sqle) {
			System.out.println("Consulta Cidade ERROR: "+sqle.getMessage());
			cidade = null;
		}
		return cidade;
	}

	public ArrayList<Cidade> consultaPorEstado(Integer estadoID){
		ArrayList<Cidade> mListaCidade = new ArrayList<Cidade>();
		Cidade mCidade;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM cidade WHERE id_UF = "+estadoID;
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mCidade = new Cidade();
				mCidade.setCidade(mResultSet.getString(""));
				mCidade.setId_Cidade(mResultSet.getInt("id_Cidade"));
				mListaCidade.add(mCidade);
			}
		}catch(SQLException sqle) {
			System.out.println("Buscar Cidades por Estado ERROR: "+sqle.getMessage());
			mListaCidade = null;
		}
		return mListaCidade;
	}

	public ArrayList<Cidade> listarTodos(String parametroBusca){
		ArrayList<Cidade> mListaCidade = new ArrayList<Cidade>();
		Cidade mCidade;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql;
		if(parametroBusca.equals("null")) {
			sql = "SELECT * FROM cidade ORDER BY cidade";
		}else {
			sql = "SELECT * FROM cidade WHERE cidade LIKE '"+parametroBusca+"%' ORDER BY cidade";
		}
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mCidade = new Cidade();
				mCidade.setCidade(mResultSet.getString("cidade"));
				mCidade.setId_Cidade(mResultSet.getInt("cidadeID"));
				mListaCidade.add(mCidade);
			}
		}catch(SQLException sqle) {
			System.out.println("Listar Todos Cidade ERROR: "+sqle.getMessage());
			mListaCidade = null;
		}
		return mListaCidade;
	}
}
