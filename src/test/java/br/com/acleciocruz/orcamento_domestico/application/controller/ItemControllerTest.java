package br.com.acleciocruz.orcamento_domestico.application.controller;

import br.com.acleciocruz.orcamento_domestico.application.model.ItemBudget;
import br.com.acleciocruz.orcamento_domestico.infra.repositories.IItemRepository;
import br.com.acleciocruz.orcamento_domestico.mocks.ItemMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IItemRepository mockRepository;

    @InjectMocks
    private ItemController controller;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("should return list items with success")
    void getAllItems() throws Exception {
        List<ItemBudget> budgets = ItemMock.itemBudgetList(2);
        Mockito.when(mockRepository.findAll()).thenReturn(budgets);

        mockMvc.perform(get("/v1/api/budget/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].itemName")
                        .value("Product Test 1"));
    }

    @Test
    void insertItem() {
    }

    @Test
    void getByName() {
    }
}