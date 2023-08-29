public class Tabuleiro {
    /**
     * Simula a evolução da população em uma matriz 2D ao longo de várias gerações.
     *
     * @param linhas           Número de linhas da matriz.
     * @param colunas          Número de colunas da matriz.
     * @param geracoes         Número de gerações a serem simuladas.
     * @param velocidade       Velocidade de exibição em milissegundos entre as gerações.
     * @param populacaoInicial Representação da população inicial em forma de string.
     */
    public static void criarMatriz(int linhas, int colunas, int geracoes, int velocidade, String populacaoInicial) {
        // Inicializa a matriz com base no tamanho especificado
        int[][] matriz = new int[linhas][colunas];

        // Converte a população inicial em uma matriz de células
        int[][] populacao = TratarArgumentos.converterPopulacao(populacaoInicial, linhas, colunas);

        // Copia a população inicial para a matriz.
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = populacao[i][j];
            }
        }

        // Loop de simulação das gerações.
        for (int g = 0; g < geracoes; g++) {
            System.out.println("\nGeração " + (g + 1) + ":");

            // Conta a população viva na matriz atual
            int populacaoViva = AplicarRegras.contarPopulacaoViva(matriz);
            System.out.println("População viva: " + populacaoViva + "\n");

            exibirMatriz(matriz);

            // Cria uma nova matriz pra armazenar a próxima geração
            int[][] novaMatriz = new int[linhas][colunas];

            // Aplica regras de evolução para cada célula na matriz atual
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    int vizinhosVivos = AplicarRegras.checarEstado(matriz, i, j);

                    // Calcula o próximo estado da célula com base nos vizinhos vivos.
                    novaMatriz[i][j] = AplicarRegras.evoluirGeracao(matriz[i][j], vizinhosVivos);
                }
            }

            // Atualiza a matriz para a próxima geração.
            matriz = novaMatriz;

            /**
             * Pausa a execução da thread atual por um período especificado de tempo
             * fornecido pelo usuário como velocidade.
             *
             * @param velocidade o tempo em milissegundos pelo qual a thread atual deve ser pausada.
             * @throws InterruptedException Se a thread for interrompida enquanto estiver em espera.
             */
            try {
                Thread.sleep(velocidade);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Exibe os elementos da matriz, onde cada elemento da matriz
     * é formatado entre colchetes e separado por espaços.
     *
     * @param matriz A matriz 2D de inteiros a ser exibida.
     */
    public static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                //System.out.print("[" + matriz[i][j] + "] ");
                System.out.print(EstilizarMatriz.formatarElemento(matriz[i][j]) + " ");
            }
            System.out.println();
        }
    }
}