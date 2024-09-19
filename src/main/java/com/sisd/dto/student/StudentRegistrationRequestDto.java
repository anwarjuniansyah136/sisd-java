package com.sisd.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationRequestDto {
    // Student
    String studentName;
    String dateOfBirth; // "1998-18-25" yyyy-MM-dd ISO_8601
    String placeOfBirth;
    String gender;
    String studentPhoto;
    String password;

    // parent
    String parentName;
    String address;
    String email;
    String profession;
    String parentPhoto;
}
