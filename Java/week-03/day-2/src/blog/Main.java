package blog;

public class Main {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.add(new BlogPost("James", "about me", "21.6.1999"));
        blog.add(new BlogPost("Thomas", "about you", "17.6.1999"));
        blog.add(new BlogPost("Lukas", "about us", "21.6.2001"));
        blog.add(new BlogPost("Stan", "about them", "21.6.2010"));
        System.out.println(blog);
        System.out.println("----------------");
        blog.delete(1);
        System.out.println(blog);
        System.out.println("----------------");
        blog.update(1, new BlogPost("Thomas", "about you", "17.6.1999"));
        System.out.println(blog);

    }
}
