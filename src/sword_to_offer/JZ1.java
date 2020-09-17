package sword_to_offer;

//find number in an two-dimensional array
public class JZ1 {

//    public boolean Find(int target, int [][] array) {
//
//        if (array == null || array.length == 0) return false;
//        //垃圾时间复杂度
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                if (array[i][j] == target) return true;
//            }
//        }
//        return false;
//
//
//
//        return false;
//
//    }

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;

        int i = 0; int j = array[0].length - 1;

        while (i < array.length && j >=0) {
            if (array[i][j] == target) return true;
            else if (array[i][j] > target){
                j--;
            }else{
                i++;
            }
        }

        return false;
    }

}
