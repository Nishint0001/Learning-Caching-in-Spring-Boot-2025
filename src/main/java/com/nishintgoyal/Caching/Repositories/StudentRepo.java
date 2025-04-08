package com.nishintgoyal.Caching.Repositories;

import com.nishintgoyal.Caching.Entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>
{

}
