package com.praticando.courseSpring.entities.pk;

import com.praticando.courseSpring.entities.Order;
import com.praticando.courseSpring.entities.Product;
import jakarta.persistence.ManyToOne;

@jakarta.persistence.Embeddable
public class OrderItemPK implements java.io.Serializable {

    @ManyToOne
    @jakarta.persistence.JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @jakarta.persistence.JoinColumn(name = "product_id")
    private Product product;


    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        OrderItemPK other = (OrderItemPK) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

}
