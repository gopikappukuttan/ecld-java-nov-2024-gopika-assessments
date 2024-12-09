package hard;

public class ACapitalChallenge {
    public static String selectLetters(String s1, String s2) {
    char[] c1=s1.toCharArray();
    char[] c2=s2.toCharArray();
    int length=1;
    StringBuilder result=new StringBuilder();
    if(c1.length>c2.length){
        length=c1.length;
    }else{
        length=c2.length;
    }
    for(int i=0;i<length;i++){
        if(Character.isUpperCase(c1[i])){
            result.append(c2[i]);
        }
        if(Character.isUpperCase(c2[i])){
            result.append(c1[i]);
        }
    }
    return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(selectLetters("heLLO", "GUlp"));
        System.out.println(selectLetters("1234567", "XxXxX"));
        System.out.println(selectLetters("EVERYTHING", "SomeThings"));
    }

}
