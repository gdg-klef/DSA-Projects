// Approach 1 ) Use result auxiliary arr to store elements at their correct positions as of ouput.

public void rotate(int[] nums, int k) {
        if(nums.length==1)
        return ;
        int []arr=new int[nums.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[(i+k)%arr.length]=nums[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            nums[i]=arr[i];
        }
    }

//Approach 2 ) In-place change : 1)full reverse 2)first half reverse(0,k-1) 3)second half reverse (k,n-1)

 public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
