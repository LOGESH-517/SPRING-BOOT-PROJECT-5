package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.respository.BookRepo;

@Service
public class ApiService {
@Autowired 
BookRepo er;
public List<Book> saveninfo(List<Book> ee)
{
	return (List<Book>)er.saveAll(ee);
}
public List<Book> showinfo()
{
	return er.findAll();
}
public Book getStudentById(int id)
{
	Optional<Book> studentOptional=er.findById(id);
	return studentOptional.orElse(null);
}
public String updateinfobyid(int id,Book ee)
{
	if(er.existsById(id))
	{
		er.saveAndFlush(ee);
		return "Updated";
	}
	else
	{
		return "Enter valid id";
	}
}
public void deleteid(int id)
{
	er.deleteById(id);
}
}
