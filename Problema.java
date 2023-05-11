import java.io.*;
import java.util.Scanner;

public class Problema {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;

            /* Lectura y validación  de clave */

            System.out.print("Introduce la clave: ");
            Scanner sc = new Scanner(System.in);
            String clave = sc.nextLine().toUpperCase();
            int j = 0;
            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());

                int A = 'A';
                for (int i = 0; i < linea.length(); i++) {
                    if (j == clave.length()) {
                        j = 0;
                    }
                    if (Character.isLetter(linea.charAt(i))) {
                        int desplazamientos = clave.charAt(j) - A;
                        j++;
                        int valorNewLetter = Character.toUpperCase(linea.charAt(i)) + desplazamientos;
                        if (valorNewLetter > 90) {
                            valorNewLetter -= 26;
                        }

                        sb.append((char) (valorNewLetter));
                    } else {
                        sb.append(linea.charAt(i));
                    }

                }
                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */
            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}


