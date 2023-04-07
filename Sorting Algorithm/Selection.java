public class Selection{
    public static int[] selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length; j++){
             if(arr[i]>arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
             }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
     int arr[]={2,7,4,9,5};
     int arr2[]=selectionSort(arr);
    for(int i=0;i<arr2.length;i++){
        System.out.print(arr2[i]+" ");
    }
  }
}