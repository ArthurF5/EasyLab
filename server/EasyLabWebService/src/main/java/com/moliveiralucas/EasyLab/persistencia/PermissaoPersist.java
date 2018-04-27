package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Permissao;

public class PermissaoPersist {
	ConexaoMySQL mConexaoMySQL;
	
	public Integer cadastrar(Permissao mPermissao) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "SELECT * FROM permissao WHERE permissao = "+mPermissao.getPermissao();
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO permissao(permissao) VALUES(?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, mPermissao.getPermissao());
				mPreparedStatement.executeUpdate();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println("Cadastro Permissao ERROR: "+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer alterar(Permissao mPermissao) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "UPDATE permissao SET permissao = ? WHERE id_Permissao = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, mPermissao.getPermissao());
			mPreparedStatement.setInt(2, mPermissao.getId_Permissao());
			mPreparedStatement.executeUpdate();
			mPreparedStatement.close();
			retorno = 1; 
		}catch(SQLException sqle) {
			System.out.println("Alterar Permissao ERROR: "+sqle.getMessage());
		}
		return retorno;
	}
	
	public Integer excluir(Permissao mPermissao) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM permissao WHERE id_Permissao = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, mPermissao.getId_Permissao());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println("Excluir Permissao ERROR: "+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Permissao consultar(String parametroBusca) {
		Permissao mPermissao = null;
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement= null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "SELECT * FROM permissao WHERE permissao = '"+parametroBusca+"'";
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mPermissao = new Permissao();
				mPermissao.setId_Permissao(mResultSet.getInt("id_Permissao"));
				mPermissao.setPermissao(mResultSet.getString("permissao"));
			}
		}catch(SQLException sqle) {
			System.out.println("Consultar Permissao ERROR: "+sqle.getMessage());
		}
		return mPermissao;
	}
	
	public ArrayList<Permissao> listarTodos(String parametroBusca){
		ArrayList<Permissao> listaPermissoes = new ArrayList<Permissao>();
		Permissao mPermissao;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM permissao ";
		if(!parametroBusca.equals("")) {
			sql += "WHERE permissao LIKE '"+parametroBusca+"%'";
		}
		sql += "ORDER BY permissao";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mPermissao = new Permissao();
				mPermissao.setId_Permissao(mResultSet.getInt("id_Permissao"));
				mPermissao.setPermissao(mResultSet.getString("permissao"));
				listaPermissoes.add(mPermissao);
			}
		}catch(SQLException sqle) {
			System.out.println("Listar todas Permissoes ERROR: "+sqle.getMessage());
			listaPermissoes =  null;
		}
		return listaPermissoes;
	}
}
