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

    public void imprimeMargemVertical() {
        for (int i = 0; i < margem; i++) {
            System.out.println(constroiMargemVertical());
        }
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

    public void imprimeLetreiroComQuebra() {
        Boolean quebraTexto = verificaQuebratexto();
        String letreiro;
        int ultimoCaracterPossivel = calculaEspacoImprimivel();
        int i = 0;
        while (quebraTexto) {
            letreiro = "#" + constroiMargemHorizontal() + texto.substring(i, ultimoCaracterPossivel)
                    + constroiMargemHorizontal() + "#";
            System.out.println(letreiro);
            i = ultimoCaracterPossivel;
            ultimoCaracterPossivel  += calculaEspacoImprimivel();
            if (i >= texto.length()) {
                quebraTexto = false;
            }
        }
    }

    private void imprimeLetreiroNaMesmaLinha() {
        System.out.println("#" + constroiMargemHorizontal() + texto.substring(0, texto.length())
                + constroiMargemHorizontal() + "#");
    }

    public int encontraIndexRestanteCaracteres() {
        boolean encontrouFim = false;
        int indexQuebra = 0;
        while (!encontrouFim) {
            if (indexQuebra > texto.length()) {
                encontrouFim = true;
            } else {
                indexQuebra += calculaEspacoImprimivel();
            }
        }
        return indexQuebra - calculaEspacoImprimivel();
    }

    private int calculaEspacosFaltantes() {
        return calculaEspacoImprimivel() - texto.substring(encontraIndexRestanteCaracteres(), texto.length()).length();
    }

    private String constroiEspacosFaltantes() {
        String espacosFaltantes = "";
        for (int i = 0; i < calculaEspacosFaltantes(); i++) {
            espacosFaltantes = espacosFaltantes + " ";
        }
        return espacosFaltantes;
    }

    private void imprimeLetreiroSemQuebra() {
        Boolean quebraTexto = verificaQuebratexto();
        String letreiro;
        int ultimoCaracterPossivel = calculaEspacoImprimivel();
        int i = 0;
        while (quebraTexto) {
            letreiro = "#" + constroiMargemHorizontal() + texto.substring(i, ultimoCaracterPossivel)
                    + constroiMargemHorizontal() + "#";
            System.out.println(letreiro);
            i = ultimoCaracterPossivel;
            ultimoCaracterPossivel += calculaEspacoImprimivel();
            if (ultimoCaracterPossivel > texto.length()) {
                quebraTexto = false;
            }
        }
        System.out.println("#" + constroiMargemHorizontal() + texto.substring(encontraIndexRestanteCaracteres(),
                texto.length()) + constroiEspacosFaltantes() + constroiMargemHorizontal() + "#");
    }

    public void imprimePainel() {
        System.out.println(constroiLinhaHorizontal());
        imprimeMargemVertical();
        if (texto.length() % calculaEspacoImprimivel() == 0 && texto.length() > calculaEspacoImprimivel()) {
            imprimeLetreiroComQuebra();
        } else if (texto.length() <= calculaEspacoImprimivel()) {
            imprimeLetreiroNaMesmaLinha();
        } else {
            imprimeLetreiroSemQuebra();
        }
        imprimeMargemVertical();
        System.out.println(constroiLinhaHorizontal());
    }




}
