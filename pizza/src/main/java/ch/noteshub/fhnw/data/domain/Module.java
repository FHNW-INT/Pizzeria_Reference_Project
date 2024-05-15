package ch.noteshub.fhnw.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden // Hides the primary key field from swagger documentation
    @Column(name = "module_id", nullable = false)
    private Long moduleId;

    @Column(name = "module_name", nullable = false)
    private String moduleName;

    @Column(name = "module_type", nullable = false)
    private String moduleType;

    @Column(name = "module_period", nullable = false)
    private String modulePeriod;

    @Column(name = "module_teaching_language", nullable = false)
    private String moduleTeachingLanguage;

    // Getters and Setters
    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getModulePeriod() {
        return modulePeriod;
    }

    public void setModulePeriod(String modulePeriod) {
        this.modulePeriod = modulePeriod;
    }

    public String getModuleTeachingLanguage() {
        return moduleTeachingLanguage;
    }

    public void setModuleTeachingLanguage(String moduleTeachingLanguage) {
        this.moduleTeachingLanguage = moduleTeachingLanguage;
    }
}
