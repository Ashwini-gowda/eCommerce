package com.mycom.organisation;

import act.controller.Controller;
import act.controller.annotation.UrlContext;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import act.db.DbBind;
import org.mongodb.morphia.annotations.Entity;
import org.osgl.mvc.annotation.*;
import java.util.Map;
import java.util.List;
import javax.inject.Inject;
import static act.controller.Controller.Util.notFoundIfNull;

@UrlContext("/organisations")
public class OrganisationController extends MorphiaDao<Organisation> {

@Inject
private MorphiaDao<Organisation> dao = Organisation.dao();

  @PostAction("/organisations")
  public Organisation create(Organisation organisation) {
      return dao.save(organisation);
  }

  @GetAction("/organisations")
  public Iterable<Organisation> list() {
      return dao.findAll();
  }

  @GetAction("/organisations/{id}")
  public Organisation show(@DbBind("id") Organisation organisation) {
      return organisation;
  }

  @PutAction("/organisations/{id}")
  public Organisation update(String id, Map<String, Object> data) {
      Organisation organisation = findById(id);
      notFoundIfNull(organisation);
      return dao.save(organisation.mergeValues(data));
  }

  @DeleteAction("/organisations/{id}")
  public void delete(String id) {
      dao.deleteById(id);
  }
}




