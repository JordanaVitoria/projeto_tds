package org.iftm.tds.repositories;
 
 import org.iftm.tds.entities.Client;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;
 
 
 @Repository
 public interface ClientRepository extends JpaRepository<Client, Long>{
  

 }