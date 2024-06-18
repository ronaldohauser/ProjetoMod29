package domain;

public class Produto {
    
    private Long id;
    private String nome;
    private String codigo;
    private Double valor;
    
    public Produto() {
        
    }

    public Produto(Long id, String nome, String codigo, Double valor) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
