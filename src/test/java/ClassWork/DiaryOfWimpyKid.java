package ClassWork;

public class DiaryOfWimpyKid extends Book {


    public DiaryOfWimpyKid(String title, String author, int pageCount) {
        super.title = title;
        super.author = author;
        super.pageCount = pageCount;
    }

    public String getFilePath() {
        return filePath;
    }

    private String filePath = "src/test/resources/data/DiaryOfAWimpyKid.txt";

    @Override
    public void displayBook() {
        System.out.println(getContent());
    }

    @Override
    public boolean isLong() {
        if (getPageCount() > 300) {
            System.out.println("this book is long");
            return true;
        } else {
            System.out.println("this book is short");
            return false;
        }
    }


}
