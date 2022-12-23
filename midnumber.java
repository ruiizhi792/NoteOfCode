
    /*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。

 

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, medium = 0;
        if ((m + n) % 2 == 0) {
            medium = (m + n) / 2 - 1;
        } else if ((m + n) % 2 != 0){
            medium = (m + n) / 2;
        }
        int index1 = 0, index2 = 0;
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 0 && n != 0) {
            if (n % 2 == 0) {
                return (double)(nums2[medium] + nums2[medium + 1]) / 2;
            } else if (n % 2 != 0) {
                return nums2[medium];
            }
        } else if (m != 0 && n == 0) {
            if (m % 2 == 0) {
                return (double)(nums1[medium] + nums1[medium + 1]) / 2;
            } else if (m % 2 != 0) {
                return nums1[medium];
            }
        }
        int count = 0, next = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                if (count == medium) {
                    if ((m + n) % 2 == 0) {
                        if (index1 == m - 1){
                            next = nums2[index2];
                        } else {
                            next = Math.min(nums1[index1 + 1], nums2[index2]);
                        }
                        return (double)(nums1[index1] + next) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums1[index1];
                    }
                }
                if (index1 != m - 1) {
                    ++index1;
                    ++count;
                }
                else {
                    if ((m + n) % 2 == 0) {
                        return (double)(nums2[medium - m] + nums2[medium - m + 1]) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums2[medium - m];
                    }
                }  
            } else if (nums1[index1] > nums2[index2]){
                if (count == medium) {
                    if ((m + n) % 2 == 0) {
                        if (index2 == n - 1){
                            next = nums1[index1];
                        } else {
                            next = Math.min(nums1[index1], nums2[index2 + 1]);
                        }
                        return (double)(nums2[index2] + next) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums2[index2];
                    }
                }
                if (index2 != n - 1) {
                    ++index2;
                    ++count;
                } else {
                    if ((m + n) % 2 == 0) {
                        return (double)(nums1[medium - n] + nums1[medium - n + 1]) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums1[medium - n];
                    }
                }  
            } else {
                if (count == medium) {
                    if ((m + n) % 2 == 0) {
                        if (index1 == m - 1){
                            next = nums2[index2];
                        } else {
                            next = Math.min(nums1[index1 + 1], nums2[index2]);
                        }
                        return (double)(nums1[index1] + next) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums1[index1];
                    }
                }
                if (index1 != m - 1) {
                    ++index1;
                    ++count;
                }
                else {
                    if ((m + n) % 2 == 0) {
                        return (double)(nums2[medium - m] + nums2[medium - m + 1]) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums2[medium - m];
                    }
                }  
                if (count == medium) {
                    if ((m + n) % 2 == 0) {
                        if (index2 == n - 1){
                            next = nums1[index1];
                        } else {
                            next = Math.min(nums1[index1], nums2[index2 + 1]);
                        }
                        return (double)(nums2[index2] + next) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums2[index2];
                    }
                }
                if (index2 != n - 1) {
                    ++index2;
                    ++count;
                } else {
                    if ((m + n) % 2 == 0) {
                        return (double)(nums1[medium - n] + nums1[medium - n + 1]) / 2;
                    } else if ((m + n) % 2 != 0) {
                        return nums1[medium - n];
                    }
                }  
            }
        }
        return 0;
    }
}

