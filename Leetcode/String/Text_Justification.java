import java.util.*;
public class Text_Justification {
    public static List<String> fullJustify(String[] words, int maxWidth){
        int i=0;
        List<String> list=new ArrayList<>();
        while(i<words.length){
            int wc=words[i].length();
            int j=i+1;
            int spaceRequire=0;
            while(j<words.length && wc+words[j].length()+spaceRequire+1 <=maxWidth){
                wc+=words[j].length();
                spaceRequire++;
                j++;
            }
            int vac=maxWidth-wc;
            int atleast =spaceRequire==0 ? 0:vac/spaceRequire;
            int extraSpace=spaceRequire==0 ?0:vac%spaceRequire;
            if(j==words.length){
                atleast=1;
                extraSpace=0;
            }
            StringBuilder s=new StringBuilder();
            for(int k=0;k<j;k++){
                s.append(words[k]);
                if(k==j-1) break;
                for(int e=0;e<atleast;e++){
                    s.append(" ");extraSpace--;
                }
                if(extraSpace>0){
                    s.append(" ");
                    extraSpace--;
                }
            }
            while (s.length() < maxWidth)s.append(" ");

               list.add(s.toString());

                 i = j;
        }
        return list;
    }
    public static void main(String[] args) {
        String words[]={"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth=16;
        ArrayList<String> list=(ArrayList<String>) fullJustify(words,maxWidth);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
