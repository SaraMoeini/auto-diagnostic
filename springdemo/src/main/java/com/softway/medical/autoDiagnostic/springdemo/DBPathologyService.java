package com.softway.medical.autoDiagnostic.springdemo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DBPathologyService implements PathologyService{

    private final PathologyRepository pathologyRepository;

    public DBPathologyService(PathologyRepository pathologyRepository) {
        this.pathologyRepository = pathologyRepository;
    }

    public Pathology savePathology(Pathology pathology) {
        return pathologyRepository.save(pathology);
    }

    @Override
    public List<Pathology> findAllPathologies() {
        return pathologyRepository.findAll();
    }

}
