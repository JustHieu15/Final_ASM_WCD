package my.fpl.exam_01.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbProducts")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "details")
    private String details;

}
