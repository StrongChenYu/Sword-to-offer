package sword_to_offer;


public class JZ6 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        
        int l = 0;
        int r = array.length - 1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (array[mid] == array[r] && array[mid] == array[l]) {
                return findNumberInOrder(array);
            }
            
            //等于是为了防止出现相等的情况不移动r,l指针，两者情况下都需要移动指针
            if (array[mid] <= array[r]) {
                r = mid;
            } else if (array[mid] >= array[l]) {
                l = mid;
            } 
            
            if (r - l == 1) {
                 break;
            }
        }
        
        return array[r];
    }
    
    public int findNumberInOrder(int array[]) {
        int min = 0;
        for (int num : array) {
            min = Math.min(min, num);
        }
        
        return min;
    }

}
