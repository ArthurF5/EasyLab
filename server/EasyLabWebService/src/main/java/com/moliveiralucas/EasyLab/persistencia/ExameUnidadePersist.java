package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Convenio;
import com.moliveiralucas.EasyLab.model.Exame;
import com.moliveiralucas.EasyLab.model.ExameUnidade;
import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;

public class ExameUnidadePersist {
	ConexaoMySQL mConexaoMySQL;

	public Integer retornaID(ExameUnidade mExameUnidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT id_exameUnidade FROM exameUnidade WHERE id_Exame = "+mExameUnidade.getExame().getId_Exame()+" AND id_UnidadeLaboratorio = "+mExameUnidade.getUnidadeLaboratorio().getId_UnidadeLaboratorio();
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("id_exameUnidade");
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}

	public Integer cadastrar(ExameUnidade mExameUnidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM exameUnidade WHERE id_Exame = "+mExameUnidade.getExame().getId_Exame()+" AND id_UnidadeLaboratorio = "+mExameUnidade.getUnidadeLaboratorio().getId_UnidadeLaboratorio();
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO exameUnidade(id_Exame, id_UnidadeLaboratorio, id_Convenio, valor) VALUES(?, ?, ?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setInt(1, mExameUnidade.getExame().getId_Exame());
				mPreparedStatement.setInt(2, mExameUnidade.getUnidadeLaboratorio().getId_UnidadeLaboratorio());
				mPreparedStatement.setInt(3, mExameUnidade.getConvenio().getId_Convenio());
				mPreparedStatement.setDouble(4, mExameUnidade.getValor());
				mPreparedStatement.executeUpdate();
				mPreparedStatement.close();
				retorno = 1;
			}else {
				retorno = 2;
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return retorno;
	}

	public Integer alterar(ExameUnidade mExameUnidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "UPDATE exameUnidade SET valor = ?,  ";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setDouble(1, mExameUnidade.getValor());
			mPreparedStatement.setInt(2, mExameUnidade.getConvenio().getId_Convenio());
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return retorno;
	}

	public Integer excluir(ExameUnidade mExameUnidade) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM exameUnidade WHERE id_exameUnidade = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, mExameUnidade.getId_ExameUnidade());
			mPreparedStatement.executeQuery();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}

	public ArrayList<ExameUnidade> consultarExamePorUnidade(ArrayList<Exame> mExame) {
		ArrayList<ExameUnidade> mListaExameUnidade = new ArrayList<ExameUnidade>();
		ExameUnidade mExameUnidade;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		for(Integer i =0; i< mExame.size(); i++) {
			String sql = "SELECT * FROM exameUnidade WHERE id_Exame = "+mExame.get(i).getId_Exame();
			try {
				mStatement = mConnection.createStatement();
				mResultSet = mStatement.executeQuery(sql);
				while(mResultSet.next()) {
					mExameUnidade = new ExameUnidade();
					mExameUnidade.setId_ExameUnidade(mResultSet.getInt("id_exameUnidade"));

					Exame exame = new Exame();
					exame.setId_Exame(mResultSet.getInt("id_Exame"));
					mExameUnidade.setExame(exame);

					UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
					mUnidadeLaboratorio.setId_UnidadeLaboratorio(mResultSet.getInt("id_UnidadeLaboratorio"));
					mExameUnidade.setUnidadeLaboratorio(mUnidadeLaboratorio);
					
					Convenio convenio = new Convenio();
					convenio.setId_Convenio(mResultSet.getInt("id_Convenio"));
					mExameUnidade.setConvenio(convenio);

					mExameUnidade.setValor(mResultSet.getDouble("valor"));

					mListaExameUnidade.add(mExameUnidade);
				}
			}catch(SQLException sqle) {
				System.out.println(""+sqle.getMessage());
				mListaExameUnidade = null;
			}
		}

		return mListaExameUnidade;
	}

	public ArrayList<ExameUnidade> listarTodos(String parametroBusca){
		ArrayList<ExameUnidade> mListaExameUnidade = new ArrayList<ExameUnidade>();
		ExameUnidade mExameUnidade;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM exameUnidade";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mExameUnidade = new ExameUnidade();
				mExameUnidade.setId_ExameUnidade(mResultSet.getInt("id_exameUnidade"));

				Exame exame = new Exame();
				exame.setId_Exame(mResultSet.getInt("id_Exame"));
				mExameUnidade.setExame(exame);

				UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
				mUnidadeLaboratorio.setId_UnidadeLaboratorio(mResultSet.getInt("id_UnidadeLaboratorio"));
				mExameUnidade.setUnidadeLaboratorio(mUnidadeLaboratorio);
				
				Convenio convenio = new Convenio();
				convenio.setId_Convenio(mResultSet.getInt("id_Convenio"));
				mExameUnidade.setConvenio(convenio);

				mExameUnidade.setValor(mResultSet.getDouble("valor"));

				mListaExameUnidade.add(mExameUnidade);
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return mListaExameUnidade;
	}
}
