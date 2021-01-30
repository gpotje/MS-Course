package com.gpotdesevo.hriusers.repositorie;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gpotdesevo.hriusers.entities.Users;

public interface usersRepository extends JpaRepository<Users,Long>{

	Users findByEmail(String email);
}
