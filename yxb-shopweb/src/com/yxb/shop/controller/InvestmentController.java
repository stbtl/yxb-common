package com.yxb.shop.controller;

import com.yxb.shop.model.Customer;
import com.yxb.shop.model.OptionsRadios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by BING on 2017/6/19.
 */
@Controller
@RequestMapping("investment")
public class InvestmentController {

    @RequestMapping("risk_evaluation")
    public String risk_evaluation() {
        return "investment/risk_evaluation";
    }

    @RequestMapping("risk_evaluation_level")
    public String risk_evaluation_level(Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "investment/risk_evaluation_level";
    }

    @RequestMapping("portfolio_detail")
    public String portfolio_detail() {
        return "investment/portfolio_detail";
    }

    @RequestMapping("getQuestions")
    @ResponseBody
    public String getQuestions() {
        return "sdfsdfsd";
    }

    @RequestMapping("intelligent_investment_choice")
    public String intelligent_investment_choice() {
        return "investment/intelligent_investment_choice";
    }

    @RequestMapping("product_detail")
    public String product_detail() {
        return "investment/product_detail";
    }

    @RequestMapping("intelligent_optional")
    public String intelligent_optional() {
        return "investment/intelligent_optional";
    }

    @RequestMapping("fund_choice")
    public String fund_choice() {
        return "investment/fund_choice";
    }

    @RequestMapping("product_detail_add")
    public String product_detail_add() {
        return "investment/product_detail_add";
    }
}


