package com.keyin.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    public Tree createTree(String numbers) {
        List<Integer> numberList = Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        Tree tree = new Tree();
        tree.setNumbers(numbers);
        tree.buildTree(numberList);
        treeRepository.save(tree);
        return tree;
    }

    public List<Tree> getAllTrees() {
        Tree tree1 = new Tree();
        tree1.setNumbers("8,9,10");
        tree1.setTreeStructure("{\"root\": {\"value\":9,\"left\":{\"value\":8,\"left\":null,\"right\":{\"value\":10,\"left\":null,\"right\":null}}}");

        Tree tree2 = new Tree();
        tree2.setNumbers("11,12,13");
        tree2.setTreeStructure("{\"root\": {\"value\":12,\"left\":{\"value\":11,\"left\":null,\"right\":null},\"right\":{\"value\":13,\"left\":null,\"right\":null}}}");

        return Arrays.asList(tree1, tree2);
    }
}
