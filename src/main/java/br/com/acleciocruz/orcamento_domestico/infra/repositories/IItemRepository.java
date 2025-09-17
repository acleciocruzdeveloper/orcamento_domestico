package br.com.acleciocruz.orcamento_domestico.infra.repositories;

import br.com.acleciocruz.orcamento_domestico.application.model.ItemBudget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IItemRepository extends JpaRepository<ItemBudget, UUID> {
    Optional<List<ItemBudget>> findByItemName(String name);
}
