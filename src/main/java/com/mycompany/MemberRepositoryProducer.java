package com.mycompany;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * This class uses CDI to produce EntityManager instances qualified that are
 * qualified as @MemberRepository. Therefore, to inject an instance, @Inject
 * must be followed by @MemberRepository.
 */
public class MemberRepositoryProducer
{
   @SuppressWarnings("unused") // tell IDE to ignore warnings about em not being used
   @Produces
   @MemberRepository
   @PersistenceContext
   private EntityManager em;
}
