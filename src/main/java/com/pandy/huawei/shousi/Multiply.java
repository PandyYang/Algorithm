package com.pandy.huawei.shousi;

public class Multiply {
    public String multiply(String num1, String num2) {
        int len1=num1.length(),len2=num2.length();
        if(len1<1||len2<1){
            return "0";
        }
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] res=new int[len1+len2];
        for(int i=len1-1;i>=0;--i){
            for(int j=len2-1;j>=0;--j){
                int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+res[i+j+1];
                res[i+j+1]=temp%10;
                res[i+j]+=temp/10;
            }
        }
        int start=0;
        while(res[start]==0&&start<len1+len2){
            start++;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=start;i<res.length;++i){
            ans.append(res[i]);
        }
        return ans.toString();

    }
}
