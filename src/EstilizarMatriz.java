/**
 * A classe EstilizarMatriz oferece métodos para formatar elementos de uma matriz
 * para exibição em uma representação visual, incluindo a adição de cores e emojis.
 */
public class EstilizarMatriz {
    /**
     * Formata um elemento da matriz para exibição.
     *
     * @param elemento O valor do elemento na matriz.
     * @return Uma string formatada para exibição.
     */
    protected static String formatarElemento(int elemento) {
        if (elemento == 0) {
            // Adicione a formatação de cor de fundo ANSI (preto) e reset.
            return "\u001B[40m \uD83D\uDDA4 \u001B[0m";
        } else if (elemento == 1) {
            // Adicione a formatação de cor de fundo ANSI (verde) e reset.
            return "\u001B[42m ❤\uFE0F \u001B[0m";
        } else {
            // Lidar com valores diferentes de 0 e 1 conforme necessário.
            return "[" + elemento + "]";
        }
    }
}