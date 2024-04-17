import java.util.Scanner;

public class Programa {
    public void registrarFuncionario() throws Exception {
        Scanner sc = new Scanner(System.in);

        Funcionario func = new Funcionario();
        System.out.println("Digite o nome do funcionário:");
        func.nome = sc.next();
    }
}
