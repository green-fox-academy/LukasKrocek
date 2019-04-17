package blog;

import java.util.ArrayList;

public class Blog {
    /*
       add BlogPosts to the list
       delete(int) one item at given index
       update(int, BlogPost) one item at the given index and update it with another BlogPost
    */
    ArrayList<BlogPost> posts = new ArrayList<>();

    public void add(BlogPost newPost) {
        posts.add(newPost);
    }

    public void delete(int postNumber) {
        posts.remove(postNumber);
    }

    public void update(int postNumber, BlogPost replacement) {
        posts.set(postNumber, replacement);
    }
    @Override
    public String toString() {
        String blogPostsList = "";
        for (int i = 0; i < posts.size(); i++) {
            blogPostsList += (i + 1) + ". " + posts.get(i) + "\n";
        }
        return blogPostsList;
    }
}
