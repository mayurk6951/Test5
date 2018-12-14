package com.galvanize.APIWiremock;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class PaymentService {

    private static PaymentRepo repository;
    @Autowired
    public PaymentService(PaymentRepo paymentRepo) {
        this.repository = paymentRepo;

    }

    public static void sendpayment(PaymentObject paymentObject) throws IOException, org.json.JSONException {
        repository.save(readJsonFromUrl(paymentObject.getUri()+paymentObject.getUser()+paymentObject.getAmount()+paymentObject.getCurrency()+paymentObject.getSource()+paymentObject.getDesc()),paymentObject.getId());
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException, org.json.JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }  finally {
            is.close();
        }
    }
}
