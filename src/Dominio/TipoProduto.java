package Dominio;

public enum TipoProduto {
    PRODUTO_NAO_PERECIVEL( 1),
    PRODUTO_PERECIVEL_FRIO(2),
    PRODUTO_PERECIVEL(3);

    private int cod;
    private String desc;

    TipoProduto(int cod) {
        this.cod = cod;

    }

    public static TipoProduto ProdutoCadastrado(int tipo) {
        for (TipoProduto t : values()) {
            // Agora sim: compara o código do elemento atual com o número digitado!
            if (t.getCod() == t.cod) {
                return t;
            }
        }
        return null;
    }


    public int getCod() {
        return cod;
    }

}



