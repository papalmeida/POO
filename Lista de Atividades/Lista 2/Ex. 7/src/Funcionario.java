class Funcionario {
    String nome;
    String cpf;

    String formatarCPF() {
        String var = "";

        for (int i = 0; i < cpf.length(); i++) {
            if (cpf.charAt(i) != "." && cpf.charAt(i) != "-") {
                var += cpf.charAt(i);
            }
        }
        return var;
    }

    boolean validaCPF() {
        cpf = formatarCPF();

        
    }
}
