/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojaodoalemao.facade;

import br.com.lojaodoalemao.dao.ForPedidoDao;
import br.com.lojaodoalemao.model.Forpedido;
import br.com.lojaodoalemao.model.Forpedproduto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wolverine
 */
public class ForPedidoFacade {

    private ForPedidoDao forPedidoDao;

    public Forpedido consultarForPedido(int idForPedido, int idEmpresa) {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.consultarForPedido(idForPedido, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   

    public List<Forpedido> consultarForPedido(String sql) {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.consultarForPedido(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Forpedido salvarForPedido(Forpedido forPedido) {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.salvarForPedido(forPedido);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void salvarForPedProduto(Forpedproduto forPedProduto) {
       forPedidoDao = new ForPedidoDao();
        try {
            forPedidoDao.salvarForPedProduto(forPedProduto);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirForPedProduto(Forpedproduto forPedProduto) {
        forPedidoDao = new ForPedidoDao();
        try {
            forPedidoDao.excluirForPedProduto(forPedProduto);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getIdPedido()  {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.getIdPedido();
        } catch (Exception ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido) {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.consultarForPedidoProduto(forPedido);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void excluirForPedido(Forpedido forPedido) {
        forPedidoDao = new ForPedidoDao();
        try {
            forPedidoDao.excluirForPedido(forPedido);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido, int tipo) {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.consultarForPedidoProduto(forPedido, tipo);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Forpedido> consultarForPedidoUltimo(int idFornecedor, int idEmpresa) {
        forPedidoDao = new ForPedidoDao();
        try {
            return forPedidoDao.consultarForPedidoUltimo(idFornecedor, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}