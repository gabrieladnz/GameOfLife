/**
 * A classe GameOfLife é a classe principal que inicia a simulação do "Jogo da Vida" de Conway.
 * Ela lida com a validação de argumentos de linha de comando, tratamento de erros, conversão
 * de população inicial e criação de um tabuleiro para a simulação.
 *
 * @author Gabriela Diniz Santos
 */
public class GameOfLife {

    /**
     * Método principal que inicia a simulação do GOL.
     *
     * @param args Os argumentos de linha de comando passados ao programa.
     */
    public static void main(String[] args) {
        // Valida os parâmetros de entrada e exibe os argumentos
        ValidarParametros.ParametrosValidados parametros = ValidarParametros.validar(args);

        // Converte a população inicial para uma matriz de células.
        TratarArgumentos.converterPopulacao(parametros.populacaoInicial, parametros.colunas, parametros.linhas);

        // Exibe a mensagem inical contendo os argumentos fornecidos
        parametros.exibirParametros();

        // Cria o tabuleiro e inicia a simulação.
        Tabuleiro.criarMatriz(parametros.colunas, parametros.linhas, parametros.geracoes, parametros.velocidade, parametros.populacaoInicial);
    }
}
