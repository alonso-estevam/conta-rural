
public class ContaRuralLayout {
    
    public static void main(String[] args) {
        //https://receitasdecodigo.com.br/java/o-basico-sobre-java-string-format
        //https://www.javatpoint.com/java-string-format
        //https://www.baeldung.com/string/format
        //https://dzone.com/articles/java-string-format-examples
        //https://www.programiz.com/java-programming/library/string/format
​
        Double numero = 1234.56;
        //uma colinha para cep, telefone e cpf
        String numeroLayout = String.format("%010d",Integer.valueOf(numero.toString().replaceAll("\\.",""))) ;
        System.out.println(numeroLayout);
​
​
​
        LocalDate data = LocalDate.now();
        String dataLayout = data.toString().replaceAll("\\-","");
        System.out.println(dataLayout);
​
        String nomeCompleto = "Raimundo Nonato Loureiro Castelo Branco";
        String nomeLayout = nomeCompleto.substring(0,30).toUpperCase();
        System.out.println(nomeLayout);
​
        String nomePequeno = "rua das marias"; // precisa ser completado com espeços em branco
        //o sinal de - alinha o texto a esquerda
        String nomeCompletadoLayout = String.format("%-30s", nomePequeno);
        System.out.println(nomeCompletadoLayout.toUpperCase());
​
        String[] palavras = { "Gleyson Sampaio","Raimundo Nonato Loureiro Castelo Branco"}; // palavras com tamanho menor e maior que 30
​
        for(String palavra: palavras){
            String palavraFormatada = String.format("%-30.30s", palavra);
            System.out.println(palavraFormatada);
        }
        //criar objetos
        String linhaArquivoPosicional="20230316RUA DAS MARIAS                0000123456";
        //substring pega partes de uma String que representam atributos
​
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate campoData = LocalDate.parse(linhaArquivoPosicional.substring(0,8), formatter);//pegando 8 digitos da linha
        String logradouro = linhaArquivoPosicional.substring(8,38).trim();// veja o método trim
        Double valor = Double.valueOf(linhaArquivoPosicional.substring(38,48))/100;
​
        System.out.println("RESULTADO DOS CAMPOS DA LINHA POSICIONAL");
        System.out.println(campoData);
        System.out.println(logradouro);
        System.out.println(valor);
​
​
        String linhaArquivoDelimitadaPorPontVirgula="20230316;RUA DAS MARIAS;123456";//delimitado cria um array de strings
​
        String[] campos = linhaArquivoDelimitadaPorPontVirgula.split("\\;");
​
        campoData = LocalDate.parse(campos[0], formatter);//pegando 8 digitos da linha
        logradouro = campos[1].trim();// veja o método trim
        valor = Double.valueOf(campos[2])/100;
​
        System.out.println("RESULTADO DOS CAMPOS DA LINHA DELIMITADA");
        System.out.println(campoData);
        System.out.println(logradouro);
        System.out.println(valor);
​
    }

}
