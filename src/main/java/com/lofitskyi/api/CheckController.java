package com.lofitskyi.api;

import com.lofitskyi.entity.EbayItemView;
import com.lofitskyi.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckController {

    @Autowired
    private CheckService service;

    @GetMapping(path = "/price")
    public List<EbayItemView> runMetricCounting(){
        return service.checkAllForPrices();
    }
}
