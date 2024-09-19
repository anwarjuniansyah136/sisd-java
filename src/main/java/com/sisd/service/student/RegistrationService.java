package com.sisd.service.student;

import com.sisd.dto.student.StudentRegistrationRequestDto;

public interface RegistrationService {
    String register(StudentRegistrationRequestDto dto);
}
