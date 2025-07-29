# Instruções de Execução - Jogo de Sudoku

## Como Executar o Projeto

### Pré-requisitos
- Java JDK 17 ou superior
- IDE Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Passo a Passo

#### 1. Abrir o Projeto na IDE
1. Abra sua IDE preferida
2. Importe o projeto `sudoku-master`
3. Certifique-se de que o Java 17+ está configurado

#### 2. Configurar os Argumentos de Execução

**No IntelliJ IDEA:**
1. Clique com botão direito no arquivo `Main.java`
2. Selecione "Run 'Main.main()'"
3. Clique em "Edit Configurations..."
4. No campo "Program arguments", cole os argumentos abaixo:

```
0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false
```

**No Eclipse:**
1. Clique com botão direito no arquivo `Main.java`
2. Selecione "Run As" → "Java Application"
3. Clique em "Run Configurations..."
4. Selecione "Main" e vá para a aba "Arguments"
5. Cole os argumentos no campo "Program arguments"

**No VS Code:**
1. Abra o arquivo `Main.java`
2. Pressione F5 ou clique em "Run and Debug"
3. Configure o `launch.json` com os argumentos

#### 3. Executar o Projeto
1. Execute o arquivo `Main.java`
2. O jogo será iniciado com a mensagem de boas-vindas
3. Use o menu para navegar pelas opções

### Como Jogar

1. **Iniciar Jogo** (Opção 1)
   - Inicia um novo jogo com o tabuleiro configurado

2. **Inserir Número** (Opção 2)
   - Informe a coluna (0-8)
   - Informe a linha (0-8)
   - Informe o número (1-9)

3. **Visualizar Tabuleiro** (Opção 4)
   - Mostra o estado atual do jogo

4. **Verificar Status** (Opção 5)
   - Mostra se há erros e o progresso

5. **Finalizar Jogo** (Opção 7)
   - Verifica se você completou o Sudoku corretamente

### Entendendo os Argumentos

Os argumentos seguem o formato: `coluna,linha;valor,fixo`

Exemplo: `0,0;4,false` significa:
- Posição: coluna 0, linha 0
- Valor: 4
- Fixo: false (pode ser alterado pelo jogador)

### Solução do Sudoku

O Sudoku fornecido tem uma solução única. Os números fixos (true) são as pistas iniciais e não podem ser alterados.

### Dicas para Jogar

- Comece preenchendo números que só podem ir em uma posição
- Use a opção "Verificar status" frequentemente
- Visualize o tabuleiro para planejar suas jogadas
- Se ficar travado, use "Limpar jogo" para recomeçar

### Problemas Comuns

**Erro: "Cannot find symbol"**
- Verifique se está usando Java 17+
- Certifique-se de que todos os arquivos estão no lugar correto

**Erro: "ArrayIndexOutOfBoundsException"**
- Verifique se os argumentos estão corretos
- Certifique-se de que há exatamente 81 argumentos

**Jogo não inicia**
- Verifique se os argumentos foram passados corretamente
- Certifique-se de que o formato dos argumentos está correto

### Suporte

Se encontrar problemas, verifique:
1. Versão do Java (deve ser 17+)
2. Configuração dos argumentos
3. Estrutura de pastas do projeto
4. Logs de erro no console 