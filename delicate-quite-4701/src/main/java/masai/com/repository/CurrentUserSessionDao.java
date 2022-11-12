package masai.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import masai.com.model.CurrentUserSession;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer> {
	
	


		
		public Optional<CurrentUserSession> findByUserId(Integer userId);
		
		public Optional<CurrentUserSession> findByUuid(String uuid);

	

}