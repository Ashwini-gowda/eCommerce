package com.ecommerce.models;

import com.ecommerce.models.Order;
import com.ecommerce.models.Product;

import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;
import java.util.Map;
import java.util.*;
import javax.persistence.*;

@Entity("orderitem")
public class OrderItem extends MorphiaAdaptiveRecord<OrderItem> {
  @Embedded
  public Order order;
  public List<Product> product = new ArrayList<Product>(); 

  @Id
  public Integer id;
  public Integer quantity;
  public Float discount;
  public Float list_price;
  public Float net_price;

  public void setProduct(List<Product> product){
    this.product = product;
  }
  public List<Product> getProduct(){
    return product;
  }
  public static class Dao extends MorphiaDao<OrderItem> {
  }
}
