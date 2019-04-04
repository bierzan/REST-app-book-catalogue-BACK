package pl.coderslab.app;

import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import pl.coderslab.app.dto.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getBookById(long id) {
        Book book = null;
        try {
            book = this.list.stream()
                    .filter(x-> x.getId()==id)
                    .findFirst()
                    .orElseThrow(()->new Exception("nie ma książki o podanym id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}