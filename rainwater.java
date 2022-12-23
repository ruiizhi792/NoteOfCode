
   /* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 

    示例 1：
    
    
    
    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水） */
class Solution {
    public int trap(int[] height) {
        int max=0;
        for(int i=1;i<height.length-1;i++)//去掉两边
        {
        int left=0;
        int right=0;
        for(int m=i-1;m>=0;m--)//左边最大
        {
            if(height[m]>left)
            left=height[m];
        }
        for(int n=i+1;n<height.length;n++)//右边最大
        {
            if(height[n]>right)
            right=height[n];
        }
         int min=Math.min(left,right);//取最小值
         if(min>height[i])
         {
             max=max+(min-height[i]);
         }
        }
        return max;
    }
    }