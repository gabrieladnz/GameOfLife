import java.util.Random;

/**
 * A classe GerarValoresRandom é responsável por gerar valores
 * aleatórios para populações iniciais e outros parâmetros.
 */
public class GerarValoresRandom {

    /**
     * Gera uma população inicial aleatória no formato de string.
     *
     * @param colunas O número de colunas da população.
     * @param linhas  O número de linhas da população.
     * @return Uma string representando a população inicial gerada aleatoriamente.
     */
    public static String gerarPopulacaoRandom(int colunas, int linhas) {
        // StringBuilder permite criar e manipular Strings dinamicamente/modificáveis
        StringBuilder population = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                // Gera 0 ou 1 aleatoriamente
                population.append(random.nextInt(2));
            }
            if (i < linhas - 1) {
                // Adiciona separador entre as linhas
                population.append("#");
            }
        }
        // converte pra String novamente
        return population.toString();
    }

    /**
     * Gera um valor aleatório dentre os possíveis valores.
     *
     * @return Um valor aleatório entre 10, 20 e 40.
     */
    public static int getRandomValue() {
        int[] possibleValues = {10, 20, 40};
        Random random = new Random();
        return possibleValues[random.nextInt(possibleValues.length)];
    }
}