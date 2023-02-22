package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.PartnerFileLocalDataSource;
import com.dgd.huellas.domain.models.Partner;

public class GetPartnerUseCase {
    private PartnerFileLocalDataSource dataSource = PartnerFileLocalDataSource.getInstance();

    public Partner execute(Integer id){
        return dataSource.findById(id);
    }
}
