package com.thellong.banhmi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Thêm cái tên đê bạn êy")
    private String name;

    @NotBlank(message = "Tên đường đi bạn")
    private String street;

    @NotBlank(message = "Thêm tên thành phố cho nó dễ tìm bạn")
    private String city;

    @NotBlank(message = "Cái này không được để trống bạn ơi")
    private String state;

    @NotBlank(message = "Cái này cũng không được để trống")
    private String zip;

    @CreditCardNumber(message = "Tên thẻ không hợp lệ")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Định dạng như này này MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Số CVV không hợp lệ")
    private String ccCVV;

    private Date placedAt;

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
