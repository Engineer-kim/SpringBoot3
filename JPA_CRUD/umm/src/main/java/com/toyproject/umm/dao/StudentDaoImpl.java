package com.toyproject.umm.dao;

import com.toyproject.umm.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    //해당 메소드가 종료될 때 트랜잭션이 커밋되면서 자동으로 flush가 발생합니다.
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        //merge()는 준영속 상태의 엔티티를 영속성 컨텍스트에 다시 통합/
        //준영속 상태 :엔티티는 메모리에서 존재하지만,
        // 영속성 컨텍스트와의 연결이 끊어졌기 때문에 merge() 메소드를 사용해야 변경 사항을 DB에 반영할 수 있음
        // DB에는 존재 JPA가 관리안함 그렇기에 더티채킹을 자동으로 하지않음(트랜잭션의 영향을 받지 않음)
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
