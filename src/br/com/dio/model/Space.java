package br.com.dio.model;

/**
 * Classe que representa um espaço individual no tabuleiro de Sudoku
 * Cada espaço pode conter um valor fixo (que não pode ser alterado) ou um valor editável
 * 
 * @author Seu Nome
 * @version 1.0
 */
public class Space {

    private Integer actual;      // Valor atual no espaço (pode ser null se vazio)
    private final int expected;  // Valor esperado (solução correta)
    private final boolean fixed; // Indica se o valor é fixo (não pode ser alterado)

    /**
     * Construtor do espaço
     * @param expected Valor esperado (solução correta)
     * @param fixed Indica se o valor é fixo
     */
    public Space(final int expected, final boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;
        // Se o espaço é fixo, o valor atual é automaticamente definido como o esperado
        if (fixed){
            actual = expected;
        }
    }

    /**
     * Retorna o valor atual no espaço
     * @return Valor atual ou null se o espaço estiver vazio
     */
    public Integer getActual() {
        return actual;
    }

    /**
     * Define o valor atual no espaço
     * @param actual Valor a ser definido (1-9 ou null para limpar)
     */
    public void setActual(final Integer actual) {
        // Espaços fixos não podem ter seus valores alterados
        if (fixed) return;
        
        // Validação: apenas valores de 1 a 9 ou null são permitidos
        if (actual != null && (actual < 1 || actual > 9)) {
            throw new IllegalArgumentException("Valor deve estar entre 1 e 9");
        }
        
        this.actual = actual;
    }

    /**
     * Limpa o espaço, removendo o valor atual
     * Apenas espaços não-fixos podem ser limpos
     */
    public void clearSpace(){
        setActual(null);
    }

    /**
     * Retorna o valor esperado (solução correta)
     * @return Valor esperado
     */
    public int getExpected() {
        return expected;
    }

    /**
     * Verifica se o espaço tem um valor fixo
     * @return true se o valor é fixo, false caso contrário
     */
    public boolean isFixed() {
        return fixed;
    }

    /**
     * Verifica se o espaço está preenchido
     * @return true se há um valor no espaço, false se está vazio
     */
    public boolean isFilled() {
        return actual != null;
    }

    /**
     * Verifica se o valor atual está correto
     * @return true se o valor atual corresponde ao esperado, false caso contrário
     */
    public boolean isCorrect() {
        return actual != null && actual.equals(expected);
    }

    /**
     * Retorna uma representação em string do espaço
     * @return String representando o valor atual ou espaço vazio
     */
    @Override
    public String toString() {
        return actual != null ? actual.toString() : " ";
    }
}
