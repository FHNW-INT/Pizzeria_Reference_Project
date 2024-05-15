package ch.noteshub.fhnw.business.service;

import ch.noteshub.fhnw.data.domain.Module;
import ch.noteshub.fhnw.data.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Module findModuleById(Long id) {
        Optional<Module> moduleOptional = moduleRepository.findById(id);
        if (moduleOptional.isPresent()) {
            return moduleOptional.get();
        } else {
            throw new RuntimeException("Module with id " + id + " not found");
        }
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module addModule(Module module) {
        return moduleRepository.save(module);
    }

    public Module updateModule(Long id, Module moduleDetails) {
        Module module = findModuleById(id);
        module.setModuleName(moduleDetails.getModuleName());
        module.setModuleType(moduleDetails.getModuleType());
        module.setModulePeriod(moduleDetails.getModulePeriod());
        module.setModuleTeachingLanguage(moduleDetails.getModuleTeachingLanguage());
        return moduleRepository.save(module);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
