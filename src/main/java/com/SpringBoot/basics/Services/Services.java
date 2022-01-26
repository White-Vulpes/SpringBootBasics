package com.SpringBoot.basics.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.basics.Loads.Loads;
import com.SpringBoot.basics.LoadsDao.loadsDao;

@Service
public class Services{

	@Autowired
	loadsDao dao;
	
	public String addData(Loads load) {
		dao.save(load);
		return "Loads Data Added Successfuly";
	}
	
	public String delete(String Id) {
		dao.deleteById(Id);
		return "Data Deleted";
	}
	
	public List<Loads> getAll(){
		return dao.findAll();
	}
	
	public Loads getWithId(String Id) {
		Optional<Loads> l = dao.findById(Id);
		if(l.isEmpty() != true) {
			return l.get();
		}
		else {
			Loads load = new Loads();
			load.setComment("Not Found Exception");
			return load;
		}
	}
	
	public String editLoad(Loads load) {
		dao.save(load);
		return "Data Saved";
	}
}
