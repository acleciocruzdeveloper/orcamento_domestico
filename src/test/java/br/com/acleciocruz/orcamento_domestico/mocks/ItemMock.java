package br.com.acleciocruz.orcamento_domestico.mocks;

import br.com.acleciocruz.orcamento_domestico.application.model.ItemBudget;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemMock {
    private UUID id;
    @Column(name = "item_name")
    private String itemName;
    private BigDecimal price;
    private String mark;
    private int amount;

    public static ItemBudget itemBudgetMock(
            UUID id,
            String itemNameMock,
            BigDecimal priceMock,
            String markMock,
            int amountMock) {
        ItemBudget mock = new ItemBudget();
        mock.setId(id);
        mock.setItemName(itemNameMock);
        mock.setPrice(priceMock);
        mock.setMark(markMock);
        mock.setAmount(amountMock);
        return mock;
    }

    public static List<ItemBudget> itemBudgetList(int count){
        ArrayList<ItemBudget> mocks = new ArrayList<>();
        for (int i = 1; i <= count; i++){
            mocks.add(itemBudgetMock(
                    UUID.randomUUID(),
                    "Product Test " + i,
                    BigDecimal.ONE.plus(),
                    "Mark Product " + i,
                    1
            ));
        }
        return mocks;
    }

}
