package masai.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import masai.com.model.Seed;

public interface SeedDao extends JpaRepository<Seed, Integer> {

}
