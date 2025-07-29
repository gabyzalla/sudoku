package br.com.dio.model;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.GameStatusEnum.COMPLETE;
import static br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Classe que representa o tabuleiro do jogo de Sudoku
 * Gerencia o estado do jogo, validações e operações no tabuleiro
 * 
 * @author Seu Nome
 * @version 1.0
 */
public class Board {

    private final List<List<Space>> spaces;

    /**
     * Construtor do tabuleiro
     * @param spaces Lista de listas representando as posições do tabuleiro
     */
    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    /**
     * Retorna as posições do tabuleiro
     * @return Lista de listas com as posições
     */
    public List<List<Space>> getSpaces() {
        return spaces;
    }

    /**
     * Determina o status atual do jogo
     * @return Enum representando o status (NÃO_INICIADO, INCOMPLETO, COMPLETO)
     */
    public GameStatusEnum getStatus(){
        // Se nenhum espaço não-fixo tem valor, o jogo não foi iniciado
        if (spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))){
            return NON_STARTED;
        }

        // Se algum espaço está vazio, o jogo está incompleto
        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    /**
     * Verifica se há erros no tabuleiro atual
     * @return true se há erros, false caso contrário
     */
    public boolean hasErrors(){
        if(getStatus() == NON_STARTED){
            return false;
        }

        // Verifica se algum número inserido não corresponde ao esperado
        return spaces.stream().flatMap(Collection::stream)
                .anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }

    /**
     * Altera o valor de uma posição específica no tabuleiro
     * @param col Coluna (0-8)
     * @param row Linha (0-8)
     * @param value Valor a ser inserido (1-9)
     * @return true se a alteração foi bem-sucedida, false se a posição é fixa
     */
    public boolean changeValue(final int col, final int row, final int value){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }

        space.setActual(value);
        return true;
    }

    /**
     * Remove o valor de uma posição específica no tabuleiro
     * @param col Coluna (0-8)
     * @param row Linha (0-8)
     * @return true se a remoção foi bem-sucedida, false se a posição é fixa
     */
    public boolean clearValue(final int col, final int row){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }

        space.clearSpace();
        return true;
    }

    /**
     * Reseta o tabuleiro, removendo todos os valores inseridos pelo usuário
     * Mantém apenas os valores fixos
     */
    public void reset(){
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    /**
     * Verifica se o jogo foi completado com sucesso
     * @return true se o jogo está completo e sem erros
     */
    public boolean gameIsFinished(){
        return !hasErrors() && getStatus().equals(COMPLETE);
    }

    /**
     * Retorna o número de espaços preenchidos pelo usuário
     * @return Quantidade de espaços preenchidos
     */
    public int getFilledSpacesCount() {
        return (int) spaces.stream()
                .flatMap(Collection::stream)
                .filter(s -> !s.isFixed() && nonNull(s.getActual()))
                .count();
    }

    /**
     * Retorna o número total de espaços que podem ser preenchidos
     * @return Quantidade total de espaços não-fixos
     */
    public int getTotalFillableSpaces() {
        return (int) spaces.stream()
                .flatMap(Collection::stream)
                .filter(s -> !s.isFixed())
                .count();
    }

    /**
     * Calcula o progresso do jogo em porcentagem
     * @return Porcentagem de preenchimento (0-100)
     */
    public double getProgressPercentage() {
        if (getTotalFillableSpaces() == 0) {
            return 100.0;
        }
        return (double) getFilledSpacesCount() / getTotalFillableSpaces() * 100.0;
    }
}
