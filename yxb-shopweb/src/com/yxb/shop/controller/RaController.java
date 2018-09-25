package com.yxb.shop.controller;

import com.yxb.shop.model.Customer;
import com.yxb.shop.model.OptionsRadios;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by BING on 2017/6/28.
 */
@Controller
@RequestMapping("ra")
public class RaController {
    @RequestMapping("questionnaire")
    @ResponseBody
    public Customer questionnaire(OptionsRadios or) {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("张三");
        customer.setRisk_level_type("平衡型");
        customer.setRisk_tolerance("中");
        customer.setQ1(or.getQ1());
        customer.setQ2(or.getQ2());
        customer.setQ3(or.getQ3());
        customer.setQ4(or.getQ4());
        customer.setQ5(or.getQ5());
        customer.setQ6(or.getQ6());
        customer.setQ7(or.getQ7());
        customer.setQ8(or.getQ8());
        customer.setQ9(or.getQ9());
        customer.setQ10(or.getQ10());
        customer.setQ11(or.getQ11());
        customer.setQ12(or.getQ12());
        return customer;
    }
}
