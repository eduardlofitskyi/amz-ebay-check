package com.lofitskyi.service;

import com.lofitskyi.entity.EbayItemView;
import com.lofitskyi.entity.Item;

import java.util.List;

public interface CheckService {
    List<EbayItemView> checkAllForPrices();
}
