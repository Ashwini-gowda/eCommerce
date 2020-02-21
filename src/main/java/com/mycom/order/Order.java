package com.mycom.order;
import com.mycom.order_item.OrderItem;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;
import java.util.Map;
import java.util.*;
import javax.persistence.*;

@Entity("order")
public class Order extends MorphiaAdaptiveRecord<Order> {
  public List<OrderItem> orderItem = new ArrayList<OrderItem>();
  @Id
  public Integer id;
  public String serial_no;
  public String status;

  public static class Dao extends MorphiaDao<Order> {
  }
}
