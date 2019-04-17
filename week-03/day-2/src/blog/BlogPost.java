package blog;

public class BlogPost {
    String authorName;
    String title;
    String text;
    String publicationDate;

    BlogPost(String authorName, String title, String publicationDate) {
        this.authorName = authorName;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        String postDescription = "Title : " + title + ", written by : " + authorName + ", published : " + publicationDate;

        return postDescription;
    }
}
