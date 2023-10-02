package com.henrique.imdb.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;
import java.util.UUID;

public class PrefixIdGenerator implements IdentifierGenerator{

    private String prefix;

    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) {
        this.prefix = parameters.getProperty("prefix");
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException{
        return prefix + "_" + UUID.randomUUID().toString();
    }
}
