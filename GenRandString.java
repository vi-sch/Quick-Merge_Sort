//package ueb;
import java.util.*;

/**
 * Hilfsfunktionen zum Erzeugen von zuf&auml;lligen Strings.
 * 
 * @author Steger
 * 
 */
public class GenRandString {
    /**
     * Erzeuge ein zuf&auml;lliges Zeichen im Bereich 'a' .. 'z'.
     * 
     * @return das Zeichen.
     */
    public static char genZeichen() {
        double rand = java.lang.Math.random();
        double chr = rand * 26 + 'a';
        char ch = (char) chr;
        return ch;
    }

    /**
     * Erzeuge eine zuf&auml;llige Zeichenkette der gegebenen L&auml;nge.
     * 
     * @param len
     *            die L&auml;nge.
     * @return die Zeichenkette.
     */
    public static String genRandString(int len) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < len; i++) {
            buf.append(genZeichen());
        }
        return buf.toString();
    }




    /**
     * Aufgabe 17 c)
     * Die Funktion soll zunächst ein String-Array stab der Länge len/same erzeugen und dieses
     * Array mit zufälligen Strings der Länge 20 belegen.
     * Dann erzeugen Sie ein String-Array res der Länge len und belegen es mit zufällig
     * gewählten Werten aus dem Array stab. Verwenden Sie hierzu ein Objekt der Klasse
     * Random mit der Funktion nextInt(len/same), die jeweils einen Indexwert aus stab zufällig
     * wählt. Jeder String aus stab kommt dann im Mittel same mal im erzeugten Array res vor.
     * res geben Sie als Ergebnis der Funktion genRandArrSame zurück
    **/
    public static String[] genRandArrSame(int len, int same){
        
        String[] stab=new String[len/same];
        for(int i=0; i<stab.length;i++){
            stab[i]=genRandString(20);
        }
        
        String[] res= new String[len];
        for(int i=0;i<res.length; i++){
            Random ran=new Random();
            int nxt = ran.nextInt(len/same);
            res[i]=stab[nxt];
        }
        
        return res;
        
        
       
    }



    /**
     * Generiere ein Array mit einer f&uuml;r Standard-Quicksort pathologischen
     * Zahlenverteilung. Die Zahlen sind so verteilt, dass bei Wahl des
     * Pivotelements in der Mitte des zu sortierenden Bereichs, immer nur ein
     * Element abgespalten wird. Generiert wird ein Array, das aus den Zahlen
     * 0..len-1 besteht.
     * 
     * @param len
     *            die L&auml;nge des Arrays.
     * @return das Array.
     */
    public static int[] genMeanMaxInt(int len) {
        int[] a = new int[len];

        // Die untere H�lfte des Arrays
        for (int i = 0; i < len / 2; i++) {
            a[i] = 2 * i + 1;
        }
        // Die gr�sste Zahl liegt genau in der Mitte des Arrays
        a[len / 2] = len - 1;

        // Die Zahl 0 liegt in der Zelle mit Index = h�chste Zweierpotenz.
        int pos = 1;
        while (2 * pos < len) {
            pos = 2 * pos;
        }
        a[pos] = 0;

        /**
         * Die geraden Zahlen liegen auf dem maximalen Index f�r den gilt: index =
         * (zahl+1)*2^k.
         */
        for (int i = 2; i < len; i += 2) {
            pos = i + 1;
            while (2 * pos < len) {
                pos *= 2;
            }
            a[pos] = i;
        }
        return a;
    }

    /**
     * Konvertiert die Zahl in einen String der L�nge len. Dabei ist der String
     * f&uuml;r n==0 'AAAAA', f�r jede nachfolgende Zahl werden die Ziffern
     * 'hochgez&auml;hlt'.
     * 
     * @param len
     *            die L&auml;nge des zu erzeugenden Strings.
     * @param n
     *            die Zahl die in eine Zeichenkette abzubilden ist.
     * @return der String
     */
    public static String convToString(int len, int n) {
        final int anzBuchst = 26;
        StringBuffer str = new StringBuffer();
        while (n > 0) {
            int rest = n % anzBuchst;
            n = n / anzBuchst;
            int ch = 'a' + rest;
            char chr = (char) ch;
            str.insert(0, chr);
        }
        // mit 'a' auff�llen
        while (str.length() < len) {
            str.insert(0, 'a');
        }
        return str.toString();
    }

    /**
     * Generiere ein Array mit einer f&uuml;r Standard-Quicksort pathologischen
     * Zahlenverteilung. Die Strings sind so verteilt, dass bei Wahl des
     * Pivotelements in der Mitte des zu sortierenden Bereichs, immer nur ein
     * Element abgespalten wird.
     * 
     * @param len
     *            die L&auml;nge des Arrays.
     * @return das Array.
     */
    public static String[] genMeanMaxString(int len) {
        final int strlen = 10;
        String[] a = new String[len];

        // Die untere H�lfte des Arrays
        for (int i = 0; i < len / 2; i++) {
            a[i] = convToString(strlen, 2 * i + 1);
        }
        // Die gr�sste Zahl liegt genau in der Mitte des Arrays
        a[len / 2] = convToString(strlen, len - 1);

        // Die Zahl 0 liegt in der Zelle mit Index = h�chste Zweierpotenz.
        int pos = 1;
        while (2 * pos < len) {
            pos = 2 * pos;
        }
        a[pos] = convToString(strlen, 0);

        /**
         * Die geraden Zahlen liegen auf dem maximalen Index f�r den gilt: index =
         * (zahl+1)*2^k.
         */
        for (int i = 2; i + 1 < len; i += 2) {
            pos = i + 1;
            while (2 * pos < len) {
                pos *= 2;
            }
            a[pos] = convToString(strlen, i);
        }
        return a;
    }
    
    /**
    * Schreiben Sie außerdem eine Hilfsfunktion, die überprüft, ob das übergebene Array von Strings aufsteigend sortiert ist. Diese
    *  Funktion kann z.B. über das Array laufen und immer zwei aufeinander folgende Werte
    * vergleichen.
    **/ 
    public static boolean isSortedAsc(String[] arr){
        boolean b=true;
        for(int i=0; i<arr.length-1;i++){
            if(arr[i].compareTo(arr[i+1])>0){
                b=false;
            }
            
        }
        return b;
    }
    
    
    public static void main(String[] args){
        
        //Aufgabe 17 d)
        int n = 100000;
        int same= 1000;
        for(int i=n;i<3200001;i=i*2){
            //1. Mit der Methode genRandArrSame und same = 100 ein Array der Länge n mit
            //Zufallsstrings belegen.
            QuickS qs= new QuickS(genRandArrSame(i,same));
            //2. Eine Kopie des Arrays aus 1. anlegen.
            MergeS ms=new MergeS(qs.copy());
            /** Die Kopie des Arrays mit dem unter a) implementierten Quicksort sortieren und dabei
                die benötigte Zeit messen. Zur Messung der Zeit können Sie die Klasse Stoppuhr
                verwenden, die Sie schon aus einer anderen Übung kennen. Am Ende (nach Stoppen der
                Uhr!) prüfen Sie mit isSortedAsc, ob das Array sortiert ist, d.h. ob ihre Implementierung
                von Quicksort korrekt ist.
             **/
             Stoppuhr StoppQS=new Stoppuhr();
             Stoppuhr StoppMS=new Stoppuhr();
             
             //Quicksort
             StoppQS.start();
             qs.sort();
             StoppQS.stop();
             System.out.println("Für n="+i+" Zeit Quicksort: "+(StoppQS.getTime()/ 1000000)+"ms");
             System.out.println("Das array ist sortiert: "+isSortedAsc(qs.getArr()));
             
             
             //Mergesort
             StoppMS.start();
             ms.mergeSort();
             StoppMS.stop();
             System.out.println("\nFür n="+i+" Zeit Mergesort: "+(StoppMS.getTime()/ 1000000)+"ms");
             System.out.println("Das array ist sortiert: "+isSortedAsc(ms.getArr()));
             
             //Divider
              System.out.println("\n--------------------\n");
        }
    }
}