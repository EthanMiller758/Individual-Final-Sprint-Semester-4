package com.keyin.project;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.Transient;
import java.util.Collections;
import java.util.List;

@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String numbers;

    @Column(columnDefinition = "TEXT")
    private String treeStructure;

    @Transient
    private TreeNode root;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }

    public void buildTree(List<Integer> numberList) {
        Collections.sort(numberList);
        root = sortedListToBST(numberList, 0, numberList.size() - 1);
        treeStructure = "{\"root\": " + treeToJson(root) + "}";
    }

    private TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = sortedListToBST(list, start, mid - 1);
        node.right = sortedListToBST(list, mid + 1, end);
        return node;
    }

    private String treeToJson(TreeNode node) {
        if (node == null) {
            return "null";
        }
        return "{" +
                "\"value\":" + node.value + "," +
                "\"left\":" + treeToJson(node.left) + "," +
                "\"right\":" + treeToJson(node.right) +
                "}";
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
