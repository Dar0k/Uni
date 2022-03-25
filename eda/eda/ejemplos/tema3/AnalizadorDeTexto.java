package ejemplos.tema3;

import librerias.estructurasDeDatos.modelos.*;
import librerias.estructurasDeDatos.deDispersion.*;
import java.util.Scanner;

public class AnalizadorDeTexto {

    protected Map<String, Integer> m;

    /** construye un Analizador del Texto t, considerando que
     *  el separador de sus palabras es el espacio en blanco
     */
    public AnalizadorDeTexto(String t) {
        String[] palabras = t.split(" +");
        m = new TablaHash<String, Integer>(palabras.length);
        for (int i = 0; i < palabras.length; i++) {
            String pal = palabras[i].toLowerCase();
            Integer frec = m.recuperar(pal);
            if (frec != null) {
               frec++;
               m.insertar(pal, frec);
            }
            else { m.insertar(pal, 1); }
        }
    }

    /** devuelve el n� de palabras con frecuencia de aparici�n mayor
     *  que n que aparecen en el texto tratado por un Analizador.
     *  As�, por ejemplo, si n=0 devuelve el n�mero de palabras distintas
     *  que aparecen en el texto; si n=1 devuelve el n�mero de palabras
     *  repetidas que tiene el texto, etc.
     */
    public int frecuenciaMayorQue(int n) {
        // COMPLETAR
        int frecuencia  = 0;
        ListaConPI<String> deClaves = m.claves();
        deClaves.inicio();
        while(!deClaves.esFin())
        {
          if(m.recuperar(deClaves.recuperar()) > n)
          {
            frecuencia++;
          }
          deClaves.siguiente();
        }
        return frecuencia;
    }

    public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Escriba palabras separadas por blancos:");
      String texto = teclado.nextLine();

      AnalizadorDeTexto adt = new AnalizadorDeTexto(texto);
      System.out.println("Escriba frecuencia:");
      int frec = teclado.nextInt();
      System.out.println(adt.frecuenciaMayorQue(frec));

    }
}
