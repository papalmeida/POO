import java.util.Scanner;

public class Ex1 {
    private class TAluno {
        String nome;
        int idade;
        String endereco;
        String dataInscricao;
        String dataObtencaoCarta;
    }

    public void CadastroAlunos() throws Exception {
        Scanner sc = new Scanner(System.in);
        TAluno[] alunos = new TAluno[50];

        
            for (int i = 0; i < alunos.length; i++) {
                alunos[i] = new TAluno();
                System.out.println("\nAdicionar aluno " + (i + 1) + ":");

                System.out.print("Nome: ");
                alunos[i].nome = sc.next();
                if(alunos[i].nome.equalsIgnoreCase("Fim")) 
                    break;

                System.out.print("Idade: ");
                alunos[i].idade = sc.nextInt();

                System.out.print("Endereço: ");
                alunos[i].endereco = sc.next();

                System.out.print("Data de inscrição: ");
                alunos[i].dataInscricao = sc.next();

                System.out.print("Data de obtenção de carta:");
                alunos[i].dataObtencaoCarta = sc.next();
                
            }
        

        acharAlunoMaisNovo(alunos);
        sc.close();
        
    }

    private void acharAlunoMaisNovo(TAluno[] alunos) {
        TAluno alunoMaisNovo = new TAluno();
        alunoMaisNovo.idade = 999;
        int qntdAlunos = alunos.length;
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i].nome.equalsIgnoreCase("fim") || alunos[i].nome == null) {
                qntdAlunos = i - 1;
                break;
            }
        }

        for (int i = 0; i < qntdAlunos; i++) {
            if(alunos[i].idade < alunoMaisNovo.idade) {
                alunoMaisNovo = alunos[i];
            }
        }

        System.out.println("\nDados do Aluno Mais Novo:\n");
        System.out.println("Nome: " + alunoMaisNovo.nome);
        System.out.println("Idade: " + alunoMaisNovo.idade);
        System.out.println("Endereço: " + alunoMaisNovo.endereco);
        System.out.println("Data de Inscrição: " + alunoMaisNovo.dataInscricao);
        System.out.println("Data de Obtenção: " + alunoMaisNovo.dataObtencaoCarta);

    }
}