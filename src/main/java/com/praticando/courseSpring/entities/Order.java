package com.praticando.courseSpring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.praticando.courseSpring.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "tb_orders")
public class Order implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;


    private Integer orderStatus;

    // Significa o relacionamento de um cliente com varias pedidos
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new java.util.HashSet<>();

    @OneToOne (mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(){
    }

    public Order(Long id, Instant moment,OrderStatus OrderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(OrderStatus);
        this.client = client;
    }
    public Long getId() {
        return id;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }

    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.ValueOf(orderStatus);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (OrderItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
