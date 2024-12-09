public class HowMuchIsTrue {
    public static int countTrue(boolean[] arr) {
        int count = 0;
        for(boolean value:arr){
            if(value){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countTrue(new boolean[]{true, false, false, true, false}));
        System.out.println(countTrue(new boolean[]{false, false, false, false}));
        System.out.println(countTrue(new boolean[]{}));
    }
}
