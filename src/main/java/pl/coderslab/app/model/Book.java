package pl.coderslab.app.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "ksiazki")
public class Book {

    //najlepiej mieć walidację na KAŻDYM etapie
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private BigInteger id;

    @Column(nullable = false, length =  100)
//    @Min(value = 5)
//    @Max(value = 100)
    @NotBlank //czy ktoś nie podal pustego stringa ""
    @Size(min = 5, max = 100)
    private String title;

    @Column(nullable = false)
    @NotNull  //przejdzie nam dowolna treść
    @Min(value = 1)
    @Max(value = 10)
    private int rating;

    @Column(length = 600)
    @Size(max = 600)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "publisher_id")
    @NotNull
    private  Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Min(value = 2)  // jeśli będzie nullem to ta walidacja w ogóle nie będzie sprawdzana
    private Integer pages;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> auth) {
        this.authors = auth;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher;
    }
}