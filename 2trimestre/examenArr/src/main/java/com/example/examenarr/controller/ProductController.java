package com.example.examenarr.controller;

import com.example.examenarr.domain.Product;
import com.example.examenarr.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    //@GetMapping(value = {"","/"}, params = {"!pagina","tamanio", "!paginado"})
    @GetMapping(value = {"","/"})
    private List<Product> all() {
        log.info("Get all products");
        return this.productService.all();
    }

    @GetMapping(value = {"","/"}, params = {"paginado"})
     public ResponseEntity<Map<String,Object>> all(@RequestParam (value = "pagina",defaultValue = "0")int pagina,
     @RequestParam(value = "tamanio", defaultValue = "3")int tamanio) {
        log.info("All products");
        Map<String,Object> responseAll = this.productService.all(pagina,tamanio);
        return ResponseEntity.ok(responseAll);
    }


    @PostMapping({"","/"})
    public Product newProduct(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable long id) {
        return this.productService.one(id);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return this.productService.replace(id,product);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable ("id") long id) {
        this.productService.delete(id);
    }
}
