package com.guyu.bdcwxsubscription.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 黄盼
 * @Title: 树形结构
 * @Description:
 * @date 2020/12/10 9:20
 */
@Data
public class TreeNode {
    private Integer id;
    private Integer pid;
    private String name;
    private List<TreeNode> children;

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

}
