/**
 * A classe TratarArgumentos é responsável por processar argumentos de linha de comando e tratar a população inicial
 * para a simulação do jogo da vida. Ela fornece métodos para tratar erros de argumentos, formatar a população inicial
 * e converter essa formatação em uma matriz 2D de células.
 */
public class TratarArgumentos {
    /**
     * Converte uma string de população inicial formatada em uma matriz 2D de células.
     *
     * @param populacaoInicial A string representando a população inicial.
     * @param linhas           O número de linhas da matriz.
     * @param colunas          O número de colunas da matriz.
     * @return Uma matriz 2D de células representando a população inicial.
     */
    public static int[][] converterPopulacao(String populacaoInicial, int linhas, int colunas) {
        String[] populacaoFormatada = populacaoInicial.split("#");
        int[][] populacao = new int[linhas][colunas];

        for (int i = 0; i < populacaoFormatada.length && i < linhas; i++) {
            String valorAtual = populacaoFormatada[i];

            for (int j = 0; j < Math.min(valorAtual.length(), colunas); j++) {
                int value = Character.getNumericValue(valorAtual.charAt(j));
                if (value == -1) {
                    System.out.print("Erro.");
                }
                populacao[i][j] = value;
            }
        }
        return populacao;
    }
}