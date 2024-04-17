import java.util.Random;

public class Ex5 {
    private class PercursoCaminhao {
        int numero;
        int numCidades;
        int[] cidades = new int[6];
    }

    public static void main(String[] args) {
        PercursoCaminhao[] fichas = new geradorPercurso[30];
        int[][] matDist = gerarMatrizDist(10);
        imprimirMatriz(matDist);

    }

    static PercursoCaminhao[] geradorPercurso(int numPercursos) {
        P
    }

    static int[][] gerarMatrizDist (int numCidades) {
        int[][] mat = new int[numCidades + 1][numCidades + 1];
        Random rd = new Random();

        for(int i = 1; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                mat[i][j] = rd.nextInt(40) + 10; // 10 -> 49
                mat[j][i] = mat[i][j];
            }
        }

        return mat;
    }

    static void imprimirMatriz(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
}
