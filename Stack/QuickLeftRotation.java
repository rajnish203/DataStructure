public class QuickLeftRotation {

    public static void leftRotate(int[] arr, int d, int n) {
       if(d==0){
        return;
       }
       int length=arr.length-1;
       int temp=arr[length];
       arr[length]=arr[0];
       arr[0]=temp;
      leftRotate(arr, d-1, length);

      for(int i:arr){
        System.out.print(i+" ");
      }
      
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;
        leftRotate(arr, d, n);
        
    }
}
