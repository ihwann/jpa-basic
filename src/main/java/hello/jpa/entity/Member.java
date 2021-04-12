package hello.jpa.entity;
import hello.jpa.enum2.RoleType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "member-seq-generator", sequenceName = "member_seq")
public class  Member {

    @Id // pk 매핑 id를 직접 할당
    //@GeneratedValue(strategy = GenerationType.AUTO)  DB 방언에 맞춰 값을 위임
    @GeneratedValue(
            strategy = GenerationType.IDENTITY // DB 방언에 맞춰 값을 위임 (mysql auto_increment))
                                                // 기본키를 테이블에 insert 되어야 기본키를 알 수 있기 때문에
                                                // IDENTITY 전략은 예외적으로 커밋이 아닌 persist 장면에서 db insert 된다.
            , generator = "member-seq-generator")
    private Long id;

    @Column(name = "name")
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum 타입 매핑, ORDIANL(enum의 순서를 저장) 사용을 지양하자
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜시간 타입 매핑
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP) // 날짜시간 타입 매핑
    private Date lastModifiedDate;

    @Lob // text랑 비슷한가?
    private String description;

    @Transient // db 와 맵핑되지 않고 메모리상에서 연산하고자 할 때
    private String temp;
}
