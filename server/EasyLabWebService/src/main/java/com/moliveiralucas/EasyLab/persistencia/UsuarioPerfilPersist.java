package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.model.UsuarioPerfil;

public class UsuarioPerfilPersist {
	ConexaoMySQL mConexaoMySQL;
	
	public Integer cadastrar(UsuarioPerfil mUsuarioPerfil) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		PreparedStatement mPreparedStatement = null;
		String sql = "SELECT * FROM usuarioPerfil WHERE id_PerfilUsuario = "+mUsuarioPerfil.getPerfilUsuario().getId_PerfilUsuario()+" AND id_Usuario = "+mUsuarioPerfil.getUsuario().getId_Usuario();
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO usuarioPerfil(id_PerfilUsuario, id_Usuario) VALUES(?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setInt(1, mUsuarioPerfil.getPerfilUsuario().getId_PerfilUsuario());
				mPreparedStatement.setInt(2, mUsuarioPerfil.getUsuario().getId_Usuario());
				mPreparedStatement.executeQuery();
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

	public UsuarioPerfil consultar(String parametroBusca) {
		UsuarioPerfil mUsuarioPerfil = new UsuarioPerfil();
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM usuarioPerfil WHERE id_Usuario =  AND id_PerfilUsuario = ";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mUsuarioPerfil.setId_UsuarioPerfil(mResultSet.getInt("id_UsuarioPerfil"));
				PerfilUsuario mPerfilUsuario = new PerfilUsuario();
				mPerfilUsuario.setId_PerfilUsuario(mResultSet.getInt("id_PerfilUsuario"));
				mUsuarioPerfil.setPerfilUsuario(mPerfilUsuario);
				
				Usuario mUsuario = new Usuario();
				mUsuario.setId_Usuario(mResultSet.getInt("id_Usuario"));
				mUsuarioPerfil.setUsuario(mUsuario);
			}else {
				mUsuarioPerfil = null;
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return mUsuarioPerfil;
	}
	
	public ArrayList<UsuarioPerfil> consultarUsuarios(PerfilUsuario mPerfilUsuario){
		ArrayList<UsuarioPerfil> listaUsuarioPerfil = new ArrayList<UsuarioPerfil>();
		
		return listaUsuarioPerfil;
	}

	public Integer excluir(UsuarioPerfil mUsuarioPerfil) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM usuarioPerfil WHERE id_UsuarioPerfil = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, mUsuarioPerfil.getId_UsuarioPerfil());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}

}
