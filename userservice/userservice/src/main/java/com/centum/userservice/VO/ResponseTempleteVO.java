package com.centum.userservice.VO;


import com.centum.userservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTempleteVO {
    private User user ;
    private MonthlySavings monthlysavings;

}
