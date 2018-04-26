package com.moliveiralucas.EasyLab.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moliveiralucas.EasyLab.connect.ConexaoMySQL;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.util.Util;

public class UsuarioPersist {
	ConexaoMySQL mConexaoMySQL;
	
	public Integer returnID(Usuario usuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT id_Usuario FROM usuario WHERE usuario LIKE '"+usuario.getUsuario()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				retorno = mResultSet.getInt("id_Usuario");
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return retorno;
	}
	
	public Integer cadastrar(Usuario usuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM usuario WHERE usuario = '"+usuario.getUsuario()+"'";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(!mResultSet.next()) {
				sql = "INSERT INTO usuario(usuario, email, senha) VALUES(?, ?, ?)";
				mPreparedStatement = mConnection.prepareStatement(sql);
				mPreparedStatement.setString(1, usuario.getUsuario());
				mPreparedStatement.setString(2, usuario.getEmail());
				String password = Util.toSHA1(usuario.getUsuario() + usuario.getSenha());
				mPreparedStatement.setString(3, password);
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
	
	public Integer alterar(Usuario usuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "";
		try {
			sql = "UPDATE usuario SET email = ?, senha = ? WHERE id_Usuario = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setString(1, usuario.getEmail());
			String password = Util.toSHA1(usuario.getUsuario() + usuario.getSenha());
			mPreparedStatement.setString(2, password);
			mPreparedStatement.setInt(3, usuario.getId_Usuario());
			mPreparedStatement.executeUpdate();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Integer excluir(Usuario usuario) {
		Integer retorno = 0;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		PreparedStatement mPreparedStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "DELETE FROM usuario WHERE id_Usuario = ?";
			mPreparedStatement = mConnection.prepareStatement(sql);
			mPreparedStatement.setInt(1, usuario.getId_Usuario());
			mPreparedStatement.execute();
			mPreparedStatement.close();
			retorno = 1;
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			retorno = 3;
		}
		return retorno;
	}
	
	public Usuario consultar (String parametroBusca){
		Usuario mUsuario = null;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		try {
			String sql = "SELECT * FROM usuario WHERE usuario = '"+parametroBusca+"'";
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			if(mResultSet.next()) {
				mUsuario = new Usuario();
				mUsuario.setId_Usuario(mResultSet.getInt("id_Usuario"));
				mUsuario.setUsuario(mResultSet.getString("usuario"));
				mUsuario.setEmail(mResultSet.getString("email"));
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
		}
		return mUsuario;
	}
	
	public ArrayList<Usuario> listarTodos(String parametroBusca){
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		Usuario mUsuario;
		mConexaoMySQL = new ConexaoMySQL();
		Connection mConnection = null;
		ResultSet mResultSet = null;
		Statement mStatement = null;
		mConnection = mConexaoMySQL.abreConexaoBD();
		String sql = "SELECT * FROM usuario WHERE usuario = '"+parametroBusca+"%' ORDER BY usuario";
		try {
			mStatement = mConnection.createStatement();
			mResultSet = mStatement.executeQuery(sql);
			while(mResultSet.next()) {
				mUsuario = new Usuario();
				mUsuario.setId_Usuario(mResultSet.getInt("id_Usuario"));
				mUsuario.setUsuario(mResultSet.getString("usuario"));
				mUsuario.setEmail(mResultSet.getString("email"));
				
				listaUsuario.add(mUsuario);
			}
		}catch(SQLException sqle) {
			System.out.println(""+sqle.getMessage());
			listaUsuario = null;
		}
		return listaUsuario;
	}
}
