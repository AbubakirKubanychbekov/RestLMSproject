package boss.repo;

import boss.dto.response.StudentResponse;
import boss.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {


    @Query("SELECT new boss.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.isBlock) FROM Student s")
    List<StudentResponse> getAllStudents();

    Optional<StudentResponse> getStudentById(Long id);


    @Query("SELECT s FROM Student s WHERE s.studyFormat = 'online'")
    List<StudentResponse> getAllOnlineStudents();


    @Query("SELECT s FROM Student s WHERE s.studyFormat = 'Offline'")
    List<StudentResponse> getAllOfflineStudents();

    @Query("select new boss.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.isBlock) from Student s")
    Page<StudentResponse> findAllStudents(Pageable pageable);
}
