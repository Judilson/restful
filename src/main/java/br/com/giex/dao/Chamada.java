/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.dao;

import br.com.giex.conexao.ConectaMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjunior
 */
public class Chamada {

    public void insert(String nome, String metodo) {

        Connection conn = new ConectaMysql().conecta();
        PreparedStatement psmt = null;
        String query = "insert into giex.tb_chamada_rest (ukey, valor_chamada, metodo_chamada)"
                + " values (?,?,?)";

        try {

            UUID uuid = UUID.randomUUID();

            psmt = conn.prepareStatement(query);
            psmt.setString(1, uuid.toString());
            psmt.setString(2, nome);
            psmt.setString(3, metodo);

            psmt.execute();
            
            conn.commit();
            conn.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
