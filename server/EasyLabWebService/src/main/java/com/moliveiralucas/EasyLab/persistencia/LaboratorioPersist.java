package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Laboratorio;

public class LaboratorioPersist {
	ConexaoMySQL mConexaoMySQL;
	/**
	 * Retorna o ID de um Laboratorio
	 * @param lab - Objeto do tipo Laboratorio
	 * @return - ID Inteiro de um laboratorio
	 */
	public Integer retornaID(Laboratorio lab) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT labID FROM laboratorio WHERE laboratorio LIKE '"+lab.getLaboratorio()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("labID");
			}
		}catch(SQLException e) {
			System.out.println("RetornaID Laboratorio ERRO: "+e.getMessage());
		}
		return retorno;
	}

	public String buscaPorID(Integer id) {
		String retorno = "";
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT laboratorio FROM laboratorio WHERE labID = "+id;
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getString("laboratorio");
			}
		} catch (SQLException e) {
			System.out.println("Busca por laboratorio por ID ERROR: "+e.getMessage());
		}
		return retorno;
	}
	/**
	 * Inclui um novo laboratorio no DB
	 * @param lab - Objeto do tipo Laboratorio
	 * @return 	1 - Cadastrado com Sucesso! 
	 * 			2 - Ja possui cadastro com o nome informado
	 * 			3 - Houve um erro ao cadastrar no banco verificar log
	 */
	public Integer cadastrar(Laboratorio lab) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM laboratorio WHERE laboratorio LIKE '"+lab.getLaboratorio()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO laboratorio(laboratorio) VALUES (?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, lab.getLaboratorio());
				mPreparedStatement.executeUpdate();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException e) {
			System.out.println("Incluir Laboratorio ERRO: "+e.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	/**
	 * Altera os dados cadastrados no banco de um determinado laboratorio
	 * @param lab
	 * @return True / False
	 */
	public boolean alterar(Laboratorio lab) {
		Boolean retorno = false;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "";
		try {
			sql = "UPDATE laboratorio SET laboratorio = ? WHERE labID = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, lab.getLaboratorio());
			mPreparedStatement.setInt(2, lab.getId_Laboratorio());
			mPreparedStatement.executeUpdate();
			mPreparedStatement.close();
			retorno = true;
		}catch(SQLException e) {
			System.out.println("Alterar Laboratorio ERRO: "+e.getMessage());
		}
		return retorno;
	}
	/**
	 * Exclui um Laboratorio 
	 * @param lab
	 * @return 	1 - Excluido com Sucesso 
	 * 			2 - Houve um erro ao excluir no banco verificar log
	 */
	public Integer excluir(Integer id) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "";
		try {
			sql = "DELETE FROM laboratorio WHERE labID = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, id);
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException e) {
			System.out.println("Excluir Laboratorio ERRO: "+e.getMessage());
			retorno = 2;
		}
		return retorno;
	}
	/**
	 * Realiza a busca por laboratorios 
	 * @param parametroBusca
	 * @return Lista de laboratorios
	 */
	public ArrayList<Laboratorio> listarTodos(){
		ArrayList<Laboratorio> laboratorio = new ArrayList<Laboratorio>();
		Laboratorio mLaboratorio;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM laboratorio ORDER BY laboratorio";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mLaboratorio = new Laboratorio();
				mLaboratorio.setId_Laboratorio(mResultSet.getInt("labID"));
				mLaboratorio.setLaboratorio(mResultSet.getString("laboratorio"));
				laboratorio.add(mLaboratorio);
			}
		}catch (SQLException e) {
			System.out.println("Listar laboratorios ERRO: "+e.getMessage());
			laboratorio = null;
		}
		return laboratorio;
	}
	
	/**
	 * 
	 * @param parametroBusca
	 * @return
	 */
	public Laboratorio consultar(String parametroBusca) {
		Laboratorio mLaboratorio = new Laboratorio();
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM laboratorio WHERE laboratorio = '"+parametroBusca+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mLaboratorio.setId_Laboratorio(mResultSet.getInt("id_laboratorio"));
				mLaboratorio.setLaboratorio(mResultSet.getString("laboratorio"));
			}else {
				mLaboratorio = null;
			}
		}catch(SQLException sqle) {
			System.out.println("Consultar Laboratorio ERROR: "+sqle.getMessage());
			mLaboratorio = null;
		}
		return mLaboratorio;
	}
}
