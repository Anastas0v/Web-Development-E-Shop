package mk.ukim.finki.wpaud.repository.impl;

import mk.ukim.finki.wpaud.bootstrap.DataHolder;
import mk.ukim.finki.wpaud.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryCategoryRepository
{
    public List<Category> findAll()
    {
        return DataHolder.categoryList;
    }

    public Category save(Category category)
    {
        if(category == null || category.getName().isEmpty())
            return null;

        DataHolder.categoryList.removeIf(r -> r.getName().equals(category.getName()));
        DataHolder.categoryList.add(category);
        return category;
    }

    public Optional<Category> findByName(String name)
    {
        return DataHolder.categoryList.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
    }

    public Optional<Category> findById(Long id)
    {
        return DataHolder.categoryList.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public List<Category> search(String text)
    {
        return DataHolder.categoryList.stream()
                .filter(r -> r.getName().contains(text) || r.getDescription().contains(text))
                .collect(Collectors.toList());
    }

    public void delete(String name)
    {
        DataHolder.categoryList.removeIf(r -> r.getName().equals(name));
    }
}
