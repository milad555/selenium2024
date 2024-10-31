package ClassWork;

public class PrideAndPrejudice extends Book {
    public PrideAndPrejudice(String title, String author, int pageCount) {
        super.title = title;
        super.author = author;
        super.pageCount= pageCount;

    }

  //  @Override
    public boolean isLong() {
        if(getPageCount()< 300){
            System.out.println("yes");
            return true;
        }
        System.out.println("no");
        return false;
    }


    public void displayBook(){
        System.out.println(getContent());
    }
}
