package com.StudentList.StudentManagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentList.StudentManagement.dto.StudentResponseDto;
import com.StudentList.StudentManagement.dto.StudentRequestDto;
import com.StudentList.StudentManagement.model.Gender;
import com.StudentList.StudentManagement.model.Student;
import com.StudentList.StudentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpli implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Entity ← DTO
    private Student mapToEntity(StudentRequestDto dto) {
        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setClassName(dto.getClassName());
        student.setGender(Gender.valueOf(dto.getGender()));
        student.setFatherName(dto.getFatherName());
        student.setPhoneNo(dto.getPhoneNo());
        student.setAddress(dto.getAddress());
        student.setDate(dto.getDate()); // or LocalDate.now()

        return student;
    }

    // DTO ← Entity
    private StudentResponseDto mapToDTO(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setRollNo(student.getRollNo());
        dto.setName(student.getName());
        dto.setClassName(student.getClassName());
        dto.setGender(student.getGender().name());
        dto.setFatherName(student.getFatherName());
        return dto;
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto dto) {

        boolean exists = studentRepository
                .existsByNameIgnoreCaseAndFatherNameIgnoreCase(
                        dto.getName(),
                        dto.getFatherName());

        if (exists) {
            throw new RuntimeException(
                    "Student already exists with same name and father name");
        }

        Student saved = studentRepository.save(mapToEntity(dto));
        return mapToDTO(saved);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public StudentResponseDto getStudentById(Long rollNo) {
        return studentRepository.findById(rollNo)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<StudentResponseDto> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public StudentResponseDto updatePartialStudent(Long rollNo, Map<String, Object> update) {

        Student student = studentRepository.findById(rollNo)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + rollNo));

        update.forEach((field, value) -> {

            switch (field) {

                case "name":
                    student.setName((String) value);
                    break;

                case "email":
                    student.setEmail((String) value);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
            }
        });
        studentRepository.save(student) ;
        return mapToDTO(student);
    }

}
