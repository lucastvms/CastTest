package cast.test.bank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Deposit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String cpf;

    @Column(nullable = false, updatable = false)
    private double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpfReceiver) {
        this.cpf = cpfReceiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", value=" + value +
                '}';
    }
}
