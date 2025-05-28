/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*

+ cadTurma(s : Sistema)
- lerLinha(msg : String) : String
- lerInteiro(msg : String) : int
- lerDouble(msg : String) : double
- lerProf(s : Sistema) : Professor
- lerAlunos(s : Sistema) : Aluno[ ]
- lerAlunoProva(s : Sistema, a : Aluno, nQuestoes : int) : AlunoProva
- lerProva(s : Sistema, alunos : Aluno[ ]) : Prova
- lerGrupoTrabalho(s : Sistema) : GrupoTrabalho
- lerTrabalho(s : Sistema, alunos : Aluno[ ]) : Trabalho
- lerAvaliacoes(s : Sistema, alunos : Aluno[ ], nAvaliacoes : int) : Avaliacao[ ]
 */

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior, Luma e remerson
 */
public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe Entrada
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
    * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
    * @return Inteiro contendo a opção escolhida pelo usuário
    */
    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar aluno:\n" +
                "3) Cadastrar turma:\n" +
                "4) Listar turmas:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 4) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/
    
    public int menu_avs() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg =
                "Escolha um tipo de avaliacao:\n" +
                "1) Prova:\n" +
                "2) Trabalho:\n"; 
                

        int op = this.lerInteiro(msg);

        while (op < 1 || op > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }
    /***************************************************/

    /**
     * Lê os dados de um novo Professor e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadProf(Sistema s) {
        s.listarProfs();

        String nome = this.lerLinha("Digite o nome do professor: ");
        String cpf = this.lerLinha("Digite o cpf do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$");

        if (s.encontrarProfessor(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Professor p = new Professor(nome, cpf, salario);
            s.novoProf(p);
        }
        else {
            System.out.println("Erro: CPF duplicado. Professor não adicionado.");
        }
    }
    
    /***************************************************/
    
    public void cadAluno(Sistema s) {
        s.listarAlunos();
        String nome = this.lerLinha("Digite o nome do aluno : ");
        String cpf = this.lerLinha("Digite o cpf do aluno: ");
        String matricula = this.lerLinha("Digite a matrícula do aluno: ");


        if (s.encontrarAlunoCpf(cpf) == null && s.encontrarAlunoMat(matricula)==null ) { // Garantindo que o não CPF esteja duplicado.
            Aluno a = new Aluno(nome, cpf, matricula);
            s.novoAluno(a);
        }
        else {
            System.out.println("Erro: CPF ou matricula duplicada");
        }
    }

    private Trabalho lerTrabalho(Sistema s, List<Aluno> alunos) {
        String nome = this.lerLinha("Informe o nome desta avaliação: ");
        int dia = this.lerInteiro("digite o dia do trabalho: ");
        int mes = this.lerInteiro("digite o mes do trabalho: ");
        int ano = this.lerInteiro("digite o ano do trabalho: " );
        Data d2=new Data(26,5,2025);
        Data data=new Data(dia,mes,ano);
        if(data.posterior(d2)){
            int valor_trabalho=this.lerInteiro("Digite o valor máximo desta avaliacao: ");
            int numero_integrantes = this.lerInteiro("Digite o número máximo de integrantes: ");
            int numero_grupos = this.lerInteiro("Digite o número de grupos: ");
            //lista para armazenar os grupos de trabalho
            ArrayList<GrupoTrabalho> grupos = new ArrayList<>();
            for (int i = 0; i < numero_grupos; i++) {
                int numero_alunos_grupo = this.lerInteiro("Digite o número de alunos do grupo " + (i + 1) + ": ");
                if (numero_alunos_grupo > numero_integrantes) {
                    System.out.println("Número de alunos no grupo excede o máximo permitido. Tente novamente.");
                    i--; // Repetir a leitura para o mesmo índice
                    continue;
                }
                ArrayList<Aluno> grupo = new ArrayList<>();
                for (int j = 0; j < numero_alunos_grupo; j++) {
                    String mat = this.lerLinha("Digite a matricula do aluno " + (j + 1) +  ": ");
                    Aluno aluno = s.encontrarAlunoMat(mat);
                    if (aluno != null) {
                        grupo.add(aluno);
                    } else {
                        System.out.println("Aluno com a matricula " + mat + " nao existe");
                        j--; // Repetir a leitura para o mesmo índice
                    }
                }
                double nota = this.lerDouble("Digite a nota do grupo " + (i + 1) + ": ");
                GrupoTrabalho grupoTrabalho = new GrupoTrabalho(grupo, nota);
                grupos.add(grupoTrabalho);
        }
    }
    return new Trabalho(nome, data, valor_trabalho, numero_integrantes, grupos);
}
    
    /***************************************************/
    public void cadTurma(Sistema s) {

        String nome = this.lerLinha("Digite o nome da disciplina : ");
        int ano = this.lerInteiro("Digite o ano da disciplina: ");
        int sem = this.lerInteiro("Digite o semestre da disciplina: ");
        String cpf=this.lerLinha("Digite o CPF do professor:");
        if (s.encontrarProfessor(cpf) != null) { // Garantindo que o não CPF esteja duplicado.
           Professor prof=s.encontrarProfessor(cpf);
           int qnt_alunos=this.lerInteiro("Digite a quantidade de alunos na disciplina: ");
           int i=0;
           ArrayList<Aluno> alunosTurma= new ArrayList<>();
           while(i<qnt_alunos){        
              String mat = this.lerLinha("Digite a matricula do aluno : ");
              if(s.encontrarAlunoMat(mat)!=null){
                  Aluno a=s.encontrarAlunoMat(mat);
                  alunosTurma.add(a);
                  i++;
              }else{
                  System.out.println("Aluno com a matricula "+mat+" nao existe");}
           }int qnt_avs=this.lerInteiro("Digite a quantidade de avaliacoes na disciplina: ");
            int op = this.menu_avs();
            if(op==1){
              Prova prova=this.lerProva(s, alunosTurma);
              if(prova!=null){
                Turma t= new Turma(nome, ano, sem, prof, alunosTurma, prova);
                s.novaTurma(t);
                  
              }
            }
           
        }else{
           System.out.println("Professor não existe");
        }
    }
        
       /***************************************************/
      public AlunoProva LerAlunoProva(Sistema s,Aluno a,int nQuestoes){
          ArrayList<Integer> alunonotas= new ArrayList<>();
          for(int i=0;i<nQuestoes;i++){
              int nota = this.lerInteiro("Nota de "+ a.getNome() +"na questão " +(i+1)+ ":");
              alunonotas.add(nota);
          }
           
          return new AlunoProva(a,alunonotas);
      }
      /***************************************************/
      public Prova lerProva(Sistema s,List<Aluno> alunos){
          String nome =this.lerLinha("Informe o nome desta prova: ");
          int dia=this.lerInteiro("digite o dia da prova: ");
          int mes=this.lerInteiro("digite o mes da prova: ");
          int ano=this.lerInteiro("digite o ano da prova: " );
          Data d2=new Data(26,5,2025);
          Data data=new Data(dia,mes,ano);
          if(data.posterior(d2)){
            int valor_prova=this.lerInteiro("Digite o valor máximo desta avaliacao: ");
            int n_questoes=this.lerInteiro("digite o número de questoes: ");
            ArrayList<AlunoProva> alunosprovas= new ArrayList<>();
             for(Aluno a: alunos){            
                 AlunoProva p=this.LerAlunoProva(s,a,n_questoes); 
                 alunosprovas.add(p);
              }
  
            return new Prova(nome,data,valor_prova,n_questoes,alunosprovas);
          }
         return null;
      }
      /***************************************************/

}
