package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import dao.generic.jdbc.dao.ProdutoDAO;
import dao.generic.jdbc.dao.iProdutoDAO;
import domain.Produto;

public class ProdutoTest {
    
    private iProdutoDAO produtoDAO;
    
    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        
        produto.setCodigo("10");
        produto.setNome("Computador");
        produto.setValor(3500.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoDB = produtoDAO.buscar("10");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getValor(), produtoDB.getValor());
        
        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }
    
    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        
        produto.setCodigo("10");
        produto.setNome("Computador");
        produto.setValor(3500.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoDB = produtoDAO.buscar("10");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getValor(), produtoDB.getValor());
        
        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);    
    }
    
    @Test
    public void deleteTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        
        produto.setCodigo("10");
        produto.setNome("Computador");
        produto.setValor(3500.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoDB = produtoDAO.buscar("10");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getValor(), produto.getValor());
        
        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }
    
    @Test 
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();
    
        Produto p1 = new Produto();
        p1.setCodigo("10");
        p1.setNome("Computador");
        p1.setValor(3500.00);
        
        Produto p2 = new Produto();
        p2.setCodigo("20");
        p2.setNome("Celular");
        p2.setValor(1500.00);
        
        Integer count1 = produtoDAO.cadastrar(p1);
        Integer count2 = produtoDAO.cadastrar(p2);
        assertTrue(count1 == 1 && count2 == 1);
        
        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
        
        Integer delCount = 0;
        for (Produto produto : list) {
            produtoDAO.excluir(produto);
            delCount++;
        }
        
        assertTrue(delCount == 2);
        list = produtoDAO.buscarTodos();
        assertEquals(0, list.size());
    }
    
    @Test
    public void atualizarTest() throws Exception {
        
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        
        produto.setCodigo("10");
        produto.setNome("Computador");
        produto.setValor(3500.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoDB = produtoDAO.buscar("10");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getValor(), produtoDB.getValor());
        
        produtoDB.setCodigo("20");
        produtoDB.setNome("Notebook");
        produtoDB.setValor(3400.00);
        Integer countUpdate = produtoDAO.atualizar(produtoDB);
        assertTrue(countUpdate == 1);
        
        Produto produtoDB1 = produtoDAO.buscar("10");
        assertNull(produtoDB1);
        
        Produto produtoDB2 = produtoDAO.buscar("20");
        assertNotNull(produtoDB2);
        assertEquals(produtoDB2.getId(), produtoDB.getId());
        assertEquals(produtoDB2.getNome(), produtoDB.getNome());
        assertEquals(produtoDB2.getCodigo(), produtoDB.getCodigo());
        assertEquals(produtoDB2.getValor(), produtoDB.getValor());
        
        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
        
        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
        }
        
        list = produtoDAO.buscarTodos();
        assertTrue(list.size() == 0);
    }
}
