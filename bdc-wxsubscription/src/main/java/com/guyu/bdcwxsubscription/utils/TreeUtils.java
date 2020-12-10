package com.guyu.bdcwxsubscription.utils;

import com.guyu.bdcwxsubscription.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄盼
 * @Title: 树形结构工具类
 * @Description:
 * @date 2020/12/10 9:15
 */
public class TreeUtils {


    //把一个List转成树
    public static List<TreeNode> buidTree(List<TreeNode> list) {
        List<TreeNode> tree = new ArrayList<>();
        list.forEach(s -> {
            if (s.getPid() == 0) {
                tree.add(findChild(s, list));
            }
        });
        return tree;
    }

    //循环递归
    public static TreeNode findChild(TreeNode node, List<TreeNode> list) {
        list.forEach(s -> {
            if (s.getPid().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<TreeNode>());
                }
                node.getChildren().add(findChild(s, list));
            }
        });
        return node;
    }

    public static void main(String[] args) {

    }
}
