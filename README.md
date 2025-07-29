# Jogo de Sudoku em Java

Um jogo de Sudoku completo desenvolvido em Java com interface no terminal, implementando todas as funcionalidades essenciais para uma experiência de jogo interativa e funcional.

## Descrição

Este projeto implementa um jogo de Sudoku completo em Java, consolidando conceitos de:
- **Programação Orientada a Objetos**
- **Manipulação de estruturas de dados**
- **Uso de métodos e classes**
- **Entradas e saídas no terminal**
- **Validação de dados**

## Funcionalidades

- Iniciar novo jogo - Cria um novo tabuleiro de Sudoku
- Inserir números - Adiciona números nas posições desejadas
- Remover números - Remove números de posições específicas
- Visualizar jogo atual - Mostra o estado atual do tabuleiro
- Verificar status do jogo - Indica se há erros ou se está completo
- Limpar jogo - Reseta o tabuleiro para o estado inicial
- Finalizar jogo - Verifica se o jogo foi completado com sucesso
- Validação de regras - Verifica se os números seguem as regras do Sudoku

## Tecnologias Utilizadas

- **Java 17+**
- **IDE IntelliJ IDEA** (recomendado)
- **Git** para versionamento

## Como Executar

### Pré-requisitos
- Java JDK 17 ou superior instalado
- IDE Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Passos para execução:

1. **Clone o repositório:**
   ```bash
   git clone [URL_DO_SEU_REPOSITORIO]
   cd sudoku-master
   ```

2. **Abra o projeto na sua IDE**

3. **Execute o arquivo Main.java** com os seguintes argumentos:

   ```
   0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false
   ```

### Como usar o jogo:

1. **Iniciar jogo** - Selecione opção 1 para começar
2. **Inserir número** - Use opção 2, informe coluna, linha e valor
3. **Visualizar** - Use opção 4 para ver o tabuleiro atual
4. **Verificar status** - Use opção 5 para ver se há erros
5. **Finalizar** - Use opção 7 quando achar que completou

## Estrutura do Projeto

```
src/
├── br/com/dio/
│   ├── Main.java              # Classe principal com menu interativo
│   ├── model/
│   │   ├── Board.java         # Classe que representa o tabuleiro
│   │   ├── Space.java         # Classe que representa cada espaço
│   │   └── GameStatusEnum.java # Enum com status do jogo
│   └── util/
│       └── BoardTemplate.java # Template para exibição do tabuleiro
```

## Melhorias Implementadas

- Interface melhorada - Menu mais intuitivo e responsivo
- Validação robusta - Verificação de entrada de dados
- Documentação completa - README detalhado
- Código organizado - Estrutura clara e bem documentada
- Tratamento de erros - Mensagens de erro claras

## Status do Projeto

- [x] Implementação básica do Sudoku
- [x] Interface no terminal
- [x] Validação de regras
- [x] Sistema de menu interativo
- [x] Documentação completa
- [x] Tratamento de erros

## Autor

**Seu Nome** - Desenvolvido como parte do curso da DIO

## Licença

Este projeto foi desenvolvido para fins educacionais como parte do curso da Digital Innovation One.

---

**Divirta-se jogando Sudoku!** 