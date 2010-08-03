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
   // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced directly
   @SuppressWarnings("unused")
   @Produces
   @MemberRepository
   @PersistenceContext
   private EntityManager em;
}
