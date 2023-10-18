package persistence;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import data.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    DBConnection db = new DBConnection();
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        
        String sql = "INSERT INTO tb_produtos VALUES(default, ?, ?, ?)";
        
        if(db.connect()){
            try{
                ps = db.getConn().prepareStatement(sql);
                ps.setString(1, produto.getNome());
                ps.setInt(2, produto.getValor());
                ps.setString(3, produto.getStatus());
                ps.execute();
                
                return true;
            }catch(SQLException e){
            
            }finally{
                db.disconnect();
            }
        }
        
        return false;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

