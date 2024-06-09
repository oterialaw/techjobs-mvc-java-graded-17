package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;

import java.util.ArrayList;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {
@PostMapping("results")
public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
    model.addAttribute(searchTerm, searchType);
    System.out.println(searchTerm);
    System.out.println(searchType);
    ArrayList<Job> jobs;
    if (searchType.equals("all") && searchTerm.isEmpty()){
        jobs = JobData.findAll();
    } else {
        jobs = JobData.findByColumnAndValue(searchType, searchTerm);
    }
    model.addAttribute("jobs", jobs);
    return "search";
//    model.addAttribute("searchTerm", columnChoices);
//    return "search";
}

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

}


