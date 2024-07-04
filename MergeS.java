public class MergeS{
    
    private static String[] array;
    
    //constructpor
    public MergeS(String[] arrInput){
        this.array=arrInput;
    }
    
    
    
    
    public static void mergeAB(String[] ziel, int zielL, String[] a, int al, int ar, String[] b, int bl, int br) {
        int i = al; // Läuft über Eingabe a
        int j = bl; // Läuft über Eingabe b
        for (int k = zielL; k < zielL + (ar - al + 1) + (br - bl + 1); k++) {
            if (i > ar) {
                // a ist bereits erschöpft
                ziel[k] = b[j++];
                continue;
            }
            if (j > br) {
                // b ist bereits erschöpft
                ziel[k] = a[i++];
                continue;
            }
            if (a[i].compareTo(b[j]) < 0) {
                ziel[k] = a[i++];
            } else {
                ziel[k] = b[j++];
            }
        }
    }
    
    
    // Mergesort von b nach a
    // im Bereich [l..r]
    public static void mergeSortABr(String[] a, String[] b, int l, int r){
        if (r <= l) {
            return;
        } else {
            int mid = (l + r) / 2;
            mergeSortABr(b, a, l, mid); // links
            mergeSortABr(b, a, mid + 1, r); // rechts
            // Mischen nach a
            mergeAB(a, l,
            b, l, mid, // linker Teil
            b, mid + 1, r); // rechter Teil
        }
    }
    
    
    public static void mergeSort() {
        String[] b = new String[array.length]; // Hilfsarray
        for (int i = 0; i < array.length; i++) { // a nach b kopieren
            b[i] = array[i];
        }
        mergeSortABr(array, b, 0, array.length - 1);
    }
    
   
    void printArr(){
        for(int i=0;i<array.length;i++){
            System.out.print("["+array[i]+"]\n");
        }
        System.out.print("\n");
    }
    
    
    public String[] getArr(){
        return array;
    }
    
    
    public String[] copy(){
        String[] arrcopy= new String[array.length];
        for(int i=0;i<array.length;i++){
            arrcopy[i]=array[i];
        }
        return arrcopy;
    }
}