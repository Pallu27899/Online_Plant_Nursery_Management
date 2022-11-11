package masai.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import masai.com.model.Seed;

@Repository
public interface SeedDao extends JpaRepository<Seed, Integer>{

	
	@Query("select s from Seed s where s.commonName = ?1")
	public List<Seed> getSeedBycommonName(String commonName);
	
	@Query("select s from Seed s where s.typeOfSeeds = ?1")
     public List<Seed> getSeedBytypeOfSeeds(String typeOfSeeds);

	 
}
