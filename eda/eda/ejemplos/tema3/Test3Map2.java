package ejemplos.tema3;

//para poder usar Map y ListaConPI
import librerias.estructurasDeDatos.modelos.*;

//para poder usar TablaHash, la Implementacion de Map
import librerias.estructurasDeDatos.deDispersion.*;

// CUESTION: ?Que sucede si, en lugar de los dos import,
// se escribe: import java.util.*;?
import java.util.Locale;
import java.util.Scanner;

public class Test3Map2 {

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


        Map<String, Integer> m = new TablaHash<String, Integer>(texto.length());

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
              m.insertar(clave, 1);

            }
            else
            {

              m.insertar(clave, m.recuperar(clave)+1);

            }
          }

        // OJO: nos piden mostrar las palabras distintas que aparecen,
        // que NO son las Entradas del Map sino SOLO sus claves
        ListaConPI<String> deClaves = m.claves();
        deClaves.inicio();
        while(!deClaves.esFin())
        {
          if(m.recuperar(deClaves.recuperar()) > 1)
          {
            System.out.println(deClaves.recuperar() + ", " + m.recuperar(deClaves.recuperar()));
          }
          deClaves.siguiente();
        }
        }
}
