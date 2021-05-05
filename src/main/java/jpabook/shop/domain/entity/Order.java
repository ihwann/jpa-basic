package jpabook.shop.domain.entity;

import jpabook.shop.domain.enumgroup.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDERDATE")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus staus;


    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
