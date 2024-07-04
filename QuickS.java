public class QuickS{
    
    private static String[] array;
    
    //constructpor
    public QuickS(String[] arrInput){
        this.array=arrInput;
    }
    
    
    
    public static void swap(String[] arr, int i, int j) {
        String h = arr[i];
        arr[i] = arr[j];
        arr[j] = h;
      }
    
    
    private static int partition(String[] arr, final int l, final int r) {
        int i = l - 1;
        int j = r;
        mean(arr, l, r);
        while (i < j) {
            while (arr[++i].compareTo(arr[r]) <= 0) { // erstes Element von links
                if (i == r) // das > Vergleichselement
                    break;
            }
            while (arr[--j].compareTo(arr[r]) > 0) { // erstes Element von rechts
                if (j == l) // das < Vergleichselement
                    break;
            }
            if (i < j) { // Vertausche die beiden
                swap(arr, i, j);
            }
        }
        swap(arr, r, i); // Setze Vergleichselement zwischen
        return i; // die kleineren und grösseren
    }


   
    public static void mean(String[] arr, final int l, final int r) {
        int mean = (l + r) / 2; // mittleres Element bestimmen
        swap(arr, mean, r); // ans Ende setzen
    }

    
    public static void quicksort(String[] arr,final int l, final int r) {
        int m = partition(arr, l, r);
        if (l < m - 1) {
            quicksort(arr, l, m - 1);
        }
        if (m + 1 < r) {
            quicksort(arr, m + 1, r);
        }
    }
        
        
    public void printArr(){
        for(int i=0;i<array.length;i++){
            System.out.print("["+array[i]+"]\n");
        }
        System.out.print("\n");
    }
    
    public static void sort(){
        quicksort(array, 0, array.length-1);
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