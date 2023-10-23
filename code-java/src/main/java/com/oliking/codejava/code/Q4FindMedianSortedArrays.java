package com.oliking.codejava.code;

public class Q4FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int nLeft = 0, nRight = n-1, mLeft = 0, mRight = m-1, mMid = 0, nMid = 0;
        while(!((m+n)%2==0?(mMid+nMid == (m+n)/2): (mMid+nMid == (m+n)/2-1)) || !((nums1[mMid] >= nums2[nMid] && (nMid+1 > nRight || nums1[mMid] <= nums2[Math.min(nMid+1, nRight)]))
                || (nums2[nMid] >= nums1[mMid] && (mMid+1 > mRight  || nums2[nMid] <= nums1[Math.min(mMid+1, mRight)])))) {
            mMid = (mLeft + mRight)/2;
            nMid = (nLeft + nRight)/2;
            if (nums1[mMid] > nums2[nMid] && nums1[mMid] > nums2[Math.min(nMid+1, nRight)]){
                mRight = Math.max(mMid - 1, mLeft);
                nLeft = Math.min(nMid + 1, nRight);
            }else if ((nums2[nMid] > nums1[mMid] && nums2[nMid] > nums1[Math.min(mMid+1, mRight)])){
                mLeft = Math.min(mMid + 1, mRight);
                nRight = Math.max(nMid-1, nLeft);
            }
        }
        if ((m+n)%2!=0 ){
            return (mMid+nMid+1) > (m+n)/2?Math.min(nums1[mMid], nums2[nMid]):Math.max(nums1[mMid], nums2[nMid]);
        }else{
            if (nMid-1>=0 && nums1[mMid] < nums2[nMid-1]){
                return (nums2[nMid-1] + nums2[nMid])/2.0 ;
            }else if (mMid-1>=0 && nums2[nMid] < nums1[mMid-1]){
                return (nums1[mMid-1] + nums1[nMid])/2.0;
            }
            return (nums1[mMid] + nums2[nMid])/2.0 ;
        }
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,9,10};
        int[] nums2 = new int[]{4,4,5,6};
        System.out.println(new Q4FindMedianSortedArrays().findMedianSortedArraysBetter(nums1, nums2));
    }

    /**
     * 转化为求第k个数
     */
    public double findMedianSortedArraysBetter(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1)/2;
        int right = (m + n + 2)/2;
        return (getKth(left, 0, m-1, 0, n-1, nums1, nums2) + getKth(right, 0, m-1, 0, n-1, nums1, nums2)) * 0.5;
    }

    public int getKth(int k, int left1, int right1, int left2, int right2, int[] nums1, int[] nums2){
        int len1 = right1 - left1 + 1;
        int len2 = right2 - left2 + 1;
        if (len1 > len2) return getKth(k, left2, right2, left1, right1, nums2, nums1);
        if (len1 == 0) return nums2[left2 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int i = left1 + Math.min(k/2, len1) - 1;
        int j = left2 + Math.min(k/2, len2) - 1;
        if (nums1[i] < nums2[j]){
            return getKth(k-(i-left1+1), i+1, right1, left2, right2, nums1, nums2);
        }else{
            return getKth(k-(j-left2+1), left1, right1, j+1, right2, nums1, nums2);
        }
    }
}
