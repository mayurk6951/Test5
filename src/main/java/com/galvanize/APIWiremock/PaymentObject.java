package com.galvanize.APIWiremock;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class PaymentObject {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String uri;
    private String user;
    private Long amount;
    private String currency;
    private String source;
    private String desc;


    @Builder

    public PaymentObject(String uri, String user, Long amount, String currency, String source, String desc) {
        this.uri = uri;
        this.user = user;
        this.amount = amount;
        this.currency = currency;
        this.source = source;
        this.desc = desc;
    }

    public PaymentObject() {
    }
}

