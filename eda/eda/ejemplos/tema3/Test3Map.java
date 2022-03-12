package ejemplos.tema3;

//para poder usar Map y ListaConPI
import librerias.estructurasDeDatos.modelos.*;

//para poder usar TablaHash, la Implementacion de Map
import librerias.estructurasDeDatos.deDispersion.*;

// CUESTION: ?Que sucede si, en lugar de los dos import,
// se escribe: import java.util.*;?
import java.util.Locale;
import java.util.Scanner;

public class Test3Map {

    public static void main(String[] args) {

        // Por simplicidad, la frase no se lee de un fichero,
        // sino que se lee de teclado como un String de Palabras
        // separadas por blancos. Una frase (String) ejemplo seria:
        // "vale, aunque es un poco rollo lo hago para que se vea como funciona el Map!! Se me ha olvidado escribir palabras repetidas vaya!!"

        // Lectura de la frase (String) a partir de la que se construye el Map
        Locale localEDA = new Locale("es", "US");
        Scanner teclado = new Scanner(System.in).useLocale(localEDA);
        System.out.println("Escriba palabras separadas por blancos:");
        String texto = teclado.nextLine();


        Map<String, String> m = new TablaHash<String, String>(texto.length());
        Map<String, Integer> m2 = new TablaHash<String, Integer>(texto.length()/2);

        // Construcci�n del Map, via insercion/actualizacion de sus Entradas,
        // a partir de la frase leida:
        // uso del m�todo split de String con separador " " (uno o mas)
        String[] palabrasDelTexto = texto.split(" +");
        int temp;
        for (int i = 0; i < palabrasDelTexto.length; i++)
            // OJO: LO M�S BARATO SERIA
        // d.insertar(palabrasDelTexto[i].toLowerCase(),
        // palabrasDelTexto[i].toLowerCase());
          {
            String clave = palabrasDelTexto[i].toLowerCase();
            if(m.recuperar(clave) == null)
            {
              m.insertar(clave, "");

            }
            else
            {
              if(m2.recuperar(clave) == null)
              {
                m2.insertar(clave, 2);
              }
              else{
                m2.insertar(clave, m2.recuperar(clave)+1);
              }
            }
          }

        // OJO: nos piden mostrar las palabras distintas que aparecen,
        // que NO son las Entradas del Map sino SOLO sus claves

        System.out.println(m2);
        }
}
