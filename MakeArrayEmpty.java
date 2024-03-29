import java.util.HashMap;

public class MakeArrayEmpty {
    public static int minOperations(int[] nums) {
        HashMap<Integer,Integer> temp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            if(temp.containsKey(a)){
                temp.put(a, temp.get(a)+1);
            }else{
                temp.put(a,1);
            }
        }

        int counter = 0;

        for(int a : temp.keySet()){

            if(temp.get(a)%3 == 0){
                counter += temp.get(a)/3;
            }else if(temp.get(a)%2 == 0){

                int val = temp.get(a);
                int mul = 0;

                while(val > 6){
                    val -= 6;
                    mul++;
                }
                counter += val/2;
                counter += mul*2;
            }else{
                int newNumber = temp.get(a);
                while(newNumber>4){
                    counter++;
                    newNumber -= 3;
                }
                if(newNumber%2 != 0){
                    return -1;
                }
                counter += newNumber/2;
            }

        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {19,19,19,19,19,19,19,19,19,19,19,19,19};
        System.out.println(minOperations(nums));
    }
}
