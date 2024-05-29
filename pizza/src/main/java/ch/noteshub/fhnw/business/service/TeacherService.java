package ch.noteshub.fhnw.business.service;

import ch.noteshub.fhnw.data.domain.Teacher;
import ch.noteshub.fhnw.data.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher findTeacherById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            return teacherOptional.get();
        } else {
            throw new RuntimeException("Teacher with id " + id + " not found");
        }
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = findTeacherById(id);
        teacher.setTeacherFirstname(teacherDetails.getTeacherFirstname());
        teacher.setTeacherLastname(teacherDetails.getTeacherLastname());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}

