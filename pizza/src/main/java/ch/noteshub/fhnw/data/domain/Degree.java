package ch.noteshub.fhnw.data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "degree")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "degree_id", nullable = false)
    private Long degreeId;

    @Column(name = "degree_name", nullable = false)
    private String degreeName;

    // Getters and Setters
    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
