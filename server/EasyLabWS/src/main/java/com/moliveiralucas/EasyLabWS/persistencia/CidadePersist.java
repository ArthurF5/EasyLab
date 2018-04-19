package com.moliveiralucas.EasyLabWS.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLabWS.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLabWS.model.Cidade;

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

	public Cidade consulta(String parametroBusca) {
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

	public ArrayList<Cidade> buscaPorEstado(Integer estadoID){
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
		}catch(SQLException sqle) {
			
		}
		return mListaCidade;
	}
}
