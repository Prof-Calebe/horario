/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.persistence;

import br.edu.horario.models.Disciplina;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class DisciplinaManager {
    
    private SQLiteManager db = null;
    
    public DisciplinaManager(){
        try{
            db = new SQLiteManager();
        }catch(Exception ex){
            System.out.println("Could not instantiate database:"+ex.getMessage());
        }
    }
    
    public void add(Disciplina disciplina){
        String sql = "INSERT INTO "+SQLiteManager.TABLE_NAME_DISCIPLINA+ " VALUES"
                + "("+disciplina.getNome()+")";
        try{
            db.insertNewRow(sql);
        }catch(Exception ex){
            System.out.println("Could not insert row:"+ex.getMessage());
        }
    }
    
    public ArrayList<Disciplina> getAll(){
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        try{
            ResultSet rs = db.selectAllFromTable(SQLiteManager.TABLE_NAME_DISCIPLINA);
            while(rs.next()){
                disciplinas.add(new Disciplina(rs.getInt(1), rs.getString(2)));
            }
        }catch(Exception ex){
            System.out.println("Error while retrieving data:"+ex.getMessage());
        }
        return disciplinas;
    }
}
