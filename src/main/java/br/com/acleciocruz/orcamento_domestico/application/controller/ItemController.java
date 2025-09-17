package br.com.acleciocruz.orcamento_domestico.application.controller;

import br.com.acleciocruz.orcamento_domestico.application.model.ItemBudget;
import br.com.acleciocruz.orcamento_domestico.application.resources.IBudgetResource;
import br.com.acleciocruz.orcamento_domestico.infra.repositories.IItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/budget")
public class ItemController implements IBudgetResource {

    private final IItemRepository repository;

    @Override
    @GetMapping("/items")
    public ResponseEntity<List<ItemBudget>> getAllItems() {
        List<ItemBudget> items = repository.findAll();
        return ResponseEntity.ok(items);
    }

    @Override
    @PostMapping("/items")
    public ResponseEntity<Void> insertItem(ItemBudget request) {
        repository.save(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("name={item}")
                .buildAndExpand(request.getItemName())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping(value = "/items", params = "name")
    public ResponseEntity<List<ItemBudget>> getByName(String name) {
        Optional<List<ItemBudget>> itemName = repository.findByItemName(name);
        if (itemName.isPresent()){
            return ResponseEntity.ok(itemName.get());
        }
        return null;
    }
}
