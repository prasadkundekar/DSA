// class Solution{
//     public int[] twoSum(int nums[],int target){
//         Map<Integer,Interger>m = new HahMap<>();
//         for(i=0;;++i){
//             int x = nums[i];
//             int y = target - x;
//             if(m.containKey(y)){
//                 return new int[]{m.get(y),i};
//             }
//             m.put(x,i)
//         }
//     }
// }


class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hash = new HashMap<>();
        
        for(int i =0; i < nums.length; i++){
            int result = target -nums[i];

            if(hash.containsKey(result)){
                return new int[]{hash.get(result), i};
            }
            hash.put(nums[i],i);
        }
        return new int[]{};

    }
}