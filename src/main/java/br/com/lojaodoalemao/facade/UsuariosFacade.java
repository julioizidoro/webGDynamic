/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.facade;

import br.com.lojaodoalemao.dao.UsuariosDao;
import br.com.lojaodoalemao.model.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wolverine
 */
public class UsuariosFacade {
    
    UsuariosDao usuariosDao;
    
    public Usuarios consultarUsuario(String login, String senha) {
        usuariosDao = new UsuariosDao();
        try {
            return usuariosDao.consultarUsuario(login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Usuarios consultarUsuario(int idUsuario) {
        usuariosDao = new UsuariosDao();
        try {
            return usuariosDao.consultarUsuario(idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Usuarios salvarUsuario(Usuarios usuario) {
        usuariosDao = new UsuariosDao();
        try {
            return usuariosDao.salvarUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
