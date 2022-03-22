package com.checkpoint4.jcollection.repository;

import com.checkpoint4.jcollection.entity.Media;
import com.checkpoint4.jcollection.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
 List<Media> findMediaByType(Type type);
}
