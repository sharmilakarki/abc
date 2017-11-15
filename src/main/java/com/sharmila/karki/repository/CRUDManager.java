package com.sharmila.karki.repository;

import java.io.Serializable;
import java.util.List;



public interface CRUDManager<T extends Serializable,Pk extends Serializable>{

	public T getById(String id);
	public T addNew(T t);
	public T update(T t);
	public List<T> getAll();
	public void remove(String id);
}
