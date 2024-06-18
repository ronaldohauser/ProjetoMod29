package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import dao.generic.jdbc.dao.ClienteDAO;
import dao.generic.jdbc.dao.iClienteDAO;
import domain.Cliente;

public class ClienteTest {
    
    private iClienteDAO clienteDAO;
    
    @Test
    public void cadastrarTest() throws Exception {
        clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setCodigo("10");
        cliente.setNome("Douglas Oliveira");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);
        
        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());
        
        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue(countDel == 1);
    }
    
    @Test
    public void buscarTest() throws Exception {
        clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setCodigo("10");
        cliente.setNome("Douglas Oliveira");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);
        
        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());
        
        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue(countDel == 1);    
    }
    
    @Test
    public void deleteTest() throws Exception {
        clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setCodigo("10");
        cliente.setNome("Douglas Oliveira");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);
        
        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());
        
        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue(countDel == 1);
    }
    
    @Test 
    public void buscarTodosTest() throws Exception {
        clienteDAO = new ClienteDAO();
    
        Cliente c1 = new Cliente();
        c1.setCodigo("10");
        c1.setNome("Douglas Oliveira");
        
        Cliente c2 = new Cliente();
        c2.setCodigo("20");
        c2.setNome("Eduardo Oliveira");
        
        Integer count1 = clienteDAO.cadastrar(c1);
        Integer count2 = clienteDAO.cadastrar(c2);
        assertTrue(count1 == 1 && count2 == 1);
        
        List<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
        
        Integer delCount = 0;
        for (Cliente cliente : list) {
            clienteDAO.excluir(cliente);
            delCount++;
        }
        
        assertTrue(delCount == 2);
        list = clienteDAO.buscarTodos();
        assertEquals(0, list.size());
    }
    
    @Test
    public void atualizarTest() throws Exception {
        
        clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setCodigo("10");
        cliente.setNome("Douglas Oliveira");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);
        
        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());
        
        clienteDB.setCodigo("20");
        clienteDB.setNome("Outro nome");
        Integer countUpdate = clienteDAO.atualizar(clienteDB);
        assertTrue(countUpdate == 1);
        
        Cliente clienteDB1 = clienteDAO.buscar("10");
        assertNull(clienteDB1);
        
        Cliente clienteDB2 = clienteDAO.buscar("20");
        assertNotNull(clienteDB2);
        assertEquals(clienteDB2.getId(), clienteDB.getId());
        assertEquals(clienteDB2.getNome(), clienteDB.getNome());
        assertEquals(clienteDB2.getCodigo(), clienteDB.getCodigo());
        
        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue(countDel == 1);
        
        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
        }
        
        list = clienteDAO.buscarTodos();
        assertTrue(list.size() == 0);
    }
}
