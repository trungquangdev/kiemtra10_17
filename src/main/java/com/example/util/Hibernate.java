package com.example.util;

import com.example.entity.LoaiPhieuGiamGia;
import com.example.entity.PhieuGiamGia;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class Hibernate {
    //Remember change name database and config entity
    private static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration();
         configuration.addAnnotatedClass(LoaiPhieuGiamGia.class);
         configuration.addAnnotatedClass(PhieuGiamGia.class);

        Properties properties = new Properties();
        properties.put(
                Environment.DIALECT,
                "org.hibernate.dialect.SQLServer2016Dialect"
        );
        properties.put(
                Environment.DRIVER,
                "com.microsoft.sqlserver.jdbc.SQLServerDriver"
        );
        properties.put(
                Environment.URL,
                "jdbc:sqlserver://localhost:1433;"
                        + "databaseName=PTPM_FINALLY_SOF3012;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
        );
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");
        configuration.setProperties(properties);
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
        FACTORY = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFactory());
    }
}

