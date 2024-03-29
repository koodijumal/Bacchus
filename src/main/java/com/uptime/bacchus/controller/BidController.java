package com.uptime.bacchus.controller;

import com.uptime.bacchus.entity.Bid;
import com.uptime.bacchus.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/")
    public String getMainPage() {
        return "main";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void insertBid(@RequestBody Bid bid) {
        bidService.addBid(new Bid(bid.getFullName(), bid.getProductId(), bid.getBidAmount()));
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Bid> getProductsById(String productId) {
        return bidService.getBidsByProductId(productId);
    }

    @GetMapping("/getProducts")
    @ResponseBody
    public List<Bid> getProducts(String productId) {
        return bidService.getBidsByProductId(productId);
    }

}
