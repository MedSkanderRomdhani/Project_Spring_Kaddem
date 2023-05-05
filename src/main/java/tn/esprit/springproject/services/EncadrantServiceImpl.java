package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Encadrant;
import tn.esprit.springproject.repositories.EncadrantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EncadrantServiceImpl implements EncadrantService {
    EncadrantRepository repository;

    @Override
    public List<Encadrant> retrieveAllEncadrants() {
        return repository.findAll();
    }

    @Override
    public Encadrant addEncadrant(Encadrant e) {
        return repository.save(e);
    }

    @Override
    public void deleteEncadrant(int id) {
        repository.deleteById(id);
    }

    @Override
    public Encadrant updateEncadrant(Encadrant e) {
        return repository.save(e);
    }

    @Override
    public Encadrant retrieveEncadrant(int id) {
        return repository.findById(id).orElse(null);
    }
}
