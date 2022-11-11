package masai.com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import masai.com.exception.SeedException;
import masai.com.service.SeedServices;
import masai.com.model.Seed;

@RestController
public class SeedController {

	@Autowired
	private SeedServices seedServices;
			
		@GetMapping("/showseeds")
		public ResponseEntity<List<Seed>> getAllSeedsHandler() throws SeedException{
			
			 List<Seed> seeds= this.seedServices.getAllSeeds();
			
			return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
			
			
		}

		
		@GetMapping("/showseed/{pid}")
		public ResponseEntity<Seed> getSeedByIdHandler(@PathVariable("pid") Integer id) throws SeedException{
			
			
			Seed seed= this.seedServices.getSeedById(id);
			
			return new ResponseEntity<Seed>(seed,HttpStatus.OK);
			
		}
		
				
	@GetMapping("/getseeds/{name}")
		public ResponseEntity<List<Seed>> getSeedByNameHandler(@PathVariable("name") String Name) throws SeedException{
			
			
			List<Seed> seed= this.seedServices.getSeedBycommonName(Name);
			
			return new ResponseEntity<List<Seed>>(seed,HttpStatus.OK);
			
		}
				

		@GetMapping("/showseedsList/{type}")
		public ResponseEntity<List<Seed>> getPlantBytypeOfSeedHandler(@PathVariable("type") String type) throws SeedException{
			
			
			List<Seed> seeds= this.seedServices.getseedByTypeOfSeed(type);
			
			return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
			
		}
	

}
