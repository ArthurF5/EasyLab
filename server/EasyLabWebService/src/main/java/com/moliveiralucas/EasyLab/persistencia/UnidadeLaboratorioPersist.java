package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Cidade;
import com.moliveiralucas.EasyLab.model.Laboratorio;
import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;

public class UnidadeLaboratorioPersist {
	ConexaoMySQL mConexaoMySQL;
	public Integer retornaID(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT id_UnidadeLaboratorio FROM unidadeLaboratorio WHERE id_Laboratorio = "+mUnidadeLaboratorio.getLaboratorio().getId_Laboratorio()+" AND endereco LIKE '"+mUnidadeLaboratorio.getLogradouro()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("id_UnidadeLaboratorio");
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return retorno;
	}
	
	public Integer cadastrar(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM unidadeLaboratorio WHERE nomeUnidade = '"+mUnidadeLaboratorio.getNomeUnidade()+"'";
//		if(!mUnidadeLaboratorio.getComplemento().equals("")) {
//			
//		}
//		if(!mUnidadeLaboratorio.getNumero().equals("")) {
//			
//		}
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO unidadeLaboratorio(nomeUnidade, logradouro, complemento, numero, id_Cidade, id_Laboratorio) VALUES(?, ?, ?, ?, ?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, mUnidadeLaboratorio.getNomeUnidade());
				mPreparedStatement.setString(2, mUnidadeLaboratorio.getLogradouro());
				mPreparedStatement.setString(3, mUnidadeLaboratorio.getComplemento());
				mPreparedStatement.setString(4, mUnidadeLaboratorio.getNumero());
				mPreparedStatement.setInt(5, mUnidadeLaboratorio.getCidade().getId_Cidade());
				mPreparedStatement.setInt(6, mUnidadeLaboratorio.getLaboratorio().getId_Laboratorio());
				mPreparedStatement.executeUpdate();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println("Cadastro de UnidadeLaboratorio ERROR: ");
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer alterar(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
//		if(!mUnidadeLaboratorio.getComplemento().equals("")) {
//			
//		}
//		if(!mUnidadeLaboratorio.getNumero().equals("")) {
//			
//		}
		try {
			String sql = "UPDATE unidadeLaboratorio SET nomeUnidade = ?, logradouro = ?, complemento = ?, numero = ? WHERE id_UnidadeLaboratorio = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, mUnidadeLaboratorio.getNomeUnidade());
			mPreparedStatement.setString(2, mUnidadeLaboratorio.getLogradouro());
			mPreparedStatement.setString(3, mUnidadeLaboratorio.getComplemento());
			mPreparedStatement.setString(4, mUnidadeLaboratorio.getNumero());
			mPreparedStatement.setInt(5, mUnidadeLaboratorio.getId_UnidadeLaboratorio());
			mPreparedStatement.executeQuery();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer excluir(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM unidadeLaboratorio WHERE id_UnidadeLaboratorio = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, mUnidadeLaboratorio.getId_UnidadeLaboratorio());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public UnidadeLaboratorio consultar(String parametroBusca) {
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement= null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM unidadeLaboratorio WHERE nomeUnidade = '"+parametroBusca+"%' ORDER BY nomeUnidade";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mUnidadeLaboratorio.setId_UnidadeLaboratorio(mResultSet.getInt("id_UnidadeLaboratorio"));
				mUnidadeLaboratorio.setNomeUnidade(mResultSet.getString("nomeUnidade"));
				mUnidadeLaboratorio.setLogradouro(mResultSet.getString("logradouro"));
				mUnidadeLaboratorio.setComplemento(mResultSet.getString("complemento"));
				mUnidadeLaboratorio.setNumero(mResultSet.getString("numero"));
				
				Cidade mCidade = new Cidade();
				mCidade.setId_Cidade(mResultSet.getInt("id_Cidade"));
				mUnidadeLaboratorio.setCidade(mCidade);
				
				Laboratorio mLaboratorio = new Laboratorio();
				mLaboratorio.setId_Laboratorio(mResultSet.getInt("id_Laboratorio"));
				mUnidadeLaboratorio.setLaboratorio(mLaboratorio);
				
			}else {
				mUnidadeLaboratorio = null;
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			mUnidadeLaboratorio = null;
		}
		return mUnidadeLaboratorio;
	}
	
	public ArrayList<UnidadeLaboratorio> listarTodos(String parametroBusca){
		ArrayList<UnidadeLaboratorio> listaUnidades = new ArrayList<UnidadeLaboratorio>();
		UnidadeLaboratorio mUnidadeLaboratorio;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM unidadeLaboratorio WHERE nomeLaboratorio = '"+parametroBusca+"%' ORDER BY nomeLaboratorio";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mUnidadeLaboratorio = new UnidadeLaboratorio();
				mUnidadeLaboratorio.setId_UnidadeLaboratorio(mResultSet.getInt("id_UnidadeLaboratorio"));
				mUnidadeLaboratorio.setNomeUnidade(mResultSet.getString("nomeUnidade"));
				mUnidadeLaboratorio.setLogradouro(mResultSet.getString("logradouro"));
				mUnidadeLaboratorio.setComplemento(mResultSet.getString("complemento"));
				mUnidadeLaboratorio.setNumero(mResultSet.getString("numero"));
				
				Cidade mCidade = new Cidade();
				mCidade.setId_Cidade(mResultSet.getInt("id_Cidade"));
				mUnidadeLaboratorio.setCidade(mCidade);
				
				Laboratorio mLaboratorio = new Laboratorio();
				mLaboratorio.setId_Laboratorio(mResultSet.getInt("id_Laboratorio"));
				mUnidadeLaboratorio.setLaboratorio(mLaboratorio);
				
				listaUnidades.add(mUnidadeLaboratorio);
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			listaUnidades = null;
		}
		return listaUnidades;
	}
	
}
