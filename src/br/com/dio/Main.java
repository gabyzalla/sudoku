package br.com.dio;

import br.com.dio.model.Board;
import br.com.dio.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

/**
 * Classe principal do jogo de Sudoku
 * Implementa um jogo completo de Sudoku com interface no terminal
 * 
 * @author Seu Nome
 * @version 1.0
 */
public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static Board board;
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        System.out.println("BEM-VINDO AO JOGO DE SUDOKU!");
        System.out.println("==============================");
        
        // Processa os argumentos de linha de comando para configurar o tabuleiro
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        
        var option = -1;
        while (true){
            displayMenu();
            option = scanner.nextInt();

            switch (option){
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> showHints();
                case 9 -> System.exit(0);
                default -> System.out.println("Opção inválida, selecione uma das opções do menu");
            }
        }
    }

    /**
     * Exibe o menu principal do jogo
     */
    private static void displayMenu() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("===============");
        System.out.println("1 - Iniciar um novo Jogo");
        System.out.println("2 - Colocar um novo número");
        System.out.println("3 - Remover um número");
        System.out.println("4 - Visualizar jogo atual");
        System.out.println("5 - Verificar status do jogo");
        System.out.println("6 - Limpar jogo");
        System.out.println("7 - Finalizar jogo");
        System.out.println("8 - Ver dicas");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Inicia um novo jogo de Sudoku
     * @param positions Mapa com as posições iniciais do tabuleiro
     */
    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)){
            System.out.println("O jogo já foi iniciado!");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("Jogo iniciado com sucesso! Boa sorte!");
        showCurrentGame();
    }

    /**
     * Permite ao usuário inserir um número no tabuleiro
     */
    private static void inputNumber() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("INSERIR NÚMERO");
        System.out.println("==============");
        System.out.println("Informe a coluna (0-8):");
        var col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha (0-8):");
        var row = runUntilGetValidNumber(0, 8);
        System.out.printf("Informe o número (1-9) para a posição [%s,%s]: ", col, row);
        var value = runUntilGetValidNumber(1, 9);
        
        if (!board.changeValue(col, row, value)){
            System.out.printf("A posição [%s,%s] tem um valor fixo e não pode ser alterada!\n", col, row);
        } else {
            System.out.printf("Número %d inserido na posição [%s,%s] com sucesso!\n", value, col, row);
        }
    }

    /**
     * Permite ao usuário remover um número do tabuleiro
     */
    private static void removeNumber() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("REMOVER NÚMERO");
        System.out.println("==============");
        System.out.println("Informe a coluna (0-8):");
        var col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha (0-8):");
        var row = runUntilGetValidNumber(0, 8);
        
        if (!board.clearValue(col, row)){
            System.out.printf("A posição [%s,%s] tem um valor fixo e não pode ser removida!\n", col, row);
        } else {
            System.out.printf("Número removido da posição [%s,%s] com sucesso!\n", col, row);
        }
    }

    /**
     * Exibe o estado atual do tabuleiro
     */
    private static void showCurrentGame() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var col: board.getSpaces()){
                args[argPos ++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("\nTABULEIRO ATUAL");
        System.out.println("================");
        System.out.printf((BOARD_TEMPLATE) + "\n", args);
    }

    /**
     * Exibe o status atual do jogo
     */
    private static void showGameStatus() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("\nSTATUS DO JOGO");
        System.out.println("==============");
        System.out.printf("Status: %s\n", board.getStatus().getLabel());
        
        // Mostra informações de progresso
        int filledSpaces = board.getFilledSpacesCount();
        int totalSpaces = board.getTotalFillableSpaces();
        double progress = board.getProgressPercentage();
        
        System.out.printf("Progresso: %d/%d espaços preenchidos (%.1f%%)\n", 
                         filledSpaces, totalSpaces, progress);
        
        if(board.hasErrors()){
            System.out.println("O jogo contém erros - verifique suas respostas!");
        } else {
            System.out.println("O jogo não contém erros - continue assim!");
        }
    }

    /**
     * Limpa o tabuleiro, removendo todos os números inseridos pelo usuário
     */
    private static void clearGame() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("ATENÇÃO: Esta ação irá limpar todo o seu progresso!");
        System.out.println("Tem certeza que deseja limpar o jogo? (sim/não):");
        var confirm = scanner.next();
        while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não") && 
               !confirm.equalsIgnoreCase("nao") && !confirm.equalsIgnoreCase("s")){
            System.out.println("Informe 'sim' ou 'não':");
            confirm = scanner.next();
        }

        if(confirm.equalsIgnoreCase("sim") || confirm.equalsIgnoreCase("s")){
            board.reset();
            System.out.println("Jogo limpo com sucesso!");
        } else {
            System.out.println("Operação cancelada!");
        }
    }

    /**
     * Verifica se o jogo foi completado com sucesso
     */
    private static void finishGame() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        if (board.gameIsFinished()){
            System.out.println("PARABÉNS! Você concluiu o jogo com sucesso!");
            System.out.println("Você é um mestre do Sudoku!");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Seu jogo contém erros. Verifique e corrija antes de finalizar!");
        } else {
            System.out.println("Você ainda precisa preencher alguns espaços para completar o jogo!");
        }
    }

    /**
     * Exibe dicas sobre como jogar Sudoku
     */
    private static void showHints() {
        System.out.println("\nDICAS DO SUDOKU");
        System.out.println("===============");
        System.out.println("REGRAS BÁSICAS:");
        System.out.println("• Cada linha deve conter números de 1 a 9 sem repetição");
        System.out.println("• Cada coluna deve conter números de 1 a 9 sem repetição");
        System.out.println("• Cada quadrado 3x3 deve conter números de 1 a 9 sem repetição");
        System.out.println("• Números fixos (mostrados no início) não podem ser alterados");
        System.out.println();
        System.out.println("ESTRATÉGIAS:");
        System.out.println("• Comece preenchendo números que só podem ir em uma posição");
        System.out.println("• Use a opção 'Verificar status' para identificar erros");
        System.out.println("• Se ficar travado, use 'Limpar jogo' para recomeçar");
        System.out.println("• Visualize o tabuleiro frequentemente para planejar suas jogadas");
    }

    /**
     * Valida e retorna um número dentro do intervalo especificado
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Número válido inserido pelo usuário
     */
    private static int runUntilGetValidNumber(final int min, final int max){
        var current = scanner.nextInt();
        while (current < min || current > max){
            System.out.printf("Informe um número entre %s e %s: ", min, max);
            current = scanner.nextInt();
        }
        return current;
    }
}
