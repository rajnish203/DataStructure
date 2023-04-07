package ArrayList;
import java.util.ArrayList;
public class ArrayListUse{
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(list.size());
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(40);
        for(int i:list){
            System.out.print(i+" ");
        }
        list.add(0, 60);// insert a particular index
        System.out.println();
        for(int i:list){
            System.out.print(i+" ");
        }
        list.set(1, 90);// it will replace the value at a particular index
        Integer i=40;
        System.out.println();
        list.remove(i);// it will remove the value 40 from the list 
        for(int l:list){
            System.out.print(l+" ");
        }
    }
}