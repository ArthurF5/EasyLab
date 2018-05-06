package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Permissao;
import com.moliveiralucas.EasyLab.model.PermissaoPerfil;

public class PermissaoPerfilPersist {
	ConexaoMySQL mConexaoMySQL;
	public Integer cadastrar(PermissaoPerfil mPermissaoPerfil) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "SELECT * FROM permissaoPerfil WHERE id_Permissao = "+mPermissaoPerfil.getPermissao().getId_Permissao()+" AND id_PerfilUsuario = "+mPermissaoPerfil.getPerfilUsuario().getId_PerfilUsuario();
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO permissaoPerfil(id_Permissao, id_PerfilUsuario) VALUES(?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setInt(1, mPermissaoPerfil.getPermissao().getId_Permissao());
				mPreparedStatement.setInt(2, mPermissaoPerfil.getId_permissaoPerfil());
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

	public Integer excluir(PermissaoPerfil mPermissaoPerfil) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM permissaoPerfil WHERE id_PermissaoPerfil = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, mPermissaoPerfil.getId_permissaoPerfil());
			mPreparedStatement.executeQuery();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}

	public PermissaoPerfil listarPermissoes(PerfilUsuario mPerfilUsuario){
		PermissaoPerfil mPermissaoPerfil = new PermissaoPerfil();
		ArrayList<Permissao> listaPermissao = new ArrayList<Permissao>();
		Permissao mPermissao;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "SELECT * FROM permissaoPerfil WHERE id_PerfilUsuario = "+mPerfilUsuario.getId_PerfilUsuario();
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mPermissaoPerfil.setId_permissaoPerfil(mResultSet.getInt("id_PermissaoPerfil"));
				mPermissaoPerfil.setPerfilUsuario(mPerfilUsuario);
				while(mResultSet.next()) {
					mPermissao = new Permissao();
					mPermissao.setId_Permissao(mResultSet.getInt("id_Permissao"));
					listaPermissao.add(mPermissao);
				}
				mPermissaoPerfil.setPermissoes(listaPermissao);
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			mPermissaoPerfil = null;
		}
		return mPermissaoPerfil;
	}
}
