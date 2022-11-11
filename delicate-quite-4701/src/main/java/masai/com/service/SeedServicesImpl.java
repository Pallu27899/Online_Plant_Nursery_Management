package masai.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masai.com.exception.SeedException;
import masai.com.repository.SeedDao;
import masai.com.model.Seed;

@Service
public class SeedServicesImpl implements SeedServices {

	@Autowired
	private SeedDao dao;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		  Seed addSeed=dao.save(seed);

	        if(addSeed!=null)
	        {
	        	return addSeed;
	        }        
	        
	        else {
	        throw new SeedException("Seed details are empty........");
			}
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
	
Optional<Seed>opt=dao.findById(seed.getSeedId());
		
		if(opt.isPresent())
		{
			
			return seed;
		}
	
	
	else {
        throw new SeedException("Seed with given id is not presesnt........");

	}
		
	}

	
	@Override
	public Seed deleteSeed(Seed seed) throws SeedException {
		
		 Optional<Seed>opt=dao.findById(seed.getSeedId());
			
			if(opt.isPresent())
			{
				
				dao.delete(seed);
				
				return seed;
			}
		
		
		else {
			
	        throw new SeedException("This Plant is not present ........");

		}
		
	}

	
	@Override
	public List<Seed> getAllSeeds() throws SeedException {
		
		 List<Seed> seeds=dao.findAll();

	        if(seeds.size()>0)
	        {
	        	return seeds;
	        }
	         
	        
	        else 
	        {
	        	
	        throw new SeedException("Seed details List is empty........");
	        
			}
		
		
	}

	
	@Override
	public Seed getSeedById(Integer seedId) throws SeedException {
		
Optional<Seed>opt=dao.findById(seedId);
		
		if(opt.isPresent())
		{
			
			Seed seed=opt.get();
			
			return seed;
		}
	
	
	else {
		
        throw new SeedException("This Seed with given id is not present ........");

	}
		
		
		
	}


	@Override
	public List<Seed> getSeedBycommonName(String commonName) throws SeedException {
		
		List<Seed> p =dao.getSeedBycommonName(commonName);
		 
		 System.out.println(p);

		if(p.size()>0)
		{
		 System.out.println(p);
			return p;
		}
		else {
	        throw new SeedException("This Seed with given Common name is not present ........");

		}
		
		
	}

	
	@Override
	public List<Seed> getseedByTypeOfSeed(String typeOfSeeds) throws SeedException {
		
		List<Seed>paList=dao.getSeedBytypeOfSeeds(typeOfSeeds);
		if(paList.size()>0)
		{
			return paList;
		}
		else {
			throw new SeedException("List of given type of seed is not present");
		}
		
		
		
	}
	
	

}
