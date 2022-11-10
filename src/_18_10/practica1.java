package _18_10;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class practica1 {
    public static void main(String[] args) {

            while (true) {
                try {
                    //Creacion fichero para comprobar y guardar el contenido de dentro
                    File fTiendaC = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1810\\tienda.dat");


                    //Menú
                    System.out.println("=========MENU=========");
                    System.out.println(" ");
                    System.out.println("1 || Añadir prendas");
                    System.out.println("2 || Ver información fichero");
                    System.out.println("3 || Salir");
                    Scanner sc = new Scanner(System.in);
                    int opcion = sc.nextInt();
                    sc.nextLine();

                    //ArrayList Principal
                    ArrayList<Object> prendas = new ArrayList<Object>();


                    //Un try que busca y guarda la informacion del fichero
                    try {
                        FileInputStream fis = new FileInputStream(fTiendaC);
                        ObjectInputStream ois = new ObjectInputStream(fis);


                        //Si hay contenido dentro, lo lee y lo guarda en la arraylist principal
                        Object lectura2 = null;
                        while ((lectura2 = (prenda) ois.readObject()) != null) {
                            String tipoE = ((prenda) lectura2).getTipo();
                            String colorE = ((prenda) lectura2).getColor();
                            String tallaE = ((prenda) lectura2).getTalla();
                            double precioE = ((prenda) lectura2).getPrecio();
                            boolean dispE = ((prenda) lectura2).isDisponibilidad();
                            prendas.add(new prenda(tipoE, colorE, tallaE, dispE, precioE));

                        }
                        fis.close();
                        ois.close();
                    }
                    catch (IOException e){
                        //exception sin mensaje para no molestar
                        System.out.println(" ");
                    }

                    //opcion añadir prendas
                    if (opcion == 1) {
                        //fichero para añadir prendas
                        File fTienda = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1810\\tienda.dat");
                        FileOutputStream fos = new FileOutputStream(fTienda);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);


                        //se pregunta por la cantidad de prendas a meter de una, y se guarda en la arraylist
                        //(seguidamente de contenido antiguo del fichero, gracias al try de antes)
                        System.out.println("cuantas prendas quieres ingresar?");
                        int numPrendas = sc.nextInt();
                        sc.nextLine();
                        boolean disponibilidad;
                        for (int i = 0; i < numPrendas; i++) {
                            System.out.println("Tipo? Camiseta/Sudadera/Pantalon/Zapatillas/Gorras");
                            String tipoP = sc.next();
                            System.out.println("Talla? S/M/L");
                            String tallaP = sc.next();
                            System.out.println("Color? Verde/Rojo/Azul/Rosa");
                            String colorP = sc.next();
                            System.out.println("Disponible? S/N");
                            String disPS = sc.next();
                            if (disPS.equalsIgnoreCase("S")) {
                                disponibilidad = true;
                            } else {
                                disponibilidad = false;
                            }
                            System.out.println("Precio? ");
                            double precioP = sc.nextDouble();

                            prendas.add(new prenda(tipoP, tallaP, colorP, disponibilidad, precioP));

                        }

                        //escribe toda la ArrayList (lo antiguo y lo nuevo) de una
                        Object lectura = null;
                        for (Object objeto : prendas) {
                            oos.writeObject(objeto);
                            System.out.println("Se a añadido la prenda");
                        }

                        oos.close();
                        fos.close();


                        //opcion que lee el contenido
                    } else if (opcion == 2) {
                        File fTienda2 = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1810\\tienda.dat");
                        FileInputStream fis = new FileInputStream(fTienda2);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        Object lectura = null;
                        //lee y lo muestra con la plantilla de los syso
                        while ((lectura = (prenda) ois.readObject()) != null) {
                            System.out.println(" ");
                            System.out.println("Tipo: " + ((prenda) lectura).getTipo());
                            System.out.println("Color: " + ((prenda) lectura).getColor());
                            System.out.println("Talla: " + ((prenda) lectura).getTalla());
                            System.out.println("Precio: " + ((prenda) lectura).getPrecio());
                            System.out.println("Disponibilidad: " + ((prenda) lectura).isDisponibilidad());
                            System.out.println(" ");
                            System.out.println("=============================================================");
                        }



                        fis.close();
                        ois.close();
                    }
                    else {
                        System.exit(1);
                    }


                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    // un catch personalizado para cuando acabe de leer
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Se terminó de leer");
                    System.out.println("Continuar");
                    String continuar = sc2.nextLine();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

}
