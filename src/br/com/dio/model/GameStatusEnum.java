package br.com.dio.model;

/**
 * Enum que representa os possíveis status do jogo de Sudoku
 * 
 * @author Seu Nome
 * @version 1.0
 */
public enum GameStatusEnum {

    /**
     * Jogo não foi iniciado - nenhum número foi inserido pelo usuário
     */
    NON_STARTED("não iniciado"),
    
    /**
     * Jogo está em andamento - alguns números foram inseridos, mas não está completo
     */
    INCOMPLETE("incompleto"),
    
    /**
     * Jogo está completo - todos os espaços foram preenchidos
     */
    COMPLETE("completo");

    private final String label;

    /**
     * Construtor do enum
     * @param label Descrição legível do status
     */
    GameStatusEnum(final String label){
        this.label = label;
    }

    /**
     * Retorna a descrição legível do status
     * @return String com a descrição do status
     */
    public String getLabel() {
        return label;
    }

    /**
     * Retorna uma representação em string do enum
     * @return String com o nome do enum e sua descrição
     */
    @Override
    public String toString() {
        return name() + " (" + label + ")";
    }
}
