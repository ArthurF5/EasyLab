package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Laboratorio;
import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;

public class UnidadeLaboratorioPersist {
	ConexaoMySQL mConexaoMySQL;
	public Integer retornaID(UnidadeLaboratorio mUnidadeLaboratorio, Laboratorio mLaboratorio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT id_UnidadeLaboratorio FROM unidadeLaboratorio WHERE id_Laboratorio = "+mLaboratorio.getId_Laboratorio()+" AND endereco LIKE '"+mUnidadeLaboratorio.getLogradouro()+"'";
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
	
	public Integer cadastrar(UnidadeLaboratorio mUnidadeLaboratorio, Laboratorio mLaboratorio) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO unidadeLaboratorio(logradouro, complemento, numero, id_Cidade, id_Laboratorio) VALUES(?, ?, ?, ?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, mUnidadeLaboratorio.getLogradouro());
				mPreparedStatement.setString(2, mUnidadeLaboratorio.getComplemento());
				mPreparedStatement.setString(3, mUnidadeLaboratorio.getNumero());
				mPreparedStatement.setInt(4, mUnidadeLaboratorio.getCidade().getId_Cidade());
				mPreparedStatement.setInt(5, mUnidadeLaboratorio.getCidade().getEstado().getId_Estado());
				mPreparedStatement.executeQuery();
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
	
	public Integer alterar() {
		Integer retorno = 0;
		
		return retorno;
	}
	
	public Integer excluir() {
		Integer retorno = 0;
		
		return retorno;
	}
	
	public UnidadeLaboratorio consultar() {
		UnidadeLaboratorio mUnidadeLaboratorio = null;
		
		return mUnidadeLaboratorio;
	}
	
	public ArrayList<UnidadeLaboratorio> listarTodos(){
		ArrayList<UnidadeLaboratorio> listaUnidades = new ArrayList<UnidadeLaboratorio>();
		
		return listaUnidades;
	}
	
}
