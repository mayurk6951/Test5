package com.galvanize.APIWiremock;


import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Wiremock_controller {

private final PaymentService paymentService;

    @Autowired
    public Wiremock_controller(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/create/")
    public void sendpayment(@RequestBody PaymentObject paymentObject) throws IOException, JSONException {
       paymentService.sendpayment(paymentObject);
    }
}
