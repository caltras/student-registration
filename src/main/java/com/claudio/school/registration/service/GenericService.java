package com.claudio.school.registration.service;

import java.util.Optional;

import com.claudio.school.registration.exception.NotFoundData;

import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<T, R extends JpaRepository<T,Long>> {

    protected R repository;

    public T save(T newObj) { 
        T st = this.repository.save(newObj);
        return st;
    }

    public T update(Long id, T object) throws NotFoundData {
        Optional<T> obj = this.repository.findById(id);
        if (obj.isPresent()){
            return this.repository.save(object);
        } else {
            throw new NotFoundData("Element not found on DB.");
        }
    }

    public boolean delete(Long id) {
        Optional<T> st = this.repository.findById(id);
        if (st.isPresent()) {
            this.repository.delete(st.get());
            return true;
        } 
        return false;
    }

    public T get(Long id) throws NotFoundData {
        Optional<T> obj = this.repository.findById(id);
        if (obj.isPresent()){
            return obj.get();
        } else {
            throw new NotFoundData("Element not found on DB.");
        }
    }
    
}
