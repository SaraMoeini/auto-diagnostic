package com.softway.medical.autoDiagnostic.springdemo;

import java.util.List;

public interface PathologyService {
    Pathology savePathology(Pathology pathology);

    List<Pathology> findAllPathologies();

}
