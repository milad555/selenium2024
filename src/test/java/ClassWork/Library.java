package ClassWork;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class Library {

    private HashMap<Integer, Book> collection;

    public Library() {
        this.collection = new HashMap<>();
    }

    public void addBook(int id, Book book) {
        collection.put(id,book);
    }

    public void removeBook(int id){
        collection.remove(id);
    }
    public void removeBook(Book book){
        collection.values().remove(book);
    }

    public String readBook(int id){
        return collection.get(id).getContent();
    }

    public Collection<Book> displayLibrary(){
        return collection.values();
    }

    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        lib.addBook(123, new DiaryOfWimpyKid("AA","bb", 123));
//System.out.println(lib.readBook(123));
      //  System.out.println(lib.displayLibrary());
        DiaryOfWimpyKid diary = new DiaryOfWimpyKid("aa", "bb", 12);
        System.out.println(diary.getTitle());
    }
}
