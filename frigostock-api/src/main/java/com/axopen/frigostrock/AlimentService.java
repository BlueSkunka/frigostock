package com.axopen.frigostrock;


import com.axopen.frigostrock.model.tables.pojos.Aliment;
import com.axopen.frigostrock.model.tables.records.AlimentRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.UpdateResultStep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.axopen.frigostrock.model.Tables.ALIMENT;

@Service
public class AlimentService {

    private final DSLContext dslContext;

    public AlimentService(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Aliment> getAliment() {
        return dslContext.select(ALIMENT.fields())
                .from(ALIMENT)
                .fetchInto(Aliment.class);
    }

    public Aliment createAliment(String name, String type) {
        AlimentRecord aliment = dslContext.newRecord(ALIMENT);
        aliment.setName(name);
        aliment.setType(type);
        aliment.insert();

        return aliment.into(Aliment.class);
    }

    public Boolean deleteAliment(Integer id) throws Exception {
        int deleted = dslContext.delete(ALIMENT)
                .where(ALIMENT.ID.eq(id))
                .execute();

        return deleted != 0;

    }

    public Boolean modifyAliment(Integer id, String name, String type) {

            Integer count = dslContext.update(ALIMENT)
                    .set(ALIMENT.NAME, name)
                    .set(ALIMENT.TYPE, type)
                    .where(ALIMENT.ID.eq(id))
                    .returningResult(ALIMENT.ID)
                    .fetchOne().getValue(ALIMENT.ID);

            return count != null;

    }
}
