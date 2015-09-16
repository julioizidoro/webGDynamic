/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.dao;

import br.com.lojaodoalemao.connection.ConectionFactory;
import br.com.lojaodoalemao.model.Fornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class FornecedorDao {

    private EntityManager manager;

    public List<Fornecedor> consultarFornecedor() throws SQLException {
        manager = ConectionFactory.getConnection();;
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f order by f.nomeFantasia");
        listaFornecedor = q.getResultList();
        manager.close();
        return listaFornecedor;
    }

    public Fornecedor consultarFornecedor(int idFornecedor) throws SQLException {
        manager = ConectionFactory.getConnection();;
        Fornecedor fornecedor = new Fornecedor();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f where f.idfornecedor=" + idFornecedor);
        if (q.getResultList().size() > 0) {
            fornecedor = (Fornecedor) q.getSingleResult();
        }
        manager.close();
        return fornecedor;
    }

    public List<Fornecedor> consultarFornecedorRazaoSocial(String razaoSocial, String nomeFantasia) throws SQLException {
        manager = ConectionFactory.getConnection();;
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f WHERE f.razaoSocial Like '" + razaoSocial + "%' or f.nomeFantasia Like '%" + nomeFantasia + "%' order by f.razaoSocial");
        listaFornecedor = q.getResultList();
        manager.close();
        return listaFornecedor;
    }

    public Fornecedor consultarCNPJ(String cnpj) throws Exception {
        manager = ConectionFactory.getConnection();;
        Fornecedor fornecedor = new Fornecedor();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f WHERE f.cnpj='" + cnpj + "'");
        if (q.getResultList().size() > 0) {
            fornecedor = (Fornecedor) q.getResultList().get(0);
        }
        manager.close();
        return fornecedor;
    }

    public Fornecedor salvarFronecedor(Fornecedor fornecedor) throws Exception {
        manager = ConectionFactory.getConnection();;
        //abrindo uma transação
        manager.getTransaction().begin();
        fornecedor = manager.merge(fornecedor);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return fornecedor;
    }

    public void excluir(Fornecedor fornecedor) throws Exception {
        manager = ConectionFactory.getConnection();;
        //abrindo uma transação
        manager.getTransaction().begin();
        fornecedor = manager.find(Fornecedor.class, fornecedor.getIdfornecedor());
        manager.remove(fornecedor);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
    }

    public int getIdFornecedor() throws Exception {
        manager = ConectionFactory.getConnection();;
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idfornecedor) From fornecedor");
        int idFornecedor = (Integer) q.getSingleResult();
        manager.close();
        return idFornecedor;
    }
}
