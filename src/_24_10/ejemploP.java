package _24_10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class  ejemploP{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1,"Producto 1", 3.2, true, 'T'));
        productos.add(new Producto(2,"Producto 2", 40.6, true, 'R'));
        productos.add(new Producto(3,"Producto 3", 55.6, false, 'T'));
        productos.add(new Producto(4,"Producto 4", 40.6, true, 'R'));

        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_2410\\ficheroP.dat", "rw");
            for(Producto p : productos) {
                raf.writeInt(p.getId());
                StringBuffer sb = new StringBuffer(p.getNombre());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                raf.writeDouble(p.getPrecio());
                raf.writeBoolean(p.isDescuento());
                raf.writeChar(p.getTipo());
            }

            raf.seek(105); //En este caso, lo que metamos en el seek debe ser múltiplo de 35
            System.out.println(raf.readInt());
            String nombre = "";
            for(int i=0; i<10; i++) {
                nombre += raf.readChar();
            }
            System.out.println(nombre);
            System.out.println(raf.readDouble());
            System.out.println(raf.readBoolean());
            System.out.println(raf.readChar());

        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
