package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.entities.UniteDouaniere;
import sn.douanes.gestionstockpostgres.repositories.SectionsRepository;
import sn.douanes.gestionstockpostgres.services.SectionsService;

import java.util.List;


@Service
public class SectionsServiceImpl implements SectionsService {

    @Autowired
    SectionsRepository sectionsRepository;

    @Override
    public Sections saveSections(Sections s) {
        return sectionsRepository.save(s);
    }

    @Override
    public Sections updateSections(Sections p) {
        return sectionsRepository.save(p);
    }

    @Override
    public void deleteSections(Sections p) {
        sectionsRepository.delete(p);
    }

    @Override
    public void deleteSectionsById(String id) {
        sectionsRepository.deleteById(id);
    }

    @Override
    public Sections getSectionsById(String id) {
        return sectionsRepository.findById(id).isPresent() ? sectionsRepository.findById(id).get() : null;
    }

    @Override
    public List<Sections> getAllSectionss() {
        return sectionsRepository.findAll();
    }


    @Override
    public Sections ajouterSections(
            String codeSection,
            String libelleSection
    ) {

        Sections sections = new Sections();

        sections.setCodeSection(codeSection);
        sections.setLibelleSection(libelleSection);

        return sectionsRepository.save(sections);
    }


}
