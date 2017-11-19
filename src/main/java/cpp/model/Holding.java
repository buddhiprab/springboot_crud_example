package cpp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "holding")
public class Holding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private String amount;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name="owner_id")
    private User owner;
}
