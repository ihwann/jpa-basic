package hello.jpa.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@Setter
public class Member {

    @Id
    private Long id;
    private String name;

}
