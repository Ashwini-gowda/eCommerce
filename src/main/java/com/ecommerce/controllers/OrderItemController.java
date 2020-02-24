package com.ecommerce.controllers;

import com.ecommerce.models.OrderItem;
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

@UrlContext("/orderitems")
public class OrderItemController extends MorphiaDao<OrderItem> {

@Inject
private MorphiaDao<OrderItem> dao = OrderItem.dao();

  @PostAction("/orderitems")
  public OrderItem create(OrderItem orderItem) {
      return dao.save(orderItem);
  }

  @GetAction("/orderitems")
  public Iterable<OrderItem> list() {
      return dao.findAll();
  }

  @GetAction("/orderitems/{id}")
  public OrderItem show(@DbBind("id") OrderItem orderItem) {
      return orderItem;
  }

  @PutAction("/orderitems/{id}")
  public OrderItem update(String id, Map<String, Object> data) {
      OrderItem orderItem = findById(id);
      notFoundIfNull(orderItem);
      return dao.save(orderItem.mergeValues(data));
  }

  @DeleteAction("/orderitems/{id}")
    public void delete(String id) {
      dao.deleteById(id);
    }
}
