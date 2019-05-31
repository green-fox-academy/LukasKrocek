package com.example.reddit.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private PostRepo posts;
    private int pageSize = 4;
    private List<Integer> pageNumbers;


    @Autowired
    public PostService(PostRepo posts) {
        this.posts = posts;
    }

    public List<Post> getPage(int numberOfPage) {
        return posts.findAllOnPage(PageRequest.of(numberOfPage - 1, pageSize));
    }

    public int getNumberOfPages() {
        return posts.findAll().size() / pageSize;
    }

    public List<Integer> getPageNumberList() {
        pageNumbers = new ArrayList<>();
        int numberOfPage = 0;
        for (int i = 0; i < getNumberOfPages(); i++) {
            numberOfPage++;
            pageNumbers.add(numberOfPage);
        }
        return pageNumbers;
    }
}
