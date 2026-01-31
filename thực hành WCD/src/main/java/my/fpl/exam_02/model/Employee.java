package my.fpl.exam_02.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @Column(name = "employee_id", length = 20, nullable = false)
    private String employeeId;

    @Column(name = "employee_name", length = 64, nullable = false)
    private String employeeName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    public Employee() {}

    public Employee(String employeeId, String employeeName, LocalDate birthday, String phoneNumber, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}