import java.util.Random;

/**
 * A classe ValidarParametros é responsável por validar e processar os argumentos de linha de comando
 * fornecidos para a simulação do "Jogo da Vida". Ela também define uma classe interna ParametrosValidados
 * para armazenar os parâmetros validados.
 */
public class ValidarParametros {
    /**
     * Classe interna que armazena os parâmetros validados.
     */
    public static class ParametrosValidados {
        public int colunas;
        public int linhas;
        public int geracoes;
        public int velocidade;
        public String populacaoInicial;

        /**
         * Construtor da classe ParametrosValidados.
         *
         * @param colunas          O número de colunas na matriz.
         * @param linhas           O número de linhas na matriz.
         * @param geracoes         O número de gerações a serem simuladas.
         * @param velocidade       O intervalo de tempo entre as gerações.
         * @param populacaoInicial A configuração inicial da população de células.
         */
        public ParametrosValidados(int colunas, int linhas, int geracoes, int velocidade, String populacaoInicial) {
            this.colunas = colunas;
            this.linhas = linhas;
            this.geracoes = geracoes;
            this.velocidade = velocidade;
            this.populacaoInicial = populacaoInicial;
        }

        public void exibirParametros() {
            System.out.println("\uD83E\uDE90 Bem-vindo(a) ao Jogo da vida! \uD83D\uDE80\n");
            System.out.println("Dados inseridos:");
            System.out.println("\nColunas = " + this.colunas);
            System.out.println("Linhas = " + this.linhas);
            System.out.println("Gerações = " + this.geracoes);
            System.out.println("Velocidade = " + this.velocidade);
            System.out.println("População inicial = " + this.populacaoInicial);
        }
    }

    /**
     * Valida os argumentos de linha de comando e retorna um
     * objeto ParametrosValidados contendo os parâmetros validados.
     * Caso o usuário não forneça os parâmetros, o jogo é iniciado
     * com valores gerados aleatoriamente ou já definidos.
     *
     * @param args Os argumentos de linha de comando passados ao programa.
     * @return Um objeto ParametrosValidados contendo os parâmetros validados.
     */
    public static ParametrosValidados validar(String[] args) {
        int colunas = (args.length >= 1) ? parseInteger(args[0]) : GerarValoresRandom.getRandomValue();
        int linhas = (args.length >= 2) ? parseInteger(args[1]) : GerarValoresRandom.getRandomValue();
        int geracoes = (args.length >= 3) ? parseInteger(args[2]) : 10;
        int velocidade = (args.length >= 4) ? parseInteger(args[3]) : 1000;
        String populacaoInicial = (args.length >= 5) ? args[4] : GerarValoresRandom.gerarPopulacaoRandom(colunas, linhas);

        return new ParametrosValidados(colunas, linhas, geracoes, velocidade, populacaoInicial);
    }

    /**
     * Converte uma string em um valor inteiro. Se a conversão falhar, retorna 0.
     *
     * @param value A string a ser convertida em um valor inteiro.
     * @return O valor inteiro convertido ou 0 se a conversão falhar.
     */
    private static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
