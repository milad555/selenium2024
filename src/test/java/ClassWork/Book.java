package ClassWork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Book {

    String title;
    String author;
    int pageCount;

    private String content;

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //abstract methods can't have a body
    public abstract void displayBook();

    public void readBook(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        content = new String(fileBytes);

    }

    public abstract boolean isLong();

    public int getPageCount(){
        return pageCount;
    }

    public void rateBook() {
        System.out.println("You left no rating");
    }

    public void rateBook(int rating) {
        System.out.println("You left a rating: " + rating);
    }

    public void rateBook(int rating, String review) {
        System.out.println("You left a rating: " + rating);
        System.out.println("Your review: " + review);
    }
    // Method to extract text based on a regex pattern
    public List<String> extractWithRegex(String regex) {
        ArrayList<String> s = new ArrayList<>() ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
             s.add(matcher.group());
        }
        return s;
    }

    public void appendToBook(String filePath, String textToAdd) throws IOException {
        Files.write(Paths.get(filePath), textToAdd.getBytes(), StandardOpenOption.APPEND);
    }
}
