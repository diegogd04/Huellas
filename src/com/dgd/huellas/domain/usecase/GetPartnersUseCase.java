package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.PartnerFileLocalDataSource;
import com.dgd.huellas.domain.models.Partner;

import java.util.List;

public class GetPartnersUseCase {
    private PartnerFileLocalDataSource dataSource = PartnerFileLocalDataSource.getInstance();

    public List<Partner> execute() {
        return dataSource.findAll();
    }
}
