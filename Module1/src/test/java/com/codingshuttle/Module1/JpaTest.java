//package com.codingshuttle.Module1;
//
//import com.codingshuttle.Module1.Chapter3.dto.Cdto;
//import com.codingshuttle.Module1.Chapter3.dto.Idto;
//import com.codingshuttle.Module1.Chapter3.dto.PCategoryDTO;
//import com.codingshuttle.Module1.Chapter3.entities.ProductEntity;
//import com.codingshuttle.Module1.Chapter3.repositories.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class JpaTest {
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void createRepositoryTest(){
//        ProductEntity createProduct=ProductEntity.builder()
//                .productName("Apple MacBook M3")
//                .productSerialCode("SN-2026-Z890")
//                .productCategory("Electronics")
//                .productPrice(89999.00)
//                .productStock(50)
//                .build();
//
//        ProductEntity savedProduct=productRepository.save(createProduct);
//        System.out.println(savedProduct);
//    }
//
//    @Test
//    void deleteByIdTest(){
//        productRepository.deleteById(6L);
//        System.out.println("Delete by id successfully");
//    }
//
//    @Test
//    void getAllTest(){
//        List<ProductEntity> list=productRepository.findAll();
//        for(ProductEntity p: list){
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    void getByTitleTest(){
//        List<ProductEntity> list=productRepository.findByProductCategory("Electronics");
//        for(ProductEntity p: list){
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    void getBySerialCodetest(){
//        List<ProductEntity> list=productRepository.findByProductSerialCode("SN-2026-E505");
//        for(ProductEntity p: list){
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    void getByNameAndCategoryTest(){
//        List<ProductEntity> list=productRepository.findByProductNameAndProductCategory("Ergonomic Mesh Chair v2","SN-2026-C412");
//        for(ProductEntity p: list){
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    void getAllInfoTest(){
//        List<Idto> patients=productRepository.getAllInfo();
//        for(Idto p: patients){
//            System.out.println("Id: "+p.getId());
//            System.out.println("Id: "+p.getName());
//            System.out.println("Id: "+p.getSerialCode());
//            System.out.println("-----------------------------------");
//        }
//    }
//
//    @Test
//    void getAllInfoTest2(){
//        List<Cdto> patients=productRepository.getAllInfoClass();
//        for(Cdto p: patients){
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    void getInfoProductCategoryTest(){
//        List<PCategoryDTO> patients=productRepository.getAllInfoByCategory();
//        for(PCategoryDTO p: patients){
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    void updateFieldTest(){
//        int rowsAffected=productRepository.rowAffected("Victor Von Doom", 2L);
//        System.out.println(rowsAffected);
//    }
//}
