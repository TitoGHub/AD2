package _04_10;

import java.io.*;

public class practica1 {
    public static void main(String[] args) {
        File leer = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\LeerDentro\\fichero1.txt");
        FileReader ficheroleer = null;
        try {
            ficheroleer = new FileReader(leer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bl = new BufferedReader(ficheroleer);

        try {

            for (int i = 0; i < 400; i ++){
                String linea = bl.readLine();
                System.out.println(linea);
            }
            bl.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
