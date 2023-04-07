import javax.swing.plaf.synth.SynthStyle;

public class Bubble{
    public static int[] BubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>=arr[j]){
                    int temp =arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={2,5,1,7,4,9,8};
        int arr2[]=BubbleSort(arr);

        // print the sorted array;
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }
}
