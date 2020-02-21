package com.mycom.product;
import java.io.*;

import com.mycom.organisation.Organisation;
import act.controller.Controller;
import act.controller.annotation.UrlContext;
import act.db.morphia.*;
import act.db.DbBind;
import org.osgl.mvc.annotation.*;
import java.util.*;
import javax.inject.Inject;
import org.mongodb.morphia.annotations.Entity;
import static act.controller.Controller.Util.notFoundIfNull;

@UrlContext("/products")
public class ProductController extends MorphiaDao<Product> {
  
  @Inject
  private MorphiaDao<Product> dao = Product.dao();
  private MorphiaDao<Organisation> dao1 = Organisation.dao();
  public List<Organisation> organisations = new ArrayList<Organisation>();
    @PostAction("/products")
    public Product create(Product product) {
      return dao.save(product);
    }

    @GetAction("/products")
    public Iterable<Product> list() {
      return dao.findAll();
    }

    @GetAction("/products/{id}")
    public Product show(@DbBind("id") Product product) {
      return product;
    }

    @PutAction("/products/{id}")
    public Product update(String id, Map<String, Object> data) {
      Product product = findById(id);
      notFoundIfNull(product);
      return dao.save(product.mergeValues(data));
    }

    @DeleteAction("/products/{id}")
    public void delete(String id) {
      dao.deleteById(id);
    }
}

