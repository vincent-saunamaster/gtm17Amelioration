package service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import dao.IDao;
import interceptor.Audited;
import interceptor.Interceptor2annotation;
import interceptor.Timed;


@Audited
@Interceptor2annotation
@Timed

public class ServiceImp implements Iservice {
	@Inject
	private IDao dao;
	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		
		
		return dao.appelDao();
	}
	@PostConstruct
	public void logApresConstruction(){
		System.out.println("Après création dao");
	}
	
	@PreDestroy
	public void logApresDestruction(){
		System.out.println("avant destruction dao");
	}

}
