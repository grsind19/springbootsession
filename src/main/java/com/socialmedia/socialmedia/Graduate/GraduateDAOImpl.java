package com.socialmedia.socialmedia.Graduate;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GraduateDAOImpl implements GraduateDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Graduate save(Graduate graduate, Passport passport) {
        entityManager.persist(passport);
        graduate.setPassport(passport);
        entityManager.persist(graduate);
        return graduate;
    }

    @Override
    public Graduate findById(int id) {
        return entityManager.find(Graduate.class, id);
    }

    public Passport findpassById(int passportId) {
        return entityManager.find(Passport.class, passportId);
    }

    public List<Graduate> find(){
        return entityManager.createQuery("from Graduate").getResultList();
    }
}
