package com.example.examenarr.service;

import com.example.examenarr.domain.Product;
import com.example.examenarr.exception.ProductNotFoundException;
import com.example.examenarr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> all(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product one(Long id){
        return this.productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));
    }

    public Product replace(Long id, Product product){
        return this.productRepository.findById(id).map(p->(id.equals(product.getId()) ?
                this.productRepository.save(product):null))
                .orElseThrow(()-> new ProductNotFoundException(id));

    }

    public void delete(Long id){
       this.productRepository.findById(id).map(p->{this.productRepository.delete(p);
           return p;})
       .orElseThrow(()-> new ProductNotFoundException(id));
    }

    //////////////////////////////

    public Map<String, Object> all(int pagina, int tamanio){

        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());

        Page<Product> pageAll = this.productRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("product", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
    }
}
