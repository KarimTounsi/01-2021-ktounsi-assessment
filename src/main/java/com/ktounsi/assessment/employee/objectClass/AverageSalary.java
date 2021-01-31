package com.ktounsi.assessment.employee.objectClass;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.transaction.Transactional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class AverageSalary {

    private String positionName;
    private Integer avgSalary;
    private Integer years;

}
