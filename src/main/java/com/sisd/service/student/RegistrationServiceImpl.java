package com.sisd.service.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sisd.constant.RolesConstant;
import com.sisd.dto.student.StudentRegistrationRequestDto;
import com.sisd.entity.Parent;
import com.sisd.entity.Roles;
import com.sisd.entity.Student;
import com.sisd.entity.Users;
import com.sisd.repository.ParentRepository;
import com.sisd.repository.RolesRepository;
import com.sisd.repository.StudentRepository;
import com.sisd.repository.UsersRepository;
import com.sisd.service.EmailService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public String register(StudentRegistrationRequestDto dto) {
        // create user for parent
        Users users = new Users();
        users.setUserName(dto.getEmail());
        users.setPassword(passwordEncoder.encode(dto.getPassword()));
        Roles parentRoles = rolesRepository.findByRoleName(RolesConstant.PARENT_ROLE);
        users.setRoles(parentRoles);
        usersRepository.save(users);

        // create parent
        Parent parent = new Parent();
        parent.setParentName(dto.getParentName());
        parent.setEmail(dto.getEmail());
        // parent.setPhoneNumber(dto.)
        parent.setAddress(dto.getAddress());
        parent.setProfession(dto.getProfession());
        parent.setUsers(users);
        parentRepository.save(parent);

        // create student
        Student student = new Student();
        student.setStudentName(dto.getStudentName());
        student.setRegisterDate(LocalDate.now());
        LocalDate dateOfBirth = LocalDate.parse(dto.getDateOfBirth(), DateTimeFormatter.ISO_DATE);
        student.setDateOfBirth(dateOfBirth);
        student.setPlaceOfBirth(dto.getPlaceOfBirth());
        student.setGender(dto.getGender());
        student.setParent(parent);
        studentRepository.save(student);
        // return "succesfully";

        // send email
        String to = dto.getEmail();
        String subject = "Student Registration";
        String text = "Teruntuk Orantua Siswa, \n\n " +
                "Proses Pendaftaran Siswa Telah Berhasil. Selanjutnya Akan KAmi Informasikan bertahap. \n" +
                "Terima Kasih. \n\n" +
                "Hormat \n" +
                "kepala sekolah";
        emailService.sendSimpleMessage(to, subject, text);

        return "succesfully";

    }
}
