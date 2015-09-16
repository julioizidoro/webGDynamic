/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojaodoalemao.facade;

import br.com.lojaodoalemao.dao.FornecedorDao;
import br.com.lojaodoalemao.model.Fornecedor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wolverine
 */
public class FornecedorFacade {

    FornecedorDao fornecedorDao;

     public List<Fornecedor> consultarFornecedor() {
        fornecedorDao = new FornecedorDao();
        try {
            return fornecedorDao.consultarFornecedor();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Fornecedor consultarFornecedor(int idFornecedor) {
        fornecedorDao = new FornecedorDao();
        try {
            return fornecedorDao.consultarFornecedor(idFornecedor);
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Fornecedor> consultarFornecedorRazaoSocial(String razaoSocial, String nomeFantasia) {
        fornecedorDao = new FornecedorDao();
        try {
            return fornecedorDao.consultarFornecedorRazaoSocial(razaoSocial, nomeFantasia);
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Fornecedor consultarCNPJ(String cnpj){
        fornecedorDao = new FornecedorDao();
        try {
            return fornecedorDao.consultarCNPJ(cnpj);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Fornecedor salvarFronecedor(Fornecedor fornecedor) {
         fornecedorDao = new FornecedorDao();
        try {
            return fornecedorDao.salvarFronecedor(fornecedor);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void excluir(Fornecedor fornecedor){
         fornecedorDao = new FornecedorDao();
        try {
            fornecedorDao.excluir(fornecedor);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdFornecedor()  {
        fornecedorDao = new FornecedorDao();
        try {
            return fornecedorDao.getIdFornecedor();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}
