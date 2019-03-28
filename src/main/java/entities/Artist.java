package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 15)
    private String first_name;

    @Column(length = 20)
    private String last_name;

    @Column(length = 25)
    private String instrument;

    public Artist(){}

    public Artist( String first_name, String last_name, String instrument){
        this.first_name = first_name;
        this.last_name = last_name;
        this.instrument = instrument;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirst_name(){
        return this.first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return this.last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public String getInstrument(){
        return this.instrument;
    }

    public void setInstrument(String instrument){
        this.instrument = instrument;
    }
}
