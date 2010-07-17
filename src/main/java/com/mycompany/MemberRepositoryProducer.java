package com.mycompany;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * This class uses CDI to produce @MemberRepository EntityManagers.
 */
public class MemberRepositoryProducer
{
   @SuppressWarnings("unused")   //tell IDE to ignore warnings about em not being used.  
   @Produces
   @MemberRepository
   @PersistenceContext
   private EntityManager em;
}
