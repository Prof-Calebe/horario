/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.persistence;

import java.sql.*;

/**
 *
 * @author guilherme
 */
public class SQLiteManager {
    public static final String TABLE_NAME_DISCIPLINA = "DISCIPLINA";
    public static final String TABLE_NAME_RESERVA = "RESERVA";
    private static Connection conn = null;
    
    public SQLiteManager() throws Exception{
        try{
            if(conn == null){
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
                createTableDisciplina();
                createTableReserva();
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            conn.close();
        }
    }
    
    
    private void createTableReserva() throws SQLException{
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS RESERVA " +
        "(ID INT PRIMARY KEY NOT NULL," +
        " FK_SALA INT NOT NULL, " + 
        " FK_HORARIO INT NOT NULL, " + 
        " FK_DISCIPLINA INT NOT NULL, " + 
        " FK_PROFESSOR INT NOT NULL)"; 
        stmt.executeUpdate(sql);
        stmt.close();
    }
    
    private void createTableDisciplina() throws SQLException{
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME_DISCIPLINA +
        "(ID INT PRIMARY KEY NOT NULL," +
        " NOME TEXT NOT NULL) ";
        stmt.executeUpdate(sql);
        stmt.close();
        insertNewRow("INSERT INTO +"+TABLE_NAME_DISCIPLINA+" VALUES(teste)");
    }
    
    public void insertNewRow(String sql) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
    
    public ResultSet selectAllFromTable(String table) throws SQLException{
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM "+table);
    }
}
