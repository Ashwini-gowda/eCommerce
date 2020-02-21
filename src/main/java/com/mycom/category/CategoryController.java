package com.mycom.category;

import act.controller.Controller;
import act.controller.annotation.UrlContext;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import act.db.DbBind;
import org.mongodb.morphia.annotations.Entity;
import org.osgl.mvc.annotation.*;
import java.util.*;
import javax.inject.Inject;
import static act.controller.Controller.Util.notFoundIfNull;


@UrlContext("/categories")
public class CategoryController extends MorphiaDao<Category> {

@Inject
private MorphiaDao<Category> dao = Category.dao();

  @PostAction("/categories")
  public Category create(Category category) {
      return dao.save(category);
  }

  @GetAction("/categories")
  public Iterable<Category> list() {
      return dao.findAll();
  }

  @GetAction("/categories/{id}")
  public Category show(@DbBind("id") Category category) {
      return category;
  }

  @PutAction("/categories/{id}")
  public Category update(String id, Map<String, Object> data) {
      Category category = findById(id);
      notFoundIfNull(category);
      return dao.save(category.mergeValues(data));
  }

  @DeleteAction("/categories/{id}")
  public void delete(String id) {
      dao.deleteById(id);
  }
}
