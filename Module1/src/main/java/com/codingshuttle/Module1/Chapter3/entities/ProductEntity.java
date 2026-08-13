package com.codingshuttle.Module1.Chapter3.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "product",
        indexes = {@Index(name = "idx_category", columnList = "product_category")}
    )
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_serial_code", nullable = false, unique = true)
    private String productSerialCode;

    @Column(name = "product_category", nullable = false)
    private String productCategory;

    @Column(name = "price", nullable = false)
    private Double productPrice;

    @Column(name = "quantity", nullable = false)
    private Integer productStock;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productCreateDate;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productUpdateDate;
}
