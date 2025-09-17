package br.com.acleciocruz.orcamento_domestico.application.resources;

import br.com.acleciocruz.orcamento_domestico.application.model.ItemBudget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IBudgetResource {

    ResponseEntity<List<ItemBudget>> getAllItems();

    ResponseEntity<Void> insertItem(@RequestBody ItemBudget request);
    ResponseEntity<List<ItemBudget>> getByName(@RequestParam String name);
}
