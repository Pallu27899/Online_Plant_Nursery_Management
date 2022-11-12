package masai.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import masai.com.model.SignUpData;

public interface SignUpDao extends JpaRepository<SignUpData, Integer> {

	public Optional<SignUpData> findByUserName(String userName);
	
	
	
}