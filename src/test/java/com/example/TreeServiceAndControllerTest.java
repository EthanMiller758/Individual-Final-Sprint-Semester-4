package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.keyin.project.Tree;
import com.keyin.project.TreeController;
import com.keyin.project.TreeRepository;
import com.keyin.project.TreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class TreeServiceAndControllerTest {

    @Mock
    private TreeRepository treeRepository;

    @InjectMocks
    private TreeService treeService;

    @InjectMocks
    private TreeController treeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTree() {
        Tree tree = new Tree();
        String numbers = "3,1,4,1,5,9,2,6,5";
        tree.setNumbers(numbers);
        tree.buildTree(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 9));

        when(treeRepository.save(tree)).thenReturn(tree);

        Tree result = treeService.createTree(numbers);
        assertEquals(numbers, result.getNumbers(), "The numbers field should match the input");
    }

    @Test
    public void testGetAllTrees() {
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        List<Tree> trees = Arrays.asList(tree1, tree2);

        when(treeRepository.findAll()).thenReturn(trees);

        List<Tree> result = treeService.getAllTrees();
        assertEquals(2, result.size(), "The size of the returned list should be 2.");
    }

    @Test
    public void testEnterNumbers() {
        String viewName = treeController.enterNumbers();
        assertEquals("enter-numbers", viewName, "The view name should be 'enter-numbers'.");
    }
}
