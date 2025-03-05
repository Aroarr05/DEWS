package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.exception.CategoriaNotFoundException;
import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.iesbelen.videoclub.repository.CategoriaCustomRepository;
import org.iesbelen.videoclub.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

        private final CategoriaRepository categoriaRepository;
        private final CategoriaCustomRepository categoriaCustomRepository;

        public CategoriaService(CategoriaRepository categoriaRepository, CategoriaCustomRepository categoriaCustomRepository) {
            this.categoriaRepository = categoriaRepository;
            this.categoriaCustomRepository = categoriaCustomRepository;
        }

        public List<Categoria> all() {
            return this.categoriaRepository.findAll();
        }

        public Categoria save(Categoria categoria) {
            return this.categoriaRepository.save(categoria);
        }

        public Categoria one(Long id) {
            return this.categoriaRepository.findById(id)
                    .orElseThrow(() -> new CategoriaNotFoundException(id));
        }

        public Categoria replace(Long id, Categoria categoria) {

            return this.categoriaRepository.findById(id).map( p -> (id.equals(categoria.getId())  ?
                            this.categoriaRepository.save(categoria) : null))
                    .orElseThrow(() -> new CategoriaNotFoundException(id));
        }

        public void delete(Long id) {
            this.categoriaRepository.findById(id).map(p -> {this.categoriaRepository.delete(p);
                        return p;})
                    .orElseThrow(() -> new CategoriaNotFoundException(id));
        }

        public List<Categoria> allByQueryFiltersStream(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
                return this.categoriaCustomRepository.queryCustomCategoria(buscarOptional,ordenarOptional);
        }

}


