package com.example.trialexam.controllers;

import com.example.trialexam.models.Link;
import com.example.trialexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    private LinkService linkService;

    @Autowired
    public ApiController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/api/links")
    public List<Link> getAllLinks() {
        return linkService.getAllLinks();
    }

    @DeleteMapping("/api/links/{id}")
    public ResponseEntity deleteLink(@PathVariable Long id, @RequestBody CodeHolder codeHolder) {
     if(id==null||!linkService.iDExists(id)){
         return new ResponseEntity<>(HttpStatus.valueOf(404));
     }
     Link link = linkService.findLinkById(id);
     if (!link.getSecretCode().equals(codeHolder.secretCode)){
         return new ResponseEntity<>(HttpStatus.valueOf(403));
     }
     linkService.deleteLink(link);
     return new ResponseEntity<>(HttpStatus.valueOf(204));
    }
}

class CodeHolder {
    public String secretCode;
}