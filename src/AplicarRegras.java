/**
 * A classe AplicarRegras contém métodos para aplicar as regras do Jogo da Vida de Conway em uma matriz bidimensional.
 * Essas regras determinam a evolução das células no jogo com base em seu estado atual e no número de vizinhos vivos.
 */
public class AplicarRegras {
    /**
     * Determina o estado da célula na próxima geração com base nas regras do Jogo da Vida.
     * <p>
     * * Qualquer célula viva com menos de dois vizinhos vivos morre de solidão.
     * * Qualquer célula viva com mais de três vizinhos vivos morre de superpopulação.
     * * Qualquer célula com exatamente três vizinhos vivos se torna uma célula viva.
     * * Qualquer célula com dois vizinhos vivos continua no mesmo estado para a próxima geração.
     * *
     *
     * @param estadoAtual   O estado atual da célula (0 para morta, 1 para viva).
     * @param vizinhosVivos O número de vizinhos vivos da célula.
     * @return O estado da célula na próxima geração.
     */
    public static int evoluirGeracao(int estadoAtual, int vizinhosVivos) {
        //System.out.println("AplicarRegras - Estado atual: " + estadoAtual + ", Vizinhos vivos: " + vizinhosVivos);

        if (estadoAtual == 1) {
            if (vizinhosVivos < 2 || vizinhosVivos > 3) {
                return 0; // A célula morre
            } else {
                return 1; // A célula permanece viva
            }
        } else {
            if (vizinhosVivos == 3) {
                return 1; // A célula nasce
            } else if (vizinhosVivos == 2) {
                return estadoAtual; // A célula permanece no seu estado
            } else {
                return 0;
            }
        }

    }

    /**
     * Verifica o estado das células vizinhas.
     *
     * @param matriz A matriz representando o tabuleiro do Jogo da Vida.
     * @param linha  A posição da célula na linha.
     * @param coluna A posição da célula na coluna.
     * @return O número de células vizinhas vivas.
     */
    public static int checarEstado(int[][] matriz, int linha, int coluna) {
        int contagem = 0;
        int largura = matriz[0].length;
        int altura = matriz.length;

        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                if (i >= 0 && i < altura && j >= 0 && j < largura) {
                    if (i != linha || j != coluna) {
                        contagem += matriz[i][j];
                    }
                }
            }
        }
        return contagem;
    }

    /**
     * Conta a quantidade de células vivas na matriz.
     *
     * @param matriz A matriz representando o tabuleiro do Jogo da Vida.
     * @return O número de células vivas na matriz.
     */
    public static int contarPopulacaoViva(int[][] matriz) {
        int contagem = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    contagem++;
                }
            }
        }
        return contagem;
    }
}