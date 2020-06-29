package pl.suchan.apstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orderinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInformations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private int quantity;
}
