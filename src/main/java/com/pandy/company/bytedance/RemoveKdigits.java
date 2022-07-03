package com.pandy.company.bytedance;

import java.util.Deque;
import java.util.LinkedList;

class RemoveKdigits {
    public String removeKdigits(String num, int k) {
      //维护一个双端队列
      Deque<Character> deque = new LinkedList<Character>();

		int leght = num.length();

		for (int i = 0; i < leght; i++) {
			char c = num.charAt(i);

			//当且仅当K>0 并且队尾元素大于要入队的元素的时候就把队尾元素移除掉
			while (!deque.isEmpty()&& k>0 && deque.peekLast()>c){
                                 deque.pollLast();
                                 k--;
			}
                        //如果不大于则直接入队
			deque.offerLast(c);
		}
                //此时如果K还大于0 队列里面的元素已经为单调不降了。则最后依次移除队列尾部剩余的k数次即可，
               //拿123456728 k=7 举例说明
               //入队完后 队列里面为1228 此时k=2 所以还需要依次移除尾部2和8  剩余12即为最小
		for (int i = 0; i < k; i++) {
			deque.pollLast();
		}
		boolean flag =true;
		StringBuffer res = new StringBuffer();
                //从队列头部取出所有元素
		while (!deque.isEmpty()){
			Character character = deque.pollFirst();
                       //防止前导0 也就是队头第一个元素==0 则需要跳过。
			if(flag && character=='0'){
				continue;
			}
			flag=false;
			res.append(character);
		}
                //返回结果
		return res.length()==0?  "0" :res.toString();
    }
}
