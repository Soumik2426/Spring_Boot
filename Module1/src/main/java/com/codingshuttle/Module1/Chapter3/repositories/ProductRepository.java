package com.codingshuttle.Module1.Chapter3.repositories;

import com.codingshuttle.Module1.Chapter3.dto.Cdto;
import com.codingshuttle.Module1.Chapter3.dto.Idto;
import com.codingshuttle.Module1.Chapter3.dto.PCategoryDTO;
import com.codingshuttle.Module1.Chapter3.entities.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("Select e.id as id, e.productName as name, e.productSerialCode as serialCode from ProductEntity e")
    List<Idto> getAllInfo();

    @Query("Select new com.codingshuttle.Module1.Chapter3.dto.Cdto (e.id, e.productName, e.productSerialCode) from ProductEntity e")
    List<Cdto> getAllInfoClass();

    @Query("Select new com.codingshuttle.Module1.Chapter3.dto.PCategoryDTO (e.productCategory, count(e)) FROM ProductEntity e GROUP BY e.productCategory ORDER BY count(e)")
    List<PCategoryDTO> getAllInfoByCategory();

    @Query("Select e from ProductEntity e where e.productName=?1 and e.productCategory=?2")
    List<ProductEntity> findByProductNameAndProductCategory(String name, String category);

    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity e SET e.productName=?1 WHERE e.id=?2")
    int rowAffected(@Param("name")String name, @Param("id") Long id);

    List<ProductEntity> findByProductCategory(String category);

    List<ProductEntity> findByProductSerialCode(String serialCode);

    List<ProductEntity> findByProductCategory(String title, Pageable pageable);
}
