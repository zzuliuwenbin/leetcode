package pkg;

import java.util.HashMap;

public class MajorityElement {
	
	public int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		int q=-1,k=-1;
		for(int j:map.keySet()) {
			if(map.get(j)>k) {
				q = j;
				k = map.get(j);
			}
		}
		return q;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement test = new MajorityElement();
		System.out.println(test.majorityElement(new int[]{3,1,1}));
	}

}
