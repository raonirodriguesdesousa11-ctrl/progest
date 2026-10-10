package br.com.progest.controller;

import br.com.progest.model.Category;
import br.com.progest.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public List<Category> list(){
        return service.list();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }

}
