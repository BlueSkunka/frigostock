package com.axopen.frigostrock;


import com.axopen.frigostrock.model.Tables;
import com.axopen.frigostrock.model.tables.pojos.Aliment;
import com.axopen.frigostrock.model.tables.records.AlimentRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Aliment createAliment(String name, Integer price) {
        AlimentRecord aliment = dslContext.newRecord(ALIMENT);
        aliment.setName(name);
        aliment.setPrice(price);
        aliment.insert();

        return aliment.into(Aliment.class);
    }

    public void deleteAliment(Integer id) {
        dslContext.delete(ALIMENT)
                .where(ALIMENT.ID.eq(id))
                .execute();
    }

    public Aliment modifyAliment(Integer id) {
        AlimentRecord aliment = dslContext.newRecord(ALIMENT);
        aliment.setName("name");
        aliment.setPrice(100);
        aliment.insert();

        return aliment.into(Aliment.class);
    }

}
