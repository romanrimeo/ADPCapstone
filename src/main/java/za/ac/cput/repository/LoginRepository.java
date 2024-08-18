package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.LogIn;

@Repository
public interface LoginRepository extends JpaRepository<LogIn, String> {
}
