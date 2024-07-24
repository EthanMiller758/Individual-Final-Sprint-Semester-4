package com.keyin.project;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import java.util.List;


@Controller
@CrossOrigin
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enter-numbers";
    }


    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        Tree tree = treeService.createTree(numbers);
        model.addAttribute("tree", tree);
        return "tree-result";
    }

    @GetMapping("/previous-trees")
    public String getPreviousTrees(Model model) {
        List<Tree> trees = treeService.getAllTrees();
        model.addAttribute("trees", trees);
        return "previous-trees";
    }
}
