package br.com.progest.services;

import br.com.progest.model.Category;
import br.com.progest.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> list(){
        return repository.findAll();
    }

    public Category findById(long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada: " + id));
    }

    public Category create(Category category){
        return repository.save(category);
    }

    public void delete(long id){
        Category category = findById(id);
        repository.delete(category);
    }

}
