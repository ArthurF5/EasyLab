package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Convenio;

public class ConvenioPersist {
	ConexaoMySQL mConexaoMySQL;
	
	public Integer retornaID() {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("");
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return retorno;
	}
	
	public Integer cadastrar(Convenio convenio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM convenio WHERE convenio LIKE '"+convenio.getConvenio()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO convenio(convenio) VALUES(?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, convenio.getConvenio());
				mPreparedStatement.executeUpdate();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer alterar(Convenio convenio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "UPDATE convenio SET convenio = ? WHERE id_Convenio = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, convenio.getConvenio());
			mPreparedStatement.setInt(2, convenio.getId_Convenio());
			mPreparedStatement.executeUpdate();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println("Alterar Convenio ERROR: "+sqle.getMessage());
			retorno = 2;
		}
		return retorno;
	}
	
	public Integer excluir(Convenio convenio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM convenio WHERE id_Convenio = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, convenio.getId_Convenio());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println("Excluir Convenio ERRO: "+sqle.getMessage());
			retorno = 2;
		}
		return retorno;
	}
	
	public Convenio consultarConvenio(String parametroBusca) {
		Convenio convenio = new Convenio();
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		String sql = "SELECT * FROM convenio WHERE convenio LIKE '"+parametroBusca+"'";
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				convenio.setConvenio(mResultSet.getString(""));
				convenio.setId_Convenio(mResultSet.getInt(""));
			}else {
				convenio = null;
			}
		}catch(SQLException sqle) {
			System.out.println("Consultar Convenio ERROR: "+sqle.getMessage());
			convenio = null;
		}
		return convenio;
	}
	
	public ArrayList<Convenio> listarTodos(String parametroBusca){
		ArrayList<Convenio> listaConvenio = new ArrayList<Convenio>();
		Convenio mConvenio;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM convenio ORDER BY convenio";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mConvenio = new Convenio();
				mConvenio.setConvenio(mResultSet.getString(""));
				mConvenio.setId_Convenio(mResultSet.getInt(""));
				listaConvenio.add(mConvenio);
			}
		}catch(SQLException sqle) {
			System.out.println("Listar todos Convenios ERROR: "+sqle.getMessage());
			listaConvenio = null;
		}
		return listaConvenio;
	}
}
