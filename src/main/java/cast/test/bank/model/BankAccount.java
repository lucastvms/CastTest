package cast.test.bank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String cpf;

    private String name;
    private double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
