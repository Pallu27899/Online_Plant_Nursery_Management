package masai.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import masai.com.model.SignUpData;

public interface SignUpDao extends JpaRepository<SignUpData, Integer> {

}
