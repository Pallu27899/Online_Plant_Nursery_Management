package masai.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import  masai.com.model.LogInData;

public interface LoginDataDao  extends JpaRepository<LogInData, Integer>{

}

