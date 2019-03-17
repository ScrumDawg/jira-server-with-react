package de.mola.jira.spielwiese.repository;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import net.java.ao.Entity;
import net.java.ao.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Repository
public abstract class AORepository<T extends Entity> {

    @ComponentImport
    private final ActiveObjects ao;

    private final Class<T> entityType;

    @Autowired
    public AORepository(ActiveObjects ao) {
        this.entityType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AORepository.class);
        this.ao = ao;
    }

    public Optional<T> getByID(Integer id){
        T byID = null;
        T[] foundById = ao.find(entityType, Query.select().where("ID = %s", String.valueOf(id)));
        if(foundById.length > 0)
            byID = foundById[0];

        return Optional.ofNullable(byID);
    }

    public List<T> getAll(){
        return new ArrayList<>(Arrays.asList(ao.find(entityType)));
    }
}
