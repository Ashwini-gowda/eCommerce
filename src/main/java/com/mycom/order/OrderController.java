package com.mycom.order;

import act.controller.Controller;
import act.controller.annotation.UrlContext;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import act.db.DbBind;
import org.mongodb.morphia.annotations.Entity;
import org.osgl.mvc.annotation.*;
import java.util.Map;
import static act.controller.Controller.Util.notFoundIfNull;

import java.util.List;
import javax.inject.Inject;

@UrlContext("/orders")
public class OrderController extends MorphiaDao<Order> {

@Inject
private MorphiaDao<Order> dao = Order.dao();

  @PostAction("/orders")
  public Order create(Order order) {
      return dao.save(order);
  }

  @GetAction("/orders")
  public Iterable<Order> list() {
      return dao.findAll();
  }

  @GetAction("/orders/{id}")
  public Order show(@DbBind("id") Order order) {
      return order;
  }

  @PutAction("/orders/{id}")
  public Order update(String id, Map<String, Object> data) {
      Order order = findById(id);
      notFoundIfNull(order);
      return dao.save(order.mergeValues(data));
  }

  @DeleteAction("/orders/{id}")
  public void delete(String id) {
      dao.deleteById(id);
  }
}
