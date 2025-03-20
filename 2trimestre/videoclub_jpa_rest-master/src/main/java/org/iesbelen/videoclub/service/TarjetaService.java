package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Socio;
import org.iesbelen.videoclub.domain.Tarjeta;
import org.iesbelen.videoclub.exception.SocioNotFoundException;
import org.iesbelen.videoclub.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public List<Tarjeta> all() {
        return tarjetaRepository.findAll();
    }

    public Tarjeta save(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    public Tarjeta one(Long id) {
        return this.tarjetaRepository.findById(id)
                .orElseThrow(()-> new SocioNotFoundException(id));
    }

    public Tarjeta replace(Long id, Tarjeta tarjeta) {

        return this.tarjetaRepository.findById(id).map(t-> (id.equals(tarjeta.getId()) ?
                        this.tarjetaRepository.save(tarjeta) : null))
                .orElseThrow(()-> new SocioNotFoundException(id));
    }
    public void delete(Long id) {
        this.tarjetaRepository.findById(id).map(t-> {this.tarjetaRepository.delete(t);
                    return t;})
                .orElseThrow(()-> new SocioNotFoundException(id));
    }

}
