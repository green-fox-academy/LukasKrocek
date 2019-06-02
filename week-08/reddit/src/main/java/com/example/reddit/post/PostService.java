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

    @Autowired
    public PostService(PostRepo posts) {
        this.posts = posts;
    }

    public List<Post> getPage(Integer numberOfPage) {
        if (numberOfPage == null) {
            return posts.findAllOnPage(PageRequest.of(0, pageSize));
        }
        return posts.findAllOnPage(PageRequest.of(numberOfPage - 1, pageSize));
    }

    private int getNumberOfPages() {
        int numberOfPages = posts.findAll().size()/pageSize;
        return (int)(Math.ceil((double)posts.findAll().size() / pageSize));
    }

    public List<Integer> getPageNumberList() {
        List<Integer> pageNumbers = new ArrayList<>();
        int numberOfPage = 0;
        for (int i = 0; i < getNumberOfPages(); i++) {
            numberOfPage++;
            pageNumbers.add(numberOfPage);
        }
        return pageNumbers;
    }
}
