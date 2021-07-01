package cast.test.bank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String cpfSender;

    @Column(nullable = false, updatable = false)
    private String cpfReceiver;

    @Column(nullable = false, updatable = false)
    private double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfSender() {
        return cpfSender;
    }

    public void setCpfSender(String cpfSender) {
        this.cpfSender = cpfSender;
    }

    public String getCpfReceiver() {
        return cpfReceiver;
    }

    public void setCpfReceiver(String cpfReceiver) {
        this.cpfReceiver = cpfReceiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", cpfSender='" + cpfSender + '\'' +
                ", cpfReceiver='" + cpfReceiver + '\'' +
                ", value=" + value +
                '}';
    }
}
