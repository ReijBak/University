import javax.swing.JOptionPane;

public class matrices {
    static String matriz1 = " ";
    public static void main(String[] args){
        int mat[][]={{6,7,4,9,10,4},{10,74,30,60,8,2},{7,20,90,100,45,32},{3,1,7,13,21,29},{19,27,32,47,27,3},{8,7,20,87,45,30}};
        mostrarmatriz(mat);
        culebrita_horizontal(mat);
    }

    public static void mostrarmatriz(int mat[][]){

        
        int filas = mat.length;
        for(int f=0;f<filas;f++){
            for(int c=0;c<mat[f].length;c++){
                matriz1 = matriz1 + mat[f][c]+" ";
            }
            matriz1 = matriz1 + "\n";
        }
       /* JOptionPane.showMessageDialog(null,matriz); */
    }

     /*public static void diagonalprincipal(int[][] mat){
        String matriz=" ";
        int filas = mat.length;
        for(int f=0;f<filas;f++){
            for(int c=0;c<mat[f].length;c++){
                if(f==c){
                matriz = matriz + mat[f][c]+" ";
                }
            }
            matriz = matriz + "\n";
        }
        JOptionPane.showMessageDialog(null,matriz);

    }*/

    public static void culebrita_horizontal(int[][] mat){
        String matriz=" ";
        int filas = mat.length;
        for(int f=0;f<filas;f++){
            if(f % 2 == 0){
                for(int c=0;c<mat[f].length;c++){
                    matriz = matriz + mat[f][c]+" ";
                    }
            }else{
                for(int c=filas-1;c>=0;c-=1){
                    matriz = matriz + mat[f][c]+" ";
                    }
            }
            matriz = matriz + "\n";
        }
        JOptionPane.showMessageDialog(null, matriz1 +"\n"+ matriz);

    }


}
