public class Resolucao {

    private int margem;
    private int largura;
    private String texto;
    private String painel;

    public Resolucao(int margem, int largura, String texto) {
        this.margem = margem;
        this.largura = largura;
        this.texto = texto;
    }

    public String constroiLinhaHorizontal() {
        String margemHorizontal = "";
        for(int i = 0; i < largura; i++) {
            margemHorizontal = margemHorizontal + "#";
        }
        return margemHorizontal;
    }

    private int calculaEspacosEmBranco() {
        return largura - 2;
    }

    public String constroiMargemVertical() {
        String espacosEmBranco = "";
        for (int i = 0; i < calculaEspacosEmBranco(); i++) {
            espacosEmBranco = espacosEmBranco + " ";
        }
        return "#" + espacosEmBranco + "#";
    }

    public String constroiMargemHorizontal() {
        String margemVertical = "";
        for (int i = 0; i < margem; i++) {
            margemVertical = margemVertical + " ";
        }
        return margemVertical;
    }

    public int calculaEspacoImprimivel() {
        return largura -2 * margem - 2;
    }

    public Boolean verificaQuebratexto() {
        if (texto.length() > calculaEspacoImprimivel()) {
            return true;
        } else return false;
    }

    public void imprimeLetreiroSemQuebra() {
        Boolean quebraTexto = verificaQuebratexto();
        String letreiro;
        int ultimoCaracterPossivel = calculaEspacoImprimivel();
        int i = 0;
        while (quebraTexto) {
            letreiro = "#" + constroiMargemHorizontal() + texto.substring(i, ultimoCaracterPossivel)
                    + constroiMargemHorizontal() + "#";
            System.out.println(letreiro);
            i = ultimoCaracterPossivel;
            ultimoCaracterPossivel *= 2;
            if (i >= texto.length()) {
                quebraTexto = false;
            }
        }
    }

    private void imprimeLetreiroNaMesmaLinha() {
        System.out.println("#" + constroiMargemHorizontal() + texto.substring(0, texto.length())
                + constroiMargemHorizontal() + "#");
    }

    public int calculaRestanteCaracteres() {
        return texto.length() /calculaEspacoImprimivel();
    }





    public void junta() {
        System.out.println(constroiLinhaHorizontal());
        System.out.println(constroiMargemVertical());
        if (texto.length() % calculaEspacoImprimivel() == 0) {
            imprimeLetreiroSemQuebra();
        }
        if (texto.length() <= calculaEspacoImprimivel()) {
            imprimeLetreiroNaMesmaLinha();
        }
        System.out.println(constroiMargemVertical());
        System.out.println(constroiLinhaHorizontal());
    }


}
