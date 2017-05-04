package com.lofitskyi.service;

import com.lofitskyi.entity.EbayItemView;
import com.lofitskyi.entity.Item;
import com.lofitskyi.repository.ItemRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private ItemRepository itemRepository;
    private WebDriver driver;


    public CheckServiceImpl() {
        this.driver = new HtmlUnitDriver();
    }

    @Override
    public List<EbayItemView> checkAllForPrices() {
        final List<Item> items = itemRepository.findAll();
        List<EbayItemView> checkedItem = new LinkedList<>();

        for (Item it: items){
            driver.get(it.getEbayLink());

            String price;

            try {
                price = driver.findElement(By.id("prcIsum")).getText();
            }catch (Exception e){
                try {
                    price = driver.findElement(By.id("mm-saleDscPrc")).getText();
                }
                catch (Exception ex){
                    continue;
                }
            }

            price = price.replaceAll("([^\\d.]|\\B\\.|\\.\\B)+", "");

            BigDecimal priceBD = BigDecimal.valueOf(Double.parseDouble(price));

            if (priceBD.compareTo(BigDecimal.valueOf(Double.parseDouble(it.getDocPrice()))) > 0) {
                checkedItem.add(new EbayItemView(it.getName(), it.getEbayLink(), it.getSku(), it.getDocPrice(), price));
            }
        }

        return checkedItem;
    }
}
