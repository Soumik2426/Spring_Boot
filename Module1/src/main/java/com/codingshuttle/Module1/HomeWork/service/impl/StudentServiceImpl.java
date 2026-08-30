package com.codingshuttle.Module1.HomeWork.service.impl;

import com.codingshuttle.Module1.HomeWork.dto.request.AssignProfessorToStudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.AssignSubjectToStudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.StudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.AssignProfessorToStudentResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.AssignSubjectToStudentResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.StudentResponse;
import com.codingshuttle.Module1.HomeWork.entity.AdmissionRecord;
import com.codingshuttle.Module1.HomeWork.entity.Professor;
import com.codingshuttle.Module1.HomeWork.entity.Student;
import com.codingshuttle.Module1.HomeWork.entity.Subject;
import com.codingshuttle.Module1.HomeWork.repository.AdmissionRecordRepository;
import com.codingshuttle.Module1.HomeWork.repository.ProfessorRepository;
import com.codingshuttle.Module1.HomeWork.repository.StudentRepository;
import com.codingshuttle.Module1.HomeWork.repository.SubjectRepository;
import com.codingshuttle.Module1.HomeWork.service.StudentService;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final AdmissionRecordRepository admissionRecordRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    //To create a student
    @Override
    @Transactional
    public StudentResponse createStudent(StudentRequest studentRequest) {
        if(studentRepository.existsByPhnNumber(studentRequest.phnNumber())) {
            throw new DuplicateRequestException("Student with phone number already exixts");
        }

        //Creating Student
        Student student = Student.builder()
                .name(studentRequest.name())
                .phnNumber(studentRequest.phnNumber())
                .build();

        //Saving Student to DB
        student = studentRepository.save(student);

        //Creating Admission Record
        AdmissionRecord admissionRecord = AdmissionRecord.builder()
                .student(student)
                .fees(studentRequest.fees())
                .build();

        //Saving Admission Record to DB
        admissionRecord=admissionRecordRepository.save(admissionRecord);

        return new StudentResponse(student.getId(),
                student.getName(),
                student.getPhnNumber());
    }

    //To delete a student
    @Override
    @Transactional
    public Void deleteStudent(UUID id) {
        if(!studentRepository.existsById(id)){
            throw new NoSuchElementException("Student with Id not found");
        }

        studentRepository.deleteById(id);
        return null;
    }

    //To assign professor to student
    @Override
    @Transactional
    public AssignProfessorToStudentResponse assignProfessor(UUID studentId, AssignProfessorToStudentRequest assignProfessorToStudentRequest) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new NoSuchElementException("Student with given Id not found"));

        Professor professor = professorRepository.findById(assignProfessorToStudentRequest.professorId())
                .orElseThrow(() ->
                        new NoSuchElementException("Professor with given Id not found"));

        if(student.getProfessors().contains(professor)){
            throw new DuplicateRequestException("Professor already assigned to the student");
        }

        student.getProfessors().add(professor);
        student=studentRepository.save(student);
        return new AssignProfessorToStudentResponse(
                student.getId(),
                professor.getId()
        );
    }

    //To assign subject to student
    @Override
    @Transactional
    public AssignSubjectToStudentResponse assignSubject(UUID studentId, AssignSubjectToStudentRequest assignSubjectToStudentRequest) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new NoSuchElementException("Student with given Id not found"));

        Subject subject = subjectRepository.findById(assignSubjectToStudentRequest.subjectId())
                .orElseThrow(() ->
                        new NoSuchElementException("Subject with given Id not found"));

        if(student.getSubjects().contains(subject)){
            throw new DuplicateRequestException("Subject already assigned to the student");
        }

        student.getSubjects().add(subject);
        student=studentRepository.save(student);

        return new AssignSubjectToStudentResponse(
                student.getId(),
                subject.getId()
        );
    }
}
