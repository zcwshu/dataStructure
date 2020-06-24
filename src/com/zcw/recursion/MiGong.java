package com.zcw.recursion;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:31 2020/6/24
 */
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙,上下全置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的原始情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //使用递归
        //setWay(map,1,1);
        setWay2(map,1,1);
        System.out.println("小球走过,地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找到路,
     * 0没走过,1墙,2通路可以走,3已经走过,走不通
     * 下->右->上->左,如果走不通,再回溯
     *
     * @param map 表示地图
     * @param i   表示从哪个位置开始
     * @param j
     * @return 如果找到通路就返回true, 否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路找到
            return true;
        }else{
            if (map[i][j] == 0){//如果没走过
                //按照策略走
                map[i][j] =2;//假定该点可以走通
                if (setWay(map,i+1,j)){//向下走
                    return true;
                }else if (setWay(map,i,j+1)){//右
                    return true;
                }else if (setWay(map,i-1,j)){//上
                    return true;
                }else if (setWay(map,i,j-1)){//左
                    return true;
                }else{
                    //说明该点走不通
                    map[i][j] =3;
                    return false;
                }
            }else{//如果map[][] != 0,可能1,2,3
                return false;
            }
        }
    }
    //修改策略
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路找到
            return true;
        }else{
            if (map[i][j] == 0){//如果没走过
                //按照策略走
                map[i][j] =2;//假定该点可以走通
                if (setWay2(map,i-1,j)){//向上走
                    return true;
                }else if (setWay2(map,i,j+1)){//右
                    return true;
                }else if (setWay2(map,i+1,j)){//下
                    return true;
                }else if (setWay2(map,i,j-1)){//左
                    return true;
                }else{
                    //说明该点走不通
                    map[i][j] =3;
                    return false;
                }
            }else{//如果map[][] != 0,可能1,2,3
                return false;
            }
        }
    }
}
