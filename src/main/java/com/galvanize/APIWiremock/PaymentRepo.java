package com.galvanize.APIWiremock;

import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends CrudRepository<JSONObject, Long> {
    void save(JSONObject readJsonFromUrl, long id);
}