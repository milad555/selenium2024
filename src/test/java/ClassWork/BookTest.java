package ClassWork;

import java.io.IOException;

public class BookTest {

    public static void main(String[] args) throws IOException {
        Book harry = new HarryPotter("Harry Potter and Doing your taxes", "J.K. Rowling");
        //  System.out.println(harry.getContent());
        // harry.displayBook();
//        harry.rateBook();
//        harry.rateBook(5);
//        harry.rateBook(4,"This book was good");

        PrideAndPrejudice pride = new PrideAndPrejudice("Pride and Prejudice", "Jane Austen", 245);

//        pride.readBook("src/test/resources/data/PrideAndPejudice.txt");
//        pride.displayBook();
//        pride.rateBook();

        DiaryOfWimpyKid diary = new DiaryOfWimpyKid("Diary of Wimpy Kid", "Jeff Kinney ", 350);
        diary.readBook(diary.getFilePath());

//
//        System.out.println("what is page count? "+ diary.getPageCount());
//
//        System.out.println("Is "+ pride.getTitle() + " book long? " + pride.isLong());
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
//prints email if found in the text
//        diary.extractWithRegex(emailRegex);
//        for(String email:diary.extractWithRegex(emailRegex)){
//            System.out.println("Found Emails: " + email);
//        }

        //diary.appendToBook(diary.getFilePath(),"\nHello");
        System.out.println(diary.getTitle());
       // System.out.println(diary.getContent());
    }
}

// create own methods
// override