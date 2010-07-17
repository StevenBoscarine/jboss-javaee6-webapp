package com.mycompany;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * This class uses CDI to produce @MemberRepository EntityManagers.
 */
public class MemberRepositoryProducer
{
   @Produces
   @MemberRepository
   @PersistenceContext
   private EntityManager em;
}
