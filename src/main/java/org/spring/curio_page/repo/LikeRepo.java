package org.spring.curio_page.repo;

import org.spring.curio_page.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like,Integer> {
}
