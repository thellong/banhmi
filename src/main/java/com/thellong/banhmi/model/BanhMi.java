package com.thellong.banhmi.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BanhMi {
    @NotNull
    @Size(min = 5, message = "Tên ngắn quá")
    private String name;

    @Size(min = 1, message = "Không bán bánh mì kiểu lày đâu nha :D")
    private List<String> ingredients;
}
