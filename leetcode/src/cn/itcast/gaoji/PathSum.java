package cn.itcast.gaoji;

import java.util.ArrayList;

import cn.itcast08_tree.TreeNode;

//���ظ���ֵ ������������·��
public class PathSum {
	ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
   public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
     
       if(root ==null){
           return allList;
       }
        list.add(root.val);
        target -= root.val;
        
       if(target==0&&root.left==null&&root.right==null){
        allList.add(new ArrayList<Integer>(list));
       }
     
    //���еݹ���� ,ע��ǵ÷�����һ��
    FindPath(root.left,target);
    FindPath(root.right,target);
    list.remove(list.size()-1);
    return allList;
        
}
}
