package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.PartnerFileLocalDataSource;
import com.dgd.huellas.domain.models.Partner;

public class AddPartnerUseCase {
    private PartnerFileLocalDataSource dataSource = PartnerFileLocalDataSource.getInstance();

    public void execute(Partner partner) {
        dataSource.save(partner);
    }
}
