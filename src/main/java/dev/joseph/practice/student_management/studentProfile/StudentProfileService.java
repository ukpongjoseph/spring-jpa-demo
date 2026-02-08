package dev.joseph.practice.student_management.studentProfile;

import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {
    private StudentProfileMapper mapper;
    private StudentProfileRepository repository;

    public StudentProfileService(StudentProfileMapper mapper, StudentProfileRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    // To create a studentProfile, we will recieve a dto, convert the dto a studentProfile Object. pass thisnobject to the repository. The repository returns a StudentProfile object which is converted by the mapper and sent
    public StudentProfileResponseDto createStudentProfile(StudentProfileDto dto){
        StudentProfile profile = mapper.dtoToStudentProfile(dto);
        return mapper.profileToStudentProfileResponseDto(repository.save(profile));
    }
}

