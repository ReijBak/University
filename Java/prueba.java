import javax.swing.JOptionPane;

public class prueba {
    public static void main (String [] args)  {
        int mat [][]= new int [6][6];
        llenarmatriz(mat);
        mostrarmatriz(mat);
        }

    public static void llenarmatriz(int mat[][]){
        int filas = mat.length;
        for(int f=0;f<filas;f++){
            for(int c=0;c<mat[f].length;c++){
                mat[f][c] = Integer.parseInt(JOptionPane.showInputDialog("Digite un número en la fila"+"["+f+"]"+"["+c+"]"));
            }
        }
    }

    public static void mostrarmatriz(int mat[][]){

        String matriz=" ";
        int filas = mat.length;
        for(int f=0;f<filas;f++){
            for(int c=0;c<mat[f].length;c++){
                matriz = matriz + mat[f][c]+" ";
            }
            matriz = matriz + "\n";
        }
        JOptionPane.showMessageDialog(null,matriz);
    }
}


