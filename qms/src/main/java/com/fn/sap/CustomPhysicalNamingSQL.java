package com.fn.sap;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNamingSQL extends PhysicalNamingStrategyStandardImpl {
//    @Override
//    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
//        final String tableName = name.getText();
//        if (tableName.startsWith("@")) return Identifier.toIdentifier("[" + tableName + "]");
//        return super.toPhysicalTableName(name, context);
//    }
}
