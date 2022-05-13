package leetcode.dynamicproblem;

import org.junit.Test;
import structure.TreeNode;

public class P968_Binary_Tree_Cameras {

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        Status status = minCameraCoverForNode(root);
        return Math.min(status.camera, status.coverBySon);
    }

    public static class Status {
        public int camera;
        public int coverByParent;
        public int coverBySon;

        public Status(int ifCamera, int ifCoverByParent, int ifCoverBySon) {
            this.camera = ifCamera;
            this.coverByParent = ifCoverByParent;
            this.coverBySon = ifCoverBySon;
        }
    }

    public Status minCameraCoverForNode(TreeNode node) {
        if (node == null) {
            return new Status(1001, 0, 0);
        }

        if (node.left == null && node.right == null) {
            // 叶子节点
            return new Status(1, 0, 1);
        }

        Status leftStatus = minCameraCoverForNode(node.left);
        Status rightStatus = minCameraCoverForNode(node.right);
        /*
        状态可以理解为要求节点做某事：
        比如：要求子节点安装摄像头，要求子节点被父节点的摄像头覆盖
        比如：子节点要求null安装camera，明显不行
         */

        // 当前安装摄像头
        int camera = 1 + leftStatus.coverByParent + rightStatus.coverByParent;
        camera = Math.min(camera, 1 + leftStatus.camera + rightStatus.coverByParent);
        camera = Math.min(camera, 1 + leftStatus.coverByParent + rightStatus.camera);

        // 当前被父节点覆盖
        int coverByParent = leftStatus.camera + rightStatus.camera;
        coverByParent = Math.min(coverByParent, leftStatus.camera + rightStatus.coverBySon);
        coverByParent = Math.min(coverByParent, leftStatus.coverBySon + rightStatus.camera);
        coverByParent = Math.min(coverByParent, leftStatus.coverBySon + rightStatus.coverBySon);

        // 当前节点被子节点覆盖
        int coverBySon = leftStatus.camera + rightStatus.camera;
        coverBySon = Math.min(coverBySon, leftStatus.camera + rightStatus.coverBySon);
        coverBySon = Math.min(coverBySon, leftStatus.coverBySon + rightStatus.camera);

        return new Status(camera, coverByParent, coverBySon);
    }

    /**
     *
     * @param node
     * @param ifCamera
     * @param ifCover
     * @return
     */
    public int minCameraCoverForNode(TreeNode node, boolean ifCamera, boolean ifCover) {
        if (node == null) {
                // A这条搜索路径要在null处安装摄像头，那么此路不通
            return ifCamera ? 1001 : 0;
        }

//        if (node.left == null && node.right == null) {
//            // 叶子节点
//            if (!ifCover) {
//                // 如果没有被覆盖，说明此路不通，就会在null节点上尝试安装摄像头，那么就会触发A条件
//                return 10001;
//            } else {
//                // 如果被覆盖，就看看叶子节点有没有安装摄像头
//                return camera ? 1 : 0;
//            }
//        }

        // 无论怎么放都会存在解
        if (ifCamera) {
            // 说明当前节点有摄像头覆盖，说明我在这个node处要放置摄像头

            // 1. 左节点和右节点不放摄像头
            int notPutOnLeft = minCameraCoverForNode(node.left, false, true);
            int notPutOnRight = minCameraCoverForNode(node.right, false, true);


            // 2. 左节点放摄像头, 右节点不安
            int putOnLeft = minCameraCoverForNode(node.left, true, true);
//            minCameraCoverForNode(node.right, false, true);

            // 3. 右节点放摄像头
            int putOnRight = minCameraCoverForNode(node.right, true, true);
//            minCameraCoverForNode(node.left, false, true);

            int res = 1 + notPutOnLeft + notPutOnRight;
            res = Math.min(res, 1 + putOnLeft + notPutOnRight);
            return Math.min(res, 1 + notPutOnLeft + putOnRight);

        } else if (ifCover) {
            // 这个节点如果不放置摄像头的话，那么只能说明被父节点或者被子节点监控了，那么这个ifCover必为true

            /*
            1.这个node被父亲监控
             */

            // 1.1 左右节点都安装摄像头
            int putOnLeft = minCameraCoverForNode(node.left, true, true);
            int putOnRight = minCameraCoverForNode(node.right, true, true);

            // 1.2 左节点装右节点不装
//            minCameraCoverForNode(node.left, true, true);
            int notPutOnRight = minCameraCoverForNode(node.right, false, false);

            // 1.3 左节点不装右节点装
            int notPutOnLeft = minCameraCoverForNode(node.left, false, false);
//            minCameraCoverForNode(node.right, true, true);

            // 1.4 左右节点都不装
//            minCameraCoverForNode(node.left, false, false);
//            minCameraCoverForNode(node.left, false, false);

            int res = putOnLeft + putOnRight;
            res = Math.min(res, putOnLeft + notPutOnRight);
            res = Math.min(res, notPutOnLeft + putOnRight);
            return Math.min(notPutOnLeft + notPutOnRight, res);
        } else {
            // 没有摄像头，这个节点也没有被监控，那么这时候子节点必须装

            /*
            2. 这个node被子节点监控
             */

            // 2.1 两个都装
            int putOnLeft = minCameraCoverForNode(node.left, true, true);
            int putOnRight = minCameraCoverForNode(node.right, true, true);

            // 2.2 左节点装右节点不装
//            minCameraCoverForNode(node.left, true, true);
            int notPutOnRight = minCameraCoverForNode(node.right, false, false);

            // 2.3 右节点装左节点不装
            int notPutOnLeft = minCameraCoverForNode(node.left, false, false);
//            minCameraCoverForNode(node.right, true, true);

            int res = putOnLeft + putOnRight;
            res = Math.min(res, putOnLeft + notPutOnRight);
            return Math.min(res, notPutOnLeft + putOnRight);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        System.out.println(minCameraCover(root));
    }
}
