package springdemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
    //define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    //define constructors

    //we have to define empty constructor even if we do not use it
    //Spring will use
    public Users(){

    }

    public Users(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    //define getter & setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ",name='" + name + '\''+
                ",surname='" + surname + '\''+
                '}';
    }
}
