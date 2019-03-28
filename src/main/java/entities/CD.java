package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CD {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 200)
    private String description;

    @Column(length = 4)
    private String year;

   // @Column(length = 200)
   // private String artist;

    @Column
    private Double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Artist> musicians = new HashSet<Artist>();

    public CD() {
    }

    public CD(String title, String description, String year, Set<Artist> artist, Double price) {
        this.title = title;
        this.description = description;
        setYear(year);
        this.musicians = artist;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year.substring(0, 4);
    }

    public Set<Artist> getArtist() {
        return this.musicians;
    }

    public void setArtist(Set<Artist> artist) {
        this.musicians = artist;
    }

    public Double price() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
